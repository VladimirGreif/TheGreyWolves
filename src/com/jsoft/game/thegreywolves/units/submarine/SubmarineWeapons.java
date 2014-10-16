package com.jsoft.game.thegreywolves.units.submarine;


import com.jsoft.game.thegreywolves.general.AUnit;
import com.jsoft.game.thegreywolves.general.Weapons;
import com.jsoft.game.thegreywolves.weapons.Gun;
import com.jsoft.game.thegreywolves.weapons.Torpedo;

public class SubmarineWeapons extends Weapons{
	
	private Torpedo torpedo;
	private Gun gun;
	
	public SubmarineWeapons(AUnit u) {
		super(u);
		// TODO Auto-generated constructor stub
		torpedo = new Torpedo(u);
		gun = new Gun(u);
		setActiveWeapon(torpedo);
		
		getWeaponList().add(torpedo);
		getWeaponList().add(gun);
	}

}
