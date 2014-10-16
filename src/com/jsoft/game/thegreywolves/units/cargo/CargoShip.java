package com.jsoft.game.thegreywolves.units.cargo;

import com.jsoft.game.thegreywolves.general.AUnit;
import com.jsoft.game.thegreywolves.general.Report;
import com.jsoft.game.thegreywolves.general.UnitConfiguration;

public class CargoShip  extends AUnit{
	
	public CargoShip(String name, UnitConfiguration config){
		super(name, config);
	}

	@Override
	public void createReports() {
		// TODO Auto-generated method stub
		getReports().clear();
		getVisibleTargets().clear();

		if(getReports().size()==0) getReports().add(new Report());
	}

}
