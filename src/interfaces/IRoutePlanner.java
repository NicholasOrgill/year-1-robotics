package interfaces;

import rp.robotics.navigation.GridPose;

public interface IRoutePlanner {

	/**
	 * Gets the route that a robot would have to travel to get from p1 to p2
	 * 
	 * @param _p1
	 *            The starting point of the robot
	 * @param _p2
	 *            The finishing point of the robot
	 * @return The route the robot would take
	 */
	public IRoute getRoute(GridPose _p1, GridPose _p2);

}
