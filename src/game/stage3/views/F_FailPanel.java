package game.stage3.views;

import java.awt.Dialog;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.C_GameStage;

public class F_FailPanel extends JPanel{
	private JFrame mf;
	private JPanel panel;
	
	public F_FailPanel(JFrame mf) {
		this.mf = mf;
		panel = this;
		this.setLayout(null);
		
		JLabel fail = new JLabel(new ImageIcon(new ImageIcon("images/stage3/stage3_fail.gif").getImage().getScaledInstance(1280, 720, 0)));
		fail.setBounds(0, 0, 1280, 720);
		
		Dialog popfail = new Dialog(mf, "�й�");
		popfail.setLayout(null);
		popfail.setSize(500, 250);
		popfail.setLocationRelativeTo(null);
		
		JLabel failmsg = new JLabel("�����Ʈ���� �й��Ͽ����ϴ�.");
		failmsg.setBounds(140, 50, 300, 100);
		failmsg.setFont(new Font("DungGenMo", 0, 30));
		
		JButton retry = new JButton("�絵���Ͻðڽ��ϱ�");
		retry.setBounds(90, 150, 150, 50);
		retry.setFont(new Font("DungGeunMo", 0, 20));
		
		JButton tomain = new JButton("������������ ���ư��ϴ�.");
		tomain.setBounds(280, 150, 150, 50);
		tomain.setFont(new Font("DungGeunMo", 0, 20));
		
		popfail.add(failmsg);
		popfail.add(retry);
		popfail.add(tomain);
		
		this.add(fail);
		
		fail.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				popfail.setVisible(true);
			}
		});
		
		retry.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				F_ChangePanel cp = new F_ChangePanel(mf, panel);
				F_Stage3Panel sp = new F_Stage3Panel(mf);
				cp.replacePanel(sp);
				popfail.dispose();
			}
			
		});
		
		tomain.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				F_ChangePanel cp = new F_ChangePanel(mf, panel);
				C_GameStage gs = new C_GameStage(mf);
				cp.replacePanel(gs);
				popfail.dispose();
			}
		});
		
		
	}
	
}
