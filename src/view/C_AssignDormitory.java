package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
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
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

public class C_AssignDormitory extends JPanel{
	private JFrame mf;
	private JPanel panel;
	private JLabel background;
	private JLabel hat;
	private JLabel harry; 
	private JButton choice_btn;
	private JTextArea ta;
	private boolean sw = true;
	
	public C_AssignDormitory(JFrame mf) {
		this.mf = mf;
		this.setLayout(null);
		
		panel = this;
		this.setBounds(0, 0, 1300, 770);
		System.out.println("반 배정 패널 생성");
		
		background = new JLabel(new ImageIcon(new ImageIcon("images/main/sortpage.png").getImage().getScaledInstance(1300, 770, 0)));
		background.setBounds(0, 0, 1300, 770);
		
		
		// 라벨 생성
		hat = new JLabel(new ImageIcon("images/main/hat300.gif"));
		harry = new JLabel(new ImageIcon("images/main/sortharry.png"));
		
		// 라벨 위치와 크기 설정
		hat.setBounds(125, -18, 500, 500);
		harry.setBounds(-120, 222, 1000, 500);
		
		// 패널에다 라벨 추가
		background.add(hat);
		background.add(harry);
		
		
		String str = "어렵군, 아주 어려워...\n용기가 충만하고, 총명하며,\n재능을 타고 났어!\n의욕이 하늘을 찌르는 군!\n근데 어디가 좋을까...\n그리핀도르? 래번클로? \n슬리데린? 후플푸프?\n흐음...어디보자...\n";
		
		// JTextArea(대화 상자) 생성  
		ta = new JTextArea("");   	//JTextArea 생성
		ta.setBounds(635, 50, 510, 500); 	    //JTeatArea 크기 및 위치 지정
	    ta.setEditable(false); 				    //실행시 JtextArea edit 금지 (글을 쓸 수 없음) true면 가능
		ta.setFont(new Font("DungGeunMo", Font.PLAIN, 37)); 
		ta.setBackground(new Color(0, 60, 30));
		ta.setForeground(Color.WHITE);			
		ta.setMargin(new Insets(20, 20, 5, 10));
		ta.setOpaque(false);
 	

	    // 패널에 JTextArea 추가
		background.add(ta);

		
		// 칠판 추가
		JLabel borad = new JLabel(new ImageIcon("images/main/chalkboard2.png"));
		borad.setBounds(640, 50, 520, 510); 
		background.add(borad);
	    
		
	    // 반 배정 받기 버튼 추가 
	    choice_btn = new JButton("반 배정 받기");
	    choice_btn.setBounds(777, 590, 250, 100);  
	    choice_btn.setBackground(Color.GRAY);        	   		  // 버튼 색깔 변경
	    choice_btn.setForeground(Color.WHITE);			   	      // 버튼 글자 색깔 변경
	    choice_btn.setFont(new Font("DungGeunMo", Font.PLAIN, 35));    // 버튼 글자 폰트, 효과, 크기 변경
	    choice_btn.setFocusPainted(false);				  		  // ?? 뭔가 글자 주변 테두리를 없앴다.


	    
	    // choice_btn 버튼 이벤트
	    choice_btn.addMouseListener(new MouseAdapter() {
	    	
	    	@Override
	    	public void mouseReleased(MouseEvent e) {
	    		ChangePanel cp = new ChangePanel(mf, panel);
	    		C_RandomAssign ra = new C_RandomAssign(mf);
	    		
	    		cp.replacePanel(ra);
	    		
	    		sw = false;
	    	}
	    });
	    
	    
	    
	    // 패널에다 버튼 추가
	    this.add(choice_btn);
	    
	    // 패널에다 배경 라벨 추가
	    this.add(background);
	    
	    if(sw = true) {
			for(int i = 0; i < str.length(); i++) {
				try {
					char ch = str.charAt(i);
					ta.append(Character.toString(ch));
					
					mf.add(this);
					mf.setVisible(true);
					
					Thread.sleep(100);
				

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			sw = false;
	    } 
	    
		// 마우스 효과 - 하영씨
		setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
				new ImageIcon("images/main/mouse.png").getImage(),
				new Point(0,0),"images/main/mouse.png"));
	}

}