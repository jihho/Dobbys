package game.stage6.view;

import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import game.stage6.model.vo.Bonus2_Music;

public class Bonus2_Background extends JPanel {
	private JFrame mf;
	private JPanel panel;
	private int x = 300;
	private int y = 530;
//	private JLabel dobbyR;
	private JLabel dobbyL;
	private JLabel dobby;

	
	
	public Bonus2_Background(JFrame mf) {
		
		mf.setTitle("Dobby's travel");
		this.mf = mf;
		this.setLayout(null);
		panel = this;
		
		this.requestFocus();
		this.setFocusable(true);
		
		new Bonus2_Music().stage6_bg();

		
		JLabel map = new JLabel(new ImageIcon(new ImageIcon("images/stage6/bgbg.png").
				getImage().getScaledInstance(1280, 720, 0)));
		
		dobby = new JLabel(" ");
		dobby.setSize(58, 72);
		
		dobby = new JLabel(new ImageIcon(new ImageIcon("images/stage6/d_walking_r.gif").
				getImage().getScaledInstance(58, 72, 0)));

//		 dobbyR = new JLabel(new ImageIcon(new ImageIcon("images/stage6/d_walking_r.gif").
//				getImage().getScaledInstance(58, 72, 0)));
		 
		 dobbyL = new JLabel(new ImageIcon(new ImageIcon("images/stage6/d_walking_l.gif").
					getImage().getScaledInstance(58, 72, 0)));
		
		//dobby = Toolkit.getDefaultToolkit().getImage("images/stage6/d_walking.gif");
		
		map.setBounds(0, 0, 1280, 720);
		dobby.setBounds(x, y, 58, 72);
		
		this.add(dobby);
		//this.add(dobbyR);
		//this.add(dobbyL);
		this.add(map);
		
		addKeyListener(new KeyHandler());
		
		
		
		
		dobby.addKeyListener(new KeyHandler());
		//dobbyL.addKeyListener(new KeyHandler());
		
		
	}
	
	 public JLabel getDobby() {
		return dobby;
	}

	public void setDobby(JLabel dobby) {
		this.dobby = dobby;
	}

	class KeyHandler extends KeyAdapter{
		 @Override
		 public void keyPressed(KeyEvent e) {
			 int code = e.getKeyCode();
			 
			 if(code == KeyEvent.VK_UP) {
				 if(y > 0) {
					 y -= 10;
					 dobby.setBounds(x, y, 58, 72);
					 //System.out.println("위");
				 }
				 
			 }if(code == KeyEvent.VK_DOWN) {
				 if(y < 640) {
					 y += 10;
					 dobby.setBounds(x, y, 58, 72);
					 //System.out.println("아래");
				 }

			 }if(code == KeyEvent.VK_LEFT) {
				 if(x > 0) {
					 //x -= 10;
					 
					 dobby.setBounds(x -= 10, y, 58, 72);
					 //System.out.println("왼");
				 }
			 }if(code == KeyEvent.VK_RIGHT) {
				 if(x < 1210) {
					// dobby = dobbyR;
					 //x += 10;
					 dobby.setBounds(x += 10, y, 58, 72);
					 //System.out.println("오");
				 }
			 }
			 
			 repaint();
		 }
		 
/*		 @Override
		 public void keyReleased(KeyEvent e) {
			 int code = e.getKeyCode();
			 
			 if(code == KeyEvent.VK_LEFT) {
				 if(x > 0) {
					 
					 dobbyL.setBounds(x, y, 58, 72);
				 }
			 }
		 
			 if(code == KeyEvent.VK_RIGHT) {
				 if(x < 1210) {
					 dobbyR.setBounds(x, y, 58, 72);
				 }
			 }
			 if(code == KeyEvent.VK_UP) {
				 if(y > 0) {
					 if(code == KeyEvent.VK_LEFT) {
						 if(x > 0) {
							 dobbyL.setBounds(x, y, 58, 72);
						 }
					 }
					 if(code == KeyEvent.VK_RIGHT) {
						 if(x < 1210) {
							 dobbyR.setBounds(x, y, 58, 72);
						 }
					 }

				 }
			 }
			 if(code == KeyEvent.VK_DOWN) {
				 if(y < 640) {
					 if(code == KeyEvent.VK_LEFT) {
						 if(x > 0) {
							 dobbyL.setBounds(x, y, 58, 72);
						 }
					 }
					 if(code == KeyEvent.VK_RIGHT) {
						 if(x < 1210) {
							 dobbyR.setBounds(x, y, 58, 72);
						 }
					 }
				 }
			 }
			 repaint();
		 }*/
		 
		 
	
		 
	 }
	

	
}