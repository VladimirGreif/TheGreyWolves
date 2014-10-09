package com.jsoft.game.thegreywolves.general;

import java.util.ArrayList;

import com.jsoft.game.thegreywolves.movement.Position;

public abstract class Unit {
	
	public enum TYPE{
		DESTROER("Destoyer"),
		SUBMARINE("Submarine"),
		CARGO("Cargo"),
		NON("No Type");
		String description = "";
		public String getDescription(){
			return description;
		}
		TYPE(String desc){
			description = desc;
		}
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
	private ArrayList<Position> positionList = new ArrayList<Position>();
	private double sonarZone = 180;
	private double minSonarZone = 180;
	private ArrayList<Report> reports = new ArrayList<Report>();
	private boolean destroyed = false;
	private long unitId;
	private ArrayList<Unit> victimList = new ArrayList<Unit>();
	private double maxSonarRange = 100;
	private Weapons activeWeapon;
	
	public Weapons getActiveWeapon() {
		return activeWeapon;
	}

	public void setActiveWeapon(Weapons activeWeapon) {
		this.activeWeapon = activeWeapon;
	}

	public double getMaxSonarRange() {
		return maxSonarRange;
	}

	public void setMaxSonarRange(double maxSonarRange) {
		this.maxSonarRange = maxSonarRange;
	}

	public abstract void createReports();
	

	public ArrayList<Report> getReports() {
		return reports;
	}

	public ArrayList<Position> getPositionList() {
		return positionList;
	}

	public void setPositionList(ArrayList<Position> positionList) {
		this.positionList = positionList;
	}

	public ArrayList<Unit> getVictimList() {
		return victimList;
	}

	public void setVictimList(ArrayList<Unit> victimList) {
		this.victimList = victimList;
	}

	public long getUnitId() {
		return unitId;
	}

	public void setUnitId(long unitId) {
		this.unitId = unitId;
	}

	public boolean isDestroyed() {
		return destroyed;
	}

	public void setDestroyed(boolean destroyed) {
		this.destroyed = destroyed;
	}

	public void setReports(ArrayList<Report> reports) {
		this.reports = reports;
	}

	public double getMinSonarZone() {
		return minSonarZone;
	}

	public void setMinSonarZone(double minSonarZone) {
		this.minSonarZone = minSonarZone;
	}

	public double getSonarZone() {
		return sonarZone;
	}

	public void setSonarZone(double sonarZone) {
		this.sonarZone = sonarZone;
	}

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
