package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.C_GameStage;
import game.stage4.view.Bonus_Effect;
import game.stage4.view.Bonus_GamePanel;

public class A_HidePage extends JPanel {
	private JFrame mf;
	private JPanel panel;
	private JLabel label;
	
	public A_HidePage(JFrame mf) {
		
		new Bonus_Effect().hokEnding();
		
		setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
				new ImageIcon("images/main/mouse" + A_LoginPanel.mouseNum + ".png").getImage(),
				new Point(0,0),"DobbyCursor"));
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		
		JButton return_btn = new JButton("RETURN");
		return_btn.setBounds(1130, 680, 150, 50);
		return_btn.setBackground(Color.GRAY);
		return_btn.setForeground(Color.WHITE);	
		return_btn.setFont(new Font("DungGeunMo", Font.PLAIN, 30));     
		return_btn.setFocusPainted(false);
		return_btn.setBorderPainted(false);		
		return_btn.setFocusPainted(false);
		this.add(return_btn);
		
		
		return_btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		return_btn.addMouseListener(new MouseAdapter (){
			@Override
			public void mouseReleased(MouseEvent e) {
				new Bonus_Effect().intoBgmStop();
				new A_Music().introBgm();
				
				ChangePanel cp = new ChangePanel(mf, panel);
				//t1.setDaemon(true);
				A_LoginPanel fp = new A_LoginPanel(mf);
				
				cp.replacePanel(fp);
			}
		});
		
		
		
		
		JLabel hidePage = new JLabel(new ImageIcon(new ImageIcon("images/stage4/hokFinal2.gif")
				.getImage().getScaledInstance(1300, 550, 0)));
		System.out.println("모두 수고 하셨습니다.\nDobbys 화이팅!");
		hidePage.setBounds(0, 80, 1300, 550);
		
		
		this.add(hidePage);
		
		this.mf = mf;
		this.setLayout(null);
		panel = this;
		
		
		this.setBounds(0,0,1300,770);
		this.setBackground(Color.BLACK);
	}
}
