package view;

import javax.swing.JFrame;

public class MainFrame extends JFrame{

	public MainFrame(){
		this.setBounds(0, 0, 1300, 770);
		//this.setLayout(null);
		this.setLocationRelativeTo(null);



		this.add(new C_AssignDormitory(this));
//		this.add(new B_CheckPanel(this));



		//this.add(new GraphicTest(this));
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
