package game.stage4.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import view.ChangePanel;

public class Bonus_Changer extends Thread{
	private JFrame mf;
	private JPanel panel;


	//stage4 진입 영상
	public Bonus_Changer(JFrame mf, JPanel panel) {
		this.mf = mf;
		this.panel = panel;
		//this.quest1 = quest1;
		
	}	
	

	@Override
	public void run() {
		
			try {
				this.sleep(16500);
				System.out.println("1");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			// 타이머가 끝나면 다음 패널로 넘어감
			ChangePanel cp = new ChangePanel(mf, panel);
			Bonus_GamePanel gp = new Bonus_GamePanel(mf);
			cp.replacePanel(gp);
	}
}
