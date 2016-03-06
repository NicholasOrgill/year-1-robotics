package ServerClasses;

import java.io.IOException;
import java.util.Arrays;

public class WarehouseReceiver extends Thread {
    private final Connection connection;

    public WarehouseReceiver(Connection connection) {
        this.connection = connection;
    }

    public void run() {
        String msg;
        for (;;) {
            try {
                synchronized (Connection.getM_lock()) {
                    msg = connection.getM_dis().readUTF();
                }
                connection.getReceivedQueue().add(msg);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

