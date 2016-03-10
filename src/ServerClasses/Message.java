package ServerClasses;

import interfaces.IMessage;
import interfaces.MessageHeader;


public class Message implements IMessage {
    private String body;
    private MessageHeader header;

    public Message(MessageHeader header, String body) {
        this.header = header;
        this.body = body;
    }

    @Override
    public MessageHeader getHeader() {
        return header;
    }

    /**
     * Set the message header
     *
     * @param _header The message header
     */
    @Override
    public void setHeader(MessageHeader _header) {
        this.header = _header;
    }

    @Override
    public String getContent() {
        return body;
    }

    /**
     * Set the message content
     *
     * @param _content The new message content
     */
    @Override
    public void setContent(String _content) {
        this.body = _content;
    }
}
