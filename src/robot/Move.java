package robot;

/**
 * Represents a move that a robot should execute.
 */
public final class Move {

	/**
	 * The type of move.
	 */
	public enum Type {
		MOVE_FORWARD, TURN_LEFT, TURN_RIGHT, TURN_AROUND
	}

	/**
	 * Constructs a new forward Move with the given amount of units in grid
	 * tiles.
	 *
	 * @param units
	 *            the number of units to move forward for.
	 * @return the constructed Move object
	 */
	public static Move forward(int units) {
		return new Move(Type.MOVE_FORWARD, units);
	}

	/**
	 * Constructs a new Move that tells the robot to turn left.
	 *
	 * @return the constructed Move object
	 */
	public static Move turnLeft() {
		return new Move(Type.TURN_LEFT);
	}

	/**
	 * Constructs a new Move that tells the robot to turn right.
	 *
	 * @return the constructed Move object
	 */
	public static Move turnRight() {
		return new Move(Type.TURN_RIGHT);
	}

	/**
	 * Constructs a new Move that tells the robot to turn around.
	 *
	 * @return the constructed Move object
	 */
	public static Move turnAround() {
		return new Move(Type.TURN_AROUND);
	}

	/**
	 * The type of this move.
	 */
	public final Type type;

	private final Optional<Integer> units;

	private Move(Type type) {
		this.type = type;
		this.units = Optional.empty();
	}

	private Move(Type type, int units) {
		this.type = type;
		this.units = Optional.of(units);
	}

	/**
	 * Returns the number of units to move forward for.
	 *
	 * @return the number of units to move forward for
	 */
	public int getUnits() {
		return this.units.get();
	}
}
