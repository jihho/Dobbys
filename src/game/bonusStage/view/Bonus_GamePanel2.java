package game.bonusStage.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Bonus_GamePanel2 extends JPanel implements Runnable {
 
	private JFrame mf;
	private JPanel panel;
	private int ctn = 0;	//클릭횟수
	private int hokHp = 20;
	private JButton button;
	
	public Bonus_GamePanel2(JFrame mf) throws Exception {
		this.mf = mf;
		this.setLayout(null);
		panel = this;
		this.setBackground(Color.BLACK);
		SwingUtilities.invokeLater(new Bonus_GamePanel2(mf));
		
		mf.requestFocus();
		mf.setFocusable(true);
		
		
	}
	
	@Override
	public void run() {
		
		button = new JButton(new ImageIcon("images/bonus/hok1.png"));
		button.setBounds(400, 185, 500, 400);
		button.setFont(new Font("DungGeunMo", Font.BOLD, 40));
		button.setBorderPainted(false);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				shakeButton();
			}
		});
	}
	

	 private void shakeButton() {
		    final Point point = button.getLocation();
		    final Insets margin = button.getMargin();
		    final int delay = 10;
		    Runnable r = new Runnable() {
		      @Override
		      public void run() {
		        for (int i = 0; i < 5; i++) {
		          try {
		            setButtonMargin(new Insets(margin.top, margin.left + 5,
		                margin.bottom, margin.right - 4));
		            Thread.sleep(delay);
		            setButtonMargin(margin);
		            Thread.sleep(delay);
		            setButtonMargin(new Insets(margin.top, margin.left - 4,
		                margin.bottom, margin.right + 5));
		            Thread.sleep(delay);
		            setButtonMargin(margin);
		            Thread.sleep(delay);
		          } catch (InterruptedException ex) {
		            ex.printStackTrace();
		          }
		        }
		      }
		    };
		    Thread t = new Thread(r);
		    t.start();
		  }

		  private void setButtonMargin(final Insets margin) {
		    SwingUtilities.invokeLater(new Runnable() {

		      @Override
		      public void run() {
		        button.setMargin(margin);
		      }
		    });
		  }
		  
		  
}
