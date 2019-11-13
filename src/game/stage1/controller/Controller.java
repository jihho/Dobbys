package game.stage1.controller;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import game.stage1.model.vo.Dementor;
import game.stage1.view.Background;

public class Controller extends JPanel{
	
	private JFrame mf;
	private JPanel panel;
	
	public static int TIME_SLICE = 50;
	public static int MAX_DEMENTOR = 5;
	
	private Timer t;
	private Dementor[] dementor;
	
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
		mf.add(new Background());
		
		t = new Timer(TIME_SLICE, new TimerHandler());
		t.start();
		
		//디멘터 생성
		dementor = new Dementor[MAX_DEMENTOR];
		for(int i = 0 ; i < MAX_DEMENTOR ; i++) {
			dementor[i] = new Dementor();
		}
		
	}
	
	class TimerHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			for(Dementor d : dementor) {
				if(d.getState() == Dementor.DEMENTOR_ST_DEATH) {
					d.birth();
				}
				d.move();
			}
			repaint();
		}
	}
	
	public void paint(Graphics g) {	
		
		
		for(Dementor d : dementor) {
			d.draw(g);
		}
	}
	
	
	
	
}
