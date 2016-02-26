package robot;

public class Move {
	public enum Type { FORWARD, ROTATE }
	public enum Angle { LEFT, RIGHT, ONE_EIGHTY }
	
	public final Type type;
	
	private final int units;
	private final Angle angle;
	
	public static Move forward(int units) {
		return new Move(Type.FORWARD, units, Angle.LEFT);
	}
	
	public static Move rotate(Angle angle) {
		return new Move(Type.ROTATE, -1, angle);
	}
	
	private Move(Type type, int units, Angle angle) {
		this.type = type;
		this.units = units;
		this.angle = angle;
	}
	
	public int getUnits() { return this.units; }
	
	public Angle getAngle() { return this.angle; }
}
