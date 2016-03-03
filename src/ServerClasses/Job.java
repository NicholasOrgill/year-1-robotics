package ServerClasses;

import java.util.ArrayList;

import interfaces.IJob;
import interfaces.IPick;
import interfaces.JobState;
import interfaces.PickState;

public class Job implements IJob {

	private ArrayList<IPick> picks;
	private JobState state;

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
	public IPick getNextUnassignedPick() {
		for (IPick p : picks) {
			if (p.getPickState() == PickState.INACTIVE)
				return p;
		}
		setState(JobState.FULLY_ASSIGNED);
		return null;
	}

	@Override
	public ArrayList<IPick> getUnassignedPicks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JobState getState() {
		return state;
	}

	@Override
	public void setState(JobState _jobState) {
		state = _jobState;
	}

}
