package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class A_LoginPanel extends JPanel {
	private JFrame mf;
	private JPanel panel;
	private JLabel label;
	private JLabel intro;
	private JTextField text;
	private JPasswordField passwordText;
	
	public A_LoginPanel(JFrame mf) {
		
		
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
		label.setBounds(350, 450, 150, 50);
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("DungGeunMo", Font.BOLD, 30));
		panel.add(label);
		
		text = new JTextField();
		text.setBounds(460,445,380,60);
		text.setFont(new Font("DungGeunMo", Font.PLAIN, 30));
		panel.add(text);
		text.setColumns(15);
//		text.setOpaque(false);
		
		
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
		
		JButton loginBtn = new JButton(new ImageIcon("images/main/loginBtn1.png"));
		loginBtn.setBounds(850, 447 , 130, 120);
		loginBtn.setFont(new Font("DungGeunMo", Font.BOLD, 40));
		loginBtn.setBorderPainted(false);
		
		ImageIcon loginBtnImg2 = new ImageIcon("images/main/loginBtn2.png");
		loginBtn.setRolloverIcon(loginBtnImg2);
		loginBtn.setBorderPainted(false);
		loginBtn.setPreferredSize(new Dimension(130,120));
		
		loginBtn.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
				new ImageIcon("images/main/mouse2.png").getImage(),
				new Point(0,0),"images/main/mouse2.png"));
		
		loginBtn.setContentAreaFilled(false);		//내용영역 채우기 없음
		loginBtn.setBorderPainted(false);		//외곽선 제거
		loginBtn.setOpaque(false);	//투명하게
		
//		loginBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		panel.add(loginBtn);
//		JLabel loginLabel = new JLabel("LOGIN");
//		loginLabel.setBounds(862, 450 , 300, 120);
//		loginLabel.setFont(new Font("DungGeunMo", Font.BOLD, 40));
//		
//		panel.add(loginLabel);
//		this.add(loginBtnImg);
		
		
		
//		JButton findId = new JButton("아이디 / 비밀번호 찾기");
//		findId.setBounds(460,620, 220, 35);
//		findId.setFont(new Font("DungGeunMo", Font.BOLD, 18));
////		findId.setForeground(new Color(255, 255, 255));
////		findId.setContentAreaFilled(false);		//내용영역 채우기 없음
////		findId.setBorderPainted(false);		//외곽선 제거
////		findId.setOpaque(false);	//투명하게
//		panel.add(findId);
		
		JButton findId1 = new JButton(new ImageIcon("images/main/findId1.png"));
		findId1.setBounds(460,635, 220, 35);
		findId1.setFont(new Font("DungGeunMo", Font.BOLD, 40));
		findId1.setBorderPainted(false);
		
		ImageIcon findId2 = new ImageIcon("images/main/findId2.png");
		findId1.setRolloverIcon(findId2);
		findId1.setBorderPainted(false);
		findId1.setPreferredSize(new Dimension(220, 35));
		
//		findId1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		panel.add(findId1);
		
		
		
		
		JButton changeInfo = new JButton("회원정보 수정");
		changeInfo.setBounds(690,635, 150, 35);
		changeInfo.setFont(new Font("DungGeunMo", Font.BOLD, 18));
		panel.add(changeInfo);
		
		
		
//		JButton joinUser = new JButton("회    원    가    입");
//		joinUser.setBounds(460,575, 380, 40);
//		joinUser.setFont(new Font("DungGeunMo", Font.BOLD, 22));
//		panel.add(joinUser);
		
		JButton joinBtn1 = new JButton(new ImageIcon("images/main/joinBtn1.png"));
		joinBtn1.setBounds(460,580, 380, 40);
		joinBtn1.setFont(new Font("DungGeunMo", Font.BOLD, 40));
		joinBtn1.setBorderPainted(false);
		
		ImageIcon joinBtn2 = new ImageIcon("images/main/joinBtn2.png");
		joinBtn1.setRolloverIcon(joinBtn2);
		joinBtn1.setBorderPainted(false);
		joinBtn1.setPreferredSize(new Dimension(380, 40));
		
//		joinBtn1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		panel.add(joinBtn1);
		
		joinBtn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("회원가입 클릭");
				ChangePanel cp = new ChangePanel(mf, panel);
				//t1.setDaemon(true);
				B_CheckPanel fp = new B_CheckPanel(mf);
				
				cp.replacePanel(fp);
			}
		});
		
		
		
		
		loginBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int ctn = 0;
				System.out.println("로그인 클릭");
				if(text.getText().equals("") && !passwordText.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "아이디를 입력해주세요.");
					ctn++;
				}
				
				if(passwordText.getText().equals("") && !text.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "비밀번호를 입력해주세요.");
					ctn++;
				}
				
				if(passwordText.getText().equals("") && text.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "아이디,비밀번호를 입력해주세요.");
					ctn++;
				}
				
				if(ctn == 0 && text.getText().equals("admin") && !passwordText.getText().equals("admin")) {
					JOptionPane.showMessageDialog(null, "비밀번호가 틀렸습니다.");
					ctn++;
				}
				
				if(ctn == 0 && text.getText().equals("admin") && passwordText.getText().equals("admin")) {
				ChangePanel cp = new ChangePanel(mf, panel);
				B_IntroVideoPanel fp = new B_IntroVideoPanel(mf);
				cp.replacePanel(fp);
				}
			}
		});
		
		
		
		findId1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("아이디 / 비밀번호 찾기 패널");
				ChangePanel cp = new ChangePanel(mf, panel);
				//t1.setDaemon(true);
				A_FindPage fp = new A_FindPage(mf);
				
				cp.replacePanel(fp);
			}
		});
		
		setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
				new ImageIcon("images/main/mouse.png").getImage(),
				new Point(0,0),"images/main/mouse.png"));
		
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
