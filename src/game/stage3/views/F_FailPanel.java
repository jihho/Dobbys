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

import controller.C_GameStage;
import game.stage3.controller.F_Stage3Panel;
import view.A_LoginPanel;
import view.A_Music;

public class F_FailPanel extends JPanel{
	private JFrame mf;
	private JPanel panel;
	
	public F_FailPanel(JFrame mf) {
		this.mf = mf;
		panel = this;
		this.setLayout(null);
		
		setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
				new ImageIcon("images/main/mouse" + A_LoginPanel.mouseNum + ".png").getImage(),
				new Point(0,0),"DobbyCursor"));
		
		JLabel fail = new JLabel(new ImageIcon(new ImageIcon("images/stage3/stage3_fail.gif").getImage().getScaledInstance(1280, 720, 0)));
		fail.setBounds(0, 0, 1280, 720);
		new A_Music().stage3_fail();
		
		Dialog popfail = new Dialog(mf, "패배");
		popfail.setLayout(null);
		popfail.setSize(500, 250);
		popfail.setLocationRelativeTo(null);
		
		JLabel failmsg = new JLabel("볼드모트에게 패배하셨습니다...");
		failmsg.setBounds(140, 50, 300, 100);
		failmsg.setFont(new Font("DungGenMo", 0, 20));
		
		JButton retry = new JButton("재도전");
		retry.setBounds(90, 150, 150, 50);
		retry.setFont(new Font("DungGeunMo", 0, 20));
		
		JButton tomain = new JButton("메인페이지로...");
		tomain.setBounds(280, 150, 150, 50);
		tomain.setFont(new Font("DungGeunMo", 0, 15));
		
		popfail.add(failmsg);
		popfail.add(retry);
		popfail.add(tomain);
		
		this.add(fail);
		Timer ts = new Timer();	//Timer 실행
		TimerTask tsm = new TimerTask() {

			@Override
			public void run() {
				popfail.setVisible(true);
			}//TimerTask 실행
			
		};
		ts.schedule(tsm, 3200);	
		
		
		
		/*fail.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				popfail.setVisible(true);
			}
		});*/
		
		retry.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				new A_Music().intoBgmStop();
				F_ChangePanel cp = new F_ChangePanel(mf, panel);
				F_Stage3Panel sp = new F_Stage3Panel(mf);
				cp.replacePanel(sp);
				popfail.dispose();
			}
			
		});
		
		tomain.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				new A_Music().intoBgmStop();
				F_ChangePanel cp = new F_ChangePanel(mf, panel);
				C_GameStage gs = new C_GameStage(mf);
				cp.replacePanel(gs);
				popfail.dispose();
			}
		});
		
		
	}
	
}
