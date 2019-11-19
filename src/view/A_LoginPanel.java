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
import java.util.ArrayList;

import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.B_UserManager;
import model.dao.B_UserDao;
import model.vo.User;


public class A_LoginPanel extends JPanel {
	private JFrame mf;
	private JPanel panel;
	private JLabel label;
	private JLabel intro;
	private JTextField text;
	private JPasswordField passwordText;
	private B_UserDao ud = new B_UserDao();
	
	int bgmOnOff;
	User user = new User();
	public A_LoginPanel(JFrame mf) {
		
		this.mf = mf;
		this.setLayout(null);
		panel = this;
		
		this.setBounds(0, 0, 1300, 770);
		System.out.println("패널생성");
		
		
		JLabel loginBackground = new JLabel(new ImageIcon(new ImageIcon("images/main/loginpage2.gif")
				.getImage().getScaledInstance(1300, 770, 0)));
		loginBackground.setBounds(0, 0, 1300, 770);
		
		JLabel loginLogo = new JLabel(new ImageIcon(new ImageIcon("images/main/loginLogo.gif")
				.getImage().getScaledInstance(900, 350, 0)));
		loginLogo.setBounds(210 , 50, 900, 350);
		
		JLabel allImg = new JLabel(new ImageIcon(new ImageIcon("images/main/all.png")
				.getImage().getScaledInstance(150, 150, 0)));
		allImg.setBounds(1150 , 0, 150,150);
		
		
		
		//음악 on/off
		JButton bgmOnOffBtn = new JButton();
		bgmOnOffBtn.setBounds(0, 670, 100,100);
		bgmOnOffBtn.setContentAreaFilled(false);		//내용영역 채우기 없음
		bgmOnOffBtn.setBorderPainted(false);		//외곽선 제거
		bgmOnOffBtn.setOpaque(false);	//투명하게
		this.add(bgmOnOffBtn);
		
		//on이미지
		JLabel bgmOnImg = new JLabel(new ImageIcon(new ImageIcon("images/main/sound-on.png")
				.getImage().getScaledInstance(50, 50, 0)));
		bgmOnImg.setBounds(30, 680, 50,50);
		this.add(bgmOnImg);
		
		
		//off이미지
		JLabel bgmOffImg = new JLabel(new ImageIcon(new ImageIcon("images/main/sound-off.png")
				.getImage().getScaledInstance(50, 50, 0)));
		bgmOffImg.setBounds(30, 680, 50,50);
		
		//음악 on/off 버튼 클릭시 작동할 메소드
		bgmOnOffBtn.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				
				if(bgmOnOff == 0) {
					new A_Music().intoBgmStop();
					bgmOnOff = 1;
					panel.remove(bgmOnImg);
					panel.add(bgmOffImg);	
					panel.revalidate();	
					panel.repaint();
					panel.setComponentZOrder(bgmOffImg, 0);
					
				} else if(bgmOnOff == 1) {
					new A_Music().introBgm();
					bgmOnOff = 0;
					panel.remove(bgmOffImg);
					panel.add(bgmOnImg);	
					panel.revalidate();	
					panel.repaint();
					panel.setComponentZOrder(bgmOnImg, 0);
				}
			}
		});
		
		
		
		//마우스커서
		setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
				new ImageIcon("images/main/mouse.png").getImage(),
				new Point(0,0),"DobbyCursor"));
		
		
		//아이디
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
		
		
		//비밀번호
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
		
		
		
		//게임 버전 표시
		label = new JLabel("Dobbys v1.0.0");
		label.setBounds(1120, 710, 180, 30);
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("DungGeunMo", Font.BOLD, 23));
		panel.add(label);
		
		//로그인 버튼
		JButton loginBtn = new JButton(new ImageIcon("images/main/loginBtn1.png"));
		loginBtn.setBounds(850, 447 , 130, 120);
		loginBtn.setFont(new Font("DungGeunMo", Font.BOLD, 40));
		loginBtn.setBorderPainted(false);
		
		ImageIcon loginBtnImg2 = new ImageIcon("images/main/loginBtn2-1.png");
		loginBtn.setRolloverIcon(loginBtnImg2);
		loginBtn.setBorderPainted(false);
		loginBtn.setPreferredSize(new Dimension(130,120));
		
		loginBtn.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
				new ImageIcon("images/main/mouse3.png").getImage(),
				new Point(0,0),"images/main/mouse3.png"));
		
		loginBtn.setContentAreaFilled(false);		//내용영역 채우기 없음
		loginBtn.setBorderPainted(false);		//외곽선 제거
		loginBtn.setOpaque(false);	//투명하게

		
		panel.add(loginBtn);
		
//		loginBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		
		//아이디 비밀번호 찾기 버튼
		JButton findId1 = new JButton(new ImageIcon("images/main/findId1.png"));
		findId1.setBounds(460,635, 220, 35);
		findId1.setFont(new Font("DungGeunMo", Font.BOLD, 40));
		findId1.setBorderPainted(false);
		
		ImageIcon findId2 = new ImageIcon("images/main/findId2.png");
		findId1.setRolloverIcon(findId2);
		findId1.setBorderPainted(false);
		findId1.setPreferredSize(new Dimension(220, 35));
		
		findId1.setContentAreaFilled(false);		//내용영역 채우기 없음
		findId1.setBorderPainted(false);		//외곽선 제거
		findId1.setOpaque(false);	//투명하게
		
		
		panel.add(findId1);
		
		
		JButton changePw = new JButton("회원정보 수정");
		changePw.setBounds(690,635, 150, 35);
		changePw.setFont(new Font("DungGeunMo", Font.BOLD, 18));
		panel.add(changePw);
		
		
		//회원가입 버튼
		JButton joinBtn1 = new JButton(new ImageIcon("images/main/joinBtn1.png"));
		joinBtn1.setBounds(460,580, 380, 40);
		joinBtn1.setFont(new Font("DungGeunMo", Font.BOLD, 40));
		joinBtn1.setBorderPainted(false);
		
		ImageIcon joinBtn2 = new ImageIcon("images/main/joinBtn2.png");
		joinBtn1.setRolloverIcon(joinBtn2);
		joinBtn1.setBorderPainted(false);
		joinBtn1.setPreferredSize(new Dimension(380, 40));
		
		joinBtn1.setContentAreaFilled(false);		//내용영역 채우기 없음
		joinBtn1.setBorderPainted(false);		//외곽선 제거
		joinBtn1.setOpaque(false);	//투명하게
		
		
		panel.add(joinBtn1);
		
		joinBtn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("회원가입 클릭");
				ChangePanel cp = new ChangePanel(mf, panel);
				//t1.setDaemon(true);
				B_CheckPanel fp = new B_CheckPanel(mf);
				
				cp.replacePanel(fp);
			}
		});
		
		changePw.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("회원정보 수정 클릭");
				ChangePanel cp = new ChangePanel(mf, panel);
				//t1.setDaemon(true);
				A_ChangePage fp = new A_ChangePage(mf);
				
				cp.replacePanel(fp);
			}
		});
		
		
		loginBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("로그인 버튼 클릭");
				//로그인 성공시 음악정지 (변수)
				A_Music stopMusic = new A_Music();
				
				B_UserManager um = new B_UserManager();
				
				
				
				//로그인창 아이디창 공백일시
				if(text.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "아이디를 입력해 주십시오.");
				}else {
					
					if(um.checkUserId(text.getText())) {
						System.out.println("아이디 존재");
						//로그인창 아이디와 입력값이 같으면 비밀번호 체크
						ArrayList<User> list = ud.readUserList();
						
						
						
						//일치하는 user 정보를 담을 레퍼런스 변수 초기화
						User selectedUser = null;
						//조회에 성공하면 유저 아이디와 일치하는 비밀번호를 리스트에서 탐색
						if(list != null) {
							for(int i = 0; i < list.size(); i++) {
								if(list.get(i).getId().equals(text.getText())) {
									selectedUser = list.get(i);
									break;
								}
							}
						}
						
						
						
						if(selectedUser.getPw().equals(passwordText.getText())) {
							System.out.println("로그인 성공!");
							//음악정지
							stopMusic.intoBgmStop();
							ChangePanel cp = new ChangePanel(mf, panel);
							B_IntroVideoPanel iv = new B_IntroVideoPanel(mf);
							cp.replacePanel(iv);
						} else {
							JOptionPane.showMessageDialog(null, "비밀번호가 틀렸습니다.");
						}
						
					}else {
						JOptionPane.showMessageDialog(null, "아이디가 존재하지 않습니다.");
					}
				}
			}
		});
		
		
		
		findId1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("아이디 / 비밀번호 찾기 패널");
				ChangePanel cp = new ChangePanel(mf, panel);
				//t1.setDaemon(true);
				A_FindPage fp = new A_FindPage(mf);
				
				cp.replacePanel(fp);
			}
		});
		
		this.add(allImg);
		this.add(loginLogo);
		this.add(loginBackground);

	}
	
}
