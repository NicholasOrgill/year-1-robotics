package interfaces;

import ServerClasses.Message;

public interface IMessage {
    public String getHeader();
    public String getBody();

    public static IMessage fromString(String msg) {
        // Todo: Split message into header and body from string.
        return new Message("HEADER", msg);
    }
}
