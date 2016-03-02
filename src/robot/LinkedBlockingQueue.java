package robot;

import java.util.LinkedList;

/**
 * A blocking queue implemented using a linked list.
 */
public class LinkedBlockingQueue<E> implements BlockingQueue<E> {
    private final LinkedList<E> list = new LinkedList<>();

    @Override
    public void add(E e) {
        synchronized (this.list) {
            this.list.add(e);
            this.list.notifyAll();
        }
    }

    @Override
    public E take() throws InterruptedException {

        synchronized (this.list) {
            while (this.list.isEmpty()) {
                this.list.wait();
            }

            return this.list.remove(0);
        }
    }
}
