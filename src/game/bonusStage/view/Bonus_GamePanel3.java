package game.bonusStage.view;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Bonus_GamePanel3 extends JPanel {
 
	private JFrame mf;
	private JPanel panel;
	private int ctn = 0;	//클릭횟수
	private int imgNum = 1;
	private int hokHp = 20;
	Point currLocation;
	
	public Bonus_GamePanel3(JFrame mf) {
		this.mf = mf;
		this.setLayout(null);
		panel = this;
		
		this.setBackground(Color.BLACK);
		
		JButton hok1 = new JButton(new ImageIcon(new ImageIcon("images/bonus/hok" + imgNum + ".png").
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
				
				if( ctn < 5) {
					 hok1.setIcon(new ImageIcon("images/bonus/hok1.png"));
				}
				if( ctn == 5 ) {
					hok1.setIcon(new ImageIcon("images/bonus/hok2.png"));
				} else if( ctn == 10 ) {
					hok1.setIcon(new ImageIcon("images/bonus/hok3.png"));
				} else if( ctn == 15 ) {
					hok1.setIcon(new ImageIcon("images/bonus/hok4.png"));
				} else if( ctn == 20 ) {
					hok1.setIcon(new ImageIcon("images/bonus/hok5.png"));
				} else if( ctn == 25 ) {
					hok1.setIcon(new ImageIcon("images/bonus/hok6.png"));
				} else if( ctn == 30 ) {
					hok1.setIcon(new ImageIcon("images/bonus/hok7.png"));
				} else if (ctn > 35){
					 hok1.setIcon(new ImageIcon("images/bonus/hokLast3.gif"));
				}
				
				
//				if (ctn > 10 && ctn < 15 ) {
//					imgNum = 2;
//					System.out.println(imgNum);
//				} else if ( ctn >= 15) {
//					imgNum = 1;
//					 hok1.setIcon(new ImageIcon("images/bonus/hokLast2.gif"));
//				}
				
				
				
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