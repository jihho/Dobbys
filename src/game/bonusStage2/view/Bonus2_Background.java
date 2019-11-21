package game.bonusStage2.view;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Bonus2_Background extends JPanel {
	private JFrame mf;
	private JPanel panel;
	private int x;
	private int y;
	
	
	public Bonus2_Background(JFrame mf) {
		
		mf.setTitle("Dobby's travel");
		this.mf = mf;
		this.setLayout(null);
		this.setFocusable(true);
		
		panel = this;
		
		JLabel map = new JLabel(new ImageIcon(new ImageIcon("images/bonus2/bgbg.png").
				getImage().getScaledInstance(1280, 720, 0)));
		
		JLabel dobby = new JLabel(new ImageIcon(new ImageIcon("images/bonus2/d_walking.gif").
				getImage().getScaledInstance(58, 72, 0)));
		
		map.setBounds(0, 0, 1280, 720);
		dobby.setBounds(500, 300, 58, 72);
		
		this.add(dobby);
		this.add(map);
	
		
	}
	

	
}