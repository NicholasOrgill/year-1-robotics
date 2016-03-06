package RobotClasses;


import interfaces.IMessage;

import java.io.IOException;

import static interfaces.IMessage.fromString;

public class RobotReceiver extends Thread {
    private final Connection connection;
    private boolean run;

    public RobotReceiver(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void run() {
        while (run) {
            // Todo: Notify observers of each message
            try {
                String msg = connection.getInputStream().readUTF();
                IMessage m = fromString(msg);
                connection.notifyObservers(m);
            } catch (IOException e) {
                break;
            }
        }
    }

    public void stopListening() {
        run = false;
    }
}
