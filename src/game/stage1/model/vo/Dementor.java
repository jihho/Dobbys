package game.stage1.model.vo;

import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Dementor extends JPanel{
	public static int DEMENTOR_ST_DEATH = 0;
	public static int DEMENTOR_ST_ALIVE = 1;
	
	private int state;
	private int x, y, dx;
	private int count;
	//private static Image img1 = new ImageIcon("images/stage1/dementor1_Move.gif").getImage().getScaledInstance(80, 100, 0);
	private static Image img2 = new ImageIcon("images/stage1/dementor2_Move.gif").getImage().getScaledInstance(100, 100, 0);
	//private static Image img;
	
	public Dementor(){
		state = DEMENTOR_ST_DEATH;
	}
	
	public int getState() 	{ return state; }
	public int getX()		{ return x; }
	public int getY()		{ return y; }
	
	public void birth() {
		x = 1300;
		y = new Random().nextInt(500) + 100;
		dx = new Random().nextInt(20) + 10;
		state = DEMENTOR_ST_ALIVE;
	}
	
	public void move() {
		if(state == DEMENTOR_ST_ALIVE) {
			x -= dx;
			if( x < -50 ) {
				state = DEMENTOR_ST_DEATH;
			}
		}
	}
	
	public void draw(Graphics g) {
		if(state == DEMENTOR_ST_ALIVE) {
				g.drawImage(img2, x, y, 100, 100, this);
		}
	}
	
}
