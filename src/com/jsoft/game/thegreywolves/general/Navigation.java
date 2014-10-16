package com.jsoft.game.thegreywolves.general;

public class Navigation {
	
	private Coordinates coordinates = new Coordinates();
	
	private int direction = 0;
	
	private int speedMs = 0;

	public Coordinates getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public int getSpeedMs() {
		return speedMs;
	}

	public void setSpeedMs(int speedMs) {
		this.speedMs = speedMs;
	}
	
	public void changePosition(){
		double x = coordinates.getCoordinateX() + speedMs*Constants.deltaTime*Math.sin(direction*Constants.gradToRad);
		double y = coordinates.getCoordinateY() + speedMs*Constants.deltaTime*Math.cos(direction*Constants.gradToRad);
		coordinates.setCoordinateX((int)x);
		coordinates.setCoordinateY((int)y);
		coordinates.printCoordinates();
	}
	
	public void generateStartPoint(double maxX, double maxY){
		coordinates.setCoordinateX(Constants.randInt(0,(int)maxX));
		coordinates.setCoordinateY(Constants.randInt(0,(int)maxY));
	}

}
