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
		JLabel ranking_name = new JLabel("Ranking");
		
		JLabel gryffindor = new JLabel(new ImageIcon("images/main/zm_gryffindor.png"));
		JLabel huffepuff = new JLabel(new ImageIcon("images/main/zm_huffepuff.png"));
		JLabel ravaenclaw = new JLabel(new ImageIcon("images/main/zm_ravaenclaw.png"));
		JLabel slytherin = new JLabel(new ImageIcon("images/main/zm_slytherin.png"));
		
		
		// 버튼 생성 
		JButton return_btn = new JButton("RETURN");

		// 랭킹점수 출력하는 JTextArea 생성
		JTextArea ta1 = new JTextArea("0.  1000     1000     1000     3000    유저 닉네임");
		
		// 랭킹점수 출력하는 JTextArea 생성
		JTextArea ta2 = new JTextArea(
				  "1.  1000     1000     1000     3000    도비1\n"
				+ "2.  1000     1000     1000     3000    도비2\n"
				+ "3.  1000     1000     1000     3000    도비3\n"
				+ "4.  1000     1000     1000     3000    도비4\n"
				+ "5.  1000     1000     1000     3000    도비5\n"
				+ "6.  1000     1000     1000     3000    도비6\n"
				+ "7.  1000     1000     1000     3000    도비7\n"
				);

		
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
		ranking_name.setBounds(750, 245, 200, 50);
		
		gryffindor.setBounds(670, 82, 1000, 500);
		huffepuff.setBounds(670, 132, 1000, 500);
		ravaenclaw.setBounds(670, 167, 1000, 500);
		slytherin.setBounds(670, 212, 1000, 500);


		ta1.setBounds(150, 310, 1100, 300); 
		ta2.setBounds(150, 360, 1100, 300); 	//JTeatArea 크기 및 위치 지정


		// 폰트 및 글씨 크기
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
		
		
		ta1.setForeground(Color.YELLOW);	
		ta1.setFont(new Font("DungGeunMo", Font.PLAIN, 40)); 
		ta1.setEditable(false); 	//실행시 JtextArea edit 금지 (글을 쓸 수 없음) true면 가능
		
		ta2.setForeground(Color.WHITE);	
		ta2.setFont(new Font("DungGeunMo", Font.PLAIN, 40)); 
		ta2.setEditable(false); 	//실행시 JtextArea edit 금지 (글을 쓸 수 없음) true면 가능

		background.add(ta1);
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
		ranking_name.setOpaque(false);

		ta1.setOpaque(false);
		ta2.setOpaque(false);
		
		
		
		
		// return_Btn 버튼 이벤트
		return_btn.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
			ChangePanel cp = new ChangePanel(mf, panel);
			
			C_RandomAssign ra = new C_RandomAssign(mf); 
		
			cp.replacePanel(ra);
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
		this.add(ranking_name);

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
