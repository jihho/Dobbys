package game.stage1.controller;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import game.stage1.model.vo.Dementor;
import game.stage1.model.vo.Harry;
import game.stage1.view.Background;
import game.stage1.view.BackgroundModify;

public class Controller extends JPanel{
	
	private JFrame mf;
	private JPanel panel;
	
	public static int TIME_SLICE = 50;
	public static int MAX_DEMENTOR = 5;
	
	private Timer t;
	private Dementor[] dementor;
	private Harry harry;
	private BackgroundModify back;
	
	public Controller(JFrame mf) {
		this.mf = mf;
		this.setLayout(null);
		
		panel = this;
		this.setBounds(0,0,1300,770);
		
		//메인 배경 패널 
//		ChangePanel cp = new ChangePanel(mf, panel);
//		Background bg = new Background(mf);
//		cp.replacePanel(bg);
		

		//배경추가
		//mf.add(new Background());
		back = new BackgroundModify();
		
		t = new Timer(TIME_SLICE, new TimerHandler());
		t.start();
		
		this.addKeyListener(new KeyHandler());
		this.setFocusable(true);
		
		
		
		//디멘터 생성
		dementor = new Dementor[MAX_DEMENTOR];
		for(int i = 0 ; i < MAX_DEMENTOR ; i++) {
			dementor[i] = new Dementor();
		}
		
		harry = new Harry();
		harry.startHarry();
		
		
	}
	
	class TimerHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			for(Dementor d : dementor) {
				if(d.getState() == Dementor.DEMENTOR_ST_DEATH) {
					d.birth();
				}
				d.move();
			}
			
			back.move();
			
			repaint();
		}
	}
	
	public void paint(Graphics g) {	
		g.clearRect(0, 0, getWidth(), getHeight());
		
		back.draw(g);
		
		for(Dementor d : dementor) {
			d.draw(g);
		}
		
		harry.draw(g);
		
		
	}
	
	
	class KeyHandler extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
			int code = e.getKeyCode();
			
			if(code == KeyEvent.VK_UP) {
				harry.moveUp();
			}else if(code == KeyEvent.VK_DOWN) {
				harry.moveDown();
			}
			
			repaint();
		}
	}
	
}
