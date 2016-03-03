package robot;

import lejos.nxt.LightSensor;
import lejos.robotics.navigation.DifferentialPilot;

/**
 * A Runnable class that receives moves from the server and executes them on the
 * robot.
 */
public class MoveExecuter implements Runnable {

    private static final int SENSOR_NOISE = 3;
    // Determined through testing

    private final LightSensor left;
    private final LightSensor right;
    private final DifferentialPilot pilot;
    private final ServerConnection server;

    private int leftPrevious;
    private int rightPrevious;

    public MoveExecuter(ServerConnection server, DifferentialPilot pilot,
            LightSensor left, LightSensor right) {
        this.server = server;
        this.pilot = pilot;
        this.left = left;
        this.right = right;

        this.leftPrevious = left.readValue();
        this.rightPrevious = right.readValue();
    }

    @Override
    public void run() {

        while (true) {
            final Move move = server.getNextMove();

            switch (move.type) {
            case MOVE_FORWARD:
                this.moveForward(move.getUnits());
                break;

            case TURN_LEFT:
                this.pilot.rotate(-90);
                break;

            case TURN_RIGHT:
                this.pilot.rotate(90);
                break;

            case TURN_AROUND:
                this.pilot.rotate(180);
                break;
            }

            server.confirmMove();
        }
    }

    /**
     * Returns a negative integer if r1 is dark compared to r2. Returns 0 if r1
     * is considered equal to r2. Returns a positive integer if r1 is light
     * compared to r2.
     */
    private int compareReadings(int r1, int r2) {

        // Difference between light and dark as a multiple of the noise
        // (determined through testing)
        final int diff = SENSOR_NOISE * 2;

        if (r1 + diff < r2 - diff) {
            return -1;
        } else if (r1 - diff > r2 + diff) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * Returns true if the left sensor detects a grid line, false otherwise.
     */
    private boolean isNextLeftReadingDark() {
        final int reading = this.left.readValue();

        final boolean result = this.compareReadings(reading,
                this.leftPrevious) < 0;

        this.leftPrevious = reading;
        return result;
    }

    /**
     * Returns true if the right sensor detects a grid line, false otherwise.
     */
    private boolean isNextRightReadingDark() {
        final int reading = this.right.readValue();

        final boolean result = this.compareReadings(reading,
                this.rightPrevious) < 0;

        this.rightPrevious = reading;
        return result;
    }

    /**
     * Moves the robot forward the specified number of units (grid tiles).
     */
    private void moveForward(int units) {
        this.pilot.forward();

        final Timer timer = new Timer();
        int passed = 0;

        while (passed < units) {
            final boolean left = this.isNextLeftReadingDark();
            final boolean right = this.isNextRightReadingDark();

            if (left && right) {
                // Going over a junction

                // Prevent `passed` from being incremented more than once per
                // junction:
                if (!timer.isRunning()) {
                    passed++;
                    timer.runFor((1.0 / this.pilot.getTravelSpeed()) * 0.1);
                }
            } else if (left) {
                this.pilot.rotate(5);
            } else if (right) {
                this.pilot.rotate(-5);
            }

            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                // Never happens
                throw new RuntimeException("MoveExecuter interrupted");
            }
        }

        this.pilot.stop();
    }
}
