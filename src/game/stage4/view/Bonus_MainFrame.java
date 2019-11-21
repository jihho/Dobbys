package game.stage4.view;

import javax.swing.JFrame;

import view.A_Music;

public class Bonus_MainFrame extends JFrame{
	public Bonus_MainFrame() throws Exception {
		this.setSize(1300, 770);
		this.setLocationRelativeTo(null);
		this.add(new page(this));
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
