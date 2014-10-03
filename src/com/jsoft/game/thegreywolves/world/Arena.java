package com.jsoft.game.thegreywolves.world;

import java.awt.Dimension;
import java.util.ArrayList;

import com.jsoft.game.thegreywolves.general.Unit;

public class Arena {
	
	private ArrayList<Unit> listOfPlayers = new ArrayList<Unit>();
	private Dimension size = new Dimension();
	private final int maxX = 50000;
	private final int maxY = 50000;
	
	public Arena(){
		size.setSize(maxX, maxY);
	}

	public ArrayList<Unit> getListOfPlayers() {
		return listOfPlayers;
	}

	public void setListOfPlayers(ArrayList<Unit> listOfPlayers) {
		this.listOfPlayers = listOfPlayers;
	}

	public Dimension getSize() {
		return size;
	}

	public void setSize(Dimension size) {
		this.size = size;
	}

}
