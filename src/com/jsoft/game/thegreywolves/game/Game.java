package com.jsoft.game.thegreywolves.game;

import com.jsoft.game.thegreywolves.general.AUnit;
import com.jsoft.game.thegreywolves.general.Constants;
import com.jsoft.game.thegreywolves.general.Coordinates;
import com.jsoft.game.thegreywolves.general.UnitConfiguration;
import com.jsoft.game.thegreywolves.general.UnitConfiguration.TYPE;
import com.jsoft.game.thegreywolves.world.Arena;

public class Game {
	
	private Arena arena = new Arena();
	private AUnit player;
	private static Game instance = new Game();
	
	
	private Game(){
		
	}
	
	public static Game getInstance(){
		return instance;
	}
	
	public void addPlayer(AUnit unit){
		Constants.generateUnitsID(arena, unit);
		arena.getListOfPlayers().add(unit);
	}
	
	public void printPlayers(){
		for(AUnit u : arena.getListOfPlayers()){
			Coordinates coordinates = u.getCoordinates();
			System.out.println(u.getUnitName());
			System.out.println("X = " + coordinates.getCoordinateX() + "  ;  Y = " + coordinates.getCoordinateY());
		}
	}
	
	public void turn(){
		player.move();
		player.checkPositions(arena);
		player.createReports();
	}

	public AUnit getPlayer() {
		return player;
	}

	public void setPlayer(AUnit player) {
		this.player = player;
	}

	public Arena getArena() {
		return arena;
	}

	public void setArena(Arena arena) {
		this.arena = arena;
	}
	
	public AUnit getUnitByID(long id){
		AUnit result = null;
		for(AUnit u:arena.getListOfPlayers()){
			if(u.getUnitId()==id){
				result = u;
				break;
			}
		}
		
		return result;
	}
	
	public UnitConfiguration getDestroerConfiguration(String name){
		UnitConfiguration dc = new UnitConfiguration();
		
		dc.setName(name);
		dc.setType(TYPE.DESTROER);
		dc.setMaxSpeedMs((int)(35 * UnitConfiguration.getConversionFromKnotsToMs()));
		dc.setVisibleRange(5000);
		dc.setVisualRange(5000);
		dc.setMaxSpeedDetectionRange(30000);
		dc.setArmor(10);
		dc.setHitPoints(100);
		dc.setSilentSpeed((int)(3 * UnitConfiguration.getConversionFromKnotsToMs()));
		dc.setViewObject("D:\\SpringProjects\\TheGreyWolves\\WICK40\\Wick40.obj");

		return dc;
	}
	
	public UnitConfiguration getSubmarineConfiguration(String name){
		UnitConfiguration dc = new UnitConfiguration();
		dc.setName(name);
		dc.setType(TYPE.SUBMARINE);
		dc.setMaxSpeedMs((int)(7.8 * UnitConfiguration.getConversionFromKnotsToMs()));
		dc.setVisibleRange(1000);
		dc.setVisualRange(5000);
		dc.setMaxSpeedDetectionRange(15000);
		dc.setArmor(10);
		dc.setHitPoints(100);
		dc.setSilentSpeed((int)(5 * UnitConfiguration.getConversionFromKnotsToMs()));
		dc.setViewObject("D:\\SpringProjects\\TheGreyWolves\\U48\\U48.obj");

		return dc;
	}
	
	public UnitConfiguration getCargoConfiguration(String name){
		UnitConfiguration dc = new UnitConfiguration();
		dc.setName(name);
		dc.setType(TYPE.CARGO);
		dc.setMaxSpeedMs((int)(10 * UnitConfiguration.getConversionFromKnotsToMs()));
		dc.setVisibleRange(15000);
		dc.setVisualRange(7000);
		dc.setMaxSpeedDetectionRange(90000);
		dc.setArmor(10);
		dc.setHitPoints(100);
		dc.setSilentSpeed((int)(1 * UnitConfiguration.getConversionFromKnotsToMs()));
		dc.setViewObject("D:\\SpringProjects\\TheGreyWolves\\FishingBoat\\msmunchen.obj");

		return dc;
	}

}
