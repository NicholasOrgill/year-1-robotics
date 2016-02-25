package interfaces;

import java.util.ArrayList;

public interface Pick {

	public Item            getItem();
	public void            setItem(Item _item);
	
	public int             getReward();
	public int             getWeight();
	
	public int             getAmount();
	public void            setAmount();
	
	public ArrayList<Item> getItems();
	
}
