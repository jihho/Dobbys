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
		state = HARRY_ST_ALIVE;	//해리 상태를 살아있는 상태로 변경
		x = 30;					//시작 x,y 좌표 설정
		y = 350;
		bb = new Rectangle(x + 10, y + 10, 80, 80);	//히트박스 설정
		life = HARRY_MAX_HP;	//해리 hp 설정
		count = 30;
	}
	
	public void moveUp() {
		if(state == HARRY_ST_ALIVE) {
			if(y > 100) {
				y -= 20;
				bb.y = y + 10;
			}
		}
	}	
	public void moveDown() {
		if(state == HARRY_ST_ALIVE) {
			if(y < 610 ) {
				y += 20;
				bb.y = y + 10;
			}
		}
	}
	public void moveLeft() {
		if(state == HARRY_ST_ALIVE) {
			if(x > 20) {
				x -= 20;
				bb.x = x + 10;
			}
		}
	}	
	public void moveRight() {
		if(state == HARRY_ST_ALIVE) {
			if(x < 1100) {
				x += 20;
				bb.x = x + 10;
			}
		}
	}
	
	
	public void blast() {
		state = HARRY_ST_BLAST;
		count = 30;
	}
}
