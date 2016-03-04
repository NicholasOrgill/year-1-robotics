package ServerClasses;

import interfaces.IItem;
import rp.robotics.navigation.GridPose;

public class Item implements IItem {

	private String name;
	private double reward;
	private double weight;
	
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

}
