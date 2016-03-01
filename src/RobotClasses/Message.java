package RobotClasses;

import interfaces.IMessage;

import java.io.Serializable;


public class Message implements IMessage, Serializable {
    // Looks like all we really have to do to serialize an object is implement Serializable!
    private final String header;
    private final String content;

    public Message(String header, String content) {
        this.header = header;
        this.content = content;
    }
}
