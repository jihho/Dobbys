package game.stage2.controller;

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
import game.stage2.view.E_FailPanel;
import game.stage2.view.E_QuestPanel;
import game.stage2.view.E_SuccessPanel;
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
	
	private int ctn = 0;			//유저아이템 카운트
	private int[] userChoice;		//유저 선택값 담는 배열
	private static int MAX_HP = 3;	//유저 최대 체력
	private int hp = MAX_HP;		//유저 체력
	private int hintCtn = 0;		//힌트 카운트
	private boolean pCtn = true; 	//항아리 카운트
	private boolean btn1 = true;	//버튼 한번만 클릭 할 수 있게 설정하는 변수(아이템별로 있음)
	private boolean btn2 = true;
	private boolean btn3 = true;
	private boolean btn4 = true;
	private boolean btn5 = true;
	private boolean btn6 = true;
	private boolean btn7 = true;
	private boolean btn8 = true;
	private boolean btn9 = true;
	
	//hp 라벨변수 
	private JLabel hp1;
	private JLabel hp2;
	private JLabel hp3;
	
	//10초 지난뒤 게임 시작 페이지
	public E_GamePanel(JFrame mf) {
		
		this.mf = mf;
		this.setLayout(null);
		panel = this;
		
		//유저선택 아이템 좌표
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
		
		
		//이미지 위에 올라가면 손가락 커서로 변경
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
		home.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		
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
		
		
		//home, pot, hint 위치 설정
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
		
		
			
		
			
			//아이템 마우스 이벤트
			item1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
					//item1.setBounds(910, 115, 100, 100);
					
					if(btn1 == true) {
						
						//아이템 클릭시 효과음
						new E_EffectMusic().stage2_click();
						
						//로그창에 선택한 아이템 출력
						int x = insert[ctn].getX();
						int y = insert[ctn].getY();
						item1.setBounds(x, y, 100, 100);
						
						//퀘스트와 비교용 값 담기
						userChoice[ctn] = 1;
						System.out.println(userChoice[ctn]);
						
						btn1 = false;
						ctn++;
					}
					
					
					//재료 9개 모두 선택되면 항아리 이펙트 나오기
					if(ctn == 9 && pCtn == true) {
						System.out.println("ctn1:"+ctn);
						
						panel.add(potEffect);
						panel.setComponentZOrder(potEffect, 0);
						panel.revalidate();
						panel.repaint();
						System.out.println("항아리이펙트");
						
						//재료9개되면 끓는 소리 출력
						new E_EffectMusic().stage2_boiling();	
						pCtn = false;
						System.out.println(pCtn);
						ctn++;
						System.out.println("ctn11: " + ctn);
					}
					
					
					
					
				}
			});
		
		
		
			item2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
					//item2.setBounds(1000, 115, 100, 100);
					
					
					if(btn2 == true) {
						
						//아이템 클릭 효과음
						new E_EffectMusic().stage2_click();
						
						//로그창에 선택한 아이템 출력
						int x = insert[ctn].getX();
						int y = insert[ctn].getY();
						item2.setBounds(x, y, 100, 100);
						
						//퀘스트와 비교용 값 담기
						userChoice[ctn] = 2;
						System.out.println(userChoice[ctn]);
						
						btn2 = false;
						ctn++;		
						System.out.println("ctn2: " + ctn);
					}
					
					
					if(ctn == 9 && pCtn == true) {
						
						//재료 9개 모두 선택되면 항아리 이펙트 나오기
						panel.add(potEffect);
						panel.setComponentZOrder(potEffect, 0);
						panel.revalidate();
						panel.repaint();
						System.out.println("항아리이펙트");
						
						//재료9개되면 끓는소리출력
						new E_EffectMusic().stage2_boiling();	
						pCtn = false;
						System.out.println("항아리카운트 :" + pCtn);
						ctn++;
						
					}
					
				}
				
			});
		


		item3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				//item3.setBounds(1090, 115, 100, 100);
				
				if(btn3 == true) {
					
					//아이템 클릭시 효과음
					new E_EffectMusic().stage2_click();
					
					//로그창에 선택한 아이템 출력
					int x = insert[ctn].getX();
					int y = insert[ctn].getY();
					item3.setBounds(x, y, 100, 100);
					
					//퀘스트와 비교용 값 담기
					userChoice[ctn] = 3;
					System.out.println(userChoice[ctn]);
					
					btn3 = false;
					ctn++;	
				}
				
				if(ctn == 9 && pCtn == true) {

					//재료 9개 모두 선택되면 항아리 이펙트 나오기
					panel.add(potEffect);
					panel.setComponentZOrder(potEffect, 0);
					panel.revalidate();
					panel.repaint();
					System.out.println("항아리이펙트");

					//재료9개되면 끓는소리출력
					new E_EffectMusic().stage2_boiling();
					pCtn = false;
					ctn++;
					
				}

			}
		});



		item4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				//item4.setBounds(910, 215, 100, 100);
				
				if(btn4 == true) {
					
					//아이템 클릭시 효과음
					new E_EffectMusic().stage2_click();
					
					//로그창에 선택한 아이템 출력
					int x = insert[ctn].getX();
					int y = insert[ctn].getY();
					item4.setBounds(x, y, 100, 100);
					
					//퀘스트와 비교용 값 담기
					userChoice[ctn] = 4;
					System.out.println(userChoice[ctn]);
					
					btn4 = false;
					ctn++;
				}
				
				if(ctn == 9 && pCtn == true) {

					//재료 9개 모두 선택되면 항아리 이펙트 나오기
					panel.add(potEffect);
					panel.setComponentZOrder(potEffect, 0);
					panel.revalidate();
					panel.repaint();
					System.out.println("항아리이펙트");

					//재료9개되면 끓는소리출력
					new E_EffectMusic().stage2_boiling();	
					pCtn = false;
					ctn++;
					
				}

				
			}
		});



		item5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				//item5.setBounds(1000, 215, 100, 100);
				
				if(btn5 == true) {
					
					//아이템 클릭시 효과음
					new E_EffectMusic().stage2_click();
					
					//로그창에 선택한 아이템 출력
					int x = insert[ctn].getX();
					int y = insert[ctn].getY();
					item5.setBounds(x, y, 100, 100);
					
					//퀘스트와 비교용 값 담기
					userChoice[ctn] = 5;
					System.out.println(userChoice[ctn]);
					
					btn5 = false;
					ctn++;
				}
				
				if(ctn == 9 && pCtn == true) {

					//재료 9개 모두 선택되면 항아리 이펙트 나오기
					panel.add(potEffect);
					panel.setComponentZOrder(potEffect, 0);
					panel.revalidate();
					panel.repaint();
					System.out.println("항아리이펙트");

					//재료9개되면 끓는소리출력
					new E_EffectMusic().stage2_boiling();	
					pCtn = false;
					ctn++;
					
				}

				
			}
		});



		item6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				//item6.setBounds(1090, 215, 100, 100);
				
				if(btn6 == true) {
					
					//아이템 클릭시 효과음
					new E_EffectMusic().stage2_click();
					
					//로그창에 선택한 아이템 출력
					int x = insert[ctn].getX();
					int y = insert[ctn].getY();
					item6.setBounds(x, y, 100, 100);
					
					//퀘스트와 비교용 값 담기
					userChoice[ctn] = 6;
					System.out.println(userChoice[ctn]);
					
					btn6 = false;
					ctn++;
				}
				
				if(ctn == 9 && pCtn == true) {

					//재료 9개 모두 선택되면 항아리 이펙트 나오기
					panel.add(potEffect);
					panel.setComponentZOrder(potEffect, 0);
					panel.revalidate();
					panel.repaint();
					System.out.println("항아리이펙트");

					//재료9개되면 끓는소리출력
					new E_EffectMusic().stage2_boiling();		
					pCtn = false;
					ctn++;
					
				}

			}
		});



		item7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				//item7.setBounds(910, 305, 100, 100);
				
				if(btn7 == true) {
					
					//아이템 클릭시 효과음
					new E_EffectMusic().stage2_click();
					
					//로그창에 선택한 아이템 출력
					int x = insert[ctn].getX();
					int y = insert[ctn].getY();
					item7.setBounds(x, y, 100, 100);
					
					//퀘스트와 비교용 값 담기
					userChoice[ctn] = 7;
					System.out.println(userChoice[ctn]);
					
					btn7 = false;
					ctn++;
				}

				if(ctn == 9 && pCtn == true) {

					//재료 9개 모두 선택되면 항아리 이펙트 나오기
					panel.add(potEffect);
					panel.setComponentZOrder(potEffect, 0);
					panel.revalidate();
					panel.repaint();
					System.out.println("항아리이펙트");

					//재료9개되면 끓는소리출력
					new E_EffectMusic().stage2_boiling();	
					pCtn = false;
					ctn++;
					
				}

			}
		});



		item8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				//item8.setBounds(1000, 305, 100, 100);
				
				if(btn8 == true) {
					
					//아이템 클릭시 효과음
					new E_EffectMusic().stage2_click();
					
					//로그창에 선택한 아이템 출력
					int x = insert[ctn].getX();
					int y = insert[ctn].getY();
					item8.setBounds(x, y, 100, 100);
					
					//퀘스트와 비교용 값 담기
					userChoice[ctn] = 8;
					System.out.println(userChoice[ctn]);
					
					btn8 = false;
					ctn++;
				}
				
				if(ctn == 9 && pCtn == true) {

					//재료 9개 모두 선택되면 항아리 이펙트 나오기
					panel.add(potEffect);
					panel.setComponentZOrder(potEffect, 0);
					panel.revalidate();
					panel.repaint();
					System.out.println("항아리이펙트");

					//재료9개되면 끓는소리출력
					new E_EffectMusic().stage2_boiling();	
					pCtn = false;
					ctn++;
				}

				
			}
		});



		item9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				//item9.setBounds(1090, 305, 100, 100);
				
				if(btn9 == true) {
					
					//아이템 클릭시 효과음
					new E_EffectMusic().stage2_click();
					
					//로그창에 선택한 아이템 출력
					int x = insert[ctn].getX();
					int y = insert[ctn].getY();
					item9.setBounds(x, y, 100, 100);
					
					//퀘스트와 비교용 값 담기
					userChoice[ctn] = 9;
					System.out.println(userChoice[ctn]);
					
					btn9 = false;
					ctn++;
				}
				
				if(ctn == 9 && pCtn == true) {

					//재료 9개 모두 선택되면 항아리 이펙트 나오기
					panel.add(potEffect);
					panel.setComponentZOrder(potEffect, 0);
					panel.revalidate();
					panel.repaint();
					System.out.println("항아리이펙트");	

					//재료9개되면 끓는소리출력
					new E_EffectMusic().stage2_boiling();
					pCtn = false;
					ctn++;
					
				}

				
			}
		});


		//퀘스트 문제 불러오기
		E_Quest qq = new E_Quest();
		int[] q1 = qq.getQuest();
		
		//퀘스트 이미지 불러오기
		E_QuestPanel qp = new E_QuestPanel(mf);
		JLabel questImage = qp.getQuest();
		
		//스코어 저장용 유저 불러오기
		User user = new User();
		B_UserManager um = new B_UserManager();
		//um.updateScore1("test1", 700);
		

			//pot이벤트 -> 성공, 실패 여부 판단
			pot.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
					
					//아이템 9개 다 선택 되어야 항아리 눌리게 설정
					if(ctn == 10) {
						
						//항아리 이펙트 제거
						panel.remove(potEffect);
						panel.repaint();
						//끓는소리 효과음 제거
						new E_EffectMusic().intoBgmStop_boiling();

						if(hp == MAX_HP) {
							
							//체력 최대치일때(3) 성공시, 실패시
							for(int i = 0; i < 9; i++) {
								if(userChoice[i] == q1[i]) {
									//System.out.println("일치");

								}else {

									System.out.println("불일치");

									//틀리면 실패이팩트 출력
									panel.add(failEffect);
									panel.setComponentZOrder(failEffect, 0);
									panel.repaint();
									//실패시 폭발 효과음 
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
									
									//힌트 대기 이미지 삭제
									panel.remove(hint1);

									//재료 위치 리셋
									ctn = 0;
									btn1 = true;
									btn2 = true;
									btn3 = true;
									btn4 = true;
									btn5 = true;
									btn6 = true;
									btn7 = true;
									btn8 = true;
									btn9 = true;
									pCtn = true;
									
									item1.setBounds(75, 580, 100, 100);
									item2.setBounds(200, 580, 100, 100);
									item3.setBounds(325, 580, 100, 100);
									item4.setBounds(450, 580, 100, 100);
									item5.setBounds(575, 580, 100, 100);
									item6.setBounds(700, 580, 100, 100);
									item7.setBounds(825, 580, 100, 100);
									item8.setBounds(950, 580, 100, 100);
									item9.setBounds(1075, 580, 100, 100);
									
									//힌트를 보고싶으시면 클릭하세요 이미지 출력
									panel.add(hint2);
									panel.setComponentZOrder(hint2, 0);
									panel.repaint();
									System.out.println("힌트보실?");

									//힌트 버튼 출력
									panel.add(hint);
									panel.setComponentZOrder(hint2, 1);
									panel.repaint();

									//힌트 마우스 이벤트
									hint.addMouseListener(new MouseAdapter() {

										@Override
										public void mouseReleased(MouseEvent e) {
											
											//힌트버튼 클릭 효과음
											new E_EffectMusic().stage2_click();
											//끓는소리 효과음 제거
											//new E_EffectMusic().intoBgmStop_boiling();
											
											//힌트 버튼 클릭 횟수에 따른 이미지 교체
											hintCtn++;
											if(hintCtn == 1) {
												System.out.println("힌트카운트:" + hintCtn);
												panel.remove(hint2);

												panel.add(hint3);
												panel.setComponentZOrder(hint3, 0);
												panel.repaint();
												System.out.println("스승님");
											}
											//힌트버튼 2번 눌렀을때 로그창에 퀘스트 문제  보여주기
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
												timer2.schedule(task2, 2000);
												repaint();
											}
											//힌트버튼 3번째 클릭 했을 때 이미지 변경
											if(hintCtn == 3) {
												panel.remove(hint3);
												panel.repaint();

												panel.add(hint4);
												panel.setComponentZOrder(hint4, 0);
												panel.repaint();
											}
										}

									});
									
									//새로고침
									repaint();
									//실행 후 반복하지않게 리턴하기
									return; 
								}

								//System.out.println("일치할때만나오기:" + userChoice[i]);


							}
							
							System.out.println("다맞아요");
							
							//현재 플레이하고 있는 유저에 스코어 등록하기
							um.updateScore2(user.playerId, 1000);

							//문제 값과 유저값 일치하면 성공이미지 패널로 이동
							E_ChangePanel cp = new E_ChangePanel(mf, panel);

							E_SuccessPanel sp = new E_SuccessPanel(mf);

							cp.replacePanel(sp);
							//new A_Music().intoBgmStop();


						}


						if(hp == 2) {

							//체력 2개 남았을때 성공, 실패
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
									//실패시 폭발 효과음
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
									btn1 = true;
									btn2 = true;
									btn3 = true;
									btn4 = true;
									btn5 = true;
									btn6 = true;
									btn7 = true;
									btn8 = true;
									btn9 = true;
									pCtn = true;
									
									item1.setBounds(75, 580, 100, 100);
									item2.setBounds(200, 580, 100, 100);
									item3.setBounds(325, 580, 100, 100);
									item4.setBounds(450, 580, 100, 100);
									item5.setBounds(575, 580, 100, 100);
									item6.setBounds(700, 580, 100, 100);
									item7.setBounds(825, 580, 100, 100);
									item8.setBounds(950, 580, 100, 100);
									item9.setBounds(1075, 580, 100, 100);

									//힌트버튼 마우스 이벤트
									hint.addMouseListener(new MouseAdapter() {
										@Override
										public void mouseReleased(MouseEvent e) {
											
											//힌트 버튼 효과음
											new E_EffectMusic().stage2_click();
											//끓는소리 효과음 제거
											//new E_EffectMusic().intoBgmStop_boiling();
											
											
											panel.add(hint5);
											panel.setComponentZOrder(hint5, 0);
											panel.repaint();
										}
									});
									
									repaint();
									return;

								}
							}
							System.out.println("2번째에맞춤");

							//성공 시 현재 플레이 하고있는 유저에게 스코어 등록
							um.updateScore2(user.playerId, 700);

							//퀘스트 값과 유저선택 값이 같으면 성공패널로 이동
							E_ChangePanel cp = new E_ChangePanel(mf, panel);
							E_SuccessPanel sp = new E_SuccessPanel(mf);
							cp.replacePanel(sp);
							//new A_Music().intoBgmStop();
						}

						if(hp == 1) {
							
							//체력 1개 남았을때 성공, 실패
							for(int i = 0; i < 9; i++) {
								if(userChoice[i] == q1[i]) {
									System.out.println("일치3");

								}else {
									System.out.println("불일치3");

									//hp이미지 삭제, hp감소
									panel.remove(hp1);
									hp--;
									System.out.println("3hp:"+ hp);
									repaint();

									//재료 위치 리셋
									ctn = 0;
									btn1 = true;
									btn2 = true;
									btn3 = true;
									btn4 = true;
									btn5 = true;
									btn6 = true;
									btn7 = true;
									btn8 = true;
									btn9 = true;
									pCtn = true;
									
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
										
										//힌트버튼 마우스 이벤트
										hint.addMouseListener(new MouseAdapter() {
											@Override
											public void mouseReleased(MouseEvent e) {
												
												//힌트 클릭시 효과음
												new E_EffectMusic().stage2_click();
												
												//힌트 이미지 제거
												panel.remove(hint5);
												panel.repaint();
											}
										});
										
										//힌트 버튼 제거
										panel.remove(hint);
										panel.repaint();
										
										//유저체력0으로 실패시 현재 플레이 유저에게 스코어 등록
										um.updateScore2(user.playerId, 0);
										
										//유저체력 0으로 실패 시 실패패널로 이동
										E_ChangePanel cp = new E_ChangePanel(mf, panel);
										E_FailPanel fp = new E_FailPanel(mf);
										cp.replacePanel(fp);
										//new A_Music().intoBgmStop();
									}
									return;
								}
							}
							System.out.println("3번째에 맞춤");
							//성공시 현재 플레이 유저에게 스코어 등록
							um.updateScore2(user.playerId, 400);

							//퀘스트값과 유저값 일치하면 성공이미지 패널로 이동
							E_ChangePanel cp = new E_ChangePanel(mf, panel);
							E_SuccessPanel sp = new E_SuccessPanel(mf);
							cp.replacePanel(sp);
							//new A_Music().intoBgmStop();
						}
						
						//스코어 등록 확인용 콘솔출력
						um.printAll();	
					}

				}
			});

		
		//home 이벤트 -> 메인페이지로 이동
		home.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				//재료 9개 선택 후 끓는소리 효과음 나는데 홈으로 갈 경우 효과음 제거
				if(ctn == 10) {
					new E_EffectMusic().intoBgmStop_boiling();
				}
				//음악종료(패널 전환 전 음악을 먼저 종료해야함)
				new A_Music().intoBgmStop_stage2();
				
				//home 버튼 누르면 패널 전환
				E_ChangePanel cp = new E_ChangePanel(mf, panel);
				C_GameStage main = new C_GameStage(mf);
				cp.replacePanel(main);
				//패널 전환시 랜덤값 초기화
				E_Quest qq = new E_Quest();
				qq.setRandom(new Random().nextInt(3) + 1);
				
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
