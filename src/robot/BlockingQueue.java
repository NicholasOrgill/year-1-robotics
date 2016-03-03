package robot;

/**
 * A queue that supports operations that wait for the queue to become non-empty
 * when retrieving an element. Implementing classes should make all methods
 * thread-safe.
 */
public interface BlockingQueue<E> {

	/**
	 * Adds the given element on to the end of the queue.
	 *
	 * @param e
	 *            the element to add
	 */
	void add(E e);

	/**
	 * Retrieves and removes the element at the front of the queue. If the queue
	 * is non-empty, this method waits until an element becomes available.
	 *
	 * @return the element at the front of the queue
	 * @throws InterruptedException
	 *             if interrupted while waiting
	 */
	E take() throws InterruptedException;
}
