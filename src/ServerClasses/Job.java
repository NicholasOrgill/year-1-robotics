package ServerClasses;

import java.util.ArrayList;

import interfaces.IJob;
import interfaces.IPick;
import interfaces.PickState;

public class Job implements IJob {

	private ArrayList<IPick> picks;
	private boolean complete;

	@Override
	public ArrayList<IPick> getPicks() {
		return picks;
	}

	@Override
	public void setPicks(ArrayList<IPick> _picks) {
		picks = _picks;
	}

	@Override
	public int getReward() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean getComplete() {
		return complete;
	}

	@Override
	public void setComplete(boolean _complete) {
		complete = _complete;
	}

	@Override
	public IPick getNextUnassignedPick() {
		for (IPick p : picks) {
			if (p.getPickState() == PickState.INACTIVE)
				return p;
		}
		setComplete(true);
		return null;
	}

}
