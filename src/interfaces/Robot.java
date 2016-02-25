package interfaces;

import java.util.ArrayList;

import rp.robotics.navigation.GridPose;

public interface Robot {
	
	public GridPose        getPose();
	public void            setPose(GridPose _pose);
	
	public RobotState      getState();
	public void            setState(RobotState _state);
	
	public Job             getJob();
	public void            setJob(Job _job);
	
	
	public Route           getRoute();
	public void            setRoute(Route _route);
	
	public ArrayList<Pick> getPicks();
	
	public void            sendMessage(Message _message);
	public Message         receiveMessage();

}
	