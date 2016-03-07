package ServerClasses;

import interfaces.IItem;
import rp.robotics.navigation.GridPose;

public class Item implements IItem {

	private String name;
	private double reward;
	private double weight;
	private int xLocation;
	private int yLocation;
	
	public Item(String _name, double _reward, double _weight) {
		name = _name;
		reward = _reward;
		weight = _weight;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String _name) {
		name = _name;
	}

	@Override
	public double getReward() {
		return reward;
	}

	@Override
	public void setReward(double _reward) {
		reward = _reward;

	}

	@Override
	public double getWeight() {
		return weight;
	}

	@Override
	public void setWeight(double _weight) {
		weight = _weight;
	}

	@Override
	public GridPose getPose() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPose(GridPose _pose) {
		// TODO Auto-generated method stub

	}

	public int getxLocation() {
		return xLocation;
	}
	public int getyLocation() {
		return yLocation;
	}
	
	public int[] getLocation() {
		return new int[] {getxLocation(), getyLocation()};
	}
	
	public void setxLocation(int xLocation) {
		this.xLocation = xLocation;
	}

	public void setyLocation(int yLocation) {
		this.yLocation = yLocation;
	}
	
	public void setLocation (int xLocation, int yLocation) {
		this.xLocation = xLocation;
		this.yLocation = yLocation;
	}


	
}
