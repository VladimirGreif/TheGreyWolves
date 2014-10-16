package com.jsoft.game.thegreywolves.weapons;

import com.jsoft.game.thegreywolves.game.Game;
import com.jsoft.game.thegreywolves.general.AUnit;
import com.jsoft.game.thegreywolves.movement.Position;

public class Torpedo extends Weapon{

	private AUnit attackedUnit;
	private String name = "Torpedo";
	
	public Torpedo(AUnit u) {
		super(u);
		// TODO Auto-generated constructor stub
		setName(name);
	}

	public String getName() {
		return name;
	}

	public AUnit getAttackedUnit() {
		return attackedUnit;
	}

	public void setAttackedUnit(AUnit attackedUnit) {
		this.attackedUnit = attackedUnit;
	}

	@Override
	public long fire() {
		// TODO Auto-generated method stub
		
		
		for(Position p:getBoard().getPositionList()){
			if(!Game.getInstance().getUnitByID(p.getTargetID()).isDestroyed()){
				if(p.getTargetID()==getUnitUnderUtack().getUnitId() &&   p.getDistance()<= getMaxFireRange()){
	//				if(p.getDistance()<500){
						Game.getInstance().getUnitByID(p.getTargetID()).setDestroyed(true);
						getBoard().getVictimList().add(Game.getInstance().getUnitByID(p.getTargetID()));
						System.out.println(getBoard().getVictimList().size());
						return p.getTargetID();
	//				}
				}
			}
		}
		return -1;
	}
	

}
