package it.unisa.luciogiordano;
import static org.junit.Assert.*;

import org.junit.Test;

public class ObstacleTest {

	@Test
	public void testGetCoordinates() {
		Obstacle obstacle = new Obstacle(1,1);
		assertEquals(obstacle.getCoordinates(), "(1,1)");
	}
}
