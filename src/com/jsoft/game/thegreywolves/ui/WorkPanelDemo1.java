package com.jsoft.game.thegreywolves.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class WorkPanelDemo1 extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int CANVAS_WIDTH = 640;
	public static final int CANVAS_HEIGHT = 480;
	
	public WorkPanelDemo1(){
		super();
		setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);  // paint background
		setBackground(Color.BLACK);
	 
		// Your custom painting codes
		// ......
	}

}
