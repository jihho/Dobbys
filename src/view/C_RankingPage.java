package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class C_RankingPage extends JPanel{
	private ImageIcon icon;
	private JFrame mf;
	private JPanel panel;
	
	public C_RankingPage(JFrame mf) {

		this.mf = mf;
		this.setLayout(null);
		
		panel = this;
		this.setBounds(0, 0, 1300, 770);
		
		// 배경 라벨 생성
		JLabel background = new JLabel(new ImageIcon(new ImageIcon("images/main/score.png").getImage().getScaledInstance(1300, 770, 0)));
		background.setBounds(0, 0, 1300, 770);
				
		
		// 라벨 생성 
		JLabel score_title = new JLabel("SCORE");
		
		JLabel stage1_name = new JLabel("Stage1");
		JLabel stage2_name = new JLabel("Stage2");
		JLabel stage3_name = new JLabel("Stage3");
		JLabel ranking_name = new JLabel("Ranking");
		
		
		// 라벨 위치와 크기 설정 	
		score_title.setBounds(540, -70, 400, 300);
		
		stage1_name.setBounds(200, 255, 170, 50);
		stage2_name.setBounds(395, 255, 170, 50);
		stage3_name.setBounds(590, 255, 170, 50);
		ranking_name.setBounds(792, 255, 200, 50);
		
		
		score_title.setForeground(Color.WHITE);			   			 
		score_title.setFont(new Font("DungGeunMo", Font.PLAIN, 110)); 
		
		stage1_name.setForeground(Color.WHITE);			   			 
		stage1_name.setFont(new Font("DungGeunMo", Font.PLAIN, 40)); 
		
		stage2_name.setForeground(Color.WHITE);			   			 
		stage2_name.setFont(new Font("DungGeunMo", Font.PLAIN, 40));
		
		stage3_name.setForeground(Color.WHITE);			   			 
		stage3_name.setFont(new Font("DungGeunMo", Font.PLAIN, 40));
		
		ranking_name.setForeground(Color.WHITE);			   			 
		ranking_name.setFont(new Font("DungGeunMo", Font.PLAIN, 40));
		
		
		
		
		// 되돌아가기 버튼 생성
		JButton return_btn = new JButton("RETURN");
		return_btn.setBounds(1115, 660, 150, 50);
//		return_Btn.setBackground(new Color(252, 220, 3));
//		return_Btn.setForeground(Color.BLACK);			   			   // 버튼 글자 색깔 변경
		return_btn.setBackground(Color.GRAY);
		return_btn.setForeground(Color.WHITE);			   			   // 버튼 글자 색깔 변경
		
		return_btn.setFont(new Font("DungGeunMo", Font.PLAIN, 30));      // 버튼 글자 폰트, 효과, 크기 변경
		return_btn.setFocusPainted(false);
		return_btn.setBorderPainted(false);		// JButton의 Border(외곽선)을 없애준다.
		//S_btn.setContentAreaFilled(false);	// JButton 내용영역 채우기 안함
		return_btn.setFocusPainted(false);		// JButton이 선택(focus)되었을 때 생기는 테두리 사용안함
		
		
		
		
		
		// return_Btn 버튼 이벤트
		return_btn.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
			ChangePanel cp = new ChangePanel(mf, panel);
			
			C_AssignDormitory ad = new C_AssignDormitory(mf); 
		
			cp.replacePanel(ad);
			}
		});
		
		score_title.setOpaque(false);
		stage1_name.setOpaque(false);
		stage2_name.setOpaque(false);
		stage3_name.setOpaque(false);
		ranking_name.setOpaque(false);
		
		
		// 패널에다 버튼 추가
		this.add(score_title);
		
		this.add(return_btn);
		
		this.add(stage1_name);
		this.add(stage2_name);
		this.add(stage3_name);
		this.add(ranking_name);

		// 패널에다 배경 라벨 추가
		this.add(background);
		
			
	}
	
}
