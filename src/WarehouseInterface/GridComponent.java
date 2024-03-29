package WarehouseInterface;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

import interfaces.IRobot;
import rp.robotics.navigation.Heading;

public class GridComponent extends JComponent {
	
	private Grid grid;
	private IRobot[] robots;
	private int xNumber, yNumber;
	private double xHeight, yHeight;
	
	public GridComponent(int xNumber, int yNumber, double xHeight, double yHeight, IRobot[] robots)
	{
		super();
		grid = new Grid(xNumber, yNumber, xHeight, yHeight);
		this.robots = robots;
		this.xNumber = xNumber;
		this.yNumber = yNumber;
		this.xHeight = xHeight;
		this.yHeight = yHeight;
	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D)g;
		
		grid.draw(g2);
		
		double xSpace = xHeight / (xNumber - 1.0);
		double ySpace = yHeight / (yNumber - 1.0);
		for(int i = 0; i < robots.length; i ++)
		{
			int x = robots[i].getPose().getX();
			int y = robots[i].getPose().getY();
			RobotVis robot = new RobotVis(x * xSpace, y * ySpace, Math.min(0.4 * xSpace, 0.4 * ySpace), 
					Heading.toDegrees(robots[i].getPose().getHeading()) * (Math.PI / 180.0));
			robot.draw(g2);
		}
		
	}

}
