package WarehouseInterface;

import java.util.ArrayList;

import interfaces.IMove;

public class RoutePlotter {

	public static int[] xPlot(int[] points, ArrayList<IMove> moves)
	{
		//points needs to have one more slot than moves
		int iniX = points[0];
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
						points[i] = iniX++;					
						break;
					}
					case IMove.WEST:
					{
						points[i] = iniX--;
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
	
	public static int[] yPlot(int[] points, ArrayList<IMove> moves)
	{
		//points needs to have one more slot than moves
		int iniY = points[0];
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
						points[i] = iniY++;					
						break;
					}
					case IMove.SOUTH:
					{
						points[i] = iniY--;
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
