package com.jsoft.game.thegreywolves.units.destroyer;

import com.jsoft.game.thegreywolves.general.AUnit;
import com.jsoft.game.thegreywolves.general.UnitConfiguration;
import com.jsoft.game.thegreywolves.weapons.Bomb;

public class Destroyer extends AUnit {
	
	private Bomb bomb;
	
	public Destroyer(String name, UnitConfiguration config){
		super(name, config);
		setEquipments(new DestroyerEquipments(this));
	}

	public Bomb getBomb() {
		return bomb;
	}

	public void setBomb(Bomb bomb) {
		this.bomb = bomb;
	}

}
