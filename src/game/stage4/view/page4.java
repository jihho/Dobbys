package game.stage4.view;

import java.awt.Color;
import java.awt.Cursor;
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

public class page4 extends JPanel {
	private JFrame mf;
	private JPanel panel;
	private JLabel label;
	
	public page4(JFrame mf) {
		
		setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
				new ImageIcon("images/main/mouse" + A_LoginPanel.mouseNum + ".png").getImage(),
				new Point(0,0),"DobbyCursor"));
		
//		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		JButton button = new JButton("return");
		button.setBounds(375, 160, 550, 450);
		this.add(button);
		
		button.addMouseListener(new MouseAdapter (){
			@Override
			public void mouseReleased(MouseEvent e) {
				ChangePanel cp = new ChangePanel(mf, panel);
				//t1.setDaemon(true);
				C_GameStage fp = new C_GameStage(mf);
				
				cp.replacePanel(fp);
			}
		});
		
		
		JLabel intro2 = new JLabel(new ImageIcon(new ImageIcon("images/stage4/hokVideo.gif")
				.getImage().getScaledInstance(550, 450, 0)));
		intro2.setBounds(375, 160, 550, 450);
		
		this.mf = mf;
		this.setLayout(null);
		panel = this;
		
		this.setBounds(0,0,1300,770);
		this.add(intro2);
		this.setBackground(Color.BLACK);
	}
}