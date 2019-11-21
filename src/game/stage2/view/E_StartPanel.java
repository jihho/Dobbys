package game.stage2.view;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import game.stage2.controller.E_ChangePanel;
import game.stage2.model.vo.E_EffectMusic;
import view.A_Music;

//게임 시작 화면
public class E_StartPanel extends JPanel {
	private JFrame mf;
	private JPanel panel;
	
	

	public E_StartPanel(JFrame mf) {

		//mf.setTitle("HarryPotter ~Stage2~ ");
		this.mf = mf;
		this.setLayout(null);
		
		panel = this;
		
		//배경 음악 재생
		new A_Music().stage2_BgSound();
		
/*		//마우스커서
				setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
						new ImageIcon("images/main/mouse.png").getImage(),
						new Point(0,0),"DobbyCursor"));*/
		
		//백그라운드화면
    	JLabel label = new JLabel(new ImageIcon(new ImageIcon("images/stage2/stage2_bg2.PNG").
				getImage().getScaledInstance(1280, 720, 0)));
		label.setBounds(0, 0, 1280, 720);
		
		//검정화면
		JLabel bg1 = new JLabel(new ImageIcon(new ImageIcon("images/stage2/bg1.PNG").
				getImage().getScaledInstance(1280, 720, 0)));
		bg1.setBounds(0, 0, 1280, 720);
		
		//hp이미지
		JLabel hp1 = new JLabel(new ImageIcon(new ImageIcon("images/stage2/hpmark.PNG").
				getImage().getScaledInstance(60, 80, 0) ));
		hp1.setBounds(110, 25, 120, 80);
		
		JLabel hp2 = new JLabel(new ImageIcon(new ImageIcon("images/stage2/hpmark.PNG").
				getImage().getScaledInstance(60, 80, 0) ));
		hp2.setBounds(180, 25, 120, 80);
		
		JLabel hp3 = new JLabel(new ImageIcon(new ImageIcon("images/stage2/hpmark.PNG").
				getImage().getScaledInstance(60, 80, 0) ));
		hp3.setBounds(250, 25, 120, 80);
		


		//재료이미지
		JButton item1 = new JButton(new ImageIcon("images/stage2/item1.PNG"));
		item1.setBounds(75, 580, 100, 100);
		
		
		//버튼 투명화
		item1.setBorderPainted(false); 		//외곽선 없애줌
		item1.setContentAreaFilled(false); 	//내용영역 채우기 안함
		item1.setFocusPainted(false);  		//선택될때 생기는 테두리 사용 안함
		item1.setOpaque(false); 			//불투명해제
		

		
		JButton item2 = new JButton(new ImageIcon("images/stage2/item2.PNG"));
		item2.setBounds(200, 580, 100, 100);
		//item1과 사이간격 125
				
		item2.setBorderPainted(false); 		//외곽선 없애줌
		item2.setContentAreaFilled(false); 	//내용영역 채우기 안함
		item2.setFocusPainted(false);  		//선택될때 생기는 테두리 사용 안함
		item2.setOpaque(false); 			//불투명해제
		

		
		JButton item3 = new JButton(new ImageIcon("images/stage2/item3.PNG"));
		item3.setBounds(325, 580, 100, 100);
					
		item3.setBorderPainted(false); 		//외곽선 없애줌
		item3.setContentAreaFilled(false); 	//내용영역 채우기 안함
		item3.setFocusPainted(false);  		//선택될때 생기는 테두리 사용 안함
		item3.setOpaque(false); 			//불투명해제
		

		
		JButton item4 = new JButton(new ImageIcon("images/stage2/item4.PNG"));
		item4.setBounds(450, 580, 100, 100);
		
		item4.setBorderPainted(false); 		//외곽선 없애줌
		item4.setContentAreaFilled(false); 	//내용영역 채우기 안함
		item4.setFocusPainted(false);  		//선택될때 생기는 테두리 사용 안함
		item4.setOpaque(false); 			//불투명해제
		

		
		JButton item5 = new JButton(new ImageIcon("images/stage2/item5.PNG"));
		item5.setBounds(575, 580, 100, 100);
		
		
		item5.setBorderPainted(false); 		//외곽선 없애줌
		item5.setContentAreaFilled(false); 	//내용영역 채우기 안함
		item5.setFocusPainted(false);  		//선택될때 생기는 테두리 사용 안함
		item5.setOpaque(false); 			//불투명해제
		

		
		JButton item6 = new JButton(new ImageIcon("images/stage2/item6.PNG"));
		item6.setBounds(700, 580, 100, 100);
		
		
		item6.setBorderPainted(false); 		//외곽선 없애줌
		item6.setContentAreaFilled(false); 	//내용영역 채우기 안함
		item6.setFocusPainted(false);  		//선택될때 생기는 테두리 사용 안함
		item6.setOpaque(false); 			//불투명해제
		

		
		JButton item7 = new JButton(new ImageIcon("images/stage2/item7.PNG"));
		item7.setBounds(825, 580, 100, 100);
		
		
		item7.setBorderPainted(false); 		//외곽선 없애줌
		item7.setContentAreaFilled(false); 	//내용영역 채우기 안함
		item7.setFocusPainted(false);  		//선택될때 생기는 테두리 사용 안함
		item7.setOpaque(false); 			//불투명해제
		

		
		JButton item8 = new JButton(new ImageIcon("images/stage2/item8.PNG"));
		item8.setBounds(950, 580, 100, 100);
		
		
		item8.setBorderPainted(false); 		//외곽선 없애줌
		item8.setContentAreaFilled(false);	//내용영역 채우기 안함
		item8.setFocusPainted(false); 		//선택될때 생기는 테두리 사용 안함
		item8.setOpaque(false); 			//불투명해제
		

		
		JButton item9 = new JButton(new ImageIcon("images/stage2/item9.PNG"));
		item9.setBounds(1075, 580, 100, 100);
		
		
		item9.setBorderPainted(false); 		//외곽선 없애줌
		item9.setContentAreaFilled(false); 	//내용영역 채우기 안함
		item9.setFocusPainted(false);  		//선택될때 생기는 테두리 사용 안함
		item9.setOpaque(false); 			//불투명해제
		
		
		//게임 방법 설명 이미지
		JButton rule = new JButton(new ImageIcon("images/stage2/rule3.gif"));
		rule.setBounds(300, 140, 640, 401);
		rule.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		
		
		rule.setBorderPainted(false); 		//외곽선 없애줌
		rule.setContentAreaFilled(false); 	//내용영역 채우기 안함
		rule.setFocusPainted(false);  		//선택될때 생기는 테두리 사용 안함
		rule.setOpaque(false); 				//불투명해제
		
		
		//rule 이벤트 -> QuestPanel로 이동
		rule.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
				//게임방법 이미지 클릭시 효과음
				new E_EffectMusic().stage2_clickStart();
				
				//타이머 실행 하고, 퀘스트 패널로 패널 전환
				E_ChangePanel cp = new E_ChangePanel(mf, panel);
				E_QuestPanel qp = new E_QuestPanel(mf);
				E_Timer timer = new E_Timer(mf, qp);
				Thread t1 = timer;
				t1.setDaemon(true);
				t1.start();
				cp.replacePanel(qp);
				
				
				
			}
		});
		
		//패널에 얹기
		this.add(rule);
		this.add(label);
		this.add(bg1);

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
		
		
		this.setComponentZOrder(label, 11);
		//라벨제외 14개
		
		

	}



}
	
	
	

