/**
 * 
 */
package ServerClasses;

import java.util.ArrayList;

import interfaces.IRoute;
import interfaces.IRoutePlanner;
import rp.robotics.navigation.GridPose;

public class RoutePlanner implements IRoutePlanner {

	@Override
	public IRoute getRoute(GridPose _p1, GridPose _p2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IRoute getRoute(ArrayList<GridPose> _ps) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getEuclidianDistance(GridPose _p1, GridPose _p2) {
		return Math.sqrt(Math.pow((_p2.getX() - _p1.getX()), 2) + Math.pow((_p2.getY() - _p1.getY()), 2));
	}

}
