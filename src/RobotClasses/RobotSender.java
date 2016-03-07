package RobotClasses;


import java.io.IOException;

public class RobotSender extends Thread {

    private final Connection connection;
    private boolean run;


    public RobotSender(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void run() {
        Message msg = null;
        while (run) {
            try {
                msg = connection.getSendingQueue().take();
            } catch (InterruptedException e) {
                break;
            }

            synchronized (Connection.getLock()) {
                try {
                    connection.getOutputStream().writeUTF(msg.toString());
                } catch (IOException e) {
                    break;
                }
            }
        }
    }

    public void stopListening() {
        interrupt();
    }
}
