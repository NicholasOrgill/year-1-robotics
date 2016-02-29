package robot;

import lejos.nxt.LightSensor;
import lejos.robotics.navigation.DifferentialPilot;

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
     * Moves the robot forward the specified number of units (grid tiles).
     */
    private void moveForward(int units) {
        this.pilot.forward();

        final Timer timer = new Timer();
        int passed = 0;
        boolean left = this.leftIsDark();
        boolean right = this.rightIsDark();

        while (passed < units) {

            if (left && right && !timer.isRunning()) {
                // Going over a new junction
                passed++;
                timer.runFor( /* time to pass 0.1m */ );

            } else if (left) {
                this.pilot.rotate(5);
            } else if (right) {
                this.pilot.rotate(-5);
            }

            left = this.leftIsDark();
            right = this.rightIsDark();
        }

        this.pilot.stop();
    }
}
