package game.stage3.views;

import javax.swing.JFrame;

public class F_Stage3Frame extends JFrame{
	public F_Stage3Frame(){
		this.setBounds(200, 30, 1300, 770);
		//this.setLayout(null);
		this.setTitle("스테이지3");
		this.add(new F_Stage3rule(this));
		//this.add(new GraphicTest(this));
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}