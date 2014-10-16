package com.jsoft.game.thegreywolves.units.destroyer;

import com.jsoft.game.thegreywolves.equipment.DestroyerAcousticEquipment;
import com.jsoft.game.thegreywolves.equipment.SubmarineAcousticEquipment;
import com.jsoft.game.thegreywolves.equipment.VisualEquipment;
import com.jsoft.game.thegreywolves.general.AUnit;
import com.jsoft.game.thegreywolves.general.Equipments;

public class DestroyerEquipments extends Equipments{
	
	private AUnit board;
	private DestroyerAcousticEquipment acoustic;
	private VisualEquipment guards;
	
	public DestroyerEquipments(AUnit u){
		board = u;
		acoustic = new DestroyerAcousticEquipment(u);
		guards = new VisualEquipment(u);
	}

	@Override
	public void detect() {
		// TODO Auto-generated method stub
		acoustic.detect();
		guards.detect();
		
	}

}
