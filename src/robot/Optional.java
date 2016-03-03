package robot;

import java.util.NoSuchElementException;

/**
 * A container which may or may not contain a value. If a value is present, it
 * shall be non-null.
 */
public final class Optional<T> {

	/**
	 * Returns a new Optional object containing the given non-null value.
	 *
	 * @throws NullPointerException
	 *             if val is null
	 */
	public static <T> Optional<T> of(T val) {
		return new Optional<>(val);
	}

	/**
	 * Returns an empty Optional object.
	 *
	 * @return an empty Optional
	 */
	public static <T> Optional<T> empty() {
		return new Optional<>();
	}

	private final T val;

	private Optional() {
		this.val = null;
	}

	private Optional(T val) {
		if (val == null) {
			throw new NullPointerException();
		}

		this.val = val;
	}

	/**
	 * Returns the value contained in this Optional. If this Optional is empty,
	 * throws NoSuchElementException.
	 *
	 * @return the value contained in this Optional
	 * @throws NoSuchElementException
	 *             if no value is present
	 */
	public T get() {
		if (this.val == null) {
			throw new NoSuchElementException();
		}

		return this.val;
	}

	/**
	 * Returns true if there is a value present, otherwise false.
	 *
	 * @return true if there is a value present, otherwise false
	 */
	public boolean isPresent() {
		return this.val != null;
	}
}
