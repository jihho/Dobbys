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
		
		JLabel namelb = new JLabel("�̸�");
		JLabel idlb = new JLabel("���̵�");
		JLabel pwlb = new JLabel("��й�ȣ");
		JLabel pwchecklb = new JLabel("��й�ȣ Ȯ��");
		JLabel emaillb = new JLabel("�̸���");
		JLabel certilb = new JLabel("������ȣ");
		JLabel test1 = new JLabel("��й�ȣ�� Ʋ���ϴ�.");

		
		JTextField namefield = new JTextField();
		JTextField idfield = new JTextField();
		JPasswordField pwfield = new JPasswordField();
		JPasswordField pwcheckfield = new JPasswordField();
		JTextField emailfield = new JTextField();
		JTextField certifield = new JTextField();
		
		JButton idbutton = new JButton("�ߺ�Ȯ��");
		JButton joinbutton = new JButton("ȸ������");
		JButton jeonsongbutton = new JButton("������ȣ ����");
		JButton checkbutton = new JButton("������ȣ Ȯ��");
		JButton cancelbutton = new JButton("���");
		
		
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
					JOptionPane.showMessageDialog(null, "���̵� �Է��� �ֽʽÿ�.");
				}
			}
		});
		
		jeonsongbutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(emailfield.getText());
				if(emailfield.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "�̸����� �Է��� �ֽʽÿ�.");
				}else {
					JOptionPane.showMessageDialog(null, emailfield.getText()+"�� ������ȣ�� �����Ͽ����ϴ�.");
					test1.setText("��й�ȣ�� �½��ϴ�!");
					test1.setForeground(Color.blue);
				}
			}
		});
		
		checkbutton.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(certifield.getText());
				if(certifield.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "������ȣ�� �Է��� �ּ���.");
				}else if(certifield.getText().equals("1234")) {
					JOptionPane.showMessageDialog(null, "������ �����ϼ̽��ϴ�.");
					ischeck = true;
				}else if(!certifield.getText().equals("1234")) {
					JOptionPane.showMessageDialog(null, "������ȣ�� Ʋ�Ƚ��ϴ�.");
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
