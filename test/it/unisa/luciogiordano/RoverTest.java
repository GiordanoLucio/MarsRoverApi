package it.unisa.luciogiordano;

import static org.junit.Assert.*;

import org.junit.Test;



public class RoverTest {

	@Test
	public void test() {
		Rover rover = new Rover();
	}

	@Test
	public void testEmptyCommand() throws InvalidInputException {
		Rover rover = new Rover();
		String output = rover.move("");
		String expected = "(0,0,N)";
		assertEquals(expected, output);
	}

	@Test
	public void testNewRoverConstructor() throws InvalidInputException{
		Rover rover = new Rover(0,0,"n");
	}

	@Test(expected=InvalidInputException.class)
	public void testRoverOutOfPlanetBound() throws InvalidInputException{
		int grid[][] = new int[10][10];
		Planet planet = new Planet(grid);
		Rover rover = new Rover(11, 11, "n", planet);
	}


	@Test(expected=InvalidInputException.class)
	public void testTurningException() throws InvalidInputException{
		Rover rover = new Rover();
		String changeDirection = rover.move("n");
	}

	@Test
	public void testTurningLeft() throws InvalidInputException {
		Rover rover = new Rover();
		String changeDirection = rover.move("l");
		String expectedOutput = "(0,0,W)";
		assertEquals(expectedOutput, rover.move(""));
	}
	@Test
	public void testTurningLeft2() throws InvalidInputException {
		Rover rover = new Rover();
		rover.move("l");
		String changeDirection = rover.move("l");
		String expectedOutput = "(0,0,S)";
		assertEquals(expectedOutput, rover.move(""));
	}
	@Test
	public void testTurningLeft3() throws InvalidInputException {
		Rover rover = new Rover();
		rover.move("l");rover.move("l");
		String changeDirection = rover.move("l");
		String expectedOutput = "(0,0,E)";
		assertEquals(expectedOutput, rover.move(""));
	}
	@Test
	public void testTurningLeft4() throws InvalidInputException {
		Rover rover = new Rover();
		rover.move("l");rover.move("l");rover.move("l");
		rover.move("l");
		
		String expectedOutput = "(0,0,N)";
		assertEquals(expectedOutput, rover.move(""));
	}
	@Test
	public void testTurningRight() throws InvalidInputException {
		Rover rover = new Rover();
		rover.move("r");
		String expectedOutput = "(0,0,E)";
		assertEquals(expectedOutput, rover.move(""));
	}
	@Test
	public void testTurningRight2() throws InvalidInputException {
		Rover rover = new Rover();
		rover.move("r");
		rover.move("r");
		String expectedOutput = "(0,0,S)";
		assertEquals(expectedOutput, rover.move(""));
	}
	@Test
	public void testTurningRight3() throws InvalidInputException {
		Rover rover = new Rover();
		rover.move("r");rover.move("r");
		rover.move("r");
		String expectedOutput = "(0,0,W)";
		assertEquals(expectedOutput, rover.move(""));
	}
	@Test
	public void testTurningRight4() throws InvalidInputException {
		Rover rover = new Rover();
		rover.move("r");rover.move("r");rover.move("r");
		rover.move("r");
		String expectedOutput = "(0,0,N)";
		assertEquals(expectedOutput, rover.move(""));
	}

	@Test
	public void testMovingForward() throws InvalidInputException{
		int x[][] = new int [10][10]; 
		Planet planet = new Planet(x);
		Rover rover = new Rover(9, 9, "N", planet);
		rover.move("f");
		String expectedOutput = "(9,0,N)";
		assertEquals(expectedOutput, rover.move(""));
	}
	@Test
	public void testMovingForwardSSouth() throws InvalidInputException{
		int x[][] = new int [10][10]; 
		Planet planet = new Planet(x);
		Rover rover = new Rover(9, 0, "S", planet);
		rover.move("f");
		String expectedOutput = "(9,9,S)";
		assertEquals(expectedOutput, rover.move(""));
	}
	
	@Test
	public void testMovingForwardEEast() throws InvalidInputException{
		int x[][] = new int [10][10]; 
		Planet planet = new Planet(x);
		Rover rover = new Rover(9, 9, "E", planet);
		rover.move("f");
		String expectedOutput = "(0,9,E)";
		assertEquals(expectedOutput, rover.move(""));
	}
	
	
	@Test
	public void testMovingForwardYIs0() throws InvalidInputException{
		int x[][] = new int [10][10]; 
		Planet planet = new Planet(x);
		Rover rover = new Rover(9, 0, "E", planet);
		rover.move("f");
		String expectedOutput = "(0,0,E)";
		assertEquals(expectedOutput, rover.move(""));
	}
	@Test
	public void testMovingForwardWestIs10() throws InvalidInputException{
		int x[][] = new int [10][10]; 
		Planet planet = new Planet(x);
		Rover rover = new Rover(9, 0, "W", planet);
		rover.move("f");
		String expectedOutput = "(8,0,W)";
		assertEquals(expectedOutput, rover.move(""));
	}
	@Test
	public void testMovingForwardWestIs0() throws InvalidInputException{
		int x[][] = new int [10][10]; 
		Planet planet = new Planet(x);
		Rover rover = new Rover(0, 0, "W", planet);
		String moveForward = rover.move("f");
		String expectedOutput = "(9,0,W)";
		assertEquals(expectedOutput, rover.move(""));
	}

	@Test
	public void testMovingForwardEastIs10() throws InvalidInputException{
		int x[][] = new int [10][10]; 
		Planet planet = new Planet(x);
		Rover rover = new Rover(0, 0, "E", planet);
		String moveForward = rover.move("f");
		String expectedOutput = "(1,0,E)";
		assertEquals(expectedOutput, rover.move(""));
	}

	@Test
	public void testMovingBackward() throws InvalidInputException{
		int x[][] = new int [10][10]; 
		Planet planet = new Planet(x);
		Rover rover = new Rover(5, 8, "E", planet);
		rover.move("b");
		assertEquals(rover.move(""), "(4,8,E)");	
	}

	@Test
	public void testMovingBackwardY() throws InvalidInputException{
		int x[][] = new int [10][10]; 
		Planet planet = new Planet(x);
		Rover rover = new Rover(4, 9, "S", planet);
		rover.move("b");
		assertEquals(rover.move(""), "(4,0,S)");	
	}
	@Test
	public void testMovingBackwardWTurn() throws InvalidInputException{
		int x[][] = new int [10][10]; 
		Planet planet = new Planet(x);
		Rover rover = new Rover(9, 9, "W", planet);
		rover.move("b");
		assertEquals(rover.move(""), "(0,9,W)");	
	}
	@Test
	public void testMovingBackwardW() throws InvalidInputException{
		int x[][] = new int [10][10]; 
		Planet planet = new Planet(x);
		Rover rover = new Rover(5, 9, "W", planet);
		String expe = rover.move("b");
		assertEquals(expe, "(6,9,W)");	
	}
	@Test
	public void testMovingBackwardE() throws InvalidInputException{
		int x[][] = new int [10][10]; 
		Planet planet = new Planet(x);
		Rover rover = new Rover(9, 9, "E", planet);
		String expe = rover.move("b");
		assertEquals(expe, "(8,9,E)");	
	}


	@Test
	public void testCombinedMovement() throws InvalidInputException{
		int x[][] = new int [10][10]; 
		Planet planet = new Planet(x);
		Rover rover = new Rover(0, 0, "N", planet);
		rover.move("f");
		String expe = rover.move("f");
		assertEquals(expe, "(0,2,N)");	
	}
	@Test
	public void testCombinedMovementBackward() throws InvalidInputException{
		int x[][] = new int [10][10]; 
		Planet planet = new Planet(x);
		Rover rover = new Rover(3, 3, "N", planet);
		rover.move("b");
		String expe = rover.move("b");
		assertEquals(expe, "(3,1,N)");	
	}
	@Test
	public void testCombinedMovementBackward3() throws InvalidInputException{
		int x[][] = new int [10][10]; 
		Planet planet = new Planet(x);
		Rover rover = new Rover(3, 3, "N", planet);

		rover.move("bbbb");
		assertEquals("(3,9,N)", rover.move(""));	
	}

	@Test
	public void testCombinedMovementFfrff() throws InvalidInputException{
		int x[][] = new int [10][10]; 
		Planet planet = new Planet(x);
		Rover rover = new Rover(0, 0, "N", planet);
		rover.move("ffrff");

		assertEquals("(2,2,E)",rover.move(""));	
	}
	@Test
	public void testCombinedMovementFfrffTogether() throws InvalidInputException{
		int x[][] = new int [10][10]; 
		Planet planet = new Planet(x);
		Rover rover = new Rover(0, 0, "N", planet);
		String expe =rover.move("ffrff");
		assertEquals(expe, "(2,2,E)");	

	}
	@Test
	public void testCombinedMovementFflffTogether() throws InvalidInputException{
		int x[][] = new int [10][10]; 
		Planet planet = new Planet(x);
		Rover rover = new Rover(0, 0, "N", planet);
		String expe =rover.move("fflff");
		assertEquals(expe, "(8,2,W)");	
	}

	@Test
	public void testWrapping() throws InvalidInputException{
		int x[][] = new int [10][10];
		Planet planet = new Planet(x);
		Rover rover = new Rover(0,0, "N", planet);
		String expe = rover.move("b");
		assertEquals(expe, "(0,9,N)");
	}

	@Test
	public void testNoEncounterObstacle() throws InvalidInputException{
		int x[][] = new int[10][10];
		Planet planet = new Planet(x);
		Rover rover = new Rover(0,0,"N", planet);
		String expe = rover.move("frfl");
		assertEquals(expe, "(1,1,N)");
	}
	@Test
	public void testEncounterSingleObstacle() throws InvalidInputException{
		int x[][] = new int[10][10];
		x[1][1] = 1;
		Planet planet = new Planet(x);
		Rover rover = new Rover(0,0,"N", planet);
		String expe = rover.move("frfflf");
		assertEquals(""+expe, "(0,2,N)(1,1)");
	}

	@Test
	public void testEncounterSingleObstacle2() throws InvalidInputException{
		int x[][] = new int[10][10];
		x[2][2] = 1;
		x[1][3] = 1;
		Planet planet = new Planet(x);
		Rover rover = new Rover(0,0,"N", planet);
		String expe = rover.move("ffrfflf");
		assertEquals(expe, "(1,2,N)(2,2)(1,3)");
	}
	@Test
	public void testEncounterMultipleObstacle() throws InvalidInputException{
		int x[][] = new int[10][10];
		x[1][1] = 1;
		x[0][2] = 1;
		Planet planet = new Planet(x);
		Rover rover = new Rover(0,0,"N", planet);
		String expe = rover.move("ffrff");
		assertEquals(expe, "(0,1,E)(0,2)(1,1)");
	}

	@Test
	public void testEncounterMultipleObstacle2() throws InvalidInputException{
		int x[][] = new int[10][10];
		x[2][2] = 1;
		x[2][1] = 1;
		Planet planet = new Planet(x);
		Rover rover = new Rover(0,0,"N", planet);
		String expe = rover.move("ffrfffrflf");
		assertEquals(expe, "(1,1,E)(2,2)(2,1)");
	}
	@Test
	public void testWrappingAndObstacles() throws InvalidInputException{
		int x[][] = new int[10][10];
		x[0][9] = 1;
		Planet planet = new Planet(x);
		Rover rover = new Rover(0,0,"N", planet);
		String expe = rover.move("b");
		assertEquals(expe, "(0,0,N)(0,9)");
	}

	@Test
	public void testATourAroundThePlanet() throws InvalidInputException{
		int x[][] = new int[6][6];
		x[2][2] = 1;
		x[0][5] = 1;
		x[5][0] = 1;
		Planet planet = new Planet(x);
		Rover rover = new Rover(0,0,"N", planet);
		String expe = rover.move("ffrfffrbbblllfrfrbbl");
		assertEquals(expe, "(0,0,N)(2,2)(0,5)(5,0)");
	}
	@Test
	public void testSingleMovementObstacle() throws InvalidInputException{
		int x[][] = new int[2][2];
		x[0][1] = 1;
		Planet planet = new Planet(x);
		Rover rover = new Rover(0,0,"N", planet);
		assertEquals("(0,0,N)(0,1)", rover.move("f"));
	}
	
	@Test(expected = InvalidInputException.class)
	public void testMoreMoves() throws InvalidInputException{
		int x[][] = new int[6][6];
		x[2][2] = 1;
		x[0][5] = 1;
		x[5][0] = 1;
		Planet planet = new Planet(x);
		Rover rover = new Rover(0,0,"N", planet);
		String expe = rover.move("ffrfffrbbblllfrfrbbl aasf");
	}
	



}
