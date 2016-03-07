package interfaces;

public interface IMove {

	public static final int NORTH = 0;
	public static final int EAST  = 1;
	public static final int SOUTH = 2;
	public static final int WEST  = 3;
	
	public int getDirection();
	public void setDirection(int _direction);
	
}
