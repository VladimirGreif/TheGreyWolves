package com.jsoft.game.thegreywolves.general;

public abstract class Unit {
	
	public enum TYPE{
		DESTROER,
		SUBMARINE,
		NON
	}
	
	private TYPE type = TYPE.NON;
	private String name = "";
	private double maxSpeedMs = 100;
	private double speedMs = 0;
	private double cordinateX = 0;
	private double cordinateY = 0;
	private double cordinateH = 0;
	private double vX = 0;
	private double vY = 0;
	private double kurs = 0;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public TYPE getType() {
		return type;
	}
	public void setType(TYPE type) {
		this.type = type;
	}
	public double getMaxSpeedMs() {
		return maxSpeedMs;
	}
	public void setMaxSpeedMs(double maxSpeedMs) {
		this.maxSpeedMs = maxSpeedMs;
	}
	public double getSpeedMs() {
		return speedMs;
	}
	public void setSpeedMs(double speedMs) {
		this.speedMs = speedMs;
	}
	public double getCordinateX() {
		return cordinateX;
	}
	public void setCordinateX(double cordinateX) {
		this.cordinateX = cordinateX;
	}
	public double getCordinateY() {
		return cordinateY;
	}
	public void setCordinateY(double cordinateY) {
		this.cordinateY = cordinateY;
	}
	public double getCordinateH() {
		return cordinateH;
	}
	public void setCordinateH(double cordinateH) {
		this.cordinateH = cordinateH;
	}
	public double getvX() {
		return vX;
	}
	public void setvX(double vX) {
		this.vX = vX;
	}
	public double getvY() {
		return vY;
	}
	public void setvY(double vY) {
		this.vY = vY;
	}
	public double getKurs() {
		return kurs;
	}
	public void setKurs(double kurs) {
		this.kurs = kurs;
	}
	
}
