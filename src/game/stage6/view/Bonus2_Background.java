package game.stage6.view;

import java.awt.Cursor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.C_GameStage;
import game.stage2.controller.E_ChangePanel;
import game.stage6.model.vo.Bonus2_Music;


public class Bonus2_Background extends JPanel {
	private JFrame mf;
	private JPanel panel;
	private int x = 300;
	private int y = 530;

	private JLabel dobby;

	
	
	public Bonus2_Background(JFrame mf) {
		
		mf.setTitle("Dobby if Free");
		this.mf = mf;
		this.setLayout(null);
		panel = this;
		
		this.requestFocus();
		this.setFocusable(true);
		
		

		
		JLabel map = new JLabel(new ImageIcon(new ImageIcon("images/stage6/bgbg.png").
				getImage().getScaledInstance(1280, 720, 0)));
		
		dobby = new JLabel(" ");
		dobby.setSize(58, 72);
		
		dobby = new JLabel(new ImageIcon(new ImageIcon("images/stage6/do_walk_r.gif").
				getImage().getScaledInstance(58, 72, 0)));

		JButton home = new JButton(new ImageIcon("images/stage6/homebtn.png"));
		home.setBounds(369, 10, 30, 42);
		home.setCursor(new Cursor(Cursor.HAND_CURSOR));

		home.setBorderPainted(false);
		home.setContentAreaFilled(false);
		home.setFocusPainted(false);
		home.setOpaque(false);
		
		
		home.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e){
				new Bonus2_Music().intoBgmStop();
				
				E_ChangePanel cp = new E_ChangePanel(mf, panel);
				Bonus2_EndPanel ep = new Bonus2_EndPanel(mf);
				cp.replacePanel(ep);
				
			}
		});
		
		map.setBounds(0, 0, 1280, 720);
		dobby.setBounds(x, y, 58, 72);
		
		this.add(dobby);
		this.add(home);
		this.add(map);
		
		
		addKeyListener(new KeyHandler());
		mf.addKeyListener(new KeyHandler());

		
		
	}
	

	class KeyHandler extends KeyAdapter{
		 @Override
		 public void keyPressed(KeyEvent e) {
			 int code = e.getKeyCode();
			 
			 //up
			 if(code == KeyEvent.VK_W) {
				 if(y > 0) {
					 y -= 10;
					 
					 dobby.setBounds(x, y, 58, 72);
					 //System.out.println("위");
				 }
				 
			//down	 
			 }if(code == KeyEvent.VK_S) {
				 if(y < 640) {
					 y += 10;
					 dobby.setBounds(x, y, 58, 72);
					 //System.out.println("아래");
				 }
				 
				 //left
			 }if(code == KeyEvent.VK_A) {
				 if(x > 0) {
					 x -= 10;
					 dobby.setIcon(new ImageIcon("images/stage6/do_walk_l.gif"));
					 dobby.setBounds(x, y, 58, 72);
					 //System.out.println("왼");
				 }
				 
			//right	 
			 }if(code == KeyEvent.VK_D) {
				 if(x < 1210) {
					 x += 10;
					 dobby.setIcon(new ImageIcon("images/stage6/do_walk_r.gif"));
					 dobby.setBounds(x, y, 58, 72);
					 //System.out.println("오");
				 }
			 }
			 
			 repaint();
		 }
		 
		 @Override
		 public void keyReleased(KeyEvent e) {
			 int code = e.getKeyCode();
			 
			 if(code == KeyEvent.VK_A) {
				 if(x > 0) {
					 dobby.setIcon(new ImageIcon("images/stage6/do_stand_l.gif"));
					 dobby.setBounds(x, y, 58, 72);
				 }
			 }
		 
			 if(code == KeyEvent.VK_D) {
				 if(x < 1210) {
					 dobby.setIcon(new ImageIcon("images/stage6/do_stand_r.gif"));
					 dobby.setBounds(x, y, 58, 72);
				 }
			 }
			 if(code == KeyEvent.VK_W) {
				 if(y > 0) {
					 if(code == KeyEvent.VK_A) {
						 if(x > 0) {
							 dobby.setIcon(new ImageIcon("images/stage6/do_stand_l.gif"));
							 dobby.setBounds(x, y, 58, 72);
						 }
					 }
					 if(code == KeyEvent.VK_D) {
						 if(x < 1210) {
							 dobby.setIcon(new ImageIcon("images/stage6/do_stand_r.gif"));
							 dobby.setBounds(x, y, 58, 72);
						 }
					 }

				 }
			 }
			 if(code == KeyEvent.VK_S) {
				 if(y < 640) {
					 if(code == KeyEvent.VK_A) {
						 if(x > 0) {
							 dobby.setIcon(new ImageIcon("images/stage6/do_stand_l.gif"));
							 dobby.setBounds(x, y, 58, 72);
						 }
					 }
					 if(code == KeyEvent.VK_D) {
						 if(x < 1210) {
							 dobby.setIcon(new ImageIcon("images/stage6/do_stand_r.gif"));
							 dobby.setBounds(x, y, 58, 72);
						 }
					 }
				 }
			 }
			 repaint();
		 }
		 
		 
	
		 
	 }
	

	
}