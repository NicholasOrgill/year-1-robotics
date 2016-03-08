/**
 * 
 */
package JUnitTests;

import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ServerClasses.Item;
import interfaces.IItem;
import interfaces.IJob;
import interfaces.IPick;

/**
 * @author George
 *
 */
public class AssignerTest {

	ArrayList<IItem> items = new ArrayList<IItem>();
	ArrayList<IPick> picks = new ArrayList<IPick>();
	ArrayList<IJob> jobs = new ArrayList<IJob>();

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		System.out.println("Setting up test for assigner");

		items.add(new Item("a", 2.0, 4.0));
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
