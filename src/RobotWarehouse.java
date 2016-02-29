import ServerClasses.Assigner;
import ServerClasses.RouteExecutor;
import ServerClasses.RoutePlanner;
import ServerClasses.Warehouse;

public class RobotWarehouse {

	public static void main(String[] args) {

		final int timeStepDelay = 10000; // Ten second delay example
		
		// parse the files
		// TODO: Parse the files into the job, pick and item lists.

		// create the other systems
		Warehouse warehouse = new Warehouse();
		RoutePlanner routePlanner = new RoutePlanner();
		Assigner assigner = new Assigner(warehouse, routePlanner, 0);
		RouteExecutor routeExecutor = new RouteExecutor(warehouse, timeStepDelay);

		// start the other systems
		assigner.start();
		routeExecutor.start();

	}

}
