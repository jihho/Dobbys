package game.stage5.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

import model.vo.User;
import view.A_Music;
import view.C_RankingPage;
import view.ChangePanel;

public class C_DobbyPanel extends JPanel{
	private JFrame mf;
	private JPanel panel;
	private JLabel book1;
	private JLabel book2;
	private int x = 10;
	private int y = 300;
	private boolean sw = true;

	public C_DobbyPanel(JFrame mf) {
		this.mf = mf;
		panel = this;
		this.setLayout(null);
		this.setBackground(Color.blue);


		this.setBounds(0, 0, 1300, 770);
		System.out.println("보너스 패널생성");

		JLabel background = new JLabel(new ImageIcon(new ImageIcon("images/stage5/background2.png").getImage()));
		background.setBounds(0, 0, 1300, 770);
//		JLabel black = new JLabel(new ImageIcon(new ImageIcon("images/stage5/black.png").getImage().getScaledInstance(1200, 600, 0)));
//		black.setBounds(50, 50, 1200, 600);

		
		book1 = new JLabel(new ImageIcon(new ImageIcon("images/stage5/book1.png").getImage()));
		book1.setBounds(1000, 200, 200, 150);
		JLabel coffee = new JLabel(new ImageIcon(new ImageIcon("images/stage5/coffee3.png").getImage()));
		coffee.setBounds(300, 160, 100, 150);
		
		JLabel dobby = new JLabel(new ImageIcon(new ImageIcon("images/stage5/dobby-0.png").getImage()));
		dobby.setBounds(x, y, 350, 500);
		
		JDialog free = new JDialog(mf, "Dobby is free");
		free.setBounds(540, 500, 500, 400);
		free.setLocationRelativeTo(mf);
		free.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		free.add(new JLabel((new ImageIcon("images/stage5/gift.png"))));
		
		JDialog espresso = new JDialog(mf, "Espresso Patronum");
		espresso.setBounds(540, 500, 345, 445);
		espresso.setLocationRelativeTo(mf);
		espresso.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		espresso.add(new JLabel((new ImageIcon("images/stage5/espresso.png"))));
		
		mf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_UP) {
					dobby.setBounds(x, y -= 10, 350, 500);
				}
				if(e.getKeyCode() == KeyEvent.VK_DOWN) {
					dobby.setBounds(x, y += 10, 350, 500);
				}
				if(e.getKeyCode() == KeyEvent.VK_LEFT) {
					dobby.setIcon(new ImageIcon("images/stage5/dobby-00.png"));
					dobby.setBounds(x -= 10, y, 350, 500);
				}
				if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
					dobby.setIcon(new ImageIcon("images/stage5/dobby-0.png"));
					dobby.setBounds(x += 10, y, 350, 500);
				}

			}

		});
		
		
		
		book1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				
				if(sw == true) {
					book1.setIcon(new ImageIcon("images/stage5/book2.png"));
					System.out.println(sw);
					
					free.setVisible(true);
					
					sw = false;
		
				} else if(sw == false) {
					book1.setIcon(new ImageIcon("images/stage5/book1.png"));
					System.out.println(sw);
					sw = true;
				}

			}
		});
	
		coffee.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
					
				espresso.setVisible(true);
				
			}
		});
			
				
		this.add(dobby);
		this.add(book1);
		this.add(coffee);
		this.add(background);
	}

}

