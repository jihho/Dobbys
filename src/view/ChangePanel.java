package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
// 해리포터 
public class ChangePanel {
	private JFrame mf;
	private JPanel panel;
	
	public ChangePanel(JFrame mf, JPanel panel) {
		this.mf = mf;
		this.panel = panel;
	}
	
	public void replacePanel(JPanel changePanel) {
		mf.remove(panel);
		mf.add(changePanel);
		mf.repaint();
	}
	
	public void resetPanel(){
		System.out.println("패널변경");
		mf.remove(panel);
		//JPanel panel = new BackgroundPanel_RandomAssign(mf);
		mf.add(panel);
		mf.repaint();
	}
	
	public void replaceRankPanel(JPanel changePanel){
		mf.remove(panel);
		mf.add(changePanel);
		mf.repaint();
	}
	
}
