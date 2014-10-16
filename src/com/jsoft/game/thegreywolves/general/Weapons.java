package com.jsoft.game.thegreywolves.general;

import java.util.ArrayList;

import com.jsoft.game.thegreywolves.weapons.Weapon;

public abstract class Weapons {
	
	private Weapon weapon;
	private AUnit board;
	private AUnit unitUnderAtack;
	private ArrayList<Weapon> weaponList = new ArrayList<Weapon>();
	
	public Weapons(AUnit u){
		board = u;
	}
	

	public ArrayList<Weapon> getWeaponList() {
		return weaponList;
	}


	public void setWeaponList(ArrayList<Weapon> weaponList) {
		this.weaponList = weaponList;
	}


	public Weapon getActiveWeapon() {
		return weapon;
	}

	public void setActiveWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	public AUnit getBoard() {
		return board;
	}

	public void setBoard(AUnit board) {
		this.board = board;
	}

	public AUnit getUnitUnderAtack() {
		return unitUnderAtack;
	}

	public void setUnitUnderAtack(AUnit unitUnderAtack) {
		this.unitUnderAtack = unitUnderAtack;
		getActiveWeapon().setUnitUnderUtack(unitUnderAtack);
	}
	

}
