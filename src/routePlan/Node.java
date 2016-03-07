package routePlan;

/**
 * A class that represents a single position on the grid given x and y
 * coordinates That single position also has a cost (which may be used to
 * prevent from choosing the wall as a valid move) , which is optional, and
 * heuristical cost, based on which decision are made in the other classes
 * 
 * @author Chris LIBDAYIIIMMXVI
 *
 */
public class Node {

	private int x, y;

	// heuristical cost
	private float heur;

	// The parent of a node, might come in handy when tracing back
	// to compile a route
	private Node parent;

	/**
	 * The position on the grid, specified by X and Y coords
	 * 
	 * @param x
	 *            The X coord of the location on the grid
	 * @param y
	 *            The Y coord of the location on the grid
	 */
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * A method to compare two nodes' heuristical costs
	 * 
	 * @param n
	 *            The node with which to compare
	 * @return 0 if they have the same heuristical cost
	 * 			-1 if the first node's cost is less than the second one's
	 * 			 1 if the first node's cost is greater than the second one's
	 */
	public int compareTo(Node n) {

		float costOfFirst = heur;
		float costOfSecond = n.heur;
		if (costOfFirst > costOfSecond) {
			return 1;
		}
		if (costOfFirst < costOfSecond) {
			return -1;
		} else {
			return 0;
		}
	}

	/**
	 * Get the X coordinate of a grid position
	 * 
	 * @return The X coord of the location on the grid
	 */
	public int getX() {
		return x;
	}

	/**
	 * Get the Y coordinate of a grid position
	 * 
	 * @return The Y coord of the location on the grid
	 */
	public int getY() {
		return y;
	}

	/**
	 * Get the heuristical value of a given position
	 * 
	 * @return The heuristical cost of the location on the grid
	 */
	public float getHeur() {
		return heur;
	}

	/**
	 * Set the heuristical cost to a new value Used during searching for a route
	 * 
	 * @param heur
	 *            The new heuristical value to be passed
	 */
	public void setHeur(float heur) {
		this.heur = heur;
	}

	/**
	 * Get the parent node of another node
	 * 
	 * @return The parent of a given node
	 */
	public Node getParent() {
		return parent;
	}

	/**
	 * Set who the parent of a given node is
	 * 
	 * @param parent
	 *            The parent of the node in question
	 */
	public void childOf(Node parent) {
		this.parent = parent;
	}

}
