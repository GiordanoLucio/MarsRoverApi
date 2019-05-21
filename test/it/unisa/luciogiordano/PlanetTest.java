package it.unisa.luciogiordano;

import static org.junit.Assert.*;

import org.junit.Test;

public class PlanetTest {

	@Test
	public void test() {
		int grid[][] = new int[10][10];
		Planet planet = new Planet(grid);
		assertFalse(planet.cellIsObstacle(5,5));
	}
	@Test
	public void getPlanetSize() {
		int grid[][] = new int[10][10];
		Planet planet = new Planet(grid);
		assertEquals(planet.getSize(), 10);
	}

}
