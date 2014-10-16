package com.jsoft.game.thegreywolves.general;

public class Report {
	
	private String lostReport =  "Silents, No Contact!";
	
	
	private String EquipmentName = "";
	private String rangeReport = lostReport;
	private String speedReport = "";
	private int directionReport = 0;

	public int getDirectionReport() {
		return directionReport;
	}

	public void setDirectionReport(int directionReport) {
		this.directionReport = directionReport;
	}

	public String getEquipmentName() {
		return EquipmentName;
	}

	public void setEquipmentName(String equipmentName) {
		EquipmentName = equipmentName;
	}

	public String getLostReport() {
		return lostReport;
	}

	public void setLostReport(String lostReport) {
		this.lostReport = lostReport;
	}

	public String getRangeReport() {
		return rangeReport;
	}

	public void setRangeReport(String rangeReport) {
		this.rangeReport = rangeReport;
	}

	public String getSpeedReport() {
		return speedReport;
	}

	public void setSpeedReport(String speedReport) {
		this.speedReport = speedReport;
	}

}
