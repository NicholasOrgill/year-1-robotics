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

		while (warehouse.getActive()) {

			// Single robot
//			IRobot robot = warehouse.getRobot(0);
//			if (robot.getState() == RobotState.WAITING_FOR_PICKS) {
//				int weight = 0;
//				ArrayList<IPick> picks = new ArrayList<IPick>();
//				while (weight <= 50) {
//					IPick nextPick = warehouse.getNextIncompleteJob().getNextUnassignedPick();
//					picks.add(nextPick);
//					weight += nextPick.getWeight();
//				}
//				robot.assignPicks(picks);
//				robot.assignPicks(orderPicks(picks));
//
//			if (robot.getState() == RobotState.WAITING_FOR_ROUTE) {
//				IRoute route = routePlanner.getRoute(robot.getPose(), robot.getPicks().get(0).getItem().getPose());
//				robot.setRoute(route);
//			}

				
				// TODO: Multi robot
				ArrayList<Integer> weight = new ArrayList<Integer>(warehouse.getRobotCount());
				ArrayList<ArrayList<IPick>> picks = new ArrayList<ArrayList<IPick>>(warehouse.getRobotCount());
				ArrayList<Integer> bidVal = new ArrayList<Integer>(warehouse.getRobotCount());
				
				
			}


			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				System.err.println("Assigner thread interrupted");
				e.printStackTrace();
			}
		}

	}

	private ArrayList<IPick> orderPicks(ArrayList<IPick> _picks) {

		ArrayList<IPick> remainingPicks = _picks;
		ArrayList<IPick> selectedPicks = new ArrayList<IPick>();
		IPick bestPick = null;
		while (remainingPicks.size() != 0) {
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
