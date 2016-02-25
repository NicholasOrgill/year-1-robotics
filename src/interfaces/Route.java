package interfaces;

import java.util.ArrayList;

public interface Route {
	public ArrayList<Move> getRoute();
	public boolean routeChanged();
	public Move getNextMove();
	public void changeRoute(ArrayList<Move> moves);
	public void setMove(int i, Move mv);
}
