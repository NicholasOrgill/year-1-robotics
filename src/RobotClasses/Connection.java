package RobotClasses;


import lejos.nxt.comm.BTConnection;
import lejos.nxt.comm.Bluetooth;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.Observable;
import java.util.concurrent.LinkedBlockingQueue;

public class Connection extends Observable {
    private final DataInputStream inputStream;
    private final DataOutputStream outputStream;
    private final RobotSender sender;
    private final RobotReceiver receiver;
    private BTConnection conn;
    private final static Object lock = new Object();
    private LinkedBlockingQueue<Message> sendingQueue;
    private LinkedBlockingQueue<Message> receivedQueue;


    public Connection() {
        sendingQueue = new LinkedBlockingQueue<>();
        receivedQueue = new LinkedBlockingQueue<>();

        System.out.println("Waiting for connection...");
        conn = Bluetooth.waitForConnection();
        System.out.println("Connection established!");

        // Open streams for communication.
        inputStream = conn.openDataInputStream();
        outputStream = conn.openDataOutputStream();

        sender = new RobotSender(this);
        receiver = new RobotReceiver(this);
    }

    public void startListening() {
        sender.start();
        receiver.start();
    }

    public void send(Message m) {
        sendingQueue.add(m);
    }

    public void stopListening() {
        sender.stopListening();
        receiver.stopListening();

        try {
            sender.join();
            receiver.join();
        } catch (InterruptedException e) {
            // Take no action.
        }
    }

    public static Object getLock() {
        return lock;
    }

    public LinkedBlockingQueue<Message> getSendingQueue() {
        return sendingQueue;
    }

    public DataOutputStream getOutputStream() {
        return outputStream;
    }

    public DataInputStream getInputStream() {
        return inputStream;
    }

    public void notifyObservers(Object o) {
        setChanged();
        super.notifyObservers(o);
    }
}
