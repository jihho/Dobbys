package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
import javax.swing.SwingUtilities;

import controller.B_UserManager;
import model.dao.B_UserDao;
import model.vo.User;


public class A_LoginPanel extends JPanel {
	private JFrame mf;
	private JPanel panel;
	private JLabel label;
	private JLabel loginInfo;
	private JLabel intro;
	private JTextField text;
	private JPasswordField passwordText;
	private B_UserDao ud = new B_UserDao();
	
	//마우스 번호 변수
	public static int mouseNum;
	
	int bgmOnOff = 0;
	
	User user = new User();
	public A_LoginPanel(JFrame mf) {
		//마우스 번호
		mouseNum = 1;
		
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
		allImg.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		
		JLabel dobby = new JLabel(new ImageIcon(new ImageIcon("images/main/dobby1-long.gif")
				.getImage().getScaledInstance(100, 200, 0)));
		dobby.setBounds(450 , 50, 100,200);
		
		
		
		
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
				new ImageIcon("images/main/mouse" + mouseNum + ".png").getImage(),
				new Point(0,0),"DobbyCursor"));
		
		//아이디
		label = new JLabel("User ID");
		label.setBounds(330, 450, 150, 50);
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("DungGeunMo", Font.PLAIN, 30));
		panel.add(label);
		
		text = new JTextField();
		text.setBounds(460,445,380,60);
		text.setFont(new Font("DungGeunMo", Font.PLAIN, 30));
		panel.add(text);
		text.setColumns(15);
		
		text.requestFocus();
//		text.setOpaque(false);
		
		
		
		//비밀번호
		label = new JLabel("Password");
		label.setBounds(310, 515, 150, 50);
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("DungGeunMo", Font.PLAIN, 30));
		panel.add(label);
		
		passwordText = new JPasswordField();
		passwordText.setBounds(460,510,380,60);
		passwordText.setFont(new Font("DungGeunMo", Font.PLAIN, 25));
		panel.add(passwordText);
		passwordText.setColumns(15);
		
		
		//로그인시 일치여부 문구
		loginInfo = new JLabel("");
		loginInfo.setBounds(460, 400, 500, 50);
		loginInfo.setForeground(new Color(255,255,255));
		loginInfo.setFont(new Font("DungGeunMo", Font.PLAIN, 25));
		panel.add(loginInfo);
		
		
		
		//게임 버전 표시
		label = new JLabel("Dobbys v1.6.22");
		label.setBounds(1080, 700, 230, 30);
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("DungGeunMo", Font.PLAIN, 23));
		panel.add(label);
		
		//로그인 버튼
		JButton loginBtn = new JButton(new ImageIcon("images/main/login1.png"));
		loginBtn.setBounds(462, 580 , 376, 60);
		loginBtn.setFont(new Font("DungGeunMo", Font.PLAIN, 40));
		loginBtn.setBorderPainted(false);
		
		ImageIcon loginBtnImg2 = new ImageIcon("images/main/login2.gif");
		loginBtn.setRolloverIcon(loginBtnImg2);
		loginBtn.setBorderPainted(false);
		loginBtn.setPreferredSize(new Dimension(376,70));
		
		loginBtn.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
				new ImageIcon("images/main/intromouse.png").getImage(),
				new Point(0,0),"images/main/mouse1-2.png"));
		
		loginBtn.setContentAreaFilled(false);		//내용영역 채우기 없음
		loginBtn.setBorderPainted(false);		//외곽선 제거
		loginBtn.setOpaque(false);	//투명하게

		panel.add(loginBtn);
		
		
		
		//아이디 비밀번호 찾기 버튼
		JButton findId1 = new JButton(new ImageIcon("images/main/findId1.png"));
		findId1.setBounds(620,655, 220, 35);
		findId1.setFont(new Font("DungGeunMo", Font.PLAIN, 40));
		findId1.setBorderPainted(false);
		
		ImageIcon findId2 = new ImageIcon("images/main/findId2.png");
		findId1.setRolloverIcon(findId2);
		findId1.setBorderPainted(false);
		findId1.setPreferredSize(new Dimension(220, 35));
		
		findId1.setContentAreaFilled(false);		//내용영역 채우기 없음
		findId1.setBorderPainted(false);		//외곽선 제거
		findId1.setOpaque(false);	//투명하게
		
		panel.add(findId1);
		
		
		//회원가입 버튼
		JButton joinBtn1 = new JButton(new ImageIcon("images/main/join1.png"));
		joinBtn1.setBounds(460,655, 150, 35);
		joinBtn1.setFont(new Font("DungGeunMo", Font.PLAIN, 40));
		joinBtn1.setBorderPainted(false);
		
		ImageIcon joinBtn2 = new ImageIcon("images/main/join2.png");
		joinBtn1.setRolloverIcon(joinBtn2);
		joinBtn1.setBorderPainted(false);
		joinBtn1.setPreferredSize(new Dimension(150, 35));
		
		joinBtn1.setContentAreaFilled(false);		//내용영역 채우기 없음
		joinBtn1.setBorderPainted(false);		//외곽선 제거
		joinBtn1.setOpaque(false);	//투명하게
		
		joinBtn1.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
				new ImageIcon("images/main/mouse1-2.png").getImage(),
				new Point(0,0),"images/main/mouse1-2.png"));
		
		
		panel.add(joinBtn1);
		
		
		
		joinBtn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("회원가입 클릭");
				new A_Music().btnEffect2();
				
				ChangePanel cp = new ChangePanel(mf, panel);
				//t1.setDaemon(true);
				B_CheckPanel fp = new B_CheckPanel(mf);
				
				cp.replacePanel(fp);
			}
		});
		
		
		text.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				//아이디창 타자음
				new A_Music().btnTyping();
			}		
		});
		
		
		//패스워드 창에서 엔터키 입력시 로그인 버튼 클릭.
		passwordText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				//타자소리
				new A_Music().btnTyping();
				
				if (e.getKeyCode() == 10) {
					loginBtn.doClick();
					new A_Music().btnEffect();
					// 로그인 성공시 음악정지 (변수)
					A_Music stopMusic = new A_Music();

					B_UserManager um = new B_UserManager();
					
					// 로그인창 아이디창 공백일시
					if (text.getText().equals("")) {
						loginInfo.setText("아이디를 입력해 주세요.");
						loginInfo.setForeground(new Color(230, 0, 0));
						text.requestFocus();
					} else {

						if (um.checkUserId(text.getText())) {
							System.out.println("아이디 존재");
							// 로그인창 아이디와 입력값이 같으면 비밀번호 체크
							ArrayList<User> list = ud.readUserList();
							// 일치하는 user 정보를 담을 레퍼런스 변수 초기화
							User selectedUser = null;
							// 조회에 성공하면 유저 아이디와 일치하는 비밀번호를 리스트에서 탐색
							if (list != null) {
								for (int i = 0; i < list.size(); i++) {
									if (list.get(i).getId().equals(text.getText())) {
										selectedUser = list.get(i);
										break;
									}
								}
							}

							// 아이디 존재 / 비밀번호 비교
							if (selectedUser.getPw().equals(passwordText.getText())) {
								System.out.println("로그인 성공!");
								User.playerId = selectedUser.getId();
								// 음악정지
								stopMusic.intoBgmStop();
								ChangePanel cp = new ChangePanel(mf, panel);
								B_IntroVideoPanel iv = new B_IntroVideoPanel(mf);
								cp.replacePanel(iv);
							} else {
								loginInfo.setText("비밀번호가 틀렸습니다.");
								loginInfo.setForeground(new Color(230, 0, 0));
								passwordText.setText("");
								passwordText.requestFocus();
							}

						} else {
							loginInfo.setText("아이디가 존재하지 않습니다.");
							loginInfo.setForeground(new Color(230, 0, 0));
							text.setText("");
							passwordText.setText("");
							text.requestFocus();

						}
					}
				}
			}
		});
		
				
		//마우스로 로그인 버튼 클릭시
		loginBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("로그인 버튼 클릭");
				new A_Music().btnEffect();
				
				//로그인 성공시 음악정지 (변수)
				A_Music stopMusic = new A_Music();
				
				B_UserManager um = new B_UserManager();
				
				
				
				//로그인창 아이디창 공백일시
				if(text.getText().equals("")) {
					loginInfo.setText("아이디를 입력해 주세요.");
					loginInfo.setForeground(new Color(230, 0, 0));
					text.requestFocus();
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
						
						
						//아이디 존재 상태에서 비밀번호 비교
						if(selectedUser.getPw().equals(passwordText.getText())) {
							System.out.println("로그인 성공!");
							User.playerId = selectedUser.getId();
							//음악정지
							stopMusic.intoBgmStop();
							ChangePanel cp = new ChangePanel(mf, panel);
							B_IntroVideoPanel iv = new B_IntroVideoPanel(mf);
							cp.replacePanel(iv);
						} else {
							loginInfo.setText("비밀번호가 틀렸습니다.");
							loginInfo.setForeground(new Color(230, 0, 0));
							passwordText.setText("");
							passwordText.requestFocus();
						}
						
					}else {
						loginInfo.setText("아이디가 존재하지 않습니다.");
						loginInfo.setForeground(new Color(230, 0, 0));
						text.setText("");
						passwordText.setText("");
						text.requestFocus();
						
					}
				}
			}
		});
		
		
		
		findId1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("아이디 / 비밀번호 찾기 패널");
				new A_Music().btnEffect2();
				
				ChangePanel cp = new ChangePanel(mf, panel);
				//t1.setDaemon(true);
				A_FindPage fp = new A_FindPage(mf);
				
				cp.replacePanel(fp);
			}
		});
		
		//크리에이터 (숨은버튼)
		allImg.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				new A_Music().intoBgmStop();
				new A_Music().btnEffect();
				
				ChangePanel cp = new ChangePanel(mf, panel);
				//t1.setDaemon(true);
				A_HidePage fp = new A_HidePage(mf);
				
				cp.replacePanel(fp);
			}
		});
		
		
		this.add(allImg);
		this.add(loginLogo);
		this.add(dobby);
		this.add(loginBackground);

		
	}
	
}
