package ServerClasses;

import interfaces.IMessage;


public class Message implements IMessage {
    private final String body;
    private final String header;

    public Message(String header, String body) {
        this.header = header;
        this.body = body;
    }

    @Override
    public String getHeader() {
        return header;
    }

    @Override
    public String getBody() {
        return body;
    }
}
