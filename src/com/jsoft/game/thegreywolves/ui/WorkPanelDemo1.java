package com.jsoft.game.thegreywolves.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.jsoft.game.thegreywolves.game.Game;
import com.jsoft.game.thegreywolves.general.Unit;

public class WorkPanelDemo1 extends JPanel implements ChangeListener, ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MainFrame parentFrame;
	private double conversionFromKnotsToMs = 0.514444;
	
	private Unit player;
	private JButton fireButton = new JButton("!!!FIRE!!!");
	private JButton endTurnButton = new JButton("End Turn");
	private JSlider speedSlider = new JSlider(JSlider.VERTICAL,0, 35, 0);
	
	public WorkPanelDemo1(MainFrame parent){
		super();
		
		parentFrame = parent;
		
		setPreferredSize(new Dimension(MainFrame.getCanvasWidth(), MainFrame.getCanvasHeight()));
		setLayout(null);

		add(fireButton);
		add(endTurnButton);
		
		endTurnButton.addActionListener(this);
		fireButton.addActionListener(this);
		
		JLabel speedLabel = new JLabel("Speed");
		speedLabel.setVisible(true);
		speedLabel.setVerticalTextPosition(JLabel.BOTTOM);
		speedLabel.setHorizontalTextPosition(JLabel.CENTER);
		add(speedLabel);
		add(speedSlider);
		speedSlider.addChangeListener(this);

		//Turn on labels at major tick marks.
		speedSlider.setMajorTickSpacing(5);
		speedSlider.setMinorTickSpacing(5);
		speedSlider.setPaintTicks(true);
		speedSlider.setPaintLabels(true);
		speedSlider.setToolTipText("Speed");
		
		JLabel directionLabel = new JLabel("Direction");
		directionLabel.setVisible(true);
		directionLabel.setVerticalTextPosition(JLabel.BOTTOM);
		directionLabel.setHorizontalTextPosition(JLabel.CENTER);
		add(directionLabel);
		JSlider directionSlider = new JSlider(JSlider.HORIZONTAL,-60, 60, 0);
		directionSlider.setUI(new CustomSliderUI(directionSlider));
		add(directionSlider);
		
		
		directionSlider.addChangeListener(this);
		directionSlider.setMajorTickSpacing(15);
		directionSlider.setMinorTickSpacing(15);
		directionSlider.setPaintTicks(true);
		directionSlider.setPaintLabels(true);
		directionSlider.setToolTipText("Direction");
		
		
		JLabel reportLabel = new JLabel("130 degrees, moving slow, direction undetected, VERY CLOSE !!!");
		directionLabel.setVisible(true);
		directionLabel.setVerticalTextPosition(JLabel.BOTTOM);
		directionLabel.setHorizontalTextPosition(JLabel.CENTER);
		add(reportLabel);

		
		
		Insets insets = getInsets();
		Dimension size = speedSlider.getPreferredSize();
		speedSlider.setBounds(25, 100,
	             size.width, size.height);
		
		size = speedLabel.getPreferredSize();
		speedLabel.setBounds(25, 80,
	             size.width, size.height);
		
		size = directionSlider.getPreferredSize();
		directionSlider.setBounds(100, 100,
	             size.width, size.height);
		
		size = directionLabel.getPreferredSize();
		directionLabel.setBounds(100 + insets.left, 80 + insets.top,
	             size.width, size.height);
		
		

		size = reportLabel.getPreferredSize();
		reportLabel.setBounds(10, 350,
	             size.width, size.height);
		
		
		

		size = fireButton.getPreferredSize();
		fireButton.setBounds(500, 400,
	             size.width, size.height);
		
		
		size = endTurnButton.getPreferredSize();
		endTurnButton.setBounds(300, 400,
	             size.width, size.height);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);  // paint background
//		setBackground(Color.BLACK);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==endTurnButton){
			Game game = Game.getInstance();
			game.turn();
		}
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		JSlider sl = (JSlider) e.getSource();
		if(sl == speedSlider){
			player.setSpeedMs(conversionFromKnotsToMs * sl.getValue());
		}
		System.out.println("Changed " + sl.getToolTipText());
	}

	public Unit getPlayer() {
		return player;
	}

	public void setPlayer(Unit player) {
		this.player = player;
	}

}
