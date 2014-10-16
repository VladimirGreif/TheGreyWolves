package com.jsoft.game.thegreywolves.equipment;

import com.jsoft.game.thegreywolves.general.AUnit;

public abstract class Equipment {

	private AUnit board;
	
	private int minAngle = 180;
	private int maxAngle = 180;

	private int maxRange = 100000;
	private int minRange = 100000;
	
	private String[] rangeMessages = {"WARNING VERY CLOSE!",
			"WARNING CLOSE!",
			"MEDIUM RANGE",
			"FAR AWAY",
			"HARDLY BUT CAN HEAR"};
	
	private String[] speedMessages = {"Moving very slow",
			"Moving slow",
			"Moving fast",
			"Moving very fast"};
	
	public Equipment(AUnit u){
		board = u;
	}

	public abstract void detect();
	public abstract String getName();

	public AUnit getBoard() {
		return board;
	}

	public void setBoard(AUnit board) {
		this.board = board;
	}

	public int getMinAngle() {
		return minAngle;
	}
	public void setMinAngle(int minAngle) {
		this.minAngle = minAngle;
	}
	public int getMaxAngle() {
		return maxAngle;
	}
	public void setMaxAngle(int maxAngle) {
		this.maxAngle = maxAngle;
	}
	public int getMaxRange() {
		return maxRange;
	}
	public void setMaxRange(int maxRange) {
		this.maxRange = maxRange;
	}
	public int getMinRange() {
		return minRange;
	}
	public void setMinRange(int minRange) {
		this.minRange = minRange;
	}

	public String[] getRangeMessages() {
		return rangeMessages;
	}

	public void setRangeMessages(String[] rangeMessages) {
		this.rangeMessages = rangeMessages;
	}

	public String[] getSpeedMessages() {
		return speedMessages;
	}

	public void setSpeedMessages(String[] speedMessages) {
		this.speedMessages = speedMessages;
	}
	
	
}
