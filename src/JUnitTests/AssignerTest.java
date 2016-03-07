/**
 * 
 */
package JUnitTests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ServerClasses.Item;
import ServerClasses.Job;
import ServerClasses.Pick;
import ServerClasses.Robot;
import ServerClasses.Warehouse;
import interfaces.IItem;
import interfaces.IJob;
import interfaces.IPick;
import interfaces.IRobot;
import interfaces.IWarehouse;
import interfaces.PickState;
import interfaces.RobotState;

/**
 * @author George
 *
 */
public class AssignerTest {

	ArrayList<IItem> items = new ArrayList<IItem>();
	ArrayList<IPick> picks = new ArrayList<IPick>();
	ArrayList<IJob> jobs = new ArrayList<IJob>();

	IWarehouse warehouse;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		System.out.println("Setting up test for assigner");

		// Set of items with different weights (rewards are irrelevant at this
		// stage
		items.add(new Item("a", 2.0, 1.0));
		items.add(new Item("b", 2.0, 2.0));
		items.add(new Item("c", 2.0, 4.0));
		items.add(new Item("d", 2.0, 2.0));
		items.add(new Item("e", 2.0, 4.0));
		items.add(new Item("f", 2.0, 6.0));
		items.add(new Item("g", 2.0, 5.0));
		items.add(new Item("h", 2.0, 8.0));
		items.add(new Item("i", 2.0, 1.0));
		items.add(new Item("j", 2.0, 3.0));

		picks.add(new Pick(items.get(0), 3)); // 3
		picks.add(new Pick(items.get(1), 2)); // 4
		picks.add(new Pick(items.get(2), 1)); // 4
		picks.add(new Pick(items.get(3), 2)); // 4
		picks.add(new Pick(items.get(4), 3)); // 12
		picks.add(new Pick(items.get(5), 4)); // 24
		picks.add(new Pick(items.get(6), 2)); // 10
		picks.add(new Pick(items.get(7), 1)); // 8
		picks.add(new Pick(items.get(8), 4)); // 4
		picks.add(new Pick(items.get(9), 3)); // 9

		for (int i = 0; i < 10; i++) {
			ArrayList<IPick> tempPicks = new ArrayList<IPick>();
			for (int j = 0; j < 10; j++)
				tempPicks.add(picks.get((i + j) % 10));
			jobs.add(new Job(i, tempPicks));
		}
		assert(jobs.size() == 10);

		// The job with it's corresponding weight up to 50
		// job 1 = 27 (5)
		// job 2 = 48 (5)
		// job 3 = 44 (4)
		// job 4 = 50 (4)
		// job 5 = 36
		// job 6 = 34
		// job 7 = 18
		// job 8 = 12
		// job 9 = 13
		// job 10 = 12

		ArrayList<IRobot> robots = new ArrayList<IRobot>();
		robots.add(new Robot());

		warehouse = new Warehouse(jobs, robots, null);

	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		System.out.println("Tests ended");
	}

	private void assignPicks() {
		IRobot robot = warehouse.getRobot(0);
		if (robot.getState() == RobotState.WAITING_FOR_PICKS) {
			int weight = 0;
			ArrayList<IPick> picks = new ArrayList<IPick>();
			IPick nextPick = warehouse.getNextIncompleteJob().getNextUnassignedPick();
			while (nextPick != null && weight + nextPick.getWeight() <= 50) {
				picks.add(nextPick);
				nextPick.setPickState(PickState.ASSIGNED);
				weight += nextPick.getWeight();
				nextPick = warehouse.getNextIncompleteJob().getNextUnassignedPick();
			}
			robot.assignPicks(picks);
		}
	}

	// Emulates robot completing picks and reseting
	private void resetRobot() {
		warehouse.getRobot(0).getPicks().clear();
		warehouse.getRobot(0).setState(RobotState.WAITING_FOR_PICKS);
	}

	@Test
	public void test() {
		assignPicks();
		assertEquals(warehouse.getRobot(0).getPicks().size(), 5);
		resetRobot();
		assignPicks();
		assertEquals(warehouse.getRobot(0).getPicks().size(), 4);
		resetRobot();
		assignPicks();
		assertEquals(warehouse.getRobot(0).getPicks().size(), 1);
	}

}
