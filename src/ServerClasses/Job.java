package ServerClasses;

import java.util.ArrayList;

import interfaces.IJob;
import interfaces.IPick;

public class Job implements IJob {

	private ArrayList<IPick> picks;

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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setComplete(boolean _complete) {
		// TODO Auto-generated method stub

	}

	@Override
	public IPick getNextUnassignedPick() {
		// TODO Auto-generated method stub
		return null;
	}

}
