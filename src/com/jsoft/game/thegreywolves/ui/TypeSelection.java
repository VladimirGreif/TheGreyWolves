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
import com.jsoft.game.thegreywolves.units.Destroyer;
import com.jsoft.game.thegreywolves.units.Submarine;

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
			Destroyer dest = new Destroyer("Wolverine");
			game.addPlayer(dest);
			game.setPlayer(dest);
			game.setPlayer(dest);
			parentFrame.setPlayerUnit(dest);
			Submarine sub = new Submarine("U-47");
			game.addPlayer(sub);
			game.printPlayers();
			game.turn();
			parentFrame.goToWorkPanel();
		}else if(e.getSource()==subSelection){
			System.out.println("Submarine");
			Game game = Game.getInstance();
			Submarine sub = new Submarine("U-47");
			game.addPlayer(sub);
			game.setPlayer(sub);
			parentFrame.setPlayerUnit(sub);
			Destroyer dest = new Destroyer("Wolverine");
			game.addPlayer(dest);
			parentFrame.goToWorkPanel();
			game.printPlayers();
			game.turn();
		}
		
		
		
	}

}
