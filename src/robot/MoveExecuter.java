package robot;

import lejos.nxt.LightSensor;
import lejos.robotics.navigation.DifferentialPilot;

public class MoveExecuter implements Runnable {
    private final LightSensor left;
    private final LightSensor right;
    private final DifferentialPilot pilot;
    private final BlockingQueue<Move> moves = new LinkedBlockingQueue<>();

    public MoveExecuter(
            DifferentialPilot pilot,
            LightSensor left,
            LightSensor right)
    {
        this.pilot = pilot;
        this.left = left;
        this.right = right;
    }

    @Override
    public void run() {

        pilot.forward();

        while (true) {
            final Move move = this.moves.take();

            /*
            int lefty = left.readValue();
            int righty = right.readValue();

            if (lefty < 33) {
                pilot.rotate(5, true); // different comparisons for each sensor
                                       // as they are calibrated differently
            } else if (righty < 35) {
                pilot.rotate(-5, true);
            }
            */
        }
    }

    public void pushMove(Move move) {
        this.moves.add(move);
    }
}
