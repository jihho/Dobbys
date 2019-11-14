package game.stage1.model.vo;

import java.awt.Rectangle;

import javax.swing.JPanel;

public class D_Harry extends JPanel{
	public static final int HARRY_ST_ALIVE = 1;
	public static final int HARRY_ST_BLAST = 2;
	
	public static int HARRY_MAX_HP = 5;	
	
	private int state;			// 해리 상태
	private int x, y;			// 해리 좌표
	private int count;			// 이펙트 시간
	private int life = HARRY_MAX_HP; // 해리 체력
	
	private Rectangle bb;		// bounding box
	
	public int getCount() 	{ return count;	}
	public void setCount(int count) { this.count = count; }
	
	public int getState() 	{ return state; }
	public void setState(int state)  	{ this.state = state; }
	
	public int getLife()	{ return life; }
	public void setLife(int life)   { this.life = life; }
	
	public int getX() 		{ return x; }
	public int getY() 		{ return y; }
	
	public Rectangle getBBox() { return bb; }
	
	public void startHarry() {
		state = HARRY_ST_ALIVE;
		x = 30;
		y = 350;
		bb = new Rectangle(x, y, 100, 100);
		life = HARRY_MAX_HP;
		count = 30;
	}
	
	public void moveUp() {
		if(state == HARRY_ST_ALIVE) {
			if(y > 100) {
				y -= 20;
				bb.y = y;
			}
		}
	}
	
	public void moveDown() {
		if(state == HARRY_ST_ALIVE) {
			if(y < 610 ) {
				y += 20;
				bb.y = y;
			}
		}
	}
	
	public void blast() {
		state = HARRY_ST_BLAST;
		count = 30;
	}
	
	
	
}
