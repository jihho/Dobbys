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

public class Bonus_Changer2 extends Thread{
	private JFrame mf;
	private JPanel panel;


	//호크룩스 파괴후 크리에이터 영상으로 전환
	public Bonus_Changer2(JFrame mf, JPanel panel) {
		this.mf = mf;
		this.panel = panel;
		//this.quest1 = quest1;
		
	}	
	

	@Override
	public void run() {
		
			try {
				this.sleep(7300);
				System.out.println("1");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			//마지막 화면
			new Bonus_Effect().intoBgmStop();
			ChangePanel cp = new ChangePanel(mf, panel);
			page4 gp = new page4(mf);
			cp.replacePanel(gp);
	}
}