package game.stage5.view;

import javax.swing.JFrame;


public class C_MainFrame extends JFrame{

	public C_MainFrame(){
		this.setBounds(0, 0, 1300, 770);
		//this.setLayout(null);
		this.setLocationRelativeTo(null);
		
		this.add(new C_DobbyPanel(this));
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
