package game.stage2.view;

import java.awt.Dialog;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.C_GameStage;
import game.stage2.model.vo.E_EffectMusic;
import game.stage2.model.vo.E_Quest;
import view.A_Music;

public class E_FailPanel extends JPanel {
	private JFrame mf;
	private JPanel panel;
	
	public E_FailPanel(JFrame mf) {
		this.mf = mf;
		panel = this;
		this.setLayout(null);
		
		new E_EffectMusic().stage2_fire();
		
		//실패이미지 출력
		JLabel fail = new JLabel(new ImageIcon(new ImageIcon("images/stage2/stage2_fail.gif").
				getImage().getScaledInstance(1280, 720, 0)));
		fail.setBounds(0, 0, 1280, 720);
		
		//실패팝업
		Dialog popfail = new Dialog(mf, "실패팝업");
		popfail.setLayout(null);
		popfail.setSize(500, 250);
		popfail.setLocationRelativeTo(mf);
		
		//팝업속 메세지
		JLabel failmsg = new JLabel("GAME OVER :(");
		failmsg.setBounds(140, 50, 300, 100);
		failmsg.setFont(new Font("DungGenMo", 0, 30));
		
		//팝업버튼-재도전
		JButton retry = new JButton("Retry!");
		retry.setBounds(90, 150, 150, 50);
		retry.setFont(new Font("DungGeunMo", 0, 20));
		
		//팝업버튼-메인으로
		JButton tomain = new JButton("메인으로!!");
		tomain.setBounds(280, 150, 150, 50);
		tomain.setFont(new Font("DungGeunMo", 0, 20));
		
		//패널에 얹기
		popfail.add(failmsg);
		popfail.add(retry);
		popfail.add(tomain);
		
		this.add(fail);
		
		//실패이미지클릭 -> 팝업생성
		fail.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				popfail.setVisible(true);
			}
		});
		
		//재도전버튼 클릭 -> stage2 메인으로
		retry.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				E_ChangePanel cp = new E_ChangePanel(mf, panel);
				E_StartPanel sp = new E_StartPanel(mf);
				cp.replacePanel(sp);
				popfail.dispose();
				
				E_Quest qq = new E_Quest();
				qq.setRandom(new Random().nextInt(3) + 1);
				
				new A_Music().intoBgmStop();
			}
			
		});
		
		//메인으로 버튼 클릭 -> 게임메인페이지로 넘어감
		tomain.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				E_ChangePanel cp = new E_ChangePanel(mf, panel);
				C_GameStage gs = new C_GameStage(mf);
				cp.replacePanel(gs);
				popfail.dispose();
				
				E_Quest qq = new E_Quest();
				qq.setRandom(new Random().nextInt(3) + 1);
				
				new A_Music().intoBgmStop_stage2();
			}
		});
		
		
	}
	
}
