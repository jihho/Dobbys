package view;

import javax.swing.JFrame;

public class MainFrame extends JFrame{
	public MainFrame() {
		this.setBounds(200, 30, 1300, 770);
		this.setLayout(null);
		
		this.add(new AssignDormitory(this));
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
