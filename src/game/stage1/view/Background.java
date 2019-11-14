package game.stage1.view;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Background extends JPanel  {
	//private JFrame mf;
	//private JPanel panel;

	private int x1 = 0, y1 = 0;
	private int x2 = 1300, y2 = 0;
	private final int DISTANCE = 10;
	private final int SPEED = 100;

	private static Image img1 = new ImageIcon("images/stage1/stage1_bg.png").getImage().getScaledInstance(1300, 770, 0);
	private static Image img2 = new ImageIcon("images/stage1/stage1_bg.png").getImage().getScaledInstance(1300, 770, 0);

	public Background(/*JFrame mf*/) {
		//this.mf = mf;
		//this.setLayout(null);

		//panel = this;

		this.setBounds(0, 0, 1300, 770);

		// JLabel label = new JLabel(
		// new ImageIcon(new
		// ImageIcon("images/stage1/stage1_bg.png").getImage().getScaledInstance(1300,
		// 770, 0)));

		

		// label.setBounds(x, 0, 1300, 770);
		// this.add(label);

	}

	public void paint(Graphics g) {
		g.clearRect(0, 0, getWidth(), getHeight());
		g.drawImage(img1, x1, y1, 1300, 770, this);
		g.drawImage(img1, x2, y2, 1300, 770, this);
		
		x1 -= DISTANCE;
		x2 -= DISTANCE;
		
		if(x1 < -1290) {
			x1 = 1300;
		}
		if(x2 < -1290) {
			x2 = 1300;
		}
		
		try {
			Thread.sleep(SPEED);
			repaint();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
