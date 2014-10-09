package com.jsoft.game.thegreywolves.units;

import java.util.ArrayList;

import com.jsoft.game.thegreywolves.game.Game;
import com.jsoft.game.thegreywolves.general.Range;
import com.jsoft.game.thegreywolves.general.Report;
import com.jsoft.game.thegreywolves.general.Unit;
import com.jsoft.game.thegreywolves.general.Weapons;
import com.jsoft.game.thegreywolves.general.Unit.TYPE;
import com.jsoft.game.thegreywolves.movement.Position;
import com.jsoft.game.thegreywolves.weapons.Bomb;
import com.jsoft.game.thegreywolves.weapons.Torpedo;

public class Submarine extends Unit {
	
	private double conversionFromKnotsToMs = 0.514444;
	private int numOfTubes = 6;
	private int visualRange = 5000;
	private int periscopeDepth = 16;
	private ArrayList<Unit> visibleTargets = new ArrayList<Unit>();
	private Unit underAttack;
	
	private Torpedo torpedo;
	

	public Submarine(String name){
		setType(TYPE.SUBMARINE);
		setName(name);
		setCordinateH(16);
		setSonarZone(180);
		setMinSonarZone(135);
		setMaxSpeedMs(17 * conversionFromKnotsToMs);
		setMaxSonarRange(20000);
		torpedo = new Torpedo(this);
		setActiveWeapon(torpedo);
	}
	
	public void createReports(){
		
		System.out.println("Create Report");

		getReports().clear();
		getVisibleTargets().clear();
		
		for(Position p:getPositionList()){
			if(getCordinateH()>=periscopeDepth){
				double currentAngle = getSonarZone() -  getSpeedMs() * getMaxSpeedMs()/(getSonarZone() - getMinSonarZone());
				if(currentAngle>getSonarZone()) currentAngle = getSonarZone();
				
				p.printPosition();
				Report r = new Report();
				if(p.getAnglePosition()<=180){
					if(p.getAnglePosition()<currentAngle){
						checkPosition(p, r);
					}
				}else{
					if(p.getAnglePosition()>=(360-currentAngle)){
						checkPosition(p, r);
					}
				}
				if(getCordinateH()<=periscopeDepth){
					Report vr = new Report();
					checkVisualPosition(p, vr);
				}
			}
		}
		System.out.println(getVisibleTargets().size());
		if(getReports().size()==0) getReports().add(new Report());
	};
	
	public ArrayList<Unit> getVisibleTargets() {
		return visibleTargets;
	}

	public void setVisibleTargets(ArrayList<Unit> visibleTargets) {
		this.visibleTargets = visibleTargets;
	}

	public void checkPosition(Position p, Report r){

		for(Range d:Report.getRANGE_LIST()){
			if(d.checkInRange(p.getDistance())){
				r.setSonarContact(true);
				r.setRangeReport("Accoustick Contact " + d.getMessage());
				r.setDirectionReport((int)p.getAnglePosition());
				getReports().add(r);
			}
		}
		
	}
	
	public void checkVisualPosition(Position p, Report r){
		
		if(p.getDistance()<=visualRange){
			r.setSonarContact(true);
			r.setRangeReport("Visual Contact : " + " distance is about " + ((int)p.getDistance()) + " meters");
			r.setDirectionReport((int)p.getAnglePosition());
			getReports().add(r);
			getVisibleTargets().add(Game.getInstance().getUnitByID(p.getTargetID()));
		}
		
	}

	public Unit getUnderAttack() {
		return underAttack;
	}

	public void setUnderAttack(Unit underAttack) {
		this.underAttack = underAttack;
		torpedo.setAttackedUnit(underAttack);
	}
	
}
