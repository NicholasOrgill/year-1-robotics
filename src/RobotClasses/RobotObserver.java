package RobotClasses;

import java.util.Observable;
import java.util.Observer;
import lejos.nxt.Button;
import lejos.util.Delay;

public class RobotObserver implements Observer{
	
	private String itemName;
	private int itemCount;
	private Connection connection;
	
	public RobotObserver(){
		
		//TESTING PURPOSES ONLY
		itemName = "banana";
		itemCount = 3;
	}

	public String getItemName(){
		return itemName;
	}
	
	public int getItemCount(){
		return itemCount;
	}
	
	//need a connection. method that can access what the message content says?
	public void setItemName(){
		//itemName = connection.getContent().substring(2);
	}
	
	public void setItemCount(){
		//String s = connection.getContent().substring(0, 0);		//need pick to be in format "3 banana"
		//itemCount = Integer.parseInt(s);
	}

	@Override
	public void update(Observable o, Object arg) {
		setItemName();
		setItemCount();
	}
}