package com.jsoft.game.thegreywolves.units;

import com.jsoft.game.thegreywolves.general.Report;
import com.jsoft.game.thegreywolves.general.Unit;
import com.jsoft.game.thegreywolves.movement.Position;

public class CargoShip  extends Unit{
	
	public CargoShip(String name){
		setName(name);
		setType(TYPE.CARGO);
		setSpeedMs(1);
		setMaxSonarRange(90000);
		setVisibleRange(15000);
		setVisualRange(7000);
	}

	@Override
	public void createReports() {
		// TODO Auto-generated method stub
		getReports().clear();
		getVisibleTargets().clear();
		for(Position p:getPositionList()){
			Report vr = new Report();
			checkVisualPosition(p, vr);
		}
		if(getReports().size()==0) getReports().add(new Report());
	}

}
