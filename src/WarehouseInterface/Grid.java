package WarehouseInterface;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

public class Grid {

	private int xNumber;
	private int yNumber;
	private double xHeight;
	private double yHeight;
	private double xSpace;
	private double ySpace;
	
	public Grid(int xNumber, int yNumber, double xHeight, double yHeight)
	{
		this.xNumber = xNumber;
		this.yNumber = yNumber;
		this.xHeight = xHeight;
		this.yHeight = yHeight;
		
		xSpace = xHeight / (xNumber - 1.0);
		ySpace = yHeight / (yNumber - 1.0);
	}
	
	
	public void draw(Graphics2D g)
	{
		g.setColor(Color.BLACK);
		g.setStroke(new BasicStroke(2.0f));
		//draw vertical lines
		for(int i = 0; i < xNumber; i++)
		{
			g.draw(new Line2D.Double((i * xSpace), 0.0, (i * xSpace)  , yHeight));
		}
		//draw horizontal lines
		for(int i = 0; i < yNumber; i++)
		{
			g.draw(new Line2D.Double(0.0, (i * ySpace), xHeight  , (i * ySpace)));
		}
	}
}
