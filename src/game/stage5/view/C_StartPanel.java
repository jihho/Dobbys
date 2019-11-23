package game.stage5.view;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import game.stage6.model.vo.Bonus2_Music;
import game.stage6.view.Bonus2_Background;
import view.A_Music;
import view.ChangePanel;

public class C_StartPanel extends JPanel{
	private JFrame mf;
	private JPanel panel;
	
	public C_StartPanel(JFrame mf) {
		this.mf = mf;
		this.setLayout(null);
		panel = this;
		
		new A_Music().bgm5();
		
		JButton start = new JButton(new ImageIcon("images/stage5/bg2.png"));
		start.setBounds(-1, 0, 1300, 770);
		
		start.setCursor(new Cursor(Cursor.HAND_CURSOR));
	
		start.setBorderPainted(false);
		start.setContentAreaFilled(false);
		start.setFocusPainted(false);
		start.setOpaque(false);
		
		start.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				ChangePanel cp = new ChangePanel(mf, panel);
				C_DobbyPanel dp = new C_DobbyPanel(mf);
				cp.replacePanel(dp);
				
			}
		});
		
		this.add(start);
	
	
}
}
