package view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.C_GameStage;

public class B_IntroVideoPanel extends JPanel{
	private JFrame mf;
	private JPanel panel;
	public B_IntroVideoPanel(JFrame mf){
		this.mf = mf;
		this.setLayout(null);
		
		panel = this;
		
		JLabel label = new JLabel(new ImageIcon(new ImageIcon("images/main/resizeIntroVideo.gif").getImage().getScaledInstance(1300, 770, 0)));
		label.setBounds(0, 0, 1300, 770);
		
		JLabel start = new JLabel(new ImageIcon(new ImageIcon("images/main/skipButton.PNG").getImage().getScaledInstance(300, 200, 0)));
		start.setBounds(10, 550, 300, 200);
		new A_Music().trainSound();

		start.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				new A_Music().intoBgmStop();
				ChangePanel cp = new ChangePanel(mf, panel);
				C_GameStage gs = new C_GameStage(mf);
				cp.replacePanel(gs);
			}
		
		});
		
		this.add(label);
		this.add(start);
		this.setComponentZOrder(label, 1);
		
		
	}

}
