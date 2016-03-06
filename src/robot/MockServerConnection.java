package robot;


import java.util.LinkedList;

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
    }

    @Override
    public Move getNextMove() {
        return moves.remove(0);
    }

    @Override
    public void confirmMove() {

    }
}
