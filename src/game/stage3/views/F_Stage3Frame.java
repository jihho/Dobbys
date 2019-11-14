package game.stage3.views;

import javax.swing.JFrame;

public class F_Stage3Frame extends JFrame{
	public F_Stage3Frame(){
		this.setBounds(200, 30, 1300, 770);
		//this.setLayout(null);
		this.setTitle("스테3 연습");
		this.add(new F_Stage3Panel(this));
		//this.add(new GraphicTest(this));
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}