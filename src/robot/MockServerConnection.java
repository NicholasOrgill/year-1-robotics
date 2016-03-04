package robot;

import java.util.LinkedList;

public class MockServerConnection implements ServerConnection {
    private final LinkedList<Move> moves = new LinkedList<>();

    public MockServerConnection() {
        moves.add(Move.forward(1));
        moves.add(Move.turnAround());
        moves.add(Move.forward(3));
        moves.add(Move.turnLeft());
    }

    @Override
    public Move getNextMove() {
        return moves.remove(0);
    }

    @Override
    public void confirmMove() {

    }
}
