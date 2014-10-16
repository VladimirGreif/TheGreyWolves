package com.jsoft.game.thegreywolves.weapons;

import com.jsoft.game.thegreywolves.game.Game;
import com.jsoft.game.thegreywolves.general.AUnit;
import com.jsoft.game.thegreywolves.movement.Position;

public class Bomb extends Weapon{
	
	private int activeDepth = 0;
	private String name = "Bombs";

	public Bomb(AUnit u) {
		super(u);
		// TODO Auto-generated constructor stub
		setName(name);
	}

	public String getName() {
		return name;
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
		for(Position p:getBoard().getPositionList()){
			AUnit t = Game.getInstance().getUnitByID(p.getTargetID());
			if(!t.isDestroyed()){
				if(p.getDistance()<= getFirePower() && Math.abs(getActiveDepth()-p.getDepthTargetPosition())<=getFirePower()){
					t.setDestroyed(true);
					getBoard().getVictimList().add(t);
					return p.getTargetID();
				}
			}
		}
		return -1;
	}

}
