package com.jsoft.game.thegreywolves.units;

import com.jsoft.game.thegreywolves.general.Unit;

public class CargoShip  extends Unit{
	
	public CargoShip(String name){
		setName(name);
		setType(TYPE.CARGO);
		setSpeedMs(1);
		setMaxSonarRange(90000);
	}

	@Override
	public void createReports() {
		// TODO Auto-generated method stub
		
	}

}
