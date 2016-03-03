package robot;

import lejos.nxt.LightSensor;
import lejos.robotics.navigation.DifferentialPilot;

/**
 * A Runnable class that receives moves from the server and executes them on the
 * robot.
 */
public class MoveExecuter implements Runnable {
    private final LightSensor left;
    private final LightSensor right;
    private final DifferentialPilot pilot;
    private final ServerConnection server;

    public MoveExecuter(
            ServerConnection server,
            DifferentialPilot pilot,
            LightSensor left,
            LightSensor right)
    {
        this.server = server;
        this.pilot = pilot;
        this.left = left;
        this.right = right;
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
     * Returns true if the left sensor detects a grid line, false otherwise.
     */
    private boolean leftIsDark() {
    }

    /**
     * Returns true if the right sensor detects a grid line, false otherwise.
     */
    private boolean rightIsDark() {
    }

    /**
     * Moves the robot forward the specified number of units (grid tiles).
     */
    private void moveForward(int units) {
        this.pilot.forward();

        final Timer timer = new Timer();
        int passed = 0;

        while (passed < units) {
            final boolean left = this.leftIsDark();
            final boolean right = this.rightIsDark();

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
