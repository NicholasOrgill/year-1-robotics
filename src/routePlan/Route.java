package routePlan;

import java.util.ArrayList;

/**
 * The route to be passed, consisting of a sequence of moves from the starting location to the
 * goal
 * 
 * @author Chris I
 * XXIXIIMMXVI
 *
 */
public class Route {

	// An array list of the moves in the route
	private ArrayList<Move> moves = new ArrayList<Move>();

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

	// [PERHAPS] TODO Method to affix the starting position
	// as the first item in the array /index 0/

	/**
	 * Prevent duplicates in the route Check whether a given by its coords move
	 * is already present in the route
	 * 
	 * @param x
	 *            The X coord of the step to check for
	 * @param y
	 *            The Y coord of the step to check for
	 * @return True if the path contains the given step
	 */
	public boolean has(int x, int y) {
		if(moves.contains(new Move(x, y))) {
			return true;
		}
		else {
			return false;
		}
	}

}
