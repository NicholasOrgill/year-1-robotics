package ServerClasses;

import java.util.ArrayList;

import interfaces.IJob;
import interfaces.IPick;
import interfaces.JobState;
import interfaces.PickState;

public class Job implements IJob {

	private ArrayList<IPick> picks;
	private JobState state;
	private int jobID;

	public Job(int _jobID, ArrayList<IPick> _picks) {
		jobID = _jobID;
		picks = _picks;
		state = JobState.NOT_STARTED;
	}

	@Override
	public ArrayList<IPick> getPicks() {
		return picks;
	}

	@Override
	public void setPicks(ArrayList<IPick> _picks) {
		picks = _picks;
	}

	@Override
	public double getReward() {
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

	public int getJobID() {
		return jobID;
	}

	public void setJobID(int jobID) {
		this.jobID = jobID;
	}

}
