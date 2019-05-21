package it.unisa.luciogiordano;

public class Obstacle {
	private int x, y;

	public Obstacle(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public String getCoordinates() {
		return "("+x+","+y+")";
	}
	
}
