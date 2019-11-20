package game.stage2.view;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.B_UserManager;
import controller.C_GameStage;
import game.stage2.model.vo.E_EffectMusic;
import game.stage2.model.vo.E_Quest;
import model.vo.User;
import view.A_Music;

class test{
	//유저로그창 아이템 좌표
	private int x;
	private int y;
	
	public test(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	
}


public class E_GamePanel extends JPanel {
	
	private JFrame mf;
	private JPanel panel;
	private int ctn = 0;	//유저아이템 카운트
	private int[] userChoice;
	private static int MAX_HP = 3;
	private int hp = MAX_HP;
	private int hintCtn = 0;

	
	
	//hp 라벨변수
	private JLabel hp1;
	private JLabel hp2;
	private JLabel hp3;
	
	//10초 지난뒤 게임 시작 페이지
	
	public E_GamePanel(JFrame mf) {
		this.mf = mf;
		this.setLayout(null);
		panel = this;
		
		//선택아이템 좌표
		test[] insert = new test[9];
		insert[0] = new test(910, 115);
		insert[1] = new test(1000, 115);
		insert[2] = new test(1090, 115);
		insert[3] = new test(910, 215);
		insert[4] = new test(1000, 215);
		insert[5] = new test(1090, 215);
		insert[6] = new test(910, 305);
		insert[7] = new test(1000, 305);
		insert[8] = new test(1090, 305);
		
		//유저가 선택한 값 담기 , 퀘스트문제와 비교용
		userChoice = new int[9];
		
		
		//배경
		JLabel label = new JLabel(new ImageIcon(new ImageIcon("images/stage2/stage2_bg2.PNG").
				getImage().getScaledInstance(1280, 720, 0)));
		label.setBounds(0, 0, 1280, 720);

		//항아리 이펙트
		JLabel potEffect = new JLabel(new ImageIcon(new ImageIcon("images/stage2/stage2_effect1.gif").
				getImage().getScaledInstance(102, 29, 0)));
		potEffect.setBounds(401, 409, 102, 29);
		
		//실패시 이펙트
		JLabel failEffect = new JLabel(new ImageIcon(new ImageIcon("images/stage2/stage2_effect2.gif").
				getImage().getScaledInstance(417, 399, 0)));
		failEffect.setBounds(220, 150, 417, 399);

		//힌트 이펙트  (대기상태이펙트)
		JLabel hint1 = new JLabel(new ImageIcon(new ImageIcon("images/stage2/hint1.gif").
				getImage().getScaledInstance(122, 87, 0)));
		hint1.setBounds(173, 335, 122, 87);
		
		panel.add(hint1);
		panel.setComponentZOrder(hint1, 0);
		
		//힌트이펙트 (틀렸을때 나오는 말풍선)
		JLabel hint2 = new JLabel(new ImageIcon(new ImageIcon("images/stage2/hint2.PNG").
				getImage().getScaledInstance(246, 156, 0)));
		hint2.setBounds(150, 260, 246, 156);
		
		JLabel hint3 = new JLabel(new ImageIcon(new ImageIcon("images/stage2/hint3.png").
				getImage().getScaledInstance(246, 156, 0)));
		hint3.setBounds(150, 260, 246, 156);
		
		JLabel hint4 = new JLabel(new ImageIcon(new ImageIcon("images/stage2/hint4.png").
				getImage().getScaledInstance(246, 156, 0)));
		hint4.setBounds(150, 260, 246, 156);
		
		JLabel hint5 = new JLabel(new ImageIcon(new ImageIcon("images/stage2/hint5.png").
				getImage().getScaledInstance(246, 156, 0)));
		hint5.setBounds(150, 260, 246, 156);
		
		
		
		//버튼 변수
		JButton item1;
		JButton item2;
		JButton item3;
		JButton item4;
		JButton item5;
		JButton item6;
		JButton item7;
		JButton item8;
		JButton item9;
		JButton home;
		JButton pot;
		JButton hint;
		
		
		
		//item 이미지 삽입
		item1 = new JButton(new ImageIcon("images/stage2/item1.PNG"));
		item2 = new JButton(new ImageIcon("images/stage2/item2.PNG"));
		item3 = new JButton(new ImageIcon("images/stage2/item3.PNG"));
		item4 = new JButton(new ImageIcon("images/stage2/item4.PNG"));
		item5 = new JButton(new ImageIcon("images/stage2/item5.PNG"));
		item6 = new JButton(new ImageIcon("images/stage2/item6.PNG"));
		item7 = new JButton(new ImageIcon("images/stage2/item7.PNG"));
		item8 = new JButton(new ImageIcon("images/stage2/item8.PNG"));
		item9 = new JButton(new ImageIcon("images/stage2/item9.PNG"));

		//hp 이미지 삽입
		hp1 = new JLabel(new ImageIcon(new ImageIcon("images/stage2/hpmark.PNG").
				getImage().getScaledInstance(60, 80, 0) ));
		
		hp2 = new JLabel(new ImageIcon(new ImageIcon("images/stage2/hpmark.PNG").
				getImage().getScaledInstance(60, 80, 0) ));
		
		hp3 = new JLabel(new ImageIcon(new ImageIcon("images/stage2/hpmark.PNG").
				getImage().getScaledInstance(60, 80, 0) ));
		
		
		//home, pot, hint 버튼 이미지 삽입
		home = new JButton(new ImageIcon("images/stage2/home.png"));
		pot = new JButton("  ");
		hint = new JButton(" ");
		
		
		//버튼위에 올라가면 손가락 커서로 변경
		item1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		item2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		item3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		item4.setCursor(new Cursor(Cursor.HAND_CURSOR));
		item5.setCursor(new Cursor(Cursor.HAND_CURSOR));
		item6.setCursor(new Cursor(Cursor.HAND_CURSOR));
		item7.setCursor(new Cursor(Cursor.HAND_CURSOR));
		item8.setCursor(new Cursor(Cursor.HAND_CURSOR));
		item9.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pot.setCursor(new Cursor(Cursor.HAND_CURSOR));
		potEffect.setCursor(new Cursor(Cursor.HAND_CURSOR));
		hint.setCursor(new Cursor(Cursor.HAND_CURSOR));
		hint1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		hint2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		hint3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		hint4.setCursor(new Cursor(Cursor.HAND_CURSOR));
		hint5.setCursor(new Cursor(Cursor.HAND_CURSOR));
		

		
		//item 위치 설정 (사이 간격 125)
		item1.setBounds(75, 580, 100, 100);
		item2.setBounds(200, 580, 100, 100);
		item3.setBounds(325, 580, 100, 100);
		item4.setBounds(450, 580, 100, 100);
		item5.setBounds(575, 580, 100, 100);
		item6.setBounds(700, 580, 100, 100);
		item7.setBounds(825, 580, 100, 100);
		item8.setBounds(950, 580, 100, 100);
		item9.setBounds(1075, 580, 100, 100);

		//hp 위치 설정
		hp1.setBounds(110, 25, 120, 80);
		hp2.setBounds(180, 25, 120, 80);
		hp3.setBounds(250, 25, 120, 80);
		
		
		//home, pot 위치 설정
		home.setBounds(5, 15, 50, 56);
		pot.setBounds(375, 370, 150, 150);
		hint.setBounds(150, 260, 246, 156);
		
		

		//버튼 투명화
		item1.setBorderPainted(false); 		//외곽선 없애줌
		item1.setContentAreaFilled(false); 	//내용영역 채우기 안함
		item1.setFocusPainted(false);  		//선택될때 생기는 테두리 사용 안함
		item1.setOpaque(false); 			//불투명해제
		
		item2.setBorderPainted(false); 
		item2.setContentAreaFilled(false); 
		item2.setFocusPainted(false);  
		item2.setOpaque(false); 
		
		item3.setBorderPainted(false); 
		item3.setContentAreaFilled(false); 
		item3.setFocusPainted(false);  
		item3.setOpaque(false); 

		item4.setBorderPainted(false); 
		item4.setContentAreaFilled(false); 
		item4.setFocusPainted(false); 
		item4.setOpaque(false); 

		item5.setBorderPainted(false); 
		item5.setContentAreaFilled(false); 
		item5.setFocusPainted(false);  
		item5.setOpaque(false); 
		
		item6.setBorderPainted(false); 
		item6.setContentAreaFilled(false); 
		item6.setFocusPainted(false);  
		item6.setOpaque(false); 
		
		item7.setBorderPainted(false); 
		item7.setContentAreaFilled(false); 
		item7.setFocusPainted(false);  
		item7.setOpaque(false); 

		item8.setBorderPainted(false); 
		item8.setContentAreaFilled(false); 
		item8.setFocusPainted(false);  
		item8.setOpaque(false); 
		
		item9.setBorderPainted(false); 
		item9.setContentAreaFilled(false); 
		item9.setFocusPainted(false);  
		item9.setOpaque(false); 

		home.setContentAreaFilled(false);
		home.setFocusPainted(false);
		home.setOpaque(false);
		
		pot.setBorderPainted(false);
		pot.setContentAreaFilled(false);
		pot.setFocusPainted(false);
		pot.setOpaque(false);
		
//		hint.setBorderPainted(false);
		hint.setContentAreaFilled(false);
		hint.setFocusPainted(false);
		hint.setOpaque(false);
		

		
		
		
		
			
		//아이템 이벤트
		item1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				//item1.setBounds(910, 115, 100, 100);
				
				new E_EffectMusic().stage2_click();
				
				//로그창에 선택한 아이템 출력
				int x = insert[ctn].getX();
				int y = insert[ctn].getY();
				item1.setBounds(x, y, 100, 100);
				
				//퀘스트와 비교용 값 담기
				userChoice[ctn] = 1;
				System.out.println(userChoice[ctn]);
				ctn++;
				
				//재료 9개 모두 선택되면 항아리 이펙트 나오기
				if(ctn == 9) {
					
					panel.add(potEffect);
					panel.setComponentZOrder(potEffect, 0);
					panel.revalidate();
					panel.repaint();
					System.out.println("항아리이펙트");
					
					//재료9개되면 끓는소리출력
					new E_EffectMusic().stage2_boiling();				}
				

				
				
			}
		});
	

		item2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				//item2.setBounds(1000, 115, 100, 100);
				//사이간격 90
				
				new E_EffectMusic().stage2_click();
				
				//로그창에 선택한 아이템 출력
				int x = insert[ctn].getX();
				int y = insert[ctn].getY();
				item2.setBounds(x, y, 100, 100);
				
				userChoice[ctn] = 2;
				System.out.println(userChoice[ctn]);

				ctn++;			
				
				if(ctn == 9) {

					//재료 9개 모두 선택되면 항아리 이펙트 나오기
					panel.add(potEffect);
					panel.setComponentZOrder(potEffect, 0);
					panel.revalidate();
					panel.repaint();
					System.out.println("항아리이펙트");
					
					//재료9개되면 끓는소리출력
					new E_EffectMusic().stage2_boiling();					
				}

			}
		});



		item3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				//item3.setBounds(1090, 115, 100, 100);
				
				new E_EffectMusic().stage2_click();
				
				//로그창에 선택한 아이템 출력
				int x = insert[ctn].getX();
				int y = insert[ctn].getY();
				item3.setBounds(x, y, 100, 100);
				
				userChoice[ctn] = 3;
				System.out.println(userChoice[ctn]);

				ctn++;	
				
				if(ctn == 9) {

					//재료 9개 모두 선택되면 항아리 이펙트 나오기
					panel.add(potEffect);
					panel.setComponentZOrder(potEffect, 0);
					panel.revalidate();
					panel.repaint();
					System.out.println("항아리이펙트");
					
					//재료9개되면 끓는소리출력
					new E_EffectMusic().stage2_boiling();				}

			}
		});



		item4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				//item4.setBounds(910, 215, 100, 100);
				
				new E_EffectMusic().stage2_click();
				
				//로그창에 선택한 아이템 출력
				int x = insert[ctn].getX();
				int y = insert[ctn].getY();
				
				item4.setBounds(x, y, 100, 100);
				
				userChoice[ctn] = 4;
				System.out.println(userChoice[ctn]);

				ctn++;
				
				if(ctn == 9) {
					
					//재료 9개 모두 선택되면 항아리 이펙트 나오기
					panel.add(potEffect);
					panel.setComponentZOrder(potEffect, 0);
					panel.revalidate();
					panel.repaint();
					System.out.println("항아리이펙트");
					
					//재료9개되면 끓는소리출력
					new E_EffectMusic().stage2_boiling();				}

				
			}
		});



		item5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				//item5.setBounds(1000, 215, 100, 100);
				
				new E_EffectMusic().stage2_click();
				
				//로그창에 선택한 아이템 출력
				int x = insert[ctn].getX();
				int y = insert[ctn].getY();
				item5.setBounds(x, y, 100, 100);
				
				userChoice[ctn] = 5;
				System.out.println(userChoice[ctn]);

				ctn++;
				
				if(ctn == 9) {

					//재료 9개 모두 선택되면 항아리 이펙트 나오기
					panel.add(potEffect);
					panel.setComponentZOrder(potEffect, 0);
					panel.revalidate();
					panel.repaint();
					System.out.println("항아리이펙트");
					
					//재료9개되면 끓는소리출력
					new E_EffectMusic().stage2_boiling();				}

				
			}
		});



		item6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				//item6.setBounds(1090, 215, 100, 100);

				new E_EffectMusic().stage2_click();
				
				//로그창에 선택한 아이템 출력
				int x = insert[ctn].getX();
				int y = insert[ctn].getY();
				
				item6.setBounds(x, y, 100, 100);
				
				userChoice[ctn] = 6;
				System.out.println(userChoice[ctn]);

				ctn++;
				
				if(ctn == 9) {

					//재료 9개 모두 선택되면 항아리 이펙트 나오기
					panel.add(potEffect);
					panel.setComponentZOrder(potEffect, 0);
					panel.revalidate();
					panel.repaint();
					System.out.println("항아리이펙트");
					
					//재료9개되면 끓는소리출력
					new E_EffectMusic().stage2_boiling();				}

			}
		});



		item7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				//item7.setBounds(910, 305, 100, 100);
				
				new E_EffectMusic().stage2_click();
				
				//로그창에 선택한 아이템 출력
				int x = insert[ctn].getX();
				int y = insert[ctn].getY();
				
				item7.setBounds(x, y, 100, 100);
				
				userChoice[ctn] = 7;
				System.out.println(userChoice[ctn]);

				ctn++;
				
				if(ctn == 9) {

					//재료 9개 모두 선택되면 항아리 이펙트 나오기
					panel.add(potEffect);
					panel.setComponentZOrder(potEffect, 0);
					panel.revalidate();
					panel.repaint();
					System.out.println("항아리이펙트");
					
					//재료9개되면 끓는소리출력
					new E_EffectMusic().stage2_boiling();				}

			}
		});



		item8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				//item8.setBounds(1000, 305, 100, 100);
				
				new E_EffectMusic().stage2_click();
				
				//로그창에 선택한 아이템 출력
				int x = insert[ctn].getX();
				int y = insert[ctn].getY();
				
				item8.setBounds(x, y, 100, 100);
				
				userChoice[ctn] = 8;
				System.out.println(userChoice[ctn]);

				ctn++;
				
				if(ctn == 9) {

					//재료 9개 모두 선택되면 항아리 이펙트 나오기
					panel.add(potEffect);
					panel.setComponentZOrder(potEffect, 0);
					panel.revalidate();
					panel.repaint();
					System.out.println("항아리이펙트");
					
					//재료9개되면 끓는소리출력
					new E_EffectMusic().stage2_boiling();				}

				
			}
		});



		item9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				//item9.setBounds(1090, 305, 100, 100);
				
				new E_EffectMusic().stage2_click();
				
				//로그창에 선택한 아이템 출력
				int x = insert[ctn].getX();
				int y = insert[ctn].getY();
										
				item9.setBounds(x, y, 100, 100);
				
				userChoice[ctn] = 9;
				System.out.println(userChoice[ctn]);
				
				
				ctn++;
				
				if(ctn == 9) {

					//재료 9개 모두 선택되면 항아리 이펙트 나오기
					panel.add(potEffect);
					panel.setComponentZOrder(potEffect, 0);
					panel.revalidate();
					panel.repaint();
					System.out.println("항아리이펙트");	

					//재료9개되면 끓는소리출력
					new E_EffectMusic().stage2_boiling();				
				}

				
			}
		});


		
		
		

		//퀘스트 문제 불러오기
		E_Quest qq = new E_Quest();
		int[] q1 = qq.getQuest();
		
		E_QuestPanel qp = new E_QuestPanel(mf);
		JLabel questImage = qp.getQuest();
		
		User user = new User();
		B_UserManager um = new B_UserManager();
		//um.updateScore1("test1", 700);
		
		
		//pot이벤트 -> 성공, 실패 여부 판단
		pot.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
					panel.remove(potEffect);
					panel.repaint();
					new E_EffectMusic().intoBgmStop();
					
				if(hp == MAX_HP) {
					
					for(int i = 0; i < 9; i++) {
						if(userChoice[i] == q1[i]) {
							//System.out.println("일치");
							
						}else {
							
							System.out.println("불일치");
							
							//틀리면 실패이팩트 출력
							panel.add(failEffect);
							panel.setComponentZOrder(failEffect, 0);
							panel.repaint();
							new E_EffectMusic().stage2_fire();

							
							//hp이미지 삭제, hp감소
							panel.remove(hp3);
							hp--;
							System.out.println("hp:" + hp);
							repaint();
							
							//실패이펙트 타이머
							Timer timer = new Timer();
							TimerTask task = new TimerTask() {
								@Override
								public void run() {
									panel.remove(failEffect);
									panel.revalidate();
									panel.repaint();
								}
							};
							timer.schedule(task, 500);
							
							panel.remove(hint1);
							
							
							
							//재료 위치 리셋
							ctn = 0;
							item1.setBounds(75, 580, 100, 100);
							item2.setBounds(200, 580, 100, 100);
							item3.setBounds(325, 580, 100, 100);
							item4.setBounds(450, 580, 100, 100);
							item5.setBounds(575, 580, 100, 100);
							item6.setBounds(700, 580, 100, 100);
							item7.setBounds(825, 580, 100, 100);
							item8.setBounds(950, 580, 100, 100);
							item9.setBounds(1075, 580, 100, 100);
							
							panel.add(hint2);
							panel.setComponentZOrder(hint2, 0);
							panel.repaint();
							System.out.println("힌트보실?");
							
							
							panel.add(hint);
							panel.setComponentZOrder(hint2, 1);
							panel.repaint();
							
							
							hint.addMouseListener(new MouseAdapter() {
								
								@Override
								public void mouseReleased(MouseEvent e) {
									
									new E_EffectMusic().stage2_click();
									
									hintCtn++;
									if(hintCtn == 1) {
										System.out.println("힌트카운트:" + hintCtn);
										panel.remove(hint2);
										
										panel.add(hint3);
										panel.setComponentZOrder(hint3, 0);
										panel.repaint();
										System.out.println("스승님");
									}
									if(hintCtn == 2) {
										System.out.println("힌트카운트2:" + hintCtn);
										panel.add(questImage);
										panel.setComponentZOrder(questImage, 0);
										panel.revalidate();
										panel.repaint();
										System.out.println("힌트클릭:"+ q1 );
										
										Timer timer2 = new Timer();
										TimerTask task2 = new TimerTask() {
											@Override
											public void run() {
												panel.remove(questImage);
												panel.revalidate();
												panel.repaint();
											}
										};
										timer2.schedule(task2, 1000);
										repaint();
									}
										if(hintCtn == 3) {
										panel.remove(hint3);
										panel.repaint();
										
										panel.add(hint4);
										panel.setComponentZOrder(hint4, 0);
										panel.repaint();
									}
								}
								
							});
							

							
							repaint();
							return;
						}
						
						//System.out.println("일치할때만나오기:" + userChoice[i]);

						
					}
					System.out.println("다맞아요");
					
					um.updateScore2(user.playerId, 1000);

					//문제 값과 유저값 일치하면 성공이미지 패널로 이동
					E_ChangePanel cp = new E_ChangePanel(mf, panel);

					E_SuccessPanel sp = new E_SuccessPanel(mf);
					
					cp.replacePanel(sp);
					//new A_Music().intoBgmStop();
					

				}
				
				
				if(hp == 2) {
					
					for(int i = 0; i < 9; i++) {
						if(userChoice[i] == q1[i]) {
							System.out.println("일치2");
						}else {
							System.out.println("불일치2");
							
							//틀리면 실패 이펙트 출력
							panel.add(failEffect);
							panel.setComponentZOrder(failEffect, 0);
							panel.revalidate();
							panel.repaint();
							new E_EffectMusic().stage2_fire();

							
							//hp이미지 삭제, hp감소
							panel.remove(hp2);
							hp--;
							System.out.println("2hp:" + hp);
							repaint();
							
							//실패이펙트 타이머
							Timer timer = new Timer();
							TimerTask task = new TimerTask() {
								@Override
								public void run() {
									panel.remove(failEffect);
									panel.revalidate();
									panel.repaint();
								}
							};
							timer.schedule(task, 1000);
							
							//재료 위치 리셋
							ctn = 0;
							item1.setBounds(75, 580, 100, 100);
							item2.setBounds(200, 580, 100, 100);
							item3.setBounds(325, 580, 100, 100);
							item4.setBounds(450, 580, 100, 100);
							item5.setBounds(575, 580, 100, 100);
							item6.setBounds(700, 580, 100, 100);
							item7.setBounds(825, 580, 100, 100);
							item8.setBounds(950, 580, 100, 100);
							item9.setBounds(1075, 580, 100, 100);
							
							
							
							//if(hintCtn2 == 0) {
								
								hint.addMouseListener(new MouseAdapter() {
									@Override
									public void mouseReleased(MouseEvent e) {
										
										new E_EffectMusic().stage2_click();
										
										panel.add(hint5);
										panel.setComponentZOrder(hint5, 0);
										panel.repaint();
									}
								});
								
							//}
							
							
							
							
							repaint();
							return;
							
						}
					}
					System.out.println("2번째에맞춤");
					
					um.updateScore2(user.playerId, 700);

					//퀘스트 값과 유저선택 값이 같으면 성공패널로 이동
					E_ChangePanel cp = new E_ChangePanel(mf, panel);
					E_SuccessPanel sp = new E_SuccessPanel(mf);
					cp.replacePanel(sp);
					//new A_Music().intoBgmStop();
				}
				
				if(hp == 1) {
					
					for(int i = 0; i < 9; i++) {
						if(userChoice[i] == q1[i]) {
							System.out.println("일치3");
							
						}else {
							System.out.println("불일치3");
							
							/*//틀리면 실패 이펙트 출력
							panel.add(failEffect);
							panel.setComponentZOrder(failEffect, 0);
							panel.repaint();*/
							//new E_EffectMusic().stage2_fire();

							//hp이미지 삭제, hp감소
							panel.remove(hp1);
							hp--;
							System.out.println("3hp:"+ hp);
							repaint();
							
							//재료 위치 리셋
							ctn = 0;
							item1.setBounds(75, 580, 100, 100);
							item2.setBounds(200, 580, 100, 100);
							item3.setBounds(325, 580, 100, 100);
							item4.setBounds(450, 580, 100, 100);
							item5.setBounds(575, 580, 100, 100);
							item6.setBounds(700, 580, 100, 100);
							item7.setBounds(825, 580, 100, 100);
							item8.setBounds(950, 580, 100, 100);
							item9.setBounds(1075, 580, 100, 100);
							
							
							
							//새로고침
							repaint();
							
							//hp 0되면 실패 이미지 패널로 이동
							if(hp == 0) {
								
								hint.addMouseListener(new MouseAdapter() {
									@Override
									public void mouseReleased(MouseEvent e) {
										
										new E_EffectMusic().stage2_click();
										
										panel.remove(hint5);
										panel.repaint();
									}
								});
								
								um.updateScore2(user.playerId, 0);

								E_ChangePanel cp = new E_ChangePanel(mf, panel);
								E_FailPanel fp = new E_FailPanel(mf);
								cp.replacePanel(fp);
								//new A_Music().intoBgmStop();
							}
							return;
						}
					}
					System.out.println("3번째에 맞춤");
					um.updateScore2(user.playerId, 400);

					//퀘스트값과 유저값 일치하면 성공이미지 패널로 이동
					E_ChangePanel cp = new E_ChangePanel(mf, panel);
					E_SuccessPanel sp = new E_SuccessPanel(mf);
					cp.replacePanel(sp);
					//new A_Music().intoBgmStop();
				}
				
				um.printAll();	

				
				
						
			}
		});
		

		
		
		//home 이벤트 -> 메인페이지로 이동
		home.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				E_ChangePanel cp = new E_ChangePanel(mf, panel);
				C_GameStage main = new C_GameStage(mf);
				cp.replacePanel(main);
				E_Quest qq = new E_Quest();
				qq.setRandom(new Random().nextInt(3) + 1);
				
				//음악종료
				new A_Music().intoBgmStop();
			}
		});
		
		
		//패널에 추가하기
		

		this.add(item1);
		this.add(item2);
		this.add(item3);
		this.add(item4);
		this.add(item5);
		this.add(item6);
		this.add(item7);
		this.add(item8);
		this.add(item9);

		this.add(hp1);
		this.add(hp2);
		this.add(hp3);
		
		this.add(home);
		this.add(pot);
		//this.add(hint);
		
		this.add(label);
		
		//this.setComponentZOrder(label, 14);
		
		
		
		
		
	}
}
