package ServerClasses;

import interfaces.IRouteExecutor;
import interfaces.IWarehouse;
import interfaces.RobotState;

public class RouteExecutor extends Thread implements IRouteExecutor {

	private IWarehouse warehouse;

	private int delay;

	public RouteExecutor(IWarehouse _wareHouse, int _delay) {
		warehouse = _wareHouse;
		delay = _delay;
	}

	@Override
	public void run() {
		while (warehouse.getActive()) {

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
