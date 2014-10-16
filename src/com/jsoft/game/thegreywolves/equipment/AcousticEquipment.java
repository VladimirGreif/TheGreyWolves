package com.jsoft.game.thegreywolves.equipment;

import java.util.ArrayList;

import com.jsoft.game.thegreywolves.game.Game;
import com.jsoft.game.thegreywolves.general.AUnit;
import com.jsoft.game.thegreywolves.general.Range;
import com.jsoft.game.thegreywolves.general.Report;
import com.jsoft.game.thegreywolves.general.UnitConfiguration;
import com.jsoft.game.thegreywolves.movement.Position;

public abstract class AcousticEquipment extends Equipment{

	
	private ArrayList<Range> rangeList = new ArrayList<Range>();
	

	
	public AcousticEquipment(AUnit u) {
		super(u);
		
		int step = getMaxRange()/getRangeMessages().length;
		int minRange = 0;
		int maxRange = step;
		
		for(int i = 0; i<getRangeMessages().length; i++){
			rangeList.add(new Range(minRange, maxRange, getRangeMessages()[i]));
			minRange = maxRange;
			maxRange += step;
		}

	}

	public void detect(){
		
		AUnit u = getBoard();
		UnitConfiguration unitConfig = u.getConfiguration();
		
		double currentAngle = getMaxAngle() - u.getSpeedMs() * unitConfig.getMaxSpeedMs()/(getMaxAngle() - getMinAngle());
		
		if(currentAngle>getMaxAngle()) currentAngle = getMaxAngle();
		for(Position p:u.getPositionList()){
			p.printPosition();
			Report r = new Report();
			if(p.getAnglePosition()<180){
				if(p.getAnglePosition()<currentAngle){
					checkRangePosition(p, r);
				}
			}else{
				if(p.getAnglePosition()>(360-currentAngle)){
					checkRangePosition(p, r);
				}
			}
		}
	};
	
	private void checkRangePosition(Position p,Report r){
		AUnit t = Game.getInstance().getUnitByID(p.getTargetID());
		UnitConfiguration unitConfig = t.getConfiguration();
		double acousticRange = (t.getSpeedMs() - unitConfig.getSilentSpeed()) * (unitConfig.getMaxSpeedMs()/(unitConfig.getMaxSpeedMs()-unitConfig.getSilentSpeed()));
		
		int step =unitConfig.getMaxSpeedMs()/getSpeedMessages().length;
		int minRange = 0;
		int maxRange = step;

		if(getMaxRange()>acousticRange){
			for(Range d:rangeList){
				if(d.checkInRange(p.getDistance())){
					
					for(int i = 0; i<getSpeedMessages().length; i++){
						if(t.getSpeedMs()>minRange && t.getSpeedMs()<=maxRange){
							r.setSpeedReport(getSpeedMessages()[i]);
							break;
						}
						minRange = maxRange;
						maxRange += step;
					}
					
					r.setEquipmentName(getName());
					r.setRangeReport(d.getMessage());
					r.setDirectionReport((int)p.getAnglePosition());
					getBoard().getReports().add(r);
				}
			}
		}
	}

}
