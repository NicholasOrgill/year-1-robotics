package ServerClasses;

import java.util.ArrayList;

import interfaces.IAssigner;
import interfaces.IPick;
import interfaces.IRobot;
import interfaces.IRoute;
import interfaces.IRoutePlanner;
import interfaces.IWarehouse;
import interfaces.PickState;
import interfaces.RobotState;
import rp.robotics.navigation.GridPose;

public class Assigner extends Thread implements IAssigner {

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

	public void run() {

		// Whilst the warehouse is running
		while (warehouse.getActive()) {

			// Single robot
			IRobot robot = warehouse.getRobot(0);
			if (robot.getState() == RobotState.WAITING_FOR_PICKS) {
				int weight = 0;
				ArrayList<IPick> picks = new ArrayList<IPick>();
				while (weight <= 50) {
					IPick nextPick = warehouse.getNextIncompleteJob().getNextUnassignedPick();
					picks.add(nextPick);
					nextPick.setPickState(PickState.ASSIGNED);
					weight += nextPick.getWeight();
				}
				robot.assignPicks(picks);
				robot.assignPicks(orderPicks(picks));

				// Once picks have been assigned the robot will be waiting for
				// the
				// route
				if (robot.getState() == RobotState.WAITING_FOR_ROUTE) {
					IRoute route = routePlanner.getRoute(robot.getPose(), robot.getPicks().get(0).getItem().getPose());
					robot.setRoute(route);
				}

				// TODO: Multi robot
				/*
				 * Integer[] weight = new Integer[warehouse.getRobotCount()];
				 * ArrayList<ArrayList<IPick>> picks = new
				 * ArrayList<ArrayList<IPick>>(warehouse.getRobotCount());
				 * Integer[] bidVal = new Integer[warehouse.getRobotCount()];
				 * 
				 * ArrayList<IPick> remainingPicks = new ArrayList<IPick>();
				 * remainingPicks =
				 * warehouse.getNextIncompleteJob().getUnassignedPicks();
				 * 
				 * while (picks.size() > 0) {
				 * 
				 * // Reset the bids for (int i = 0; i <
				 * warehouse.getRobotCount(); i++) bidVal[i] =
				 * Integer.MAX_VALUE;
				 * 
				 * // get the bidVal for each robot for (int i = 0; i <
				 * warehouse.getRobotCount(); i++) { // check that the robot can
				 * accept the pick if (weight[i] +
				 * remainingPicks.get(0).getWeight() <= 50) {
				 * picks.get(i).add(remainingPicks.get(0)); ArrayList<IPick>
				 * orderedPicks = orderPicks(picks.get(i)); ArrayList<GridPose>
				 * gridPoses = new ArrayList<GridPose>(); for (IPick pick :
				 * orderedPicks) gridPoses.add(pick.getPose()); bidVal[i] =
				 * routePlanner.getRoute(gridPoses).getLength();
				 * picks.get(i).remove(picks.get(i).size() - 1); } }
				 * 
				 * int bestBid = bidVal[0]; int bestIndex = 0; for (int i = 1; i
				 * < warehouse.getRobotCount(); i++) { if (bidVal[i] < bestBid)
				 * { bestBid = bidVal[i]; bestIndex = i; } }
				 * 
				 * picks.get(bestIndex).add(remainingPicks.get(0));
				 * remainingPicks.remove(0); }
				 * 
				 * }
				 */
			}
		}
		try {
			Thread.sleep(delay);
		} catch (InterruptedException e) {
			System.err.println("Assigner thread interrupted");
			e.printStackTrace();
		}
	}

	private ArrayList<IPick> orderPicks(ArrayList<IPick> _picks) {

		ArrayList<IPick> remainingPicks = _picks;
		ArrayList<IPick> selectedPicks = new ArrayList<IPick>();
		IPick bestPick = null;
		while (remainingPicks.size() != 0) {
			// The currently found best length of the route
			double bestLength = Double.MAX_VALUE;
			for (IPick selected : selectedPicks) {
				for (IPick remaining : remainingPicks) {
					// int length =
					// routePlanner.getRoute(selected.getItem().getPose(),
					// remaining.getItem().getPose()).getLength();
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
