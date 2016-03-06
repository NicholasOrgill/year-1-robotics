package robot;

/**
 * A class that can measure the passing of real time.
 */
public class Timer {
    private Optional<Long> until = Optional.empty();

    /**
     * Constructs a stopped Timer.
     */
    public Timer() {
    }

    /**
     * Sets the timer to run for the given number of seconds.
     *
     * @param s
     *            the (possibly fractional) number of seconds to run for
     */
    public void runFor(double s) {
        final long ms = (long) (s * 1000);
        this.until = Optional.of(System.currentTimeMillis() + ms);
    }

    /**
     * Returns true if this Timer is currently running, false otherwise.
     */
    public boolean isRunning() {
        return this.until.isPresent()
                && this.until.get() > System.currentTimeMillis();
    }
}
