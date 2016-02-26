package interfaces;

import java.util.ArrayList;

public interface IRoute {

	/**
	 * Return the route
	 * 
	 * @return The route
	 */
	public ArrayList<IMove> getRoute();

	/**
	 * 
	 * @return
	 */
	public boolean routeChanged();

	/**
	 * Get the next move from the route
	 * 
	 * @return The next move
	 */
	public IMove getNextMove();

	/**
	 * Set the route
	 * 
	 * @param _route
	 *            The new route
	 */
	public void setRoute(ArrayList<IMove> _route);

	/**
	 * Set the ith move in the route
	 * 
	 * @param _i
	 *            The index of the move to change
	 * @param _move
	 *            The new move
	 */
	public void setMove(int _i, IMove _move);

	/**
	 * Get the length of the route
	 * 
	 * @return The route length
	 */
	public int getLength();
}
