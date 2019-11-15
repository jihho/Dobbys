package game.stage2.view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import view.C_GameStage;

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
	private int ctn = 0;		//유저아이템 카운트
	private int lCtn = 0;	//화살표왼쪽 카운트	
	private int rCtn = 0;	//화살표 오른쪽 카운트


	//10초 지난뒤 게임 시작 페이지
	public E_GamePanel(JFrame mf) {
		this.mf = mf;
		this.setLayout(null);
		panel = this;
		
		test[] choose = new test[9];
		choose[0] = new test(910, 115);
		choose[1] = new test(1000, 115);
		choose[2] = new test(1090, 115);
		choose[3] = new test(910, 215);
		choose[4] = new test(1000, 215);
		choose[5] = new test(1090, 215);
		choose[6] = new test(910, 305);
		choose[7] = new test(1000, 305);
		choose[8] = new test(1090, 305);
		
		

		JLabel label = new JLabel(new ImageIcon(new ImageIcon("images/stage2/stage2_bg2.PNG").
				getImage().getScaledInstance(1280, 720, 0)));
		label.setBounds(0, 0, 1280, 720);

		JLabel hp1 = new JLabel(new ImageIcon(new ImageIcon("images/stage2/hpmark.PNG").
				getImage().getScaledInstance(60, 80, 0) ));
		hp1.setBounds(110, 25, 120, 80);

		JLabel hp2 = new JLabel(new ImageIcon(new ImageIcon("images/stage2/hpmark.PNG").
				getImage().getScaledInstance(60, 80, 0) ));
		hp2.setBounds(180, 25, 120, 80);

		JLabel hp3 = new JLabel(new ImageIcon(new ImageIcon("images/stage2/hpmark.PNG").
				getImage().getScaledInstance(60, 80, 0) ));
		hp3.setBounds(250, 25, 120, 80);

		JLabel hp4 = new JLabel(new ImageIcon(new ImageIcon("images/stage2/hpmark.PNG").
				getImage().getScaledInstance(60, 80, 0) ));
		hp4.setBounds(320, 25, 120, 80);

		JLabel hp5 = new JLabel(new ImageIcon(new ImageIcon("images/stage2/hpmark.PNG").
				getImage().getScaledInstance(60, 80, 0) ));
		hp5.setBounds(390, 25, 120, 80);
		
		
		JButton item1 = new JButton(new ImageIcon("images/stage2/item1.PNG"));
		item1.setBounds(75, 580, 100, 100);

		//버튼 투명화
		item1.setBorderPainted(false); //외곽선 없애줌
		item1.setContentAreaFilled(false); //내용영역 채우기 안함
		item1.setFocusPainted(false);  //선택될때 생기는 테두리 사용 안함
		item1.setOpaque(false); //불투명해제

		item1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//item1.setBounds(910, 115, 100, 100);
				int x = choose[ctn].getX();
				int y = choose[ctn].getY();
				ctn++;
				
				item1.setBounds(x, y, 100, 100);
				
				
			}
		});
	

		JButton item2 = new JButton(new ImageIcon("images/stage2/item2.PNG"));
		item2.setBounds(200, 580, 100, 100);
		//item1과 사이간격 125


		item2.setBorderPainted(false); //외곽선 없애줌
		item2.setContentAreaFilled(false); //내용영역 채우기 안함
		item2.setFocusPainted(false);  //선택될때 생기는 테두리 사용 안함
		item2.setOpaque(false); //불투명해제

		item2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//item2.setBounds(1000, 115, 100, 100);
				//사이간격 90
				
				int x = choose[ctn].getX();
				int y = choose[ctn].getY();
				ctn++;			
				
				item2.setBounds(x, y, 100, 100);
			}
		});

		JButton item3 = new JButton(new ImageIcon("images/stage2/item3.PNG"));
		item3.setBounds(325, 580, 100, 100);



		item3.setBorderPainted(false); //외곽선 없애줌
		item3.setContentAreaFilled(false); //내용영역 채우기 안함
		item3.setFocusPainted(false);  //선택될때 생기는 테두리 사용 안함
		item3.setOpaque(false); //불투명해제

		item3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//item3.setBounds(1090, 115, 100, 100);
				int x = choose[ctn].getX();
				int y = choose[ctn].getY();
				ctn++;	
				
				item3.setBounds(x, y, 100, 100);
			}
		});

		JButton item4 = new JButton(new ImageIcon("images/stage2/item4.PNG"));
		item4.setBounds(450, 580, 100, 100);



		item4.setBorderPainted(false); //외곽선 없애줌
		item4.setContentAreaFilled(false); //내용영역 채우기 안함
		item4.setFocusPainted(false);  //선택될때 생기는 테두리 사용 안함
		item4.setOpaque(false); //불투명해제

		item4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//item4.setBounds(910, 215, 100, 100);
				int x = choose[ctn].getX();
				int y = choose[ctn].getY();
				
				ctn++;
				
				item4.setBounds(x, y, 100, 100);
			}
		});

		JButton item5 = new JButton(new ImageIcon("images/stage2/item5.PNG"));
		item5.setBounds(575, 580, 100, 100);



		item5.setBorderPainted(false); //외곽선 없애줌
		item5.setContentAreaFilled(false); //내용영역 채우기 안함
		item5.setFocusPainted(false);  //선택될때 생기는 테두리 사용 안함
		item5.setOpaque(false); //불투명해제

		item5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//item5.setBounds(1000, 215, 100, 100);
				int x = choose[ctn].getX();
				int y = choose[ctn].getY();
				
				ctn++;
				
				item5.setBounds(x, y, 100, 100);
				
			}
		});

		JButton item6 = new JButton(new ImageIcon("images/stage2/item6.PNG"));
		item6.setBounds(700, 580, 100, 100);



		item6.setBorderPainted(false); //외곽선 없애줌
		item6.setContentAreaFilled(false); //내용영역 채우기 안함
		item6.setFocusPainted(false);  //선택될때 생기는 테두리 사용 안함
		item6.setOpaque(false); //불투명해제

		item6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//item6.setBounds(1090, 215, 100, 100);
				int x = choose[ctn].getX();
				int y = choose[ctn].getY();
				
				ctn++;
				item6.setBounds(x, y, 100, 100);
			}
		});

		JButton item7 = new JButton(new ImageIcon("images/stage2/item7.PNG"));
		item7.setBounds(825, 580, 100, 100);



		item7.setBorderPainted(false); //외곽선 없애줌
		item7.setContentAreaFilled(false); //내용영역 채우기 안함
		item7.setFocusPainted(false);  //선택될때 생기는 테두리 사용 안함
		item7.setOpaque(false); //불투명해제

		item7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//item7.setBounds(910, 305, 100, 100);
				int x = choose[ctn].getX();
				int y = choose[ctn].getY();
				
				ctn++;
				item7.setBounds(x, y, 100, 100);
			}
		});

		JButton item8 = new JButton(new ImageIcon("images/stage2/item8.PNG"));
		item8.setBounds(950, 580, 100, 100);



		item8.setBorderPainted(false); //외곽선 없애줌
		item8.setContentAreaFilled(false); //내용영역 채우기 안함
		item8.setFocusPainted(false);  //선택될때 생기는 테두리 사용 안함
		item8.setOpaque(false); //불투명해제

		item8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//item8.setBounds(1000, 305, 100, 100);
				int x = choose[ctn].getX();
				int y = choose[ctn].getY();
				
				ctn++;
				item8.setBounds(x, y, 100, 100);
				
			}
		});

		JButton item9 = new JButton(new ImageIcon("images/stage2/item9.PNG"));
		item9.setBounds(1075, 580, 100, 100);



		item9.setBorderPainted(false); //외곽선 없애줌
		item9.setContentAreaFilled(false); //내용영역 채우기 안함
		item9.setFocusPainted(false);  //선택될때 생기는 테두리 사용 안함
		item9.setOpaque(false); //불투명해제

		item9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//item9.setBounds(1090, 305, 100, 100);
				int x = choose[ctn].getX();
				int y = choose[ctn].getY();
										
				ctn++;
				item9.setBounds(x, y, 100, 100);
				//System.out.println("총:" + ctn);
				
			}
		});

		JButton btnLeft = new JButton(new ImageIcon("images/stage2/b_left.PNG"));
		btnLeft.setBounds(300, 400, 60, 80);



		btnLeft.setBorderPainted(false); //외곽선 없애줌
		btnLeft.setContentAreaFilled(false); //내용영역 채우기 안함
		btnLeft.setFocusPainted(false);  //선택될때 생기는 테두리 사용 안함
		btnLeft.setOpaque(false); //불투명해제

		btnLeft.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lCtn++;
				System.out.println(lCtn);
			}
		});

		JButton btnRight = new JButton(new ImageIcon("images/stage2/b_right.PNG"));
		btnRight.setBounds(540, 398, 60, 80);



		btnRight.setBorderPainted(false); //외곽선 없애줌
		btnRight.setContentAreaFilled(false); //내용영역 채우기 안함
		btnRight.setFocusPainted(false);  //선택될때 생기는 테두리 사용 안함
		btnRight.setOpaque(false); //불투명해제

		btnRight.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				rCtn++;
				System.out.println(rCtn);
			}
		});
		
		JButton home = new JButton(new ImageIcon("images/stage2/home.png"));
		home.setBounds(5, 5, 50, 56);
		
		home.setContentAreaFilled(false);
		home.setFocusPainted(false);
		home.setOpaque(false);
		
		home.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				E_ChangePanel cp = new E_ChangePanel(mf, panel);
				C_GameStage main = new C_GameStage(mf);
				cp.replacePanel(main);
			}
		});
		
		JButton pot = new JButton("  ");
		
		pot.setBounds(395, 400, 110, 110);
		
		//pot.setBorderPainted(false);
		pot.setContentAreaFilled(false);
		pot.setFocusPainted(false);
		pot.setOpaque(false);
		
		pot.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		
		
		
		this.add(label);
		this.add(hp1);
		this.add(hp2);
		this.add(hp3);
		this.add(hp4);
		this.add(hp5);
		this.add(item1);
		this.add(item2);
		this.add(item3);
		this.add(item4);
		this.add(item5);
		this.add(item6);
		this.add(item7);
		this.add(item8);
		this.add(item9);
		this.add(btnLeft);
		this.add(btnRight);
		this.add(home);
		this.add(pot);
		
		
		
		
		this.setComponentZOrder(label, 18);
		
		
		
		
		
	}
}
