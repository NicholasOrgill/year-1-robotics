package WarehouseInterface;

import java.awt.Color;
import java.awt.Graphics2D;

public class RouteDraw {
	
	private int[] xPoints;
	private int[] yPoints;
	
	public RouteDraw(int[] xPoints, int[] yPoints)
	{
		this.xPoints = xPoints;
		this.yPoints = yPoints;
	}
	
	public void draw(Graphics2D g)
	{
		g.setColor(Color.RED);
		g.drawPolyline(xPoints, yPoints, xPoints.length);
	}
}
