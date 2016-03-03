package routePlan;

import java.util.ArrayList;

/**
 * A class that uses A Star search and a heuristic to determine a route to be
 * taken by a robot
 * 
 * @author Chris I IIIIMMXVI
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

	// The set of positions in the grid where movement will take place
	private Grid[][] gridpositions;

	/**
	 * Constructor for the route finder
	 * 
	 * @param heur
	 *            The heuristic
	 */
	public FindRouteAStar(AStarHeur heur) {
		this.heur = heur;

		// TODO Retrieve grid dimensions, placeholders for now
		// 
		gridpositions = new Grid[w][h];
		for (int x = 0; x < w; x++) {
			for (int y = 0; y < h; y++) {
				gridpositions[x][y] = new Grid(x, y);
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see routePlan.RouteFinder#findRoute(int, int, int, int)
	 */
	@Override
	public Route findRoute(int ax, int ay, int gx, int gy) {

		// TODO initialise A* with [] explored, and ax,ay in open list
		// gridpositions[ax][ay]
		explored.clear();
		open.clear();
		open.add(gridpositions[ax][ay]);

		while (open.size() > 0) {
			// TODO get first state in open list
			// should have the best heuristical outcome
			Grid present = getOpenFirst();
			if(present == gridpositions[gx][gx]) {
				// stop search, reached goal node
			}
			
			addExplored(present);
			removeOpen(present);
			
			
			// TODO iterate through all of the neighbouring grid positions
			// Movements can only be in four directions so the only possible translations are:
			// (1,0), (-1,0), (0,1), (0,-1)
			// which when added to the current position would give us the coordinates of
			// the neoghbouring cells accordingly
			
			// go through X coords - explanation above
			for(int x = -1; x < 2; x++) {
					// go through Y coords - explanation above
					for(int y = -1; y < 2; y++) {
						
						int neighbouringX = present.getX() + x;
						int neighbouringY = present.getY() + y;
						
						// check whether the location is allowed
						if(isItAllowed(ax, ay, neighbouringX, neighbouringY)) {
							// cost to move, typically 1, as it is one position away from the next direct
							float costToNeighbour = present.getCost() + 1;
							
							Grid neighbour = gridpositions[neighbouringX][neighbouringY];
						
							float neighbourCost = neighbour.getCost();
							// need to check whether that node has been considered before
							// and if so check whether we have obtained a lower cost for it
							// thus take it back into consideration
							if(costToNeighbour < neighbourCost) {
								if(isItOpen(neighbour)) {
									removeOpen(neighbour);
								}
								if(isItExplored(neighbour)) {
									removeExplored(neighbour);
								}
							}
							
							if(isItExplored(neighbour) == false && isItOpen(neighbour) == false) {
								neighbourCost = costToNeighbour;
								float h = getHeuristicCost(neighbouringX, neighbouringY, gx, gy);
								neighbour.setHeur(h);
							}
						}
					}
				}

		}

		Route route = new Route();
		Grid goal = gridpositions[gx][gy];
		while(!(goal.compareTo(gridpositions[ax][ay]) == 0)) {
			// TODO add to the beginning of the list 
			route.appendStep(goal.getX(), goal.getY());
		}
		
		route.appendStep(ax, ay);
		return route;
	}

	/**
	 * Get the first element of the open list, which should be searched next.
	 *
	 * @return The element with index 0 in the list of open positions (still
	 *         unexplored)
	 */
	private Grid getOpenFirst() {
		return (Grid) open.get(0);
	}

	/*****************
	 * Adding methods
	 ****************/

	/**
	 * Add a position to the list of open unexplored positions on the grid.
	 *
	 * @param position
	 *            The position to add to the open list
	 */
	private void addOpen(Grid position) {
		open.add(position);
	}

	/**
	 * Add a position to the list of already explored positions on the grid.
	 *
	 * @param position
	 *            The position to be added to the explored list
	 */
	private void addExplored(Grid position) {
		explored.add(position);
	}

	/*****************
	 * Removing methods
	 ****************/

	/**
	 * Remove a position from the list of open unexplored positions on the grid.
	 * 
	 * @param position
	 *            The position to remove from the open list
	 */
	private void removeOpen(Grid position) {
		open.remove(position);
	}

	/**
	 * Remove a position from the list of already explored positions on the
	 * grid.
	 * 
	 * @param position
	 *            The position to remove from the explored list
	 */
	private void removeExplored(Grid position) {
		explored.remove(position);
	}

	/*****************
	 * Checking methods
	 ****************/

	/**
	 * Check whether a position is in the open (unexplored) list
	 * 
	 * @param position
	 *            The position to be checked against
	 * @return Whether the position is in the open list
	 */
	private boolean isItOpen(Grid position) {
		return open.contains(position);
	}

	/**
	 * Check whether a position is in the explored list
	 * 
	 * @param position
	 *            The position to be checked against
	 * @return Whether the position is in the already explored list
	 */
	private boolean isItExplored(Grid position) {
		return explored.contains(position);
	}

	/**
	 * TODO
	 * 
	 * A method to check whether a give location is even physically possible to
	 * be reached i.e it is not a wall or outside of the given grid (<0? x y )
	 * 
	 * @param ax
	 *            The X coord of the current position
	 * @param ay
	 *            The Y coord of the latter
	 * @param gx
	 *            The X coord of the position to be checked for validity
	 * @param gy
	 *            The Y coord of the latter
	 * @return Whether the location is physically reachable
	 */
	private boolean isItAllowed(int ax, int ay, int somex, int somey) {
		// TODO check location of walls and add them as not allowed
		// TODO x<0 and y<0 should not be allowed as well
		// TODO if somex and somey are the same as ax and ay 
		// they should not be allowed as well
		// might help circumvent a drawback of the Manhattan distance heuristic
		// as well as prevent looping in circles.
	}

	/*****************
	 * Cost-related
	 ****************/

	/**
	 * Get the heuristic cost for the given location, used to determine where to
	 * proceed to.
	 * 
	 * @param x
	 *            The X coord of the position checked against
	 * @param y
	 *            The Y coord of the latter
	 * @param gx
	 *            The X coord of the goal state
	 * @param gy
	 *            The Y coord of goal state
	 * @return The heuristic cost assigned to the tile
	 */
	public float getHeuristicCost(int x, int y, int gx, int gy) {
		return heur.getCost(x, y, gx, gy);
	}
}
