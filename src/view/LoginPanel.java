package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPanel extends JPanel {
	private JFrame mf;
	private JPanel panel;
	private JLabel label;
	private JLabel intro;
	private JTextField text;
	private JPasswordField passwordText;
	
	public LoginPanel(JFrame mf) {
		
		JLabel loginBackground = new JLabel(new ImageIcon(new ImageIcon("images/main/loginpage2.gif")
				.getImage().getScaledInstance(1300, 770, 0)));
		loginBackground.setBounds(0, 0, 1300, 770);
		
		JLabel loginLogo = new JLabel(new ImageIcon(new ImageIcon("images/main/loginLogo.gif")
				.getImage().getScaledInstance(730, 300, 0)));
		loginLogo.setBounds(290, 100, 730, 300);
		
		
		this.mf = mf;
		
		this.setLayout(null);
		panel = this;
		
		this.setBounds(0, 0, 1300, 770);
		System.out.println("패널생성");
		
//		IntroImage();
		
		label = new JLabel("User ID");
		label.setBounds(350, 455, 150, 50);
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("DungGeunMo", Font.BOLD, 30));
		panel.add(label);
		
		text = new JTextField();
		text.setBounds(460,450,380,60);
		text.setFont(new Font("DungGeunMo", Font.PLAIN, 30));
		panel.add(text);
		text.setColumns(15);
		
		label = new JLabel("Password");
		label.setBounds(330, 515, 150, 50);
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("DungGeunMo", Font.BOLD, 30));
		panel.add(label);
		
		passwordText = new JPasswordField();
		passwordText.setBounds(460,510,380,60);
		passwordText.setFont(new Font("DungGeunMo", Font.BOLD, 25));
		panel.add(passwordText);
		passwordText.setColumns(15);
		
		
		
		
		
//		JButton loginBtn = new JButton("LOGIN");
//		loginBtn.setBounds(763, 450 , 300, 120);
//		loginBtn.setFont(new Font("DungGeunMo", Font.BOLD, 40));
//		loginBtn.setBorderPainted(false);
		
//		JLabel loginBtnImg = new JLabel(new ImageIcon(new ImageIcon("images/main/loginBtn.png")
//				.getImage().getScaledInstance(130, 118, 0)));
//		loginBtnImg.setBounds(850, 450, 130, 120);
		
		JButton loginBtn = new JButton(new ImageIcon("images/main/loginBtn.png"));
		loginBtn.setBounds(850, 450 , 130, 120);
		loginBtn.setFont(new Font("DungGeunMo", Font.BOLD, 40));
		loginBtn.setBorderPainted(false);
		
		ImageIcon loginBtnImg2 = new ImageIcon("images/main/loginBtn2.png");
		loginBtn.setRolloverIcon(loginBtnImg2);
		loginBtn.setBorderPainted(false);
		loginBtn.setPreferredSize(new Dimension(130,120));
		
		JLabel loginLabel = new JLabel("LOGIN");
		loginLabel.setBounds(862, 450 , 300, 120);
		loginLabel.setFont(new Font("DungGeunMo", Font.BOLD, 40));
		
		panel.add(loginLabel);
		panel.add(loginBtn);
//		this.add(loginBtnImg);
		
		
		
		JButton findId = new JButton("아이디 / 비밀번호 찾기");
		findId.setBounds(460,620, 220, 35);
		findId.setFont(new Font("DungGeunMo", Font.BOLD, 18));
//		findId.setForeground(new Color(255, 255, 255));
//		findId.setContentAreaFilled(false);		//내용영역 채우기 없음
//		findId.setBorderPainted(false);		//외곽선 제거
//		findId.setOpaque(false);	//투명하게
		panel.add(findId);
		
		JButton changeInfo = new JButton("회원정보 수정");
		changeInfo.setBounds(690,620, 150, 35);
		changeInfo.setFont(new Font("DungGeunMo", Font.BOLD, 18));
		panel.add(changeInfo);
		
		JButton joinUser = new JButton("회    원    가    입");
		joinUser.setBounds(460,575, 380, 40);
		joinUser.setFont(new Font("DungGeunMo", Font.BOLD, 22));
		panel.add(joinUser);
		
//		JLabel under = new JLabel(Copyright 2019 by KH Academy Ltd. ");
//		under.setBounds(400, 660, 400, 50);
//		under.setForeground(new Color(255, 255, 255));
//		under.setFont(new Font("DungGeunMo", Font.PLAIN, 20));
//		panel.add(under);
		
		
		findId.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("아이디 / 비밀번호 찾기 패널");
				ChangePanel cp = new ChangePanel(mf, panel);
				//t1.setDaemon(true);
				FindPage fp = new FindPage(mf);
				
				cp.replacePanel(fp);
			}
		});
		
		this.add(loginLogo);
		this.add(loginBackground);
	}
	
//	public void IntroImage(){
//		System.out.println("인트로 이미지");
//		URL url = getClass().getClassLoader().getResource("images/main/loginpage2.gif");
//		System.out.println(url);
//		intro = new JLabel(new ImageIcon(url));
//		
//		intro.setBounds(0, 0, 1300, 770);
//		
//		this.add(intro);
//		
//		repaint();
//	}
}
