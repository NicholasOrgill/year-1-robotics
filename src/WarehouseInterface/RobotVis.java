package WarehouseInterface;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;

import rp.robotics.navigation.GridPose;

public class RobotVis {
	
	private Rectangle2D.Double robot;
	private Double heading;
	
	public RobotVis(double x, double y, double length, double direction)
	{
		robot = new Rectangle2D.Double((x - (0.5 * length)), (y -(0.25 * length)), length, 0.5 * length);
		this.heading = direction;
	}
	
	public void draw(Graphics2D g)
	{
		g.setColor(Color.MAGENTA);
		Path2D.Double path = new Path2D.Double();
	    path.append(robot, false);
	    AffineTransform t = new AffineTransform();
	    t.rotate(heading);;
	    path.transform(t);
	    g.fill(path);
	}
	
}
