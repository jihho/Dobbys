package view;

import java.awt.Dialog;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class B_CheckPanel extends JPanel{
	private JFrame mf;
	private JPanel panel;
	private int ctn = 0;
	
	public B_CheckPanel(JFrame mf){
		this.mf = mf;
		this.setLayout(null);

		panel = this;

		
		
		JLabel label = new JLabel(new ImageIcon(new ImageIcon("images/main/loginpage2.gif").getImage().getScaledInstance(1300, 770, 0)));
		label.setBounds(0, 0, 1300, 770);

		JLabel checkimg = new JLabel(new ImageIcon(new ImageIcon("images/main/check.png").getImage().getScaledInstance(300, 100, 0)));
		checkimg.setBounds(380, 100, 600, 100);
		checkimg.setOpaque(false);
		String test1 = "제1조 (목적)\r\n" + 
				"본 약관은 도비스 주식회사(이하 'Dobbys')가 \n"
				+ "고도 사이트(이하 ‘사이트’)를 통하여 인터넷상에서 \n"
				+ "제공하는 서비스(이하 ‘서비스’)를 이용하는 고객 (이하 '고객')\n"
				+ "간의 권리와 의무 및 책임 등 기타 제반사항을 규정함을 목적으로 합니다.\r\n" + 
				"\r\n" + 
				"제2조 (용어의 정의)\r\n" + 
				"이 약관에서 사용하는 용어의 정의는 다음과 같습니다.\r\n" + 
				"가. '회원'이라 함은 이 약관에 동의하고 회원가입을 \n"
				+ "통하여 이용자ID(고유번호)와 비밀번호를 발급받은 자로서,\n"
				+ " 회사가 제공하는 서비스를 이용할 수 있는 이용자를 말합니다\n";

		
		String test2 = "「개인정보보호법」\n "
				+ "제15조제1항제1호, 제17조제1항제1호,\n"
				+ " 제23조제1호, 제24조제1항 제1호에 따라 \r\n" + 
				"아래와 같이 개인정보의 수집. 이용에 관하여 귀하의 \n"
				+ "동의를 얻고자 합니다. \r\n" + 
				"\r\n" + 
				"도비스는 이용자의 사전 동의 없이는 이용자의 개인정보를\n"
				+ " 함부로 공개하지 않으며, 수집된 정보는 아래와 \n"
				+ "같이 이용하고 있습니다. \r\n" + 
				"이용자가 제공한 모든 정보는 아래의 목적에 필요한 \n"
				+ "용도 이외로는 사용되지 않으며 이용 목적이 변경될 시에는\n"
				+ " 이를 알리고 동의를 구할 것입니다.\n";

		
		JTextArea textArea1 = new JTextArea(test1);
		JTextArea textArea2 = new JTextArea(test2);
		
		textArea1.setFont(new Font("DungGeunMo", Font.BOLD, 15));
		JScrollPane scroll1 = new JScrollPane(textArea1, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		textArea2.setFont(new Font("DungGeunMo", Font.BOLD, 15));
		JScrollPane scroll2 = new JScrollPane(textArea2, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		JCheckBox box1 = new JCheckBox();
		JCheckBox box2 = new JCheckBox();
		
		JButton btn = new JButton("동의 완료");
		btn.setFont(new Font("", Font.BOLD, 16));
		
		JButton cancelbutton = new JButton("취소");
		cancelbutton.setFont(new Font("", Font.BOLD, 16));
		
		scroll1.setBounds(450, 200, 450, 150);
		scroll2.setBounds(450, 400, 450, 150);
		btn.setBounds(770, 600, 130, 30);
		box1.setBounds(910, 315, 50, 50);
		box2.setBounds(910, 515, 50, 50);
		cancelbutton.setBounds(450, 600, 100, 30);
		
		box1.setOpaque(false);
		box2.setOpaque(false);
		
		box1.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(box1.isSelected()) {
					ctn++;
					System.out.println("box1 선택");
					System.out.println(ctn);
				}else {
					ctn--;
					System.out.println("box1 해제");
					System.out.println(ctn);
				}
				
			}
		});
		
		box2.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(box2.isSelected()) {
					ctn++;
					System.out.println("box2 선택");
					System.out.println(ctn);
				}else {
					ctn--;
					System.out.println("box2 해제");
					System.out.println(ctn);
				}
			}
		});
		System.out.println(ctn);
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if(ctn != 2) {
					JOptionPane.showMessageDialog(null, "모든 약관에 동의해주시길 바랍니다.");
				}
				if(ctn == 2) {
					ChangePanel cp = new ChangePanel(mf, panel);
					B_JoinPanel jp = new B_JoinPanel(mf);
					cp.replacePanel(jp);
				}
			}
		});
		
		cancelbutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ChangePanel cp = new ChangePanel(mf, panel);
				A_LoginPanel lp = new A_LoginPanel(mf);
				cp.replacePanel(lp);
			}
		});

		this.add(label);
		this.add(scroll1);
		this.add(scroll2);
		this.add(btn);
		this.add(box1);
		this.add(box2);
		this.add(checkimg);
		this.add(cancelbutton);
		this.setComponentZOrder(label, 7);


	}
}
