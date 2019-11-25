package game.stage1.view;

import java.awt.Dialog;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.TimerTask;
import java.util.Timer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.C_GameStage;
import game.stage3.views.F_ChangePanel;
import view.A_Music;
import view.C_RankingPage;

public class D_Clear extends JPanel{
	private JFrame mf;
	private JPanel panel;
	

	public D_Clear(JFrame mf){
		
		this.mf = mf;
		panel = this;
		this.setLayout(null);
		
		this.setBounds(0, 0, 1300, 770);
		
		System.out.println("클리어패널 생성");
		
		JLabel clear = new JLabel(new ImageIcon(new ImageIcon("images/stage1/stage1_video.gif").getImage().getScaledInstance(1280, 720, 0)));
		clear.setBounds(0, 0, 1280, 720);
		new A_Music().clearSound();
		
		Dialog succ = new Dialog(mf, "성공");
		succ.setLayout(null);
		succ.setSize(500, 250);
		succ.setLocationRelativeTo(mf);
		
		JLabel succmsg = new JLabel("디멘터를 물리쳤습니다!!");
		succmsg.setBounds(140, 50, 300, 100);
		succmsg.setFont(new Font("DungGeunMo", 0 , 20));
		
		JButton clearButton = new JButton("게임 클리어!");
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
		ts.schedule(tsm, 9000);	
		
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
