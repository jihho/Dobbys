package game.stage3.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import controller.B_UserManager;
import controller.C_GameStage;
import game.stage3.model.vo.F_General;
import game.stage3.model.vo.F_Harry;
import game.stage3.model.vo.F_Voldmort;
import model.vo.User;
import view.A_Music;

public class F_Stage3Panel extends JPanel{
	private JFrame mf;
	private JPanel panel;

	//스킬 이펙트 용 라벨
	private JLabel skill;	
	private JLabel sksmash;
	private JLabel skillmiss;	
	private JLabel sksmashmiss;
	private JLabel skdf;
	private JLabel skct;
	private JLabel atkdraw;
	private JLabel smdraw;
	private JLabel smdraw1;
	
	//볼드모트 스킬 이펙트 용 라벨
	private JLabel vmskill;	
	private JLabel vmsksmash;
	private JLabel vmskdf;
	private JLabel vmskct;	
	private JLabel vmskillsuc;	
	private JLabel vmsksmashsuc;
	private JLabel vmatkdraw;
	private JLabel vmsmdraw;
	private JLabel vmatkdraw1;
	//로그 사용할 텍스트에어리어 + 스크롤
	private JTextArea log;
	private JScrollPane sc;
	private JLabel round;
	
	//공격, 방어, 스매쉬, 카운터 실행 버튼
	JButton atk;
	JButton df;
	JButton smash;
	JButton counter;

	//해리와 볼드모트 객체 생성(hp, 공격, 스매쉬, 카운터, hp남은 갯수)
	private F_General harry = new F_Harry(100, 10, 20, 30, 10);
	private F_General voldmort = new F_Voldmort(100, 10, 20, 30, 10);

	//hp 감소 라벨 객체 선언
	private JLabel[] hp = new JLabel[10];
	private JLabel[] vmhp = new JLabel[10];
	private JLabel[] rd = new JLabel[70];
	
	//뒤로가기 라벨
	private JLabel back;
	private static int ctn = 0;
	
	public F_Stage3Panel(JFrame mf){
		this.mf = mf;
		this.setLayout(null);
		panel = this;

		this.setBounds(0, 0, 1280, 720);
		//배경음악 실행
		new A_Music().stage3_backgroundSound();

		//스테이지 배경 라벨로 올림
		JLabel label = new JLabel(new ImageIcon(new ImageIcon("images/stage3/stage03.png").getImage()));
		label.setBounds(0, 0, 1280, 720);

		//해리포터 캐릭터 라벨
		JLabel hr = new JLabel(new ImageIcon(new ImageIcon("images/stage3/harrymove.gif").getImage().getScaledInstance(225, 225, 0)));
		hr.setBounds(191, 277, 225, 225);

		//볼드모트 캐릭터 라벨
		JLabel bm = new JLabel(new ImageIcon(new ImageIcon("images/stage3/voldmote.gif").getImage().getScaledInstance(225, 225, 0)));
		bm.setBounds(921, 277, 225, 225);

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

		//로그창
		log = new JTextArea();
		sc = new JScrollPane(log);
		sc.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		sc.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		log.setLineWrap(true);
		sc.setBounds(610, 520, 620, 190);
		sc.setVisible(true);
		log.setFont(new Font("DungGeunMo", Font.PLAIN, 34));
		sc.getViewport().getView().setBackground(new Color(135, 125, 106));
		log.setOpaque(true);
		this.add(sc);

		//뒤로가기 라벨
		back = new JLabel(new ImageIcon(new ImageIcon("images/stage3/back.png").getImage().getScaledInstance(100, 100, 0)));
		back.setBounds(0, 0, 100, 100);
		
		//시연용 성공 실패 버튼
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

		//해리 스킬 이펙트 라벨
		skill  = new JLabel(new ImageIcon(new ImageIcon("images/stage3/atk2.gif").getImage().getScaledInstance(650, 200, 0)));
		sksmash  = new JLabel(new ImageIcon(new ImageIcon("images/stage3/smash1.gif").getImage().getScaledInstance(750, 200, 0)));
		skdf  = new JLabel(new ImageIcon(new ImageIcon("images/stage3/df22.gif").getImage().getScaledInstance(150, 200, 0)));
		skct  = new JLabel(new ImageIcon(new ImageIcon("images/stage3/ct2.gif").getImage().getScaledInstance(250, 200, 0)));
		skillmiss  = new JLabel(new ImageIcon(new ImageIcon("images/stage3/atk2.gif").getImage().getScaledInstance(550, 200, 0)));
		sksmashmiss  = new JLabel(new ImageIcon(new ImageIcon("images/stage3/smash1.gif").getImage().getScaledInstance(550, 200, 0)));
		atkdraw  = new JLabel(new ImageIcon(new ImageIcon("images/stage3/atk2.gif").getImage().getScaledInstance(450, 200, 0)));
		smdraw  = new JLabel(new ImageIcon(new ImageIcon("images/stage3/smash1.gif").getImage().getScaledInstance(450, 200, 0)));
		smdraw1  = new JLabel(new ImageIcon(new ImageIcon("images/stage3/smash1.gif").getImage().getScaledInstance(450, 200, 0)));
		
		//볼드모트 스킬 이펙트 라벨
		vmskill = new JLabel(new ImageIcon(new ImageIcon("images/stage3/atk1.gif").getImage().getScaledInstance(550, 200, 0)));
		vmsksmash = new JLabel(new ImageIcon(new ImageIcon("images/stage3/smash2.gif").getImage().getScaledInstance(550, 200, 0)));
		vmskdf = new JLabel(new ImageIcon(new ImageIcon("images/stage3/df2.gif").getImage().getScaledInstance(150, 200, 0)));
		vmskct = new JLabel(new ImageIcon(new ImageIcon("images/stage3/ct1.gif").getImage().getScaledInstance(250, 200, 0)));
		vmskillsuc = new JLabel(new ImageIcon(new ImageIcon("images/stage3/atk1.gif").getImage().getScaledInstance(750, 200, 0)));
		vmsksmashsuc = new JLabel(new ImageIcon(new ImageIcon("images/stage3/smash2.gif").getImage().getScaledInstance(850, 200, 0)));
		vmatkdraw = new JLabel(new ImageIcon(new ImageIcon("images/stage3/atk1.gif").getImage().getScaledInstance(450, 200, 0)));
		vmsmdraw = new JLabel(new ImageIcon(new ImageIcon("images/stage3/smash2.gif").getImage().getScaledInstance(450, 200, 0)));
		vmatkdraw1 = new JLabel(new ImageIcon(new ImageIcon("images/stage3/atk1.gif").getImage().getScaledInstance(450, 200, 0)));
		/*round = new JLabel(new ImageIcon(new ImageIcon("images/stage3/round01.png").getImage()));
		round.setBounds(0, 0, 1280, 720);*/

		for(int i = 0; i < 70; i++) {
		rd[i] = new JLabel(new ImageIcon(new ImageIcon("images/stage3/round" + (i+1) +".png").getImage()));
		rd[i].setBounds(0, 0, 1280, 720);
		}
		
		
		

		//스킬 이펙트 위치와 크기 지정
		//해리
		skill.setBounds(440, 277, 700, 200);
		sksmash.setBounds(350, 277, 750, 200);
		skdf.setBounds(440, 247, 150, 250);
		skct.setBounds(400, 277, 250, 200);
		skillmiss.setBounds(440, 277, 550, 200);
		sksmashmiss.setBounds(440, 277, 550, 200);
		atkdraw.setBounds(370, 277, 450, 200);
		smdraw.setBounds(370, 277, 450, 200);
		smdraw1.setBounds(370, 277, 450, 200);
		
		//볼드모트
		vmskill.setBounds(440, 277, 550, 200);
		vmsksmash.setBounds(440, 277, 550, 200);
		vmskdf.setBounds(800, 247, 150, 250);
		vmskct.setBounds(800, 277, 250, 200);
		vmskillsuc.setBounds(200, 277, 750, 200);
		vmsksmashsuc.setBounds(200, 277, 850, 200);
		vmatkdraw.setBounds(500, 277, 450, 200);
		vmsmdraw.setBounds(600, 277, 450, 200);
		vmatkdraw1.setBounds(600, 277, 450, 200);
		//항상 존재하는 라벨과 버튼 추가
		this.add(hr);
		this.add(bm);
		this.add(success);
		this.add(fail);
		this.add(hpbar);
		for(int i = 0; i < 10; i++) {
			panel.add(hp[i]);
		}

		this.add(bmhp);
		for(int i = 0; i < 10; i++) {
			panel.add(vmhp[i]);
		}
		
		panel.add(atk);
		panel.add(df);
		panel.add(smash);
		panel.add(counter);
		panel.add(back);
		
		//버튼 이벤트
		ActionClass actionEvent = new ActionClass();
		atk.addActionListener(actionEvent);
		df.addActionListener(actionEvent);
		smash.addActionListener(actionEvent);
		counter.addActionListener(actionEvent);

		//각 버튼의 값을 1,2,3,4로 정하여 액션 이벤트에서 switch문으로 구분
		atk.setActionCommand("1");
		df.setActionCommand("2");
		smash.setActionCommand("3");
		counter.setActionCommand("4");

		log.append("버튼을 선택해주세요\n");
		
		//라운드 1 라벨 
		panel.add(rd[0]);
		
		//마지막에 배경 라벨 추가해서 라벨의 setComponentZOrder 상관 X
		this.add(label);

		atk.setEnabled(false);
		df.setEnabled(false);
		smash.setEnabled(false);
		counter.setEnabled(false);
		
		Timer ts = new Timer();	
		TimerTask tsm = new TimerTask() {

			@Override
			public void run() {
				panel.remove(rd[0]);
				panel.revalidate();
				panel.repaint();
				atk.setEnabled(true);
				df.setEnabled(true);
				smash.setEnabled(true);
				counter.setEnabled(true);
			}

		};
		ts.schedule(tsm, 1400);
		
		//뒤로가기 라벨 마우스 이벤트
		back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				new A_Music().intoBgmStop();
				ctn = 0;
				F_ChangePanel cp = new F_ChangePanel(mf, panel);
				C_GameStage gs = new C_GameStage(mf);
				cp.replacePanel(gs);
			}
		});

		//시연용 성공, 실패 버튼 마우스 이벤트
		success.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				new A_Music().intoBgmStop();

				switch(harry.getHplife()) {
				case 1: new B_UserManager().updateScore3(User.playerId, 100); break;
				case 2: new B_UserManager().updateScore3(User.playerId, 200); break;
				case 3: new B_UserManager().updateScore3(User.playerId, 300); break;
				case 4: new B_UserManager().updateScore3(User.playerId, 400); break;
				case 5: new B_UserManager().updateScore3(User.playerId, 500); break;
				case 6: new B_UserManager().updateScore3(User.playerId, 600); break;
				case 7: new B_UserManager().updateScore3(User.playerId, 700); break;
				case 8: new B_UserManager().updateScore3(User.playerId, 800); break;
				case 9: new B_UserManager().updateScore3(User.playerId, 900); break;
				case 10: new B_UserManager().updateScore3(User.playerId, 1000); break;
				}
				ctn = 0;
				F_ChangePanel cp = new F_ChangePanel(mf, panel);
				F_SuccessPanel sp = new F_SuccessPanel(mf);
				cp.replacePanel(sp);
			}
		});

		fail.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				new A_Music().intoBgmStop();
				ctn = 0;
				F_ChangePanel cp = new F_ChangePanel(mf, panel);
				F_FailPanel fp = new F_FailPanel(mf);
				cp.replacePanel(fp);
			}
		});

	}


	//버튼 액션 이벤트, 버튼 이벤트는 큰틀에서 같은 패턴이므로 주석은 1번 atk버튼에만 작성
	class ActionClass implements ActionListener{


		@Override
		public void actionPerformed(ActionEvent e) {
			//버튼에서 선언한 각 버튼의 int값 받을 수 있는 int 생성
			int action = Integer.parseInt(e.getActionCommand());
			//볼드모트의 선택 만들어줄 랜덤값 생성
			int vmchoice = (int)(Math.random()*4);

			if(e.getSource() == atk || e.getSource() == df || 
					e.getSource() == smash || e.getSource() == counter) {
				ctn++;
			}
			//플레이어의 선택 버튼 switch
			switch(action) {

			//공격 버튼
			case 1: 
				//중복 이미지 실행 및 패널 체인지 꼬이는거 막기 위한 버튼 잠금
				atk.setEnabled(false);
				df.setEnabled(false);
				smash.setEnabled(false);
				counter.setEnabled(false);

				//볼드모트의 선택이 공격, 방어, 스매쉬일 경우
				if(vmchoice == 0) {	//해리 공격, 볼드모트 공격
					new F_EffectMusic().stage3_atk();
					new F_EffectMusic().stage3_vmatk();
					
					panel.add(atkdraw);
					panel.add(vmatkdraw);
					
					panel.setComponentZOrder(atkdraw, 0);
					panel.setComponentZOrder(vmatkdraw, 0);
					
					panel.revalidate();
					panel.repaint();
					
					log.append("해리 : 공격  볼드모트 : 공격\n");
					log.append("공격이 무효화 되었습니다.\n");
					log.setCaretPosition(log.getDocument().getLength());
					
					Timer ts = new Timer();	//Timer 실행
					TimerTask tsm = new TimerTask() {	//TimerTask 실행

						//TimerTask로 실행할 작업 내용 Override
						@Override
						public void run() {
							//스킬 이펙트 제거 
							panel.remove(atkdraw);	
							panel.remove(vmatkdraw);
							
							//라운드 라벨 생성
							panel.add(rd[ctn]);
							panel.setComponentZOrder(rd[ctn], 0);

							//이펙트 안전한 제거를 위한 패널 갱신
							panel.revalidate();
							panel.repaint();
							//이펙트 종료 후 버튼 잠금 해제

						}

					};
					ts.schedule(tsm, 1400); 

					Timer rd1 = new Timer();	
					TimerTask rdm1 = new TimerTask() {

						@Override
						public void run() {
							//라운드 라벨 제거
							panel.remove(rd[ctn]);

							panel.revalidate();
							panel.repaint();
							//버튼 잠금 해제
							atk.setEnabled(true);
							df.setEnabled(true);
							smash.setEnabled(true);
							counter.setEnabled(true);
						}

					};
					rd1.schedule(rdm1, 2200); break;
					
				}else if(vmchoice == 1) {	//해리 공격 볼드모트 방어
					//각 스킬의 사운드 실행
					new F_EffectMusic().stage3_atk();
					new F_EffectMusic().stage3_vmdf();

					//패널에 스킬 이펙트 생성
					panel.add(skillmiss);
					panel.add(vmskdf);

					//각 이펙트의 우선순위를 최우선으로
					panel.setComponentZOrder(skillmiss, 0);
					panel.setComponentZOrder(vmskdf, 0);

					//패널 갱신해서 이미지 출력
					panel.revalidate();
					panel.repaint();

					//로그창 메세지
					log.append("해리 : 공격  볼드모트 : 방어\n");
					log.append("공격이 무효화 되었습니다.\n");
					//로그창 스크롤 자동 갱신
					log.setCaretPosition(log.getDocument().getLength());

					Timer ts = new Timer();	//Timer 실행
					TimerTask tsm = new TimerTask() {	//TimerTask 실행

						//TimerTask로 실행할 작업 내용 Override
						@Override
						public void run() {
							//스킬 이펙트 제거 
							panel.remove(skillmiss);	
							panel.remove(vmskdf);
							
							//라운드 라벨 생성
							panel.add(rd[ctn]);
							panel.setComponentZOrder(rd[ctn], 0);

							//이펙트 안전한 제거를 위한 패널 갱신
							panel.revalidate();
							panel.repaint();
							//이펙트 종료 후 버튼 잠금 해제

						}

					};
					ts.schedule(tsm, 1400); 

					Timer rd1 = new Timer();	
					TimerTask rdm1 = new TimerTask() {

						@Override
						public void run() {
							//라운드 라벨 제거
							panel.remove(rd[ctn]);

							panel.revalidate();
							panel.repaint();
							//버튼 잠금 해제
							atk.setEnabled(true);
							df.setEnabled(true);
							smash.setEnabled(true);
							counter.setEnabled(true);
						}

					};
					rd1.schedule(rdm1, 2200); break;
					
				}else if(vmchoice == 2) {	//해리 공격 볼드모트 스매쉬
					new F_EffectMusic().stage3_atk();
					new F_EffectMusic().stage3_vmsmash();
					
					panel.add(atkdraw);
					panel.add(vmsmdraw);

					//각 이펙트의 우선순위를 최우선으로
					panel.setComponentZOrder(atkdraw, 0);
					panel.setComponentZOrder(vmsmdraw, 0);

					//패널 갱신해서 이미지 출력
					panel.revalidate();
					panel.repaint();

					//로그창 메세지
					log.append("해리 : 공격  볼드모트 : 스매쉬\n");
					log.append("공격이 무효화 되었습니다.\n");
					//로그창 스크롤 자동 갱신
					log.setCaretPosition(log.getDocument().getLength());
					
					Timer ts = new Timer();	//Timer 실행
					TimerTask tsm = new TimerTask() {	//TimerTask 실행

						//TimerTask로 실행할 작업 내용 Override
						@Override
						public void run() {
							//스킬 이펙트 제거 
							panel.remove(atkdraw);	
							panel.remove(vmsmdraw);
							
							//라운드 라벨 생성
							panel.add(rd[ctn]);
							panel.setComponentZOrder(rd[ctn], 0);

							//이펙트 안전한 제거를 위한 패널 갱신
							panel.revalidate();
							panel.repaint();
							//이펙트 종료 후 버튼 잠금 해제

						}

					};
					ts.schedule(tsm, 1400); 

					Timer rd1 = new Timer();	
					TimerTask rdm1 = new TimerTask() {

						@Override
						public void run() {
							//라운드 라벨 제거
							panel.remove(rd[ctn]);

							panel.revalidate();
							panel.repaint();
							//버튼 잠금 해제
							atk.setEnabled(true);
							df.setEnabled(true);
							smash.setEnabled(true);
							counter.setEnabled(true);
						}

					};
					rd1.schedule(rdm1, 2200); break;
					
				}else if(vmchoice == 3) {	//해리 : 공격 볼드모트 : 카운터
					//스킬 음성 
					new F_EffectMusic().stage3_vmct();
					//스킬 이펙트 추가
					panel.add(vmskct);
					panel.setComponentZOrder(vmskct, 0);
					panel.revalidate();
					panel.repaint();
					Timer ts1 = new Timer();	
					TimerTask tsm1 = new TimerTask() {	

						@Override
						public void run() {
							new F_EffectMusic().stage3_atk();
							panel.remove(vmskct);
							panel.add(skill);	
							panel.setComponentZOrder(skill, 0);
							panel.revalidate();
							panel.repaint();
						}
					};
					ts1.schedule(tsm1, 1400);

					//볼드모트 객체에 잃은 체력 값 전달
					voldmort.setHp(voldmort.getHp() -10);
					voldmort.setHplife(voldmort.getHplife() -1);
					//로그창 
					log.append("해리 : 공격  볼드모트 : 카운터\n");
					log.append("공격 성공!!\n볼드모트의 체력이 10 감소합니다.\n");
					log.append("볼드모트의 체력 : " + voldmort.getHp()+"\n");
					log.setCaretPosition(log.getDocument().getLength());

					Timer ts = new Timer();	
					TimerTask tsm = new TimerTask() {	

						@Override
						public void run() {
							//스킬 이펙트 제거
							panel.remove(skill);

							//남은 체력값 받아와서 객체로 만든 hp게이지 제거
							for(int i = 9; i>=0; i--) {
								if(i >= voldmort.getHplife()) {
									panel.remove(vmhp[i]);
								}
							}
							//라운드 라벨 생성
							panel.add(rd[ctn]);
							panel.setComponentZOrder(rd[ctn], 0);

							//패널 갱신
							panel.revalidate();
							panel.repaint();
							//버튼 활성화

							//볼드모트 체력 0일때 성공 패널 실행을 위한 if문
							if(voldmort.getHp()<=0) {
								log.append("!!볼드모트를 물리쳤습니다.\n");
								//넘어갈때 종종 음악이 안꺼지고 이어지는 오류 해결을 위한 음악 종료
								new A_Music().intoBgmStop();
								new F_EffectMusic().intoBgmStop();

								//클리어시 남은 해리의 체력에 따른 점수 부여
								switch(harry.getHplife()) {
								case 1: new B_UserManager().updateScore3(User.playerId, 100); break;
								case 2: new B_UserManager().updateScore3(User.playerId, 200); break;
								case 3: new B_UserManager().updateScore3(User.playerId, 300); break;
								case 4: new B_UserManager().updateScore3(User.playerId, 400); break;
								case 5: new B_UserManager().updateScore3(User.playerId, 500); break;
								case 6: new B_UserManager().updateScore3(User.playerId, 600); break;
								case 7: new B_UserManager().updateScore3(User.playerId, 700); break;
								case 8: new B_UserManager().updateScore3(User.playerId, 800); break;
								case 9: new B_UserManager().updateScore3(User.playerId, 900); break;
								case 10: new B_UserManager().updateScore3(User.playerId, 1000); break;
								}
								ctn = 0;
								//성공 영상 재생을 위한 성공 패널로 체인지
								F_ChangePanel cp = new F_ChangePanel(mf, panel);
								F_SuccessPanel sp = new F_SuccessPanel(mf);
								cp.replacePanel(sp);

							}
						}

					};
					ts.schedule(tsm, 2800);
					Timer rd1 = new Timer();	
					TimerTask rdm1 = new TimerTask() {

						@Override
						public void run() {
							panel.remove(rd[ctn]);
							panel.revalidate();
							panel.repaint();
							atk.setEnabled(true);
							df.setEnabled(true);
							smash.setEnabled(true);
							counter.setEnabled(true);
						}

					};
					rd1.schedule(rdm1, 3600); break;
				}

			case 2 : 
				atk.setEnabled(false);
				df.setEnabled(false);
				smash.setEnabled(false);
				counter.setEnabled(false);

				if(vmchoice == 0) {	//해리 : 방어 볼드모트 : 공격
					new F_EffectMusic().stage3_df();
					new F_EffectMusic().stage3_vmatk();
					panel.add(skdf);	
					panel.add(vmskill);
					panel.setComponentZOrder(skdf, 0);
					panel.setComponentZOrder(vmskill, 0);
					panel.revalidate();
					panel.repaint();
					log.append("해리 : 방어  볼드모트 : 공격\n");
					log.append("공격이 무효화 되었습니다.\n");
					log.setCaretPosition(log.getDocument().getLength());

					Timer ts = new Timer();	
					TimerTask tsm = new TimerTask() {	

						@Override
						public void run() {
							panel.remove(skdf);	
							panel.remove(vmskill);
							panel.add(rd[ctn]);
							panel.setComponentZOrder(rd[ctn], 0);
							panel.revalidate();
							panel.repaint();
						}

					};
					ts.schedule(tsm, 1400);
					Timer rd1 = new Timer();	
					TimerTask rdm1 = new TimerTask() {

						@Override
						public void run() {

							panel.remove(rd[ctn]);

							panel.revalidate();
							panel.repaint();
							atk.setEnabled(true);
							df.setEnabled(true);
							smash.setEnabled(true);
							counter.setEnabled(true);
						}

					};
					rd1.schedule(rdm1, 2200); break;
				}else if(vmchoice == 1) {	//해리 방어 볼드모트 방어
					new F_EffectMusic().stage3_df();
					new F_EffectMusic().stage3_vmdf();
					panel.add(skdf);	
					panel.add(vmskdf);
					panel.setComponentZOrder(skdf, 0);
					panel.setComponentZOrder(vmskdf, 0);
					panel.revalidate();
					panel.repaint();
					log.append("해리 : 방어  볼드모트 : 방어\n");
					log.append("공격이 무효화 되었습니다.\n");
					log.setCaretPosition(log.getDocument().getLength());

					Timer ts = new Timer();	
					TimerTask tsm = new TimerTask() {	

						@Override
						public void run() {
							panel.remove(skdf);	
							panel.remove(vmskdf);
							panel.add(rd[ctn]);
							panel.setComponentZOrder(rd[ctn], 0);
							panel.revalidate();
							panel.repaint();
						}

					};
					ts.schedule(tsm, 1400);
					Timer rd1 = new Timer();	
					TimerTask rdm1 = new TimerTask() {

						@Override
						public void run() {

							panel.remove(rd[ctn]);

							panel.revalidate();
							panel.repaint();
							atk.setEnabled(true);
							df.setEnabled(true);
							smash.setEnabled(true);
							counter.setEnabled(true);
						}

					};
					rd1.schedule(rdm1, 2200); break;
				}else if(vmchoice == 2) {	//해리 : 방어 볼드모트 : 스매쉬
					new F_EffectMusic().stage3_df();
					panel.add(skdf);
					panel.setComponentZOrder(skdf, 0);
					panel.revalidate();
					panel.repaint();

					Timer ts1 = new Timer();	
					TimerTask tsm1 = new TimerTask() {	

						@Override
						public void run() {
							new F_EffectMusic().stage3_vmsmash();
							panel.remove(skdf);
							panel.add(vmsksmashsuc);	
							panel.setComponentZOrder(vmsksmashsuc, 0);
							panel.revalidate();
							panel.repaint();
						}
					};
					ts1.schedule(tsm1, 1400);

					harry.setHp(harry.getHp() -20);
					harry.setHplife(harry.getHplife() -2);
					log.append("해리 : 방어  볼드모트 : 스매쉬\n");
					log.append("볼드모트의 스매쉬!!\n해리포터의 체력이 20 감소합니다.\n");
					log.append("해리의 체력 : " + harry.getHp()+"\n");
					log.setCaretPosition(log.getDocument().getLength());

					Timer ts = new Timer();	
					TimerTask tsm = new TimerTask() {	

						@Override
						public void run() {
							panel.remove(vmsksmashsuc);
							for(int i = 9; i>=0; i--) {
								if(i >= harry.getHplife()) {
									panel.remove(hp[i]);
								}
							}
							panel.add(rd[ctn]);
							panel.setComponentZOrder(rd[ctn], 0);
							panel.revalidate();
							panel.repaint();
							
							if(harry.getHp()<=0){
								log.append("재도전하시겠습니까?");
								new A_Music().intoBgmStop();
								new F_EffectMusic().intoBgmStop();
								ctn = 0;
								F_ChangePanel cp = new F_ChangePanel(mf, panel);
								F_FailPanel fp = new F_FailPanel(mf);
								cp.replacePanel(fp);
								return;
							}

						}

					};
					ts.schedule(tsm, 2800);
					Timer rd1 = new Timer();	
					TimerTask rdm1 = new TimerTask() {

						@Override
						public void run() {

							panel.remove(rd[ctn]);

							panel.revalidate();
							panel.repaint();
							atk.setEnabled(true);
							df.setEnabled(true);
							smash.setEnabled(true);
							counter.setEnabled(true);
						}

					};
					rd1.schedule(rdm1, 3600); break;
					
				}else if(vmchoice == 3) {	//해리 : 방어 볼드모트 : 카운터
					new F_EffectMusic().stage3_df();
					new F_EffectMusic().stage3_vmct();
					panel.add(skdf);	
					panel.add(vmskct);
					panel.setComponentZOrder(skdf, 0);
					panel.setComponentZOrder(vmskct, 0);
					panel.revalidate();
					panel.repaint();
					log.append("해리 : 방어  볼드모트 : 카운터\n");
					log.append("공격이 무효화 되었습니다.\n");
					log.setCaretPosition(log.getDocument().getLength());

					Timer ts = new Timer();	
					TimerTask tsm = new TimerTask() {	

						@Override
						public void run() {
							panel.remove(skdf);	
							panel.remove(vmskct);
							panel.add(rd[ctn]);
							panel.setComponentZOrder(rd[ctn], 0);
							panel.revalidate();
							panel.repaint();
						}

					};
					ts.schedule(tsm, 1400);
					Timer rd1 = new Timer();	
					TimerTask rdm1 = new TimerTask() {

						@Override
						public void run() {

							panel.remove(rd[ctn]);

							panel.revalidate();
							panel.repaint();
							atk.setEnabled(true);
							df.setEnabled(true);
							smash.setEnabled(true);
							counter.setEnabled(true);
						}

					};
					rd1.schedule(rdm1, 2200); break;
				}

			case 3 : 
				atk.setEnabled(false);
				df.setEnabled(false);
				smash.setEnabled(false);
				counter.setEnabled(false);

				if(vmchoice == 0) { //해리 : 스매쉬 볼드모트 : 공격 
					new F_EffectMusic().stage3_smash();
					new F_EffectMusic().stage3_vmatk();
					
					panel.add(smdraw1);
					panel.add(vmatkdraw1);

					//각 이펙트의 우선순위를 최우선으로
					panel.setComponentZOrder(smdraw1, 0);
					panel.setComponentZOrder(vmatkdraw1, 0);

					//패널 갱신해서 이미지 출력
					panel.revalidate();
					panel.repaint();

					//로그창 메세지
					log.append("해리 : 스매쉬  볼드모트 : 공격\n");
					log.append("공격이 무효화 되었습니다.\n");
					//로그창 스크롤 자동 갱신
					log.setCaretPosition(log.getDocument().getLength());
					
					Timer ts = new Timer();	//Timer 실행
					TimerTask tsm = new TimerTask() {	//TimerTask 실행

						//TimerTask로 실행할 작업 내용 Override
						@Override
						public void run() {
							//스킬 이펙트 제거 
							panel.remove(smdraw1);	
							panel.remove(vmatkdraw1);
							
							//라운드 라벨 생성
							panel.add(rd[ctn]);
							panel.setComponentZOrder(rd[ctn], 0);

							//이펙트 안전한 제거를 위한 패널 갱신
							panel.revalidate();
							panel.repaint();
							//이펙트 종료 후 버튼 잠금 해제

						}

					};
					ts.schedule(tsm, 1400); 

					Timer rd1 = new Timer();	
					TimerTask rdm1 = new TimerTask() {

						@Override
						public void run() {
							//라운드 라벨 제거
							panel.remove(rd[ctn]);

							panel.revalidate();
							panel.repaint();
							//버튼 잠금 해제
							atk.setEnabled(true);
							df.setEnabled(true);
							smash.setEnabled(true);
							counter.setEnabled(true);
						}

					};
					rd1.schedule(rdm1, 2200); break;
					
				}else if(vmchoice == 1) {	//해리 : 스매쉬 볼드모트 : 방어
					new F_EffectMusic().stage3_vmdf();
					panel.add(vmskdf);	
					panel.setComponentZOrder(vmskdf, 0);
					panel.revalidate();
					panel.repaint();
					Timer ts1 = new Timer();	
					TimerTask tsm1 = new TimerTask() {	

						@Override
						public void run() {
							new F_EffectMusic().stage3_atk();
							panel.remove(vmskdf);
							panel.add(sksmash);	
							panel.setComponentZOrder(sksmash, 0);
							panel.revalidate();
							panel.repaint();
						}
					};
					ts1.schedule(tsm1, 1400);
					
					voldmort.setHp(voldmort.getHp() -20);
					voldmort.setHplife(voldmort.getHplife() -2);
					log.append("해리 : 스매쉬  볼드모트 : 방어\n");
					log.append("공격 성공!!\n볼드모트의 체력이 20 감소합니다.\n");
					log.append("볼드모트의 체력 : " + voldmort.getHp()+"\n");
					log.setCaretPosition(log.getDocument().getLength());

					Timer ts = new Timer();	
					TimerTask tsm = new TimerTask() {	

						@Override
						public void run() {
							panel.remove(sksmash);	 
							panel.add(rd[ctn]);
							panel.setComponentZOrder(rd[ctn], 0);
							for(int i = 9; i>=0; i--) {
								if(i >= voldmort.getHplife()) {
									panel.remove(vmhp[i]);
								}
							}
							panel.revalidate();
							panel.repaint();
							if(voldmort.getHp()<=0) {
								log.append("!!볼드모트를 물리쳤습니다.\n");
								new A_Music().intoBgmStop();
								new F_EffectMusic().intoBgmStop();

								switch(harry.getHplife()) {
								case 1: new B_UserManager().updateScore3(User.playerId, 100); break;
								case 2: new B_UserManager().updateScore3(User.playerId, 200); break;
								case 3: new B_UserManager().updateScore3(User.playerId, 300); break;
								case 4: new B_UserManager().updateScore3(User.playerId, 400); break;
								case 5: new B_UserManager().updateScore3(User.playerId, 500); break;
								case 6: new B_UserManager().updateScore3(User.playerId, 600); break;
								case 7: new B_UserManager().updateScore3(User.playerId, 700); break;
								case 8: new B_UserManager().updateScore3(User.playerId, 800); break;
								case 9: new B_UserManager().updateScore3(User.playerId, 900); break;
								case 10: new B_UserManager().updateScore3(User.playerId, 1000); break;
								}
								ctn = 0;
								F_ChangePanel cp = new F_ChangePanel(mf, panel);
								F_SuccessPanel sp = new F_SuccessPanel(mf);
								cp.replacePanel(sp);
							}
						}

					};
					ts.schedule(tsm, 2800);	
					Timer rd1 = new Timer();	
					TimerTask rdm1 = new TimerTask() {

						@Override
						public void run() {

							panel.remove(rd[ctn]);

							panel.revalidate();
							panel.repaint();
							atk.setEnabled(true);
							df.setEnabled(true);
							smash.setEnabled(true);
							counter.setEnabled(true);
						}

					};
					rd1.schedule(rdm1, 3600); break;
					
				}else if(vmchoice == 2) {	//해리 : 스매쉬 볼드모트 스매쉬
					new F_EffectMusic().stage3_smash();
					new F_EffectMusic().stage3_vmsmash();
					panel.add(smdraw);
					panel.add(vmsmdraw);
					panel.setComponentZOrder(smdraw, 0);
					panel.setComponentZOrder(vmsmdraw, 0);
					panel.revalidate();
					panel.repaint();
					log.append("해리 : 스매쉬  볼드모트 : 스매쉬\n");
					log.append("공격이 무효화 되었습니다.\n");
					log.setCaretPosition(log.getDocument().getLength());
					Timer ts = new Timer();	
					TimerTask tsm = new TimerTask() {	

						@Override
						public void run() {
							panel.remove(smdraw);	 
							panel.remove(vmsmdraw);
							panel.add(rd[ctn]);
							panel.setComponentZOrder(rd[ctn], 0);
							panel.revalidate();
							panel.repaint();

						}
					};
					ts.schedule(tsm, 1400);
					Timer rd1 = new Timer();	
					TimerTask rdm1 = new TimerTask() {

						@Override
						public void run() {

							panel.remove(rd[ctn]);

							panel.revalidate();
							panel.repaint();
							atk.setEnabled(true);
							df.setEnabled(true);
							smash.setEnabled(true);
							counter.setEnabled(true);
						}

					};
					rd1.schedule(rdm1, 2200); break;
					
				}else if(vmchoice == 3) {	//해리 : 스매쉬 볼드모트 : 카운터
					new F_EffectMusic().stage3_smash();
					panel.add(sksmashmiss);
					panel.setComponentZOrder(sksmashmiss, 0);
					panel.revalidate();
					panel.repaint();
					Timer ts1 = new Timer();
					TimerTask tsm1 = new TimerTask() {
						@Override
						public void run() {
							new F_EffectMusic().stage3_vmct();
							panel.add(vmskct);
							panel.setComponentZOrder(vmskct, 0);
							panel.revalidate();
							panel.repaint();
						}
					};
					ts1.schedule(tsm1, 700);

					harry.setHp(harry.getHp() -30);
					harry.setHplife(harry.getHplife() -3);
					
					log.append("해리 : 스매쉬  볼드모트 : 카운터\n");
					log.append("볼드모트의 카운터!\n해리포터의 체력이 30 감소합니다.\n");
					log.append("해리의 체력 : " + harry.getHp()+"\n");
					log.setCaretPosition(log.getDocument().getLength());

					Timer ts = new Timer();	
					TimerTask tsm = new TimerTask() {	

						@Override
						public void run() {
							panel.remove(sksmashmiss);
							panel.remove(vmskct);	 
							panel.add(rd[ctn]);
							panel.setComponentZOrder(rd[ctn], 0);
							for(int i = 9; i>=0; i--) {
								if(i >= harry.getHplife()) {
									panel.remove(hp[i]);
								}
							}
							panel.revalidate();
							panel.repaint();
							if(harry.getHp()<=0){
								log.append("재도전하시겠습니까?");
								new A_Music().intoBgmStop();
								new F_EffectMusic().intoBgmStop();
								ctn = 0;
								F_ChangePanel cp = new F_ChangePanel(mf, panel);
								F_FailPanel fp = new F_FailPanel(mf);
								cp.replacePanel(fp);
								return;
							}
						}

					};
					ts.schedule(tsm, 1400);
					Timer rd1 = new Timer();	
					TimerTask rdm1 = new TimerTask() {

						@Override
						public void run() {

							panel.remove(rd[ctn]);

							panel.revalidate();
							panel.repaint();
							atk.setEnabled(true);
							df.setEnabled(true);
							smash.setEnabled(true);
							counter.setEnabled(true);
						}

					};
					rd1.schedule(rdm1, 2200); break;
				}

			case 4 : 
				atk.setEnabled(false);
				df.setEnabled(false);
				smash.setEnabled(false);
				counter.setEnabled(false);

				if(vmchoice == 0) {	//해리 : 카운터 볼드모트 : 공격
					new F_EffectMusic().stage3_ct();
					panel.add(skct);	
					panel.setComponentZOrder(skct, 0);
					panel.revalidate();
					panel.repaint();
					Timer ts1 = new Timer();	
					TimerTask tsm1 = new TimerTask() {	

						@Override
						public void run() {
							new F_EffectMusic().stage3_vmatk();
							panel.remove(skct);
							panel.add(vmskillsuc);	
							panel.setComponentZOrder(vmskillsuc, 0);
							panel.revalidate();
							panel.repaint();
						}
					};
					ts1.schedule(tsm1, 1400);

					harry.setHp(harry.getHp() -10);
					harry.setHplife(harry.getHplife() -1);
					log.append("해리 : 카운터  볼드모트 : 공격\n");
					log.append("볼드모트의 공격!!\n해리포터의 체력이 10 감소합니다.\n");
					log.append("해리의 체력 : " + harry.getHp()+"\n");
					log.setCaretPosition(log.getDocument().getLength());

					Timer ts = new Timer();	
					TimerTask tsm = new TimerTask() {	

						@Override
						public void run() {
							panel.remove(vmskillsuc);
							panel.add(rd[ctn]);
							panel.setComponentZOrder(rd[ctn], 0);
							for(int i = 9; i>=0; i--) {
								if(i >= harry.getHplife()) {
									panel.remove(hp[i]);
								}
							}
							panel.revalidate();
							panel.repaint();
							if(harry.getHp()<=0){
								log.append("재도전하시겠습니까?");
								new A_Music().intoBgmStop();
								new F_EffectMusic().intoBgmStop();
								ctn = 0;
								F_ChangePanel cp = new F_ChangePanel(mf, panel);
								F_FailPanel fp = new F_FailPanel(mf);
								cp.replacePanel(fp);
								return;
							}
						}
					};
					ts.schedule(tsm, 2800);
					
					Timer rd1 = new Timer();	
					TimerTask rdm1 = new TimerTask() {

						@Override
						public void run() {

							panel.remove(rd[ctn]);

							panel.revalidate();
							panel.repaint();
							atk.setEnabled(true);
							df.setEnabled(true);
							smash.setEnabled(true);
							counter.setEnabled(true);
						}

					};
					rd1.schedule(rdm1, 3600); break;
				}else if(vmchoice == 1) {	//해리 : 카운터 볼드모트 : 방어
					new F_EffectMusic().stage3_ct();
					new F_EffectMusic().stage3_vmdf();
					panel.add(skct);	
					panel.add(vmskdf);
					panel.setComponentZOrder(skct, 0);
					panel.setComponentZOrder(vmskdf, 0);
					panel.revalidate();
					panel.repaint();
					log.append("해리 : 카운터  볼드모트 : 방어\n");
					log.append("공격이 무효화 되었습니다.\n");
					log.setCaretPosition(log.getDocument().getLength());

					Timer ts = new Timer();	
					TimerTask tsm = new TimerTask() {	

						@Override
						public void run() {
							panel.remove(skct);	
							panel.remove(vmskdf);
							panel.add(rd[ctn]);
							panel.setComponentZOrder(rd[ctn], 0);
							panel.revalidate();
							panel.repaint();
						}

					};
					ts.schedule(tsm, 1400);
					Timer rd1 = new Timer();	
					TimerTask rdm1 = new TimerTask() {

						@Override
						public void run() {

							panel.remove(rd[ctn]);

							panel.revalidate();
							panel.repaint();
							atk.setEnabled(true);
							df.setEnabled(true);
							smash.setEnabled(true);
							counter.setEnabled(true);
						}

					};
					rd1.schedule(rdm1, 2200); break;
					
				}else if(vmchoice == 2) {	//해리 : 카운터 볼드모트 : 스매쉬
					new F_EffectMusic().stage3_vmsmash();
					panel.add(vmsksmash);	
					panel.setComponentZOrder(vmsksmash, 0);
					panel.revalidate();
					panel.repaint();
					Timer ts1 = new Timer();	
					TimerTask tsm1 = new TimerTask() {

						@Override
						public void run() {
							new F_EffectMusic().stage3_ct();
							panel.add(skct);	
							panel.setComponentZOrder(skct, 0);
							panel.revalidate();
							panel.repaint();
						}
					};
					ts1.schedule(tsm1, 700);
					voldmort.setHp(voldmort.getHp() -30);
					voldmort.setHplife(voldmort.getHplife() -3);
					log.append("해리 : 카운터  볼드모트 : 스매쉬\n");
					log.append("해리의 카운터!!\n볼드모트의 체력이 30 감소합니다.\n");
					log.append("볼드모트의 체력 : " + voldmort.getHp()+"\n");
					log.setCaretPosition(log.getDocument().getLength());

					Timer ts = new Timer();	
					TimerTask tsm = new TimerTask() {	

						@Override
						public void run() {
							panel.remove(vmsksmash);	
							panel.remove(skct);
							panel.add(rd[ctn]);
							panel.setComponentZOrder(rd[ctn], 0);
							panel.revalidate();
							panel.repaint();
							for(int i = 9; i>=0; i--) {
								if(i >= voldmort.getHplife()) {
									panel.remove(vmhp[i]);
								}
							}
							if(voldmort.getHp()<=0) {
								log.append("!!볼드모트를 물리쳤습니다.\n");
								new A_Music().intoBgmStop();
								new F_EffectMusic().intoBgmStop();

								switch(harry.getHplife()) {
								case 1: new B_UserManager().updateScore3(User.playerId, 100); break;
								case 2: new B_UserManager().updateScore3(User.playerId, 200); break;
								case 3: new B_UserManager().updateScore3(User.playerId, 300); break;
								case 4: new B_UserManager().updateScore3(User.playerId, 400); break;
								case 5: new B_UserManager().updateScore3(User.playerId, 500); break;
								case 6: new B_UserManager().updateScore3(User.playerId, 600); break;
								case 7: new B_UserManager().updateScore3(User.playerId, 700); break;
								case 8: new B_UserManager().updateScore3(User.playerId, 800); break;
								case 9: new B_UserManager().updateScore3(User.playerId, 900); break;
								case 10: new B_UserManager().updateScore3(User.playerId, 1000); break;
								}
								ctn = 0;
								F_ChangePanel cp = new F_ChangePanel(mf, panel);
								F_SuccessPanel sp = new F_SuccessPanel(mf);
								cp.replacePanel(sp);
							}
						}
					};
					ts.schedule(tsm, 1400);
					Timer rd1 = new Timer();	
					TimerTask rdm1 = new TimerTask() {

						@Override
						public void run() {

							panel.remove(rd[ctn]);

							panel.revalidate();
							panel.repaint();
							atk.setEnabled(true);
							df.setEnabled(true);
							smash.setEnabled(true);
							counter.setEnabled(true);
						}

					};
					rd1.schedule(rdm1, 2200); break;
				}else if(vmchoice == 3) {	//해리 : 카운터 볼드모트 : 카운터
					new F_EffectMusic().stage3_ct();
					new F_EffectMusic().stage3_vmct();
					panel.add(skct);	
					panel.add(vmskct);
					panel.setComponentZOrder(skct, 0);
					panel.setComponentZOrder(vmskct, 0);
					panel.revalidate();
					panel.repaint();
					log.append("해리 : 카운터  볼드모트 : 카운터\n");
					log.append("공격이 무효화 되었습니다.\n");
					log.setCaretPosition(log.getDocument().getLength());

					Timer ts = new Timer();	
					TimerTask tsm = new TimerTask() {	

						@Override
						public void run() {
							panel.remove(skct);	
							panel.remove(vmskct);
							panel.add(rd[ctn]);
							panel.setComponentZOrder(rd[ctn], 0);
							panel.revalidate();
							panel.repaint();
						}

					};
					ts.schedule(tsm, 1400);
					Timer rd1 = new Timer();	
					TimerTask rdm1 = new TimerTask() {

						@Override
						public void run() {

							panel.remove(rd[ctn]);

							panel.revalidate();
							panel.repaint();
							atk.setEnabled(true);
							df.setEnabled(true);
							smash.setEnabled(true);
							counter.setEnabled(true);
						}

					};
					rd1.schedule(rdm1, 2200); break;
				}

			}

		}

	}
}
