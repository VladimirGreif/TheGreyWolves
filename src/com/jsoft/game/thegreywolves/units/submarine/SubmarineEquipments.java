package com.jsoft.game.thegreywolves.units.submarine;

import com.jsoft.game.thegreywolves.equipment.SubmarineAcousticEquipment;
import com.jsoft.game.thegreywolves.equipment.VisualEquipment;
import com.jsoft.game.thegreywolves.general.AUnit;
import com.jsoft.game.thegreywolves.general.Equipments;

public class SubmarineEquipments extends Equipments{
	
	private AUnit board;
	private SubmarineAcousticEquipment acoustic;
	private VisualEquipment guards;
	
	public SubmarineEquipments(AUnit u){
		board = u;
		acoustic = new SubmarineAcousticEquipment(u);
		guards = new VisualEquipment(u);
	}

	@Override
	public void detect() {
		// TODO Auto-generated method stub
		acoustic.detect();
		if(board.getCoordinates().getCoordinateH()<=((Submarine)board).getPeriscopeDepth()){
			guards.detect();
		}
	}

}
