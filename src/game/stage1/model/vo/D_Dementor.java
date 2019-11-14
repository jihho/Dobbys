package game.stage1.model.vo;

import java.awt.Rectangle;
import java.util.Random;

import javax.swing.JPanel;

public class D_Dementor extends JPanel{
	public static final int DEMENTOR_ST_DEATH = 0;
	public static final int DEMENTOR_ST_ALIVE = 1;
	
	private int state;
	private int x, y, dx;
	private int count;
	
	private Rectangle bb;	//bounding box
	
	public D_Dementor(){
		state = DEMENTOR_ST_DEATH;
		bb = new Rectangle(0, 0, 100, 100);
	}
	
	
	public int getState() 	{ return state; }
	public void setState(int state)  	{ this.state = state; }
	
	public int getX()		{ return x; }
	public int getY()		{ return y; }
	public Rectangle getBBox() { return bb; }

	
	public void birth() {
		x = 1500;
		y = new Random().nextInt(500) + 100;
		dx = new Random().nextInt(15) + 10;
		state = DEMENTOR_ST_ALIVE;
		bb.x = x;
		bb.y = y;
	}
	
	public void move() {
		if(state == DEMENTOR_ST_ALIVE) {
			x -= dx;
			bb.x = x;
			bb.y = y;
			
			if( x < -50 ) {
				state = DEMENTOR_ST_DEATH;
			}
		}
	}
	

	
	
}