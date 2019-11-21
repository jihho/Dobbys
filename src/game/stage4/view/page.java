package game.stage4.view;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import view.A_IntroChanger;
import view.A_IntroPage_2;
import view.A_Music;
import view.ChangePanel;

public class page extends JPanel {
	private JFrame mf;
	private JPanel panel;
	private JLabel label;
	
	public page(JFrame mf) {
		
//		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		JButton intro2 = new JButton();
		intro2.setBounds(600, 420, 100, 100);
		
		this.mf = mf;
		this.setLayout(null);
		panel = this;
		
		intro2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				
				ChangePanel cp = new ChangePanel(mf, panel);
				hokVideo qp = new hokVideo (mf);
				Bonus_Changer timer = new Bonus_Changer(mf, qp);
				Thread t1 = timer;
				t1.setDaemon(true);
				t1.start();
				cp.replacePanel(qp);
			}
		});
		
		
		this.setBounds(0,0,1300,770);
		this.add(intro2);
	}
}
