package routePlan;

/**
 * A class that computes the Manhattan distance between the two points with
 * their respective coords A better approach and not that resource intensive as
 * the Euclidean distance
 * 
 * Conventions I use in here:
 * delta denotes a rate of change/difference
 * 
 * @author Chris I 
 * XXIXIIMMXVI
 */
public class ManhattanHeur implements AStarHeur {

	/*
	 * (non-Javadoc)
	 * 
	 * @see routePlan.AStarHeur#getCost(int, int, int, int)
	 */
	@Override
	public float getCost(int x, int y, int gx, int gy) {

		//
		float deltaX = x - gx;

		//
		float deltaY = y - gy;

		return (float) (Math.abs(deltaX) + Math.abs(deltaY));
	}

}
