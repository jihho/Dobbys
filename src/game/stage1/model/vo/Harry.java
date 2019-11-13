package game.stage1.model.vo;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Harry extends JPanel{
	public static int HARRY_ST_ALIVE = 1;
	public static int HARRY_ST_BLAST = 2;
	
	private int state;
	private int x, y;
	private int count;
	
	private static Image img = new ImageIcon("images/stage1/stage1_harry.gif").getImage().getScaledInstance(100, 100, 0);
	
	public int getState() 	{ return state; }
	public int getX() 		{ return x; }
	public int getY() 		{ return y; }
	
	public void startHarry() {
		state = HARRY_ST_ALIVE;
		x = 50;
		y = 350;
	}
	
	public void moveUp() {
		if(state == HARRY_ST_ALIVE) {
			if(y > 100) {
				y -= 20;
			}
		}
	}
	
	public void moveDown() {
		if(state == HARRY_ST_ALIVE) {
			if(y < 610 ) {
				y += 20;
			}
		}
	}
	
	public void blast() {
		state = HARRY_ST_BLAST;
		count = 30;
	}
	
	public void draw(Graphics g) {
		g.drawImage(img, x, y, 100, 100, this);
		
		if(state == HARRY_ST_BLAST) {
			count--;
			if(count == 0) {
				state = HARRY_ST_ALIVE;
			}
		}
	}
	
}
