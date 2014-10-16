package com.jsoft.game.thegreywolves.equipment;

import com.jsoft.game.thegreywolves.general.AUnit;

public class SubmarineAcousticEquipment extends AcousticEquipment{

	private int minAngle = 135;
	private int maxAngle = 180;

	private int maxRange = 40000;
	private int minRange = 0;
	
	
	public SubmarineAcousticEquipment(AUnit u) {
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
