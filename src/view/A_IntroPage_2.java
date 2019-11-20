package view;

import java.awt.Cursor;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class A_IntroPage_2 extends JPanel {
	private JFrame mf;
	private JPanel panel;
	private JLabel label;
	
	public A_IntroPage_2(JFrame mf) {
		
		setCursor(new Cursor(Cursor.WAIT_CURSOR));
//		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		JLabel intro2 = new JLabel(new ImageIcon(new ImageIcon("images/main/intro1_2.gif")
				.getImage().getScaledInstance(1300, 810, 0)));
		intro2.setBounds(0, 0, 1300, 810);
		
		this.mf = mf;
		this.setLayout(null);
		panel = this;
		
		this.setBounds(0,0,1300,770);
		this.add(intro2);
	}
}
