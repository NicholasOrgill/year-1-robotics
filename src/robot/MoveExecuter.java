package robot;

import lejos.nxt.LightSensor;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.util.Delay;

/**
 * A Runnable class that receives moves from the server and executes them on the
 * robot.
 */
public class MoveExecuter implements Runnable {

    /** Noise of the light sensor (determined through testing). */
    private static final int SENSOR_NOISE = 1;

    /**
     * Difference between light and dark readings (determined through testing).
     */
    private static final int LIGHT_DIFF = 5;

    /**
     * Compares the two given readings, taking sensor noise into account.
     */
    private static int compareReadings(int r1, int r2) {
        if ((r2 - SENSOR_NOISE) - (r1 + SENSOR_NOISE) > LIGHT_DIFF) {
            return -1;
        } else if ((r1 - SENSOR_NOISE) - (r2 + SENSOR_NOISE) > LIGHT_DIFF) {
            return 1;
        } else {
            return 0;
        }
    }

    private final LightSensor left;
    private final LightSensor right;
    private final DifferentialPilot pilot;
    private final ServerConnection server;

    private Optional<Integer> leftLight = Optional.empty();
    private Optional<Integer> rightLight = Optional.empty();
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

        this.pilot.setTravelSpeed(200);
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
                this.pilot.rotate(90);
                break;

            case TURN_RIGHT:
                this.pilot.rotate(-90);
                break;

            case TURN_AROUND:
                this.pilot.rotate(180);
                break;
            }

            server.confirmMove();
        }
    }

    /**
     * Returns true if the left sensor detects a grid line, false otherwise.
     */
    private boolean isNextLeftReadingDark() {
        final int reading = this.left.readValue();
        final int result = compareReadings(reading, this.leftPrevious);

        final boolean ret;
        if (result < 0) {
            // Reading is dark
            this.leftLight = Optional.of(this.leftPrevious);
            ret = true;

        } else if (result == 0) {
            // Readings are equal
            if (this.leftLight.isPresent()) {
                final int result2 = compareReadings(reading,
                        this.leftLight.get());

                ret = result2 < 0;

            } else {
                // If we can't tell, assume the reading is light:
                ret = false;
            }

        } else {
            // Reading is light
            this.leftLight = Optional.of(reading);
            ret = false;
        }

        this.leftPrevious = reading;
        return ret;
    }

    /**
     * Returns true if the right sensor detects a grid line, false otherwise.
     */
    private boolean isNextRightReadingDark() {
        final int reading = this.right.readValue();
        final int result = compareReadings(reading, this.rightPrevious);

        final boolean ret;
        if (result < 0) {
            // Reading is dark
            this.rightLight = Optional.of(this.rightPrevious);
            ret = true;

        } else if (result == 0) {
            // Readings are equal
            if (this.rightLight.isPresent()) {
                final int result2 = compareReadings(reading,
                        this.rightLight.get());

                ret = result2 < 0;

            } else {
                // If we can't tell, assume the reading is light:
                ret = false;
            }

        } else {
            // Reading is light
            this.rightLight = Optional.of(reading);
            ret = false;
        }

        this.rightPrevious = reading;
        return ret;
    }

    /**
     * Moves the robot forward the specified number of units (grid tiles).
     */
    private void moveForward(int units) {

        int passed = 0;

        while (passed < units) {
            final boolean left = this.isNextLeftReadingDark();
            final boolean right = this.isNextRightReadingDark();

            if (left && right) {
                // Going over a junction

                // Prevent `passed` from being incremented more than once per
                // junction:
                this.pilot.forward();
                passed++;

                System.out.println("Sleeping...");
                Delay.msDelay(250);
                System.out.println("Woke up.");

            } else if (left) {
                this.pilot.arcForward(600);
            } else if (right) {
                this.pilot.arcForward(-600);
            } else {
                this.pilot.forward();
            }

            Delay.msDelay(20);
        }

        this.pilot.stop();
    }
}
