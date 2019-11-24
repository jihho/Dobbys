package game.stage5.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.C_GameStage;
import model.vo.User;
import view.A_LoginPanel;
import view.A_Music;
import view.C_RankingPage;
import view.ChangePanel;

public class C_DobbyPanel extends JPanel{
	private JFrame mf;
	private JPanel panel;
	private int x = 10;
	private int y = 300;
	private int sw;

	public C_DobbyPanel(JFrame mf) {
		this.mf = mf;
		panel = this;
		this.setLayout(null);

		this.setBounds(0, 0, 1300, 770);
		System.out.println("보너스 패널생성");

		JLabel background = new JLabel(new ImageIcon(new ImageIcon("images/stage5/background2.png").getImage()));
		JLabel book1 = new JLabel(new ImageIcon(new ImageIcon("images/stage5/book1.png").getImage()));
		JLabel coffee = new JLabel(new ImageIcon(new ImageIcon("images/stage5/coffee3.png").getImage()));
		JLabel dobby = new JLabel(new ImageIcon(new ImageIcon("images/stage5/dobby-0.png").getImage()));
		
		JDialog free = new JDialog(mf, "Dobby is free");
		JDialog espresso = new JDialog(mf, "Espresso Patronum");
		
		JButton return_btn = new JButton("RETURN");

		background.setBounds(0, 0, 1300, 770);
		book1.setBounds(1000, 200, 200, 150);
		coffee.setBounds(300, 160, 100, 150);
		dobby.setBounds(x, y, 350, 500);
		free.setBounds(540, 500, 500, 400);
		espresso.setBounds(540, 500, 345, 445);
		return_btn.setBounds(1115, 660, 150, 50);

		free.setLocationRelativeTo(mf);
		free.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		free.add(new JLabel((new ImageIcon("images/stage5/gift.png"))));
		espresso.setLocationRelativeTo(mf);
		espresso.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		espresso.add(new JLabel((new ImageIcon("images/stage5/espresso.png"))));
		return_btn.setBackground(Color.GRAY);
		return_btn.setForeground(Color.WHITE);	
		return_btn.setFont(new Font("DungGeunMo", Font.PLAIN, 30));     
		return_btn.setFocusPainted(false);
		return_btn.setBorderPainted(false);		
		return_btn.setFocusPainted(false);
		
		
		mf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_UP) {
					dobby.setIcon(new ImageIcon("images/stage5/dobby-0.png"));
					dobby.setBounds(x, y -= 10, 350, 500);
				}
				if(e.getKeyCode() == KeyEvent.VK_DOWN) {
					dobby.setIcon(new ImageIcon("images/stage5/dobby-0.png"));
					dobby.setBounds(x, y += 10, 350, 500);
				}
				if(e.getKeyCode() == KeyEvent.VK_LEFT) {
					sw++;
					if(sw == 1) {
						dobby.setIcon(new ImageIcon("images/stage5/dobby2-1.png"));
						dobby.setBounds(x -= 10, y, 350, 500);
					} 
					if(sw == 2) {
						dobby.setIcon(new ImageIcon("images/stage5/dobby2-2.png"));
						dobby.setBounds(x -= 10, y, 350, 500);
					} 
					if(sw == 3) {
						dobby.setIcon(new ImageIcon("images/stage5/dobby2-3.png"));
						dobby.setBounds(x -= 10, y, 350, 500);
					} 
					if(sw == 4) {
						dobby.setIcon(new ImageIcon("images/stage5/dobby2-2.png"));
						dobby.setBounds(x -= 10, y, 350, 500);
						sw = 0;
					} 
				}
				if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
					sw++;
					if(sw == 1) {
						dobby.setIcon(new ImageIcon("images/stage5/dobby2-1.png"));
						dobby.setBounds(x += 10, y, 350, 500);
					} 
					if(sw == 2) {
						dobby.setIcon(new ImageIcon("images/stage5/dobby2-2.png"));
						dobby.setBounds(x += 10, y, 350, 500);
					} 
					if(sw == 3) {
						dobby.setIcon(new ImageIcon("images/stage5/dobby2-3.png"));
						dobby.setBounds(x += 10, y, 350, 500);
					} 
					if(sw == 4) {
						dobby.setIcon(new ImageIcon("images/stage5/dobby2-2.png"));
						dobby.setBounds(x += 10, y, 350, 500);
						sw = 0;
					} 
					
				}
				if(e.getKeyCode() == KeyEvent.VK_D) {
					sw++;
					if(sw == 1) {
						dobby.setIcon(new ImageIcon("images/stage5/dobby4-1.png"));
						dobby.setBounds(x, y, 350, 500);
					} 
					if(sw == 2) {
						dobby.setIcon(new ImageIcon("images/stage5/dobby4-2.png"));
						dobby.setBounds(x, y, 350, 500);
					} 
					if(sw == 3) {
						dobby.setIcon(new ImageIcon("images/stage5/dobby4-3.png"));
						dobby.setBounds(x, y, 350, 500);
					} 
					if(sw == 4) {
						dobby.setIcon(new ImageIcon("images/stage5/dobby4-2.png"));
						dobby.setBounds(x, y, 350, 500);
						sw = 0;
					} 
				}
				if(e.getKeyCode() == KeyEvent.VK_F) {
					dobby.setIcon(new ImageIcon("images/stage5/dobby3-1.png"));
					dobby.setBounds(x, y, 600, 500);
				}

			}
		});
		
		book1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
					book1.setIcon(new ImageIcon("images/stage5/book2.png"));
					A_Music.dobbyfree();
					free.setVisible(true);
					
					free.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseReleased(MouseEvent e) {
							A_Music.intoBgmStopJ3();
							free.setVisible(false);
							book1.setIcon(new ImageIcon("images/stage5/book1.png"));
						}
					});
			}
		});
	
		coffee.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				espresso.setVisible(true);
				A_Music.espresso();
				
				espresso.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseReleased(MouseEvent e) {
						A_Music.intoBgmStopJ3();
						espresso.setVisible(false);
					}
					
				});
			}
		});
		
		return_btn.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
			new A_Music().intoBgmStopJ2();
			
			ChangePanel cp = new ChangePanel(mf, panel);
			C_GameStage gs = new C_GameStage(mf); 
		
			cp.replacePanel(gs);
			
			}
		});
		
		
		this.add(return_btn);
		this.add(dobby);
		this.add(book1);
		this.add(coffee);
		this.add(background);
		
		
		// 마우스 - 하영씨
		setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
				new ImageIcon("images/main/mouse" + A_LoginPanel.mouseNum + ".png").getImage(),
				new Point(0,0),"dobby mouse"));
	}

}

