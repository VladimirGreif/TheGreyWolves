package com.jsoft.game.thegreywolves.weapons;

import com.jsoft.game.thegreywolves.general.AUnit;

public abstract class Weapon {
	
	private double minFireRange = 0;
	private double maxFireRange = 10000;
	private double accuracy = 0;
	private double firePower = 0;
	private int numOfShell = 100;
	private AUnit board;
	private AUnit unitUnderUtack;
	private String name = "";
	
	public Weapon(AUnit u){
		board = u;
	}
	
	public abstract long fire();

	public AUnit getUnitUnderUtack() {
		return unitUnderUtack;
	}

	public void setUnitUnderUtack(AUnit unitUnderUtack) {
		this.unitUnderUtack = unitUnderUtack;
	}

	public AUnit getBoard() {
		return board;
	}

	public void setBoard(AUnit board) {
		this.board = board;
	}

	public double getMinFireRange() {
		return minFireRange;
	}

	public void setMinFireRange(double minFireRange) {
		this.minFireRange = minFireRange;
	}

	public double getMaxFireRange() {
		return maxFireRange;
	}

	public void setMaxFireRange(double maxFireRange) {
		this.maxFireRange = maxFireRange;
	}

	public double getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(double accuracy) {
		this.accuracy = accuracy;
	}

	public double getFirePower() {
		return firePower;
	}

	public void setFirePower(double firePower) {
		this.firePower = firePower;
	}

	public int getNumOfShell() {
		return numOfShell;
	}

	public void setNumOfShell(int numOfShell) {
		this.numOfShell = numOfShell;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
