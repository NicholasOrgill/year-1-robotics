package ServerClasses;

import java.util.ArrayList;

import interfaces.IJob;
import interfaces.IRobot;
import interfaces.IWarehouse;
import rp.robotics.mapping.GridMap;

public class Warehouse implements IWarehouse {

	@Override
	public ArrayList<IRobot> getRobots() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<IJob> getJobs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setJobs(ArrayList<IJob> _jobs) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addRobot(IRobot _robot) {
		// TODO Auto-generated method stub

	}

	@Override
	public IRobot getRobot(int _robotIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GridMap getMap() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setMap(GridMap _map) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getRobotCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getJobCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean getActive() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public IJob getNextIncompleteJob() {
		// TODO Auto-generated method stub
		return null;
	}

}
