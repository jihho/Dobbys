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

import controller.B_UserManager;
import model.vo.User;

public class C_AssignDormitory extends JPanel{
	private JFrame mf;
	private JPanel panel;
	
	public C_AssignDormitory(JFrame mf) {
		this.mf = mf;
		this.setLayout(null);
		
		panel = this;
		this.setBounds(0, 0, 1300, 770);
		System.out.println("반 배정 패널 생성");
		
		// 노래 생성
		new A_Music().hat_talk();

		// 라벨 생성
		JLabel background = new JLabel(new ImageIcon(new ImageIcon("images/main/sortpage.png").getImage().getScaledInstance(1300, 770, 0)));
		JLabel hat = new JLabel(new ImageIcon("images/main/hat300.gif"));
		JLabel harry = new JLabel(new ImageIcon("images/main/sortharry.png"));
		JLabel borad = new JLabel(new ImageIcon("images/main/hat.gif"));

		// 버튼 생성
		JButton choice_btn = new JButton("반 배정 받기");
		
		// 라벨 위치와 크기 설정
		background.setBounds(0, 0, 1300, 770);
		hat.setBounds(125, -18, 500, 500);
		harry.setBounds(-120, 222, 1000, 500);
		borad.setBounds(640, 50, 520, 510); 

		// 라벨(background)에 라벨 붙이기
		background.add(hat);
		background.add(harry);
		background.add(borad);
		
	    // 반 배정 받기 버튼 설정
	    choice_btn.setBounds(777, 590, 250, 100);  
	    choice_btn.setBackground(Color.GRAY);        	   		  // 버튼 색깔 변경
	    choice_btn.setForeground(Color.WHITE);			   	      // 버튼 글자 색깔 변경
	    choice_btn.setFont(new Font("DungGeunMo", Font.PLAIN, 35));    // 버튼 글자 폰트, 효과, 크기 변경
	    choice_btn.setFocusPainted(false);				  		  // ?? 뭔가 글자 주변 테두리를 없앴다.

	    // 패널에다 에 버튼 및 라벨(background) 붙이기
	    this.add(choice_btn);
	    this.add(background);
	    
	    
	    // choice_btn 버튼 이벤트
	    choice_btn.addMouseListener(new MouseAdapter() {
	    	
	    	@Override
	    	public void mouseReleased(MouseEvent e) {
	    		ChangePanel cp = new ChangePanel(mf, panel);
	    		C_RandomAssign ra = new C_RandomAssign(mf);
	    		
	    		cp.replacePanel(ra);
	    		new A_Music().intoBgmStop();
	    		
	    	}
	    });
	    
	    
		// 마우스 효과 - 하영
		setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
				new ImageIcon("images/main/mouse.png").getImage(),
				new Point(0,0),"images/main/mouse.png"));
	}

}