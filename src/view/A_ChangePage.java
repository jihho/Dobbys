package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.B_UserManager;
import model.dao.B_UserDao;
import model.vo.User;

public class A_ChangePage extends JPanel {

	private JFrame mf;
	private JPanel panel;
	private JLabel label;
	private JTextField textId;
	private JPasswordField nowPw;
	private JPasswordField newPw;
	private JPasswordField checkPw;
	private JLabel changeLabel;
	private JButton changeBtn1;
	
	
	private B_UserDao ud = new B_UserDao();
	
	public A_ChangePage(JFrame mf) {
		
		JLabel changeBackground = new JLabel(new ImageIcon(new ImageIcon("images/main/loginpage2.gif")
				.getImage().getScaledInstance(1300, 770, 0)));
		changeBackground.setBounds(0, 0, 1300, 770);
		
		this.mf = mf;
		this.setLayout(null);
		panel = this;
		
		//커서
		setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
				new ImageIcon("images/main/mouse.png").getImage(),
				new Point(0,0),"images/main/mouse.png"));
		
		
		//아이디찾기 (이름, 이메일) 
		label = new JLabel("비밀번호 변경");
		label.setBounds(480, 80, 500, 50);
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("DungGeunMo", Font.BOLD, 50));
		panel.add(label);

		// 아이디
		textId = new JTextField();
		textId.setBounds(400, 220, 500, 60);
		textId.setFont(new Font("DungGeunMo", Font.PLAIN, 30));
		panel.add(textId);
		textId.setColumns(15);

		label = new JLabel("아이디");
		label.setBounds(400, 180, 300, 50);
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("DungGeunMo", Font.BOLD, 25));
		panel.add(label);

		// 현재 비밀번호
		nowPw = new JPasswordField();
		nowPw.setBounds(400, 320, 500, 60);
		nowPw.setFont(new Font("DungGeunMo", Font.PLAIN, 30));
		panel.add(nowPw);
		nowPw.setColumns(15);

		label = new JLabel("현재 비밀번호");
		label.setBounds(400, 280, 300, 50);
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("DungGeunMo", Font.BOLD, 25));
		panel.add(label);

		// 변경할 비밀번호
		newPw = new JPasswordField();
		newPw.setBounds(400, 420, 500, 60);
		newPw.setFont(new Font("DungGeunMo", Font.PLAIN, 30));
		panel.add(newPw);
		newPw.setColumns(15);

		label = new JLabel("새 비밀번호");
		label.setBounds(400, 380, 300, 50);
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("DungGeunMo", Font.BOLD, 25));
		panel.add(label);

		// 변경할 비밀번호 확인
		checkPw = new JPasswordField();
		checkPw.setBounds(400, 520, 500, 60);
		checkPw.setFont(new Font("DungGeunMo", Font.PLAIN, 30));
		panel.add(checkPw);
		checkPw.setColumns(15);

		label = new JLabel("새 비밀번호 확인");
		label.setBounds(400, 480, 300, 50);
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("DungGeunMo", Font.BOLD, 25));
		panel.add(label);
		
		changeLabel = new JLabel("");
		changeLabel.setBounds(400, 570, 700, 50);
		changeLabel.setForeground(new Color(255, 255, 255));
		changeLabel.setFont(new Font("DungGeunMo", Font.BOLD, 25));
		panel.add(changeLabel);
		
		
		
		
		
		//비밀번호 변경 버튼
		changeBtn1 = new JButton(new ImageIcon("images/main/changeBtn1.png"));
		changeBtn1.setBounds(400, 660, 500, 60);
		changeBtn1.setFont(new Font("DungGeunMo", Font.BOLD, 40));
		changeBtn1.setBorderPainted(false);
		
		ImageIcon changeBtn2 = new ImageIcon("images/main/changeBtn2.png");
		changeBtn1.setRolloverIcon(changeBtn2);
		changeBtn1.setPreferredSize(new Dimension(140, 70));
		
		changeBtn1.setContentAreaFilled(false);		//내용영역 채우기 없음
		changeBtn1.setBorderPainted(false);		//외곽선 제거
		changeBtn1.setOpaque(false);	//투명하게
		
		panel.add(changeBtn1);
		
		
		//돌아가기 버튼
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
		
		
		changeBtn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				B_UserManager um = new B_UserManager();

				
				//아이디 혹은 비밀번호 공백일시
				if ((textId.getText().equals("") || (nowPw.getText().equals("")))) {
					changeLabel.setText("아이디와 비밀번호를 입력해주세요.");
					changeLabel.setForeground(new Color(230, 0, 0));
				} else {

					//아이디 존재여부
					if (um.checkUserId(textId.getText())) {
						//아이디와 같은 유저 정보 불러오기
						ArrayList<User> list = ud.readUserList();

						// 일치하는 user 정보를 담을 레퍼런스 변수 초기화
						User selectedUser = null;
						// 조회에 성공하면 유저 아이디와 일치하는 비밀번호를 리스트에서 탐색
						if (list != null) {
							for (int i = 0; i < list.size(); i++) {
								if (list.get(i).getId().equals(textId.getText())) {
									selectedUser = list.get(i);
									break;
								}
							}
						}
						//아이디가 없을시
						if(selectedUser == null) {
							changeLabel.setText("아이디가 존재하지 않습니다.");
							changeLabel.setForeground(new Color(230, 0, 0));
						}
						//아이디와 비밀번호 일치시
						if (selectedUser.getPw().equals(nowPw.getText())) {
							//모든 정보가 일치 (비밀번호 변경)
							if(newPw.getText().equals(checkPw.getText())
									&& newPw.getText().length() > 0) {
								//임시비밀번호 변경
								um.updatePw(textId.getText(), checkPw.getText());
								changeLabel.setText("비밀번호가 변경 되었습니다.");
								changeLabel.setForeground(new Color(0, 200, 0));
								textId.setText("");
								nowPw.setText("");
								newPw.setText("");
								checkPw.setText("");
								
								
							} else { 
								//아이디, 비밀번호 일치하나 변경 비밀번호가 다름
								changeLabel.setText("새 비밀번호가 일치하지 않습니다.");
								changeLabel.setForeground(new Color(230, 0, 0));
								newPw.setText("");
								checkPw.setText("");
							}
							
						} else {
							//아이디가 존재, 비밀번호 불일치
							changeLabel.setText("현재 비밀번호가 일치하지 않습니다.");
							changeLabel.setForeground(new Color(230, 0, 0));
							nowPw.setText("");
						}
			
					} else {
						//아이디가 없음
						changeLabel.setText("아이디가 존재하지 않습니다.");
						changeLabel.setForeground(new Color(230, 0, 0));
						textId.setText("");
						nowPw.setText("");
						newPw.setText("");
						checkPw.setText("");
					}
				}
			}
		});
		
		
		this.setBounds(0, 0, 1300, 770);
		this.add(changeBackground);
	}
	
	
	
	
	
	
//	// 작업중@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//	@Override
//	public void actionPerformed(ActionEvent e) {
//
//		B_UserManager um = new B_UserManager();
//
//		
//		//아이디 혹은 비밀번호 공백일시
//		if (e.getSource() == changeBtn1 && ((textId.getText().equals("") || (nowPw.getText().equals(""))))) {
//			changeLabel.setText("아이디와 비밀번호를 입력해주세요.");
//			changeLabel.setForeground(new Color(230, 0, 0));
//		} else {
//
//			if (e.getSource() == changeBtn1 && um.checkUserId(textId.getText())) {
//				//아이디가 존재하면 비밀번호 체크
//				ArrayList<User> list = ud.readUserList();
//
//				// 일치하는 user 정보를 담을 레퍼런스 변수 초기화
//				User selectedUser = null;
//				// 조회에 성공하면 유저 아이디와 일치하는 비밀번호를 리스트에서 탐색
//				if (list != null) {
//					for (int i = 0; i < list.size(); i++) {
//						if (list.get(i).getId().equals(textId.getText())) {
//							selectedUser = list.get(i);
//							break;
//						}
//					}
//				}
//				
//				if (selectedUser.getPw().equals(nowPw.getText())) {
//					
//					if(newPw.getText() == checkPw.getText()) {
//						changeLabel.setText("비밀번호가 변경 되었습니다.");
//						changeLabel.setForeground(new Color(0, 200, 0));
//					} else { 
//						changeLabel.setText("새 비밀번호가 일치하지 않습니다.");
//						changeLabel.setForeground(new Color(230, 0, 0));
//						newPw.setText("");
//						checkPw.setText("");
//					}
//					
//				} else {
//					changeLabel.setText("현재 비밀번호가 일치하지 않습니다.");
//					changeLabel.setForeground(new Color(230, 0, 0));
//					nowPw.setText("");
//				}
//	
////				//찾기 버튼 클릭 후 textfield 초기화
////				name.setText("");
////				emailId.setText("");
////				id.setText("");
////				emailPw.setText("");
//				
//			}
//		}
//			
//	}	

}
