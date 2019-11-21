package game.stage3.views;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import view.A_Music;

public class F_Stage3rule extends JPanel{
	private JFrame mf;
	private JPanel panel;

	JButton atk;
	JButton df;
	JButton smash;
	JButton counter;
	private JLabel[] hp = new JLabel[10];
	private JLabel[] vmhp = new JLabel[10];
	public F_Stage3rule(JFrame mf) {
		this.mf = mf;
		this.setLayout(null);
		panel = this;

		this.setBounds(0, 0, 1280, 720);

		JLabel label = new JLabel(new ImageIcon(new ImageIcon("images/stage3/stage03.png").getImage()));
		label.setBounds(0, 0, 1280, 720);

		JLabel rule = new JLabel(new ImageIcon(new ImageIcon("images/stage3/rule_bg.png").getImage()));
		rule.setBounds(0, 0, 1280, 720);
		//해리포터 캐릭터 라벨
		JLabel hr = new JLabel(new ImageIcon(new ImageIcon("images/stage3/harrymove.gif").getImage().getScaledInstance(225, 225, 0)));
		hr.setBounds(191, 277, 225, 225);

		//볼드모트 캐릭터 라벨
		JLabel bm = new JLabel(new ImageIcon(new ImageIcon("images/stage3/voldmote.gif").getImage().getScaledInstance(225, 225, 0)));
		bm.setBounds(921, 277, 225, 225);
		
		JLabel hrsummon = new JLabel(new ImageIcon(new ImageIcon("images/stage3/hrsummon.gif").getImage().getScaledInstance(225, 225, 0)));
		hrsummon.setBounds(191, 277, 225, 225);

		//볼드모트 캐릭터 라벨
		JLabel vmsummon = new JLabel(new ImageIcon(new ImageIcon("images/stage3/vmsummon.gif").getImage().getScaledInstance(225, 225, 0)));
		vmsummon.setBounds(921, 277, 225, 225);

		//해리포터 체력 두근거리는 하트
		JLabel hpbar = new JLabel(new ImageIcon(new ImageIcon("images/stage3/hp.gif").getImage().getScaledInstance(34, 35, 0)));
		hpbar.setBounds(190, 200, 34, 35);

		//실제 데미지 표시될 체력
		hp[0] = new JLabel(new ImageIcon(new ImageIcon("images/stage3/hp0.png").getImage().getScaledInstance(23, 70, 0)));
		hp[0].setBounds(230, 180, 23, 70);

		for(int i = 1; i<10; i++) {
			hp[i] = new JLabel(new ImageIcon(new ImageIcon("images/stage3/hpp.png").getImage().getScaledInstance(23, 70, 0)));
			hp[i].setBounds(230 + (i * 20), 180, 23, 70);
		}

		//볼드모트 체력 두근거리는 하트
		JLabel bmhp = new JLabel(new ImageIcon(new ImageIcon("images/stage3/hp.gif").getImage().getScaledInstance(34, 35, 0)));
		bmhp.setBounds(1120, 200, 34, 35);

		//실제 데미지 표시될 체력
		vmhp[0] = new JLabel(new ImageIcon(new ImageIcon("images/stage3/hpbm0.png").getImage().getScaledInstance(23, 70, 0)));
		vmhp[0].setBounds(1100, 180, 23, 70);
		for(int i = 1; i < 10; i++) {
			vmhp[i] = new JLabel(new ImageIcon(new ImageIcon("images/stage3/hpp.png").getImage().getScaledInstance(23, 70, 0)));
			vmhp[i].setBounds(1100 - (i * 20), 180, 23, 70);
		}
		panel.add(rule);
		panel.add(label);
		

		rule.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				Timer ts = new Timer();	
				TimerTask tsm = new TimerTask() {

					@Override
					public void run() {
						panel.remove(rule);
						panel.add(hrsummon);
						panel.add(vmsummon);
						panel.setComponentZOrder(hrsummon, 0);
						panel.setComponentZOrder(vmsummon, 0);
						panel.revalidate();
						panel.repaint();
					
					}

				};
				ts.schedule(tsm, 100);
				Timer ts1 = new Timer();	
				TimerTask tsm1 = new TimerTask() {

					@Override
					public void run() {
						panel.add(hpbar);
						panel.add(bmhp);
						panel.setComponentZOrder(hpbar, 0);
						panel.setComponentZOrder(bmhp, 0);
						panel.revalidate();
						panel.repaint();
					}

				};
				ts1.schedule(tsm1, 300);
				Timer ts2 = new Timer();	
				TimerTask tsm2 = new TimerTask() {

					@Override
					public void run() {
						panel.add(hp[0]);
						panel.add(vmhp[0]);
						panel.setComponentZOrder(hp[0], 0);
						panel.setComponentZOrder(vmhp[0], 0);
						panel.revalidate();
						panel.repaint();
					}

				};
				ts2.schedule(tsm2, 500);
				Timer ts3 = new Timer();	
				TimerTask tsm3 = new TimerTask() {

					@Override
					public void run() {
						panel.add(hp[1]);
						panel.add(vmhp[1]);
						panel.setComponentZOrder(hp[1], 0);
						panel.setComponentZOrder(vmhp[1], 0);
						panel.revalidate();
						panel.repaint();
					}

				};
				ts3.schedule(tsm3, 700);
				Timer ts4 = new Timer();	
				TimerTask tsm4 = new TimerTask() {

					@Override
					public void run() {
						panel.add(hp[2]);
						panel.add(vmhp[2]);
						panel.setComponentZOrder(hp[2], 0);
						panel.setComponentZOrder(vmhp[2], 0);
						panel.revalidate();
						panel.repaint();
					}

				};
				ts4.schedule(tsm4, 900);
				Timer ts5 = new Timer();	
				TimerTask tsm5 = new TimerTask() {

					@Override
					public void run() {
						panel.add(hp[3]);
						panel.add(vmhp[3]);
						panel.setComponentZOrder(hp[3], 0);
						panel.setComponentZOrder(vmhp[3], 0);
						panel.revalidate();
						panel.repaint();
					}

				};
				ts5.schedule(tsm5, 1100);
				Timer ts6 = new Timer();	
				TimerTask tsm6 = new TimerTask() {

					@Override
					public void run() {
						panel.add(hp[4]);
						panel.add(vmhp[4]);
						panel.setComponentZOrder(hp[4], 0);
						panel.setComponentZOrder(vmhp[4], 0);
						panel.revalidate();
						panel.repaint();
					}

				};
				ts6.schedule(tsm6, 1300);
				Timer ts7 = new Timer();	
				TimerTask tsm7 = new TimerTask() {

					@Override
					public void run() {
						panel.add(hp[5]);
						panel.add(vmhp[5]);
						panel.setComponentZOrder(hp[5], 0);
						panel.setComponentZOrder(vmhp[5], 0);
						panel.revalidate();
						panel.repaint();
					}

				};
				ts7.schedule(tsm7, 1500);
				Timer ts8 = new Timer();	
				TimerTask tsm8 = new TimerTask() {

					@Override
					public void run() {
						panel.add(hp[6]);
						panel.add(vmhp[6]);
						panel.setComponentZOrder(hp[6], 0);
						panel.setComponentZOrder(vmhp[6], 0);
						panel.revalidate();
						panel.repaint();
					}

				};
				ts8.schedule(tsm8, 1700);
				Timer ts9 = new Timer();	
				TimerTask tsm9 = new TimerTask() {

					@Override
					public void run() {
						panel.add(hp[7]);
						panel.add(vmhp[7]);
						panel.setComponentZOrder(hp[7], 0);
						panel.setComponentZOrder(vmhp[7], 0);
						panel.revalidate();
						panel.repaint();
					}

				};
				ts9.schedule(tsm9, 1900);
				Timer ts10 = new Timer();	
				TimerTask tsm10 = new TimerTask() {

					@Override
					public void run() {
						panel.add(hp[8]);
						panel.add(vmhp[8]);
						panel.setComponentZOrder(hp[8], 0);
						panel.setComponentZOrder(vmhp[8], 0);
						panel.revalidate();
						panel.repaint();
					}

				};
				ts10.schedule(tsm10, 2100);
				Timer ts11 = new Timer();	
				TimerTask tsm11 = new TimerTask() {

					@Override
					public void run() {
						panel.add(hp[9]);
						panel.add(vmhp[9]);
						panel.setComponentZOrder(hp[9], 0);
						panel.setComponentZOrder(vmhp[9], 0);
						panel.revalidate();
						panel.repaint();
					}

				};
				ts11.schedule(tsm11, 2300);
				Timer ts12 = new Timer();	
				TimerTask tsm12 = new TimerTask() {

					@Override
					public void run() {
						panel.remove(hrsummon);
						panel.remove(vmsummon);
						panel.add(hr);
						panel.add(bm);
						panel.setComponentZOrder(hr, 0);
						panel.setComponentZOrder(bm, 0);
						panel.revalidate();
						panel.repaint();
					}

				};
				ts12.schedule(tsm12, 2500);
				
				Timer ts13 = new Timer();	
				TimerTask tsm13 = new TimerTask() {

					@Override
					public void run() {
						F_ChangePanel cp = new F_ChangePanel(mf, panel);
						F_Stage3Panel sp = new F_Stage3Panel(mf);
						cp.replacePanel(sp);
					}

				};
				ts13.schedule(tsm13, 2600);
				
			}

		});
	}

}
