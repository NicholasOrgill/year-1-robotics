package RobotClasses;
import RobotClasses.RobotObserver;
import lejos.nxt.Button;
import lejos.util.Delay;

public class RobotDisplay implements Runnable{
	
	RobotObserver ro = new RobotObserver();
	private int count;
	
	@Override
	public void run(){
		System.out.println("Required: " + ro.getItemCount() + "x " + ro.getItemName());
		System.out.println("");
		System.out.println("To load an item once, please press the middle orange button.");
		System.out.println("If the robot is in the wrong location, please press the bottom dark grey button.");
		Delay.msDelay(5000);
		
		Button.waitForAnyPress();
		if(Button.readButtons() == Button.ID_ESCAPE){
			System.out.println("The robot is in the wrong location.");
		}else if(Button.readButtons() == Button.ID_ENTER){
			count++;
			System.out.println("Required: " + ro.getItemCount() + "x " + ro.getItemName());
			System.out.println(count + " " + ro.getItemName() + " has been loaded.");
			Delay.msDelay(5000);
			while(count != ro.getItemCount()){
				Button.ENTER.waitForPressAndRelease();
				count++;
				if(count == 1){
					System.out.println("Required: " + ro.getItemCount() + "x " + ro.getItemName());
					System.out.println(count + " " + ro.getItemName() + " has been loaded.");
					Delay.msDelay(5000);
				}else{
					System.out.println("Required: " + ro.getItemCount() + "x " + ro.getItemName());
					System.out.println(count + " " + ro.getItemName() + "s have been loaded.");
					Delay.msDelay(5000);
				}
		
				if(count == ro.getItemCount()){
					System.out.println("Items loaded.");
					Delay.msDelay(5000);
					//need to notify something? TODO
				}
			}
		}
	}
}