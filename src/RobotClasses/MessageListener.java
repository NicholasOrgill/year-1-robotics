package RobotClasses;

import java.util.Observable;

/**
 * Create an observable interface to allow the robot to
 * take actions on every new message.
 *
 * We'll send the message in our call to notifyObservers.
 */
public class MessageListener extends Observable{
    private MessageQueue queue;

    public MessageListener() {
        queue = new MessageQueue();
        Thread t = new MessageListenerThread(queue, this);
        t.start();
    }

    public void gotMessage() throws InterruptedException {
        setChanged();
        notifyObservers(queue.take());
    }
}
