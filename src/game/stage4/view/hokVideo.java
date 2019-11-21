package game.stage4.view;

import java.awt.Cursor;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class hokVideo extends JPanel {
	private JFrame mf;
	private JPanel panel;
	private JLabel label;
	
	public hokVideo(JFrame mf) {
		
		setCursor(new Cursor(Cursor.WAIT_CURSOR));
//		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		JLabel intro2 = new JLabel(new ImageIcon(new ImageIcon("images/stage4/hok_Video.gif")
				.getImage().getScaledInstance(1300, 770, 0)));
		intro2.setBounds(0, 0, 1300, 770);
		
		this.mf = mf;
		this.setLayout(null);
		panel = this;
		
		this.setBounds(0,0,1300,770);
		this.add(intro2);
		new Bonus_Effect().hokStart();
	}
}