package routePlan;

import java.util.ArrayList;

import interfaces.IMove;
import interfaces.IRoute;

/**
 * The route to be passed, consisting of a sequence of moves from the starting
 * location to the goal
 * 
 * @author Chris I XXIXIIMMXVI
 *
 */
public class Route implements IRoute {

	// An array list of the moves in the route
	private ArrayList<IMove> moves = new ArrayList<IMove>();

	// The empty constructor of the route, consisting of the moves
	// from the start to the goal state
	public Route() {
	}

	/**
	 * Add a move given by its coordinates to the route
	 * 
	 * @param x
	 *            The X coord of the move
	 * @param y
	 *            The Y coord of the move
	 */
	public void appendStep(int x, int y) {
		moves.add(new Move(x, y));
	}

	/**
	 * Get the step at a given index in the path
	 * 
	 * @param i
	 *            The index of the move to get
	 * @return The coordinates of the next move
	 */
	public Move getMove(int i) {
		return (Move) moves.get(i);
	}

	/**
	 * Get the X coordinate for the move at a given index
	 * 
	 * @param i
	 *            The index of the move's X coord
	 * @return The X coord of a particular move
	 */
	public int getX(int i) {
		return getMove(i).getX();
	}

	/**
	 * Get the Y coordinate for the move at a given index
	 * 
	 * @param i
	 *            The index of the move's Y coord
	 * @return The Y coord of a particular move
	 */
	public int getY(int i) {
		return getMove(i).getY();
	}

	/**
	 * Affix a location to the front of the route i.e move it to position 0
	 * 
	 * @param x
	 *            The x coord of the move
	 * @param y
	 *            The y coord of the move
	 */
	public void setFirstMove(int x, int y) {
		moves.add(0, new Move(x, y));
	}

	/**
	 * Prevent duplicates in the route. Check whether a given by its coords move
	 * is already present in the route
	 * 
	 * @param x
	 *            The X coord of the step to check for
	 * @param y
	 *            The Y coord of the step to check for
	 * @return True if the path contains the given step
	 */
	public boolean has(int x, int y) {
		if (moves.contains(new Move(x, y))) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Get the route size = the number of moves = the number of items in the
	 * Array List
	 * 
	 * Should be useful, so as to know which index can the moves be obtained up
	 * to and thus avoid NullPointerExceptions
	 * 
	 * @return The number of moves in this route
	 */
	@Override
	public int getLength() {
		return moves.size();
	}

	/**
	 * Return the route
	 * 
	 * @return The route
	 */
	@Override
	public ArrayList<IMove> getRoute() {
		return moves;
	}

	@Override
	public boolean routeChanged() {
		return true;
	}

	@Override
	public IMove getNextMove() {
		// TODO Implement method
		return null;
	}

	@Override
	public void setRoute(ArrayList<IMove> route) {
		// Trying to avoid making a copy of a list, so that there are not only pointers.
		// to the objects but the objects themselves - truly independent lists.  
		// Otherwise, if we change an element in the copied List, it will be changed
		// in the original list too.
		for(int i=0; i<moves.size(); i++) {
			route.add(moves.get(i));
		}
	}

	/**
	 * Set a move to a given position in the route
	 * 
	 * @param i
	 *            The index of the move to change
	 * @param move
	 *            The new move
	 */
	@Override
	public void setMove(int i, IMove move) {
		moves.set(i, move);
	}

}
