package ServerClasses;

import interfaces.IItem;
import rp.robotics.navigation.GridPose;

public class Item implements IItem {

	private String name;
	private int reward;
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String _name) {
		name = _name;
	}

	@Override
	public int getReward() {
		return reward;
	}

	@Override
	public void setReward(int _reward) {
		// TODO Auto-generated method stub

	}

	@Override
	public double getWeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setWeight(double _weight) {
		// TODO Auto-generated method stub

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
