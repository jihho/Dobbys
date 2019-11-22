package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.EventHandler;

import javax.mail.MessagingException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.B_SendMail;
import controller.B_UserManager;
import model.vo.User;

public class B_JoinPanel extends JPanel{
	private JFrame mf;
	private JPanel panel;
	private boolean isIdcheck = false;
	private boolean isPwcheck = false;
	private boolean isemailcheck = false;
	private String certPassword = "";
	private User user = new User();
	private String beforePassword = "";
	
	public B_JoinPanel(JFrame mf){
		this.mf = mf;
		this.setLayout(null);
		
		panel = this;
		
		//user.playerId = "jiho";
		//배경
		setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
				new ImageIcon("images/main/mouse.png").getImage(),
				new Point(0,0),"DobbyCursor"));
		JLabel label = new JLabel(new ImageIcon(new ImageIcon("images/main/loginpage2.gif").getImage().getScaledInstance(1300, 770, 0)));
		label.setBounds(0, 0, 1300, 770);
		
		//라벨 변수
		JLabel namelb = new JLabel("닉네임");
		JLabel idlb = new JLabel("아이디");
		JLabel pwlb = new JLabel("비밀번호");
		JLabel pwchecklb = new JLabel("비밀번호 확인");
		JLabel emaillb = new JLabel("이메일");
		JLabel certilb = new JLabel("인증번호");
		JLabel test1 = new JLabel("");
		JLabel joinlb = new JLabel("회원가입");
		
		//textfield 변수
		JTextField namefield = new JTextField();
		JTextField idfield = new JTextField();
		JPasswordField pwfield = new JPasswordField();
		JPasswordField pwcheckfield = new JPasswordField();
		JTextField emailfield = new JTextField();
		JTextField certifield = new JTextField();
		
		//button 변수
		JButton idbutton = new JButton("중복확인");
		JButton joinbutton = new JButton("회원가입");
		JButton jeonsongbutton = new JButton("인증번호 전송");
		JButton checkbutton = new JButton("인증번호 확인");
		JButton cancelbutton = new JButton("취소");
		JButton pwcheckbutton = new JButton("확인");
		
		//위치설정
		namelb.setBounds(450, 300, 100, 70);
		idlb.setBounds(450, 345, 100, 70);
		pwlb.setBounds(450, 390, 100, 70);
		pwchecklb.setBounds(450, 435, 150, 70);
		emaillb.setBounds(450, 480, 100, 70);
		certilb.setBounds(450, 525, 100, 70);
		test1.setBounds(910,440,200,70);
		joinlb.setBounds(570,150, 200, 200);
		
		namefield.setBounds(600, 325, 180, 30);
		idfield.setBounds(600, 370, 180, 30);
		pwfield.setBounds(600, 415, 180, 30);
		pwcheckfield.setBounds(600, 460, 180, 30);
		emailfield.setBounds(600, 505, 180, 30);
		certifield.setBounds(600, 550, 180, 30);
		
		idbutton.setBounds(800, 370, 150, 30);
		joinbutton.setBounds(700, 630, 130, 30);
		jeonsongbutton.setBounds(800, 505, 150, 30);
		checkbutton.setBounds(800, 550, 150, 30);
		cancelbutton.setBounds(550, 630, 100, 30);
		pwcheckbutton.setBounds(800, 460, 100, 30);
		
		idbutton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		joinbutton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		jeonsongbutton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		checkbutton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		cancelbutton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pwcheckbutton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		//폰트, 색상 설정
		namelb.setFont(new Font("DungGeunMo", Font.BOLD, 20));
		namelb.setForeground(Color.white);
	
		
		idlb.setFont(new Font("DungGeunMo", Font.BOLD, 20));
		idlb.setForeground(Color.white);
	
		
		pwlb.setFont(new Font("DungGeunMo", Font.BOLD, 20));
		pwlb.setForeground(Color.white);
	
		
		pwchecklb.setFont(new Font("DungGeunMo", Font.BOLD, 20));
		pwchecklb.setForeground(Color.white);
	
		
		emaillb.setFont(new Font("DungGeunMo", Font.BOLD, 20));
		emaillb.setForeground(Color.white);
	
		
		certilb.setFont(new Font("DungGeunMo", Font.BOLD, 20));
		certilb.setForeground(Color.white);
		
		test1.setFont(new Font("DungGeunMo",Font.BOLD, 18));
		test1.setForeground(Color.red);
		
		joinlb.setFont(new Font("DungGeunMo",Font.BOLD, 40));
		joinlb.setForeground(Color.white);
		
		idbutton.setFont(new Font("DungGeunMo",Font.BOLD,16));
		idbutton.setBackground(Color.lightGray);
		joinbutton.setFont(new Font("DungGeunMo", Font.BOLD, 16));
		joinbutton.setBackground(Color.lightGray);
		jeonsongbutton.setFont(new Font("DungGeunMo", Font.BOLD, 16));
		jeonsongbutton.setBackground(Color.lightGray);
		checkbutton.setFont(new Font("DungGeunMo", Font.BOLD, 16));
		checkbutton.setBackground(Color.lightGray);
		cancelbutton.setFont(new Font("DungGeunMo", Font.BOLD, 16));
		cancelbutton.setBackground(Color.lightGray);
		pwcheckbutton.setFont(new Font("DungGeunMo", Font.BOLD, 16));
		pwcheckbutton.setBackground(Color.lightGray);
		
		//취소 이벤트 -> 이용약관페이지으로 이동
		cancelbutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				new A_Music().btnEffect();
				ChangePanel cp = new ChangePanel(mf, panel);
				B_CheckPanel bcp = new B_CheckPanel(mf);
				cp.replacePanel(bcp);
			}
		
		});
		
		// 회원가입 버튼 이벤트 -> 로그인페이지로 이동
		joinbutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				new A_Music().btnEffect();
				char[] ch = pwfield.getPassword();
				String strPw = "";
				for(int i = 0; i < ch.length; i++) {
					strPw += ch[i];
				}
				
				char[] ch2 = pwcheckfield.getPassword();
				String strPwCheck = "";
				for(int i = 0; i < ch2.length; i++) {
					strPwCheck += ch2[i];
				}
				
				if(namefield.getText().equals("")||idfield.getText().equals("")||strPw.equals("")
						||strPwCheck.equals("")||emailfield.getText().equals("")||certifield.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "모든 입력 창을 입력해주세요.");
				}else {
					if(isIdcheck == false) {	//중복체크를 하지 않았을 경우
						JOptionPane.showMessageDialog(null, "아이디 중복체크를 해주세요.");
					}else {
						if(isPwcheck == false) {	//비밀번호 확인을 하지 않았을 경우
							JOptionPane.showMessageDialog(null, "비밀번호 확인을 해주세요.");
						}else {
							if(isemailcheck == false) {	//이메일 인증번호를 하지 않았을 경우
								JOptionPane.showMessageDialog(null, "이메일 인증번호 확인을 해주세요.");
							}else {
								if(namefield.getText().length() > 5) {
									JOptionPane.showMessageDialog(null, "이름을 5글자 내로 입력해 주세요.");
								}else {
									if(beforePassword.equals(strPw) &&strPw.equals(strPwCheck) && certifield.getText().equals("1234")) {
										user.setId(idfield.getText());
										user.setPw(strPw);
										user.setName(namefield.getText());
										user.seteMail(emailfield.getText());
										
										B_UserManager um = new B_UserManager();
										um.insertUser(user);
										
										ChangePanel cp = new ChangePanel(mf, panel);
										A_LoginPanel lp = new A_LoginPanel(mf);
										cp.replacePanel(lp);
										
									}else {
										JOptionPane.showMessageDialog(null, "확인이 완료되지 않았습니다.");
										
									}
								}
								
							}
						}
						
					}
				}
//				user.setId(idfield.getText());
//				char[] ch = pwfield.getPassword();
//				String str = "";
//				for(int i = 0; i < ch.length; i++) {
//					str+=ch[i];
//				}
//				user.setPw(str); 
//				user.setName(namefield.getText());
//				user.seteMail(emailfield.getText());
				//System.out.println(user);
			}
		
		});

		//중복확인 버튼 이벤트
		idbutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				new A_Music().btnEffect();
				System.out.println(idfield.getText());
				if(idfield.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "아이디를 입력해 주십시오.");
				}else {
					B_UserManager um = new B_UserManager();
					if(um.checkUserId(idfield.getText())) {
						JOptionPane.showMessageDialog(null, "사용할 수 없는 아이디 입니다.");
						isIdcheck = false;
					}else {
						JOptionPane.showMessageDialog(null, "사용 가능한 아이디 입니다.");
						isIdcheck = true;
					}
				}
			}
		});
		
		//인증번호 전송 버튼 이벤트
		jeonsongbutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				new A_Music().btnEffect();
				System.out.println(emailfield.getText());
				if(emailfield.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "이메일을 입력해 주십시오.");
				}else {
//					B_SendMail sm = new B_SendMail();
//					certPassword = sm.generateCertPassword();
//					System.out.println(certPassword);
//					
//					try {
//						sm.sendMail(certPassword, emailfield.getText());
//					} catch (MessagingException e1) {
//						e1.printStackTrace();
//					}
					certPassword = "1234";
					JOptionPane.showMessageDialog(null, emailfield.getText()+"로 인증번호를 전송하였습니다.");
				}
			}
		});
		
		//인증번호 확인 버튼 이벤트
		checkbutton.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseReleased(MouseEvent e) {
				new A_Music().btnEffect();
				System.out.println(certifield.getText());
				if(certifield.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "인증번호를 입력해 주세요.");
					isemailcheck = false;
				}else if(certifield.getText().equals(certPassword)) {
					JOptionPane.showMessageDialog(null, "인증에 성공하셨습니다.");
					isemailcheck = true;
				}else if(!certifield.getText().equals(certPassword)) {
					JOptionPane.showMessageDialog(null, "인증번호가 틀렸습니다.");
					isemailcheck = false;
				}
			}
		});
		
	
		//비밀번호값과 비밀번호 확인 값이 같을때, 다를때 이벤트 구현 
		pwcheckbutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				new A_Music().btnEffect();
				char[] ch = pwfield.getPassword();
				String str = "";
				for(int i = 0; i < ch.length; i++) {
					str+=ch[i];
				}
				char[] ch2 = pwcheckfield.getPassword();
				String str2 = "";
				for(int i = 0; i < ch2.length; i++) {
					str2 += ch2[i];
				}
	
				if(str.equals(str2)) {
					test1.setText("비밀번호가 맞습니다!");
					test1.setForeground(Color.blue);
					beforePassword = str;
					System.out.println(beforePassword);
					isPwcheck = true;
				}else {
					test1.setText("비밀번호가 틀립니다.");
					test1.setForeground(Color.red);
					isPwcheck = false;
				}
			}
		});
		
		//패널에 추가
		this.add(label);
		this.add(idlb);
		this.add(idfield);
		this.add(idbutton);
		
		this.add(pwlb);
		this.add(pwfield);
		
		this.add(pwchecklb);
		this.add(pwcheckfield);
		
		this.add(namelb);
		this.add(namefield);
		
		this.add(emaillb);
		this.add(emailfield);
		
		this.add(certilb);
		this.add(certifield);
		
		this.add(joinbutton);
		this.add(jeonsongbutton);
		this.add(checkbutton);
		this.add(cancelbutton);
		this.add(test1);
		this.add(pwcheckbutton);
		this.add(joinlb);
		this.setComponentZOrder(label, 20);
		
		
	}
}
