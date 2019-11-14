package view;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class IntroVideoPanel extends JPanel{
	private JFrame mf;
	private JPanel panel;
	public IntroVideoPanel(JFrame mf){
		this.mf = mf;
		this.setLayout(null);
		
		panel = this;
		
		JLabel label = new JLabel(new ImageIcon(new ImageIcon("images/main/resizeIntroVideo.gif").getImage().getScaledInstance(1300, 770, 0)));
		label.setBounds(0, 0, 1300, 770);
		
		JLabel start = new JLabel(new ImageIcon(new ImageIcon("images/main/skipButton.PNG").getImage().getScaledInstance(300, 200, 0)));
		start.setBounds(180, 550, 300, 200);
		

		this.add(label);
		this.add(start);
		this.setComponentZOrder(label, 1);
		
		
	}

}
