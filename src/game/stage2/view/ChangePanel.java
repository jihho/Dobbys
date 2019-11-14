package game.stage2.view;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ChangePanel {
	private JFrame mf;
	private JPanel panel;
	
	public  ChangePanel(JFrame mf, JPanel panel) {
		this.mf = mf;
		this.panel = panel;
	}
	
	public void replacePanel(JPanel changePanel) {
		mf.remove(panel);
		mf.add(changePanel);
		mf.revalidate();
		mf.repaint();
		//System.out.println("퀘스트패널");
		
	}
	
	public void playPanel() {
		System.out.println("플레이패널");
		mf.add(panel);
		mf.repaint();
	}
	
	

}
