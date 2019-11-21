package game.stage5.view;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Timer extends Thread{
	private JFrame mf;
	private JPanel panel;
	private String dobbyIsFree;
	
	public Timer(JFrame mf, JPanel panel){
		this.mf = mf;
		this.panel = panel;
	}

	@Override
	public void run() {
		JTextField label = new JTextField("남은시간 : ");
		label.setBounds(1060, 20, 200, 50);
		label.setFont(new Font("DungGeunMo", Font.PLAIN, 30));
		panel.add(label);
		for(int i = 60; i >= 0; i--){
			try {
				System.out.println(i);
				this.sleep(100);
				label.setText("남은시간 : " + i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		dobbyIsFree = JOptionPane.showInputDialog(new ImageIcon(new ImageIcon("images/gift.png").getImage().getScaledInstance(300, 300, 0)));
	}

}
