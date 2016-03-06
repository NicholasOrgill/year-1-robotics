package robot;

import lejos.nxt.LCD;
import lejos.nxt.LightSensor;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.util.Delay;

/**
 * A Runnable class that receives moves from the server and executes them on the
 * robot.
 */
public class MoveExecuter implements Runnable {

	private final LightSensor left;
	private final LightSensor right;

	private final DifferentialPilot pilot;
	private final ServerConnection server;

	public MoveExecuter(ServerConnection server, DifferentialPilot pilot, LightSensor left, LightSensor right) {
		this.server = server;
		this.pilot = pilot;
		this.left = left;
		this.right = right;

	}

	@Override
	public void run() {

		while (true) {
			final Move move = server.getNextMove();

			switch (move.type) {
			case MOVE_FORWARD:
				this.moveForward(move.getUnits());
				break;

			case TURN_LEFT:
				this.pilot.rotate(90);
				break;

			case TURN_RIGHT:
				this.pilot.rotate(-90);
				break;

			case TURN_AROUND:
				this.pilot.rotate(180);
				break;
			}

			server.confirmMove();
		}
	}

	/**
	 * Returns true if the left sensor detects a grid line, false otherwise.
	 */
	private boolean isNextLeftReadingDark() {
		int lefty = left.readValue();

		if (lefty < 33)
			return true;
		else
			return false;
	}

	/**
	 * Returns true if the right sensor detects a grid line, false otherwise.
	 */
	private boolean isNextRightReadingDark() {
		int righty = right.readValue();

		if (righty < 33)
			return true;
		else
			return false;
	}

	/**
	 * Moves the robot forward the specified number of units (grid tiles).
	 */
	private void moveForward(int units) {

		int passed = 0;
		while (passed < units) {
			this.pilot.forward();
			
			this.pilot.setTravelSpeed(150f);

			boolean left = this.isNextLeftReadingDark();
			boolean right = this.isNextRightReadingDark();

			if (left && right) {
				passed++;
				Delay.msDelay(200);
				pilot.travel(65);
				LCD.drawString("Pass" + passed, 2, 3);
			} 
			
			if (left) {
				this.pilot.rotate(3, true);
				Delay.msDelay(50);
			} else if (right) {
				this.pilot.rotate(-3, true);
				Delay.msDelay(50);
			}

		}
		this.pilot.stop();
	}
}
