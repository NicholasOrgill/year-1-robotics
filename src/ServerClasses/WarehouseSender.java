package ServerClasses;

import java.io.IOException;

public class WarehouseSender extends Thread {
    private final Connection connection;

    public WarehouseSender(Connection connection) {
        this.connection = connection;
    }

    public void run() {
        for (;;) {
            String msg;
            try {
                msg = connection.getSendingQueue().take();
            } catch (InterruptedException e) {
                // We've been interrupted, break cleanly out.
                break;
            }
            synchronized (Connection.getM_lock()) {
                try {
                    connection.getM_dos().writeChars(msg);
                    connection.getM_dos().flush();
                } catch (IOException e) {
                    // We've been interrupted, break cleanly out.
                    break;
                }
            }
        }
    }
}
