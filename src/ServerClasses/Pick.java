package ServerClasses;

import interfaces.IItem;
import interfaces.IPick;
import interfaces.PickState;

public class Pick implements IPick {

	private IItem item;
	PickState state;

	@Override
	public IItem getItem() {
		return item;
	}

	@Override
	public void setItem(IItem _item) {
		item = _item;
	}

	@Override
	public int getReward() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getWeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getAmount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setAmount(int _amount) {
		// TODO Auto-generated method stub

	}

	@Override
	public PickState getPickState() {
		return state;
	}

	@Override
	public void setPickState(PickState _pickState) {
		state = _pickState;
	}

}
