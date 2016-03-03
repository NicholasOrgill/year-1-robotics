package robot;

/**
 * Represents a connection to the server.
 */
public interface ServerConnection {

    /**
     * Get the next move sent from the server. If no moves are available, this
     * method blocks until a move is available.
     *
     * @return the next move to execute on this robot
     */
    Move getNextMove();

    /**
     * Sends a confirmation message to the server signalling that the previous
     * move was successful.
     */
    void confirmMove();
}
