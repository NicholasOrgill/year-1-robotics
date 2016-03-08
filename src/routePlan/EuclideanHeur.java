package routePlan;

/**
 * A class that computes the Euclidean distance between two coordinates. Should
 * not be appropriate in the given circumstances as closest location may be an
 * obstacle
 * 
 * Conventions I use in here: 
 * delta denotes a rate of change/difference
 * 
 * @author Chris I 
 * XXIXIIMMXVI
 *
 */
public class EuclideanHeur implements AStarHeur {

	/*
	 * (non-Javadoc)
	 * 
	 * @see routePlan.AStarHeur#getCost(int, int, int, int)
	 */
	@Override
	public float getCost(int x, int y, int gx, int gy) {

		// The difference between the X coords
		float deltaX = gx - x;

		// The difference between the Y coords
		float deltaY = gy - y;

		return (float) Math.sqrt(deltaX * deltaX + deltaY * deltaY);
	}

}
