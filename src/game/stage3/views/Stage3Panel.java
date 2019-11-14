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

public class Stage3Panel extends JPanel{
	private JFrame mf;
	private JPanel panel;
	JLabel ef;	//스킬 이펙트 없앨때 사용할 라벨
	JLabel skill;	//스킬 이펙트 용 라벨
	JLabel sksmash;
	JLabel skdf;
	JLabel skct;
	public Stage3Panel(JFrame mf){
		this.mf = mf;
		this.setLayout(null);
		panel = this;
		
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
		JLabel hp = new JLabel(new ImageIcon(new ImageIcon("images/stage3/hp.gif").getImage().getScaledInstance(34, 35, 0)));
		hp.setBounds(190, 200, 34, 35);
		
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
		hp9.setBounds(410, 180, 23, 70);
		
		
		//볼드모트 체력 바
		JLabel bmhp = new JLabel(new ImageIcon(new ImageIcon("images/stage3/hp.gif").getImage().getScaledInstance(34, 35, 0)));
		bmhp.setBounds(1120, 200, 34, 35);
		
		JLabel bmhp0 = new JLabel(new ImageIcon(new ImageIcon("images/stage3/hpbm0.png").getImage().getScaledInstance(23, 70, 0)));
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
		bmhp9.setBounds(920, 180, 23, 70);
		
		
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
		ef = new JLabel();
		
		//스킬 이펙트 라벨
		skill  = new JLabel(new ImageIcon(new ImageIcon("images/stage3/atk2.gif").getImage().getScaledInstance(650, 200, 0)));
		sksmash  = new JLabel(new ImageIcon(new ImageIcon("images/stage3/smash1.gif").getImage().getScaledInstance(650, 200, 0)));
		skdf  = new JLabel(new ImageIcon(new ImageIcon("images/stage3/df22.gif").getImage().getScaledInstance(150, 200, 0)));
		skct  = new JLabel(new ImageIcon(new ImageIcon("images/stage3/ct2.gif").getImage().getScaledInstance(250, 200, 0)));
		
		//스킬이 가려질 수 있게 ef의 사이즈를 스킬보다 살짝 크게 
		ef.setBounds(400, 277, 700, 200);
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
		this.add(label);
		this.add(hr);
		this.add(bm);
		this.add(hp);
		this.add(hp0);
		this.add(hp1);
		this.add(hp2);
		this.add(hp3);
		this.add(hp4);
		this.add(hp5);
		this.add(hp6);
		this.add(hp7);
		this.add(hp8);
		this.add(hp9);
		
		this.add(bmhp);
		this.add(bmhp0);
		this.add(bmhp1);
		this.add(bmhp2);
		this.add(bmhp3);
		this.add(bmhp4);
		this.add(bmhp5);
		this.add(bmhp6);
		this.add(bmhp7);
		this.add(bmhp8);
		this.add(bmhp9);
		
		this.add(atk);
		this.add(df);
		this.add(smash);
		this.add(counter);
		this.add(log);
		
		//배경 라벨의 우선 순위를 가장 아래로 내림으로서 나머지 라벨 등장 
		this.setComponentZOrder(label,29);

		//마우스 이펙트 사용
		atk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {	//클릭은 동일한 위치라 인식이 안되는 경우가 종종 생기므로 Released 사용
					if(e.getSource() == atk){	//getSource를 atk버튼을 받게 함
						panel.remove(ef);	//ef 라벨 제거 
						panel.add(skill);	//skill 라벨 추가
						skill.updateUI();	//라벨 갱신해서 오류 삭제
						panel.setComponentZOrder(label, 30);	//skill라벨이 보여지기 위해 배경 라벨의 우선순위 조정

						Timer ts = new Timer();	//Timer 실행
						TimerTask tsm = new TimerTask() {	//TimerTask 실행
							
							//TimerTask로 실행할 작업 내용 Override
							@Override
							public void run() {
								panel.remove(skill);	//skill 라벨 제거 
								panel.add(ef);			//ef 라벨 추가
								ef.updateUI();			//라벨 갱신 
								panel.setComponentZOrder(label, 29);	//배경 라벨 우선순위 조정
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
						panel.remove(ef);	//ef 라벨 제거 
						panel.add(sksmash);	//skill 라벨 추가
						/*sksmash.revalidate();
						sksmash.repaint();*/
						sksmash.updateUI();	//라벨 갱신해서 오류 삭제
						panel.setComponentZOrder(label, 30);	//skill라벨이 보여지기 위해 배경 라벨의 우선순위 조정

						Timer ts = new Timer();	//Timer 실행
						TimerTask tsm = new TimerTask() {	//TimerTask 실행
							
							//TimerTask로 실행할 작업 내용 Override
							@Override
							public void run() {
								panel.remove(sksmash);	//skill 라벨 제거 
								panel.add(ef);			//ef 라벨 추가
								ef.updateUI();			//라벨 갱신 
								panel.setComponentZOrder(label, 29);	//배경 라벨 우선순위 조정
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
						panel.remove(ef);	//ef 라벨 제거 
						panel.add(skdf);	//skill 라벨 추가
						skdf.updateUI();	//라벨 갱신해서 오류 삭제
						panel.setComponentZOrder(label, 30);	//skill라벨이 보여지기 위해 배경 라벨의 우선순위 조정
						
						Timer ts = new Timer();	//Timer 실행
						TimerTask tsm = new TimerTask() {	//TimerTask 실행
							
							//TimerTask로 실행할 작업 내용 Override
							@Override
							public void run() {
								panel.remove(skdf);	//skill 라벨 제거 
								panel.add(ef);			//ef 라벨 추가
								ef.updateUI();			//라벨 갱신 
								panel.setComponentZOrder(label, 29);	//배경 라벨 우선순위 조정
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
						panel.remove(ef);	//ef 라벨 제거 
						panel.add(skct);	//skill 라벨 추가
						skct.updateUI();	//라벨 갱신해서 오류 삭제
						panel.setComponentZOrder(label, 30);	//skill라벨이 보여지기 위해 배경 라벨의 우선순위 조정

						Timer ts = new Timer();	//Timer 실행
						TimerTask tsm = new TimerTask() {	//TimerTask 실행
							
							//TimerTask로 실행할 작업 내용 Override
							@Override
							public void run() {
								panel.remove(skct);	//skill 라벨 제거 
								panel.add(ef);			//ef 라벨 추가
								ef.updateUI();			//라벨 갱신 
								panel.setComponentZOrder(label, 29);	//배경 라벨 우선순위 조정
							}

						};
						ts.schedule(tsm, 1400);	//Override에 있는 작업 시작 시간 설정 
					}
			}
		});
	}
}
