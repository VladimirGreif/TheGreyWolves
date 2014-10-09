package com.jsoft.game.thegreywolves.movement;

import java.util.Random;

import com.jsoft.game.thegreywolves.general.Unit;
import com.jsoft.game.thegreywolves.world.Arena;

public class Engine {
	
	private Random rand = new Random();
	private int deltaTime = 3 * 60;
	private double gradToRad = Math.PI/180;
	private double radToGrad = 180/Math.PI;
	
	public void generateStartPoint(Unit unit, double maxX, double maxY){
		unit.setCordinateX(randInt(0,(int)maxX));
		unit.setCordinateY(randInt(0,(int)maxY));
	}
	
	public void checkPositions(Arena arena, Unit unit){

		moveUnit(unit);
		
		unit.getPositionList().clear();

		for(Unit u:arena.getListOfPlayers()){
			if(u!=unit && !u.isDestroyed()){

				Position p = new Position();
				
				double difX = Math.abs(u.getCordinateX() - unit.getCordinateX());
				double difY = Math.abs(u.getCordinateY() - unit.getCordinateY());
				double difZ = Math.abs(u.getCordinateH() - unit.getCordinateH());

				double az = calculateAzTarget(unit,u);

				double distance  = Math.sqrt(difX*difX + difY*difY + difZ*difZ);

				p.setDistance(distance);
				p.setAnglePosition(az);
				p.setDepthTargetPosition(u.getCordinateH());
				p.setTargetID(u.getUnitId());
				p.setTargetMaxRange(u.getSpeedMs() * u.getMaxSonarRange()/u.getMaxSpeedMs());
				unit.getPositionList().add(p);
			}
		}
	}
	
	public double calculateAzTarget(Unit player, Unit u){
		
		double az_u = Math.atan2(u.getCordinateY()-player.getCordinateY(),u.getCordinateX()-player.getCordinateX());
		az_u -= Math.PI/2.0;
		az_u = az_u * radToGrad * (-1);
	    if (az_u < 0) {
	    	az_u += 360;
	    }

	    double az_target = az_u - player.getKurs();	
	    
	    if (az_target < 0) {
	    	az_target += 360;
	    }
	    az_target = Math.abs(az_target);
		return az_target;
	}
	
	public void moveUnit(Unit unit){
		double x = unit.getCordinateX() + unit.getSpeedMs()*deltaTime*Math.sin(unit.getKurs()*gradToRad);
		double y = unit.getCordinateY() + unit.getSpeedMs()*deltaTime*Math.cos(unit.getKurs()*gradToRad);
		unit.setCordinateX(x);
		unit.setCordinateY(y);
	}
	
	public int randInt(int min, int max) {
		int randomNum = 0;
		for(int i = 0 ; i<5 ;i++){
			randomNum = rand.nextInt((max - min) + 1) + min;
		}
	    return randomNum;
	}
	
	public long randLong() {
		long randomNum = 0;
		for(int i = 0 ; i<5 ;i++){
			randomNum = rand.nextLong();
		}
	    return randomNum;
	}
	
	public void generateUnitsID(Arena arena, Unit unit){
		for(Unit u:arena.getListOfPlayers()){
			long id = randLong();
			while(!checkIDS(id,arena)){
				id = randLong();
			}
			unit.setUnitId(id);
		}
	}
	
	public boolean checkIDS(Long id,Arena arena){
		for(Unit u:arena.getListOfPlayers()){
			if(u.getUnitId()==id){
				return false;
			}
		}
		return true;
	}

}
