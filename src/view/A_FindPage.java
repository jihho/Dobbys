package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Random;

import javax.mail.MessagingException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.B_SendMail;
import controller.B_UserManager;
import model.dao.B_UserDao;
import model.vo.User;

public class A_FindPage extends JPanel implements ActionListener{
	private JFrame mf;
	private JPanel panel;
	private JLabel label;
	private JTextField text;
	private JTextField name;
	private JTextField emailId;
	private JTextField id;
	private JTextField emailPw;
	private JButton findIdBtn1;
	private JButton findPwBtn1;
	private JLabel findPwLabel;
	private JLabel findIdLabel;
	private JButton findpw;
	private JButton backPage;
	private String temporaryPw = "";
	
	private B_UserDao ud = new B_UserDao();
	
	//할일 리스트
	//찾기 버튼 눌렀을때 label이 동시에 바뀌는 오류 수정하기
	//User 정보 가져와서 비교하고 이메일 전송하기.
//	버튼명.setCursor(new Cursor(Cursor.HAND_CURSOR));  //손가락 모양 커서
	
	public A_FindPage(JFrame mf) {
		JLabel findBackground = new JLabel(new ImageIcon(new ImageIcon("images/main/loginpage2.gif")
				.getImage().getScaledInstance(1300, 770, 0)));
		findBackground.setBounds(0, 0, 1300, 770);
		
		this.mf = mf;
		this.setLayout(null);
		panel = this;
		
		//아이디찾기 (이름, 이메일) 
		label = new JLabel("아이디 찾기");
		label.setBounds(300, 120, 300, 50);
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("DungGeunMo", Font.BOLD, 50));
		panel.add(label);
		
		name = new JTextField();
		name.setBounds(300,190,500,60);
		name.setFont(new Font("DungGeunMo", Font.PLAIN, 30));
		panel.add(name);
		name.setColumns(15);
		
		label = new JLabel("이름 : ");
		label.setBounds(200, 190, 300, 50);
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("DungGeunMo", Font.BOLD, 30));
		panel.add(label);
		
		emailId = new JTextField();
		emailId.setBounds(300,260,500,60);
		emailId.setFont(new Font("DungGeunMo", Font.PLAIN, 30));
		panel.add(emailId);
		emailId.setColumns(15);
		
		label = new JLabel("이메일 : ");
		label.setBounds(170, 260, 300, 50);
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("DungGeunMo", Font.BOLD, 30));
		panel.add(label);
		
		
		
		//아이디 찾기 버튼
		findIdBtn1 = new JButton(new ImageIcon("images/main/findId1-1.png"));
		findIdBtn1.setBounds(820, 260, 250, 60);
		findIdBtn1.setFont(new Font("DungGeunMo", Font.BOLD, 40));
		findIdBtn1.setBorderPainted(false);
		
		ImageIcon findIdBtn2 = new ImageIcon("images/main/findId2-1.png");
		findIdBtn1.setRolloverIcon(findIdBtn2);
		findIdBtn1.setPreferredSize(new Dimension(250, 60));
		
		findIdBtn1.setContentAreaFilled(false);		//내용영역 채우기 없음
		findIdBtn1.setBorderPainted(false);		//외곽선 제거
		findIdBtn1.setOpaque(false);	//투명하게
		
		panel.add(findIdBtn1);
		
		
		
		
		//아이디 찾기 버튼 누르면 아이디 Label 출력.
		findIdBtn1.addActionListener(this);
		findIdLabel = new JLabel("");
		findIdLabel.setBounds(300,330,800, 30);
		findIdLabel.setForeground(new Color(255, 255, 255));
		findIdLabel.setFont(new Font("DungGeunMo", Font.BOLD, 30));
		panel.add(findIdLabel);
		
		
		//비밀번호 찾기 (아이디, 이메일)
		label = new JLabel("비밀번호 찾기");
		label.setBounds(300, 400, 500, 50);
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("DungGeunMo", Font.BOLD, 50));
		panel.add(label);
		
		id = new JTextField();
		id.setBounds(300,470,500,60);
		id.setFont(new Font("DungGeunMo", Font.PLAIN, 30));
		panel.add(id);
		id.setColumns(15);
		
		label = new JLabel("아이디 : ");
		label.setBounds(170, 470, 300, 50);
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("DungGeunMo", Font.BOLD, 30));
		panel.add(label);
		
		emailPw = new JTextField();
		emailPw.setBounds(300,540,500,60);
		emailPw.setFont(new Font("DungGeunMo", Font.PLAIN, 30));
		panel.add(emailPw);
		emailPw.setColumns(15);
		
		label = new JLabel("이메일 : ");
		label.setBounds(170, 540, 300, 50);
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("DungGeunMo", Font.BOLD, 30));
		panel.add(label);
		
		
		
		//임시비밀번호 발급 버튼
		findPwBtn1 = new JButton(new ImageIcon("images/main/findPw1.png"));
		findPwBtn1.setBounds(820, 540, 250, 60);
		findPwBtn1.setFont(new Font("DungGeunMo", Font.BOLD, 40));
		findPwBtn1.setBorderPainted(false);
		
		ImageIcon findPwBtn2 = new ImageIcon("images/main/findPw2.png");
		findPwBtn1.setRolloverIcon(findPwBtn2);
		findPwBtn1.setPreferredSize(new Dimension(250, 60));
		
		findPwBtn1.setContentAreaFilled(false);		//내용영역 채우기 없음
		findPwBtn1.setBorderPainted(false);		//외곽선 제거
		findPwBtn1.setOpaque(false);	//투명하게
		
		panel.add(findPwBtn1);
		
		
		findPwBtn1.addActionListener(this);
		findPwLabel = new JLabel("");
		findPwLabel.setBounds(300,610,800, 30);
		findPwLabel.setForeground(new Color(255, 255, 255));
		findPwLabel.setFont(new Font("DungGeunMo", Font.BOLD, 30));
		panel.add(findPwLabel);
		
		
		
		JButton backBtn1 = new JButton(new ImageIcon("images/main/backBtn1.png"));
		backBtn1.setBounds(1140, 660, 140, 70);
		backBtn1.setFont(new Font("DungGeunMo", Font.BOLD, 40));
		backBtn1.setBorderPainted(false);
		
		ImageIcon backBtn2 = new ImageIcon("images/main/backBtn2.png");
		backBtn1.setRolloverIcon(backBtn2);
		backBtn1.setPreferredSize(new Dimension(140, 70));
		
		backBtn1.setContentAreaFilled(false);		//내용영역 채우기 없음
		backBtn1.setBorderPainted(false);		//외곽선 제거
		backBtn1.setOpaque(false);	//투명하게
		

		
		panel.add(backBtn1);
		
	
		backBtn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("돌아가기");
				ChangePanel cp = new ChangePanel(mf, panel);
				//t1.setDaemon(true);
				A_LoginPanel fp = new A_LoginPanel(mf);
				
				cp.replacePanel(fp);
			}
		});
		
		
		
		
		setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
				new ImageIcon("images/main/mouse.png").getImage(),
				new Point(0,0),"images/main/mouse.png"));
		
		
		this.setBounds(0,0,1300,770);
		this.add(findBackground);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		findIdLabel.setText("");
		findPwLabel.setText("");

		B_UserManager um = new B_UserManager();
		
		//아이디찾기
		// 로그인창 아이디창 공백일시
		if (e.getSource() == findIdBtn1 && (name.getText().equals("") || (emailId.getText().equals("")))) {
			findIdLabel.setText("이름,이메일 정보를 입력해주세요.");
			findIdLabel.setForeground(new Color(230, 0, 0));
		} else {

			if (e.getSource() == findIdBtn1 && um.checkUserName(name.getText())) {
				System.out.println("이름 존재");
				// 로그인창 아이디와 입력값이 같으면 비밀번호 체크
				ArrayList<User> list = ud.readUserList();

				// 일치하는 user 정보를 담을 레퍼런스 변수 초기화
				User selectedUser = null;
				// 조회에 성공하면 유저 아이디와 일치하는 비밀번호를 리스트에서 탐색
				if (list != null) {
					for (int i = 0; i < list.size(); i++) {
						if (list.get(i).getName().equals(name.getText())) {
							selectedUser = list.get(i);
							break;
						}
					}
				}

				if (selectedUser.geteMail().equals(emailId.getText())) {
					findIdLabel.setText(selectedUser.getName() + "님의 아이디는 '"+ selectedUser.getId() + "' 입니다.");
					findIdLabel.setForeground(new Color(0, 200, 0));
				} else {
					findIdLabel.setText(selectedUser.getName() + "님의 이메일 정보와 일치하지 않습니다.");
					findIdLabel.setForeground(new Color(230, 0, 0));
				}
			} else if(name.getText().length() >= 1) {
				findIdLabel.setText("일치하는 회원이 없습니다.");
				findIdLabel.setForeground(new Color(230, 0, 0));
			}
		}
		
		
		
		//비밀번호 찾기 (임시비밀번호 발급)
		if (e.getSource() == findPwBtn1 && (id.getText().equals("") || (emailPw.getText().equals("")))) {
			findPwLabel.setText("아이디,이메일 정보를 입력해주세요.");
			findPwLabel.setForeground(new Color(230, 0, 0));
		} else {

			if (e.getSource() == findPwBtn1 && um.checkUserId(id.getText())) {
				System.out.println("아이디 존재");
				
				// 로그인창 아이디와 입력값이 같으면 비밀번호 체크
				ArrayList<User> list = ud.readUserList();

				User selectedUser = null;
				if (list != null) {
					for (int i = 0; i < list.size(); i++) {
						if (list.get(i).getId().equals(id.getText())) {
							selectedUser = list.get(i);
							break;
						}
					}
				}

				//임시비밀번호 전송
				if (selectedUser.geteMail().equals(emailPw.getText())) {
//					findPwLabel.setText(selectedUser.geteMail() +"로 임시 비밀번호를 전송 했습니다.");
//					findPwLabel.setForeground(new Color(0, 200, 0));
//					
//					//이메일전송
//					B_SendMail sm = new B_SendMail();
//					temporaryPw = sm.temporaryPw();
//					System.out.println(temporaryPw);
//					try {
//						sm.sendTemporaryPw(temporaryPw, emailPw.getText());
//					} catch (MessagingException e1) {
//						e1.printStackTrace();
//					}
//					
//					//임시비밀번호 변경
//					um.updatePw(id.getText(), temporaryPw);
					
					
					findPwLabel.setText("임시 비밀번호는 dobbyisfree 입니다.");
					findPwLabel.setForeground(new Color(0, 200, 0));
					
					um.updatePw(id.getText(), "dobbyisfree");
					
					
				} else {
					findPwLabel.setText(selectedUser.getId() + "님의 이메일 정보와 일치하지 않습니다.");
					findPwLabel.setForeground(new Color(230, 0, 0));
				}
			} else if(id.getText().length() >= 1) {
				findPwLabel.setText("일치하는 회원이 없습니다.");
				findPwLabel.setForeground(new Color(230, 0, 0));
			}
		}
		
	
		//찾기 버튼 클릭 후 textfield 초기화
		name.setText("");
		emailId.setText("");
		id.setText("");
		emailPw.setText("");
		
	}
	
	
	//임시 비밀번호 생성
	public String subPassword() {
	
		StringBuffer key = new StringBuffer();
		Random rnd = new Random();
		
		for(int i = 0; i < 10; i++) {
			int index = rnd.nextInt(3);
			
			switch (index) {
			//소문자
			case 0: key.append((char) ((int) (rnd.nextInt(26)) + 97)); break;
			//대문자
			case 1: key.append((char) ((int) (rnd.nextInt(26)) + 65)); break;
			//0~9 숫자
			case 2: key.append((rnd.nextInt(10))); break;
			}
		}
		
		return key.toString();
	}
	
}