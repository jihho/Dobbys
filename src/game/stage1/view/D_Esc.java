package game.stage1.view;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
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
import game.stage3.views.F_ChangePanel;
import view.A_Music;

public class D_Esc extends JPanel {
	private JFrame mf;
	private JPanel panel;

	public D_Esc(JFrame mf) {

		this.mf = mf;
		panel = this;
		this.setLayout(null);
		
		this.setBounds(0, 0, 1300, 770);
		
		System.out.println("클리어패널 생성");
		this.setBackground(Color.black);
		JLabel clear = new JLabel(new ImageIcon(new ImageIcon("images/stage1/fail_harry.jpg").getImage().getScaledInstance(1280, 600, 0)));
		
		clear.setBounds(0, 85, 1280, 600);
		new A_Music().stage1FailSound();
		
		Dialog succ = new Dialog(mf, "Stage1 실패");
		succ.setLayout(null);
		succ.setSize(500, 250);
		succ.setLocationRelativeTo(mf);
		
		JLabel succmsg = new JLabel("YOU DIED");
		succmsg.setBounds(140, 50, 300, 100);
		succmsg.setFont(new Font("DungGeunMo", 0 , 45));
		
		
		JButton clearButton = new JButton("메인으로");
		clearButton.setBounds(100, 150, 300, 50);
		clearButton.setFont(new Font("DungGeunMo", 0, 25));
		
		
		succ.add(succmsg);
		succ.add(clearButton);
		
		this.add(clear);
		
		Timer ts = new Timer();	//Timer 실행
		TimerTask tsm = new TimerTask() {

			@Override
			public void run() {
				succ.setVisible(true);
			}//TimerTask 실행
			
		};
		ts.schedule(tsm, 5000);	
		
		clearButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				new A_Music().intoBgmStop();
				F_ChangePanel cp = new F_ChangePanel(mf, panel);
				C_GameStage gs = new C_GameStage(mf);
				cp.replacePanel(gs);
				succ.dispose();
			}
		});

	}

}
