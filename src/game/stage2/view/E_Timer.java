package game.stage2.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class E_Timer extends Thread{
	private JFrame mf;
	private JPanel panel;
	//private JLabel quest1;

	
	public E_Timer(JFrame mf, JPanel panel/*, JLabel quest1*/) {
		this.mf = mf;
		this.panel = panel;
		//this.quest1 = quest1;

		
	}	

		//퀘스트 10초뒤 사라지기
	
	@Override
	public void run() {
		JTextField timeCount = new JTextField("남은시간: ") {
			//textfield외곽선 없애기
			@Override
			public void setBorder(Border border) {
				
			}
			};
		timeCount.setBounds(965, 370, 158, 50);
		timeCount.setFont(new Font("DungGeunMo", 0, 25));
		timeCount.setBackground(new Color(252, 247, 165)); 
		
		//timeCount.setOpaque(false);
		
		panel.add(timeCount);
		for(int i = 10; i >= 0; i--) {
			try {
				System.out.println(i);
				this.sleep(100);
				timeCount.setText(" 남은시간:"+ i);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		//타이머가 끝나면 다음 패널로 넘어감
		E_ChangePanel cp = new E_ChangePanel(mf, panel);
		E_GamePanel gp = new E_GamePanel(mf);
		cp.replacePanel(gp);
		
		panel.remove(timeCount);
		
		panel.repaint();
		
	}
	
	

}

