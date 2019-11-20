package game.stage3.views;

import java.awt.Color;
import java.awt.Font;
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
import game.stage3.model.vo.F_General;
import game.stage3.model.vo.F_Harry;
import game.stage3.model.vo.F_Voldmort;
import model.vo.User;
import view.A_Music;

public class F_Stage3Panel extends JPanel{
	private JFrame mf;
	private JPanel panel;
	//JLabel ef;	//스킬 이펙트 없앨때 사용할 라벨
	private static JLabel label = new JLabel(new ImageIcon(new ImageIcon("images/stage3/stage03.png").getImage()));
	private static JLabel hr = new JLabel(new ImageIcon(new ImageIcon("images/stage3/harry.png").getImage().getScaledInstance(225, 225, 0)));
	private static JLabel bm = new JLabel(new ImageIcon(new ImageIcon("images/stage3/boldemote.png").getImage().getScaledInstance(225, 225, 0)));
	private static JLabel hpbar = new JLabel(new ImageIcon(new ImageIcon("images/stage3/hp.gif").getImage().getScaledInstance(34, 35, 0)));
	private static Image hpimg = new ImageIcon("images/stage3/hp0.png").getImage().getScaledInstance(23, 70, 0);
	private static Image hpimg1 = new ImageIcon("images/stage3/hpp.png").getImage().getScaledInstance(23, 70, 0);
	private static Image vmimg = new ImageIcon("images/stage3/hpbm0.png").getImage().getScaledInstance(23, 70, 0);
	private static JLabel bmhp = new JLabel(new ImageIcon(new ImageIcon("images/stage3/hp.gif").getImage().getScaledInstance(34, 35, 0)));
	
	
	//스킬 이펙트 용 라벨
	private static JLabel skill  = new JLabel(new ImageIcon(new ImageIcon("images/stage3/atk2.gif").getImage().getScaledInstance(650, 200, 0)));
	private static JLabel sksmash  = new JLabel(new ImageIcon(new ImageIcon("images/stage3/smash1.gif").getImage().getScaledInstance(650, 200, 0)));
	private static JLabel skdf  = new JLabel(new ImageIcon(new ImageIcon("images/stage3/df22.gif").getImage().getScaledInstance(150, 200, 0)));
	private static JLabel skct  = new JLabel(new ImageIcon(new ImageIcon("images/stage3/ct2.gif").getImage().getScaledInstance(250, 200, 0)));
	
	private static JLabel vmskill = new JLabel(new ImageIcon(new ImageIcon("images/stage3/atk1.gif").getImage().getScaledInstance(650, 200, 0)));
	private static JLabel vmsksmash = new JLabel(new ImageIcon(new ImageIcon("images/stage3/smash2.gif").getImage().getScaledInstance(650, 200, 0)));
	private static JLabel vmskdf = new JLabel(new ImageIcon(new ImageIcon("images/stage3/df2.gif").getImage().getScaledInstance(150, 200, 0)));
	private static JLabel vmskct = new JLabel(new ImageIcon(new ImageIcon("images/stage3/ct1.gif").getImage().getScaledInstance(250, 200, 0)));

	private static JTextArea log;
	private static JScrollPane sc;
	
	private static JButton atk = new JButton(new ImageIcon("images/stage3/atk.png"));
	private static JButton df = new JButton(new ImageIcon("images/stage3/df.png"));
	private static JButton smash = new JButton(new ImageIcon("images/stage3/smash.png"));
	private static JButton counter = new JButton(new ImageIcon("images/stage3/counter.png"));


	private F_General harry = new F_Harry(100, 10, 20, 30, 10);	//체력, 공격, 스매쉬, 카운터, 체력 칸
	private F_General voldmort = new F_Voldmort(100, 10, 20, 30, 10);

	private JLabel[] hp = new JLabel[10];
	private JLabel[] vmhp = new JLabel[10];
	
	int harryChoice = 0;
	
	
	public F_Stage3Panel(JFrame mf){
		this.mf = mf;
		this.setLayout(null);
		panel = this;
		this.setBounds(0, 0, 1280, 720);
		new A_Music().stage3_backgroundSound();
		//스테이지 배경 라벨로 올림
		//JLabel label = new JLabel(new ImageIcon(new ImageIcon("images/stage3/stage03.png").getImage()));
		label.setBounds(0, 0, 1280, 720);

		//해리포터 캐릭터 라벨
		//JLabel hr = new JLabel(new ImageIcon(new ImageIcon("images/stage3/harry.png").getImage().getScaledInstance(225, 225, 0)));
		hr.setBounds(191, 277, 225, 225);

		//볼드모트 캐릭터 라벨
		//JLabel bm = new JLabel(new ImageIcon(new ImageIcon("images/stage3/boldemote.png").getImage().getScaledInstance(225, 225, 0)));
		bm.setBounds(921, 277, 225, 225);

		//해리포터 체력 바
		//JLabel hpbar = new JLabel(new ImageIcon(new ImageIcon("images/stage3/hp.gif").getImage().getScaledInstance(34, 35, 0)));
		hpbar.setBounds(190, 200, 34, 35);
		//img_g.drawImage(deImg, d.getX(), d.getY(), this);
		hp[0] = new JLabel(new ImageIcon(hpimg));
		hp[0].setBounds(230, 180, 23, 70);
		hp[1] = new JLabel(new ImageIcon(hpimg1));
		hp[1].setBounds(250, 180, 23, 70);
		hp[2] = new JLabel(new ImageIcon(hpimg1));
		hp[2].setBounds(270, 180, 23, 70);
		hp[3] = new JLabel(new ImageIcon(hpimg1));
		hp[3].setBounds(290, 180, 23, 70);
		hp[4] = new JLabel(new ImageIcon(hpimg1));
		hp[4].setBounds(310, 180, 23, 70);
		hp[5] = new JLabel(new ImageIcon(hpimg1));
		hp[5].setBounds(330, 180, 23, 70);
		hp[6] = new JLabel(new ImageIcon(hpimg1));
		hp[6].setBounds(350, 180, 23, 70);
		hp[7] = new JLabel(new ImageIcon(hpimg1));
		hp[7].setBounds(370, 180, 23, 70);
		hp[8] = new JLabel(new ImageIcon(hpimg1));
		hp[8].setBounds(390, 180, 23, 70);
		hp[9] = new JLabel(new ImageIcon(hpimg1));
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
		//JLabel bmhp = new JLabel(new ImageIcon(new ImageIcon("images/stage3/hp.gif").getImage().getScaledInstance(34, 35, 0)));
		bmhp.setBounds(1120, 200, 34, 35);

		vmhp[0] = new JLabel(new ImageIcon(vmimg));
		vmhp[0].setBounds(1100, 180, 23, 70);
		vmhp[1] = new JLabel(new ImageIcon(hpimg1));
		vmhp[1].setBounds(1080, 180, 23, 70);
		vmhp[2] = new JLabel(new ImageIcon(hpimg1));
		vmhp[2].setBounds(1060, 180, 23, 70);
		vmhp[3] = new JLabel(new ImageIcon(hpimg1));
		vmhp[3].setBounds(1040, 180, 23, 70);
		vmhp[4] = new JLabel(new ImageIcon(hpimg1));
		vmhp[4].setBounds(1020, 180, 23, 70);
		vmhp[5] = new JLabel(new ImageIcon(hpimg1));
		vmhp[5].setBounds(1000, 180, 23, 70);
		vmhp[6] = new JLabel(new ImageIcon(hpimg1));
		vmhp[6].setBounds(980, 180, 23, 70);
		vmhp[7] = new JLabel(new ImageIcon(hpimg1));
		vmhp[7].setBounds(960, 180, 23, 70);
		vmhp[8] = new JLabel(new ImageIcon(hpimg1));
		vmhp[8].setBounds(940, 180, 23, 70);
		vmhp[9] = new JLabel(new ImageIcon(hpimg1));
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

		ActionClass actionEvent = new ActionClass();
		atk.addActionListener(actionEvent);
		df.addActionListener(actionEvent);
		smash.addActionListener(actionEvent);
		counter.addActionListener(actionEvent);

		atk.setActionCommand("1");
		df.setActionCommand("2");
		smash.setActionCommand("3");
		counter.setActionCommand("4");
		//공격 버튼
		atk.setBounds(40, 530, 186, 81);

		//디펜스 버튼
		df.setBounds(270, 530, 186, 81);

		//스매쉬 버튼
		smash.setBounds(40, 620, 186, 81);

		//카운터 버튼
		counter.setBounds(270, 620, 186, 81);

		//로그 텍스트에어리어
		log = new JTextArea();
		sc = new JScrollPane(log);
		sc.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		sc.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		log.setLineWrap(true);
		sc.setBounds(610, 520, 620, 190);
		sc.setVisible(true);
		//log.setBounds(610, 520, 620, 180);
		log.setFont(new Font("DungGeunMo", Font.PLAIN, 34));
		sc.getViewport().getView().setBackground(new Color(135, 125, 106));
		//log.setBackground(new Color(135, 125, 106));
		log.setOpaque(true);
		//log.selectAll();
		this.add(sc);
		
		//this.add(log);
		//panel.add(scrollPane);

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
		
		//textArea.setText(textArea.getText() + String.valueOf((char)paramInt));
		
		/*JTextArea textArea = new JTextArea(50, 10);
		PrintStream printStream = new PrintStream(new CustomOutputStream(textArea));
		System.setOut(printStream);
		System.setErr(printStream);*/
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

		//볼드모트 스킬 이펙트 라벨
		

		//스킬이 가려질 수 있게 ef의 사이즈를 스킬보다 살짝 크게 
		//ef.setBounds(400, 277, 700, 200);
		skill.setBounds(440, 277, 650, 200);
		sksmash.setBounds(440, 277, 650, 200);
		skdf.setBounds(440, 237, 150, 250);
		skct.setBounds(400, 277, 250, 200);

		vmskill.setBounds(440, 277, 650, 200);
		vmsksmash.setBounds(440, 277, 650, 200);
		vmskdf.setBounds(800, 237, 150, 250);
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

		panel.add(hr);
		panel.add(bm);
		panel.add(success);
		panel.add(fail);
		panel.add(hpbar);
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

		panel.add(bmhp);
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

		//라벨을 가장 마지막에 추가함으로서 자동적으로 우선순위를 최 하위로 변경
		//setComponentZOrder를 여기서 사용할 필요 없게 됨
		
	


		//배경 라벨의 우선 순위를 가장 아래로 내림으로서 나머지 라벨 등장 
		//this.setComponentZOrder(label,29);
		//log.setCaretPosition(log.getDocument().getLength());
		log.append("버튼을 선택해주세요\n");
		//볼드모트의 선택이 될 랜덤 수
		this.add(label);

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
				
				F_ChangePanel cp = new F_ChangePanel(mf, panel);
				F_SuccessPanel sp = new F_SuccessPanel(mf);
				cp.replacePanel(sp);
			}
		});
		
		fail.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				new A_Music().intoBgmStop();
				F_ChangePanel cp = new F_ChangePanel(mf, panel);
				F_FailPanel fp = new F_FailPanel(mf);
				cp.replacePanel(fp);
			}
		});

	}
	
	class ActionClass implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			int action = Integer.parseInt(e.getActionCommand());
			int vmchoice = (int)(Math.random()*4);
			
			switch(action) {
			
			case 1: 
				atk.setEnabled(false);
				df.setEnabled(false);
				smash.setEnabled(false);
				counter.setEnabled(false);
				
				if(vmchoice == 0 || vmchoice == 1 || vmchoice == 2) {
					new F_EffectMusic().stage3_atk();
					new F_EffectMusic().stage3_vmdf();
					
					panel.add(skill);
					panel.add(vmskdf);
					
					panel.setComponentZOrder(skill, 0);
					panel.setComponentZOrder(vmskdf, 0);
					//panel.revalidate();
					panel.repaint();
					log.append("공격이 무효화 되었습니다.\n");
					log.setCaretPosition(log.getDocument().getLength());
					Timer ts = new Timer();	//Timer 실행
					TimerTask tsm = new TimerTask() {	//TimerTask 실행

						//TimerTask로 실행할 작업 내용 Override
						@Override
						public void run() {
							panel.remove(skill);	//skill 라벨 제거 
							panel.remove(vmskdf);
							//panel.revalidate();
							panel.repaint();
							//panel.add(ef);			//ef 라벨 추가
							//ef.updateUI();			//라벨 갱신 
							//panel.setComponentZOrder(label, 29);	//배경 라벨 우선순위 조정
							/*F_ChangePanel ap = new F_ChangePanel(mf, panel);
							F_RoundPanel rp = new F_RoundPanel(mf);
							ap.replacePanel(rp);*/
							atk.setEnabled(true);
							df.setEnabled(true);
							smash.setEnabled(true);
							counter.setEnabled(true);
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
								
								F_ChangePanel cp = new F_ChangePanel(mf, panel);
								F_SuccessPanel sp = new F_SuccessPanel(mf);
								cp.replacePanel(sp);
							}
						}
					};
					ts.schedule(tsm, 1400);
				}else if(vmchoice == 3) {
					new F_EffectMusic().stage3_vmatk();
					panel.add(skill);
					panel.setComponentZOrder(skill, 0);
					//panel.revalidate();
					panel.repaint();

					voldmort.setHp(voldmort.getHp() -10);
					voldmort.setHplife(voldmort.getHplife() -1);
					log.append("공격 성공!!\n볼드모트의 체력이 10 감소합니다.\n");
					log.append("볼드모트의 체력 : " + voldmort.getHp()+"\n");
					log.setCaretPosition(log.getDocument().getLength());
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
							//panel.revalidate();
							panel.repaint();
							atk.setEnabled(true);
							df.setEnabled(true);
							smash.setEnabled(true);
							counter.setEnabled(true);
							/*F_ChangePanel ap = new F_ChangePanel(mf, panel);
							F_RoundPanel rp = new F_RoundPanel(mf);
							ap.replacePanel(rp);*/
							//panel.add(ef);			//ef 라벨 추가
							//ef.updateUI();			//라벨 갱신 
							//panel.setComponentZOrder(label, 29);	//배경 라벨 우선순위 조정
							if(voldmort.getHp()<=0) {
								log.append("!!!!!볼드모트를 물리쳤습니다.\n");
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
								
								F_ChangePanel cp = new F_ChangePanel(mf, panel);
								F_SuccessPanel sp = new F_SuccessPanel(mf);
								cp.replacePanel(sp);
							}
						}


					};
					ts.schedule(tsm, 1400);
				}
				break;
				
			case 2 : 
				atk.setEnabled(false);
				df.setEnabled(false);
				smash.setEnabled(false);
				counter.setEnabled(false);
				
				new F_EffectMusic().stage3_df();
				if(vmchoice == 0 || vmchoice == 1 || vmchoice == 3) {
					panel.add(skdf);	//skill 라벨 추가
					panel.add(vmskill);
					panel.revalidate();
					panel.repaint();
					panel.setComponentZOrder(skdf, 0);
					panel.setComponentZOrder(vmskill, 0);
					log.append("공격이 무효화 되었습니다.\n");
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
							atk.setEnabled(true);
							df.setEnabled(true);
							smash.setEnabled(true);
							counter.setEnabled(true);
							//panel.add(ef);			//ef 라벨 추가
							//ef.updateUI();			//라벨 갱신 
							//panel.setComponentZOrder(label, 29);	//배경 라벨 우선순위 조정
							if(harry.getHp()<=0){
								log.append("재도전하시겠습니까?");
								new A_Music().intoBgmStop();
								new F_EffectMusic().intoBgmStop();
								F_ChangePanel cp = new F_ChangePanel(mf, panel);
								F_FailPanel fp = new F_FailPanel(mf);
								cp.replacePanel(fp);
							}
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
					log.append("볼드모트의 스매쉬!!\n해리포터의 체력이 20 감소합니다.\n");
					log.append("해리의 체력 : " + harry.getHp()+"\n");
					log.setCaretPosition(log.getDocument().getLength());
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
							atk.setEnabled(true);
							df.setEnabled(true);
							smash.setEnabled(true);
							counter.setEnabled(true);
							//panel.add(ef);			//ef 라벨 추가
							//ef.updateUI();			//라벨 갱신 
							//panel.setComponentZOrder(label, 29);	//배경 라벨 우선순위 조정
							if(harry.getHp()<=0){
								log.append("재도전하시겠습니까?");
								new A_Music().intoBgmStop();
								new F_EffectMusic().intoBgmStop();
								F_ChangePanel cp = new F_ChangePanel(mf, panel);
								F_FailPanel fp = new F_FailPanel(mf);
								cp.replacePanel(fp);
							}
						}

					};
					ts.schedule(tsm, 1400);
				}
				break;
				
			case 3 : 
				atk.setEnabled(false);
				df.setEnabled(false);
				smash.setEnabled(false);
				counter.setEnabled(false);
				if(vmchoice == 0 || vmchoice == 2) {
					new F_EffectMusic().stage3_vmsmash();
					panel.add(sksmash);
					panel.add(vmskdf);
					panel.setComponentZOrder(sksmash, 0);
					panel.setComponentZOrder(vmskdf, 0);
					panel.revalidate();
					panel.repaint();
					log.append("공격이 무효화 되었습니다.\n");
					log.setCaretPosition(log.getDocument().getLength());
					Timer ts = new Timer();	//Timer 실행
					TimerTask tsm = new TimerTask() {	//TimerTask 실행

						//TimerTask로 실행할 작업 내용 Override
						@Override
						public void run() {
							panel.remove(sksmash);	//skill 라벨 제거 
							panel.remove(vmskdf);
							panel.revalidate();
							panel.repaint();
							atk.setEnabled(true);
							df.setEnabled(true);
							smash.setEnabled(true);
							counter.setEnabled(true);
							//panel.add(ef);			//ef 라벨 추가
							//ef.updateUI();			//라벨 갱신 
							//panel.setComponentZOrder(label, 29);	//배경 라벨 우선순위 조정
							if(voldmort.getHp()<=0) {
								log.append("!!!!볼드모트를 물리쳤습니다.");
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
								
								F_ChangePanel cp = new F_ChangePanel(mf, panel);
								F_SuccessPanel sp = new F_SuccessPanel(mf);
								cp.replacePanel(sp);
							}
							if(harry.getHp()<=0){
								log.append("재도전하시겠습니까?");
								new A_Music().intoBgmStop();
								new F_EffectMusic().intoBgmStop();
								F_ChangePanel cp = new F_ChangePanel(mf, panel);
								F_FailPanel fp = new F_FailPanel(mf);
								cp.replacePanel(fp);
							}
						}
					};
					ts.schedule(tsm, 1400);
				}else if(vmchoice == 1) {
					new F_EffectMusic().stage3_smash();
					panel.add(sksmash);	//skill 라벨 추가
					panel.revalidate();
					panel.repaint();
					panel.setComponentZOrder(sksmash, 0);
					voldmort.setHp(voldmort.getHp() -20);
					voldmort.setHplife(voldmort.getHplife() -2);
					log.append("공격 성공!!\n볼드모트의 체력이 20 감소합니다.\n");
					log.append("볼드모트의 체력 : " + voldmort.getHp()+"\n");
					log.setCaretPosition(log.getDocument().getLength());
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
							atk.setEnabled(true);
							df.setEnabled(true);
							smash.setEnabled(true);
							counter.setEnabled(true);
							//panel.add(ef);			//ef 라벨 추가
							//ef.updateUI();			//라벨 갱신 
							//panel.setComponentZOrder(label, 29);	//배경 라벨 우선순위 조정
							if(voldmort.getHp()<=0) {
								log.append("!!!!볼드모트를 물리쳤습니다.");
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
								
								F_ChangePanel cp = new F_ChangePanel(mf, panel);
								F_SuccessPanel sp = new F_SuccessPanel(mf);
								cp.replacePanel(sp);
							}
							if(harry.getHp()<=0){
								log.append("재도전하시겠습니까?");
								new A_Music().intoBgmStop();
								new F_EffectMusic().intoBgmStop();
								F_ChangePanel cp = new F_ChangePanel(mf, panel);
								F_FailPanel fp = new F_FailPanel(mf);
								cp.replacePanel(fp);
							}
						}

					};
					ts.schedule(tsm, 1400);	//Override에 있는 작업 시작 시간 설정 
				}else if(vmchoice == 3) {
					new F_EffectMusic().stage3_vmct();
					panel.add(vmsksmash);	//skill 라벨 추가
					panel.revalidate();
					panel.repaint();
					panel.setComponentZOrder(vmsksmash, 0);
					harry.setHp(harry.getHp() -30);
					harry.setHplife(harry.getHplife() -3);
					log.append("볼드모트의 카운터!\n해리포터의 체력이 30 감소합니다.\n");
					log.append("해리의 체력 : " + harry.getHp()+"\n");
					log.setCaretPosition(log.getDocument().getLength());
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
							atk.setEnabled(true);
							df.setEnabled(true);
							smash.setEnabled(true);
							counter.setEnabled(true);
							//panel.add(ef);			//ef 라벨 추가
							//ef.updateUI();			//라벨 갱신 
							//panel.setComponentZOrder(label, 29);	//배경 라벨 우선순위 조정
							if(voldmort.getHp()<=0) {
								log.append("!!!!볼드모트를 물리쳤습니다.");
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
								
								F_ChangePanel cp = new F_ChangePanel(mf, panel);
								F_SuccessPanel sp = new F_SuccessPanel(mf);
								cp.replacePanel(sp);
							}
							if(harry.getHp()<=0){
								log.append("재도전하시겠습니까?");
								new A_Music().intoBgmStop();
								new F_EffectMusic().intoBgmStop();
								F_ChangePanel cp = new F_ChangePanel(mf, panel);
								F_FailPanel fp = new F_FailPanel(mf);
								cp.replacePanel(fp);
							}
						}

					};
					ts.schedule(tsm, 1400);	//Override에 있는 작업 시작 시간 설정 
				}
				
				break;
				
			case 4 : 
				atk.setEnabled(false);
				df.setEnabled(false);
				smash.setEnabled(false);
				counter.setEnabled(false);
				new F_EffectMusic().stage3_ct();
				if(vmchoice == 0) {
					panel.add(skct);	//skill 라벨 추가
					panel.add(vmskill);
					panel.setComponentZOrder(skct, 0);
					panel.setComponentZOrder(vmskill, 0);
					panel.revalidate();
					panel.repaint();
					harry.setHp(harry.getHp() -10);
					harry.setHplife(harry.getHplife() -1);
					log.append("볼드모트의 공격!!\n해리포터의 체력이 10 감소합니다.\n");
					log.append("해리의 체력 : " + harry.getHp()+"\n");
					log.setCaretPosition(log.getDocument().getLength());
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
							atk.setEnabled(true);
							df.setEnabled(true);
							smash.setEnabled(true);
							counter.setEnabled(true);
							//panel.add(ef);			//ef 라벨 추가
							//ef.updateUI();			//라벨 갱신 
							//panel.setComponentZOrder(label, 29);	//배경 라벨 우선순위 조정
							if(voldmort.getHp()<=0) {
								log.append("!!!!볼드모트를 물리쳤습니다.");
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
								
								F_ChangePanel cp = new F_ChangePanel(mf, panel);
								F_SuccessPanel sp = new F_SuccessPanel(mf);
								cp.replacePanel(sp);
							}
							if(harry.getHp()<=0){
								log.append("재도전하시겠습니까?");
								new A_Music().intoBgmStop();
								new F_EffectMusic().intoBgmStop();
								F_ChangePanel cp = new F_ChangePanel(mf, panel);
								F_FailPanel fp = new F_FailPanel(mf);
								cp.replacePanel(fp);
							}
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
					log.append("공격이 무효화 되었습니다.\n");
					log.setCaretPosition(log.getDocument().getLength());
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
							atk.setEnabled(true);
							df.setEnabled(true);
							smash.setEnabled(true);
							counter.setEnabled(true);
							//panel.add(ef);			//ef 라벨 추가
							//ef.updateUI();			//라벨 갱신 
							//panel.setComponentZOrder(label, 29);	//배경 라벨 우선순위 조정
							if(voldmort.getHp()<=0) {
								log.append("!!!!볼드모트를 물리쳤습니다.");
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
								
								F_ChangePanel cp = new F_ChangePanel(mf, panel);
								F_SuccessPanel sp = new F_SuccessPanel(mf);
								cp.replacePanel(sp);
							}
							if(harry.getHp()<=0){
								log.append("재도전하시겠습니까?");
								new A_Music().intoBgmStop();
								new F_EffectMusic().intoBgmStop();
								F_ChangePanel cp = new F_ChangePanel(mf, panel);
								F_FailPanel fp = new F_FailPanel(mf);
								cp.replacePanel(fp);
							}
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
					log.append("해리의 카운터!!\n볼드모트의 체력이 30 감소합니다.\n");
					log.append("볼드모트의 체력 : " + voldmort.getHp()+"\n");
					log.setCaretPosition(log.getDocument().getLength());
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
							atk.setEnabled(true);
							df.setEnabled(true);
							smash.setEnabled(true);
							counter.setEnabled(true);
							//panel.add(ef);			//ef 라벨 추가
							//ef.updateUI();			//라벨 갱신 
							//panel.setComponentZOrder(label, 29);	//배경 라벨 우선순위 조정
							if(voldmort.getHp()<=0) {
								log.append("!!!!볼드모트를 물리쳤습니다.");
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
								
								F_ChangePanel cp = new F_ChangePanel(mf, panel);
								F_SuccessPanel sp = new F_SuccessPanel(mf);
								cp.replacePanel(sp);
							}
							if(harry.getHp()<=0){
								log.append("재도전하시겠습니까?");
								new A_Music().intoBgmStop();
								new F_EffectMusic().intoBgmStop();
								F_ChangePanel cp = new F_ChangePanel(mf, panel);
								F_FailPanel fp = new F_FailPanel(mf);
								cp.replacePanel(fp);
							}
						}
					};
					ts.schedule(tsm, 1400);
				}
				break;
				
			}
		}
		
	}
}
