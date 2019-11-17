package game.stage2.view;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class E_SuccessPanel extends JPanel{
	private JFrame mf;
	private JPanel panel;
	
	public E_SuccessPanel(JFrame mf) {
		
		this.mf = mf;
		panel = this;
		
		JLabel suc = new JLabel(new ImageIcon(new ImageIcon("images/stage2/stage2_suss.gif").
				getImage().getScaledInstance(1280, 720, 0)));
		
		this.add(suc, "Center");
		
	}
	
	
}
