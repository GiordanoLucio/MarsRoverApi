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
		this.direction = direction.toUpperCase();
	}
	public Rover (int x, int y, String direction, Planet planet) throws InvalidInputException {
		this.x = x;
		this.y = y;
		this.direction = direction.toUpperCase();
		
		if(x>planet.getSize()-1) {
			throw new InvalidInputException();
		}else {
			this.planet = planet;
		}}

	private String turn(String direct) throws InvalidInputException {
		if(direct == "l") {
			if(direction == "N")
				this.direction = "W";
			else if(direction == "W")
				this.direction ="S";
			else if(direction == "S")
				this.direction = "E";
			else if(direction == "E")
				this.direction = "N";
		}else if(direct == "r") {
			if(direction == "N")
				this.direction = "E";
			else if(direction == "W")
				this.direction = "N";
			else if(direction == "S")
				this.direction = "W";
			else if(direction == "E")
				this.direction = "S";
		}else {
			throw new InvalidInputException();
		}

		return "("+Integer.toString(x)+","+Integer.toString(y)+","+direction+")";
	}


	public String move(String s) throws InvalidInputException{
		String obstaclesFound ="";
		for (int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			checkMove(""+c);
		}
		for(int i =0; i<obstacles.size();i++) {
			if(!obstaclesFound.contains((obstacles.get(i)).getCoordinates())){
				obstaclesFound += obstacles.get(i).getCoordinates();
			}
		}
		return  status() + obstaclesFound;
	}

	private String checkMove(String s) throws InvalidInputException {
		if(s.equals("f")) {
			return moveForward();
		}else if(s.equals("b")) {
			return moveBackward();
		}else if(s.equals("r")) {
			return turn("r");
		}else if(s.equals("l")) {
			return turn("l");
		}else {
			throw new InvalidInputException();
		}
	}


	private String moveForward() {
		int saveY = this.y;
		int saveX = this.x;
		if(direction == "S") {
			if(y == 0) {
				y=planet.getSize()-1;
			}else {
				y -= 1;
			}
		}else if(direction == "W") {
			if( x == 0) {
				x = planet.getSize()-1;
			}else {
				x -= 1;
			}
		}else if(direction == "N") {
			if(y == planet.getSize()-1) {
				y = 0;
			}else {
				y += 1;
			}
		}else if(direction == "E") {
			if(x == planet.getSize()-1) {
				x = 0;
			}else {
				x += 1;
			}
		}
		if(planet.cellIsObstacle(x, y)){
			obstacles.add(new Obstacle(x,y));
			x=saveX;
			y=saveY;
			return "("+Integer.toString(saveX)+","+Integer.toString(saveY)+","+direction+")";
		}else {
			return "("+Integer.toString(x)+","+Integer.toString(y)+","+direction+")";
		}
	}
	
	private String moveBackward() {
		int saveY=this.y;
		int saveX=this.x;
		if(direction == "S") {
			if(y == planet.getSize()-1) {
				y = 0;
			}else {
				y += 1;
			}
		}else if(direction == "W") {
			if( x == planet.getSize()-1) {
				x = 0;
			}else {
				x += 1;
			}
		}else if(direction == "N") {
			if(y == 0) {
				y = planet.getSize()-1;
			}else {
				y -= 1;
			}
		}else if(direction == "E") {
			if(x == 0) {
				x = planet.getSize()-1;
			}else {
				x -= 1;
			}
		}
		if(planet.cellIsObstacle(x, y)){
			obstacles.add(new Obstacle(x,y));
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

	private String status() {
		return "("+Integer.toString(x) +","+Integer.toString(y)+","+direction+")";
	}
}
