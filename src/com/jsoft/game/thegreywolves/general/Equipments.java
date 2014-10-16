package com.jsoft.game.thegreywolves.general;

import java.util.ArrayList;

import com.jsoft.game.thegreywolves.equipment.Equipment;

public abstract class Equipments {
	
	private ArrayList<Equipment> equipmentsList = new ArrayList<Equipment>();

	public ArrayList<Equipment> getEquipmentsList() {
		return equipmentsList;
	}

	public void setEquipmentsList(ArrayList<Equipment> equipmentsList) {
		this.equipmentsList = equipmentsList;
	}
	
	public abstract void detect();

}
