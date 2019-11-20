package game.stage1.controller;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import controller.B_UserManager;
import controller.C_GameStage;
import game.stage1.model.vo.D_Dementor;
import game.stage1.model.vo.D_Harry;
import game.stage1.model.vo.D_Snitch;
import game.stage1.view.D_BackgroundModify;
import game.stage1.view.D_Clear;
import model.vo.User;
import view.A_Music;


public class D_Controller extends JPanel {

	private JFrame mf;
	private JPanel panel;

	public final int TIME_SLICE = 50;
	public final int MAX_DEMENTOR = 5;
	//public static int MAX_HP = ;
	
	//이펙트 효과 시간
	public final int EFFECT_TIME = 80;
	
	//스니치 먹었을 때 더해지는 게이지 
	public final int SNITCH_SCORE = 30;
	
	//클리어 효과 시간
	public final int CLEAR_TIME = 90;
	
	//필살기 게이지 차는 시간
	public final int GAGE_SPEED = 10;
	
	//게임 상태 판단 변수
	public final int ST_TITLE = 0;
	public final int ST_GAME = 1;
	public final int ST_ENDING = 2;
	public final int ST_ALTIMATE = 3;
	public final int ST_CLEAR = 4;
	public final int ST_SCORE = 5;

	private int gameState;
	
	private boolean aliveDeath = true;

	private Timer t;

	private D_Dementor[] dementor;
	private D_Snitch snitch;
	private D_Harry harry;
	private D_BackgroundModify back;
	private int harryHp;
	private int altimateGage = 0;
	
	//stage1 점수
	private int score = 0;
	private int clearCount = CLEAR_TIME;
	private int effectCount = EFFECT_TIME;
	
	// 배경 이미지
	private Image backImg1 = new ImageIcon("images/stage1/stage1_bg.png").getImage().
			getScaledInstance(1300, 770, 0);
	private Image backImg2 = new ImageIcon("images/stage1/stage1_bg.png").getImage().
			getScaledInstance(1300, 770, 0);
	
	
	// 클리어 점수 이미지
	private Image score200 = new ImageIcon("images/stage1/score200.png").getImage().
			getScaledInstance(900, 500, 0);
	private Image score400 = new ImageIcon("images/stage1/score400.png").getImage().
			getScaledInstance(900, 500, 0);
	private Image score600 = new ImageIcon("images/stage1/score600.png").getImage().
			getScaledInstance(900, 500, 0);
	private Image score800 = new ImageIcon("images/stage1/score800.png").getImage().
			getScaledInstance(900, 500, 0);
	private Image score1000 = new ImageIcon("images/stage1/score1000.png").getImage().
			getScaledInstance(900, 500, 0);
	
	// 스니치 이미지
	private Image snitImg = new ImageIcon("images/stage1/ssni.gif").getImage().
	getScaledInstance(80, 150, 0);

	// 디멘터 이미지
	private Image deImg = new ImageIcon("images/stage1/dementor2_Move.gif").getImage().
			getScaledInstance(100, 100,	0);

	// 해리 이미지
	private Image harryImg = new ImageIcon("images/stage1/stage1_harry.gif").getImage().
			getScaledInstance(100, 100, 0);
	
	// 해리 체력 이미지
	private Image hpImg  = new ImageIcon("images/stage1/hpmark.png").getImage().getScaledInstance(80, 80, 0);
	
	// 배경 이미지
	private Image spaceBar = new ImageIcon("images/stage1/spacebar_w.png").getImage().
			getScaledInstance(818, 64, 0);
	
	private Image blackBack = new ImageIcon("images/stage2/bg1.png").getImage().
			getScaledInstance(1300, 770, 0);
	
	private Image endWord = new ImageIcon("images/stage1/endWord.png").getImage().
			getScaledInstance(818, 400, 0);
	
	//필살기 게이지
	private Image gageBar = new ImageIcon("images/stage1/gageBar_dot.png").getImage().
			getScaledInstance(850, 50, 0);
	
	//필살기 활성화 게이지
	private Image altimateBar = new ImageIcon("images/stage1/altimate_dot.png").getImage().
			getScaledInstance(10, 40, 0);
	
	//필살기 버튼
	private Image rButton = new ImageIcon("images/stage1/r_button_dot.png").getImage().
				getScaledInstance(60, 60, 0); 
	
	//필살기 활성화 된 버튼
	private Image rButtonAlti = new ImageIcon("images/stage1/altimate_R.gif").getImage().
			getScaledInstance(60 , 60, 0); 
	
	//필살기 이펙트 
	private Image altiEffect = new ImageIcon("images/stage1/harrySkill.gif").getImage().
			getScaledInstance(1300 , 500, 0); 
	
	//클리어 영상
	private Image clear = new ImageIcon("images/stage1/stage1_video.gif").getImage().
			getScaledInstance(1300 , 770, 0); 
	
	private boolean firstClear = false;
	
	//이미지 이중 버퍼
	Image img;
	Graphics img_g;
	
	//점수 넘겨주기 위한 객체 생성
	User user = new User();
	
	//배경음악
	A_Music backSound = new A_Music();
	
	
	
	
	public D_Controller(JFrame mf) {
		this.mf = mf;
		this.setLayout(null);

		panel = this;
		this.setBounds(0, 0, 1300, 770);
		
		System.out.println("스테이지1 생성");

		// 메인 배경 패널
		// ChangePanel cp = new ChangePanel(mf, panel);
		// Background bg = new Background(mf);
		// cp.replacePanel(bg);

		// 배경추가
		// mf.add(new Background());
		back = new D_BackgroundModify();

		t = new Timer(TIME_SLICE, new TimerHandler());
		t.start();
		
		

		//키리스너 추가
		mf.addKeyListener(new KeyHandler());
		
		//키리스너가 작용되게 포커스 설정
		mf.requestFocus();
		mf.setFocusable(true);

		// 디멘터 생성
		dementor = new D_Dementor[MAX_DEMENTOR];
		for (int i = 0; i < MAX_DEMENTOR; i++) {
			dementor[i] = new D_Dementor();
		}
		
		altimateGage = 0;
		
		hpImg = new ImageIcon("images/stage1/hpmark.png").getImage().getScaledInstance(80, 80, 0);
		
		//harry 생성		
		harry = new D_Harry();
		//harry.startHarry();
		
		//snitch 생성
		snitch = new D_Snitch();
		
		

	}

	class TimerHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			
			// 디멘터 생성 및 이동
			if (gameState != ST_SCORE) {
				for (D_Dementor d : dementor) {
					if (d.getState() == D_Dementor.DEMENTOR_ST_DEATH ) {
						if(aliveDeath) {
							d.birth();
						}
					}
					
					if(d.getY() > harry.getY() && harry.getState() == D_Harry.HARRY_ST_ALIVE) {
						d.yMinusMove();
					}else if(d.getY() < harry.getY() && harry.getState() == D_Harry.HARRY_ST_ALIVE) {
						d.yPlusMove();
					}else if(harry.getState() == D_Harry.HARRY_ST_ALIVE){
						d.move();						
					}

					// 디멘터 히트박스와 해리포터 히트박스 충돌 판단
					if (d.getState() == D_Dementor.DEMENTOR_ST_ALIVE && gameState == ST_GAME) {
						if (harry.getState() == D_Harry.HARRY_ST_ALIVE) {

							if (harry.getBBox().intersects(d.getBBox())) {
								d.setState(D_Dementor.DEMENTOR_ST_DEATH);
								harry.setLife(harry.getLife() - 1);
								if (harry.getLife() == 0) {
									harry.blast();
									backSound.intoBgmStop();
									backSound.stage1FailSound();
									aliveDeath = false;
									for (D_Dementor de : dementor) {
										de.setState(D_Dementor.DEMENTOR_ST_DEATH);
										
									}
									altimateGage = 0;
									effectCount = EFFECT_TIME;
									clearCount = CLEAR_TIME;
									gameState = ST_ENDING;

								}
							}

						}
					}
				}				
			}else {
				for (D_Dementor d : dementor) {
					d.setState(D_Dementor.DEMENTOR_ST_DEATH);
					aliveDeath = false;
				}
			}
			
			if(snitch.getState() == snitch.SNITCH_ST_DEATH && D_Util.prob100(1)) {
				snitch.birth();
			} 
			
			if (snitch.getState() == snitch.SNITCH_ST_ALIVE) {
				snitch.move();
				if (harry.getState() == D_Harry.HARRY_ST_ALIVE) {
					if (harry.getBBox().intersects(snitch.getBBox())) {
						snitch.setState(D_Snitch.SNITCH_ST_DEATH);
						altimateGage += SNITCH_SCORE;
					}
				}

			}
			

			back.move();

			
			//필살기 게이지 체우는 효과
			if(altimateGage < 820) {
				altimateGage += GAGE_SPEED;
			}else {
				altimateGage = 820;
			}
			
			//필살기 효과 시간
			if(effectCount > 0 && gameState == ST_ALTIMATE) {
				effectCount--;	
			}else if(effectCount == 0){				
				effectCount = EFFECT_TIME;
				gameState = ST_CLEAR;
				firstClear = true;
			}
			
			if(firstClear == true) {
				firstClear = false;
				backSound.intoBgmStop();
				D_ChangePanel cp = new D_ChangePanel(mf, panel);					
				D_Clear dc = new D_Clear(mf);						
				cp.replacePanel(dc);
			}
			
			
			//전체 다시 그리기
			repaint();
		}
	}

	public void paint(Graphics g) {	
		
		img = createImage(1300, 770);
		img_g = img.getGraphics();
		paintComponents(img_g);
		
		//버퍼에 배경추가
		img_g.drawImage(backImg1, back.getX1(), back.getY1(), this);
		img_g.drawImage(backImg2, back.getX2(), back.getY2(), this);
		
		//버퍼에 디멘터 추가
		
		
		if(gameState == ST_TITLE) {
			img_g.drawImage(blackBack, 0, 0, this);
			img_g.drawImage(spaceBar, 240, 300, this);
		}
		
		if(gameState == ST_ENDING) {
			img_g.drawImage(blackBack, 0, 0, this);
			img_g.drawImage(endWord, 240, 100, this);
		}
		
		
		//게임 시작
		if (gameState == ST_GAME) {
			//버퍼에 해리 추가
			img_g.drawImage(harryImg, harry.getX(), harry.getY(), this);
			
			// 버퍼에 hp 추가
			for (int i = 0; i < harry.getLife(); i++) {
				img_g.drawImage(hpImg, i * 50, 0, this);
			}
			
			for(D_Dementor d : dementor) {
				if(d.getState() == D_Dementor.DEMENTOR_ST_ALIVE) {
					img_g.drawImage(deImg, d.getX(), d.getY(), this);
				}
				
			}
			
			//필살기 게이지 바 추가
			img_g.drawImage(gageBar, 330, 10, this);
			
			//필살기 활성화 게이지 바 추가
			img_g.drawImage(altimateBar, 340, 15, 10 + altimateGage, 40, this);

			//필살기 버튼
			if(altimateGage < 820) {
				img_g.drawImage(rButton, 1200, 5, this);
			}else if(altimateGage == 820) {
				img_g.drawImage(rButtonAlti, 1200, 5, this);
			}					
			
			if(snitch.getState() == D_Snitch.SNITCH_ST_ALIVE) {
				img_g.drawImage(snitImg, snitch.getX(), snitch.getY(), this);
				
			}
			
		}		
		
		if(gameState == ST_ALTIMATE && effectCount > 0) {
			img_g.drawImage(blackBack, 0, 0, this);
			img_g.drawImage(altiEffect, 0, 100, this);
			
		}
		

		
		if(harry.getState() == D_Harry.HARRY_ST_BLAST) {
			for(int i = 1 ; i < harry.getCount() ; i++) {
				img_g.setColor(D_Util.randColor(128, 255));
				int x0 = D_Util.rand(-40, 40);
				int y0 = D_Util.rand(-40, 40);
				int r0 = D_Util.rand(5, 40);
				img_g.fillOval(harry.getX() - x0 + r0, harry.getY() - y0 + r0, r0, r0);
			}
			harry.setCount(harry.getCount()-1);
			if(harry.getCount() == 0) {
				harry.blast();
				aliveDeath = false;
				harry.startHarry();
			}
			
		}
		
		
		//한번에 그림
		g.drawImage(img, 0, 0, null);
		
	}

	public void update(Graphics g) {
		paint(g);
	}

	class KeyHandler extends KeyAdapter {
		
		@Override
		public void keyPressed(KeyEvent e) {
			int code = e.getKeyCode();
			//System.out.println("키리스터 생성");

			if(gameState == ST_TITLE) {
				if(code == KeyEvent.VK_SPACE) {
					harry.startHarry();
					effectCount = EFFECT_TIME;
					clearCount = CLEAR_TIME;
					altimateGage = 0;
					gameState = ST_GAME;
					aliveDeath = true;
					backSound.stage1_backgroundSound();
					score = 0;
					
				}
			}else if(gameState == ST_GAME) {
				//위아래로 해리 조정
				
				if (code == KeyEvent.VK_UP) {
					harry.moveUp();
				} else if (code == KeyEvent.VK_DOWN) {
					harry.moveDown();
				} else if( code == KeyEvent.VK_RIGHT) {
					harry.moveRight();
				} else if( code == KeyEvent.VK_LEFT) {
					harry.moveLeft();
				}
				
				if(code == KeyEvent.VK_R && altimateGage == 820) {
					gameState = ST_ALTIMATE;
					backSound.intoBgmStop();
					backSound.harrySkillSound();
					
					switch(harry.getLife()) {
					case 1: new B_UserManager().updateScore1(User.playerId, 200); break;
					case 2: new B_UserManager().updateScore1(User.playerId, 400); break;
					case 3: new B_UserManager().updateScore1(User.playerId, 600); break;
					case 4: new B_UserManager().updateScore1(User.playerId, 800); break;
					case 5: new B_UserManager().updateScore1(User.playerId, 1000); break;
					}
					new B_UserManager().printAll();
				}
				
				
			}else if(gameState == ST_ENDING) {
				//backSound.stage1FailSound();
				if(code == KeyEvent.VK_ENTER) {
					gameState = ST_TITLE;
					backSound.intoBgmStop();
					
				}
				if(code == KeyEvent.VK_ESCAPE) {
					t.stop();
					mf.setFocusable(false);
					backSound.intoBgmStop();
					D_ChangePanel cp = new D_ChangePanel(mf, panel);					
					C_GameStage gs = new C_GameStage(mf);			
					cp.replacePanel(gs);
				}				
			}
//			else if(gameState == ST_CLEAR && firstClear == true) {
//				if(code == KeyEvent.VK_Z) {
//					backSound.intoBgmStop();
//					t.stop();
//					mf.setFocusable(false);
//					//남은 hp 별로 점수 출력밑 넘겨줘야함
//					switch(harry.getLife()) {
//					case 1: new B_UserManager().updateScore1(User.playerId, 200); break;
//					case 2: new B_UserManager().updateScore1(User.playerId, 400); break;
//					case 3: new B_UserManager().updateScore1(User.playerId, 600); break;
//					case 4: new B_UserManager().updateScore1(User.playerId, 800); break;
//					case 5: new B_UserManager().updateScore1(User.playerId, 1000); break;
//					}
//					new B_UserManager().printAll();
//					firstClear = false;
//					D_ChangePanel cp = new D_ChangePanel(mf, panel);					
//					D_Clear dc = new D_Clear(mf);						
//					cp.replacePanel(dc);
//				}
//			}
			
			

			repaint();
		}
	}

}
