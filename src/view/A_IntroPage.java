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

public class A_IntroPage extends JPanel{
	private JFrame mf;
	private JPanel panel;
	
	public A_IntroPage(JFrame mf){
		
		//음악재생
		new A_Music().introBgm();
		
		this.mf = mf;
		this.setLayout(null);
		
		
		panel = this;
		this.setBackground(Color.BLACK);
		
		JLabel introBackground = new JLabel(new ImageIcon(new ImageIcon("images/main/intro1-1.gif")
				.getImage().getScaledInstance(1330, 785, 0)));
		introBackground.setBounds(0, 0, 1300, 770);
		
//		JLabel introBackground = new JLabel(new ImageIcon(new ImageIcon("images/main/intro2.gif")
//				.getImage().getScaledInstance(1300, 540, 0)));
//		introBackground.setBounds(0, 115, 1300, 540);
		
		JLabel press = new JLabel(new ImageIcon(new ImageIcon("images/main/clickBtn.gif")
				.getImage().getScaledInstance(650, 50, 0)));
		press.setBounds(320, 650, 650, 50);
		
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				ChangePanel cp = new ChangePanel(mf, panel);
				//t1.setDaemon(true);
				A_LoginPanel gp = new A_LoginPanel(mf);
				
				cp.replacePanel(gp);
			}
		});
		
		
		this.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyPressed(KeyEvent e) {
					ChangePanel cp = new ChangePanel(mf, panel);
					//t1.setDaemon(true);
					A_LoginPanel gp = new A_LoginPanel(mf);
					
					cp.replacePanel(gp);
			}
		});
		
//		introBackground.setCursor(new Cursor(Cursor.HAND_CURSOR));
//		press.setCursor(new Cursor(Cursor.HAND_CURSOR));
		setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
				new ImageIcon("images/main/intromouse.png").getImage(),
				new Point(0,0),"images/main/intromouse.png"));
		
		
		this.add(press);
		this.add(introBackground);
//		this.setComponentZOrder(label, 1);
		
		

	}
	
	
		
}

