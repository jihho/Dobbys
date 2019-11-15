package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;

public class C_AssignDormitory extends JPanel{
	private JFrame mf;
	private JPanel panel;
	
	
	public C_AssignDormitory(JFrame mf) {
		this.mf = mf;
		this.setLayout(null);
		
		panel = this;
		this.setBounds(0, 0, 1300, 770);
		
		JLabel background = new JLabel(new ImageIcon(new ImageIcon("images/main/sortpage.png").getImage().getScaledInstance(1300, 770, 0)));
		background.setBounds(0, 0, 1300, 770);
		
		
		// 라벨 생성
		JLabel hat = new JLabel(new ImageIcon("images/main/hat300.gif"));
		JLabel harry = new JLabel(new ImageIcon("images/main/sortharry.png"));
		
		// 라벨 위치와 크기 설정
		hat.setBounds(125, -20, 500, 500);
		harry.setBounds(-120, 220, 1000, 500);
		
		// 패널에다 라벨 추가
		background.add(hat);
		background.add(harry);
		
		
		String str = "어렵군, 아주 어려워...\n\n용기가 충만하고, 총명하며,\n\n재능을 타고 났어!\n\n의욕이 하늘을 찌르는 군!\n\n근데 어디가 좋을까...\n\n그리핀도르? 래번클로? \n\n슬리데린? 후플푸프?\n\n흐음...어디보자...\n";
		
//		for(int i = 0; i < str.length(); i++) {
//			try {
//				char ch = str.charAt(i);
//				Thread.sleep(150);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//			
//		}
		
		// JTextArea(대화 상자) 생성  
		JTextArea ta = new JTextArea(str);  	//JTextArea 생성
     	ta.setBounds(640, 50, 510, 500); 	//JTeatArea 크기 및 위치 지정
	    ta.setEditable(false); 				//실행시 JtextArea edit 금지 (글을 쓸 수 없음) true면 가능
		ta.setFont(new Font("DungGeunMo", Font.PLAIN, 38)); 
		ta.setBackground(new Color(9, 71, 34));
		ta.setForeground(Color.WHITE);			
		ta.setMargin(new Insets(5, 10, 5, 10));
	    
		
	    // 패널에에 JTextArea 추가
		background.add(ta);
				
	    
	    // 반 배정 받기 버튼 추가 
	    JButton choice_btn = new JButton("반 배정 받기");
	    choice_btn.setBounds(777, 590, 250, 100);  
	    choice_btn.setBackground(Color.GRAY);        	   		  // 버튼 색깔 변경
	    choice_btn.setForeground(Color.WHITE);			   	      // 버튼 글자 색깔 변경
	    choice_btn.setFont(new Font("DungGeunMo", Font.PLAIN, 35));    // 버튼 글자 폰트, 효과, 크기 변경
	    choice_btn.setFocusPainted(false);				  		  // ?? 뭔가 글자 주변 테두리를 없앴다.


	    // choice_btn 버튼 이벤트
	    choice_btn.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
			ChangePanel cp = new ChangePanel(mf, panel);
			
			C_RandomAssign ra = new C_RandomAssign(mf);
		
						
			cp.replacePanel(ra);
			}
		});
	    
	    // 패널에다 버튼 추가
	    this.add(choice_btn);
	    
	    // 패널에다 배경 라벨 추가
	    this.add(background);
	    //this.setComponentZOrder(background, 1);
	}

}