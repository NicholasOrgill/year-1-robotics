package RobotClasses;

/**
 * Implement a thread which listens for messages, adds them to a queue, and notifies
 * a callback object.
 */
public class MessageListenerThread extends Thread {
    private final MessageQueue queue;
    private final MessageListener callbackObject;

    public MessageListenerThread(MessageQueue queue, MessageListener messageListener) {
        this.queue = queue;
        this.callbackObject = messageListener;
    }

    public void run() {
        for (;;) {
            // Block while waiting for message (mocked here).
            Message message = new Message("Header", "Content");

            // Add message to our queue and repeat.
            queue.add(message);

            // Callback to our master object.
            try {
                callbackObject.gotMessage();
            } catch (InterruptedException e) {
                // Try to exit cleanly if we're interrupted.
                break;
            }
        }
    }
}
