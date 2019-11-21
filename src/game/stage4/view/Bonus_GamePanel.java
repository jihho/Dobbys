package game.stage4.view;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import view.ChangePanel;

public class Bonus_GamePanel extends JPanel {
 
	private JFrame mf;
	private JPanel panel;
	private int ctn = 0;	//클릭횟수
	private int imgNum = 1;
	private int hokHp = 20;
	Point currLocation;
	
	public Bonus_GamePanel(JFrame mf) {
		this.mf = mf;
		this.setLayout(null);
		panel = this;
		
		
		
		// @@ 지우기!!!!!!!!! (첫 인트로 사운드)
		
		
		
		
		
		this.setBackground(Color.BLACK);
		JButton hok1 = new JButton(new ImageIcon(new ImageIcon("images/stage4/hok" + imgNum + ".png").
				getImage().getScaledInstance(500, 400, 0)));
		hok1.setBounds(400, 185, 500, 400);
		this.add(hok1);
		
		
		
	
		hok1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ctn++;
				System.out.println("클릭 횟수" + ctn);
				hokHp--;
				System.out.println("호크룩스 HP" + hokHp);
				new Bonus_Effect().hokClick();
				
				if( ctn < 5) {
					 hok1.setIcon(new ImageIcon("images/stage4/hok1.png"));
				}
				if( ctn == 15 ) {
					hok1.setIcon(new ImageIcon("images/stage4/hok2.png"));
					new Bonus_Effect().crack_L();
				} else if( ctn == 23 ) {
					hok1.setIcon(new ImageIcon("images/stage4/hok3.png"));
					new Bonus_Effect().crack_M();
				} else if( ctn == 28 ) {
					hok1.setIcon(new ImageIcon("images/stage4/hok4.png"));
					new Bonus_Effect().crack_S();
				} else if( ctn == 33 ) {
					hok1.setIcon(new ImageIcon("images/stage4/hok5.png"));
					new Bonus_Effect().crack_S();
				} else if( ctn == 45 ) {
					hok1.setIcon(new ImageIcon("images/stage4/hok6.png"));
					new Bonus_Effect().crack_M();
				} else if( ctn == 60 ) {
					hok1.setIcon(new ImageIcon("images/stage4/hok7.png"));
					new Bonus_Effect().crack_L();
				} else if (ctn > 70){
					ChangePanel cp = new ChangePanel(mf, panel);
					page3 qp = new page3 (mf);
					Bonus_Changer2 timer = new Bonus_Changer2(mf, qp);
					Thread t1 = timer;
					t1.setDaemon(true);
					t1.start();
					cp.replacePanel(qp);
//					 hok1.setIcon(new ImageIcon("images/stage4/hokLast3.gif"));
				}
				
				currLocation = mf.getLocationOnScreen();

			    Point position1 = new Point(currLocation.x + 4, currLocation.y);
			    Point position2 = new Point(currLocation.x - 4, currLocation.y);
			    for (int i = 0; i < 5; i++) {
			    	mf.setLocation(position1);
			    	mf.setLocation(position2);
			    }
			    mf.setLocation(currLocation);
			  }
		}); 
		mf.requestFocus();
		mf.setFocusable(true);
	}
}