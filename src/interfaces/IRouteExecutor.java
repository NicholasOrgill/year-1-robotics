package interfaces;

public interface IRouteExecutor {

	/**
	 * Get the delay for the executor
	 * 
	 * @return The executor delay
	 */
	public int getDelay();

	/**
	 * Set the delay for the executor
	 * 
	 * @param _delay
	 *            The new delay
	 */
	public void setDelay(int _delay);

	/**
	 * 
	 * @param _msg
	 * @return
	 */
	public IMessage returnMessage(IMessage _msg);

}
