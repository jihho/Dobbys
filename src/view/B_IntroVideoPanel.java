package view;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.B_UserManager;
import controller.C_GameStage;
import model.vo.User;

public class B_IntroVideoPanel extends JPanel{
	private JFrame mf;
	private JPanel panel;
	public B_IntroVideoPanel(JFrame mf){
		this.mf = mf;
		this.setLayout(null);
		
		panel = this;
		
		JLabel label = new JLabel(new ImageIcon(new ImageIcon("images/main/resizeIntroVideo.gif").getImage().getScaledInstance(1300, 770, 0)));
		label.setBounds(0, 0, 1300, 770);
		
//		JButton skip_btn = new JButton(new ImageIcon("images/main/skipButton.PNG"));
//		skip_btn.setBounds(1000, 550, 200, 200);
//		skip_btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		JLabel start = new JLabel(new ImageIcon(new ImageIcon("images/main/nextButton.PNG").getImage().getScaledInstance(250, 250, 0)));
		start.setBounds(1100, 600, 110, 70);
		start.setCursor(new Cursor(Cursor.HAND_CURSOR));
		setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
				new ImageIcon("images/main/mouse1.png").getImage(),
				new Point(0,0),"DobbyCursor"));
		new A_Music().trainSound();
	
		start.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				B_UserManager um = new B_UserManager();
				//um.updateLoginCount(User.playerId);
				//System.out.println(User.playerId);
				if(um.selectLoginCount(User.playerId) == 0) {
					new A_Music().intoBgmStop();
					new A_Music().btnEffect();
					ChangePanel cp = new ChangePanel(mf, panel);
					C_AssignDormitory ad = new C_AssignDormitory(mf);
					cp.replacePanel(ad);
				}else {
					new A_Music().intoBgmStop();
					new A_Music().btnEffect();
					ChangePanel cp = new ChangePanel(mf, panel);
					C_GameStage gs = new C_GameStage(mf);
					cp.replacePanel(gs);
				}
			}
		
		});
		
//		skip_btn.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseReleased(MouseEvent e) {
//				B_UserManager um = new B_UserManager();
//				//um.updateLoginCount(User.playerId);
//				//System.out.println(User.playerId);
//				if(um.selectLoginCount(User.playerId) == 0) {
//					new A_Music().intoBgmStop();
//					ChangePanel cp = new ChangePanel(mf, panel);
//					C_AssignDormitory ad = new C_AssignDormitory(mf);
//					cp.replacePanel(ad);
//				}else {
//					new A_Music().intoBgmStop();
//					ChangePanel cp = new ChangePanel(mf, panel);
//					C_GameStage gs = new C_GameStage(mf);
//					cp.replacePanel(gs);
//				}
//			}
//		});
		
		this.add(label);
		this.add(start);
		//this.add(skip_btn);
		this.setComponentZOrder(label, 1);
		
		
	}

}
