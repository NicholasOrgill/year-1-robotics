package robot;

/**
 * Represents a move that a robot should execute.
 */
public class Move {

    /**
     * The type of move.
     */
    public enum Type {
        FORWARD, ROTATE
    }

    /**
     * The angle to turn for rotate moves.
     */
    public enum Angle {
        LEFT, RIGHT, ONE_EIGHTY
    }

    /**
     * The type of this move.
     */
    public final Type type;

    private final int units;
    private final Angle angle;

    /**
     * Constructs a new forward Move with the given amount of units in grid
     * tiles.
     *
     * @param units
     *            the number of units to move forward for.
     * @return the constructed Move object
     */
    public static Move forward(int units) {
        return new Move(Type.FORWARD, units, Angle.LEFT);
    }

    /**
     * Constructs a new rotate Move with the given angle.
     *
     * @param angle
     *            the angle to rotate for
     * @return the constructed Move object
     */
    public static Move rotate(Angle angle) {
        return new Move(Type.ROTATE, -1, angle);
    }

    private Move(Type type, int units, Angle angle) {
        this.type = type;
        this.units = units;
        this.angle = angle;
    }

    /**
     * Returns the number of units to move forward for.
     *
     * @return the number of units to move forward for
     */
    public int getUnits() {
        return this.units;
    }

    /**
     * Returns the angle to rotate for.
     *
     * @return the angle to rotate for
     */
    public Angle getAngle() {
        return this.angle;
    }
}
