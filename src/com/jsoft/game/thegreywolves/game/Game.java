package com.jsoft.game.thegreywolves.game;

import com.jsoft.game.thegreywolves.general.Unit;
import com.jsoft.game.thegreywolves.general.Unit.TYPE;
import com.jsoft.game.thegreywolves.movement.Engine;
import com.jsoft.game.thegreywolves.movement.Position;
import com.jsoft.game.thegreywolves.world.Arena;

public class Game {
	
	private Arena arena = new Arena();
	private Engine engine = new Engine();
	private Unit player;
	private static Game instance = new Game();
	
	private Game(){
		
	}
	
	public static Game getInstance(){
		return instance;
	}
	
	public void addPlayer(Unit unit){
		
		engine.generateUnitsID(arena,unit);
		
//		engine.generateStartPoint(unit, arena.getSize().getWidth(), arena.getSize().getHeight());
		
//		if(unit.getType()==TYPE.DESTROER){
//			unit.setCordinateX(5000);
//			unit.setCordinateY(5000);
//		}else{
//			unit.setCordinateX(5000);
//			unit.setCordinateY(10000);
//		}
		arena.getListOfPlayers().add(unit);
	}
	
	public void printPlayers(){
		for(Unit u : arena.getListOfPlayers()){
			System.out.println(u.getName());
			System.out.println("X = " + u.getCordinateX() + "  ;  Y = " + u.getCordinateY());
		}
	}
	
	public void turn(){
		System.out.println("Turn");
		engine.checkPositions(arena, player);
		player.createReports();
	}

	public Unit getPlayer() {
		return player;
	}

	public void setPlayer(Unit player) {
		this.player = player;
	}

	public Arena getArena() {
		return arena;
	}

	public void setArena(Arena arena) {
		this.arena = arena;
	}
	
	public Unit getUnitByID(long id){
		Unit result = null;
		for(Unit u:arena.getListOfPlayers()){
			if(u.getUnitId()==id){
				result = u;
				break;
			}
		}
		
		return result;
	}

}
