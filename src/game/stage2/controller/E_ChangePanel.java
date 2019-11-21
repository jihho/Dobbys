package game.stage2.controller;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class E_ChangePanel {
	private JFrame mf;
	private JPanel panel;
	
	public E_ChangePanel(JFrame mf, JPanel panel) {
		this.mf = mf;
		this.panel = panel;
	}
	
	public void replacePanel(JPanel changePanel) {
		mf.remove(panel);
		mf.add(changePanel);
		mf.revalidate();
		mf.repaint();
		
	}
	
	public void resetPanel() {
		System.out.println("패널변경~~");
		mf.remove(panel);
		mf.add(panel);
		mf.repaint();
	}
	
	public void replaceRankPanel(JPanel changePanel) {
		mf.remove(panel);
		mf.add(changePanel);
		mf.repaint();
	}
	
	

}
