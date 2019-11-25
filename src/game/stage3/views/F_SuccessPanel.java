package game.stage3.views;

import java.awt.Dialog;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.B_UserManager;
import controller.C_GameStage;
import view.A_LoginPanel;
import view.A_Music;
import view.C_RankingPage;

public class F_SuccessPanel extends JPanel{
	private JFrame mf;
	private JPanel panel;


	
	public F_SuccessPanel(JFrame mf) {
		
		this.mf = mf;
		panel = this;
		this.setLayout(null);
		
		setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
				new ImageIcon("images/main/mouse" + A_LoginPanel.mouseNum + ".png").getImage(),
				new Point(0,0),"DobbyCursor"));
		
		JLabel suc = new JLabel(new ImageIcon(new ImageIcon("images/stage3/stage3_sucs.gif").getImage().getScaledInstance(1280, 720, 0)));
		suc.setBounds(0, 0 , 1280, 720);
		new A_Music().stage3_sc();
		
		
		Dialog succ = new Dialog(mf, "성공");
		succ.setLayout(null);
		succ.setSize(500, 250);
		succ.setLocationRelativeTo(mf);
		
		JLabel succmsg = new JLabel("볼드모트를 물리쳤습니다!!");
		succmsg.setBounds(140, 50, 300, 100);
		succmsg.setFont(new Font("DungGeunMo", 0 , 20));
		
		JButton ranking = new JButton("게임 클리어!");
		ranking.setBounds(100, 150, 300, 50);
		ranking.setFont(new Font("DungGeunMo", 0, 25));
		
		succ.add(succmsg);
		succ.add(ranking);
		
		this.add(suc);
		
		Timer ts = new Timer();	//Timer 실행
		TimerTask tsm = new TimerTask() {

			@Override
			public void run() {
				succ.setVisible(true);
			}//TimerTask 실행
			
		};
		ts.schedule(tsm, 50000);	
		
		
		/*suc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				succ.setVisible(true);
			}
		});*/
		
		ranking.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				new A_Music().intoBgmStop();
				F_ChangePanel cp = new F_ChangePanel(mf, panel);
				C_RankingPage rp = new C_RankingPage(mf);
				cp.replacePanel(rp);
				succ.dispose();
			}
		});
		
		
	}
	
	
	
	
	
	
}

