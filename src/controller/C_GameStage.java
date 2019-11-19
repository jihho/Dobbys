package controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import game.stage1.controller.D_Controller;
import game.stage2.view.E_StartPanel;
import game.stage3.views.F_Stage3Panel;

import view.A_Music;

import view.C_RandomAssign;
import view.C_RankingPage;
import view.ChangePanel;

public class C_GameStage extends JPanel{
	private ImageIcon icon;
	private JFrame mf;
	private JPanel panel;
	
	public C_GameStage(JFrame mf) {
		this.mf = mf;
		this.setLayout(null);
		
		panel = this;
		this.setBounds(0, 0, 1300, 770);
		System.out.println("게임 스테이지 패널 생성");
		
		JLabel background = new JLabel(new ImageIcon(new ImageIcon("images/main/mainpage.png").getImage().getScaledInstance(1300, 770, 0)));
		background.setBounds(0, 0, 1300, 770);
		
		
		
		// JTextArea(대화 상자) 생성  
		JTextArea ta = new JTextArea("ID : 도비1");   	//JTextArea 생성
		ta.setBounds(530, 640, 400, 60); 	    			//JTeatArea 크기 및 위치 지정
	    ta.setEditable(false); 				   				 //실행시 JtextArea edit 금지 (글을 쓸 수 없음) true면 가능
		ta.setFont(new Font("DungGeunMo", Font.PLAIN, 45)); 
		ta.setBackground(new Color(0, 0, 0, 150));
		ta.setForeground(Color.WHITE);			
		ta.setMargin(new Insets(5, 10, 5, 10));
		
		background.add(ta);
		
		
		// 버튼 생성 - 아이콘 크기 (72 * 70)
		JButton stage1_btn = new JButton(new ImageIcon("images/main/stage1_icon2.png"));
		JButton stage2_btn = new JButton(new ImageIcon("images/main/stage2_icon2.png"));
		JButton stage3_btn = new JButton(new ImageIcon("images/main/stage3_icon2.png"));
		JButton ranking_btn = new JButton(new ImageIcon("images/main/ranking_icon2.png"));
		
		JButton stage1_name = new JButton("Stage1");
		JButton stage2_name = new JButton("Stage2");
		JButton stage3_name = new JButton("Stage3");
		JButton ranking_name = new JButton("Ranking");
		
		
		// 버튼 위치와 크기 설정 
		stage1_btn.setBounds(1140, 510, 72, 70);
		stage2_btn.setBounds(860, 160, 72, 70);
		stage3_btn.setBounds(130, 160, 72, 70);
		ranking_btn.setBounds(110, 480, 72, 70);
		
		stage1_name.setBounds(1105, 465, 150, 50);
		stage2_name.setBounds(825, 115, 150, 50);
		stage3_name.setBounds(95, 115, 150, 50);
		ranking_name.setBounds(75, 435, 150, 50);
		
		
		stage1_name.setBackground(Color.GRAY);
		stage1_name.setForeground(Color.WHITE);			   			 
		stage1_name.setFont(new Font("DungGeunMo", Font.PLAIN, 30)); 
		
		stage2_name.setBackground(Color.GRAY);
		stage2_name.setForeground(Color.WHITE);			   			 
		stage2_name.setFont(new Font("DungGeunMo", Font.PLAIN, 30));
		
		stage3_name.setBackground(Color.GRAY);
		stage3_name.setForeground(Color.WHITE);			   			 
		stage3_name.setFont(new Font("DungGeunMo", Font.PLAIN, 30));
		
		ranking_name.setBackground(Color.GRAY);
		ranking_name.setForeground(Color.WHITE);			   			 
		ranking_name.setFont(new Font("DungGeunMo", Font.PLAIN, 30));
		
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
			
			C_RandomAssign ra = new C_RandomAssign(mf); 
		
			cp.replacePanel(ra);
			}
		});

		
		// stage1_btn 버튼 이벤트
		stage1_btn.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
			new A_Music().door();
			
			ChangePanel cp = new ChangePanel(mf, panel);			
			D_Controller dc = new D_Controller(mf); 			
			cp.replacePanel(dc);
			

			}
		});
		
		// stage2_btn 버튼 이벤트
		stage2_btn.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
			new A_Music().door();
			
			ChangePanel cp = new ChangePanel(mf, panel);
			E_StartPanel st2 = new E_StartPanel(mf); 
			cp.replacePanel(st2);
			}
		});
		
		// stage3_btn 버튼 이벤트
		stage3_btn.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
			new A_Music().door();
			
			ChangePanel cp = new ChangePanel(mf, panel);
			F_Stage3Panel str3 = new F_Stage3Panel(mf); 
			cp.replacePanel(str3);
			}
		});
		
		// ranking_btn 버튼 이벤트
		ranking_btn.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
			new A_Music().door();
			ChangePanel cp = new ChangePanel(mf, panel);
			C_RankingPage rp = new C_RankingPage(mf); 
			cp.replacePanel(rp);
			}
		});
		
		
		// 버튼 투명화
		stage1_btn.setContentAreaFilled(false);		// JButtondml 내용영역 채우기 안함
		//stage1_btn.setBorderPainted(false);		// JButton의 Border(외곽선)을 없애준다.
		//stage1_btn.setFocusPainted(false);		// JButton이 선택(focus)되었을 때 생기는 테두리 사용안함
		stage1_btn.setOpaque(false);
		
		stage2_btn.setContentAreaFilled(false);	
		//stage2_btn.setBorderPainted(false);		
		//stage2_btn.setFocusPainted(false);		
		stage2_btn.setOpaque(false);
		
		stage3_btn.setContentAreaFilled(false);	
		//stage3_btn.setBorderPainted(false);		
		//stage3_btn.setFocusPainted(false);		
		stage3_btn.setOpaque(false);
		
		ranking_btn.setContentAreaFilled(false);	
		//ranking_btn.setBorderPainted(false);		
		//ranking_btn.setFocusPainted(false);		
		ranking_btn.setOpaque(false);

		
		stage1_name.setContentAreaFilled(false);	
		stage1_name.setBorderPainted(false);		
		stage1_name.setFocusPainted(false);		
		stage1_name.setOpaque(false);
		
		stage2_name.setContentAreaFilled(false);	
		stage2_name.setBorderPainted(false);		
		stage2_name.setFocusPainted(false);		
		stage2_name.setOpaque(false);
		
		stage3_name.setContentAreaFilled(false);	
		stage3_name.setBorderPainted(false);		
		stage3_name.setFocusPainted(false);		
		stage3_name.setOpaque(false);
		
		ranking_name.setContentAreaFilled(false);	
		ranking_name.setBorderPainted(false);		
		ranking_name.setFocusPainted(false);		
		ranking_name.setOpaque(false);
		
		
		
		// 패널에다 버튼 추가
		this.add(return_btn);
		
		this.add(stage1_btn);
		this.add(stage2_btn);
		this.add(stage3_btn);
		this.add(ranking_btn);
		
		this.add(stage1_name);
		this.add(stage2_name);
		this.add(stage3_name);
		this.add(ranking_name);

		
		// 마우스 효과 - 하영씨
		setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
				new ImageIcon("images/main/mouse.png").getImage(),
				new Point(0,0),"images/main/mouse.png"));
		
		
		// 패널에다 배경 라벨 추가
		this.add(background);

	}
	
	
		
}



