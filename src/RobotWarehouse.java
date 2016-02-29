import ServerClasses.Assigner;
import ServerClasses.RoutePlanner;
import ServerClasses.Warehouse;

public class RobotWarehouse {

	public static void main(String[] args) {

		Warehouse warehouse = new Warehouse();
		RoutePlanner routePlanner = new RoutePlanner();

		// parse the files

		// create the objects

		// create the other systems
		Assigner assigner = new Assigner(warehouse, routePlanner, 0);

		// start the other systems

	}

}
