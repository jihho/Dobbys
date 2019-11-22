package game.stage6.view;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.C_GameStage;
import game.stage2.controller.E_ChangePanel;

public class Bonus2_EndPanel extends JPanel{
	private JFrame mf;
	private JPanel panel;
	
	public Bonus2_EndPanel(JFrame mf) {
		this.mf = mf;
		this.setLayout(null);
		panel = this;
		
		JButton end = new JButton(new ImageIcon("images/stage6/theend.png"));
		end.setBounds(0, 0, 1280, 720);
		
		end.setCursor(new Cursor(Cursor.HAND_CURSOR));

		end.setBorderPainted(false);
		end.setContentAreaFilled(false);
		end.setFocusPainted(false);
		end.setOpaque(false);
		
		end.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				E_ChangePanel cp = new E_ChangePanel(mf, panel);
				C_GameStage gs = new C_GameStage(mf);
				cp.replacePanel(gs);;
				
			}
		});
		
		this.add(end);
	}
		
}
