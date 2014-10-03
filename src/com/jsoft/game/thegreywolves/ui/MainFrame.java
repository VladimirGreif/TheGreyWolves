package com.jsoft.game.thegreywolves.ui;

import javax.swing.JFrame;

import com.jsoft.game.thegreywolves.general.Unit;

public class MainFrame extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String TITLE = "The Grey Wolves";
	private static final int CANVAS_WIDTH = 640;
	private static final int CANVAS_HEIGHT = 480;
	private TypeSelection ts = new TypeSelection(this);
	private WorkPanelDemo1 wp = new WorkPanelDemo1(this);

	public MainFrame(){
		super();
		goToSelectionPanel();
	}
	
	public void goToWorkPanel(){
		ts.setVisible(false);
		wp.setVisible(true);
		setContentPane(wp);
	}
	
	public void goToSelectionPanel(){
		wp.setVisible(false);
		ts.setVisible(true);
		setContentPane(ts);
	}

	public static int getCanvasWidth() {
		return CANVAS_WIDTH;
	}

	public static int getCanvasHeight() {
		return CANVAS_HEIGHT;
	}
	
	public void setPlayerUnit(Unit unit){
		wp.setPlayer(unit);
	}
}
