package ServerClasses;


import interfaces.IMessage;
import lejos.pc.comm.NXTComm;
import lejos.pc.comm.NXTCommException;
import lejos.pc.comm.NXTInfo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Observable;
import java.util.concurrent.LinkedBlockingQueue;

public class Connection extends Observable implements Runnable  {
    private DataInputStream m_dis;
    private DataOutputStream m_dos;
    private final int m_start;
    private final int m_count;
    private final NXTInfo m_nxt;
    private final static Object m_lock = new Object();
    private LinkedBlockingQueue<String> receivedQueue;
    private LinkedBlockingQueue<String> sendingQueue;


    public DataInputStream getM_dis() {
        return m_dis;
    }

    public DataOutputStream getM_dos() {
        return m_dos;
    }

    public int getM_start() {
        return m_start;
    }

    public int getM_count() {
        return m_count;
    }

    public NXTInfo getM_nxt() {
        return m_nxt;
    }

    public static Object getM_lock() {
        return m_lock;
    }


    public Connection(NXTInfo _nxt, int _start, int _count) {
        sendingQueue = new LinkedBlockingQueue<>();
        receivedQueue = new LinkedBlockingQueue<>();
        m_start = _start;
        m_count = _count;
        m_nxt = _nxt;
    }


    public boolean connect(NXTComm _comm) throws NXTCommException {
        if (_comm.open(m_nxt)) {
            m_dis = new DataInputStream(_comm.getInputStream());
            m_dos = new DataOutputStream(_comm.getOutputStream());
        }
        return isConnected();
    }


    public boolean isConnected() {
        return m_dos != null;
    }


    public void send(IMessage m) {
        sendingQueue.add(m.toString());
    }

    @Override
    public void run() {
        Thread receiver = new WarehouseReceiver(this);
        Thread sender = new WarehouseSender(this);
        receiver.start();
        sender.start();

        try {
            receiver.join();
        } catch (InterruptedException e) {} finally {
            try {
                sender.join();
            } catch (InterruptedException e) {}
        }

    }

    public LinkedBlockingQueue<String> getReceivedQueue() {
        return receivedQueue;
    }

    public LinkedBlockingQueue<String> getSendingQueue() {
        return sendingQueue;
    }
}
