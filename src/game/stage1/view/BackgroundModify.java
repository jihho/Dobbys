package game.stage1.view;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class BackgroundModify extends JPanel{
	
	private int state;
	private int x1, y1;
	private int x2, y2;
	private final int SPEED = 10;
	
	private static Image img1 = new ImageIcon("images/stage1/stage1_bg.png").getImage().getScaledInstance(1300, 770, 0);
	private static Image img2 = new ImageIcon("images/stage1/stage1_bg.png").getImage().getScaledInstance(1300, 770, 0);

	public BackgroundModify() {
		x1 = 0;
		y1 = 0;
		x2 = 1300;
		y2 = 0;
	}
	
	public void move() {
		x1 -= SPEED;
		x2 -= SPEED;
		
		if( x1 < -1290) {
			x1 = 1300;
		}
		if( x2 < -1290 ) {
			x2 = 1300;
		}
	}
	
	public void draw(Graphics g) {
		g.drawImage(img1, x1, y1, 1300, 770, this);
		g.drawImage(img1, x2, y2, 1300, 770, this);
	}
}
