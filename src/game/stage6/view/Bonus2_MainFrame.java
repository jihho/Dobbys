package game.stage6.view;

import javax.swing.JFrame;

public class Bonus2_MainFrame extends JFrame {
	public Bonus2_MainFrame() {
		this.setSize(1300, 770);
		this.setLocationRelativeTo(null);
		
		this.add(new Bonus2_StartPanel(this));
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
