package ServerClasses;

import interfaces.IItem;
import interfaces.IPick;
import interfaces.PickState;
import rp.robotics.navigation.GridPose;

public class Pick implements IPick {

	private IItem item;
	private int amount;
	PickState state;
	double weight;
	double reward;
	
	public Pick(IItem item, int amount) {
		super();
		this.item = item;
		this.amount = amount;
		state = PickState.INACTIVE;
		weight = amount * item.getWeight();
		reward = amount * item.getReward();
	}

	@Override
	public IItem getItem() {
		return item;
	}

	@Override
	public void setItem(IItem _item) {
		item = _item;
	}

	@Override
	public double getWeight() {
		return weight;
	}
	
	@Override
	public double getReward() {
		return reward;
	}
	
	@Override
	public int getAmount() {
		return amount;
	}

	@Override
	public void setAmount(int _amount) {
		amount = _amount;
	}

	@Override
	public PickState getPickState() {
		return state;
	}

	@Override
	public void setPickState(PickState _pickState) {
		state = _pickState;
	}

	@Override
	public GridPose getPose() {
		return item.getPose();
	}

	@Override
	public void setPose(GridPose _pose) {
		item.setPose(_pose);
	}

	@Override
	public interfaces.GridPose getPose() {
		// TODO Auto-generated method stub
		return null;
	}

}
