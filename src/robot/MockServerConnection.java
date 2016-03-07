package robot;

import java.util.LinkedList;

import lejos.nxt.Button;
import lejos.util.Delay;

/**
 * A fake ServerConnection implementation.
 */
public class MockServerConnection implements ServerConnection {
    private final LinkedList<Move> moves = new LinkedList<>();

    public MockServerConnection() {
        moves.add(Move.forward(2));
        moves.add(Move.turnLeft());
        moves.add(Move.forward(6));
        moves.add(Move.turnLeft());
        moves.add(Move.forward(2));
        moves.add(Move.turnLeft());
        moves.add(Move.forward(6));
        moves.add(Move.turnLeft());
    }

    @Override
    public Move getNextMove() {
        if (moves.isEmpty()) {
            Button.waitForAnyPress();
            System.exit(0);
            return null;
        } else {
            return moves.remove(0);
        }
    }

    @Override
    public void confirmMove() {

    }
}
