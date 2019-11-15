package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class A_FindPage extends JPanel {
	private JFrame mf;
	private JPanel panel;
	private JLabel label;
	private JTextField text;
	private JTextField name;
	private JTextField id;
	private JTextField email;
	private JButton findid;
	private JButton findpw;
	private JButton backPage;
	
	public A_FindPage(JFrame mf) {
		JLabel findBackground = new JLabel(new ImageIcon(new ImageIcon("images/main/loginpage2.gif")
				.getImage().getScaledInstance(1300, 770, 0)));
		findBackground.setBounds(0, 0, 1300, 770);
		
		this.mf = mf;
		this.setLayout(null);
		panel = this;
		
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
		
		email = new JTextField();
		email.setBounds(300,260,500,60);
		email.setFont(new Font("DungGeunMo", Font.PLAIN, 30));
		panel.add(email);
		email.setColumns(15);
		
		findid = new JButton("아이디 찾기");
		findid.setBounds(820, 190, 180, 130);
		findid.setFont(new Font("DungGeunMo", Font.BOLD, 20));
		panel.add(findid);
		
		
		
		
		
		label = new JLabel("비밀번호 찾기");
		label.setBounds(300, 370, 500, 50);
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("DungGeunMo", Font.BOLD, 50));
		panel.add(label);
		
		id = new JTextField();
		id.setBounds(300,440,500,60);
		id.setFont(new Font("DungGeunMo", Font.PLAIN, 30));
		panel.add(id);
		id.setColumns(15);
		
		email = new JTextField();
		email.setBounds(300,510,500,60);
		email.setFont(new Font("DungGeunMo", Font.PLAIN, 30));
		panel.add(email);
		email.setColumns(15);
		
		findpw = new JButton("임시 비밀번호 전송");
		findpw.setBounds(820, 440, 180, 130);
		findpw.setFont(new Font("DungGeunMo", Font.BOLD, 20));
		panel.add(findpw);
		
		
		
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
		backBtn1.setBorderPainted(false);
		backBtn1.setPreferredSize(new Dimension(140, 70));
		
//		backBtn1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		panel.add(backBtn1);
		
	
		backBtn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
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
	
	
}