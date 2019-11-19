package game.stage3.views;

import java.awt.Color;
import java.awt.Font;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class F_RoundPanel extends JPanel{
	private JFrame mf;
	private JPanel panel;
	
	private JLabel skill;	//스킬 이펙트 용 라벨
	private JLabel sksmash;
	private JLabel skdf;
	private JLabel skct;
	private JLabel vmskill;	//볼드모트 스킬 이펙트 용 라벨
	private JLabel vmsksmash;
	private JLabel vmskdf;
	private JLabel vmskct;	

	private JTextArea log;

	private JButton atk;
	private JButton df;
	private JButton smash;
	private JButton counter;
	private JLabel[] hp = new JLabel[10];
	private JLabel[] vmhp = new JLabel[10];
	
	public F_RoundPanel(JFrame mf) {
		this.mf = mf;
		panel = this;
		this.setLayout(null);
		this.setBounds(0, 0, 1280, 720);
		JLabel label = new JLabel(new ImageIcon(new ImageIcon("images/stage3/stage03.png").getImage()));
		label.setBounds(0, 0, 1280, 720);

		//해리포터 캐릭터 라벨
		JLabel hr = new JLabel(new ImageIcon(new ImageIcon("images/stage3/harry.png").getImage().getScaledInstance(225, 225, 0)));
		hr.setBounds(191, 277, 225, 225);

		//볼드모트 캐릭터 라벨
		JLabel bm = new JLabel(new ImageIcon(new ImageIcon("images/stage3/boldemote.png").getImage().getScaledInstance(225, 225, 0)));
		bm.setBounds(921, 277, 225, 225);

		//해리포터 체력 바
		JLabel hpbar = new JLabel(new ImageIcon(new ImageIcon("images/stage3/hp.gif").getImage().getScaledInstance(34, 35, 0)));
		hpbar.setBounds(190, 200, 34, 35);

		hp[0] = new JLabel(new ImageIcon(new ImageIcon("images/stage3/hp0.png").getImage().getScaledInstance(23, 70, 0)));
		hp[0].setBounds(230, 180, 23, 70);
		hp[1] = new JLabel(new ImageIcon(new ImageIcon("images/stage3/hpp.png").getImage().getScaledInstance(23, 70, 0)));
		hp[1].setBounds(250, 180, 23, 70);
		hp[2] = new JLabel(new ImageIcon(new ImageIcon("images/stage3/hpp.png").getImage().getScaledInstance(23, 70, 0)));
		hp[2].setBounds(270, 180, 23, 70);
		hp[3] = new JLabel(new ImageIcon(new ImageIcon("images/stage3/hpp.png").getImage().getScaledInstance(23, 70, 0)));
		hp[3].setBounds(290, 180, 23, 70);
		hp[4] = new JLabel(new ImageIcon(new ImageIcon("images/stage3/hpp.png").getImage().getScaledInstance(23, 70, 0)));
		hp[4].setBounds(310, 180, 23, 70);
		hp[5] = new JLabel(new ImageIcon(new ImageIcon("images/stage3/hpp.png").getImage().getScaledInstance(23, 70, 0)));
		hp[5].setBounds(330, 180, 23, 70);
		hp[6] = new JLabel(new ImageIcon(new ImageIcon("images/stage3/hpp.png").getImage().getScaledInstance(23, 70, 0)));
		hp[6].setBounds(350, 180, 23, 70);
		hp[7] = new JLabel(new ImageIcon(new ImageIcon("images/stage3/hpp.png").getImage().getScaledInstance(23, 70, 0)));
		hp[7].setBounds(370, 180, 23, 70);
		hp[8] = new JLabel(new ImageIcon(new ImageIcon("images/stage3/hpp.png").getImage().getScaledInstance(23, 70, 0)));
		hp[8].setBounds(390, 180, 23, 70);
		hp[9] = new JLabel(new ImageIcon(new ImageIcon("images/stage3/hpp.png").getImage().getScaledInstance(23, 70, 0)));
		hp[9].setBounds(410, 180, 23, 70);

		//볼드모트 체력 바
		JLabel bmhp = new JLabel(new ImageIcon(new ImageIcon("images/stage3/hp.gif").getImage().getScaledInstance(34, 35, 0)));
		bmhp.setBounds(1120, 200, 34, 35);

		vmhp[0] = new JLabel(new ImageIcon(new ImageIcon("images/stage3/hpbm0.png").getImage().getScaledInstance(23, 70, 0)));
		vmhp[0].setBounds(1100, 180, 23, 70);
		vmhp[1] = new JLabel(new ImageIcon(new ImageIcon("images/stage3/hpp.png").getImage().getScaledInstance(23, 70, 0)));
		vmhp[1].setBounds(1080, 180, 23, 70);
		vmhp[2] = new JLabel(new ImageIcon(new ImageIcon("images/stage3/hpp.png").getImage().getScaledInstance(23, 70, 0)));
		vmhp[2].setBounds(1060, 180, 23, 70);
		vmhp[3] = new JLabel(new ImageIcon(new ImageIcon("images/stage3/hpp.png").getImage().getScaledInstance(23, 70, 0)));
		vmhp[3].setBounds(1040, 180, 23, 70);
		vmhp[4] = new JLabel(new ImageIcon(new ImageIcon("images/stage3/hpp.png").getImage().getScaledInstance(23, 70, 0)));
		vmhp[4].setBounds(1020, 180, 23, 70);
		vmhp[5] = new JLabel(new ImageIcon(new ImageIcon("images/stage3/hpp.png").getImage().getScaledInstance(23, 70, 0)));
		vmhp[5].setBounds(1000, 180, 23, 70);
		vmhp[6] = new JLabel(new ImageIcon(new ImageIcon("images/stage3/hpp.png").getImage().getScaledInstance(23, 70, 0)));
		vmhp[6].setBounds(980, 180, 23, 70);
		vmhp[7] = new JLabel(new ImageIcon(new ImageIcon("images/stage3/hpp.png").getImage().getScaledInstance(23, 70, 0)));
		vmhp[7].setBounds(960, 180, 23, 70);
		vmhp[8] = new JLabel(new ImageIcon(new ImageIcon("images/stage3/hpp.png").getImage().getScaledInstance(23, 70, 0)));
		vmhp[8].setBounds(940, 180, 23, 70);
		vmhp[9] = new JLabel(new ImageIcon(new ImageIcon("images/stage3/hpp.png").getImage().getScaledInstance(23, 70, 0)));
		vmhp[9].setBounds(920, 180, 23, 70);

		//공격 버튼
		atk = new JButton(new ImageIcon("images/stage3/atk.png"));
		atk.setBounds(40, 530, 186, 81);

		//디펜스 버튼
		df = new JButton(new ImageIcon("images/stage3/df.png"));
		df.setBounds(270, 530, 186, 81);

		//스매쉬 버튼
		smash = new JButton(new ImageIcon("images/stage3/smash.png"));
		smash.setBounds(40, 620, 186, 81);

		//카운터 버튼
		counter = new JButton(new ImageIcon("images/stage3/counter.png"));
		counter.setBounds(270, 620, 186, 81);

		//로그 텍스트에어리어
		log = new JTextArea();
		log.setBounds(610, 520, 620, 180);
		log.setEditable(false);
		log.setFont(new Font("DungGeunMo", Font.PLAIN, 37));
		log.setBackground(new Color(0, 60, 30));
		log.setOpaque(false);
		log.selectAll();
		log.append(null);

		JButton success = new JButton();
		success.setText("성공");
		success.setBounds(1250, 530, 100, 30);
		success.setContentAreaFilled(false);
		success.setFocusPainted(false);
		success.setOpaque(false);
		
		JButton fail = new JButton();
		fail.setText("실패");
		fail.setBounds(1250, 620, 100, 30);
		fail.setContentAreaFilled(false);
		fail.setFocusPainted(false);
		fail.setOpaque(false);
		
		this.add(hr);
		this.add(bm);
		this.add(success);
		this.add(fail);
		this.add(hpbar);
		panel.add(hp[0]);
		panel.add(hp[1]);
		panel.add(hp[2]);
		panel.add(hp[3]);
		panel.add(hp[4]);
		panel.add(hp[5]);
		panel.add(hp[6]);
		panel.add(hp[7]);
		panel.add(hp[8]);
		panel.add(hp[9]);

		this.add(bmhp);
		panel.add(vmhp[0]);
		panel.add(vmhp[1]);
		panel.add(vmhp[2]);
		panel.add(vmhp[3]);
		panel.add(vmhp[4]);
		panel.add(vmhp[5]);
		panel.add(vmhp[6]);
		panel.add(vmhp[7]);
		panel.add(vmhp[8]);
		panel.add(vmhp[9]);

		panel.add(atk);
		panel.add(df);
		panel.add(smash);
		panel.add(counter);

		this.add(label);
		JLabel round = new JLabel(new ImageIcon(new ImageIcon("images/stage3/round01.png").getImage().getScaledInstance(1280, 720, 0)));
		round.setBounds(0, 0 , 1280, 720);
		this.add(round);
		panel.setComponentZOrder(round, 0);
		Timer ts = new Timer();	//Timer 실행
		TimerTask tsm = new TimerTask() {

			@Override
			public void run() {
				F_ChangePanel cp = new F_ChangePanel(mf, panel);
				F_Stage3Panel sp = new F_Stage3Panel(mf);
				cp.replacePanel(sp);
			}//TimerTask 실행
			
		};
		ts.schedule(tsm, 1400);	
	}
}
