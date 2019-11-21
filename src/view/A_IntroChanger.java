package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class A_IntroChanger extends Thread{
	private JFrame mf;
	private JPanel panel;


	
	public A_IntroChanger(JFrame mf, JPanel panel) {
		this.mf = mf;
		this.panel = panel;
		//this.quest1 = quest1;
		
	}	
	

	@Override
	public void run() {
		
			try {
				this.sleep(900);
				System.out.println("1");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			// 타이머가 끝나면 다음 패널로 넘어감
			ChangePanel cp = new ChangePanel(mf, panel);
			A_LoginPanel gp = new A_LoginPanel(mf);
			cp.replacePanel(gp);
	}
}
