package ServerClasses;

import java.util.ArrayList;

import interfaces.IAssigner;
import interfaces.IPick;
import interfaces.IRobot;
import interfaces.IRoute;
import interfaces.IRoutePlanner;
import interfaces.IWarehouse;
import interfaces.RobotState;
import rp.robotics.navigation.GridPose;

public class Assigner implements IAssigner {

	private IWarehouse warehouse;
	private IRoutePlanner routePlanner;
	private int delay;

	/**
	 * The default constructor for the assigner
	 * 
	 * @param _warehouse
	 *            The warehouse that the assigner is based on
	 * @param _routePlanner
	 *            The route planner for the warehouse
	 * @param _delay
	 *            The delay for the thread
	 */
	public Assigner(IWarehouse _warehouse, IRoutePlanner _routePlanner, int _delay) {
		warehouse = _warehouse;
		routePlanner = _routePlanner;
		setDelay(_delay);
	}

	@Override
	public void run() {

		// Whilst the warehouse is running
		while (warehouse.getActive()) {
			// Get the first robot
			IRobot robot = warehouse.getRobot(0);
			// The robot has run out of picks to collect so assign new ones
			if (robot.getState() == RobotState.WAITING_FOR_PICKS) {
				int weight = 0;
				// Assign picks until the weight limit is exceeded
				while (weight <= 50) {
					// Get the next unassigned pick
					IPick nextPick = warehouse.getNextIncompleteJob().getNextUnassignedPick();
					// assign it to the robot
					robot.assignPick(nextPick);
					// Increase the current weight
					weight += nextPick.getWeight();
				}
			}

			// Once picks have been assigned the robot will be waiting for the
			// route
			if (robot.getState() == RobotState.WAITING_FOR_ROUTE) {
				// Get the route from the route planner
				IRoute route = routePlanner.getRoute(robot.getPose(), robot.getPicks().get(0).getItem().getPose());
				robot.setRoute(route);
			}

			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				System.err.println("Assigner thread interrupted");
				e.printStackTrace();
			}
		}

	}

	private ArrayList<Pick> orderPicks(ArrayList<Pick> _picks) {

		// Picks remaining to be assigned
		ArrayList<Pick> remainingPicks = _picks;
		/// Picks already assigned
		ArrayList<Pick> selectedPicks = new ArrayList<Pick>();
		Pick bestPick = null;
		// While there are still picks to be assigned
		while (remainingPicks.size() != 0) {
			// The currently found best length of the route
			double bestLength = Double.MAX_VALUE;
			for (Pick selected : selectedPicks) {
				for (Pick remaining : remainingPicks) {
					double length = routePlanner.getEuclidianDistance(selected.getItem().getPose(),
							remaining.getItem().getPose());
					if (length < bestLength) {
						bestPick = remaining;
						bestLength = length;
					}
				}
			}
			if (bestPick != null) {
				int i = 0;
				int minPos = 0;
				int minExtension = Integer.MAX_VALUE;
				while (i < selectedPicks.size() - 1) {
					ArrayList<GridPose> subRoute = new ArrayList<GridPose>();
					subRoute.add(selectedPicks.get(i).getPose());
					subRoute.add(selectedPicks.get(i + 1).getPose());
					int originalLength = routePlanner.getRoute(subRoute).getLength();
					subRoute.add(1, bestPick.getPose());
					int newLength = routePlanner.getRoute(subRoute).getLength();
					int diff = newLength - originalLength;
					if (diff < minExtension) {
						minPos = i;
						minExtension = diff;
					}
					i++;
				}

				remainingPicks.remove(bestPick);
				selectedPicks.add(minPos, bestPick);
			}
		}
		return selectedPicks;
	}

	@Override
	public int getDelay() {
		return delay;
	}

	@Override
	public void setDelay(int _delay) {
		delay = _delay;
	}

}
