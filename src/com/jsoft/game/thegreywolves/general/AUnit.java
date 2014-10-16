package com.jsoft.game.thegreywolves.general;

import java.util.ArrayList;

import com.jsoft.game.thegreywolves.general.UnitConfiguration.TYPE;
import com.jsoft.game.thegreywolves.movement.Position;
import com.jsoft.game.thegreywolves.world.Arena;

public abstract class AUnit {
	
	private long unitId;
	private boolean destroyed = false;
	private String unitName;
	private Navigation navigation;
	private Weapons weapons;
	private Equipments equipments;
	private UnitConfiguration configuration;
	private AUnit underAttack;
	
	
	private ArrayList<Position> positionList = new ArrayList<Position>();
	private ArrayList<Report> reports = new ArrayList<Report>();
	private ArrayList<AUnit> victimList = new ArrayList<AUnit>();
	private ArrayList<AUnit> visibleTargets = new ArrayList<AUnit>();
	
	
	public AUnit(String name, UnitConfiguration config){
		unitName = name;
		configuration = config;
		navigation = new Navigation();
	}

	public void move(){
		navigation.changePosition();
	}
	
	public void fire(){
		weapons.getActiveWeapon().fire();
	}

	public void createReports(){
		
		System.out.println("Create Report");

		reports.clear();
		visibleTargets.clear();
		
		equipments.detect();
		
		if(reports.size()==0) reports.add(new Report());
	}
	
	public Position getPositionByTargetID(long id){
		
		for(Position p:positionList){
			if(p.getTargetID()==id){
				return p;
			}
		}
		
		return null;
	}
	
	public void checkPositions(Arena arena){

		positionList.clear();
		
		Coordinates playerCoordinates = getCoordinates();
		
		for(AUnit u:arena.getListOfPlayers()){
			if(u!=this){
				
				Coordinates targetCoordinates = u.getCoordinates();

				Position p = new Position();
				
				double difX = Math.abs(targetCoordinates.getCoordinateX() - playerCoordinates.getCoordinateX());
				double difY = Math.abs(targetCoordinates.getCoordinateY() - playerCoordinates.getCoordinateY());
				double difZ = Math.abs(targetCoordinates.getCoordinateH() - playerCoordinates.getCoordinateH());

				double az = calculateAzTarget(u);

				double distance  = Math.sqrt(difX*difX + difY*difY + difZ*difZ);

				p.setDistance(distance);
				p.setAnglePosition(az);
				p.setDepthTargetPosition(targetCoordinates.getCoordinateH());
				p.setTargetID(u.getUnitId());
				positionList.add(p);
			}
		}
	}
	
	public double calculateAzTarget(AUnit u){
		
		Coordinates playerCoordinates = getCoordinates();
		Coordinates targetCoordinates = u.getCoordinates();
		
		double az_u = Math.atan2(targetCoordinates.getCoordinateY()-playerCoordinates.getCoordinateY(),targetCoordinates.getCoordinateX()-playerCoordinates.getCoordinateX());
		az_u -= Math.PI/2.0;
		az_u = az_u * Constants.radToGrad * (-1);
	    if (az_u < 0) {
	    	az_u += 360;
	    }

	    double az_target = az_u - getDirection();	
	    
	    if (az_target < 0) {
	    	az_target += 360;
	    }
	    az_target = Math.abs(az_target);
		return az_target;
	}

	public Coordinates getCoordinates() {
		return navigation.getCoordinates();
	}
	
	public int getDirection(){
		return navigation.getDirection();
	}
	
	public void setDirection(int direction){
		navigation.setDirection(direction);
	}

	public long getUnitId() {
		return unitId;
	}

	public void setUnitId(long unitId) {
		this.unitId = unitId;
	}

	public String getUnitName() {
		return unitName;
	}

	public ArrayList<Position> getPositionList() {
		return positionList;
	}

	public ArrayList<Report> getReports() {
		return reports;
	}

	public ArrayList<AUnit> getVictimList() {
		return victimList;
	}

	public Weapons getWeapons() {
		return weapons;
	}

	public void setWeapons(Weapons weapons) {
		this.weapons = weapons;
	}

	public UnitConfiguration getConfiguration() {
		return configuration;
	}
	
	public int getSpeedMs(){
		return navigation.getSpeedMs();
	}
	
	public void setSpeedMs(int speedMs){
		navigation.setSpeedMs(speedMs);
	}

	public ArrayList<AUnit> getVisibleTargets() {
		return visibleTargets;
	}

	public boolean isDestroyed() {
		return destroyed;
	}

	public void setDestroyed(boolean destroyed) {
		this.destroyed = destroyed;
	}

	public Equipments getEquipments() {
		return equipments;
	}

	public void setEquipments(Equipments equipments) {
		this.equipments = equipments;
	}
	
	public TYPE getType(){
		return configuration.getType();
	}
	
	public AUnit getUnderAttack() {
		return underAttack;
	}
	
	public void setUnderAttack(AUnit underAttack) {
		this.underAttack = underAttack;
		if(weapons!=null){
			getWeapons().setUnitUnderAtack(underAttack);
		}		
	}
	
}
