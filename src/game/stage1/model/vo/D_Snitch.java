package game.stage1.model.vo;

import java.awt.Rectangle;
import java.util.Random;

public class D_Snitch {
	public static final int SNITCH_ST_DEATH = 0;
	public static final int SNITCH_ST_ALIVE = 1;
	
	private int state;
	private int x, y, dx;
	
	private Rectangle bb;	
	
	public D_Snitch() {
		state = SNITCH_ST_DEATH;
		bb = new Rectangle(0, 0, 80, 150);
	}
	
	public int getState()	{ return state; }
	public void setState(int state) { this.state = state; }
	
	public int getX()	{ return x; }
	public int getY()	{ return y; }
	public Rectangle getBBox() { return bb; }
	
	public void birth() {
		x = 1500;
		y = new Random().nextInt(500) + 100;
		dx = new Random().nextInt(10) + 20;
		state = SNITCH_ST_ALIVE;
		bb.x = x;
		bb.y = y;
	}
	
	public void move() {
		if(state == SNITCH_ST_ALIVE) {
			x-= dx;
			bb.x = x;
			bb.y = y;
			
			if( x < -50 ) {
				state = SNITCH_ST_DEATH;
			}
		}
	}
}
