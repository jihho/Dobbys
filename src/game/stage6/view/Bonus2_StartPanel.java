package game.stage6.view;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import game.stage2.controller.E_ChangePanel;
import game.stage6.model.vo.Bonus2_Music;

public class Bonus2_StartPanel extends JPanel{
	private JFrame mf;
	private JPanel panel;
	
	public Bonus2_StartPanel(JFrame mf) {
		
		this.mf = mf;
		this.setLayout(null);
		panel = this;
		
		new Bonus2_Music().stage6_bg();
		
		JButton start = new JButton(new ImageIcon("images/stage6/start.png"));
		start.setBounds(0, 0, 1280, 720);
		
		start.setCursor(new Cursor(Cursor.HAND_CURSOR));

		start.setBorderPainted(false);
		start.setContentAreaFilled(false);
		start.setFocusPainted(false);
		start.setOpaque(false);
		
		start.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				E_ChangePanel cp = new E_ChangePanel(mf, panel);
				Bonus2_Background ep = new Bonus2_Background(mf);
				cp.replacePanel(ep);
				
			}
		});
		
		this.add(start);
		
		
	}
}
