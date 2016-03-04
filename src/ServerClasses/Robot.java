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
		return pose;
	}

	@Override
	public void setPose(GridPose _pose) {
		pose = _pose;
	}

	@Override
	public RobotState getState() {
		return state;
	}

	@Override
	public void setState(RobotState _state) {
		state = _state;
	}

	@Override
	public void assignPick(IPick _pick) {
		// TODO Auto-generated method stub

	}

	@Override
	public void assignPicks(ArrayList<IPick> _picks) {
		picks = _picks;
		setState(RobotState.WAITING_FOR_ROUTE);
	}

	@Override
	public IRoute getRoute() {
		return route;
	}

	@Override
	public void setRoute(IRoute _route) {
		route = _route;
	}

	@Override
	public ArrayList<IPick> getPicks() {
		return picks;
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
