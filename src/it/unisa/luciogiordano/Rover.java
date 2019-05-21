package it.unisa.luciogiordano;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import it.unisa.luciogiordano.InvalidInputException;

public class Rover {
	private int x,y;
	private String direction;
	Planet planet = new Planet();

	ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();
	public Rover() {
		land();
	}
	public Rover(int x, int y, String direction) {
		this.x = x;
		this.y = y;
		this.direction = direction;
	}
	public Rover (int x, int y, String direction, Planet planet) throws InvalidInputException {
		this.x = x;
		this.y = y;
		this.direction = direction;
		if(x>planet.getSize()-1) {
			throw new InvalidInputException();
		}else {
			this.planet = planet;
		}}

	public String turn(String direct) throws InvalidInputException {
		if(direct == "l") {
			if(direction == "n" || direction == "N")
				this.direction = "w";
			else if(direction == "w" || direction == "W")
				this.direction ="s";
			else if(direction == "s" || direction == "S")
				this.direction = "e";
			else if(direction == "e" || direction == "E")
				this.direction = "n";
		}else if(direct == "r") {
			if(direction == "n" || direction == "N")
				this.direction = "e";
			else if(direction == "w" || direction == "W")
				this.direction = "n";
			else if(direction == "s" || direction == "S")
				this.direction = "w";
			else if(direction == "e" || direction == "E")
				this.direction = "s";
		}else {
			throw new InvalidInputException();
		}

		return "("+Integer.toString(x)+","+Integer.toString(y)+","+direction+")";
	}


	public String moreMoves(String s) throws InvalidInputException{
		String obstaclesFound ="";

		for (int i = 0; i < s.length()-1; i++){
			char c = s.charAt(i);
			move(""+c);
		}
		String stringToReturn = move(""+s.charAt(s.length()-1));


		for(int i =0; i<obstacles.size();i++) {
			if(!obstaclesFound.contains((obstacles.get(i)).getCoordinates())){
				obstaclesFound += obstacles.get(i).getCoordinates();
			}
		}
		/**for(Obstacle ob : obstacles) {
			if(!obstaclesFound.contains(ob.getCoordinates()))
				obstaclesFound += ob.getCoordinates();
		}*/
		return  stringToReturn + obstaclesFound;

	}

	public String move(String s) throws InvalidInputException {
		if(s.equals("f")) {
			return moveForward();
		}else if(s.equals("b")) {
			return moveBackward();
		}else if(s.equals("r")) {
			return turn("r");
		}else if(s.equals("l")) {
			return turn("l");
		}else {
			return "";
		}
	}


	public String moveForward() {
		int saveY = this.y;
		int saveX = this.x;
		if(direction == "s") {
			if(y == 0) {
				y=planet.getSize()-1;
			}else {
				y -= 1;
			}
		}else if(direction == "w") {
			if( x == 0) {
				x = planet.getSize()-1;
			}else {
				x -= 1;
			}
		}else if(direction == "n") {
			if(y == planet.getSize()-1) {
				y = 0;
			}else {
				y += 1;
			}
		}else if(direction == "e") {
			if(x == planet.getSize()-1) {
				x = 0;
			}else {
				x += 1;
			}
		}
		if(planet.cellIsObstacle(x, y)){
			obstacles.add(new Obstacle(x,y));
			//System.out.println(obstacles.size());
			x=saveX;
			y=saveY;
			return "("+Integer.toString(saveX)+","+Integer.toString(saveY)+","+direction+")";
		}else {
			return "("+Integer.toString(x)+","+Integer.toString(y)+","+direction+")";
		}
	}
	public String moveBackward() {
		int saveY=this.y;
		int saveX=this.x;

		if(direction == "s") {
			if(y == planet.getSize()) {
				y = 0;
			}else {
				y += 1;
			}
		}else if(direction == "w") {
			if( x == planet.getSize()-1) {
				x = 0;
			}else {
				x += 1;
			}
		}else if(direction == "n") {
			if(y == 0) {
				y = planet.getSize()-1;
			}else {
				y -= 1;
			}
		}else if(direction == "e") {
			if(x == 0) {
				x = planet.getSize()-1;
			}else {
				x -= 1;
			}
		}
		if(planet.cellIsObstacle(x, y)){
			obstacles.add(new Obstacle(x,y));
			//System.out.println(obstacles.size());
			x=saveX;
			y=saveY;
			return "("+Integer.toString(saveX)+","+Integer.toString(saveY)+","+direction+")";
		}else {
			return "("+Integer.toString(x)+","+Integer.toString(y)+","+direction+")";
		}

	}

	private void land() {
		this.x = 0;
		this.y = 0;
		this.direction = "N";
	}
	public String getCommand(String s) {
		if (s.equals("")) {
			return status();
		}
		return "";
	}
	private String status() {
		return "("+Integer.toString(x) +","+Integer.toString(y)+","+direction+")";
	}
}
