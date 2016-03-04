package routePlan;

/**
 * A class that represents a single position on the grid given x and y coordinates
 * That single position also has a cost (which may be used to prevent from choosing the wall as a valid move)
 * , which is optional, and heuristical cost, based on which decision are made in the other classes
 * 
 * @author Chris
 * LIBDAYIIIMMXVI
 *
 */
public class Node {
	
	private int x,y;
	// heuristical cost
	private float heur;
	//[AMENDABLE - SUBJECT FOR REMOVAL IN THE FUTURE]
	// movement cost
	private float cost;
	
	
	/**
	 * The position on the grid, specified by X and Y coords
	 * @param x The X coord of the location on the grid
	 * @param y The Y coord of the location on the grid
	 */
	public Node(int x, int y) {
		this.x=x;
		this.y=y;
	}


	/**
	 * Get the X coordinate of a grid position
	 * @return The X coord of the location on the grid
	 */
	public int getX() {
		return x;
	}


	/**
	 * Get the Y coordinate of a grid position
	 * @return The Y coord of the location on the grid
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * Get the heuristical value of a given position
	 * @return The heuristical cost of the location on the grid
	 */
	public float getHeur() {
		return heur;
	}


	
	/**
	 * Set the heuristical cost to a new value
	 * Used during searching for a route
	 * @param heur The new heuristical value to be passed
	 */
	public void setHeur(float heur) {
		this.heur = heur;
	}


	/**
	 * Get the movement cost
	 * May act as a deterrent from walls if nothing better.
	 * @return The movement cost associated with moving to the specified position
	 */
	public float getCost() {
		return cost;
	}
	
	
}
