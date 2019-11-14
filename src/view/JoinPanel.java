package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.EventHandler;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class JoinPanel extends JPanel{
	private JFrame mf;
	private JPanel panel;
	private boolean ischeck = false;
	
	public JoinPanel(JFrame mf){
		this.mf = mf;
		this.setLayout(null);
		
		panel = this;
		
		JLabel label = new JLabel(new ImageIcon(new ImageIcon("images/main/loginpage2.gif").getImage().getScaledInstance(1300, 770, 0)));
		label.setBounds(0, 0, 1300, 770);
		
		JLabel namelb = new JLabel("이름");
		JLabel idlb = new JLabel("아이디");
		JLabel pwlb = new JLabel("비밀번호");
		JLabel pwchecklb = new JLabel("비밀번호 확인");
		JLabel emaillb = new JLabel("이메일");
		JLabel certilb = new JLabel("인증번호");
		JLabel test1 = new JLabel("비밀번호가 틀립니다.");

		
		JTextField namefield = new JTextField();
		JTextField idfield = new JTextField();
		JPasswordField pwfield = new JPasswordField();
		JPasswordField pwcheckfield = new JPasswordField();
		JTextField emailfield = new JTextField();
		JTextField certifield = new JTextField();
		
		JButton idbutton = new JButton("중복확인");
		JButton joinbutton = new JButton("회원가입");
		JButton jeonsongbutton = new JButton("인증번호 전송");
		JButton checkbutton = new JButton("인증번호 확인");
		JButton cancelbutton = new JButton("취소");
		
		
		namelb.setBounds(450, 300, 100, 70);
		idlb.setBounds(450, 345, 100, 70);
		pwlb.setBounds(450, 390, 100, 70);
		pwchecklb.setBounds(450, 435, 150, 70);
		emaillb.setBounds(450, 480, 100, 70);
		certilb.setBounds(450, 525, 100, 70);
		test1.setBounds(800,440,200,70);
		
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
		
		namelb.setFont(new Font("", Font.BOLD, 20));
		namelb.setForeground(Color.white);
	
		
		idlb.setFont(new Font("", Font.BOLD, 20));
		idlb.setForeground(Color.white);
	
		
		pwlb.setFont(new Font("", Font.BOLD, 20));
		pwlb.setForeground(Color.white);
	
		
		pwchecklb.setFont(new Font("", Font.BOLD, 20));
		pwchecklb.setForeground(Color.white);
	
		
		emaillb.setFont(new Font("", Font.BOLD, 20));
		emaillb.setForeground(Color.white);
	
		
		certilb.setFont(new Font("", Font.BOLD, 20));
		certilb.setForeground(Color.white);
		
		test1.setFont(new Font("",Font.BOLD, 18));
		test1.setForeground(Color.red);
		
		idbutton.setFont(new Font("",Font.BOLD,16));
		joinbutton.setFont(new Font("", Font.BOLD, 16));
		jeonsongbutton.setFont(new Font("", Font.BOLD, 16));
		checkbutton.setFont(new Font("", Font.BOLD, 16));
		cancelbutton.setFont(new Font("", Font.BOLD, 16));
		
		
		cancelbutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ChangePanel cp = new ChangePanel(mf, panel);
				CheckPanel chp = new CheckPanel(mf);
				cp.replacePanel(chp);
			}
		
		});
		
		joinbutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				ChangePanel cp = new ChangePanel(mf, panel);
				IntroVideoPanel ivp = new IntroVideoPanel(mf);
				cp.replacePanel(ivp);
			}
		
		});

		idbutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(idfield.getText());
				if(idfield.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "아이디를 입력해 주십시오.");
				}
			}
		});
		
		jeonsongbutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(emailfield.getText());
				if(emailfield.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "이메일을 입력해 주십시오.");
				}else {
					JOptionPane.showMessageDialog(null, emailfield.getText()+"로 인증번호를 전송하였습니다.");
					test1.setText("비밀번호가 맞습니다!");
					test1.setForeground(Color.blue);
				}
			}
		});
		
		checkbutton.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(certifield.getText());
				if(certifield.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "인증번호를 입력해 주세요.");
				}else if(certifield.getText().equals("1234")) {
					JOptionPane.showMessageDialog(null, "인증에 성공하셨습니다.");
					ischeck = true;
				}else if(!certifield.getText().equals("1234")) {
					JOptionPane.showMessageDialog(null, "인증번호가 틀렸습니다.");
				}
			}
		});
		
	
		
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
		this.setComponentZOrder(label, 18);
		
		
	}
}
