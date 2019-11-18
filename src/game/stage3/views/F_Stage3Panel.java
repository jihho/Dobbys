package game.stage3.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import controller.C_GameStage;
import game.stage3.controller.F_Stage3Play;
import game.stage3.model.vo.F_General;
import game.stage3.model.vo.F_Harry;
import game.stage3.model.vo.F_Voldmort;
import game.stage3.views.F_SuccessPanel;
import game.stage3.views.F_FailPanel;

public class F_Stage3Panel extends JPanel{
	private JFrame mf;
	private JPanel panel;
	//JLabel ef;	//스킬 이펙트 없앨때 사용할 라벨
	
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


	private F_General harry = new F_Harry(100, 10, 20, 30, 10);	//체력, 공격, 스매쉬, 카운터
	private F_General voldmort = new F_Voldmort(100, 10, 20, 30, 10);

	private JLabel[] hp = new JLabel[10];
	private JLabel[] vmhp = new JLabel[10];

	int harryChoice = 0;

	public F_Stage3Panel(JFrame mf){
		this.mf = mf;
		this.setLayout(null);
		panel = this;
		this.setBounds(0, 0, 1280, 720);

		//스테이지 배경 라벨로 올림
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

		//로그 텍스트 필드
		log = new JTextArea();
		log.setBounds(610, 520, 620, 180);
		log.setEditable(false);
		log.setFont(new Font("DungGeunMo", Font.PLAIN, 37));
		log.setBackground(new Color(0, 60, 30));
		log.setOpaque(false);
		log.selectAll();
		log.append(null);
		
		
/*String str = "어렵군, 아주 어려워...\n용기가 충만하고, 총명하며,\n재능을 타고 났어!\n의욕이 하늘을 찌르는 군!\n근데 어디가 좋을까...\n그리핀도르? 래번클로? \n슬리데린? 후플푸프?\n흐음...어디보자...\n";
		
		// JTextArea(대화 상자) 생성  
		ta = new JTextArea("");   	//JTextArea 생성
		ta.setBounds(635, 50, 510, 500); 	    //JTeatArea 크기 및 위치 지정
	    ta.setEditable(false); 				    //실행시 JtextArea edit 금지 (글을 쓸 수 없음) true면 가능
		ta.setFont(new Font("DungGeunMo", Font.PLAIN, 37)); 
		ta.setBackground(new Color(0, 60, 30));
		ta.setForeground(Color.WHITE);			
		ta.setMargin(new Insets(20, 20, 5, 10));
		ta.setOpaque(false);*/
		//이펙트 가림용 라벨
		//ef = new JLabel();

		//스킬 이펙트 라벨
		skill  = new JLabel(new ImageIcon(new ImageIcon("images/stage3/atk2.gif").getImage().getScaledInstance(650, 200, 0)));
		sksmash  = new JLabel(new ImageIcon(new ImageIcon("images/stage3/smash1.gif").getImage().getScaledInstance(650, 200, 0)));
		skdf  = new JLabel(new ImageIcon(new ImageIcon("images/stage3/df22.gif").getImage().getScaledInstance(150, 200, 0)));
		skct  = new JLabel(new ImageIcon(new ImageIcon("images/stage3/ct2.gif").getImage().getScaledInstance(250, 200, 0)));

		//볼드모트 스킬 이펙트 라벨
		vmskill = new JLabel(new ImageIcon(new ImageIcon("images/stage3/atk1.gif").getImage().getScaledInstance(650, 200, 0)));
		vmsksmash = new JLabel(new ImageIcon(new ImageIcon("images/stage3/smash2.gif").getImage().getScaledInstance(650, 200, 0)));
		vmskdf = new JLabel(new ImageIcon(new ImageIcon("images/stage3/df2.gif").getImage().getScaledInstance(150, 200, 0)));
		vmskct = new JLabel(new ImageIcon(new ImageIcon("images/stage3/ct1.gif").getImage().getScaledInstance(250, 200, 0)));

		//스킬이 가려질 수 있게 ef의 사이즈를 스킬보다 살짝 크게 
		//ef.setBounds(400, 277, 700, 200);
		skill.setBounds(440, 277, 650, 200);
		sksmash.setBounds(440, 277, 650, 200);
		skdf.setBounds(440, 277, 150, 250);
		skct.setBounds(400, 277, 250, 200);

		vmskill.setBounds(440, 277, 650, 200);
		vmsksmash.setBounds(440, 277, 650, 200);
		vmskdf.setBounds(800, 277, 150, 250);
		vmskct.setBounds(400, 277, 250, 200);
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

		panel.add(atk);
		panel.add(df);
		panel.add(smash);
		panel.add(counter);

		this.add(log);
		//라벨을 가장 마지막에 추가함으로서 자동적으로 우선순위를 최 하위로 변경
		//setComponentZOrder를 여기서 사용할 필요 없게 됨


		//배경 라벨의 우선 순위를 가장 아래로 내림으로서 나머지 라벨 등장 
		//this.setComponentZOrder(label,29);

		System.out.println("버튼을 선택해주세요");
		//볼드모트의 선택이 될 랜덤 수
		this.add(label);
		//마우스 이펙트 사용
		atk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {	//클릭은 동일한 위치라 인식이 안되는 경우가 종종 생기므로 Released 사용
				if(e.getSource() == atk){	//getSource를 atk버튼을 받게 함
					int vmchoice = (int)(Math.random()*4);
					if(vmchoice == 0 || vmchoice == 1 || vmchoice == 2) {
						panel.add(skill);
						panel.add(vmskdf);
						panel.setComponentZOrder(skill, 0);
						panel.setComponentZOrder(vmskdf, 0);
						panel.revalidate();
						panel.repaint();
						System.out.println("공격이 무효화 되었습니다.");
						Timer ts = new Timer();	//Timer 실행
						TimerTask tsm = new TimerTask() {	//TimerTask 실행

							//TimerTask로 실행할 작업 내용 Override
							@Override
							public void run() {
								panel.remove(skill);	//skill 라벨 제거 
								panel.remove(vmskdf);
								panel.revalidate();
								panel.repaint();
								//panel.add(ef);			//ef 라벨 추가
								//ef.updateUI();			//라벨 갱신 
								//panel.setComponentZOrder(label, 29);	//배경 라벨 우선순위 조정
							}
						};
						ts.schedule(tsm, 1400);
					}else if(vmchoice == 3) {
						panel.add(skill);
						panel.setComponentZOrder(skill, 0);
						panel.revalidate();
						panel.repaint();

						voldmort.setHp(voldmort.getHp() -10);
						voldmort.setHplife(voldmort.getHplife() -1);
						System.out.println("공격 성공!! 볼드모트의 체력이 10 감소합니다.");
						System.out.println("볼드모트의 체력 : " + voldmort.getHp());
						Timer ts = new Timer();	//Timer 실행
						TimerTask tsm = new TimerTask() {	//TimerTask 실행

							//TimerTask로 실행할 작업 내용 Override
							@Override
							public void run() {
								panel.remove(skill);	//skill 라벨 제거 
								for(int i = 9; i>=0; i--) {
									if(i >= voldmort.getHplife()) {
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
						ts.schedule(tsm, 1400);
					}
					if(voldmort.getHp()<=0) {
						System.out.println("!!!!!볼드모트를 물리쳤습니다.");
						F_ChangePanel cp = new F_ChangePanel(mf, panel);
						F_SuccessPanel sp = new F_SuccessPanel(mf);
						cp.replacePanel(sp);
					}
				}
			}
		});

		smash.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {	//클릭은 동일한 위치라 인식이 안되는 경우가 종종 생기므로 Released 사용
				if(e.getSource() == smash){	//getSource를 atk버튼을 받게 함
					int vmchoice = (int)(Math.random()*4);
					if(vmchoice == 0 || vmchoice == 2) {
						panel.add(sksmash);
						panel.add(vmskdf);
						panel.setComponentZOrder(sksmash, 0);
						panel.setComponentZOrder(vmskdf, 0);
						panel.revalidate();
						panel.repaint();
						System.out.println("공격이 무효화 되었습니다.");
						Timer ts = new Timer();	//Timer 실행
						TimerTask tsm = new TimerTask() {	//TimerTask 실행

							//TimerTask로 실행할 작업 내용 Override
							@Override
							public void run() {
								panel.remove(sksmash);	//skill 라벨 제거 
								panel.remove(vmskdf);
								panel.revalidate();
								panel.repaint();
								//panel.add(ef);			//ef 라벨 추가
								//ef.updateUI();			//라벨 갱신 
								//panel.setComponentZOrder(label, 29);	//배경 라벨 우선순위 조정
							}
						};
						ts.schedule(tsm, 1400);
					}else if(vmchoice == 1) {
						panel.add(sksmash);	//skill 라벨 추가
						panel.revalidate();
						panel.repaint();
						panel.setComponentZOrder(sksmash, 0);
						voldmort.setHp(voldmort.getHp() -20);
						voldmort.setHplife(voldmort.getHplife() -2);
						System.out.println("공격 성공!! 볼드모트의 체력이 20 감소합니다.");
						System.out.println("볼드모트의 체력 : " + voldmort.getHp());
						//sksmash.updateUI();	//라벨 갱신해서 오류 삭제
						//panel.setComponentZOrder(label, 30);	//skill라벨이 보여지기 위해 배경 라벨의 우선순위 조정

						Timer ts = new Timer();	//Timer 실행
						TimerTask tsm = new TimerTask() {	//TimerTask 실행

							//TimerTask로 실행할 작업 내용 Override
							@Override
							public void run() {
								panel.remove(sksmash);	//skill 라벨 제거 
								
								for(int i = 9; i>=0; i--) {
									if(i >= voldmort.getHplife()) {
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
					}else if(vmchoice == 3) {
						panel.add(vmsksmash);	//skill 라벨 추가
						panel.revalidate();
						panel.repaint();
						panel.setComponentZOrder(vmsksmash, 0);
						harry.setHp(harry.getHp() -30);
						harry.setHplife(harry.getHplife() -3);
						System.out.println("볼드모트의 카운터! 해리포터의 체력이 30 감소합니다.");
						System.out.println("해리의 체력 : " + harry.getHp());
						//sksmash.updateUI();	//라벨 갱신해서 오류 삭제
						//panel.setComponentZOrder(label, 30);	//skill라벨이 보여지기 위해 배경 라벨의 우선순위 조정

						Timer ts = new Timer();	//Timer 실행
						TimerTask tsm = new TimerTask() {	//TimerTask 실행

							//TimerTask로 실행할 작업 내용 Override
							@Override
							public void run() {
								panel.remove(vmsksmash);	//skill 라벨 제거 
								panel.revalidate();
								panel.repaint();
								for(int i = 9; i>=0; i--) {
									if(i >= harry.getHplife()) {
										panel.remove(hp[i]);
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
					if(voldmort.getHp()<=0) {
						System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!볼드모트를 물리쳤습니다.");
						F_ChangePanel cp = new F_ChangePanel(mf, panel);
						F_SuccessPanel sp = new F_SuccessPanel(mf);
						cp.replacePanel(sp);
					}
					if(harry.getHp()<=0){
						System.out.println("재도전하시겠습니까?");
						F_ChangePanel cp = new F_ChangePanel(mf, panel);
						F_FailPanel fp = new F_FailPanel(mf);
						cp.replacePanel(fp);
					}
				}
			}
		});

		df.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {	//클릭은 동일한 위치라 인식이 안되는 경우가 종종 생기므로 Released 사용
				if(e.getSource() == df){	//getSource를 atk버튼을 받게 함
					int vmchoice = (int)(Math.random()*4);
					if(vmchoice == 0 || vmchoice == 1 || vmchoice == 3) {
						panel.add(skdf);	//skill 라벨 추가
						panel.add(vmskill);
						panel.revalidate();
						panel.repaint();
						panel.setComponentZOrder(skdf, 0);
						panel.setComponentZOrder(vmskill, 0);
						System.out.println("공격이 무효화 되었습니다.");
						//skdf.updateUI();	//라벨 갱신해서 오류 삭제
						//panel.setComponentZOrder(label, 30);	//skill라벨이 보여지기 위해 배경 라벨의 우선순위 조정

						Timer ts = new Timer();	//Timer 실행
						TimerTask tsm = new TimerTask() {	//TimerTask 실행

							//TimerTask로 실행할 작업 내용 Override
							@Override
							public void run() {
								panel.remove(skdf);	//skill 라벨 제거 
								panel.add(vmskill);
								panel.revalidate();
								panel.repaint();
								//panel.add(ef);			//ef 라벨 추가
								//ef.updateUI();			//라벨 갱신 
								//panel.setComponentZOrder(label, 29);	//배경 라벨 우선순위 조정
							}

						};
						ts.schedule(tsm, 1400);	//Override에 있는 작업 시작 시간 설정 
					}else if(vmchoice == 2){
						panel.add(skdf);	//skill 라벨 추가
						panel.add(vmsksmash);
						panel.setComponentZOrder(skdf, 0);
						panel.setComponentZOrder(vmsksmash, 0);
						panel.revalidate();
						panel.repaint();
						harry.setHp(harry.getHp() -20);
						harry.setHplife(harry.getHplife() -2);
						System.out.println("볼드모트의 스매쉬!! 해리포터의 체력이 20 감소합니다 ");
						System.out.println("해리의 체력 : " + harry.getHp());
						//skdf.updateUI();	//라벨 갱신해서 오류 삭제
						//panel.setComponentZOrder(label, 30);	//skill라벨이 보여지기 위해 배경 라벨의 우선순위 조정

						Timer ts = new Timer();	//Timer 실행
						TimerTask tsm = new TimerTask() {	//TimerTask 실행

							//TimerTask로 실행할 작업 내용 Override
							@Override
							public void run() {
								panel.remove(skdf);	//skill 라벨 제거 
								panel.remove(vmsksmash);
								for(int i = 9; i>=0; i--) {
									if(i >= harry.getHplife()) {
										panel.remove(hp[i]);
									}
								}
								panel.revalidate();
								panel.repaint();
								//panel.add(ef);			//ef 라벨 추가
								//ef.updateUI();			//라벨 갱신 
								//panel.setComponentZOrder(label, 29);	//배경 라벨 우선순위 조정
							}

						};
						ts.schedule(tsm, 1400);
					}
					if(harry.getHp()<=0){
						System.out.println("재도전하시겠습니까?");
						F_ChangePanel cp = new F_ChangePanel(mf, panel);
						F_FailPanel fp = new F_FailPanel(mf);
						cp.replacePanel(fp);
					}
				}
			}
		});

		counter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {	//클릭은 동일한 위치라 인식이 안되는 경우가 종종 생기므로 Released 사용
				if(e.getSource() == counter){	//getSource를 atk버튼을 받게 함
					int vmchoice = (int)(Math.random()*4);
					if(vmchoice == 0) {
						panel.add(skct);	//skill 라벨 추가
						panel.add(vmskill);
						panel.setComponentZOrder(skct, 0);
						panel.setComponentZOrder(vmskill, 0);
						panel.revalidate();
						panel.repaint();
						harry.setHp(harry.getHp() -10);
						harry.setHplife(harry.getHplife() -1);
						System.out.println("볼드모트의 공격!! 해리포터의 체력이 10 감소합니다 ");
						System.out.println("해리의 체력 : " + harry.getHp());
						//skdf.updateUI();	//라벨 갱신해서 오류 삭제
						//panel.setComponentZOrder(label, 30);	//skill라벨이 보여지기 위해 배경 라벨의 우선순위 조정

						Timer ts = new Timer();	//Timer 실행
						TimerTask tsm = new TimerTask() {	//TimerTask 실행

							//TimerTask로 실행할 작업 내용 Override
							@Override
							public void run() {
								panel.remove(skct);	//skill 라벨 제거 
								panel.remove(vmskill);
								for(int i = 9; i>=0; i--) {
									if(i >= harry.getHplife()) {
										panel.remove(hp[i]);
									}
								}
								panel.revalidate();
								panel.repaint();
								//panel.add(ef);			//ef 라벨 추가
								//ef.updateUI();			//라벨 갱신 
								//panel.setComponentZOrder(label, 29);	//배경 라벨 우선순위 조정
							}

						};
						ts.schedule(tsm, 1400);
					}else if(vmchoice == 1 || vmchoice ==3) {
						panel.add(skct);	//skill 라벨 추가
						panel.add(vmskdf);
						panel.setComponentZOrder(skct, 0);
						panel.setComponentZOrder(vmskdf, 0);
						panel.revalidate();
						panel.repaint();
						System.out.println("공격이 무효화되었습니다.");
						//skct.updateUI();	//라벨 갱신해서 오류 삭제
						//panel.setComponentZOrder(label, 30);	//skill라벨이 보여지기 위해 배경 라벨의 우선순위 조정

						Timer ts = new Timer();	//Timer 실행
						TimerTask tsm = new TimerTask() {	//TimerTask 실행

							//TimerTask로 실행할 작업 내용 Override
							@Override
							public void run() {
								panel.remove(skct);	//skill 라벨 제거 
								panel.remove(vmskdf);
								panel.revalidate();
								panel.repaint();
								//panel.add(ef);			//ef 라벨 추가
								//ef.updateUI();			//라벨 갱신 
								//panel.setComponentZOrder(label, 29);	//배경 라벨 우선순위 조정
							}

						};
						ts.schedule(tsm, 1400);	//Override에 있는 작업 시작 시간 설정 
					}else if(vmchoice == 2) {
						panel.add(vmsksmash);	//skill 라벨 추가
						panel.add(skct);
						panel.setComponentZOrder(vmsksmash, 0);
						panel.setComponentZOrder(skct, 0);
						panel.revalidate();
						panel.repaint();
						
						voldmort.setHp(voldmort.getHp() -30);
						voldmort.setHplife(voldmort.getHplife() -3);
						System.out.println("해리의 카운터! 볼드모트의 체력이 30 감소합니다.");
						System.out.println("볼드모트의 체력 : " + voldmort.getHp());
						//sksmash.updateUI();	//라벨 갱신해서 오류 삭제
						//panel.setComponentZOrder(label, 30);	//skill라벨이 보여지기 위해 배경 라벨의 우선순위 조정

						Timer ts = new Timer();	//Timer 실행
						TimerTask tsm = new TimerTask() {	//TimerTask 실행

							//TimerTask로 실행할 작업 내용 Override
							@Override
							public void run() {
								panel.remove(vmsksmash);	//skill 라벨 제거 
								panel.remove(skct);
								panel.revalidate();
								panel.repaint();
								for(int i = 9; i>=0; i--) {
									if(i >= voldmort.getHplife()) {
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
						ts.schedule(tsm, 1400);
					}
					if(voldmort.getHp()<=0) {
						System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!볼드모트를 물리쳤습니다.");
						F_ChangePanel cp = new F_ChangePanel(mf, panel);
						F_SuccessPanel sp = new F_SuccessPanel(mf);
						cp.replacePanel(sp);
					}
					if(harry.getHp()<=0){
						System.out.println("재도전하시겠습니까?");
						F_ChangePanel cp = new F_ChangePanel(mf, panel);
						F_FailPanel fp = new F_FailPanel(mf);
						cp.replacePanel(fp);
					}
				}
			}
		});
		

	}
}
