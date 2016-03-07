package interfaces;

import rp.robotics.navigation.GridPose;

public interface IPick {

	/**
	 * Get the item of the pick
	 * 
	 * @return The item in the pick
	 */
	public IItem getItem();

	/**
	 * Set the item for the pick
	 * 
	 * @param _item
	 *            The item for the pick
	 */
	public void setItem(IItem _item);

	/**
	 * Get the reward for the pick
	 * 
	 * @return The reward for the pick
	 */
	public int getReward();

	/**
	 * Get the total weight of the pick
	 * 
	 * @return The total weight of the pick
	 */
	public int getWeight();

	/**
	 * get the number of items in the pick
	 * 
	 * @return The number of items in the pick
	 */
	public int getAmount();

	/**
	 * Set the number of items in the pick
	 * 
	 * @param _amount
	 *            The number of items in the pick
	 */
	public void setAmount(int _amount);

	/**
	 * Get the state of the pick
	 * 
	 * @return the pick state
	 */
	public PickState getPickState();

	/**
	 * Set the state of the pick
	 * 
	 * @param _pickState
	 *            the new pick state
	 */
	public void setPickState(PickState _pickState);

	/**
	 * Get the location of the pick on the grid
	 * 
	 * @return The picks location
	 */
	public GridPose getPose();

	/**
	 * Set the position of the pick on the grid
	 * 
	 * @param _pose
	 */
	public void setPose(GridPose _pose);

}
