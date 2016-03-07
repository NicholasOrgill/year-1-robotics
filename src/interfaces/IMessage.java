package interfaces;

import ServerClasses.Message;

public interface IMessage {

	/**
	 * Create a message by splitting a string into two parts.
	 * @param msg The initial string.
	 * @return The message created.
     */
    public static IMessage fromString(String msg) {
        // Todo: Split message into header and body from string.
        return new Message("HEADER", msg);
    }

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
