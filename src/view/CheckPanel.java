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

public class CheckPanel extends JPanel{
	private JFrame mf;
	private JPanel panel;
	private int ctn = 0;
	
	public CheckPanel(JFrame mf){
		this.mf = mf;
		this.setLayout(null);

		panel = this;

		
		
		JLabel label = new JLabel(new ImageIcon(new ImageIcon("images/main/loginpage2.gif").getImage().getScaledInstance(1300, 770, 0)));
		label.setBounds(0, 0, 1300, 770);

		JLabel checkimg = new JLabel(new ImageIcon(new ImageIcon("images/main/check.png").getImage().getScaledInstance(300, 100, 0)));
		checkimg.setBounds(380, 100, 600, 100);
		checkimg.setOpaque(false);
		String test1 = "��1�� (����)\r\n" + 
				"�� ����� ���� �ֽ�ȸ��(���� 'Dobbys')�� \n"
				+ "�� ����Ʈ(���� ������Ʈ��)�� ���Ͽ� ���ͳݻ󿡼� \n"
				+ "�����ϴ� ����(���� �����񽺡�)�� �̿��ϴ� �� (���� '��')\n"
				+ "���� �Ǹ��� �ǹ� �� å�� �� ��Ÿ ���ݻ����� �������� �������� �մϴ�.\r\n" + 
				"\r\n" + 
				"��2�� (����� ����)\r\n" + 
				"�� ������� ����ϴ� ����� ���Ǵ� ������ �����ϴ�.\r\n" + 
				"��. 'ȸ��'�̶� ���� �� ����� �����ϰ� ȸ�������� \n"
				+ "���Ͽ� �̿���ID(������ȣ)�� ��й�ȣ�� �߱޹��� �ڷμ�,\n"
				+ " ȸ�簡 �����ϴ� ���񽺸� �̿��� �� �ִ� �̿��ڸ� ���մϴ�\n";
		
		String test2 = "������������ȣ����\n "
				+ "��15����1����1ȣ, ��17����1����1ȣ,\n"
				+ " ��23����1ȣ, ��24����1�� ��1ȣ�� ���� \r\n" + 
				"�Ʒ��� ���� ���������� ����. �̿뿡 ���Ͽ� ������ \n"
				+ "���Ǹ� ����� �մϴ�. \r\n" + 
				"\r\n" + 
				"���񽺴� �̿����� ���� ���� ���̴� �̿����� ����������\n"
				+ " �Ժη� �������� ������, ������ ������ �Ʒ��� \n"
				+ "���� �̿��ϰ� �ֽ��ϴ�. \r\n" + 
				"�̿��ڰ� ������ ��� ������ �Ʒ��� ������ �ʿ��� \n"
				+ "�뵵 �ܷ̿δ� ������ ������ �̿� ������ ����� �ÿ���\n"
				+ " �̸� �˸��� ���Ǹ� ���� ���Դϴ�.\n";
		
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
		
		JButton btn = new JButton("ȸ������");
		btn.setFont(new Font("", Font.BOLD, 16));
		
		scroll1.setBounds(450, 200, 450, 150);
		scroll2.setBounds(450, 400, 450, 150);
		btn.setBounds(620, 600, 130, 30);
		box1.setBounds(910, 315, 50, 50);
		box2.setBounds(910, 515, 50, 50);
		box1.setOpaque(false);
		box2.setOpaque(false);
		
		box1.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(box1.isSelected()) {
					ctn++;
					System.out.println("box1 ����");
					System.out.println(ctn);
				}else {
					ctn--;
					System.out.println("box1 ����");
					System.out.println(ctn);
				}
				
			}
		});
		
		box2.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(box2.isSelected()) {
					ctn++;
					System.out.println("box2 ����");
					System.out.println(ctn);
				}else {
					ctn--;
					System.out.println("box2 ����");
					System.out.println(ctn);
				}
			}
		});
		System.out.println(ctn);
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(ctn != 2) {
					JOptionPane.showMessageDialog(null, "��� ����� �������ֽñ� �ٶ��ϴ�.");
				}
				if(ctn == 2) {
					ChangePanel cp = new ChangePanel(mf, panel);
					JoinPanel jp = new JoinPanel(mf);
					cp.replacePanel(jp);
				}
			}
		});
		//		start.addMouseListener(new MouseAdapter() {
		//			@Override
		//			public void mouseClicked(MouseEvent e) {
		//				ChangePanel cp = new ChangePanel(mf, panel);
		//				//t1.setDaemon(true);
		//				GamePanel gp = new GamePanel(mf);
		//				Timer timer = new Timer(mf,gp);
		//				Thread t1 = timer;
		//				t1.start();
		//				
		//				
		//				
		//				cp.replacePanel(gp);
		//			}
		//			
		//		});
		this.add(label);
		this.add(scroll1);
		this.add(scroll2);
		this.add(btn);
		this.add(box1);
		this.add(box2);
		this.add(checkimg);
		this.setComponentZOrder(label, 6);


	}
}
