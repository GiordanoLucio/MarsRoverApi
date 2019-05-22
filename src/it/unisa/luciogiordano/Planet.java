package it.unisa.luciogiordano;

import java.util.ArrayList;

public class Planet {

	int grid[][];
	ArrayList<Obstacle> obstacles= new ArrayList<Obstacle> ();
	
	public Planet() {
	}
	
	public Planet(int[][] grid) {
		this.grid = grid;
		this.obstacles=null;
	}
	
	public Planet(int[][] grid, ArrayList<Obstacle> obstacles) {
		this.grid= grid;
		this.obstacles = obstacles;
		for(Obstacle ob : obstacles) {
			setObstacle(ob.getX(), ob.getY());
		}
	}
	
	public int getSize() {
		return grid.length;
	}
	public boolean cellIsObstacle(int x, int y) {
		if(grid[x][y] == 0) {
			return false;
		}else {
			return true;
		}
	}
	
	private void setObstacle(int x, int y) {
		grid[x][y] = 1;
	}
	
}
