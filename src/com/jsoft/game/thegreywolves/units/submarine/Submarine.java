package com.jsoft.game.thegreywolves.units.submarine;

import com.jsoft.game.thegreywolves.general.AUnit;
import com.jsoft.game.thegreywolves.general.UnitConfiguration;

public class Submarine extends AUnit {

	private int numOfTubes = 6;
	private int periscopeDepth = 16;
	private int maxDepth = 130;	

	public Submarine(String name, UnitConfiguration config){
		super(name,config);
		setWeapons(new SubmarineWeapons(this));
		setEquipments(new SubmarineEquipments(this));
	}

	public int getPeriscopeDepth() {
		return periscopeDepth;
	}

	public void setPeriscopeDepth(int periscopeDepth) {
		this.periscopeDepth = periscopeDepth;
	}

}
