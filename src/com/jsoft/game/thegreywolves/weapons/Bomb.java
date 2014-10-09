package com.jsoft.game.thegreywolves.weapons;

import com.jsoft.game.thegreywolves.game.Game;
import com.jsoft.game.thegreywolves.general.Unit;
import com.jsoft.game.thegreywolves.general.Weapons;
import com.jsoft.game.thegreywolves.movement.Position;

public class Bomb extends Weapons{
	
	private int activeDepth = 0;
	private Unit unit;
	
	public Bomb(Unit u){
		unit = u;
		setFirePower(100);
	}
	
	public int getActiveDepth() {
		return activeDepth;
	}
	public void setActiveDepth(int activeDepth) {
		this.activeDepth = activeDepth;
	}

	@Override
	public long fire() {
		// TODO Auto-generated method stub
		for(Position p:unit.getPositionList()){
			if(!Game.getInstance().getUnitByID(p.getTargetID()).isDestroyed()){
				if(p.getDistance()<= getFirePower() && Math.abs(getActiveDepth()-p.getDepthTargetPosition())<=getFirePower()){
					Game.getInstance().getUnitByID(p.getTargetID()).setDestroyed(true);
					unit.getVictimList().add(Game.getInstance().getUnitByID(p.getTargetID()));
					return p.getTargetID();
				}
			}
		}
		return -1;
	}

}
