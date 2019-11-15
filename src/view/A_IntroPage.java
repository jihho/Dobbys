package view;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class A_IntroPage extends JPanel{
	private JFrame mf;
	private JPanel panel;
	
	public A_IntroPage(JFrame mf){
		
		this.mf = mf;
		this.setLayout(null);
		
		panel = this;
		
		JLabel introBackground = new JLabel(new ImageIcon(new ImageIcon("images/main/intro.gif")
				.getImage().getScaledInstance(1300, 770, 0)));
		introBackground.setBounds(0, 0, 1300, 770);
		
		JLabel press = new JLabel(new ImageIcon(new ImageIcon("images/main/pressbutton.gif")
				.getImage().getScaledInstance(950, 150, 0)));
		press.setBounds(200, 520, 950, 300);
		
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
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
		
		this.add(press);
		this.add(introBackground);
//		this.setComponentZOrder(label, 1);
		
		
	}
	
}

