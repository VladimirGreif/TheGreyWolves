package com.jsoft.game.thegreywolves.weapons;

import com.jsoft.game.thegreywolves.game.Game;
import com.jsoft.game.thegreywolves.general.Unit;
import com.jsoft.game.thegreywolves.general.Weapons;
import com.jsoft.game.thegreywolves.movement.Position;

public class Torpedo extends Weapons{

	private Unit unit;
	private Unit attackedUnit;
	
	public Torpedo(Unit u){
		unit = u;
		setFirePower(5000);
	}
	
	public Unit getAttackedUnit() {
		return attackedUnit;
	}

	public void setAttackedUnit(Unit attackedUnit) {
		this.attackedUnit = attackedUnit;
	}

	@Override
	public long fire() {
		// TODO Auto-generated method stub
		
		
		for(Position p:unit.getPositionList()){
			if(p.getTargetID()==attackedUnit.getUnitId() &&   p.getDistance()<= getFirePower()){
//				if(p.getDistance()<500){
					Game.getInstance().getUnitByID(p.getTargetID()).setDestroyed(true);
					unit.getVictimList().add(Game.getInstance().getUnitByID(p.getTargetID()));
					return p.getTargetID();
//				}
			}
		}
		return -1;
	}
	

}
