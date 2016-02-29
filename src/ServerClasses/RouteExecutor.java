package ServerClasses;

import interfaces.IMessage;
import interfaces.IRobot;
import interfaces.IRouteExecuter;
import interfaces.IWarehouse;
import interfaces.RobotState;

public class RouteExecutor implements IRouteExecuter {
	
	private IWarehouse warehouse;
	private int delay;
	private int robotCount;
	
	public RouteExecutor (IWarehouse _wh, int _delay) {
		warehouse = _wh;
		delay = _delay;
	}

	@Override
	public void run() {
		while(warehouse.getActive()) {
			robotCount = warehouse.getRobotCount();
			for(int i = 0; i < robotCount; i++) {
				IRobot robot = warehouse.getRobot(i);
				if (robot.getState() == RobotState.ROUTE_ASSIGNED) {
					robot.setState(RobotState.EXECUTING_ROUTE);
				}
			}
		}
	}
	//convert list of coordinates to list of moves 

	@Override
	public int getDelay() {
		// TODO Auto-generated method stub
		return delay;
	}

	@Override
	public void setDelay(int _delay) {
		delay = _delay;
	}

	@Override
	public void returnMessage(IMessage _msg) {
		// TODO Auto-generated method stub
		
	}
	
	
}
