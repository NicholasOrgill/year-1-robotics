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
	private double weight;
	private double reward;
	
	public Job(int iD, ArrayList<IPick> picks) {
		super();
		jobID = iD;
		this.picks = picks;
		state = JobState.NOT_STARTED;
		for (int i = 0; i < picks.size(); i++) {
			weight = weight + picks.get(i).getWeight();
			reward = reward + picks.get(i).getReward();
		}
		
	}

	@Override
	public ArrayList<IPick> getPicks() {
		return picks;
	}

	@Override
	public void setPicks(ArrayList<IPick> _picks) {
		picks = _picks;
	}

	public double getWeight() {
		return weight;
	}
	
	public double getReward() {
		return reward;
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
