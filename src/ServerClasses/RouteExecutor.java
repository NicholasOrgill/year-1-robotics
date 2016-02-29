package ServerClasses;

import interfaces.IWarehouse;

public class RouteExecutor implements Runnable {
	
	private IWarehouse warehouse;
	
	public RouteExecutor (IWarehouse _wh) {
		warehouse = _wh;
	}

	@Override
	public void run() {
		while(warehouse.getActive()) {
			
		}
	}
	//convert list of coordinates to list of moves 
}
