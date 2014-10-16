package com.jsoft.game.thegreywolves.general;

public class UnitConfiguration {
	
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
	
	public static double conversionFromKnotsToMs = 0.514444;
	
	private TYPE type = TYPE.NON;
	
	private String name = "";

	private int maxSpeedMs = 100;
	
	private int maxSpeedDetectionRange = 100000;
	private int silentSpeed = 5;

	private int visibleRange = 5000;
	private int visualRange = 5000;
	
	private int armor;
	
	private int hitPoints;
	
	private String viewObject = "";


	public static double getConversionFromKnotsToMs() {
		return conversionFromKnotsToMs;
	}

	public static void setConversionFromKnotsToMs(double conversionFromKnotsToMs) {
		UnitConfiguration.conversionFromKnotsToMs = conversionFromKnotsToMs;
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

	public int getMaxSpeedMs() {
		return maxSpeedMs;
	}

	public void setMaxSpeedMs(int maxSpeedMs) {
		this.maxSpeedMs = maxSpeedMs;
	}

	public int getMaxSpeedDetectionRange() {
		return maxSpeedDetectionRange;
	}

	public void setMaxSpeedDetectionRange(int maxSpeedDetectionRange) {
		this.maxSpeedDetectionRange = maxSpeedDetectionRange;
	}

	public int getSilentSpeed() {
		return silentSpeed;
	}

	public void setSilentSpeed(int silentSpeed) {
		this.silentSpeed = silentSpeed;
	}

	public int getVisibleRange() {
		return visibleRange;
	}

	public void setVisibleRange(int visibleRange) {
		this.visibleRange = visibleRange;
	}

	public int getVisualRange() {
		return visualRange;
	}

	public void setVisualRange(int visualRange) {
		this.visualRange = visualRange;
	}

	public int getArmor() {
		return armor;
	}

	public void setArmor(int armor) {
		this.armor = armor;
	}

	public int getHitPoints() {
		return hitPoints;
	}

	public void setHitPoints(int hitPoints) {
		this.hitPoints = hitPoints;
	}

	public String getViewObject() {
		return viewObject;
	}

	public void setViewObject(String viewObject) {
		this.viewObject = viewObject;
	}

}
