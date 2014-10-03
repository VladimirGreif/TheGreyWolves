package com.jsoft.game.thegreywolves.starter;

import javax.swing.SwingUtilities;

import com.jsoft.game.thegreywolves.ui.MainFrame;
import com.jsoft.game.thegreywolves.ui.WorkPanelDemo1;

public class Starter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MainFrame frame = new MainFrame();
				frame.setTitle(frame.TITLE);
				frame.setDefaultCloseOperation(MainFrame.EXIT_ON_CLOSE);
				frame.pack();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
			
		});
	}

}
