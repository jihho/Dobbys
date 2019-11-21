package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.Properties;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import game.stage2.view.E_ChangePanel;
import game.stage2.view.E_QuestPanel;
import game.stage2.view.E_Timer;

public class A_IntroPage extends JPanel{
	private JFrame mf;
	private JPanel panel;
	
	public A_IntroPage(JFrame mf){
		
		//음악재생
		new A_Music().lightningEffect();
		
		this.mf = mf;
		this.setLayout(null);
		
		panel = this;
		this.setBackground(Color.BLACK);
		
		JLabel introBackground = new JLabel(new ImageIcon(new ImageIcon("images/main/intro1.gif")
				.getImage().getScaledInstance(1300, 800, 0)));
		introBackground.setBounds(0, 0, 1300, 800);
		
//		JLabel introNext = new JLabel(new ImageIcon(new ImageIcon("images/main/intro3-5sec.gif")
//				.getImage().getScaledInstance(1330, 785, 0)));
//		introBackground.setBounds(0, 0, 1300, 770);
		
		
		JLabel press = new JLabel(new ImageIcon(new ImageIcon("images/main/clickBtn.gif")
				.getImage().getScaledInstance(650, 50, 0)));
		press.setBounds(320, 570, 650, 50);
		
		
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				
//				ChangePanel cp = new ChangePanel(mf, panel);
//				//t1.setDaemon(true);
//				A_LoginPanel gp = new A_LoginPanel(mf);
//				
//				cp.replacePanel(gp);
				
				//버튼눌렀을경우 IntroPage1 (타이머 재생)
				new A_Music().intoBgmStop();	//음악정지(천둥소리)
				new A_Music().loginEffect();
				new A_Music().introBgm();		//해리포터 bgm
				ChangePanel cp = new ChangePanel(mf, panel);
				A_IntroPage_2 qp = new A_IntroPage_2 (mf);
				A_IntroChanger timer = new A_IntroChanger(mf, qp);
				Thread t1 = timer;
				t1.setDaemon(true);
				t1.start();
				cp.replacePanel(qp);
			}
		});
		
		
		setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
				new ImageIcon("images/main/intromouse.png").getImage(),
				new Point(0,0),"images/main/intromouse.png"));
		
		
		this.add(press);
		this.add(introBackground);
		
		mf.requestFocus();
		mf.setFocusable(true);
//		this.setComponentZOrder(label, 1);

	}
}

