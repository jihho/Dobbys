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

import game.stage1.model.vo.D_Dementor;
import game.stage1.model.vo.D_Harry;
import game.stage1.view.D_BackgroundModify;
import view.GameStage;

public class D_Controller extends JPanel {

	private JFrame mf;
	private JPanel panel;

	public final int TIME_SLICE = 50;
	public final int MAX_DEMENTOR = 5;
	//public static int MAX_HP = ;
	
	//게임 상태 판단 변수
	public final int ST_TITLE = 0;
	public final int ST_GAME = 1;
	public final int ST_ENDING = 2;

	private int gameState;
	

	private Timer t;

	private D_Dementor[] dementor;
	private D_Harry harry;
	private D_BackgroundModify back;
	private int harryHp;

	// 배경 이미지
	private static Image backImg1 = new ImageIcon("images/stage1/stage1_bg.png").getImage().
			getScaledInstance(1300, 770, 0);
	private static Image backImg2 = new ImageIcon("images/stage1/stage1_bg.png").getImage().
			getScaledInstance(1300, 770, 0);

	// 디멘터 이미지
	private static Image deImg = new ImageIcon("images/stage1/dementor2_Move.gif").getImage().
			getScaledInstance(100, 100,	0);

	// 해리 이미지
	private static Image harryImg = new ImageIcon("images/stage1/stage1_harry.gif").getImage().
			getScaledInstance(100, 100, 0);
	
	// 해리 체력 이미지
	private static Image hpImg  = new ImageIcon("images/stage1/hpmark.png").getImage().getScaledInstance(80, 80, 0);
	
	private static Image spaceBar = new ImageIcon("images/stage1/spacebar_w.png").getImage().
			getScaledInstance(818, 64, 0);
	
	private static Image blackBack = new ImageIcon("images/stage2/bg1.png").getImage().
			getScaledInstance(1300, 770, 0);
	
	private static Image endWord = new ImageIcon("images/stage1/endWord.png").getImage().
			getScaledInstance(818, 400, 0);
	
	//이미지 이중 버퍼
	Image img;
	Graphics img_g;
	
	
	
	public D_Controller(JFrame mf) {
		this.mf = mf;
		this.setLayout(null);

		panel = this;
		this.setBounds(0, 0, 1300, 770);

		// 메인 배경 패널
		// ChangePanel cp = new ChangePanel(mf, panel);
		// Background bg = new Background(mf);
		// cp.replacePanel(bg);

		// 배경추가
		// mf.add(new Background());
		back = new D_BackgroundModify();

		t = new Timer(TIME_SLICE, new TimerHandler());
		t.start();

		this.addKeyListener(new KeyHandler());
		this.setFocusable(true);

		// 디멘터 생성
		dementor = new D_Dementor[MAX_DEMENTOR];
		for (int i = 0; i < MAX_DEMENTOR; i++) {
			dementor[i] = new D_Dementor();
		}
		
		
		hpImg = new ImageIcon("images/stage1/hpmark.png").getImage().getScaledInstance(80, 80, 0);
		
		//harry 생성
		
		harry = new D_Harry();
		harry.startHarry();

	}

	class TimerHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			
			//디멘터 생성 및 이동
			for (D_Dementor d : dementor) {
				if (d.getState() == D_Dementor.DEMENTOR_ST_DEATH) {
					//디멘터가 사라지거나 부딪쳐서 사라지면 다시 생성
					d.birth();
				}
				d.move();
				
				//디멘터 히트박스와 해리포터 히트박스 충돌 판단
				if(d.getState() == D_Dementor.DEMENTOR_ST_ALIVE && gameState == ST_GAME) {
					if(harry.getState() == D_Harry.HARRY_ST_ALIVE) {
						if(harry.getBBox().intersects(d.getBBox())) {
							d.setState(D_Dementor.DEMENTOR_ST_DEATH);
							harry.setLife(harry.getLife() - 1);
							if(harry.getLife() == 0) {
								harry.blast();
								gameState = ST_ENDING;
							}
						}
					}
				}
			}

			back.move();

			
			
			
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
		for(D_Dementor d : dementor) {
			if(d.getState() == D_Dementor.DEMENTOR_ST_ALIVE) {
				img_g.drawImage(deImg, d.getX(), d.getY(), this);
			}
			
		}
		
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
		
		public void keyPressed(KeyEvent e) {
			int code = e.getKeyCode();

			if(gameState == ST_TITLE) {
				if(code == KeyEvent.VK_SPACE) {
					gameState = ST_GAME;
					harry.startHarry();
				}
			}else if(gameState == ST_GAME) {
				//위아래로 해리 조정
				if (code == KeyEvent.VK_UP) {
					harry.moveUp();
				} else if (code == KeyEvent.VK_DOWN) {
					harry.moveDown();
				}
			}else if(gameState == ST_ENDING) {
				
				if(code == KeyEvent.VK_ENTER) {
					gameState = ST_TITLE;
				}
				if(code == KeyEvent.VK_ESCAPE) {
					D_ChangePanel cp = new D_ChangePanel(mf, panel);					
					GameStage gs = new GameStage(mf);						
					cp.replacePanel(gs);
				}
				
			}

			repaint();
		}
	}

}
