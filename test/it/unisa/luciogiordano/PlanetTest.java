package it.unisa.luciogiordano;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class PlanetTest {

	@Test
	public void testPlanetCreation() {
		int grid[][] = new int[10][10];
		Planet planet = new Planet(grid);
	}
	@Test
	public void getPlanetSize() {
		int grid[][] = new int[10][10];
		Planet planet = new Planet(grid);
		assertEquals(planet.getSize(), 10);
	}
	@Test
	public void testPlanetWithoutObstacle() {
		int grid[][] = new int[10][10];
		Planet planet = new Planet(grid);
		assertFalse(planet.cellIsObstacle(5,5));
	}

	@Test
	public void testPlanetWithObstacle() {
		int grid[][] = new int[10][10];
		grid[1][1] = 1;
		Planet planet = new Planet(grid);
		assertTrue(planet.cellIsObstacle(1,1));
	}
	
	@Test
	public void testPlanetWithListObstacle() {
		int grid[][] = new int[10][10];
		ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();
		obstacles.add(new Obstacle(1,1));
		obstacles.add(new Obstacle(1,2));
		Planet planet = new Planet(grid, obstacles);
		assertTrue(planet.cellIsObstacle(1,1));
		assertTrue(planet.cellIsObstacle(1,2));
	}
}
