package game.stage4.view;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class page4 extends JPanel {
	private JFrame mf;
	private JPanel panel;
	private JLabel label;
	
	public page4(JFrame mf) {
		
		setCursor(new Cursor(Cursor.WAIT_CURSOR));
		
//		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		JButton button = new JButton("return");
		button.setBounds(375, 160, 550, 450);
		this.add(button);
		
		JLabel intro2 = new JLabel(new ImageIcon(new ImageIcon("images/stage4/hok_Video.gif")
				.getImage().getScaledInstance(550, 450, 0)));
		intro2.setBounds(375, 160, 550, 450);
		
		this.mf = mf;
		this.setLayout(null);
		panel = this;
		
		this.setBounds(0,0,1300,770);
		this.add(intro2);
		this.setBackground(Color.BLACK);
	}
}