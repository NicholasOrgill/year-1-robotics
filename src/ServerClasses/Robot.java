package ServerClasses;

import java.util.ArrayList;

import interfaces.IMessage;
import interfaces.IPick;
import interfaces.IRobot;
import interfaces.IRoute;
import interfaces.RobotState;
import rp.robotics.navigation.GridPose;

public class Robot implements IRobot {

	private RobotState state;
	private GridPose pose;
	private ArrayList<IPick> picks;
	private IRoute route;
	
	public Robot(){
		picks = new ArrayList<IPick>();
		state = RobotState.WAITING_FOR_PICKS;
	}
	
	@Override
	public GridPose getPose() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPose(GridPose _pose) {
		// TODO Auto-generated method stub

	}

	@Override
	public RobotState getState() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setState(RobotState _state) {
		// TODO Auto-generated method stub

	}

	@Override
	public void assignPick(IPick _pick) {
		// TODO Auto-generated method stub

	}

	@Override
	public void assignPicks(ArrayList<IPick> _picks) {
		// TODO Auto-generated method stub

	}

	@Override
	public IRoute getRoute() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setRoute(IRoute _route) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<IPick> getPicks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void sendMessage(IMessage _message) {
		// TODO Auto-generated method stub

	}

	@Override
	public IMessage receiveMessage() {
		// TODO Auto-generated method stub
		return null;
	}

}
