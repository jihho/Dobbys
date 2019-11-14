package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class RankingPage extends JPanel{
	private ImageIcon icon;
	private JFrame mf;
	private JPanel panel;
	
	public RankingPage(JFrame mf) {

		this.mf = mf;
		this.setLayout(null);
		
		panel = this;
		this.setBounds(0, 0, 1300, 770);
		System.out.println("패널 생성");
		
		// 배경 라벨 생성
		JLabel background = new JLabel(new ImageIcon(new ImageIcon("images/main/score.png").getImage().getScaledInstance(1300, 770, 0)));
		background.setBounds(0, 0, 1300, 770);
				
		
		// 버튼 생성
		JButton return_btn = new JButton("처음으로");
		return_btn.setBounds(540, 500, 200, 100);
		return_btn.setBackground(Color.GRAY);        	   		// 버튼 색깔 변경
		return_btn.setForeground(Color.WHITE);			    // 버튼 글자 색깔 변경
		return_btn.setFont(new Font("DungGeunMo TTF", Font.BOLD, 40));      // 버튼 글자 폰트, 효과, 크기 변경
		return_btn.setFocusPainted(false);
		
		// 버튼 이벤트
		return_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ChangePanel cp = new ChangePanel(mf, panel);
				C_AssignDormitory ad = new C_AssignDormitory(mf);
				cp.replacePanel(ad);
		
			}
		});
		
		this.add(return_btn);
		this.add(background);

			
	}
	
}
