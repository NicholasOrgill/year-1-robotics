package interfaces;

import java.util.ArrayList;

public interface IJob {

	/**
	 * Get the list of picks
	 * 
	 * @return The list of picks
	 */
	public ArrayList<IPick> getPicks();

	/**
	 * Set the list of picks
	 * 
	 * @param _picks
	 *            The list of picks
	 */
	public void setPicks(ArrayList<IPick> _picks);

	/**
	 * Get the total reward for the job
	 * 
	 * @return The reward for the job
	 */
	public double getReward();

	/**
	 * Get the job state
	 * 
	 * @return The job state
	 */
	public JobState getState();

	/**
	 * Set the job state
	 * 
	 * @param _complete
	 *            Whether the job is complete
	 */
	public void setState(JobState _jobState);

	/**
	 * Get the next unassigned pick
	 * 
	 * @return The next unassigned pick
	 */
	public IPick getNextUnassignedPick();

	/**
	 * Get the remaining unassigned picks for the job
	 * 
	 * @return The remaining unassigned picks
	 */
	public ArrayList<IPick> getUnassignedPicks();

}
