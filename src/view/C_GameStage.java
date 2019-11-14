package view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class C_GameStage extends JPanel{
	private ImageIcon icon;
	private JFrame mf;
	private JPanel panel;
	
	
	public C_GameStage(JFrame mf) {
		this.mf = mf;
		this.setLayout(null);
		
		panel = this;
		this.setBounds(0, 0, 1300, 770);
		System.out.println("패널 생성");

		JLabel background = new JLabel(new ImageIcon(new ImageIcon("images/main/mainpage.png").getImage().getScaledInstance(1300, 770, 0)));
		background.setBounds(0, 0, 1300, 770);
		
		
		// 버튼 생성 - 아이콘 크기 (72 * 70)
		JButton stage1_btn = new JButton(new ImageIcon("images/main/stage1_icon2.png"));
		JButton stage2_btn = new JButton(new ImageIcon("images/main/stage2_icon2.png"));
		JButton stage3_btn = new JButton(new ImageIcon("images/main/stage3_icon2.png"));
		JButton ranking_btn = new JButton(new ImageIcon("images/main/ranking_icon2.png"));
		
		// 버튼 위치와 크기 설정 
		stage1_btn.setBounds(1140, 510, 72, 70);
		stage2_btn.setBounds(860, 160, 72, 70);
		stage3_btn.setBounds(130, 160, 72, 70);
		ranking_btn.setBounds(110, 480, 72, 70);
		

		
		// ranking_btn 버튼 이벤트
		ranking_btn.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
			ChangePanel cp = new ChangePanel(mf, panel);
			
			RankingPage rp = new RankingPage(mf); 
		
			cp.replacePanel(rp);
			}
		});
		
		
		
		
		
		

		
		// 버튼 투명화
		//stage1_btn.setBorderPainted(false);		// JButton의 Border(외곽선)을 없애준다.
		stage1_btn.setContentAreaFilled(false);	// JButtondml 내용영역 채우기 안함
		//stage1_btn.setFocusPainted(false);		// JButton이 선택(focus)되었을 때 생기는 테두리 사용안함
		stage1_btn.setOpaque(false);
		
		//stage2_btn.setBorderPainted(false);		
		stage2_btn.setContentAreaFilled(false);	
		//stage2_btn.setFocusPainted(false);		
		stage2_btn.setOpaque(false);
		
		//stage3_btn.setBorderPainted(false);		
		stage3_btn.setContentAreaFilled(false);	
		//stage3_btn.setFocusPainted(false);		
		stage3_btn.setOpaque(false);
		
		//ranking_btn.setBorderPainted(false);		
		ranking_btn.setContentAreaFilled(false);	
		//ranking_btn.setFocusPainted(false);		
		ranking_btn.setOpaque(false);

		
		// 패널에다 버튼 추가
		this.add(stage1_btn);
		this.add(stage2_btn);
		this.add(stage3_btn);
		this.add(ranking_btn);

		// 패널에다 배경 라벨 추가
		this.add(background);

		
		
	}


}
