package game.stage6.view;

import java.awt.Cursor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

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
	private int sockX;
	private int sockY;
	private int ctn = 0; //탈출카운트
	

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
		
		
		
		
		map.setBounds(0, 0, 1280, 720);
		dobby.setBounds(x, y, 58, 72);
		
		//양말 아이콘 
		JLabel sockIcon1 = new JLabel(new ImageIcon(new ImageIcon("images/stage6/ss0.png").
				getImage().getScaledInstance(42, 42, 0)));
		sockIcon1.setBounds(900, 640, 42, 42);
		this.add(sockIcon1);
		
		
		JLabel sockIcon2 = new JLabel(new ImageIcon(new ImageIcon("images/stage6/ss0.png").
				getImage().getScaledInstance(42, 42, 0)));
		sockIcon2.setBounds(970, 640, 42, 42);
		this.add(sockIcon2);
		
		JLabel sockIcon3 = new JLabel(new ImageIcon(new ImageIcon("images/stage6/ss0.png").
				getImage().getScaledInstance(42, 42, 0)));
		sockIcon3.setBounds(1040, 640, 42, 42);
		this.add(sockIcon3);
		
		JLabel sockIcon4 = new JLabel(new ImageIcon(new ImageIcon("images/stage6/ss0.png").
				getImage().getScaledInstance(42, 42, 0)));
		sockIcon4.setBounds(1110, 640, 42, 42);
		this.add(sockIcon4);
		
		JLabel sockIcon5 = new JLabel(new ImageIcon(new ImageIcon("images/stage6/ss0.png").
				getImage().getScaledInstance(42, 42, 0)));
		sockIcon5.setBounds(1180, 640, 42, 42);
		this.add(sockIcon5);
		
		
		//양말 뿌리기
		sockX = new Random().nextInt(1000) + 10;
		sockY = new Random().nextInt(600) + 10;
		
		System.out.println(sockX);
		System.out.println(sockY);
		
		JLabel sock1 = new JLabel(new ImageIcon(new ImageIcon("images/stage6/ss1.png").
				getImage().getScaledInstance(42, 42, 0)));
		sock1.setBounds(sockX, sockY, 42, 42);
		this.add(sock1);

		sockX = new Random().nextInt(1000) + 10;
		sockY = new Random().nextInt(600) + 10;
		
		System.out.println(sockX);
		System.out.println(sockY);
		
		JLabel sock2 = new JLabel(new ImageIcon(new ImageIcon("images/stage6/ss2.png").
				getImage().getScaledInstance(42, 42, 0)));
		sock2.setBounds(sockX, sockY, 42, 42);
		this.add(sock2);
		
		sockX = new Random().nextInt(1000) + 10;
		sockY = new Random().nextInt(600) + 10;
		
		System.out.println(sockX);
		System.out.println(sockY);
		
		JLabel sock3 = new JLabel(new ImageIcon(new ImageIcon("images/stage6/ss3.png").
				getImage().getScaledInstance(42, 42, 0)));
		sock3.setBounds(sockX, sockY, 42, 42);
		this.add(sock3);
		
		
		sockX = new Random().nextInt(1000) + 10;
		sockY = new Random().nextInt(600) + 10;
		
		System.out.println(sockX);
		System.out.println(sockY);
		
		JLabel sock4 = new JLabel(new ImageIcon(new ImageIcon("images/stage6/ss4.png").
				getImage().getScaledInstance(42, 42, 0)));
		sock4.setBounds(sockX, sockY, 42, 42);
		this.add(sock4);
		
		sockX = new Random().nextInt(1000) + 10;
		sockY = new Random().nextInt(600) + 10;
		
		System.out.println(sockX);
		System.out.println(sockY);
		
		JLabel sock5 = new JLabel(new ImageIcon(new ImageIcon("images/stage6/ss5.png").
				getImage().getScaledInstance(42, 42, 0)));
		sock5.setBounds(sockX, sockY, 42, 42);
		this.add(sock5);
		
		sock1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		sock2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		sock3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		sock4.setCursor(new Cursor(Cursor.HAND_CURSOR));
		sock5.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		//마우스이벤트
		
		sock1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				panel.remove(sockIcon1);
				panel.repaint();
				
				panel.add(sock1);
				sock1.setBounds(900, 640, 42, 42);
				panel.setComponentZOrder(sock1, 0);
				panel.repaint();
				
				ctn++;
				System.out.println("ctn: " + ctn);

			}
		});
		
		sock2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				panel.remove(sockIcon2);
				panel.repaint();
				
				panel.add(sock2);
				sock2.setBounds(970, 640, 42, 42);
				panel.setComponentZOrder(sock2, 0);
				panel.repaint();
				
				ctn++;
				System.out.println("ctn: " + ctn);

			}
		});
		
		sock3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				panel.remove(sockIcon3);
				panel.repaint();
				
				panel.add(sock3);
				sock3.setBounds(1040, 640, 42, 42);
				panel.setComponentZOrder(sock3, 0);
				panel.repaint();
				
				ctn++;
				System.out.println("ctn: " + ctn);

			}
		});
		
		sock4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				panel.remove(sockIcon4);
				panel.repaint();
				
				panel.add(sock4);
				sock4.setBounds(1110, 640, 42, 42);
				panel.setComponentZOrder(sock4, 0);
				panel.repaint();
				
				ctn++;
				System.out.println("ctn: " + ctn);

			}
		});
		
		sock5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				panel.remove(sockIcon5);
				panel.repaint();
				
				panel.add(sock5);
				sock5.setBounds(1180, 640, 42, 42);
				panel.setComponentZOrder(sock5, 0);
				panel.repaint();
				
				ctn++;
				System.out.println("ctn: " + ctn);
			}
		});
		
		//양말5개 다 주으면 홈버튼 활성화
		
			home.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e){
					if(ctn == 5) {
						
					
					
					new Bonus2_Music().intoBgmStop();
					
					E_ChangePanel cp = new E_ChangePanel(mf, panel);
					Bonus2_EndPanel ep = new Bonus2_EndPanel(mf);
					cp.replacePanel(ep);
					
				}
			}
			});
		
		
		
		//패널 얹기
//		this.add(sockIcon1);
//		this.add(sockIcon2);
//		this.add(sockIcon3);
//		this.add(sockIcon4);
//		this.add(sockIcon5);
//		this.add(sock1);
//		this.add(sock2);
//		this.add(sock3);
//		this.add(sock4);
//		this.add(sock5);
				
		this.add(dobby);
		this.add(home);
		this.add(map);
		
		//this.setComponentZOrder(map, 6);
		
		
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