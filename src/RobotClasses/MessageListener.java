package RobotClasses;

import java.util.Observable;

/**
 * Created by bxk56_000 on 01/03/2016.
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
