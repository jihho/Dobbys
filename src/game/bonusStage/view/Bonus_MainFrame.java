package game.bonusStage.view;

import javax.swing.JFrame;

import view.A_Music;

public class Bonus_MainFrame extends JFrame{
	public Bonus_MainFrame() {
		this.setSize(1300, 770);
		this.setLocationRelativeTo(null);
		
		
		
		this.add(new Bonus_GamePanel(this));
		//this.add(new GamePanel(this));
		//new BgPanel(this);
		//new A_Music().stage2_BgSound();
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
