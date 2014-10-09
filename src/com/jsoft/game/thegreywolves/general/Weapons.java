package com.jsoft.game.thegreywolves.general;

public abstract class Weapons {
	private double minFireRange = 0;
	private double maxFireRange = 0;
	private double accuracy = 0;
	private double firePower = 0;
	private int numOfShell = 100;
	
	public abstract long fire();

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
	
}
