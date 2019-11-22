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
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import game.stage1.view.D_Explain;
import game.stage2.view.E_StartPanel;
import game.stage3.views.F_Stage3Panel;
import game.stage3.views.F_Stage3rule;
import game.stage4.view.Bonus_Changer;
import game.stage4.view.hokVideo;
import game.stage4.view.page;
import game.stage5.view.C_DobbyPanel;
import game.stage6.view.Bonus2_Background;
import game.stage6.view.Bonus2_StartPanel;
import model.vo.User;

import view.A_ChangePage;
import view.A_FindPage;
import view.A_IntroPage;

import view.A_LoginPanel;
import view.A_Music;
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
		
		new A_Music().TalesWeaver();

		JLabel background = new JLabel(new ImageIcon(new ImageIcon("images/main/mainpage.png").getImage().getScaledInstance(1300, 770, 0)));
		background.setBounds(0, 0, 1300, 770);
		
		B_UserManager um = new B_UserManager();
		String[] test = um.selectUserScore(User.playerId);
		
		
		// JTextArea(대화 상자) 생성  
		JTextArea ta = new JTextArea(test[4] + "님이 접속하셨습니다.");   	//JTextArea 생성
		ta.setBounds(380, 650, test[4].length()*50 + 450, 60); 	    	//JTeatArea 크기 및 위치 지정
	    ta.setEditable(false); 				   				 			//실행시 JtextArea edit 금지 (글을 쓸 수 없음) true면 가능
		ta.setFont(new Font("DungGeunMo", Font.PLAIN, 45)); 
		ta.setBackground(new Color(0, 0, 0, 150));
		ta.setForeground(Color.WHITE);			
		ta.setMargin(new Insets(5, 10, 5, 10));
		
		background.add(ta);
		
		
		// 버튼 생성 - 아이콘 크기 (72 * 70)
		JButton stage1_btn = new JButton(new ImageIcon("images/main/stage1_icon2.png"));
		JButton stage2_btn = new JButton(new ImageIcon("images/main/stage2_icon2.png"));
		JButton stage3_btn = new JButton(new ImageIcon("images/main/stage3_icon2.png"));
		JButton stage4_btn = new JButton(new ImageIcon("images/main/remove.png"));
		JButton stage5_btn = new JButton(new ImageIcon("images/main/remove.png"));
		JButton stage6_btn = new JButton(new ImageIcon("images/main/remove.png"));
		JButton ranking_btn = new JButton(new ImageIcon("images/main/ranking_icon2.png"));

		JButton	myinfo_btn = new JButton("내 정보");
		JButton modify_btn = new JButton("정보수정");
		JButton logout_btn = new JButton("로그아웃");
		

		JLabel stage1_name = new JLabel("Stage1");
		JLabel stage2_name = new JLabel("Stage2");
		JLabel stage3_name = new JLabel("Stage3");
		JLabel ranking_name = new JLabel("Ranking");
		
		JLabel slytherin_la = new JLabel(new ImageIcon("images/main/z_slytherin(200x250).png"));
		JLabel ravaenclaw_la = new JLabel(new ImageIcon("images/main/z_ravaenclaw(200x250).png"));
		JLabel huffepuff_la = new JLabel(new ImageIcon("images/main/z_huffepuff(200x250).png"));
		JLabel gryffindor_la = new JLabel(new ImageIcon("images/main/z_gryffindor(200x250).png"));
	
		JDialog my = new JDialog(mf, "내 정보");
		JTextArea mm = new JTextArea("닉네임 : " + test[4] + "\n\n아이디 : " + User.playerId + "\n\n이메일 : "+ um.selectEmail(User.playerId) +"\n\n기숙사 : " + test[5] + "\n");
		my.setBounds(540, 500, 500, 600);
		my.setLocationRelativeTo(mf);
		my.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		mm.setForeground(Color.BLACK);	
		mm.setFont(new Font("DungGeunMo", Font.PLAIN, 30));
		
		modify_btn.setForeground(Color.WHITE);			   			    
		modify_btn.setFont(new Font("DungGeunMo", Font.PLAIN, 25));
		
		switch(test[5]) {
		case "slytherin" : 
			my.add(slytherin_la, "Center"); 
			modify_btn.setBackground(new Color(9, 71, 34)); 
			break;
		case "ravaenclaw" : 
			my.add(ravaenclaw_la, "Center"); 
			modify_btn.setBackground(new Color(26, 40, 125)); 
			break;
		case "huffepuff" : my.add(huffepuff_la, "Center"); 
			modify_btn.setForeground(Color.BLACK);	
			modify_btn.setBackground(new Color(252, 220, 3)); 
			break;
		case "gryffindor" : 
			my.add(gryffindor_la, "Center"); 
			modify_btn.setBackground(new Color(167, 15, 14)); 
			break;
		}
		my.add(mm, "North");
		my.add(modify_btn, "South");
		
		ImageIcon key = new ImageIcon("images/main/key.gif");
		ImageIcon jinho = new ImageIcon("images/main/jinho.png");
		ImageIcon jinho2 = new ImageIcon("images/main/jinho2.png");
		
		// 열쇠 이미지 효과
		stage1_btn.setRolloverIcon(key);
		stage2_btn.setRolloverIcon(key);
		stage3_btn.setRolloverIcon(key);
		stage4_btn.setRolloverIcon(jinho);
		stage5_btn.setRolloverIcon(jinho);
		stage6_btn.setRolloverIcon(jinho2);
		ranking_btn.setRolloverIcon(key);
		stage1_btn.setBorderPainted(false);
		stage2_btn.setBorderPainted(false);
		stage3_btn.setBorderPainted(false);
		stage4_btn.setBorderPainted(false);
		stage5_btn.setBorderPainted(false);
		stage6_btn.setBorderPainted(false);
		ranking_btn.setBorderPainted(false);
		
		// 위치와 크기 설정 
		stage1_btn.setBounds(1140, 510, 72, 70);
		stage2_btn.setBounds(860, 160, 72, 70);
		stage3_btn.setBounds(130, 160, 72, 70);
		stage4_btn.setBounds(470, 165, 150, 100);
		stage5_btn.setBounds(900, 350, 150, 100);
		stage6_btn.setBounds(185, 340, 150, 100);
		ranking_btn.setBounds(110, 480, 72, 70);
		myinfo_btn.setBounds(10, 660, 140, 50);
		modify_btn.setBounds(160, 660, 150, 50);
		logout_btn.setBounds(1115, 660, 150, 50);
		
		stage1_name.setBounds(1135, 465, 150, 50);
		stage2_name.setBounds(855, 115, 150, 50);
		stage3_name.setBounds(125, 115, 150, 50);
		ranking_name.setBounds(100, 435, 150, 50);
		
		// 글자 설정
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

		myinfo_btn.setBackground(Color.GRAY);
		myinfo_btn.setForeground(Color.WHITE);			   			    
		myinfo_btn.setFont(new Font("DungGeunMo", Font.PLAIN, 25)); 

		logout_btn.setBackground(Color.GRAY);
		logout_btn.setForeground(Color.WHITE);			   			    
		logout_btn.setFont(new Font("DungGeunMo", Font.PLAIN, 25));

		// 버튼 설정
		stage1_btn.setContentAreaFilled(false);		// JButtondml 내용영역 채우기 안함
		stage1_btn.setOpaque(false);
		//stage1_btn.setBorderPainted(false);		// JButton의 Border(외곽선)을 없애준다.
		//stage1_btn.setFocusPainted(false);		// JButton이 선택(focus)되었을 때 생기는 테두리 사용안함
		stage2_btn.setContentAreaFilled(false);	
		stage2_btn.setOpaque(false);
		stage3_btn.setContentAreaFilled(false);	
		stage3_btn.setOpaque(false);
		stage4_btn.setContentAreaFilled(false);	
		stage4_btn.setBorderPainted(false);		
		stage4_btn.setOpaque(false);
		stage5_btn.setContentAreaFilled(false);	
		stage5_btn.setBorderPainted(false);		
		stage5_btn.setOpaque(false);
		stage6_btn.setContentAreaFilled(false);	
		stage6_btn.setBorderPainted(false);		
		stage6_btn.setOpaque(false);
		ranking_btn.setContentAreaFilled(false);	
		ranking_btn.setOpaque(false);
		
		myinfo_btn.setFocusPainted(false);
		myinfo_btn.setBorderPainted(false);		
		myinfo_btn.setFocusPainted(false);		
		modify_btn.setFocusPainted(false);
		modify_btn.setBorderPainted(false);		
		modify_btn.setFocusPainted(false);		
		logout_btn.setFocusPainted(false);
		logout_btn.setBorderPainted(false);		
		logout_btn.setFocusPainted(false);		
		
		
		myinfo_btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				my.setVisible(true);
				
				modify_btn.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseReleased(MouseEvent e) {
						new A_Music().intoBgmStopJ2();
						my.setVisible(false);
						ChangePanel cp = new ChangePanel(mf, panel);
						A_ChangePage ap = new A_ChangePage(mf);
						cp.replacePanel(ap);
					}
				});
				
			}
		});
		
		// return_Btn 버튼 이벤트
		logout_btn.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
			new A_Music().introBgm();
			my.setVisible(false);
			
			ChangePanel cp = new ChangePanel(mf, panel);
			A_LoginPanel lp = new A_LoginPanel(mf); 
			cp.replacePanel(lp);
			
			new A_Music().intoBgmStopJ2();
			}
		});

		
		// stage1_btn 버튼 이벤트
		stage1_btn.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
			new A_Music().door();
			new A_Music().intoBgmStopJ2();
			my.setVisible(false);
			
			ChangePanel cp = new ChangePanel(mf, panel);			
			D_Explain de = new D_Explain(mf); 			
			cp.replacePanel(de);
			
			}
		});
		
		// stage2_btn 버튼 이벤트
		stage2_btn.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
			new A_Music().door();
    		new A_Music().intoBgmStopJ2();
			my.setVisible(false);
			
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
			new A_Music().intoBgmStopJ2();
			my.setVisible(false);
			
			ChangePanel cp = new ChangePanel(mf, panel);
			F_Stage3rule str3 = new F_Stage3rule(mf); 
			cp.replacePanel(str3);
			}
		});
		
		// stage4_btn 버튼 이벤트
		stage4_btn.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
			new A_Music().door();
			new A_Music().intoBgmStopJ2();
			my.setVisible(false);
			
			ChangePanel cp = new ChangePanel(mf, panel);
			hokVideo qp = new hokVideo (mf);
			Bonus_Changer timer = new Bonus_Changer(mf, qp);
			Thread t1 = timer;
			t1.setDaemon(true);
			t1.start();
			cp.replacePanel(qp);
			}
		});
		
		// stage5_btn 버튼 이벤트
		stage5_btn.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
			new A_Music().door();
			new A_Music().intoBgmStopJ2();
			my.setVisible(false);
			
			ChangePanel cp = new ChangePanel(mf, panel);
			C_DobbyPanel str5 = new C_DobbyPanel(mf); 
			cp.replacePanel(str5);
			}
		});
		
		// stage6_btn 버튼 이벤트
		stage6_btn.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
			new A_Music().door();
			new A_Music().intoBgmStopJ2();
			my.setVisible(false);
			
			ChangePanel cp = new ChangePanel(mf, panel);
			Bonus2_StartPanel str6 = new Bonus2_StartPanel(mf); 
			cp.replacePanel(str6);
			}
		});
		
		// ranking_btn 버튼 이벤트
		ranking_btn.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
			new A_Music().door();
			new A_Music().intoBgmStopJ2();
			my.setVisible(false);
			
			ChangePanel cp = new ChangePanel(mf, panel);
			C_RankingPage rp = new C_RankingPage(mf); 
			cp.replacePanel(rp);
			}
		});
		
		

		
		
		// 패널에 추가
		this.add(myinfo_btn);
//		this.add(modify_btn);
		this.add(logout_btn);

		this.add(stage1_btn);
		this.add(stage2_btn);
		this.add(stage3_btn);
		this.add(stage4_btn);
		this.add(stage5_btn);
		this.add(stage6_btn);
		this.add(ranking_btn);
		
		this.add(stage1_name);
		this.add(stage2_name);
		this.add(stage3_name);
		this.add(ranking_name);

		this.add(background);

		
		// 마우스 효과 - 하영씨
		setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
				new ImageIcon("images/main/mouse" + A_LoginPanel.mouseNum + ".png").getImage(),
				new Point(0,0),"dobby mouse"));
	}
}



