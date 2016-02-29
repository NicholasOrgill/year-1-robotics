package ServerClasses;

import java.util.ArrayList;

import interfaces.IJob;
import interfaces.IRobot;
import interfaces.IWarehouse;
import rp.robotics.mapping.GridMap;

public class Warehouse implements IWarehouse {

	private ArrayList<IJob> jobs;
	private ArrayList<IRobot> robots;
	private GridMap map;
	private boolean active;

	public Warehouse(ArrayList<IJob> _jobs, ArrayList<IRobot> _robots, GridMap _map){
		jobs = _jobs;
		robots = _robots;
		map = _map;
		active = true;
	}
	
	@Override
	public ArrayList<IRobot> getRobots() {
		return robots;
	}

	@Override
	public ArrayList<IJob> getJobs() {
		return jobs;
	}

	@Override
	public void setJobs(ArrayList<IJob> _jobs) {
		jobs = _jobs;
	}

	@Override
	public void addRobot(IRobot _robot) {
		robots.add(_robot);

	}

	@Override
	public IRobot getRobot(int _robotIndex) throws IndexOutOfBoundsException {
		return robots.get(_robotIndex);
	}

	@Override
	public GridMap getMap() {
		return map;
	}

	@Override
	public void setMap(GridMap _map) {
		map = _map;

	}

	@Override
	public int getRobotCount() {
		return robots.size();
	}

	@Override
	public int getJobCount() {
		return jobs.size();
	}

	@Override
	public boolean getActive() {
		return active;
	}

	@Override
	public void setActive(boolean _active) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public IJob getNextIncompleteJob() {
		for(IJob j : jobs){
			if (j.getComplete() == false) return j;
		}
		//TODO: if all jobs complete
		return null;
	}

}
