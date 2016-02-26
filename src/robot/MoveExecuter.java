package robot;

public class MoveExecuter implements Runnable {
    private final BlockingQueue<Move> moves = new BlockingQueue<>();

    @Override
    public void run() {
        while (true) {
            final Move move = this.moves.take();
            // Execute the move
        }
    }

    public void pushMove(Move move) {
        this.moves.add(move);
    }
}
