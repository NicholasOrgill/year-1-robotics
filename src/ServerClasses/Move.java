package ServerClasses;

import interfaces.IMove;

public class Move implements IMove {
	private int direction;
	
	public Move (int _direction) {
		direction = _direction;
	}

	@Override
	public int getDirection() {
		return direction;
	}

	@Override
	public void setDirection(int _direction) {
		direction = _direction;
	}

}
