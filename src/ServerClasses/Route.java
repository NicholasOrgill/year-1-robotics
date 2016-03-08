package ServerClasses;

import java.util.ArrayList;

import interfaces.IMove;
import interfaces.IRoute;

public class Route implements IRoute {
	
	ArrayList<IMove> route;
	boolean routeChanged;
	
	public Route (ArrayList<IMove> _route) {
		route = _route;
	}

	@Override
	public ArrayList<IMove> getRoute() {
		// TODO Auto-generated method stub
		return route;
	}

	@Override
	public boolean routeChanged() {
		// TODO Auto-generated method stub
		boolean n = routeChanged;
		routeChanged = false;
		return n;
	}

	@Override
	public IMove getNextMove() {
		IMove nextMove = route.get(0);
		route.remove(0);
		return nextMove;
	}

	@Override
	public void setRoute(ArrayList<IMove> _route) {
		// TODO Auto-generated method stub
		route = _route;
		routeChanged = true;
	}

	@Override
	public void setMove(int _i, IMove _move) {
		// TODO Auto-generated method stub
		route.set(_i, _move);
		routeChanged = true;
	}

	@Override
	public int getLength() {
		// TODO Auto-generated method stub
		return route.size();
	}

}
