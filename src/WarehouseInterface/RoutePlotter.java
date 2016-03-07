package WarehouseInterface;

import java.util.ArrayList;

import interfaces.IMove;

public class RoutePlotter {

	public static int[] xPlot(int[] points, ArrayList<IMove> moves, double xSpace)
	{
		//points needs to have one more slot than moves
		int iniX = (int)(points[0] * xSpace);
		for(int i = 0; i < points.length; i++)
		{
			if(i == 0)
			{
				//do nothing. Done this way in case there are no moves.
			}
			else
			{
				switch(moves.get(i - 1).getDirection())
				{
					case IMove.EAST:
					{
						points[i] = (int)(iniX + xSpace);
						iniX = points[i];
						break;
					}
					case IMove.WEST:
					{
						points[i] = (int)(iniX - xSpace);
						iniX = points[i];
						break;
					}
					default:
					{
						points[i] = iniX;
						break;
					}
					
				}
				
			}
		}
		return points;
	}
	
	public static int[] yPlot(int[] points, ArrayList<IMove> moves, double ySpace)
	{
		//points needs to have one more slot than moves
		int iniY = (int)(points[0] * ySpace);
		for(int i = 0; i < points.length; i++)
		{
			if(i == 0)
			{
				//do nothing. Done this way in case there are no moves.
			}
			else
			{
				switch(moves.get(i - 1).getDirection())
				{
					case IMove.NORTH:
					{
						points[i] = (int)(iniY + ySpace);
						iniY = points[i];				
						break;
					}
					case IMove.SOUTH:
					{
						points[i] = (int)(iniY - ySpace);
						iniY = points[i];
						break;
					}
					default:
					{
						points[i] = iniY;
						break;
					}
					
				}
				
			}
		}
		return points;
	}
}
