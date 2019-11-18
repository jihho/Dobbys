package game.stage3.views;

import java.awt.Dialog;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.C_GameStage;

public class F_SuccessPanel extends JPanel{
	private JFrame mf;
	private JPanel panel;


	
	public F_SuccessPanel(JFrame mf) {
		
		this.mf = mf;
		panel = this;
		this.setLayout(null);
		
		JLabel suc = new JLabel(new ImageIcon(new ImageIcon("images/stage3/stage3_sucs.gif").getImage().getScaledInstance(1280, 720, 0)));
		suc.setBounds(0, 0 , 1280, 720);
		
		Dialog succ = new Dialog(mf, "성공팝업");
		succ.setLayout(null);
		succ.setSize(500, 250);
		succ.setLocationRelativeTo(null);
		
		JLabel succmsg = new JLabel("볼드모트를 물리쳤습니다!!");
		succmsg.setBounds(140, 50, 300, 100);
		succmsg.setFont(new Font("DungGeunMo", 0 , 30));
		
		JButton tomain = new JButton("메인페이지로 돌아갑니다.");
		tomain.setBounds(100, 150, 300, 50);
		tomain.setFont(new Font("DungGeunMo", 0, 25));
		
		succ.add(succmsg);
		succ.add(tomain);
		
		this.add(suc);
		
		suc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				succ.setVisible(true);
			}
		});
		
		tomain.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				F_ChangePanel cp = new F_ChangePanel(mf, panel);
				C_GameStage gs = new C_GameStage(mf);
				cp.replacePanel(gs);
				succ.dispose();
			}
		});
		
		
	}
	
	
	
	
	
	
}

