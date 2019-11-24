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
import view.A_LoginPanel;
import view.ChangePanel;

public class hokVideo extends JPanel {
	private JFrame mf;
	private JPanel panel;
	private JLabel label;
	
	public hokVideo(JFrame mf) {
		
		setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
				new ImageIcon("images/main/mouse" + A_LoginPanel.mouseNum + ".png").getImage(),
				new Point(0,0),"DobbyCursor"));
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		JLabel intro2 = new JLabel(new ImageIcon(new ImageIcon("images/stage4/hokVideo.gif")
				.getImage().getScaledInstance(1300, 750, 0)));
		intro2.setBounds(0, -20, 1300, 770);
		
		
		
		this.mf = mf;
		this.setLayout(null);
		panel = this;
		this.setBackground(Color.BLACK);
		
		this.setBounds(0,0,1300,750);
		this.add(intro2);
		new Bonus_Effect().hokStart();
		new Bonus_Effect().hokBgm();
	}
}