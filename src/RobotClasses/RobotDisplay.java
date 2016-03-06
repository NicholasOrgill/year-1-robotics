package RobotClasses;

import java.util.Observable;
import java.util.Observer;
import lejos.nxt.Button;
import lejos.util.Delay;

public class RobotDisplay implements Runnable, Observer{
	
	private String itemName;
	private int itemCount;
	private int count;
	
	public RobotDisplay(){
		count = 0;
		
		//TESTING PURPOSES ONLY
		itemName = "banana";
		itemCount = 3;
	}

	@Override
	public void run() {
		//To be changed. in what format is the info for
		//items and item amount going to be given?
		//ie. 3 banana 2 oranges 1 apple etc.
		// or will it be in the form of 2 arrays
		//eg. 3 2 1
		//	banana orage apple
		//and i'll have to loop over the array to display
		// the info? or something else entirely different?
		System.out.println("Required: " + itemCount + "x " + itemName);
		Delay.msDelay(5000);
		
		while(count != itemCount){
			Button.waitForAnyPress();
			count++;
			
			if(count == itemCount){
				System.out.println("All items loaded.");
				//need to notify something? TODO
			}
		}
	}
	
	public String getItemName(){ //to be change/unneeded
		return itemName;
	}
	
	public int getItemCount(){//to be change/unneeded
		return itemCount;
	}
	
	public void setItemName(){ //to be change/unneeded
	//	itemName = //from Message to be received
	}
	
	public void setItemCount(){//to be change/unneeded
	//	itemCount = //from Message to be received
	}

	@Override
	public void update(Observable o, Object arg) {
		setItemName();
		setItemCount();
	}
}