package interfaces;

import java.util.ArrayList;

import rp.robotics.mapping.GridMap;

public interface Warehouse {

	public ArrayList<Robot> getRobots();
	
	public ArrayList<Job>   getJobs();
	public void             setJobs(ArrayList<Job> _jobs);
	
	public void             addRobot(Robot _robot);
	public Robot            getRobot(int _robotIndex);
	
	public GridMap          getMap();
	public void             setMap();
	
}
