package com.jsoft.game.thegreywolves.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.jsoft.game.thegreywolves.game.Game;
import com.jsoft.game.thegreywolves.general.Report;
import com.jsoft.game.thegreywolves.general.Unit;
import com.jsoft.game.thegreywolves.general.Unit.TYPE;
import com.jsoft.game.thegreywolves.units.Destroyer;
import com.jsoft.game.thegreywolves.units.Submarine;

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
	private JSlider bombDepthSlider = new JSlider(JSlider.VERTICAL,0, 500, 0);
	private JSlider directionSlider = new JSlider(JSlider.HORIZONTAL,0, 360, 0);
	private JLabel reportLabel = new JLabel("!!! Contact !!!");
	private JLabel bombDepthLabel = new JLabel("BombDepth");
	private ArrayList<JRadioButton> selectVisibleTarget = new ArrayList<JRadioButton>();
	private ButtonGroup targetGroup = new ButtonGroup();
	
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
		directionSlider.setUI(new CustomSliderUI(directionSlider));
		add(directionSlider);
		
		
		directionSlider.addChangeListener(this);
		directionSlider.setMajorTickSpacing(90);
		directionSlider.setMinorTickSpacing(45);
		directionSlider.setPaintTicks(true);
		directionSlider.setPaintLabels(true);
		directionSlider.setToolTipText("Direction");
		
		
		reportLabel.setVisible(true);
		reportLabel.setVerticalTextPosition(JLabel.BOTTOM);
		reportLabel.setHorizontalTextPosition(JLabel.CENTER);
		add(reportLabel);

		bombDepthLabel.setVisible(false);
		bombDepthLabel.setVerticalTextPosition(JLabel.BOTTOM);
		bombDepthLabel.setHorizontalTextPosition(JLabel.CENTER);
		add(bombDepthLabel);
		add(bombDepthSlider);
		bombDepthSlider.addChangeListener(this);
		bombDepthSlider.setMajorTickSpacing(100);
		bombDepthSlider.setMinorTickSpacing(50);
		bombDepthSlider.setPaintTicks(true);
		bombDepthSlider.setPaintLabels(true);
		bombDepthSlider.setToolTipText("BombDepth");
		bombDepthSlider.setInverted(true);
		bombDepthSlider.setValue(0);
		bombDepthSlider.setVisible(false);



		
		
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
		
		
		size = bombDepthLabel.getPreferredSize();
		bombDepthLabel.setBounds(330 + insets.left, 80 + insets.top,
		             size.width, size.height);
			
		size = bombDepthSlider.getPreferredSize();
		bombDepthSlider.setBounds(330 + insets.left, 100 + insets.top,
		             size.width, size.height);
		

		size = reportLabel.getPreferredSize();
		reportLabel.setBounds(10, 350,
	             size.width, size.height);

		size = fireButton.getPreferredSize();
		fireButton.setBounds(500, 400,
	             size.width, size.height);
		
		
		size = endTurnButton.getPreferredSize();
		endTurnButton.setBounds(350, 400,
	             size.width, size.height);

	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);  // paint background
//		setBackground(Color.BLACK);
		String report = "";
		String victims = "";
		for(Unit u:player.getVictimList()){
			victims = victims + " <br> " + u.getName() + " was sunk !!! by " + player.getName();
		}
//		victims = "<html>" + victims +"</html>";
		for(Report r:player.getReports()){
			report = report + " <br> " + r.getRangeReport() + " : " + r.getDirectionReport();
		}
//		report = "<html>" + report +"</html>";
		String text = "<html>" + victims + "<br><br>" + report +"</html>";
		reportLabel.setText(text);
		Dimension size = reportLabel.getPreferredSize();
		reportLabel.setBounds(10, 350,
	             size.width, size.height);
		
		speedSlider.setMaximum((int)(player.getMaxSpeedMs()/conversionFromKnotsToMs));
		
		if(player.getType()==TYPE.DESTROER){

			bombDepthLabel.setVisible(true);
			bombDepthSlider.setVisible(true);

		}
		
		if(player.getType()==TYPE.SUBMARINE){
			int num = 0;
			
			
			Enumeration<AbstractButton> jREnum = targetGroup.getElements();
			
			while(jREnum.hasMoreElements()){
				remove(jREnum.nextElement());
			}			
			
			for(Unit u:((Submarine)player).getVisibleTargets()){
				if(!u.isDestroyed()){
					final JRadioButton button = new JRadioButton( u.getType().getDescription() + " : Position on " + (int)player.getPositionByTargetID(u.getUnitId()).getAnglePosition() + " : Distance : " + (int)player.getPositionByTargetID(u.getUnitId()).getDistance() + " meters");
					button.setToolTipText(Long.toString(u.getUnitId()));
					add(button);
					targetGroup.add(button);
					button.setVisible(true);
					Dimension sizeButton = button.getPreferredSize();
					if(num==0){
						button.setSelected(true);
						((Submarine)player).setUnderAttack(Game.getInstance().getUnitByID(u.getUnitId()));
					}
					button.setBounds(350, 100+num * 50,
							sizeButton.width, sizeButton.height);
					button.addActionListener(new ActionListener() {
		                @Override
		                public void actionPerformed(ActionEvent e) {
		                	System.out.println(((JRadioButton)e.getSource()).getToolTipText());
		                	((Submarine)player).setUnderAttack(Game.getInstance().getUnitByID(Long.valueOf(((JRadioButton)e.getSource()).getToolTipText())));
		                }
		            });
				num++;
				}
			}
			

		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==endTurnButton){
			Game game = Game.getInstance();
			game.turn();
			String report = "";
			for(Report r:player.getReports()){
				report = report + "<br>" + r.getRangeReport() + " : " + r.getDirectionReport();
			}
			report = "<html>" + report +"</html>";
			reportLabel.setText(report);
			Dimension size = reportLabel.getPreferredSize();
			reportLabel.setBounds(10, 350,
		             size.width, size.height);
			repaint();
		}else if(e.getSource()==fireButton){
			System.out.println("FIRE");
			long rezult = player.getActiveWeapon().fire();
			repaint();
		}
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		JSlider sl = (JSlider) e.getSource();
		if(sl == speedSlider){
			player.setSpeedMs(conversionFromKnotsToMs * sl.getValue());
		}else if(sl == directionSlider){
			player.setKurs(sl.getValue());
		}else if(sl == bombDepthSlider){
			((Destroyer)player).getBomb().setActiveDepth(bombDepthSlider.getValue());
		}
//		System.out.println("Changed " + sl.getToolTipText());
	}

	public Unit getPlayer() {
		return player;
	}

	public void setPlayer(Unit player) {
		this.player = player;
	}

}
