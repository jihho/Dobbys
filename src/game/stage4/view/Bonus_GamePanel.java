package game.stage4.view;

import java.awt.Color;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import view.A_LoginPanel;
import view.ChangePanel;

public class Bonus_GamePanel extends JPanel {
 
	private JFrame mf;
	private JPanel panel;
	private int ctn = 0;	//클릭횟수
	private int imgNum = 1;
	Point currLocation;
	
	public Bonus_GamePanel(JFrame mf) {
		this.mf = mf;
		this.setLayout(null);
		panel = this;
		
		
		this.setBackground(Color.BLACK);
		JButton hok1 = new JButton(new ImageIcon(new ImageIcon("images/stage4/hok" + imgNum + ".png").
				getImage().getScaledInstance(500, 400, 0)));
		hok1.setBounds(400, 185, 500, 400);
		hok1.setBorderPainted(false);		//외곽선 제거
		
		this.add(hok1);
		
		setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
				new ImageIcon("images/main/mouseHok.png").getImage(),
				new Point(0,0),"DobbyCursor"));
		
		
		
	
		hok1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ctn++;
				
				if(ctn < 69) {
				new Bonus_Effect().hokClick();
				}
				
				if( ctn < 5) {
					 hok1.setIcon(new ImageIcon("images/stage4/hok1.png"));
				} else if( ctn == 8 ) {
					hok1.setIcon(new ImageIcon("images/stage4/hok2.png"));
					new Bonus_Effect().crack_L();
				} else if( ctn == 13 ) {
					hok1.setIcon(new ImageIcon("images/stage4/hok3.png"));
					new Bonus_Effect().crack_M();
				} else if( ctn == 16 ) {
					hok1.setIcon(new ImageIcon("images/stage4/hok4.png"));
					new Bonus_Effect().crack_S();
				} else if( ctn == 20 ) {
					hok1.setIcon(new ImageIcon("images/stage4/hok5.png"));
					new Bonus_Effect().crack_S();
				} else if( ctn == 26 ) {
					hok1.setIcon(new ImageIcon("images/stage4/hok6.png"));
					new Bonus_Effect().crack_M();
				} else if( ctn == 34 ) {
					hok1.setIcon(new ImageIcon("images/stage4/hok7.png"));
					new Bonus_Effect().crack_L();
				} else if (ctn > 40){
					
					int rndMouse = new Random().nextInt(6) + 2;
					
					A_LoginPanel.mouseNum = rndMouse;
					new Bonus_Effect().hokLastEffect();
					ChangePanel cp = new ChangePanel(mf, panel);
					hokLast qp = new hokLast (mf);
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