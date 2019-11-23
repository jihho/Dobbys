package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Comparator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import controller.B_UserManager;
import controller.C_GameStage;
import model.comparator.DescUserTotal;
import model.vo.User;

public class C_RankingPage extends JPanel{
	private ImageIcon icon;
	private JFrame mf;
	private JPanel panel;
	
	
	public C_RankingPage(JFrame mf) {

		this.mf = mf;
		this.setLayout(null);
		panel = this;
		System.out.println("랭킹 페이지 패널 생성");
		
		new A_Music().onepiece();
		
				
		// 라벨 생성 
		JLabel background = new JLabel(new ImageIcon(new ImageIcon("images/main/z_score.png").getImage().getScaledInstance(1300, 770, 0)));
		JLabel score_title = new JLabel("SCORE");

		JLabel stage1_la = new JLabel(new ImageIcon("images/main/stage1_icon.png"));
		JLabel stage2_la = new JLabel(new ImageIcon("images/main/stage2_icon.png"));
		JLabel stage3_la = new JLabel(new ImageIcon("images/main/stage3_icon.png"));
		JLabel ranking_la = new JLabel(new ImageIcon("images/main/ranking_icon.png"));
		
		JLabel stage1_name = new JLabel("Stage1");
		JLabel stage2_name = new JLabel("Stage2");
		JLabel stage3_name = new JLabel("Stage3");
		JLabel total_name = new JLabel("Total");
		
		JLabel gryffindor = new JLabel(new ImageIcon("images/main/zm_gryffindor.png"));
		JLabel huffepuff = new JLabel(new ImageIcon("images/main/zm_huffepuff.png"));
		JLabel ravaenclaw = new JLabel(new ImageIcon("images/main/zm_ravaenclaw.png"));
		JLabel slytherin = new JLabel(new ImageIcon("images/main/zm_slytherin.png"));
		
		// 버튼 생성 
		JButton return_btn = new JButton("RETURN");

		
		// 현재 유저의 정보값 불러오기
		B_UserManager um = new B_UserManager();
		String[] test = um.selectUserScore(User.playerId);
		//test[0] score1 값
		//test[1] score2 값
		//test[2] score3 값
		//test[3] Total 값
		//test[4] 닉네임
		//test[5] 배정된 기숙사
		
		// 현재 유저의 랭킹점수 출력하는 JTextArea 생성
 		JTextArea score1 = new JTextArea(test[0]);
		JTextArea score2 = new JTextArea(test[1]);
		JTextArea score3 = new JTextArea(test[2]);
		JTextArea total = new JTextArea(test[3]);
		JTextArea name = new JTextArea(test[4]);
		JTextArea dormitory = new JTextArea(test[5]);
		
		switch(test[5]) {
		case "gryffindor" : 
			System.out.println("그리핀도르"); 
			this.add(gryffindor);
			gryffindor.setBounds(670, 82, 1000, 500);
			break; 
		case "ravaenclaw" : 
			System.out.println("래번클로");
			this.add(ravaenclaw);
			ravaenclaw.setBounds(670, 82, 1000, 500);
			break;
		case "huffepuff" : 
			System.out.println("후플푸프"); 
			this.add(huffepuff);
			huffepuff.setBounds(670, 82, 1000, 500);
			break;
		case "slytherin" : 
			System.out.println("슬리데린"); 
			this.add(slytherin);
			slytherin.setBounds(670, 82, 1000, 500);
			break;
		default : System.out.println("왜 안나와");
		}
		
		
		score1.setBounds(240, 310, 500, 300);
		score2.setBounds(420, 310, 500, 300);
		score3.setBounds(610, 310, 500, 300);
		total.setBounds(770, 310, 500, 300);
		name.setBounds(920, 310, 500, 300);
		
		score1.setForeground(Color.YELLOW);	
		score1.setFont(new Font("DungGeunMo", Font.PLAIN, 40)); 
		score1.setEditable(false); 	
		score2.setForeground(Color.YELLOW);	
		score2.setFont(new Font("DungGeunMo", Font.PLAIN, 40)); 
		score2.setEditable(false);
		score3.setForeground(Color.YELLOW);	
		score3.setFont(new Font("DungGeunMo", Font.PLAIN, 40)); 
		score3.setEditable(false);
		total.setForeground(Color.YELLOW);	
		total.setFont(new Font("DungGeunMo", Font.PLAIN, 40)); 
		total.setEditable(false);
		name.setForeground(Color.YELLOW);	
		name.setFont(new Font("DungGeunMo", Font.PLAIN, 40)); 
		name.setEditable(false);
		dormitory.setForeground(Color.YELLOW);	
		dormitory.setFont(new Font("DungGeunMo", Font.PLAIN, 40)); 
		dormitory.setEditable(false);

		
		// 누적 랭킹점수 출력하는 JTextArea 생성
		String[][] test2 = um.sortList(new DescUserTotal());

		// 지호씨 케리
		for(int i = 0; i < test2.length; i++) {
			for(int j = 0; j < test2[i].length; j++) {
				System.out.print(test2[i][j] + "\t");
			}
			System.out.println();
		}
		um.printAll();
		
		
		JTextArea b1_rank = new JTextArea("1위");
		JTextArea b1_score1 = new JTextArea(test2[0][0]);
		JTextArea b1_score2 = new JTextArea(test2[0][1]);
		JTextArea b1_score3 = new JTextArea(test2[0][2]);
		JTextArea b1_total = new JTextArea(test2[0][3]);
		JTextArea b1_name = new JTextArea(test2[0][4]);
		
		JTextArea b2_rank = new JTextArea("2위");
		JTextArea b2_score1 = new JTextArea(test2[1][0]);
		JTextArea b2_score2 = new JTextArea(test2[1][1]);
		JTextArea b2_score3 = new JTextArea(test2[1][2]);
		JTextArea b2_total = new JTextArea(test2[1][3]);
		JTextArea b2_name = new JTextArea(test2[1][4]);
		//JTextArea b2_dormitory = new JTextArea(test2[0][5]);
		JTextArea b3_rank = new JTextArea("3위");
		JTextArea b3_score1 = new JTextArea(test2[2][0]);
		JTextArea b3_score2 = new JTextArea(test2[2][1]);
		JTextArea b3_score3 = new JTextArea(test2[2][2]);
		JTextArea b3_total = new JTextArea(test2[2][3]);
		JTextArea b3_name = new JTextArea(test2[2][4]);
		//JTextArea b3_dormitory = new JTextArea(test2[0][5]);
		JTextArea b4_rank = new JTextArea("4위");
		JTextArea b4_score1 = new JTextArea(test2[3][0]);
		JTextArea b4_score2 = new JTextArea(test2[3][1]);
		JTextArea b4_score3 = new JTextArea(test2[3][2]);
		JTextArea b4_total = new JTextArea(test2[3][3]);
		JTextArea b4_name = new JTextArea(test2[3][4]);
		//JTextArea b4_dormitory = new JTextArea(test2[0][5]);
		JTextArea b5_rank = new JTextArea("5위");
		JTextArea b5_score1 = new JTextArea(test2[4][0]);
		JTextArea b5_score2 = new JTextArea(test2[4][1]);
		JTextArea b5_score3 = new JTextArea(test2[4][2]);
		JTextArea b5_total = new JTextArea(test2[4][3]);
		JTextArea b5_name = new JTextArea(test2[4][4]);
		//JTextArea b5_dormitory = new JTextArea(test2[0][5]);
		JTextArea b6_rank = new JTextArea("6위");
		JTextArea b6_score1 = new JTextArea(test2[5][0]);
		JTextArea b6_score2 = new JTextArea(test2[5][1]);
		JTextArea b6_score3 = new JTextArea(test2[5][2]);
		JTextArea b6_total = new JTextArea(test2[5][3]);
		JTextArea b6_name = new JTextArea(test2[5][4]);
		//JTextArea b6_dormitory = new JTextArea(test2[0][5]);
		JTextArea b7_rank = new JTextArea("7위");
		JTextArea b7_score1 = new JTextArea(test2[6][0]);
		JTextArea b7_score2 = new JTextArea(test2[6][1]);
		JTextArea b7_score3 = new JTextArea(test2[6][2]);
		JTextArea b7_total = new JTextArea(test2[6][3]);
		JTextArea b7_name = new JTextArea(test2[6][4]);
		//JTextArea b6_dormitory = new JTextArea(test2[0][5]);
	
		b1_rank.setBounds(135, 360, 500, 300);
		b1_score1.setBounds(240, 360, 500, 300);
		b1_score2.setBounds(420, 360, 500, 300);
		b1_score3.setBounds(610, 360, 500, 300);
		b1_total.setBounds(770, 360, 500, 300);
		b1_name.setBounds(920, 360, 500, 300);
		//b1_dormitory.setBounds(145, 360, 500, 300);
		b2_rank.setBounds(135, 400, 500, 300);
		b2_score1.setBounds(240, 400, 500, 300);
		b2_score2.setBounds(420, 400, 500, 300);
		b2_score3.setBounds(610, 400, 500, 300);
		b2_total.setBounds(770, 400, 500, 300);
		b2_name.setBounds(920, 400, 500, 300);
		//b2_dormitory.setBounds(145, 360, 500, 300);
		b3_rank.setBounds(135, 440, 500, 300);
		b3_score1.setBounds(240, 440, 500, 300);
		b3_score2.setBounds(420, 440, 500, 300);
		b3_score3.setBounds(610, 440, 500, 300);
		b3_total.setBounds(770, 440, 500, 300);
		b3_name.setBounds(920, 440, 500, 300);
		//b3_dormitory.setBounds(145, 360, 500, 300);
		b4_rank.setBounds(135, 480, 500, 300);
		b4_score1.setBounds(240, 480, 500, 300);
		b4_score2.setBounds(420, 480, 500, 300);
		b4_score3.setBounds(610, 480, 500, 300);
		b4_total.setBounds(770, 480, 500, 300);
		b4_name.setBounds(920, 480, 500, 300);
		//b4_dormitory.setBounds(145, 360, 500, 300);
		b5_rank.setBounds(135, 520, 500, 300);
		b5_score1.setBounds(240, 520, 500, 300);
		b5_score2.setBounds(420, 520, 500, 300);
		b5_score3.setBounds(610, 520, 500, 300);
		b5_total.setBounds(770, 520, 500, 300);
		b5_name.setBounds(920, 520, 500, 300);
		//b5_dormitory.setBounds(145, 360, 500, 300);
		b6_rank.setBounds(135, 560, 500, 300);
		b6_score1.setBounds(240, 560, 500, 300);
		b6_score2.setBounds(420, 560, 500, 300);
		b6_score3.setBounds(610, 560, 500, 300);
		b6_total.setBounds(770, 560, 500, 300);
		b6_name.setBounds(920, 560, 500, 300);
		//b6_dormitory.setBounds(145, 360, 500, 300);
		b7_rank.setBounds(135, 600, 500, 300);
		b7_score1.setBounds(240, 600, 500, 300);
		b7_score2.setBounds(420, 600, 500, 300);
		b7_score3.setBounds(610, 600, 500, 300);
		b7_total.setBounds(770, 600, 500, 300);
		b7_name.setBounds(920, 600, 500, 300);
		//b7_dormitory.setBounds(145, 360, 500, 300);
		
		
		b1_rank.setForeground(Color.WHITE);	
		b1_rank.setFont(new Font("DungGeunMo", Font.PLAIN, 40)); 
		b1_rank.setEditable(false); 	
		b1_score1.setForeground(Color.WHITE);	
		b1_score1.setFont(new Font("DungGeunMo", Font.PLAIN, 40)); 
		b1_score1.setEditable(false); 	
		b1_score2.setForeground(Color.WHITE);	
		b1_score2.setFont(new Font("DungGeunMo", Font.PLAIN, 40)); 
		b1_score2.setEditable(false); 
		b1_score3.setForeground(Color.WHITE);	
		b1_score3.setFont(new Font("DungGeunMo", Font.PLAIN, 40)); 
		b1_score3.setEditable(false); 
		b1_total.setForeground(Color.WHITE);	
		b1_total.setFont(new Font("DungGeunMo", Font.PLAIN, 40)); 
		b1_total.setEditable(false); 
		b1_name.setForeground(Color.WHITE);	
		b1_name.setFont(new Font("DungGeunMo", Font.PLAIN, 40)); 
		b1_name.setEditable(false); 
		//b1_dormitory.setForeground(Color.WHITE);	
		//b1_dormitory.setFont(new Font("DungGeunMo", Font.PLAIN, 40)); 
		//b1_dormitory.setEditable(false); 
		b2_rank.setForeground(Color.WHITE);	
		b2_rank.setFont(new Font("DungGeunMo", Font.PLAIN, 40)); 
		b2_rank.setEditable(false);
		b2_score1.setForeground(Color.WHITE);	
		b2_score1.setFont(new Font("DungGeunMo", Font.PLAIN, 40)); 
		b2_score1.setEditable(false); 	
		b2_score2.setForeground(Color.WHITE);	
		b2_score2.setFont(new Font("DungGeunMo", Font.PLAIN, 40)); 
		b2_score2.setEditable(false); 
		b2_score3.setForeground(Color.WHITE);	
		b2_score3.setFont(new Font("DungGeunMo", Font.PLAIN, 40)); 
		b2_score3.setEditable(false); 
		b2_total.setForeground(Color.WHITE);	
		b2_total.setFont(new Font("DungGeunMo", Font.PLAIN, 40)); 
		b2_total.setEditable(false); 
		b2_name.setForeground(Color.WHITE);	
		b2_name.setFont(new Font("DungGeunMo", Font.PLAIN, 40)); 
		b2_name.setEditable(false); 
		//b1_dormitory.setForeground(Color.WHITE);	
		//b1_dormitory.setFont(new Font("DungGeunMo", Font.PLAIN, 40)); 
		//b1_dormitory.setEditable(false); 
		b3_rank.setForeground(Color.WHITE);	
		b3_rank.setFont(new Font("DungGeunMo", Font.PLAIN, 40)); 
		b3_rank.setEditable(false);
		b3_score1.setForeground(Color.WHITE);	
		b3_score1.setFont(new Font("DungGeunMo", Font.PLAIN, 40)); 
		b3_score1.setEditable(false); 	
		b3_score2.setForeground(Color.WHITE);	
		b3_score2.setFont(new Font("DungGeunMo", Font.PLAIN, 40)); 
		b3_score2.setEditable(false); 
		b3_score3.setForeground(Color.WHITE);	
		b3_score3.setFont(new Font("DungGeunMo", Font.PLAIN, 40)); 
		b3_score3.setEditable(false); 
		b3_total.setForeground(Color.WHITE);	
		b3_total.setFont(new Font("DungGeunMo", Font.PLAIN, 40)); 
		b3_total.setEditable(false); 
		b3_name.setForeground(Color.WHITE);	
		b3_name.setFont(new Font("DungGeunMo", Font.PLAIN, 40)); 
		b3_name.setEditable(false); 
		//b1_dormitory.setForeground(Color.WHITE);	
		//b1_dormitory.setFont(new Font("DungGeunMo", Font.PLAIN, 40)); 
		//b1_dormitory.setEditable(false); 
		b4_rank.setForeground(Color.WHITE);	
		b4_rank.setFont(new Font("DungGeunMo", Font.PLAIN, 40)); 
		b4_rank.setEditable(false);
		b4_score1.setForeground(Color.WHITE);	
		b4_score1.setFont(new Font("DungGeunMo", Font.PLAIN, 40)); 
		b4_score1.setEditable(false); 	
		b4_score2.setForeground(Color.WHITE);	
		b4_score2.setFont(new Font("DungGeunMo", Font.PLAIN, 40)); 
		b4_score2.setEditable(false); 
		b4_score3.setForeground(Color.WHITE);	
		b4_score3.setFont(new Font("DungGeunMo", Font.PLAIN, 40)); 
		b4_score3.setEditable(false); 
		b4_total.setForeground(Color.WHITE);	
		b4_total.setFont(new Font("DungGeunMo", Font.PLAIN, 40)); 
		b4_total.setEditable(false); 
		b4_name.setForeground(Color.WHITE);	
		b4_name.setFont(new Font("DungGeunMo", Font.PLAIN, 40)); 
		b4_name.setEditable(false); 
		//b1_dormitory.setForeground(Color.WHITE);	
		//b1_dormitory.setFont(new Font("DungGeunMo", Font.PLAIN, 40)); 
		//b1_dormitory.setEditable(false); 
		b5_rank.setForeground(Color.WHITE);	
		b5_rank.setFont(new Font("DungGeunMo", Font.PLAIN, 40)); 
		b5_rank.setEditable(false);
		b5_score1.setForeground(Color.WHITE);	
		b5_score1.setFont(new Font("DungGeunMo", Font.PLAIN, 40)); 
		b5_score1.setEditable(false); 	
		b5_score2.setForeground(Color.WHITE);	
		b5_score2.setFont(new Font("DungGeunMo", Font.PLAIN, 40)); 
		b5_score2.setEditable(false); 
		b5_score3.setForeground(Color.WHITE);	
		b5_score3.setFont(new Font("DungGeunMo", Font.PLAIN, 40)); 
		b5_score3.setEditable(false); 
		b5_total.setForeground(Color.WHITE);	
		b5_total.setFont(new Font("DungGeunMo", Font.PLAIN, 40)); 
		b5_total.setEditable(false); 
		b5_name.setForeground(Color.WHITE);	
		b5_name.setFont(new Font("DungGeunMo", Font.PLAIN, 40)); 
		b5_name.setEditable(false); 
		//b1_dormitory.setForeground(Color.WHITE);	
		//b1_dormitory.setFont(new Font("DungGeunMo", Font.PLAIN, 40)); 
		//b1_dormitory.setEditable(false); 
		b6_rank.setForeground(Color.WHITE);	
		b6_rank.setFont(new Font("DungGeunMo", Font.PLAIN, 40)); 
		b6_rank.setEditable(false);
		b6_score1.setForeground(Color.WHITE);	
		b6_score1.setFont(new Font("DungGeunMo", Font.PLAIN, 40)); 
		b6_score1.setEditable(false); 	
		b6_score2.setForeground(Color.WHITE);	
		b6_score2.setFont(new Font("DungGeunMo", Font.PLAIN, 40)); 
		b6_score2.setEditable(false); 
		b6_score3.setForeground(Color.WHITE);	
		b6_score3.setFont(new Font("DungGeunMo", Font.PLAIN, 40)); 
		b6_score3.setEditable(false); 
		b6_total.setForeground(Color.WHITE);	
		b6_total.setFont(new Font("DungGeunMo", Font.PLAIN, 40)); 
		b6_total.setEditable(false); 
		b6_name.setForeground(Color.WHITE);	
		b6_name.setFont(new Font("DungGeunMo", Font.PLAIN, 40)); 
		b6_name.setEditable(false); 
		//b1_dormitory.setForeground(Color.WHITE);	
		//b1_dormitory.setFont(new Font("DungGeunMo", Font.PLAIN, 40)); 
		//b1_dormitory.setEditable(false); 
		b7_rank.setForeground(Color.WHITE);	
		b7_rank.setFont(new Font("DungGeunMo", Font.PLAIN, 40)); 
		b7_rank.setEditable(false);
		b7_score1.setForeground(Color.WHITE);	
		b7_score1.setFont(new Font("DungGeunMo", Font.PLAIN, 40)); 
		b7_score1.setEditable(false); 	
		b7_score2.setForeground(Color.WHITE);	
		b7_score2.setFont(new Font("DungGeunMo", Font.PLAIN, 40)); 
		b7_score2.setEditable(false); 
		b7_score3.setForeground(Color.WHITE);	
		b7_score3.setFont(new Font("DungGeunMo", Font.PLAIN, 40)); 
		b7_score3.setEditable(false); 
		b7_total.setForeground(Color.WHITE);	
		b7_total.setFont(new Font("DungGeunMo", Font.PLAIN, 40)); 
		b7_total.setEditable(false); 
		b7_name.setForeground(Color.WHITE);	
		b7_name.setFont(new Font("DungGeunMo", Font.PLAIN, 40)); 
		b7_name.setEditable(false); 
		//b1_dormitory.setForeground(Color.WHITE);	
		//b1_dormitory.setFont(new Font("DungGeunMo", Font.PLAIN, 40)); 
		//b1_dormitory.setEditable(false); 
		
		
		
		// 위치와 크기 설정 	
		this.setBounds(0, 0, 1300, 770);
		background.setBounds(0, 0, 1300, 770);
		score_title.setBounds(540, -70, 400, 300);
		
		stage1_la.setBounds(220, 140, 102, 100);
		stage2_la.setBounds(400, 140, 102, 100);
		stage3_la.setBounds(585, 140, 102, 100);
		ranking_la.setBounds(760, 140, 102, 100);
		
		stage1_name.setBounds(215, 245, 170, 50);
		stage2_name.setBounds(395, 245, 170, 50);
		stage3_name.setBounds(580, 245, 170, 50);
		total_name.setBounds(761, 245, 200, 50);
		
		// 폰트 및 글씨 크기
		score_title.setForeground(Color.WHITE);			   			 
		score_title.setFont(new Font("DungGeunMo", Font.PLAIN, 110)); 
		stage1_name.setForeground(Color.WHITE);			   			 
		stage1_name.setFont(new Font("DungGeunMo", Font.PLAIN, 40)); 
		stage2_name.setForeground(Color.WHITE);			   			 
		stage2_name.setFont(new Font("DungGeunMo", Font.PLAIN, 40));
		stage3_name.setForeground(Color.WHITE);			   			 
		stage3_name.setFont(new Font("DungGeunMo", Font.PLAIN, 40));
		total_name.setForeground(Color.WHITE);			   			 
		total_name.setFont(new Font("DungGeunMo", Font.PLAIN, 40));
		
		background.add(score1);
		background.add(score2);
		background.add(score3);
		background.add(total);
		background.add(name);
		//background.add(dormitory);
		
 		background.add(b1_rank);
		background.add(b1_score1);
		background.add(b1_score2);
		background.add(b1_score3);
		background.add(b1_total);
		background.add(b1_name);
		//background.add(b_dormitory);
 		background.add(b2_rank);
		background.add(b2_score1);
		background.add(b2_score2);
		background.add(b2_score3);
		background.add(b2_total);
		background.add(b2_name);
		//background.add(b_dormitory);
 		background.add(b3_rank);
		background.add(b3_score1);
		background.add(b3_score2);
		background.add(b3_score3);
		background.add(b3_total);
		background.add(b3_name);
		//background.add(b_dormitory);
 		background.add(b4_rank);
		background.add(b4_score1);
		background.add(b4_score2);
		background.add(b4_score3);
		background.add(b4_total);
		background.add(b4_name);
		//background.add(b_dormitory);
 		background.add(b5_rank);
		background.add(b5_score1);
		background.add(b5_score2);
		background.add(b5_score3);
		background.add(b5_total);
		background.add(b5_name);
		//background.add(b_dormitory);
 		background.add(b6_rank);
		background.add(b6_score1);
		background.add(b6_score2);
		background.add(b6_score3);
		background.add(b6_total);
		background.add(b6_name);
		//background.add(b_dormitory);
 		background.add(b7_rank);
		background.add(b7_score1);
		background.add(b7_score2);
		background.add(b7_score3);
		background.add(b7_total);
		background.add(b7_name);
		//background.add(b_dormitory);

		// 되돌아가기 버튼 생성
		return_btn.setBounds(1115, 660, 150, 50);
		return_btn.setBackground(Color.GRAY);
		return_btn.setForeground(Color.WHITE);			   			   // 버튼 글자 색깔 변경
		
		return_btn.setFont(new Font("DungGeunMo", Font.PLAIN, 30));      // 버튼 글자 폰트, 효과, 크기 변경
		return_btn.setFocusPainted(false);
		return_btn.setBorderPainted(false);		// JButton의 Border(외곽선)을 없애준다.
		//S_btn.setContentAreaFilled(false);	// JButton 내용영역 채우기 안함
		return_btn.setFocusPainted(false);		// JButton이 선택(focus)되었을 때 생기는 테두리 사용안함
		
		score_title.setOpaque(false);
		stage1_name.setOpaque(false);
		stage2_name.setOpaque(false);
		stage3_name.setOpaque(false);
		total_name.setOpaque(false);

		score1.setOpaque(false);
		score2.setOpaque(false);
		score3.setOpaque(false);
		total.setOpaque(false);
		name.setOpaque(false);
		//dormitory.setOpaque(false);		
		
		b1_rank.setOpaque(false);
		b1_score1.setOpaque(false);
		b1_score2.setOpaque(false);
		b1_score3.setOpaque(false);
		b1_total.setOpaque(false);
		b1_name.setOpaque(false);
		//b_dormitory.setOpaque(false);	
		b2_rank.setOpaque(false);
		b2_score1.setOpaque(false);
		b2_score2.setOpaque(false);
		b2_score3.setOpaque(false);
		b2_total.setOpaque(false);
		b2_name.setOpaque(false);
		//b_dormitory.setOpaque(false);
		b3_rank.setOpaque(false);
		b3_score1.setOpaque(false);
		b3_score2.setOpaque(false);
		b3_score3.setOpaque(false);
		b3_total.setOpaque(false);
		b3_name.setOpaque(false);
		//b_dormitory.setOpaque(false);
		b4_rank.setOpaque(false);
		b4_score1.setOpaque(false);
		b4_score2.setOpaque(false);
		b4_score3.setOpaque(false);
		b4_total.setOpaque(false);
		b4_name.setOpaque(false);
		//b_dormitory.setOpaque(false);
		b5_rank.setOpaque(false);
		b5_score1.setOpaque(false);
		b5_score2.setOpaque(false);
		b5_score3.setOpaque(false);
		b5_total.setOpaque(false);
		b5_name.setOpaque(false);
		//b_dormitory.setOpaque(false);	
		b6_rank.setOpaque(false);
		b6_score1.setOpaque(false);
		b6_score2.setOpaque(false);
		b6_score3.setOpaque(false);
		b6_total.setOpaque(false);
		b6_name.setOpaque(false);
		//b_dormitory.setOpaque(false);	
		b7_rank.setOpaque(false);
		b7_score1.setOpaque(false);
		b7_score2.setOpaque(false);
		b7_score3.setOpaque(false);
		b7_total.setOpaque(false);
		b7_name.setOpaque(false);
		//b_dormitory.setOpaque(false);	
		
		// return_Btn 버튼 이벤트
		return_btn.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
			new A_Music().intoBgmStopJ();
			ChangePanel cp = new ChangePanel(mf, panel);
			C_GameStage gs = new C_GameStage(mf); 
		
			cp.replacePanel(gs);
			
			}
		});
		
		
		// 패널에 추가
		this.add(score_title);

		this.add(stage1_la);
		this.add(stage2_la);
		this.add(stage3_la);
		this.add(ranking_la);
		
		this.add(stage1_name);
		this.add(stage2_name);
		this.add(stage3_name);
		this.add(total_name);

		this.add(slytherin);
		this.add(ravaenclaw);
		this.add(huffepuff);
		this.add(gryffindor);
		
		this.add(return_btn);
		this.add(background);

		
		// 마우스 효과 - 하영
		setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
				new ImageIcon("images/main/mouse" + A_LoginPanel.mouseNum + ".png").getImage(),
				new Point(0,0),"dobby mouse"));
		
	}
	
}
