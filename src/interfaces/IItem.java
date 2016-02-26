package interfaces;

import rp.robotics.navigation.GridPose;

public interface IItem {

	/**
	 * Get the name of the item
	 * 
	 * @return The items name
	 */
	public String getName();

	/**
	 * Set the name of the item
	 * 
	 * @param _name
	 *            The new name of the item
	 */
	public void setName(String _name);

	/**
	 * Get the reward for the item
	 * 
	 * @return The items reward
	 */
	public int getReward();

	/**
	 * Set the reward for the item
	 * 
	 * @param _reward
	 *            The reward for the item
	 */
	public void setReward(int _reward);

	/**
	 * Get the weight of the item
	 * 
	 * @return The weight of the item
	 */
	public double getWeight();

	/**
	 * Set the weight of the item
	 * 
	 * @param _weight
	 *            The new weight of the item
	 */
	public void setWeight(double _weight);

	/**
	 * Get the position of the item on the grid
	 * 
	 * @return The position of the item on the grid
	 */
	public GridPose getPose();

	/**
	 * Set the position of the item on the grid
	 * 
	 * @param _pose
	 *            The new position of the item
	 */
	public void setPose(GridPose _pose);

}
