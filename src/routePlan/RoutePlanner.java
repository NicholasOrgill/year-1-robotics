package routePlan;

/**
 * The interface to be implemented in order to find a path from one
 * location(the start) to another(the goal), using a preordained map.
 * 
 * @author Chris II
 * 29IIMMXVI
 */
public interface RoutePlanner {
	/**
	 * The following convention is used in classes created by me:
	 * 
	 * 'a' prefix to variable name = that variable in the beginning
	 * 'g' prefix to variable name = that variable at the end /goal/ 
	 * 
	 * 
	 * @param ax The x coordinate of the starting location
	 * @param ay The y coordinate of the starting location
	 * 
	 * @param gx The x coordinate of the goal location
	 * @param gy The y coordinate of the goal location
	 * @return The route from start to end
	 */
	public Route findRoute(int ax, int ay, int gx, int gy );
}
