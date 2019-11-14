package game.stage2.view;

import java.awt.Font;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
		JTextField timeCount = new JTextField("남은시간: ");
		timeCount.setBounds(700, 20 , 145, 50);
		timeCount.setFont(new Font("둥근모꼴", 0, 25));
		//timeCount.setOpaque(false);

		panel.add(timeCount);
		for(int i = 10; i >= 0; i--) {
			try {
				System.out.println(i);
				this.sleep(1000);
				timeCount.setText("남은시간: "+ i);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		E_ChangePanel cp = new E_ChangePanel(mf, panel);
		E_GamePanel gp = new E_GamePanel(mf);
		cp.replacePanel(gp);
		
		panel.remove(timeCount);
		
		panel.repaint();
		
	}
	
	

}

