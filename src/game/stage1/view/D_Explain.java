package game.stage1.view;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import game.stage1.controller.D_Controller;
import game.stage2.model.vo.E_EffectMusic;
import game.stage3.views.F_ChangePanel;

public class D_Explain extends JPanel {

	private JFrame mf;
	private JPanel panel;

	public D_Explain(JFrame mf) {

		this.mf = mf;
		panel = this;
		this.setLayout(null);

		this.setBounds(0, 0, 1300, 770);

		System.out.println("설명 패널 생성");
		this.setBackground(Color.black);
		JLabel clear = new JLabel(new ImageIcon(
				new ImageIcon("images/stage1/stage1_explain.png").getImage().getScaledInstance(1280, 600, 0)));

		clear.setBounds(0, 85, 1280, 600);
		
		clear.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
				F_ChangePanel cp = new F_ChangePanel(mf, panel);
				D_Controller dc = new D_Controller(mf);
				cp.replacePanel(dc);
				
				
				
			}
		});

		this.add(clear);

	}

}
