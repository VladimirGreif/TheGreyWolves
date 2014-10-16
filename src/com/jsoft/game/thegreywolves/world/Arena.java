package com.jsoft.game.thegreywolves.world;

import java.awt.Dimension;
import java.util.ArrayList;

import com.jsoft.game.thegreywolves.general.AUnit;

public class Arena {

	private ArrayList<AUnit> listOfPlayers = new ArrayList<AUnit>();
	private Dimension size = new Dimension();
	private final int maxX = 50000;
	private final int maxY = 50000;
	
	public Arena(){
		size.setSize(maxX, maxY);
	}

	public ArrayList<AUnit> getListOfPlayers() {
		return listOfPlayers;
	}

	public void setListOfPlayers(ArrayList<AUnit> listOfPlayers) {
		this.listOfPlayers = listOfPlayers;
	}

	public Dimension getSize() {
		return size;
	}

	public void setSize(Dimension size) {
		this.size = size;
	}

}
