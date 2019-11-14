package game.stage2.view;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GamePanel extends JPanel{
	private JFrame mf;
	private JPanel panel;
	
	public GamePanel(JFrame mf) {
		this.mf = mf;
		this.setLayout(null);
		
		panel = this;
		
		JLabel label = new JLabel(new ImageIcon(new ImageIcon("images/stage2/stage2_bg2.PNG").
				getImage().getScaledInstance(1280, 720, 0)));
		label.setBounds(0, 0, 1280, 720);
		
		System.out.println("배경");
		
			
		JLabel quest1 = new JLabel(new ImageIcon(new ImageIcon("images/stage2/quest1.PNG").
				getImage().getScaledInstance(264, 275, 0)));
		quest1.setBounds(910, 130, 264, 275);
		
		System.out.println("문제");
		
		
/*		Timer hide = new Timer();
		TimerTask task = new TimerTask() {
			
			@Override
			public void run() {
				 quest1 = new JLabel(new ImageIcon(new ImageIcon("image/stage2/quest1.PMG").
						getImage().getScaledInstance(264, 275, 0)));
				quest1.setBounds(910,130,264,275);
				
			}
		};
		hide.schedule(task, 3000);
		//hide.schedule(task, 5000);
*/
		
		this.add(label);
		this.add(quest1);
		//mf.add(this);
		
		this.setComponentZOrder(label, 1);
		System.out.println("왜안돼");
		
		
		
		
	}
	
}
