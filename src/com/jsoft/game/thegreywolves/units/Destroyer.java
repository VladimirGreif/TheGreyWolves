package com.jsoft.game.thegreywolves.units;

import com.jsoft.game.thegreywolves.game.Game;
import com.jsoft.game.thegreywolves.general.Range;
import com.jsoft.game.thegreywolves.general.Report;
import com.jsoft.game.thegreywolves.general.Unit;
import com.jsoft.game.thegreywolves.general.Weapons;
import com.jsoft.game.thegreywolves.movement.Position;
import com.jsoft.game.thegreywolves.weapons.Bomb;

public class Destroyer extends Unit {
	
	private Bomb bomb;
	
	private double conversionFromKnotsToMs = 0.514444;
	
	public Destroyer(String name){
		setName(name);
		setType(TYPE.DESTROER);
		setSonarZone(135);
		setMinSonarZone(45);
		setMaxSpeedMs(35 * conversionFromKnotsToMs);
		setMaxSonarRange(40000);
		setVisibleRange(5000);
		setVisualRange(5000);
		bomb = new Bomb(this);
		setActiveWeapon(bomb);
	}
	
	public void createReports(){
		
		System.out.println("Create Report");
		
		getReports().clear();
		getVisibleTargets().clear();

		double currentAngle = getSonarZone() -  getSpeedMs() * getMaxSpeedMs()/(getSonarZone() - getMinSonarZone());
		if(currentAngle>getSonarZone()) currentAngle = getSonarZone();
		for(Position p:getPositionList()){
			p.printPosition();
			Report r = new Report();
			if(p.getAnglePosition()<180){
				if(p.getAnglePosition()<currentAngle){
					checkPosition(p, r);
				}
			}else{
				if(p.getAnglePosition()>(360-currentAngle)){
					checkPosition(p, r);
				}
			}
			Report vr = new Report();
			checkVisualPosition(p, vr);
		}
		if(getReports().size()==0) getReports().add(new Report());
	}
	
	public void checkPosition(Position p, Report r){
		for(Range d:Report.getRANGE_LIST()){
			if(d.checkInRange(p.getDistance())){
				r.setSonarContact(true);
				r.setRangeReport(d.getMessage());
				r.setDirectionReport((int)p.getAnglePosition());
				getReports().add(r);
			}
		}
	}

	public Bomb getBomb() {
		return bomb;
	}

	public void setBomb(Bomb bomb) {
		this.bomb = bomb;
	}

	public double getConversionFromKnotsToMs() {
		return conversionFromKnotsToMs;
	}

	public void setConversionFromKnotsToMs(double conversionFromKnotsToMs) {
		this.conversionFromKnotsToMs = conversionFromKnotsToMs;
	}

}
