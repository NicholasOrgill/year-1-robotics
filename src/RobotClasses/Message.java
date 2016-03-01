package RobotClasses;

import interfaces.IMessage;

import java.io.Serializable;


public class Message implements IMessage, Serializable {
    private final String header;
    private final String content;

    public Message(String header, String content) {
        this.header = header;
        this.content = content;
    }
}
