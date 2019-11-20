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
		JTextArea score1 = new JTextArea(test[0]);
		JTextArea score2 = new JTextArea(test[1]);
		JTextArea score3 = new JTextArea(test[2]);
		JTextArea total = new JTextArea(test[3]);
		JTextArea name = new JTextArea(test[4]);
		JTextArea dormitory = new JTextArea(test[5]);
		
		switch(test[5]) {
		case "griyffindor" : System.out.println("그리핀도르"); break; 
		case "ravaenclaw" : System.out.println("래번클로"); break;
		case "huffepuff" : System.out.println("후플푸프"); break;
		case "slytherin" : System.out.println("슬리데린"); break;
		default : System.out.println("왜 안나와");
		}
		
		
		score1.setBounds(260, 310, 500, 300);
		score2.setBounds(440, 310, 500, 300);
		score3.setBounds(610, 310, 500, 300);
		total.setBounds(780, 310, 500, 300);
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
		
		
		// 랭킹점수 출력하는 JTextArea 생성
		JTextArea ta2 = new JTextArea();

		String[][] test2 = um.sortList(new DescUserTotal());
		
		for(int i = 0; i < 7; i++) {
			ta2 = new JTextArea((i + 1) + "위   " + test2[i][0] + "        " + test2[i][1] 
					+ "        " + test2[i][2] + "        " + test2[i][3]
					+ "    " + test2[i][4]/* + "     " + test2[i][5]*/);
		}
		
		ta2.setBounds(145, 360, 1100, 300); 	//JTeatArea 크기 및 위치 지정
		ta2.setForeground(Color.WHITE);	
		ta2.setFont(new Font("DungGeunMo", Font.PLAIN, 40)); 
		ta2.setEditable(false); 	//실행시 JtextArea edit 금지 (글을 쓸 수 없음) true면 가능
		
		
		
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
		
		

		


		background.add(score1);
		background.add(score2);
		background.add(score3);
		background.add(total);
		background.add(name);
		background.add(dormitory);
		
		background.add(ta2);
		this.add(background);
		
		
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
		dormitory.setOpaque(false);		
		
		ta2.setOpaque(false);	
		
		// return_Btn 버튼 이벤트
		return_btn.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
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
				new ImageIcon("images/main/mouse.png").getImage(),
				new Point(0,0),"images/main/mouse.png"));
		
	}
	
}
