package game.stage2.view;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Timer extends Thread{
	private JFrame mf;
	private JPanel panel;
	
	public Timer(JFrame mf, JPanel panel) {
		this.mf = mf;
		this.panel = panel;
		
	}
	
	@Override
	public void run() {
		JLabel quest1 = new JLabel(new ImageIcon(new ImageIcon("images/stage2/quest1.PNG").
				getImage().getScaledInstance(264, 275, 0)));
		quest1.setBounds(910, 130, 264, 275);
	}
}
