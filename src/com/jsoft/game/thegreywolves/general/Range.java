package com.jsoft.game.thegreywolves.general;

public class Range {
	
	private int minRange;
	private int maxRange;
	private String message;
	
	public Range(int minR, int maxR, String message){
		this.minRange = minR;
		this.maxRange = maxR;
		this.message = message;
	}
	
	public int getMinRange() {
		return minRange;
	}
	public void setMinRange(int minRange) {
		this.minRange = minRange;
	}
	public int getMaxRange() {
		return maxRange;
	}
	public void setMaxRange(int maxRange) {
		this.maxRange = maxRange;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public boolean checkInRange(double range){
		
		int iRange = (int) Math.round(range);
		if(iRange>=minRange && iRange<maxRange){
			return true;
		}else{
			return false;
		}
	}

}
