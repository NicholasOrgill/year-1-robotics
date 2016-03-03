package routePlan;

public class Grid {
	
	private int x,y;
	private float heur;
	private float cost;
	
	
	public Grid(int x, int y) {
		this.x=x;
		this.y=y;
	}


	public int getX() {
		return x;
	}


	public int getY() {
		return y;
	}
	
	public float getHeur() {
		return heur;
	}


	public void setHeur(float heur) {
		this.heur = heur;
	}


	public float getCost() {
		return cost;
	}
	
	
}
