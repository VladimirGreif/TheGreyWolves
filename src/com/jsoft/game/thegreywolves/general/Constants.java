package com.jsoft.game.thegreywolves.general;

import java.util.Random;

import com.jsoft.game.thegreywolves.world.Arena;

public class Constants {
	
	public static int deltaTime = 3 * 60;
	
	private static Random rand = new Random();
	
	public static double gradToRad = Math.PI/180;
	public static double radToGrad = 180/Math.PI;
	
	public static int randInt(int min, int max) {

		int randomNum = 0;
		for(int i = 0 ; i<5 ;i++){
			randomNum = rand.nextInt((max - min) + 1) + min;
		}
	    return randomNum;
	}
	
	public static long randLong() {
		long randomNum = 0;
		for(int i = 0 ; i<5 ;i++){
			randomNum = rand.nextLong();
		}
	    return randomNum;
	}
	
	public static void generateUnitsID(Arena arena, AUnit unit){
		long id = randLong();
		while(!checkIDS(id,arena)){
			id = randLong();
		}
		unit.setUnitId(id);	
	}
	
	public static boolean checkIDS(Long id,Arena arena){
		for(AUnit u:arena.getListOfPlayers()){
			if(u.getUnitId()==id){
				return false;
			}
		}
		return true;
	}

}
