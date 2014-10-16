package com.jsoft.game.thegreywolves.weapons;

import com.jsoft.game.thegreywolves.general.AUnit;

public class Gun extends Weapon{
	
	private String name = "Guns";

	public Gun(AUnit u) {
		super(u);
		// TODO Auto-generated constructor stub
		setName(name);
	}

	@Override
	public long fire() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getName() {
		return name;
	}

}
