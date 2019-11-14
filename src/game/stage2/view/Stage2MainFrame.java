package game.stage2.view;

import javax.swing.JFrame;

public class Stage2MainFrame extends JFrame{
	public Stage2MainFrame() {
		this.setSize(1300, 770);
		
		this.add(new BgPanel(this));
		//this.add(new GamePanel(this));
		//new BgPanel(this);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
