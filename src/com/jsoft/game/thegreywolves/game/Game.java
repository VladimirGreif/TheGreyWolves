package com.jsoft.game.thegreywolves.game;

import com.jsoft.game.thegreywolves.general.Unit;
import com.jsoft.game.thegreywolves.movement.Engine;
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
		engine.generateStartPoint(unit, arena.getSize().getWidth(), arena.getSize().getHeight());
		arena.getListOfPlayers().add(unit);
	}
	
	public void printPlayers(){
		for(Unit u : arena.getListOfPlayers()){
			System.out.println(u.getName());
			System.out.println("X = " + u.getCordinateX() + "  ;  Y = " + u.getCordinateY());
		}
	}
	
	public void turn(){
		engine.checkPositions(arena, player);
	}

	public Unit getPlayer() {
		return player;
	}

	public void setPlayer(Unit player) {
		this.player = player;
	}

}
