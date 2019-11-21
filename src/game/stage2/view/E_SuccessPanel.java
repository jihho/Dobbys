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
import game.stage2.controller.E_ChangePanel;
import game.stage2.model.vo.E_EffectMusic;
import game.stage2.model.vo.E_Quest;
import view.A_Music;


public class E_SuccessPanel extends JPanel{
	private JFrame mf;
	private JPanel panel;
	JLabel suc;

	
	public E_SuccessPanel(JFrame mf) {
		
		
		
		this.mf = mf;
		panel = this;
		this.setLayout(null);
		
		//성공이미지 출력
		suc = new JLabel(new ImageIcon(new ImageIcon("images/stage2/stage2_suss.gif").
				getImage().getScaledInstance(1280, 720, 0)));
		suc.setBounds(0, 0 , 1280, 720);
		
		new E_EffectMusic().stage2_suc();
		
		//성공팝업
		Dialog succ = new Dialog(mf, "성공팝업");
		succ.setLayout(null);
		succ.setSize(500, 250);
		succ.setLocationRelativeTo(mf);
		
		//팝업속 메세지
		JLabel succmsg = new JLabel("Stage2 Clear!!");
		succmsg.setBounds(140, 50, 300, 100);
		succmsg.setFont(new Font("DungGeunMo", 0 , 30));
		
		//팝업속 버튼 - 메인으로
		JButton tomain = new JButton("메인으로!");
		tomain.setBounds(100, 150, 300, 50);
		tomain.setFont(new Font("DungGeunMo", 0, 25));
		
		//패널에 얹기
		succ.add(succmsg);
		succ.add(tomain);
		
		this.add(suc);
		
		//성공이미지클릭 -> 팝업생성
		suc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				succ.setVisible(true);
			}
		});
		
		//팝업버튼클릭 -> 게임메인페이지로 넘어감
		tomain.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				new A_Music().intoBgmStop_stage2();
				E_ChangePanel cp = new E_ChangePanel(mf, panel);
				C_GameStage gs = new C_GameStage(mf);
				cp.replacePanel(gs);
				succ.dispose();
				E_Quest qq = new E_Quest();
				qq.setRandom(new Random().nextInt(3) + 1);
				
				

			}
		});
		
		
	}
	
	
	
	
	
	
}

/*class E_time extends Thread{
	private JFrame mf;
	private JPanel panel;
	
	public E_time(JFrame mf, JPanel panel) {
	}
	
	@Override
	public void run() {
		//성공이미지 출력
		
		for(int i = 10; i >= 0; i--) {
			
			try {
				this.sleep(400);
				System.out.println("시간가는중:" + i);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
		

		//타이머가 끝나면 다음 메인화면으로 넘어감
		
		E_ChangePanel cp = new E_ChangePanel(mf, panel);
		C_GameStage gs = new C_GameStage(mf);
		cp.replacePanel(gs);
	}
}*/