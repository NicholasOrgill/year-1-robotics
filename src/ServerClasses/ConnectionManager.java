package ServerClasses;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import interfaces.IRobot;
import lejos.pc.comm.NXTComm;
import lejos.pc.comm.NXTCommException;
import lejos.pc.comm.NXTCommFactory;
import lejos.pc.comm.NXTInfo;

public class ConnectionManager {
	NXTComm nxtComm;
	private ArrayList<Thread> threads;

	public ConnectionManager() {
		nxtComm = null;
		try {
			nxtComm = NXTCommFactory.createNXTComm(NXTCommFactory.BLUETOOTH);
		} catch (NXTCommException e) {
			e.printStackTrace();
			System.out.println("Couldn't create bluetooth communications factory!");
		}

	}

	Connection makeConnection(String name, String address) {
		NXTInfo nxtInfo = new NXTInfo(NXTCommFactory.BLUETOOTH, name, address);
		// Quite frankly I don't know what the _start and _count parameters do
		// in the Connection constructor. But that's what's in Nick's example code,
		// completely undocumented, so I guess that's how it's staying.
		Random rand = new Random();
		return new Connection(nxtInfo, rand.nextInt(), 20);
	}

	public void addConnections(ArrayList<IRobot> robots) {
		threads = new ArrayList<>();

		for (IRobot robot : robots) {
			String name = String.valueOf(robot.getId());
			String address = robot.getAddress();
			Connection c = makeConnection(name, address);

			// Wait until we can connect to each NXT.
			for (;;) {
				try {
					c.connect(nxtComm);
					break; // This will only be reached when c.connect has succeeded.
				} catch (NXTCommException e) {
					System.out.println("Can't connect to NXT " + name + " at " + address);
					System.out.println("Will try again in 3 seconds...");
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e1) {
						// If we've been interrupted, don't try to add any more NXTs.
						return;
					}
				}
			}
			threads.add(new Thread(c));
			robot.setConnection(c);
		}
		threads.forEach(Thread::start);
	}

	public void joinAll() {
		for (Thread thread : threads) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
