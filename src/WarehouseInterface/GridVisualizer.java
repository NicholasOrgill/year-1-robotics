package WarehouseInterface;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import ServerClasses.Warehouse;
import interfaces.IRobot;
import rp.robotics.mapping.GridMap;

/**
 * 
 * This s a JPanel that will be responsible for displaying the warehouse map. At the moment it can display the grid and all the robots in their positions.
 *
 */
public class GridVisualizer extends JPanel implements Observer{
	
	//ToDo: add obstructions to GridMap to finish Visualiser
	private IRobot[] robots;
	private Warehouse warehouse;
	private GridMap map;
	private int xHeight;
	private int yHeight;
	private GridComponent gridC;
	
	public GridVisualizer(Warehouse _wareHouse)
	{
		super();
		
		ArrayList<IRobot> interRobots = warehouse.getRobots();
		robots = new IRobot[interRobots.size()];
		for(int i = 0; i < interRobots.size(); i++)
		{
			robots[i] = interRobots.get(i);
		}
		
		map = warehouse.getMap();
		xHeight = map.getXSize();
		yHeight = map.getYSize();
		
		gridC = new GridComponent(xHeight, yHeight, this.getWidth(), this.getWidth(), robots);
		add(gridC);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		gridC.repaint();
		add(gridC);
	}
	

}
