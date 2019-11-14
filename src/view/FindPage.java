package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FindPage extends JPanel {
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
	
	public FindPage(JFrame mf) {
		JLabel findBackground = new JLabel(new ImageIcon(new ImageIcon("images/main/loginpage2.gif")
				.getImage().getScaledInstance(1300, 770, 0)));
		findBackground.setBounds(0, 0, 1300, 770);
		
		this.mf = mf;
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
		
		findpw = new JButton("비밀번호 찾기");
		findpw.setBounds(820, 440, 180, 130);
		findpw.setFont(new Font("DungGeunMo", Font.BOLD, 20));
		panel.add(findpw);
		
		
		
		backPage = new JButton("돌아가기");
		backPage.setBounds(1100, 620, 140, 70);
		backPage.setFont(new Font("DungGeunMo", Font.BOLD, 25));
		panel.add(backPage);
		
	
		backPage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("돌아가기");
				ChangePanel cp = new ChangePanel(mf, panel);
				//t1.setDaemon(true);
				LoginPanel fp = new LoginPanel(mf);
				
				cp.replacePanel(fp);
			}
		});
		
		
		
		this.setBounds(0,0,1300,770);
		
		this.add(findBackground);
	}
}
