package ServerClasses;

import interfaces.Direction;
import interfaces.IMove;

public class Move implements IMove {
	private Direction direction;
	
	public Move (Direction _direction) {
		direction = _direction;
	}

	@Override
	public Direction getDirection() {
		return direction;
	}

	@Override
	public void setDirection(Direction _direction) {
		direction = _direction;
	}
	
	@Override
	public String toString() {
		return direction.toString(); 
	}

}
