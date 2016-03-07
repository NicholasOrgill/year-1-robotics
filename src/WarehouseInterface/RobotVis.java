package WarehouseInterface;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;
import javax.swing.JLabel;

import rp.robotics.navigation.GridPose;

public class RobotVis {
	
	private Rectangle2D.Double robot;
	private Double heading;
	private int label;
	
	public RobotVis(double x, double y, double length, double direction, int i)
	{
		robot = new Rectangle2D.Double((x - (0.5 * length)), (y -(0.25 * length)), length, 0.5 * length);
		this.heading = direction;
		label = i;
	}
	
	public void draw(Graphics2D g)
	{
		g.setColor(Color.GRAY);
		Path2D.Double path = new Path2D.Double();
	    path.append(robot, false);
	    AffineTransform t = new AffineTransform();
	    t.rotate(Math.toRadians(heading), robot.getX() + robot.width/2, robot.getY() + robot.height/2);
	    path.transform(t);
	    g.fill(path);
	    g.setColor(Color.WHITE);
	    g.drawString(String.valueOf(label), (float)((robot.getX() + robot.width/2.0) - 4.0), (float)((robot.getY() + robot.height/2.0) + 3.0));
	}
	
}
