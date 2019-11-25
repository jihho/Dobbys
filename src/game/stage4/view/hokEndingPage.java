package game.stage4.view;

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
import view.A_ChangePage;
import view.A_LoginPanel;
import view.ChangePanel;

public class hokEndingPage extends JPanel {
	private JFrame mf;
	private JPanel panel;
	private JLabel label;
	
	public hokEndingPage(JFrame mf) {
		
		setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
				new ImageIcon("images/main/mouse" + A_LoginPanel.mouseNum + ".png").getImage(),
				new Point(0,0),"DobbyCursor"));
		
		new Bonus_Effect().hokGet();
		
//		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		JButton return_btn = new JButton("RETURN");
		return_btn.setBounds(1130, 680, 150, 50);
		return_btn.setBackground(Color.GRAY);
		return_btn.setForeground(Color.WHITE);	
		return_btn.setFont(new Font("DungGeunMo", Font.PLAIN, 30));     
		return_btn.setFocusPainted(false);
		return_btn.setBorderPainted(false);		
		return_btn.setFocusPainted(false);
		this.add(return_btn);
		
		JButton reGame = new JButton("RETRY");
		reGame.setBounds(20, 680, 150, 50);
		reGame.setBackground(Color.GRAY);
		reGame.setForeground(Color.WHITE);	
		reGame.setFont(new Font("DungGeunMo", Font.PLAIN, 30));     
		reGame.setFocusPainted(false);
		reGame.setBorderPainted(false);		
		reGame.setFocusPainted(false);
		this.add(reGame);
		
		return_btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		reGame.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		
		return_btn.addMouseListener(new MouseAdapter (){
			@Override
			public void mouseReleased(MouseEvent e) {
				new Bonus_Effect().intoBgmStop();
				new Bonus_Effect().intoBonusStop();
				
				ChangePanel cp = new ChangePanel(mf, panel);
				//t1.setDaemon(true);
				C_GameStage fp = new C_GameStage(mf);
				
				cp.replacePanel(fp);
			}
		});
		
		
		//다시뽑기
		reGame.addMouseListener(new MouseAdapter (){
			@Override
			public void mouseReleased(MouseEvent e) {
				new Bonus_Effect().intoBgmStop();
				new Bonus_Effect().intoBonusStop();
				new Bonus_Effect().hokBgm();
				
				ChangePanel cp = new ChangePanel(mf, panel);
				Bonus_GamePanel gp = new Bonus_GamePanel(mf);
				cp.replacePanel(gp);
			}
		});
		
		
		
		
//		JLabel hokFinal = new JLabel(new ImageIcon(new ImageIcon("images/stage4/hokFinal1.gif")
//				.getImage().getScaledInstance(1300, 550, 0)));
//		hokFinal.setBounds(0, 110, 1300, 550);
		
		JLabel hokGet = new JLabel(new ImageIcon(new ImageIcon("images/stage4/hokget.gif")
				.getImage().getScaledInstance(1000, 600, 0)));
		hokGet.setBounds(150, 85, 1000, 600);
		
		JLabel hokMouse = new JLabel(new ImageIcon
				(new ImageIcon("images/main/mouse" + A_LoginPanel.mouseNum + ".png")
						.getImage().getScaledInstance(32, 32, 0)));
		hokMouse.setBounds(634, 369, 32, 32);
		
		this.add(hokMouse);
		this.add(hokGet);
		
		this.mf = mf;
		this.setLayout(null);
		panel = this;
		
		this.setBounds(0,0,1300,770);
		this.setBackground(Color.BLACK);
	}
}