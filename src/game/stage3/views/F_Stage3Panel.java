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
import javax.swing.JTextField;

import game.stage3.controller.F_Stage3Play;
import game.stage3.model.vo.F_Harry;

public class F_Stage3Panel extends JPanel{
	private JFrame mf;
	private JPanel panel;
	//JLabel ef;	//스킬 이펙트 없앨때 사용할 라벨
	private F_Stage3Play sp;

	JLabel skill;	//스킬 이펙트 용 라벨
	JLabel sksmash;
	JLabel skdf;
	JLabel skct;
	F_Harry harry = new F_Harry(100, 10, 20, 30, 10);
	
	JLabel[] hp = new JLabel[10];
	JLabel[] vmhp = new JLabel[10];
	public F_Stage3Panel(){

		this.mf = mf;
		this.setLayout(null);

		panel = this;
		this.setBounds(0, 0, 1280, 720);
		//스테이지 용 라벨
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

		/*
		JLabel hp0 = new JLabel(new ImageIcon(new ImageIcon("images/stage3/hp0.png").getImage().getScaledInstance(23, 70, 0)));
		hp0.setBounds(230, 180, 23, 70);
		JLabel hp1 = new JLabel(new ImageIcon(new ImageIcon("images/stage3/hpp.png").getImage().getScaledInstance(23, 70, 0)));
		hp1.setBounds(250, 180, 23, 70);
		JLabel hp2 = new JLabel(new ImageIcon(new ImageIcon("images/stage3/hpp.png").getImage().getScaledInstance(23, 70, 0)));
		hp2.setBounds(270, 180, 23, 70);
		JLabel hp3 = new JLabel(new ImageIcon(new ImageIcon("images/stage3/hpp.png").getImage().getScaledInstance(23, 70, 0)));
		hp3.setBounds(290, 180, 23, 70);
		JLabel hp4 = new JLabel(new ImageIcon(new ImageIcon("images/stage3/hpp.png").getImage().getScaledInstance(23, 70, 0)));
		hp4.setBounds(310, 180, 23, 70);
		JLabel hp5 = new JLabel(new ImageIcon(new ImageIcon("images/stage3/hpp.png").getImage().getScaledInstance(23, 70, 0)));
		hp5.setBounds(330, 180, 23, 70);
		JLabel hp6 = new JLabel(new ImageIcon(new ImageIcon("images/stage3/hpp.png").getImage().getScaledInstance(23, 70, 0)));
		hp6.setBounds(350, 180, 23, 70);
		JLabel hp7 = new JLabel(new ImageIcon(new ImageIcon("images/stage3/hpp.png").getImage().getScaledInstance(23, 70, 0)));
		hp7.setBounds(370, 180, 23, 70);
		JLabel hp8 = new JLabel(new ImageIcon(new ImageIcon("images/stage3/hpp.png").getImage().getScaledInstance(23, 70, 0)));
		hp8.setBounds(390, 180, 23, 70);
		JLabel hp9 = new JLabel(new ImageIcon(new ImageIcon("images/stage3/hpp.png").getImage().getScaledInstance(23, 70, 0)));
		hp9.setBounds(410, 180, 23, 70);*/


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






		/*JLabel bmhp0 = new JLabel(new ImageIcon(new ImageIcon("images/stage3/hpbm0.png").getImage().getScaledInstance(23, 70, 0)));
		bmhp0.setBounds(1100, 180, 23, 70);
		JLabel bmhp1 = new JLabel(new ImageIcon(new ImageIcon("images/stage3/hpp.png").getImage().getScaledInstance(23, 70, 0)));
		bmhp1.setBounds(1080, 180, 23, 70);
		JLabel bmhp2 = new JLabel(new ImageIcon(new ImageIcon("images/stage3/hpp.png").getImage().getScaledInstance(23, 70, 0)));
		bmhp2.setBounds(1060, 180, 23, 70);
		JLabel bmhp3 = new JLabel(new ImageIcon(new ImageIcon("images/stage3/hpp.png").getImage().getScaledInstance(23, 70, 0)));
		bmhp3.setBounds(1040, 180, 23, 70);
		JLabel bmhp4 = new JLabel(new ImageIcon(new ImageIcon("images/stage3/hpp.png").getImage().getScaledInstance(23, 70, 0)));
		bmhp4.setBounds(1020, 180, 23, 70);
		JLabel bmhp5 = new JLabel(new ImageIcon(new ImageIcon("images/stage3/hpp.png").getImage().getScaledInstance(23, 70, 0)));
		bmhp5.setBounds(1000, 180, 23, 70);
		JLabel bmhp6 = new JLabel(new ImageIcon(new ImageIcon("images/stage3/hpp.png").getImage().getScaledInstance(23, 70, 0)));
		bmhp6.setBounds(980, 180, 23, 70);
		JLabel bmhp7 = new JLabel(new ImageIcon(new ImageIcon("images/stage3/hpp.png").getImage().getScaledInstance(23, 70, 0)));
		bmhp7.setBounds(960, 180, 23, 70);
		JLabel bmhp8 = new JLabel(new ImageIcon(new ImageIcon("images/stage3/hpp.png").getImage().getScaledInstance(23, 70, 0)));
		bmhp8.setBounds(940, 180, 23, 70);
		JLabel bmhp9 = new JLabel(new ImageIcon(new ImageIcon("images/stage3/hpp.png").getImage().getScaledInstance(23, 70, 0)));
		bmhp9.setBounds(920, 180, 23, 70);*/


		//공격 버튼
		JButton atk = new JButton(new ImageIcon("images/stage3/atk.png"));
		atk.setBounds(40, 530, 186, 81);

		//디펜스 버튼
		JButton df = new JButton(new ImageIcon("images/stage3/df.png"));
		df.setBounds(270, 530, 186, 81);

		//스매쉬 버튼
		JButton smash = new JButton(new ImageIcon("images/stage3/smash.png"));
		smash.setBounds(40, 620, 186, 81);

		//카운터 버튼
		JButton counter = new JButton(new ImageIcon("images/stage3/counter.png"));
		counter.setBounds(270, 620, 186, 81);

		//로그 텍스트 필드
		JTextField log = new JTextField();
		log.setBounds(610, 520, 620, 180);

		//이펙트 가림용 라벨
		//ef = new JLabel();

		//스킬 이펙트 라벨
		skill  = new JLabel(new ImageIcon(new ImageIcon("images/stage3/atk2.gif").getImage().getScaledInstance(650, 200, 0)));
		sksmash  = new JLabel(new ImageIcon(new ImageIcon("images/stage3/smash1.gif").getImage().getScaledInstance(650, 200, 0)));
		skdf  = new JLabel(new ImageIcon(new ImageIcon("images/stage3/df22.gif").getImage().getScaledInstance(150, 200, 0)));
		skct  = new JLabel(new ImageIcon(new ImageIcon("images/stage3/ct2.gif").getImage().getScaledInstance(250, 200, 0)));

		//스킬이 가려질 수 있게 ef의 사이즈를 스킬보다 살짝 크게 
		//ef.setBounds(400, 277, 700, 200);
		skill.setBounds(440, 277, 650, 200);
		sksmash.setBounds(440, 277, 650, 200);
		skdf.setBounds(440, 277, 150, 250);
		skct.setBounds(400, 277, 250, 200);

		/*atk.setBorderPainted(false);
				atk.setContentAreaFilled(false);
				atk.setFocusPainted(false);
				atk.setOpaque(false);

				df.setBorderPainted(false);
				df.setContentAreaFilled(false);
				df.setFocusPainted(false);
				df.setOpaque(false);

				smash.setBorderPainted(false);
				smash.setContentAreaFilled(false);
				smash.setFocusPainted(false);
				smash.setOpaque(false);

				counter.setBorderPainted(false);
				counter.setContentAreaFilled(false);
				counter.setFocusPainted(false);
				counter.setOpaque(false);*/

		//항상 필요한 것들 추가

		this.add(hr);
		this.add(bm);

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

		this.add(atk);
		this.add(df);
		this.add(smash);
		this.add(counter);

		this.add(log);
		//라벨을 가장 마지막에 추가함으로서 자동적으로 우선순위를 최 하위로 변경
		//setComponentZOrder를 여기서 사용할 필요 없게 됨
		this.add(label);

		//배경 라벨의 우선 순위를 가장 아래로 내림으로서 나머지 라벨 등장 
		//this.setComponentZOrder(label,29);

		//마우스 이펙트 사용
		atk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {	//클릭은 동일한 위치라 인식이 안되는 경우가 종종 생기므로 Released 사용
				if(e.getSource() == atk){	//getSource를 atk버튼을 받게 함
					//sp = new F_Stage3Play(mf);

					//panel.remove(ef);	//ef 라벨 제거 
					panel.add(skill);	//skill 라벨 추가
					panel.revalidate();	//updateUI보다 revaildate + repaint가 안정적
					panel.repaint();
					//skill.updateUI();	//라벨 갱신해서 오류 삭제
					panel.setComponentZOrder(skill, 0);	//skill라벨의 우선순위를 최우선으로 변경해서 화면 위에 출력
					//panel.setComponentZOrder(label, 30);	//skill라벨이 보여지기 위해 배경 라벨의 우선순위 조정
					Timer ts = new Timer();	//Timer 실행
					TimerTask tsm = new TimerTask() {	//TimerTask 실행

						//TimerTask로 실행할 작업 내용 Override
						@Override
						public void run() {
							panel.remove(skill);	//skill 라벨 제거 
							harry.setHplife(harry.getHplife()-1);
							for(int i = 9; i>=0; i--) {
								if(i >= harry.getHplife()) {
									panel.remove(vmhp[i]);
								}
							}

							panel.revalidate();
							panel.repaint();
							//panel.add(ef);			//ef 라벨 추가
							//ef.updateUI();			//라벨 갱신 
							//panel.setComponentZOrder(label, 29);	//배경 라벨 우선순위 조정
						}

					};
					ts.schedule(tsm, 1400);	//Override에 있는 작업 시작 시간 설정 
				}
			}
		});

		smash.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {	//클릭은 동일한 위치라 인식이 안되는 경우가 종종 생기므로 Released 사용
				if(e.getSource() == smash){	//getSource를 atk버튼을 받게 함
					//panel.remove(ef);	//ef 라벨 제거 
					panel.add(sksmash);	//skill 라벨 추가
					panel.revalidate();
					panel.repaint();
					panel.setComponentZOrder(sksmash, 0);
					//sksmash.updateUI();	//라벨 갱신해서 오류 삭제
					//panel.setComponentZOrder(label, 30);	//skill라벨이 보여지기 위해 배경 라벨의 우선순위 조정

					Timer ts = new Timer();	//Timer 실행
					TimerTask tsm = new TimerTask() {	//TimerTask 실행

						//TimerTask로 실행할 작업 내용 Override
						@Override
						public void run() {
							panel.remove(sksmash);	//skill 라벨 제거 
							harry.setHplife(harry.getHplife()-2);
							for(int i = 9; i>=0; i--) {
								if(i >= harry.getHplife()) {
									panel.remove(vmhp[i]);
								}
							}
							panel.revalidate();
							panel.repaint();
							//panel.add(ef);			//ef 라벨 추가
							//ef.updateUI();			//라벨 갱신 
							//panel.setComponentZOrder(label, 29);	//배경 라벨 우선순위 조정
						}

					};
					ts.schedule(tsm, 1400);	//Override에 있는 작업 시작 시간 설정 
				}
			}
		});

		df.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {	//클릭은 동일한 위치라 인식이 안되는 경우가 종종 생기므로 Released 사용
				if(e.getSource() == df){	//getSource를 atk버튼을 받게 함
					//panel.remove(ef);	//ef 라벨 제거 
					panel.add(skdf);	//skill 라벨 추가
					panel.revalidate();
					panel.repaint();
					panel.setComponentZOrder(skdf, 0);
					//skdf.updateUI();	//라벨 갱신해서 오류 삭제
					//panel.setComponentZOrder(label, 30);	//skill라벨이 보여지기 위해 배경 라벨의 우선순위 조정

					Timer ts = new Timer();	//Timer 실행
					TimerTask tsm = new TimerTask() {	//TimerTask 실행

						//TimerTask로 실행할 작업 내용 Override
						@Override
						public void run() {
							panel.remove(skdf);	//skill 라벨 제거 
							panel.revalidate();
							panel.repaint();
							//panel.add(ef);			//ef 라벨 추가
							//ef.updateUI();			//라벨 갱신 
							//panel.setComponentZOrder(label, 29);	//배경 라벨 우선순위 조정
						}

					};
					ts.schedule(tsm, 1400);	//Override에 있는 작업 시작 시간 설정 
				}
			}
		});

		counter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {	//클릭은 동일한 위치라 인식이 안되는 경우가 종종 생기므로 Released 사용
				if(e.getSource() == counter){	//getSource를 atk버튼을 받게 함
					//panel.remove(ef);	//ef 라벨 제거 
					panel.add(skct);	//skill 라벨 추가
					panel.revalidate();
					panel.repaint();
					panel.setComponentZOrder(skct, 0);
					//skct.updateUI();	//라벨 갱신해서 오류 삭제
					//panel.setComponentZOrder(label, 30);	//skill라벨이 보여지기 위해 배경 라벨의 우선순위 조정

					Timer ts = new Timer();	//Timer 실행
					TimerTask tsm = new TimerTask() {	//TimerTask 실행

						//TimerTask로 실행할 작업 내용 Override
						@Override
						public void run() {
							panel.remove(skct);	//skill 라벨 제거 
							harry.setHplife(harry.getHplife()-3);
							for(int i = 9; i>=0; i--) {
								if(i >= harry.getHplife()) {
									panel.remove(vmhp[i]);
								}
							}
							panel.revalidate();
							panel.repaint();
							//panel.add(ef);			//ef 라벨 추가
							//ef.updateUI();			//라벨 갱신 
							//panel.setComponentZOrder(label, 29);	//배경 라벨 우선순위 조정
						}

					};
					ts.schedule(tsm, 1400);	//Override에 있는 작업 시작 시간 설정 
				}
			}
		});
	}
}
