package com.jsoft.game.thegreywolves.equipment;

import com.jsoft.game.thegreywolves.general.AUnit;

public class DestroyerAcousticEquipment extends AcousticEquipment{

	private int minAngle = 45;
	private int maxAngle = 135;

	private int maxRange = 20000;
	private int minRange = 100;
	
	
	public DestroyerAcousticEquipment(AUnit u) {
		super(u);
		// TODO Auto-generated constructor stub
		setMaxAngle(maxAngle);
		setMinAngle(minAngle);
		setMaxRange(maxRange);
		setMinRange(minRange);
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Acoustic contact";
	}

}
