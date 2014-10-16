package com.jsoft.game.thegreywolves.movement;

public class Position {
	
	private double distance = 0;
	private double anglePosition = 0;
	private double depthTargetPosition = 0;
	private long targetID = 0;
	
	public long getTargetID() {
		return targetID;
	}
	public void setTargetID(long targetID) {
		this.targetID = targetID;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public double getAnglePosition() {
		return anglePosition;
	}
	public void setAnglePosition(double anglePosition) {
		this.anglePosition = anglePosition;
	}
	
	public double getDepthTargetPosition() {
		return depthTargetPosition;
	}
	public void setDepthTargetPosition(double depthTargetPosition) {
		this.depthTargetPosition = depthTargetPosition;
	}
	
	public void printPosition(){
		System.out.println("distance : " + distance);
		System.out.println("anglePosition : "+anglePosition);
	}

}
