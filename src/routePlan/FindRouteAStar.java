package routePlan;

import java.util.ArrayList;

/**
 * A class that uses A Star search and a heuristic to determine a route to be
 * taken by a robot
 * 
 * @author Chris I
 * XXIXIIMMXVI
 *
 */
public class FindRouteAStar implements RouteFinder {

	// [AMENDABLE] The heuristic to be utilised
	// pass an appropriate heuristic
	private AStarHeur heur;
	
	// The nodes that have already been explored by the search algorithm
	private ArrayList explored = new ArrayList();

	// The nodes that still have not been explored by the latter
	private ArrayList open = new ArrayList();

	// The map used in the search
	// TODO pass map
	

}
