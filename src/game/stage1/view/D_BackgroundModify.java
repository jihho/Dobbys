package game.stage1.view;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class D_BackgroundModify extends JPanel{
	
	private int state;
	private int x1, y1;
	private int x2, y2;
	private final int SPEED = 5;
	
	
	
	public int getX1() {
		return x1;
	}

	public int getY1() {
		return y1;
	}

	public int getX2() {
		return x2;
	}

	public int getY2() {
		return y2;
	}

	public D_BackgroundModify() {
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
	
	
	
}
