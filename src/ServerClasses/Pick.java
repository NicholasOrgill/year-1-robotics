package ServerClasses;

import interfaces.IItem;
import interfaces.IPick;
import interfaces.PickState;
import rp.robotics.navigation.GridPose;

public class Pick implements IPick {

	private IItem item;
	private int amount;
	PickState state;

	public Pick(IItem _item, int _amount) {
		item = _item;
		amount = _amount;
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
	public double getReward() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getWeight() {
		// TODO Auto-generated method stub
		return 0;
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

}
