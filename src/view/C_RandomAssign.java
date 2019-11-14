package view;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class C_RandomAssign extends JPanel{
	private ImageIcon icon;
	private JFrame mf;
	private JPanel panel;
	
	public C_RandomAssign(JFrame mf) {
		
		this.mf = mf;
		this.setLayout(null);
		
		panel = this;
		this.setBounds(0, 0, 1300, 770);
		System.out.println("패널 생성");
		
		JLabel background = new JLabel(new ImageIcon(new ImageIcon("images/main/sortpage.png").getImage().getScaledInstance(1300, 770, 0)));
		background.setBounds(0, 0, 1300, 770);
		
		// 이미지 라벨 생성
		JLabel slytherin = new JLabel(new ImageIcon("images/main/z_slytherin(200x250).png"));
		JLabel ravaenclaw = new JLabel(new ImageIcon("images/main/z_ravaenclaw(200x250).png"));
		JLabel huffepuff = new JLabel(new ImageIcon("images/main/z_huffepuff(200x250).png"));
		JLabel gryffindor = new JLabel(new ImageIcon("images/main/z_gryffindor(200x250).png"));
		
		// 이미지 라벨 위치 및 크기 지정
		slytherin.setBounds(-350, -50, 1000, 500);
		ravaenclaw.setBounds(-20, -50, 1000, 500);
		huffepuff.setBounds(300, -50, 1000, 500);
		gryffindor.setBounds(600, -50, 1000, 500);


		// 라벨(background)에 라벨 추가 
		background.add(slytherin);
		background.add(ravaenclaw);
		background.add(huffepuff);
		background.add(gryffindor);
		
		
		
		// 랜덤 버튼 생성 
		JButton randomButton = new JButton("배 정");
		randomButton.setBounds(540, 500, 200, 100);
		randomButton.setBackground(Color.GRAY);        	   		// 버튼 색깔 변경
		randomButton.setForeground(Color.WHITE);			    // 버튼 글자 색깔 변경
		randomButton.setFont(new Font("DungGeunMo", Font.BOLD, 40));      // 버튼 글자 폰트, 효과, 크기 변경
		randomButton.setFocusPainted(false);
		
		// Dialog 생성 및 이미지 첨부 및 버튼 생성
		
		// 슬리데린 - 그린
/*		Dialog S_sd = new Dialog(mf, "Slytherin");
		S_sd.setBounds(390, 270, 550, 370);    
		// setLocationRelativeTo
		S_sd.add(new JLabel((new ImageIcon("images/main/z_slytherin(200x250).png"))));
		JButton S_btn = new JButton("슬리데린!");
		S_sd.add(S_btn, "South");
		
		S_btn.setBounds(540, 500, 120, 70);
		S_btn.setBackground(new Color(9, 71, 34));     // 컬러 객체 생성후 RGB값 입력
		S_btn.setForeground(Color.WHITE);			   
		S_btn.setFont(new Font("DungGeunMo", Font.BOLD, 30));    
		S_btn.setFocusPainted(false);
*/
		// 슬리데린 - 그린
		Dialog S_sd = new Dialog(mf, "Slytherin");
		S_sd.setBounds(390, 270, 550, 370);    
		// setLocationRelativeTo
		S_sd.add(new JLabel((new ImageIcon("images/main/z_slytherin(200x250).png"))));
		JButton S_btn = new JButton((new ImageIcon("images/main/z_slytherinBtn.png")));
		S_sd.add(S_btn, "South");
		
		S_btn.setBounds(540, 500, 120, 10);
		S_btn.setBackground(new Color(9, 71, 34));
		S_btn.setBorderPainted(false);		// JButton의 Border(외곽선)을 없애준다.
		//S_btn.setContentAreaFilled(false);	// JButton 내용영역 채우기 안함
		S_btn.setFocusPainted(false);		// JButton이 선택(focus)되었을 때 생기는 테두리 사용안함
		
		
		
		// 후플푸프 - 옐로우
		Dialog H_sd = new Dialog(mf, "Huffepuff");
		H_sd.setBounds(390, 270, 550, 370);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           ;
		H_sd.add(new JLabel((new ImageIcon("images/main/z_huffepuff(200x250).png"))));
		JButton H_btn = new JButton((new ImageIcon("images/main/z_huffepuffBtn.png")));
		H_sd.add(H_btn, "South");
		
		H_btn.setBounds(540, 500, 120, 70);
		H_btn.setBackground(new Color(252, 220, 3));
		H_btn.setBorderPainted(false);		// JButton의 Border(외곽선)을 없애준다.
		//H_btn.setContentAreaFilled(false);	// JButtondml 내용영역 채우기 안함
		H_btn.setFocusPainted(false);		// JButton이 선택(focus)되었을 때 생기는 테두리 사용안함
		
		
		// 래번클로 - 블루
		Dialog R_sd = new Dialog(mf, "Ravaenclaw");
		R_sd.setBounds(390, 270, 550, 370);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           ;
		R_sd.add(new JLabel((new ImageIcon("images/main/z_ravaenclaw(200x250).png"))));
		JButton R_btn = new JButton((new ImageIcon("images/main/z_ravaenclawBtn.png")));
		R_sd.add(R_btn, "South");
		
		R_btn.setBounds(540, 500, 120, 70);
		R_btn.setBackground(new Color(26, 40, 125));
		R_btn.setBorderPainted(false);		// JButton의 Border(외곽선)을 없애준다.
		//R_btn.setContentAreaFilled(false);	// JButtondml 내용영역 채우기 안함
		R_btn.setFocusPainted(false);		// JButton이 선택(focus)되었을 때 생기는 테두리 사용안함
		
		// 그리핀도르 - 레드
		Dialog G_sd = new Dialog(mf, "Gryffindor");
		G_sd.setBounds(390, 270, 550, 370);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           ;
		G_sd.add(new JLabel((new ImageIcon("images/main/z_gryffindor(200x250).png"))));
		JButton G_btn = new JButton((new ImageIcon("images/main/z_gryffindorBtn.png")));
		G_sd.add(G_btn, "South");
	
		G_btn.setBounds(540, 500, 120, 70);
		G_btn.setBackground(new Color(167, 15, 14));
		G_btn.setBorderPainted(false);		// JButton의 Border(외곽선)을 없애준다.
		//G_btn.setContentAreaFilled(false);	// JButtondml 내용영역 채우기 안함
		G_btn.setFocusPainted(false);		// JButton이 선택(focus)되었을 때 생기는 테두리 사용안함
		
		// 랜덤 버튼 이벤트
		randomButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				int ra_random = new Random().nextInt(4) + 1;
				
				switch(ra_random) {
				case 1 : S_sd.setVisible(true); break;
				case 2 : H_sd.setVisible(true); break;
				case 3 : R_sd.setVisible(true); break;
				case 4 : G_sd.setVisible(true); break;	
				}
				

			}
		});


		// Dialog 닫기
		S_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ChangePanel cp = new ChangePanel(mf, panel);
				C_GameStage gs = new C_GameStage(mf);
				cp.replacePanel(gs);
				
				// 닫기
				S_sd.dispose();
			}
		});
		H_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				H_sd.dispose();
				
			}
		});
		R_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				R_sd.dispose();
			}
		});
		G_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				G_sd.dispose();
			}
		});
		
		
		// 패널에 버튼 추가
		this.add(randomButton);
		
		// 패널에 라벨(background) 추가
		this.add(background);
	}

}