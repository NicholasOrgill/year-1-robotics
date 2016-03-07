import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import ServerClasses.Assigner;
import ServerClasses.Item;
import ServerClasses.Job;
import ServerClasses.Pick;
import ServerClasses.Robot;
import ServerClasses.RouteExecutor;
import ServerClasses.RoutePlanner;
import ServerClasses.Warehouse;
import interfaces.IItem;
import interfaces.IJob;
import interfaces.IPick;
import interfaces.IRobot;
import rp.robotics.navigation.GridPose;
import rp.robotics.navigation.Heading;

public class RobotWarehouse {

	private final static String path = "C:/Users/George/work/RobotWarehouse/warehouse/";
	private final static String jobsPath = path + "jobs.csv";
	private final static String locationsPath = path + "locations.csv";
	private final static String itemsPath = path + "items.csv";
	private final String cancellationsPath = path + "cancellations.csv";
	private final static String dropsPath = path + "drops.csv";

	public static void main(String[] args) {

		final int timeStepDelay = 10000; // Ten second delay example

		ArrayList<IItem> items;
		ArrayList<IJob> jobs;
		ArrayList<IRobot> robots;

		// parse the files
		items = new ArrayList<IItem>();
		jobs = new ArrayList<IJob>();
		readFile(jobs, items, itemsPath);
		readFile(jobs, items, locationsPath);
		items.removeAll(Collections.singleton(null));
		readFile(jobs, items, jobsPath);
		System.out.println(jobs);

		robots = new ArrayList<IRobot>();
		robots.add(new Robot());

		// create the other systems
		// TODO: add grid map
		Warehouse warehouse = new Warehouse(jobs, robots, null);
		RoutePlanner routePlanner = new RoutePlanner();
		Assigner assigner = new Assigner(warehouse, routePlanner, 0);
		RouteExecutor routeExecutor = new RouteExecutor(warehouse, timeStepDelay);

		// start the other systems
		assigner.start();
		routeExecutor.start();

	}

	private static boolean isEven(int i) {
		if (i % 2 == 0) {
			return true;
		} else
			return false;
	}

	private static void storeItems(ArrayList<IItem> items, String line) {
		String[] splits = line.split(",");
		items.add(new Item(splits[0], Double.parseDouble(splits[1]), Double.parseDouble(splits[2])));
	}

	private static void addLocations(ArrayList<IItem> items, String line) {
		// TODO SO inefficient
		String[] splits = line.split(",");
		int i = 0;
		while (!items.get(i).getName().equals(splits[2]) && i < items.size()) {
			i++;
		}
		if (i < items.size()) {
			items.get(i).setPose(
					new GridPose(new Point(Integer.parseInt(splits[0]), Integer.parseInt(splits[1])), Heading.PLUS_X));
		}
	}

	private static IItem getItem(ArrayList<IItem> items, String item) {
		int i = 0;
		while (i < items.size() && !items.get(i).getName().equals(item)) {
			i++;
		}
		try {
			return items.get(i);
		} catch (Exception e) {
			return null;
		}
	}

	private static void storeInfo(ArrayList<IJob> jobs, ArrayList<IItem> items, String fileName, String line) {
		switch (fileName) {
		case itemsPath:
			storeItems(items, line);
			break;
		case locationsPath:
			addLocations(items, line);
			break;
		case jobsPath:
			storeJobs(jobs, items, line);
			break;
		}
	}

	private static void storeJobs(ArrayList<IJob> jobs, ArrayList<IItem> items, String line) {
		String[] splits = line.split(",");
		int jobID = Integer.parseInt(splits[0]);
		ArrayList<IPick> picks = new ArrayList<IPick>();
		int amount = 0;
		String item = null;
		for (int i = 1; i < splits.length; i++) {
			if (isEven(i)) {
				amount = Integer.parseInt(splits[i]);
				picks.add(new Pick(getItem(items, item), amount));
				amount = 0;
				item = null;
			} else {
				item = splits[i];
			}

		}
		jobs.add(new Job(jobID, picks));
	}

	private static void readFile(ArrayList<IJob> jobs, ArrayList<IItem> items, String fileName) {
		try {
			String line = null;
			BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
			int i = 0;
			while ((line = bufferedReader.readLine()) != null) {
				storeInfo(jobs, items, fileName, line);
				i++;
			}
			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");
		}

	}

}
