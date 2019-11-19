package view;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import controller.B_UserManager;
import controller.C_GameStage;
import model.vo.User;

public class C_RandomAssign extends JPanel{
	private ImageIcon icon;
	private JFrame mf;
	private JPanel panel;
	private int ctn = 0;
	
	public C_RandomAssign(JFrame mf) {
		
		this.mf = mf;
		this.setLayout(null);
		
		panel = this;
		System.out.println("랜덤 반 배정 패널 생성");
		
		// 라벨 생성
		JLabel background = new JLabel(new ImageIcon(new ImageIcon("images/main/sortpage.png").getImage().getScaledInstance(1300, 770, 0)));
		JLabel slytherin_la = new JLabel(new ImageIcon("images/main/z_slytherin(200x250).png"));
		JLabel ravaenclaw_la = new JLabel(new ImageIcon("images/main/z_ravaenclaw(200x250).png"));
		JLabel huffepuff_la = new JLabel(new ImageIcon("images/main/z_huffepuff(200x250).png"));
		JLabel gryffindor_la = new JLabel(new ImageIcon("images/main/z_gryffindor(200x250).png"));

		//JButton 생성
		JButton random_btn = new JButton("배 정");
		JButton S_btn = new JButton("슬리데린!");
		JButton H_btn = new JButton("후플푸프!");
		JButton R_btn = new JButton("래번클로!");
		JButton G_btn = new JButton("그리핀도르!");
		
		// JDaialo 생성
		JDialog S_sd = new JDialog(mf, "Slytherin");
		JDialog H_sd = new JDialog(mf, "Huffepuff");
		JDialog R_sd = new JDialog(mf, "Ravaenclaw");
		JDialog G_sd = new JDialog(mf, "Gryffindor");

		// User 매니저 생성자 생성
		B_UserManager um = new B_UserManager();
		
		// 위치 및 크기 지정
		this.setBounds(0, 0, 1300, 770);
		background.setBounds(0, 0, 1300, 770);
		random_btn.setBounds(540, 500, 200, 100);

		slytherin_la.setBounds(-350, -50, 1000, 500);
		ravaenclaw_la.setBounds(-20, -50, 1000, 500);
		huffepuff_la.setBounds(300, -50, 1000, 500);
		gryffindor_la.setBounds(600, -50, 1000, 500);

		S_btn.setBounds(540, 500, 120, 70);
		H_btn.setBounds(540, 500, 120, 70);
		R_btn.setBounds(540, 500, 120, 70);
		G_btn.setBounds(540, 500, 120, 70);

		S_sd.setBounds(390, 270, 550, 370);    
		H_sd.setBounds(390, 270, 550, 370);
		R_sd.setBounds(390, 270, 550, 370); 
		G_sd.setBounds(390, 270, 550, 370); 
		
		S_sd.setLocationRelativeTo(mf);
		H_sd.setLocationRelativeTo(mf);
		R_sd.setLocationRelativeTo(mf);
		G_sd.setLocationRelativeTo(mf);
		
		// 폰트, 색상 설정
		random_btn.setBackground(Color.GRAY);        	   				 // 버튼 색깔 변경
		random_btn.setForeground(Color.WHITE);			  			     // 버튼 글자 색깔 변경
		random_btn.setFont(new Font("DungGeunMo", Font.PLAIN, 40));      // 버튼 글자 폰트, 효과, 크기 변경
		
		S_btn.setBackground(new Color(9, 71, 34));
		S_btn.setForeground(Color.WHITE);			   
		S_btn.setFont(new Font("DungGeunMo", Font.PLAIN, 30)); 
		
		H_btn.setBackground(new Color(252, 220, 3));
		H_btn.setForeground(Color.BLACK);			   
		H_btn.setFont(new Font("DungGeunMo", Font.PLAIN, 30));    
		
		R_btn.setBackground(new Color(26, 40, 125));
		R_btn.setForeground(Color.WHITE);			   
		R_btn.setFont(new Font("DungGeunMo", Font.PLAIN, 30)); 
		
		G_btn.setBackground(new Color(167, 15, 14));
		G_btn.setForeground(Color.WHITE);			   
		G_btn.setFont(new Font("DungGeunMo", Font.PLAIN, 30)); 
		
		
		// 기타 효과 
		random_btn.setFocusPainted(false);		// JButton이 선택(focus)되었을 때 생기는 테두리 사용안함

		S_btn.setBorderPainted(false);			// JButton의 Border(외곽선)을 없애준다.
		S_btn.setFocusPainted(false);			
		//S_btn.setContentAreaFilled(false);	// JButton 내용영역 채우기 안함
		
		H_btn.setBorderPainted(false);		
		H_btn.setFocusPainted(false);		
		//H_btn.setContentAreaFilled(false);	
		
		R_btn.setBorderPainted(false);		
		R_btn.setFocusPainted(false);		
		//R_btn.setContentAreaFilled(false);	
		
		G_btn.setBorderPainted(false);		
		G_btn.setFocusPainted(false);		
		//G_btn.setContentAreaFilled(false);	

		
		// 이벤트 설정
 		random_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				um.updateLoginCount(User.playerId);

				int ra_random = new Random().nextInt(4) + 1;
				switch(ra_random) {
				case 1 : um.updateDormitory(User.playerId, "slytherin"); S_sd.setVisible(true); break;
				case 2 : um.updateDormitory(User.playerId, "huffepuff"); H_sd.setVisible(true); break;
				case 3 : um.updateDormitory(User.playerId, "ravaenclaw"); R_sd.setVisible(true); break;
				case 4 : um.updateDormitory(User.playerId, "gryffindor"); G_sd.setVisible(true); new A_Music().gryffindor(); break;	
				}

			}
		});

		// JDialog 버튼 클릭시 창 전환 이벤트
		S_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ChangePanel cp = new ChangePanel(mf, panel);
				C_GameStage gs = new C_GameStage(mf);
				cp.replacePanel(gs);
				
				S_sd.dispose();
			}
		});
		H_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ChangePanel cp = new ChangePanel(mf, panel);
				C_GameStage gs = new C_GameStage(mf);
				cp.replacePanel(gs);
				
				H_sd.dispose();
				
			}
		});
		R_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ChangePanel cp = new ChangePanel(mf, panel);
				C_GameStage gs = new C_GameStage(mf);
				cp.replacePanel(gs);
				
				R_sd.dispose();
			}
		});
		G_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ChangePanel cp = new ChangePanel(mf, panel);
				C_GameStage gs = new C_GameStage(mf);
				cp.replacePanel(gs);
	    		
				new A_Music().intoBgmStop();
				G_sd.dispose();
			}
		});
		
		// JDialog X button 
		S_sd.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		H_sd.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		R_sd.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		G_sd.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// Dialog 생성 및 이미지 첨부 및 버튼 생성
		S_sd.add(new JLabel((new ImageIcon("images/main/z_slytherin(200x250).png"))));
		H_sd.add(new JLabel((new ImageIcon("images/main/z_huffepuff(200x250).png"))));
		R_sd.add(new JLabel((new ImageIcon("images/main/z_ravaenclaw(200x250).png"))));
		G_sd.add(new JLabel((new ImageIcon("images/main/z_gryffindor(200x250).png"))));
		
		S_sd.add(S_btn, "South");
		H_sd.add(H_btn, "South");
		R_sd.add(R_btn, "South");
		G_sd.add(G_btn, "South");
		
		// 패널에  추가
		this.add(slytherin_la);
		this.add(ravaenclaw_la);
		this.add(huffepuff_la);
		this.add(gryffindor_la);
		
		this.add(random_btn);
		this.add(background);

		
		// 마우스 효과 - 하영
		setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
				new ImageIcon("images/main/mouse.png").getImage(),
				new Point(0,0),"images/main/mouse.png"));
	}

}
