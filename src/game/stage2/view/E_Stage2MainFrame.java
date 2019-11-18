package game.stage2.view;

import javax.swing.JFrame;

import view.A_Music;

public class E_Stage2MainFrame extends JFrame{
	public E_Stage2MainFrame() {
		this.setSize(1300, 770);
		this.setLocationRelativeTo(null);
		
		
		this.add(new E_StartPanel(this));
		//this.add(new GamePanel(this));
		//new BgPanel(this);
		//new A_Music().stage2_BgSound();
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
