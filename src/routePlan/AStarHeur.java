package routePlan;

/**
 * 
 * An interface for the heuristic to be used for the A* Search. It will provide
 * a method that returns a cost for visiting a specified goal location from
 * another position. The obtained thereafter cost should then be used to
 * prioritise positions. Conventions I use in here: g prefix denotes goal
 * 
 * @author Chris I
 * XXIXIIMMXVI
 *
 */
public interface AStarHeur {

	/**
	 * @param x
	 *            The X coord of the state to be considered
	 * @param y
	 *            The Y coord of the latter
	 * @param gx
	 *            The X coord of the goal state
	 * @param gy
	 *            The Y coord of the latter
	 * @return The cost of a selected location
	 */
	public float getCost(int x, int y, int gx, int gy);

}
