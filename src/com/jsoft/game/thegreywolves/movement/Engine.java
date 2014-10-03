package com.jsoft.game.thegreywolves.movement;

import java.util.Random;

import com.jsoft.game.thegreywolves.general.Report;
import com.jsoft.game.thegreywolves.general.Unit;
import com.jsoft.game.thegreywolves.world.Arena;

public class Engine {
	
	private Random rand = new Random();
	private int deltaTime = 10 * 60;
	private double gradToRad = Math.PI/180;
	private double radToGrad = 180/Math.PI;
	
	public void generateStartPoint(Unit unit, double maxX, double maxY){
		unit.setCordinateX(randInt(0,(int)maxX));
		unit.setCordinateY(randInt(0,(int)maxY));
	}
	
	public Position checkPositions(Arena arena, Unit unit){

		double x = unit.getCordinateX() + unit.getSpeedMs()*deltaTime*Math.cos(unit.getKurs()*gradToRad);
		double y = unit.getCordinateY() + unit.getSpeedMs()*deltaTime*Math.sin(unit.getKurs()*gradToRad);
		
		unit.setCordinateX(x);
		unit.setCordinateY(y);

		for(Unit u:arena.getListOfPlayers()){
			if(u!=unit){
				double difX = Math.abs(u.getCordinateX() - unit.getCordinateX());
				double difY = Math.abs(u.getCordinateY() - unit.getCordinateY());
				double difZ = Math.abs(u.getCordinateH() - unit.getCordinateH());
				double distance  = Math.sqrt(difX*difX + difY*difY + difZ*difZ);
				//double azimut = az - kurs v uglah
				System.out.println(distance);
			}
		}
		
		return null;
	}
	
	public int randInt(int min, int max) {
		int randomNum = 0;
		for(int i = 0 ; i<5 ;i++){
			randomNum = rand.nextInt((max - min) + 1) + min;
		}
	    return randomNum;
	}

}
