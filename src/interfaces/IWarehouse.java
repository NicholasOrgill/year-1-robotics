	package interfaces;

import java.util.ArrayList;

import rp.robotics.mapping.GridMap;

public interface IWarehouse {

	/**
	 * Get the list of robots in the warehouse
	 * 
	 * @return The list of robots in the warehouse
	 */
	public ArrayList<IRobot> getRobots();

	/**
	 * The list of jobs in the warehouse
	 * 
	 * @return The list of jobs
	 */
	public ArrayList<IJob> getJobs();

	/**
	 * Set the list of jobs in the warehouse
	 * 
	 * @param _jobs
	 *            The list of jobs
	 */
	public void setJobs(ArrayList<IJob> _jobs);

	/**
	 * Add a robot to the warehouse
	 * 
	 * @param _robot
	 */
	public void addRobot(IRobot _robot);

	/**
	 * Get the robot at the specified index
	 * 
	 * @param _robotIndex
	 *            The index of the desired robot
	 * @return The robot at that index
	 */
	public IRobot getRobot(int _robotIndex);

	/**
	 * Get the map of the warehouse
	 * 
	 * @return The warehouse map
	 */
	public GridMap getMap();

	/**
	 * Set the warehouse map
	 * 
	 * @param _map
	 *            The new map
	 */
	public void setMap(GridMap _map);

	/**
	 * Get the number of robots in the warehouse
	 * 
	 * @return The number of robots in the warehouse
	 */
	public int getRobotCount();

	/**
	 * Get the number of jobs in the warehouse
	 * 
	 * @return The number of jobs in the warehouse
	 */
	public int getJobCount();

	/**
	 * Get whether the warehouse is active or not
	 * 
	 * @return Whether the warehouse is
	 */
	public boolean getActive();

	/**
	 * Set whether the warehouse is active
	 * 
	 * @param _active
	 *            Whether the warehouse is active
	 */
	public void setActive(boolean _active);

	/**
	 * The next job containing unassigned picks
	 * 
	 * @return The next job containing unassigned picks
	 */
	public IJob getNextIncompleteJob();

	/**
	 * Send a message to the given robot.
	 * @param robotIndex The robot to send the message to.
	 * @param header The message's header.
	 * @param message The message's body.
     */
	public void sendMessage(int robotIndex, String header, String message);

	/**
	 * @return The next message to be received (after blocking).
     */
	public IMessage nextMessage();
}
