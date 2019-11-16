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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class A_FindPage extends JPanel implements ActionListener{
	private JFrame mf;
	private JPanel panel;
	private JLabel label;
	private JTextField text;
	private JTextField name;
	private JTextField id;
	private JTextField email;
	private JButton findIdBtn1;
	private JButton findPwBtn1;
	private JLabel findPwLabel;
	private JLabel findIdLabel;
	private JButton findpw;
	private JButton backPage;
	
	//할일 리스트
	//찾기 버튼 눌렀을때 label이 동시에 바뀌는 오류 수정하기
	//User 정보 가져와서 비교하고 이메일 전송하기.
	
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
		
		email = new JTextField();
		email.setBounds(300,260,500,60);
		email.setFont(new Font("DungGeunMo", Font.PLAIN, 30));
		panel.add(email);
		email.setColumns(15);
		
		label = new JLabel("이메일 : ");
		label.setBounds(170, 260, 300, 50);
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("DungGeunMo", Font.BOLD, 30));
		panel.add(label);
		
//		findid = new JButton("이메일로 아이디 전송");
//		findid.setBounds(820, 260, 250, 60);
//		findid.setFont(new Font("DungGeunMo", Font.BOLD, 20));
//		panel.add(findid);
		
		
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
		
//		findIdBtn1.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseReleased(MouseEvent e) {
//				System.out.println("아이디 찾기 버튼");
//				JButton loginLogo = new JButton(new ImageIcon(new ImageIcon("images/main/all.png")
//						.getImage().getScaledInstance(730, 300, 0)));
//				loginLogo.setBounds(290, 100, 730, 300);
//				
//				panel.add(loginLogo);
//			}
//		});
		
		
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
		
		email = new JTextField();
		email.setBounds(300,540,500,60);
		email.setFont(new Font("DungGeunMo", Font.PLAIN, 30));
		panel.add(email);
		email.setColumns(15);
		
		label = new JLabel("이메일 : ");
		label.setBounds(170, 540, 300, 50);
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("DungGeunMo", Font.BOLD, 30));
		panel.add(label);
		
//		findpw = new JButton("임시 비밀번호 발급");
//		findpw.setBounds(820, 510, 250, 60);
//		findpw.setFont(new Font("DungGeunMo", Font.BOLD, 20));
//		panel.add(findpw);
		
		
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
		
//		findPwBtn1.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseReleased(MouseEvent e) {
//				System.out.println("돌아가기");
//				ChangePanel cp = new ChangePanel(mf, panel);
//				//t1.setDaemon(true);
//				A_LoginPanel fp = new A_LoginPanel(mf);
//				
//				cp.replacePanel(fp);
//			}
//		});
		
		findPwBtn1.addActionListener(this);
		findPwLabel = new JLabel("");
		findPwLabel.setBounds(300,610,800, 30);
		findPwLabel.setForeground(new Color(255, 255, 255));
		findPwLabel.setFont(new Font("DungGeunMo", Font.BOLD, 30));
		panel.add(findPwLabel);
		
		
		
//		backPage = new JButton("돌아가기");
//		backPage.setBounds(1100, 620, 140, 70);
//		backPage.setFont(new Font("DungGeunMo", Font.BOLD, 25));
//		panel.add(backPage);
		
		JButton backBtn1 = new JButton(new ImageIcon("images/main/backBtn1.png"));
		backBtn1.setBounds(1100, 620, 140, 70);
		backBtn1.setFont(new Font("DungGeunMo", Font.BOLD, 40));
		backBtn1.setBorderPainted(false);
		
		ImageIcon backBtn2 = new ImageIcon("images/main/backBtn2.png");
		backBtn1.setRolloverIcon(backBtn2);
		backBtn1.setPreferredSize(new Dimension(140, 70));
		
		backBtn1.setContentAreaFilled(false);		//내용영역 채우기 없음
		backBtn1.setBorderPainted(false);		//외곽선 제거
		backBtn1.setOpaque(false);	//투명하게
		
//		backBtn1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
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
		
		
		//아이디찾기
		if(e.getSource() == findIdBtn1 && name.getText().equals("박하영")) {
			findIdLabel.setText("박하영님의 아이디는 'admin' 입니다.");
			findIdLabel.setForeground(new Color(0, 200, 0));
			
		} else if(name.getText().length() >= 1){
			findIdLabel.setText("일치하는 회원이 없습니다.");
			findIdLabel.setForeground(new Color(230, 0, 0));
		}
		
		
		//비밀번호찾기
		if(e.getSource() == findPwBtn1 && id.getText().equals("admin")) {
			findPwLabel.setText("이메일로 임시 비밀번호 보냈습니다.");
			findPwLabel.setForeground(new Color(0, 200, 0));
		} else if(id.getText().length() >=1){
			findPwLabel.setText("회원정보가 일치하지 않습니다.");
			findPwLabel.setForeground(new Color(230, 0, 0));
		}
		
		//찾기 버튼 클릭 후 textfield 초기화
		name.setText("");
		email.setText("");
		id.setText("");
		
	}
	
	
}