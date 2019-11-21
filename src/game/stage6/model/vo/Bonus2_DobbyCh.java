package game.stage6.model.vo;

import java.awt.Rectangle;

import javax.swing.JPanel;

public class Bonus2_DobbyCh extends JPanel {
	private int x;
	private int y;
	
	private Rectangle bbox;

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Rectangle getBbox() {
		return bbox;
	}

	public void setBbox(Rectangle bbox) {
		this.bbox = bbox;
	}
	
	public void up() {
		if(y > 100) {
			y -= 20;
			
		}
	}
	public void down() {
		
	}
	
}
