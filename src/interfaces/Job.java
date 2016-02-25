package interfaces;

import java.util.ArrayList;

public interface Job {

	public ArrayList<Pick> getPicks();
	public void            setPicks(ArrayList<Pick> _picks);
	
	public int getReward();
	
}
