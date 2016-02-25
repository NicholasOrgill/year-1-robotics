package interfaces;

import java.awt.geom.Point2D;
import java.util.ArrayList;

public interface RoutePlanner {

	public Route getRoute(Point2D _p1, Point2D _p2);
	public void  assignRoute(ArrayList<Robot> _robots);
	
}
