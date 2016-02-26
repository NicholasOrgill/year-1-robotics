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
	public int getReward();

	/**
	 * Get whether the job is complete
	 * 
	 * @return Whether the job is complete
	 */
	public boolean getComplete();

	/**
	 * Set whether the job is complete
	 * 
	 * @param _complete
	 *            Whether the job is complete
	 */
	public void setComplete(boolean _complete);

	/**
	 * Get the next unassigned pick
	 * 
	 * @return The next unassigned pick
	 */
	public IPick getNextUnassignedPick();

}
