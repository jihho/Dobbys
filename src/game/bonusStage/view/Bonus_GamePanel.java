package game.bonusStage.view;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Bonus_GamePanel extends JPanel {
 
	private JFrame mf;
	private JPanel panel;
	private int ctn = 0;	//클릭횟수
	private int hokHp = 20;
	
	public Bonus_GamePanel(JFrame mf) {
		this.mf = mf;
		this.setLayout(null);
		panel = this;
		
		this.setBackground(Color.BLACK);
		
		JLabel hok1 = new JLabel(new ImageIcon(new ImageIcon("images/bonus/hok1.png").
				getImage().getScaledInstance(500, 400, 0)));
		hok1.setBounds(400, 185, 500, 400);
		this.add(hok1);
		
		JLabel hok2 = new JLabel(new ImageIcon(new ImageIcon("images/bonus/hok1.png").
				getImage().getScaledInstance(500, 400, 0)));
		hok2.setBounds(410, 185, 500, 400);
		
		
		
		hok1.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				ctn++;
				System.out.println("클릭 횟수" + ctn);
				hokHp--;
				System.out.println("호크룩스 HP" + hokHp);
				
				if (ctn % 2 == 0) {
					hok1.setBounds(398,185,500,400);

				} else {
					hok1.setBounds(402, 185, 500, 400);
				}
			}
			
		}); 
		
		mf.requestFocus();
		mf.setFocusable(true);
	}
}
