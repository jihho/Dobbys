package game.stage3.views;

import javax.swing.JFrame;

public class Stage3Frame extends JFrame{
	public Stage3Frame(){
		this.setBounds(200, 30, 1300, 770);
		//this.setLayout(null);
		this.setTitle("����3 ����");
		this.add(new Stage3Panel(this));
		//this.add(new GraphicTest(this));
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}