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
	private JTextArea rt;
	private JTextArea b_rank;
	private JTextArea b_score1;
	private JTextArea b_score2;
	private JTextArea b_score3;
	private JTextArea b_total;
	private JTextArea b_name;
	private JTextArea b_dormitory;
	
	
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
		
		// 랭킹점수 출력하는 JTextArea 생성
		JTextArea rr = new JTextArea(
				test[0] + "\t"+ test[1] + "\t"+ test[2] + "\t"+ 
				test[3] + "\t"+ test[4] + "\n");
		
		rr.setBounds(240, 310, 1300, 300);
		rr.setForeground(Color.YELLOW);	
		rr.setFont(new Font("DungGeunMo", Font.PLAIN, 40)); 
		rr.setEditable(false);	
		
		
		switch(test[5]) {
		case "griyffindor" : System.out.println("그리핀도르"); break; 
		case "ravaenclaw" : System.out.println("래번클로"); break;
		case "huffepuff" : System.out.println("후플푸프"); break;
		case "slytherin" : System.out.println("슬리데린"); break;
		default : System.out.println("왜 안나와");
		}
		

/*
 		JTextArea score1 = new JTextArea(test[0]);
		JTextArea score2 = new JTextArea(test[1]);
		JTextArea score3 = new JTextArea(test[2]);
		JTextArea total = new JTextArea(test[3]);
		JTextArea name = new JTextArea(test[4]);
		JTextArea dormitory = new JTextArea(test[5]);
		
		score1.setBounds(240, 310, 500, 300);
		score2.setBounds(420, 310, 500, 300);
		score3.setBounds(610, 310, 500, 300);
		total.setBounds(770, 310, 500, 300);
		name.setBounds(920, 310, 500, 300);
		//dormitory.setBounds(980, 310, 500, 300);
		
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
*/
		
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
		

/*		
		for(int i = 0; i < test2.length; i++) {
			for(int j = 0; j < test2[i].length; j++) {
				rt = new JTextArea(test2[i][j]);
			}
		}
		rt.repaint();
*/
		
		
		rt = new JTextArea( 
				"1위  " + test2[0][0] + "\t" + test2[0][1] 
				+ "\t" + test2[0][2] + "\t" + test2[0][3]
				+ "\t" + test2[0][4] + "\n" +
				
				"2위  " + test2[1][0] + "\t" + test2[1][1] 
				+ "\t" + test2[1][2] + "\t" + test2[1][3]
				+ "\t" + test2[1][4] + "\n" +
				
				"3위  " + test2[2][0] + "\t" + test2[2][1] 
				+ "\t" + test2[2][2] + "\t" + test2[2][3]
				+ "\t" + test2[2][4] + "\n" +
				
				"4위  " + test2[3][0] + "\t" + test2[3][1] 
				+ "\t" + test2[3][2] + "\t" + test2[3][3]
				+ "\t" + test2[3][4] + "\n" +
				
				"5위  " + test2[4][0] + "\t" + test2[4][1] 
				+ "\t" + test2[4][2] + "\t" + test2[4][3]
				+ "\t" + test2[4][4] + "\n" +
				
				"6위  " + test2[5][0] + "\t" + test2[5][1] 
				+ "\t" + test2[5][2] + "\t" + test2[5][3]
				+ "\t" + test2[5][4] + "\n" +
				
				"7위  " + test2[6][0] + "\t" + test2[6][1] 
				+ "\t" + test2[6][2] + "\t" + test2[6][3]
				+ "\t" + test2[6][4] + "\n"
				);
		
			
		rt.setBounds(135, 360, 1300, 500);
		rt.setForeground(Color.WHITE);	
		rt.setFont(new Font("DungGeunMo", Font.PLAIN, 40)); 
		rt.setEditable(false); 	
		
		
		
/*		
		b_rank = new JTextArea((i + 1) + "위");
		b_score1 = new JTextArea(test2[i][j]);
		b_score2 = new JTextArea(test2[i][j]);
		b_score3 = new JTextArea(test2[i][j]);
		b_total = new JTextArea(test2[i][j]);
		b_name = new JTextArea(test2[i][j]);
		b_dormitory = new JTextArea(test2[i][j]);
		
		b_rank.setBounds(135, 360, 500, 300);
		b_score1.setBounds(240, 360, 500, 300);
		b_score2.setBounds(420, 360, 500, 300);
		b_score3.setBounds(610, 360, 500, 300);
		b_total.setBounds(770, 360, 500, 300);
		b_name.setBounds(920, 360, 500, 300);
		b_dormitory.setBounds(145, 360, 500, 300);
		
		b_rank.setForeground(Color.WHITE);	
		b_rank.setFont(new Font("DungGeunMo", Font.PLAIN, 40)); 
		b_rank.setEditable(false); 	
		b_score1.setForeground(Color.WHITE);	
		b_score1.setFont(new Font("DungGeunMo", Font.PLAIN, 40)); 
		b_score1.setEditable(false); 	
		b_score2.setForeground(Color.WHITE);	
		b_score2.setFont(new Font("DungGeunMo", Font.PLAIN, 40)); 
		b_score2.setEditable(false); 
		b_score3.setForeground(Color.WHITE);	
		b_score3.setFont(new Font("DungGeunMo", Font.PLAIN, 40)); 
		b_score3.setEditable(false); 
		b_total.setForeground(Color.WHITE);	
		b_total.setFont(new Font("DungGeunMo", Font.PLAIN, 40)); 
		b_total.setEditable(false); 
		b_name.setForeground(Color.WHITE);	
		b_name.setFont(new Font("DungGeunMo", Font.PLAIN, 40)); 
		b_name.setEditable(false); 
		b_dormitory.setForeground(Color.WHITE);	
		b_dormitory.setFont(new Font("DungGeunMo", Font.PLAIN, 40)); 
		b_dormitory.setEditable(false); 
*/
		
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
		
		gryffindor.setBounds(670, 82, 1000, 500);
		huffepuff.setBounds(670, 132, 1000, 500);
		ravaenclaw.setBounds(670, 167, 1000, 500);
		slytherin.setBounds(670, 212, 1000, 500);

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
		
		background.add(rr);
		background.add(rt);
		
/*
		background.add(score1);
		background.add(score2);
		background.add(score3);
		background.add(total);
		background.add(name);
		background.add(dormitory);
		
 		background.add(b_rank);
		background.add(b_score1);
		background.add(b_score2);
		background.add(b_score3);
		background.add(b_total);
		background.add(b_name);
		background.add(b_dormitory);
*/

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

		rr.setOpaque(false);
		rt.setOpaque(false);

/*		score1.setOpaque(false);
		score2.setOpaque(false);
		score3.setOpaque(false);
		total.setOpaque(false);
		name.setOpaque(false);
		dormitory.setOpaque(false);		
		
		b_rank.setOpaque(false);
		b_score1.setOpaque(false);
		b_score2.setOpaque(false);
		b_score3.setOpaque(false);
		b_total.setOpaque(false);
		b_name.setOpaque(false);
		b_dormitory.setOpaque(false);	
*/	
		
		// return_Btn 버튼 이벤트
		return_btn.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
			ChangePanel cp = new ChangePanel(mf, panel);
			C_GameStage gs = new C_GameStage(mf); 
		
			cp.replacePanel(gs);
			
    		new A_Music().intoBgmStop();
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
				new ImageIcon("images/main/mouse.png").getImage(),
				new Point(0,0),"images/main/mouse.png"));
		
	}
	
}
