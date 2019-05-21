package it.unisa.luciogiordano;

import static org.junit.Assert.*;

import org.junit.Test;



public class RoverTest {

	@Test
	public void test() {
		Rover rover = new Rover();
	}

	@Test
	public void testEmptyCommand() {
		Rover rover = new Rover();
		String output = rover.getCommand("");
		String expected = "(0,0,N)";
		assertEquals(expected, output);
	}

	@Test(expected=InvalidInputException.class)
	public void testTurningException() throws InvalidInputException{
		Rover rover = new Rover();
		String changeDirection = rover.turn("n");
	}

	@Test
	public void testTurningLeft() throws InvalidInputException {
		Rover rover = new Rover();
		String changeDirection = rover.turn("l");
		String expectedOutput = "(0,0,w)";

		assertEquals(changeDirection, expectedOutput);
	}
	@Test
	public void testTurningRight() throws InvalidInputException {
		Rover rover = new Rover();
		String changeDirection = rover.turn("r");
		String expectedOutput = "(0,0,e)";

		assertEquals(changeDirection, expectedOutput);
	}
	@Test
	public void testTurningTwoRight() throws InvalidInputException {
		Rover rover = new Rover();
		String changeDirection = rover.turn("r");
		String changeDirection2 = rover.turn("r");
		String expectedOutput = "(0,0,e)";
		String expectedOutput2 = "(0,0,s)";
		assertEquals(changeDirection2, expectedOutput2);
	}
	@Test
	public void testMovingForward() throws InvalidInputException{
		int x[][] = new int [10][10]; 
		Planet planet = new Planet(x);
		Rover rover = new Rover(9, 9, "n", planet);
		String moveForward = rover.moveForward();
		String expectedOutput = "(9,0,n)";
		assertEquals(expectedOutput, moveForward);
	}
	@Test
	public void testMovingForwardYIs0() throws InvalidInputException{
		int x[][] = new int [10][10]; 
		Planet planet = new Planet(x);
		Rover rover = new Rover(9, 0, "n", planet);
		String moveForward = rover.moveForward();
		String expectedOutput = "(9,1,n)";
		assertEquals(expectedOutput, moveForward);
	}
	@Test
	public void testMovingForwardWestIs10() throws InvalidInputException{
		int x[][] = new int [10][10]; 
		Planet planet = new Planet(x);
		Rover rover = new Rover(9, 0, "w", planet);
		String moveForward = rover.moveForward();
		String expectedOutput = "(8,0,w)";
		assertEquals(expectedOutput, moveForward);
	}
	@Test
	public void testMovingForwardWestIs0() throws InvalidInputException{
		int x[][] = new int [10][10]; 
		Planet planet = new Planet(x);
		Rover rover = new Rover(0, 0, "w", planet);
		String moveForward = rover.moveForward();
		String expectedOutput = "(9,0,w)";
		assertEquals(expectedOutput, moveForward);
	}

	@Test
	public void testMovingForwardEastIs10() throws InvalidInputException{
		int x[][] = new int [10][10]; 
		Planet planet = new Planet(x);
		Rover rover = new Rover(0, 0, "e", planet);
		String moveForward = rover.moveForward();
		String expectedOutput = "(1,0,e)";
		assertEquals(expectedOutput, moveForward);
	}

	@Test
	public void testCombinedMovement() throws InvalidInputException{
		int x[][] = new int [10][10]; 
		Planet planet = new Planet(x);
		Rover rover = new Rover(0, 0, "n", planet);
		rover.moveForward();
		String expe = rover.moveForward();
		assertEquals(expe, "(0,2,n)");	
	}
	@Test
	public void testCombinedMovementBackward() throws InvalidInputException{
		int x[][] = new int [10][10]; 
		Planet planet = new Planet(x);
		Rover rover = new Rover(3, 3, "n", planet);
		rover.move("b");
		String expe = rover.move("b");
		assertEquals(expe, "(3,1,n)");	
	}
	@Test
	public void testCombinedMovementBackward3() throws InvalidInputException{
		int x[][] = new int [10][10]; 
		Planet planet = new Planet(x);
		Rover rover = new Rover(3, 3, "n", planet);
		rover.move("b");
		rover.move("b");rover.move("b");
		String expe = rover.move("b");
		assertEquals(expe, "(3,9,n)");	
	}

	@Test
	public void testCombinedMovementFfrff() throws InvalidInputException{
		int x[][] = new int [10][10]; 
		Planet planet = new Planet(x);
		Rover rover = new Rover(0, 0, "n", planet);
		rover.move("f");
		rover.move("f");
		rover.move("r");
		rover.move("f");

		String expe = rover.move("f");
		assertEquals(expe, "(2,2,e)");	
	}
	@Test
	public void testCombinedMovementFfrffTogether() throws InvalidInputException{
		int x[][] = new int [10][10]; 
		Planet planet = new Planet(x);
		Rover rover = new Rover(0, 0, "n", planet);
		String expe =rover.moreMoves("ffrff");
		assertEquals(expe, "(2,2,e)");	

	}
	@Test
	public void testCombinedMovementFflffTogether() throws InvalidInputException{
		int x[][] = new int [10][10]; 
		Planet planet = new Planet(x);
		Rover rover = new Rover(0, 0, "n", planet);
		String expe =rover.moreMoves("fflff");
		assertEquals(expe, "(8,2,w)");	
	}
	
	@Test
	public void testWrapping() throws InvalidInputException{
		int x[][] = new int [10][10];
		Planet planet = new Planet(x);
		Rover rover = new Rover(0,0, "n", planet);
		String expe = rover.moreMoves("b");
		assertEquals(expe, "(0,9,n)");
	}
	
	@Test
	public void testNoEncounterObstacle() throws InvalidInputException{
		int x[][] = new int[10][10];
		Planet planet = new Planet(x);
		Rover rover = new Rover(0,0,"n", planet);
		String expe = rover.moreMoves("frfl");
		assertEquals(expe, "(1,1,n)");
	}
	@Test
	public void testEncounterSingleObstacle() throws InvalidInputException{
		int x[][] = new int[10][10];
		x[1][1] = 1;
		Planet planet = new Planet(x);
		Rover rover = new Rover(0,0,"n", planet);
		String expe = rover.moreMoves("frfflf");
		assertEquals(""+expe, "(0,2,n)(1,1)");
	}
	
	@Test
	public void testEncounterSingleObstacle2() throws InvalidInputException{
		int x[][] = new int[10][10];
		x[2][2] = 1;
		x[1][3] = 1;
		Planet planet = new Planet(x);
		Rover rover = new Rover(0,0,"n", planet);
		String expe = rover.moreMoves("ffrfflf");
		assertEquals(expe, "(1,2,n)(2,2)(1,3)");
	}
	@Test
	public void testEncounterMultipleObstacle() throws InvalidInputException{
		int x[][] = new int[10][10];
		x[1][1] = 1;
		x[0][2] = 1;
		Planet planet = new Planet(x);
		Rover rover = new Rover(0,0,"n", planet);
		String expe = rover.moreMoves("ffrff");
		assertEquals(expe, "(0,1,e)(0,2)(1,1)");
	}
	
	@Test
	public void testEncounterMultipleObstacle2() throws InvalidInputException{
		int x[][] = new int[10][10];
		x[2][2] = 1;
		x[2][1] = 1;
		Planet planet = new Planet(x);
		Rover rover = new Rover(0,0,"n", planet);
		String expe = rover.moreMoves("ffrfffrflf");
		assertEquals(expe, "(1,1,e)(2,2)(2,1)");
	}
	@Test
	public void testWrappingAndObstacles() throws InvalidInputException{
		int x[][] = new int[10][10];
		x[0][9] = 1;
		Planet planet = new Planet(x);
		Rover rover = new Rover(0,0,"n", planet);
		String expe = rover.moreMoves("b");
		assertEquals(expe, "(0,0,n)(0,9)");
	}
	
	@Test
	public void testATourAroundThePlanet() throws InvalidInputException{
		int x[][] = new int[6][6];
		x[2][2] = 1;
		x[0][5] = 1;
		x[5][0] = 1;
		Planet planet = new Planet(x);
		Rover rover = new Rover(0,0,"n", planet);
		String expe = rover.moreMoves("ffrfffrbbblllfrfrbbl");
		assertEquals(expe, "(0,0,n)(2,2)(0,5)(5,0)");
	}
	
	
	
	}
