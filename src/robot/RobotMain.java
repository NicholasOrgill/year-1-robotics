package robot;

import lejos.nxt.LightSensor;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.robotics.navigation.DifferentialPilot;

/**
 * The main class of the program to run on each robot.
 */
public class RobotMain {
	public static void main(String[] args) {
		final MockServerConnection server = new MockServerConnection();

		final DifferentialPilot pilot = new DifferentialPilot(0.062, // Wheel
																		// diameter
				0.163, // Track width
				Motor.B, // Left wheel
				Motor.C); // Right wheel

		final LightSensor leftSensor = new LightSensor(SensorPort.S1);
		final LightSensor rightSensor = new LightSensor(SensorPort.S2);

		final MoveExecuter moveExecuter = new MoveExecuter(server, pilot, leftSensor, rightSensor);

		// final RobotInterface iface = new RobotInterface(server);

		// new Thread(server).start();
		new Thread(moveExecuter).start();
		// new Thread(iface).start();
	}
}
