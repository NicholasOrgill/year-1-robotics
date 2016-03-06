import ServerClasses.*;
import interfaces.IJob;
import interfaces.IRobot;
import rp.robotics.mapping.GridMap;


import java.util.ArrayList;

public class RobotWarehouse {

	public static void main(String[] args) {

		final int timeStepDelay = 10000; // Ten second delay example
		
		// parse the files
		// TODO: Parse the files into the job, pick and item lists.
		GridMap gridMap = new GridMap();


		ArrayList<IJob> jobs = new ArrayList<>(); // Todo: Add our list of jobs here.
		ArrayList<IRobot> robots = new ArrayList<>(); // Todo: Add our list of robots here.

		ConnectionManager manager = new ConnectionManager();
		manager.addConnections(robots);

		Warehouse warehouse = new Warehouse(jobs, robots, gridMap); // Todo: Instantiate Warehouse properly.
		RoutePlanner routePlanner = new RoutePlanner();
		Assigner assigner = new Assigner(warehouse, routePlanner, 0);
		RouteExecutor routeExecutor = new RouteExecutor(warehouse, timeStepDelay);

		// start the other systems
		assigner.start();
		routeExecutor.start();

		// Block until all our connections have been closed.
		manager.joinAll();

	}

}
