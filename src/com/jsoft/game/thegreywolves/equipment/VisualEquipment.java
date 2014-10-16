package com.jsoft.game.thegreywolves.equipment;

import com.jsoft.game.thegreywolves.game.Game;
import com.jsoft.game.thegreywolves.general.AUnit;
import com.jsoft.game.thegreywolves.general.Report;
import com.jsoft.game.thegreywolves.general.UnitConfiguration;
import com.jsoft.game.thegreywolves.movement.Position;

public class VisualEquipment extends Equipment{
	
	
	
	public VisualEquipment(AUnit u) {
		super(u);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void detect() {
		// TODO Auto-generated method stub
		AUnit u = getBoard();
		UnitConfiguration unitConfig = u.getConfiguration();

		for(Position p:u.getPositionList()){
			AUnit t = Game.getInstance().getUnitByID(p.getTargetID());
			UnitConfiguration targetConfig = t.getConfiguration();
			if(p.getDistance()<=unitConfig.getVisualRange() && targetConfig.getVisibleRange()>=p.getDistance() && t.getCoordinates().getCoordinateH()<3){
	
				Report r = new Report();
				
				int step =unitConfig.getMaxSpeedMs()/getSpeedMessages().length;
				int minRange = 0;
				int maxRange = step;
				
				for(int i = 0; i<getSpeedMessages().length; i++){
					if(t.getSpeedMs()>minRange && t.getSpeedMs()<=maxRange){
						r.setSpeedReport(getSpeedMessages()[i]);
						break;
					}
					minRange = maxRange;
					maxRange += step;
				}
				
				r.setEquipmentName(getName());
				r.setRangeReport(" The distance is about " + ((int)p.getDistance()) + " meters");
				r.setDirectionReport((int)p.getAnglePosition());
				getBoard().getReports().add(r);

				u.getVisibleTargets().add(t);
			}
		}
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Visual Contact";
	}
}
