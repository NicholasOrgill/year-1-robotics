package interfaces;

public interface IMessage<Content> {
	/**
	 * Get the message header
	 * 
	 * @return the message header
	 */
	public MessageHeader getHeader();

	/**
	 * Set the message header
	 * 
	 * @param _header
	 *            The message header
	 */
	public void setHeader(MessageHeader _header);

	/**
	 * Get the message content
	 * 
	 * @return The message content
	 */
	public String getContent();

	/**
	 * Set the message content
	 * 
	 * @param _content
	 *            The new message content
	 */
	public void setContent(String _content);

}
