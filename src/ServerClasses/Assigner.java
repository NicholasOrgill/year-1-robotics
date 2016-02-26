package ServerClasses;

import interfaces.IAssigner;
import interfaces.IPick;
import interfaces.IRobot;
import interfaces.RobotState;
import interfaces.IRoute;
import interfaces.IRoutePlanner;
import interfaces.IWarehouse;

public class Assigner implements IAssigner {

	private IWarehouse warehouse;
	private IRoutePlanner routePlanner;
	private int delay;
	
	public Assigner(IWarehouse _warehouse, IRoutePlanner _routePlanner, int _delay){
		warehouse = _warehouse;
		routePlanner = _routePlanner;
		setDelay(_delay);
	}
	
	@Override
	public void run() {
		
		while(warehouse.getActive()){
			IRobot robot = warehouse.getRobot(0);
			if(robot.getState() == RobotState.WAITING_FOR_PICKS){
				int weight = 0;
				while(weight <= 50){
					IPick nextPick = warehouse.getNextIncompleteJob().getNextUnassignedPick();
					robot.assignPick(nextPick);
					weight += nextPick.getWeight();
				}
			}
			
			if(robot.getState() == RobotState.WAITING_FOR_ROUTE){
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

	@Override
	public int getDelay() {
		return delay;
	}

	@Override
	public void setDelay(int _delay) {
		delay = _delay;
	}

}
