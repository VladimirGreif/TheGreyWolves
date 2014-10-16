package com.jsoft.game.thegreywolves.general;

public class Coordinates {
	
	private int coordinateX = 0;
	private int coordinateY = 0;
	private int coordinateH = 0;
	
	public int getCoordinateX() {
		return coordinateX;
	}
	public void setCoordinateX(int coordinateX) {
		this.coordinateX = coordinateX;
	}
	public int getCoordinateY() {
		return coordinateY;
	}
	public void setCoordinateY(int coordinateY) {
		this.coordinateY = coordinateY;
	}
	public int getCoordinateH() {
		return coordinateH;
	}
	public void setCoordinateH(int coordinateH) {
		this.coordinateH = coordinateH;
	}
	
	public void printCoordinates(){
		System.out.println("X = " + coordinateX + " : Y = " + coordinateY);
	}

}
