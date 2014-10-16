package com.jsoft.game.thegreywolves.ui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.jsoft.game.thegreywolves.game.Game;
import com.jsoft.game.thegreywolves.general.UnitConfiguration;
import com.jsoft.game.thegreywolves.units.cargo.CargoShip;
import com.jsoft.game.thegreywolves.units.destroyer.Destroyer;
import com.jsoft.game.thegreywolves.units.submarine.Submarine;

public class TypeSelection extends JPanel implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private MainFrame parentFrame;
	
	JButton destroyerSelection = new JButton("Destoyer");
	JButton subSelection = new JButton("Submarine");
	
	public TypeSelection(MainFrame parent){
		super();
		parentFrame = parent;
		
		setPreferredSize(new Dimension(MainFrame.getCanvasWidth(), MainFrame.getCanvasHeight()));
		setLayout(null);
		
		add(destroyerSelection);
		add(subSelection);
		
		destroyerSelection.addActionListener(this);
		subSelection.addActionListener(this);
		
		placeTheComponents();
	}
	
	private void placeTheComponents(){
		Dimension size = destroyerSelection.getPreferredSize();
		destroyerSelection.setBounds(200, 300,
	             size.width, size.height);
		
		size = subSelection.getPreferredSize();
		subSelection.setBounds(400, 300,
	             size.width, size.height);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==destroyerSelection){
			System.out.println("Destroyer");
			Game game = Game.getInstance();
			UnitConfiguration c = game.getDestroerConfiguration("Wolverine");
			Destroyer dest = new Destroyer("Wolverine", c);
			dest.getCoordinates().setCoordinateX(5000);
			dest.getCoordinates().setCoordinateY(5000);
			game.addPlayer(dest);
			game.setPlayer(dest);
			parentFrame.setPlayerUnit(dest);
			c = game.getSubmarineConfiguration("U-47");
			Submarine sub = new Submarine("U-47", c);
			sub.getCoordinates().setCoordinateX(5000);
			sub.getCoordinates().setCoordinateY(5000);
			sub.getCoordinates().setCoordinateH(16);
			game.addPlayer(sub);
			c = game.getSubmarineConfiguration("U-99");
			Submarine sub2 = new Submarine("U-99",c);
			sub.getCoordinates().setCoordinateX(10000);
			sub.getCoordinates().setCoordinateY(5000);
			sub.getCoordinates().setCoordinateH(16);
			game.addPlayer(sub2);
			
			c = game.getCargoConfiguration("Port Nicklson");
			CargoShip ship = new CargoShip("Port Nicklson",c);

			ship.getCoordinates().setCoordinateX(5000);
			ship.getCoordinates().setCoordinateY(10000);
			ship.setDirection(90);
			game.addPlayer(ship);

			game.printPlayers();
			
			game.turn();
			parentFrame.goToWorkPanel();

		}else if(e.getSource()==subSelection){
			System.out.println("Submarine");
			Game game = Game.getInstance();
			UnitConfiguration c = game.getSubmarineConfiguration("U-47");
			Submarine sub = new Submarine("U-47", c);
			game.addPlayer(sub);
			game.setPlayer(sub);
			parentFrame.setPlayerUnit(sub);
			c = game.getCargoConfiguration("Port Nicklson");
			CargoShip ship = new CargoShip("Port Nicklson",c);

			ship.getCoordinates().setCoordinateX(5000);
			ship.getCoordinates().setCoordinateY(10000);
			ship.setDirection(90);
			game.addPlayer(ship);
			
			sub.getCoordinates().setCoordinateX(5000);
			sub.getCoordinates().setCoordinateY(5000);
			c = game.getCargoConfiguration("Jarvis Bay");
			CargoShip ship2 = new CargoShip("Jarvis Bay", c);
			ship2.getCoordinates().setCoordinateX(6000);
			ship2.getCoordinates().setCoordinateY(7500);
			ship2.setDirection(90);
			game.addPlayer(ship2);

			
			
			parentFrame.goToWorkPanel();
			game.printPlayers();
			game.turn();
		}
		
		
		
	}

}
