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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class C_RankingPage extends JPanel{
	private ImageIcon icon;
	private JFrame mf;
	private JPanel panel;
	private JLabel background;
	private JLabel score_title;
	private JLabel stage1_la;
	private JLabel stage2_la;
	private JLabel stage3_la;
	private JLabel ranking_la;
	private JLabel stage1_name;
	private JLabel stage2_name;
	private JLabel stage3_name;
	private JLabel ranking_name;
	private JLabel gryffindor;
	private JLabel huffepuff;
	private JLabel ravaenclaw;
	private JLabel slytherin;
	private JButton return_btn;
	
	
	public C_RankingPage(JFrame mf) {

		this.mf = mf;
		this.setLayout(null);
		
		panel = this;
		this.setBounds(0, 0, 1300, 770);
		System.out.println("랭킹 페이지 패널 생성");
		
		// 배경 라벨 생성
		background = new JLabel(new ImageIcon(new ImageIcon("images/main/z_score.png").getImage().getScaledInstance(1300, 770, 0)));
		background.setBounds(0, 0, 1300, 770);
				
		
		
		
		
		
		// 라벨 생성 
		score_title = new JLabel("SCORE");

		stage1_la = new JLabel(new ImageIcon("images/main/stage1_icon.png"));
		stage2_la = new JLabel(new ImageIcon("images/main/stage2_icon.png"));
		stage3_la = new JLabel(new ImageIcon("images/main/stage3_icon.png"));
		ranking_la = new JLabel(new ImageIcon("images/main/ranking_icon.png"));
		
		stage1_name = new JLabel("Stage1");
		stage2_name = new JLabel("Stage2");
		stage3_name = new JLabel("Stage3");
		ranking_name = new JLabel("Ranking");
		
		gryffindor = new JLabel(new ImageIcon("images/main/zm_gryffindor.png"));
		huffepuff = new JLabel(new ImageIcon("images/main/zm_huffepuff.png"));
		ravaenclaw = new JLabel(new ImageIcon("images/main/zm_ravaenclaw.png"));
		slytherin = new JLabel(new ImageIcon("images/main/zm_slytherin.png"));
		
		
		
		// 라벨 위치와 크기 설정 	
		score_title.setBounds(540, -70, 400, 300);
		
		stage1_la.setBounds(220, 140, 102, 100);
		stage2_la.setBounds(400, 140, 102, 100);
		stage3_la.setBounds(585, 140, 102, 100);
		ranking_la.setBounds(760, 140, 102, 100);
		
		stage1_name.setBounds(215, 245, 170, 50);
		stage2_name.setBounds(395, 245, 170, 50);
		stage3_name.setBounds(580, 245, 170, 50);
		ranking_name.setBounds(750, 245, 200, 50);
		
		
		gryffindor.setBounds(660, 85, 1000, 500);
		huffepuff.setBounds(660, 165, 1000, 500);
		ravaenclaw.setBounds(660, 245, 1000, 500);
		slytherin.setBounds(660, 325, 1000, 500);



		
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
		
		
		// 점수 출력하는 TextArea 생성
		JTextArea ta = new JTextArea("1.  1000     1000     1000     3000    그리핀도르\n\n"
				+ "2.  1000     1000     1000     3000    후플푸프\n\n"
				+ "3.  1000     1000     1000     3000    래번클로\n\n"
				+ "4.  1000     1000     1000     3000    슬리데린");
		ta.setBounds(150, 310, 1100, 300); 	//JTeatArea 크기 및 위치 지정
		ta.setEditable(false); 				//실행시 JtextArea edit 금지 (글을 쓸 수 없음) true면 가능
		ta.setFont(new Font("DungGeunMo", Font.PLAIN, 40)); 
		ta.setForeground(Color.WHITE);	
		
		background.add(ta);
		this.add(background);
		ta.setOpaque(false);
		
		
		// 되돌아가기 버튼 생성
		return_btn = new JButton("RETURN");
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
			public void mouseReleased(MouseEvent e) {
			ChangePanel cp = new ChangePanel(mf, panel);
			
			C_RandomAssign ra = new C_RandomAssign(mf); 
		
			cp.replacePanel(ra);
			}
		});
		
		score_title.setOpaque(false);
		stage1_name.setOpaque(false);
		stage2_name.setOpaque(false);
		stage3_name.setOpaque(false);
		ranking_name.setOpaque(false);
		
		
		// 패널에다 라벨 추가
		this.add(score_title);

		this.add(stage1_la);
		this.add(stage2_la);
		this.add(stage3_la);
		this.add(ranking_la);
		
		this.add(stage1_name);
		this.add(stage2_name);
		this.add(stage3_name);
		this.add(ranking_name);

		// 라벨(background)에 라벨 추가 
		background.add(slytherin);
		background.add(ravaenclaw);
		background.add(huffepuff);
		background.add(gryffindor);
		
		
		this.add(return_btn);
		
		// 마우스 효과 - 하영씨
		setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
				new ImageIcon("images/main/mouse.png").getImage(),
				new Point(0,0),"images/main/mouse.png"));
		
		
		// 패널에다 배경 라벨 추가
		this.add(background);
		
			
		
		
	}
	
}
