package interfaces;

import java.awt.geom.Point2D;

public interface Item {
	
	public String getName();
	public void   setName(String _name);
	
	public int    getReward();
	public void   setReward(int _reward);
	
	public double getWeight();
	public void   setWeight(double _weight);
	
	public Point2D getPose();
	public void    setPose(Point2D _pose);
	
}
