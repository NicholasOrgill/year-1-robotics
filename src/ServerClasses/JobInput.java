package ServerClasses;
//TODO EVERYTHING

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import interfaces.IPick;


public class JobInput {

	private final static String path = "C:/Users/Daniel/Desktop/warehouse/";
	private final static String jobsPath = path + "jobs.csv";
	private final static String locationsPath = path + "locations.csv";
	private final static String itemsPath = path + "items.csv";
	private final String cancellationsPath = path + "cancellations.csv";
	private final static String dropsPath = path + "drops.csv";
	private static ArrayList<Item> items;
	private static ArrayList<Job> jobs;

	private static boolean isEven(int i) {
		if (i % 2 == 0) {
			return true;
		} else
			return false;
	}

	private static void storeItems(String line) {
		String[] splits = line.split(",");
		items.add(new Item(splits[0], Double.parseDouble(splits[1]), Double.parseDouble(splits[2])));
	}

	private static void addLocations(String line) {
		// TODO SO inefficient
		String[] splits = line.split(",");
		int i = 0;
		while (!items.get(i).getName().equals(splits[2]) && i < items.size()) {
			i++;
		}
		if (i < items.size()) {
			items.get(i).setLocation(Integer.parseInt(splits[0]), Integer.parseInt(splits[1]));
		}
	}

	private static Item getItem(String item) {
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

	private static void storeInfo(String fileName, String line) {
		switch (fileName) {
		case itemsPath:
			storeItems(line);
			break;
		case locationsPath:
			addLocations(line);
			break;
		case jobsPath:
			storeJobs(line);
			break;
		}
	}

	private static void storeJobs(String line) {
		String[] splits = line.split(",");
		int jobID = Integer.parseInt(splits[0]);
		ArrayList<IPick> picks = new ArrayList<IPick>();
		int amount = 0;
		String item = null;
		for (int i = 1; i < splits.length; i++) {
			if (isEven(i)) {
				amount = Integer.parseInt(splits[i]);
				picks.add(new Pick(getItem(item), amount));
				amount = 0;
				item = null;
			} else {
				item = splits[i];
			}

		}
		jobs.add(new Job(jobID, picks));
	}

	private static void readFile(String fileName) {
		try {
			String line = null;
			FileReader fileReader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			int i = 0;
			while ((line = bufferedReader.readLine()) != null) {
				storeInfo(fileName, line);
				i++;
			}
			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");
		}

	}

	public static void main(String[] args) {
		items = new ArrayList<Item>();
		jobs = new ArrayList<Job>();
		readFile(itemsPath);
		readFile(locationsPath);
		items.removeAll(Collections.singleton(null));
		readFile(jobsPath);
		System.out.println(jobs);
	}

}
