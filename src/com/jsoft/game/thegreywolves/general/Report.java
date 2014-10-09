package com.jsoft.game.thegreywolves.general;

import java.util.ArrayList;

public class Report {
	
	static private ArrayList<Range> RANGE_LIST = new ArrayList<Range>();
	
	private String lostReport =  "Silents, No Contact!";
	
	static{
		RANGE_LIST.add(new Range(100,500,"WARNING VERY CLOSE!"));
		RANGE_LIST.add(new Range(500,1500,"WARNING CLOSE!"));
		RANGE_LIST.add(new Range(1500,5000,"MEDIUM RANGE"));
		RANGE_LIST.add(new Range(5000,15000,"FAR AWAY"));
		RANGE_LIST.add(new Range(10000,20000,"HARDLY BUT CAN HEAR"));
	}
	
	private boolean sonarContact = false;
	private String rangeReport = lostReport;
	private int directionReport = 0;

	public int getDirectionReport() {
		return directionReport;
	}

	public void setDirectionReport(int directionReport) {
		this.directionReport = directionReport;
	}

	public static ArrayList<Range> getRANGE_LIST() {
		return RANGE_LIST;
	}

	public static void setRANGE_LIST(ArrayList<Range> rANGE_LIST) {
		RANGE_LIST = rANGE_LIST;
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

	public boolean isSonarContact() {
		return sonarContact;
	}

	public void setSonarContact(boolean sonarContact) {
		this.sonarContact = sonarContact;
	}
	
	

//	
//	public enum SPEED{
//		VERY_SLOW(0,3),
//		SLOW(3,7),
//		MIDDLE(7,15),
//		FAST(5000,10000),
//		VERY_FAST(10000,1000000);
//	}

}
