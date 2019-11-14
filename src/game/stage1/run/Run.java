package game.stage1.run;

import javax.swing.JFrame;

import game.stage1.controller.D_Controller;

public class Run extends JFrame{

	public static void main(String[] args) {
		Run run = new Run();
		run.MainFrame();
	}
	
	public void MainFrame() {
		this.setBounds(0,0, 1300,770);
		
		this.add(new D_Controller(this));
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
