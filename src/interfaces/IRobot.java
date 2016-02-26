package interfaces;

import java.util.ArrayList;

import rp.robotics.navigation.GridPose;

public interface IRobot {

	/**
	 * Get the robots position on the grid
	 * 
	 * @return The robots position on the grid
	 */
	public GridPose getPose();

	/**
	 * Set the robots position on the grid
	 * 
	 * @param _pose
	 *            The new position of the robot
	 */
	public void setPose(GridPose _pose);

	/**
	 * Get the state of the robot
	 * 
	 * @return The state of the robot
	 */
	public RobotState getState();

	/**
	 * Set the state of the robot
	 * 
	 * @param _state
	 *            The new state of the robot
	 */
	public void setState(RobotState _state);

	/**
	 * Assign a pick to the current robot
	 * 
	 * @param _pick
	 *            The pick to be assigned
	 */
	public void assignPick(IPick _pick);

	/**
	 * Get the route for the robot
	 * 
	 * @return The robots route
	 */
	public IRoute getRoute();

	/**
	 * Set the route for the current position to the next pick
	 * 
	 * @param _route
	 *            The route
	 */
	public void setRoute(IRoute _route);

	/**
	 * Get the list of picks for the robot
	 * 
	 * @return The list of picks for the robot
	 */
	public ArrayList<IPick> getPicks();

	/**
	 * Send a message to the physical robot
	 * 
	 * @param _message
	 */
	public void sendMessage(IMessage _message);

	/**
	 * Wait for a message to be received from the robot
	 * 
	 * @return The message received from the robot
	 */
	public IMessage receiveMessage();

}