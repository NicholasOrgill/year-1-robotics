package robot;

public interface ServerConnection {
    Move getNextMove();
    void confirmMove();
}
