package ServerClasses;

import java.util.ArrayList;

import SharedClasses.Message;
import interfaces.IMessage;
import interfaces.IRobot;
import interfaces.IRoute;
import interfaces.IRouteExecutor;
import interfaces.IWarehouse;
import interfaces.MessageHeader;
import interfaces.RobotState;

public class RouteExecutor extends Thread implements IRouteExecutor {
	
	private IWarehouse warehouse;
	private int delay;
	private int robotCount;
	private ArrayList<IRobot> excRobots;
	
	public RouteExecutor (IWarehouse _warehouse, int _delay) {
		warehouse = _warehouse;
		delay = _delay;
	}

	@Override
	public void run() {
		while(warehouse.getActive()) {
			try {
				sleep(delay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			robotCount = warehouse.getRobotCount();
			for(int i = 0; i < robotCount; i++) {
				IRobot robot = warehouse.getRobot(i);
				if (robot.getState() == RobotState.ROUTE_ASSIGNED) {
					robot.setState(RobotState.EXECUTING_ROUTE);
					excRobots.add(robot);
				}
			}
			for(int i = 0; i < excRobots.size(); i++) {
				IRobot cRob = excRobots.get(i);
				IRoute cRoute = cRob.getRoute();
				if (cRoute.getLength() == 0) {
					//route execution complete pick location reached
				}
				cRob.sendMessage((IMessage) new Message(MessageHeader.MOVE, cRoute.getNextMove().getDirection().toString()));
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

	@Override
	public IMessage returnMessage(IMessage _msg) {
		return _msg;
	}
}
