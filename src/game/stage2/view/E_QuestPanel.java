package game.stage2.view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//게임 퀘스트 카운트화면
public class E_QuestPanel extends JPanel{
	private JFrame mf;
	private JPanel panel;
	//private JLabel quest1;
	
	
	public E_QuestPanel(JFrame mf) {
		this.mf = mf;
		this.setLayout(null);
		
		panel = this;
		
		
		JLabel label = new JLabel(new ImageIcon(new ImageIcon("images/stage2/stage2_bg2.PNG").
				getImage().getScaledInstance(1280, 720, 0)));
		label.setBounds(0, 0, 1280, 720);
		
			
		JLabel quest1 = new JLabel(new ImageIcon(new ImageIcon("images/stage2/quest1.PNG").
				getImage().getScaledInstance(264, 275, 0)));
		quest1.setBounds(910, 130, 264, 275);
		
		//퀘스트 클릭하면 없어지기
/*		quest1.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				remove(quest1);
				repaint();
			}
		});*/
		
		
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
		
/*		item1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});*/
		
		JButton item2 = new JButton(new ImageIcon("images/stage2/item2.PNG"));
		item2.setBounds(200, 580, 100, 100);
		//item1과 사이간격 125
		
		
		item2.setBorderPainted(false); //외곽선 없애줌
		item2.setContentAreaFilled(false); //내용영역 채우기 안함
		item2.setFocusPainted(false);  //선택될때 생기는 테두리 사용 안함
		item2.setOpaque(false); //불투명해제
		
/*		item2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});*/
		
		JButton item3 = new JButton(new ImageIcon("images/stage2/item3.PNG"));
		item3.setBounds(325, 580, 100, 100);
		
		
		
		item3.setBorderPainted(false); //외곽선 없애줌
		item3.setContentAreaFilled(false); //내용영역 채우기 안함
		item3.setFocusPainted(false);  //선택될때 생기는 테두리 사용 안함
		item3.setOpaque(false); //불투명해제
		
/*		item3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});*/
		
		JButton item4 = new JButton(new ImageIcon("images/stage2/item4.PNG"));
		item4.setBounds(450, 580, 100, 100);
		
		
		
		item4.setBorderPainted(false); //외곽선 없애줌
		item4.setContentAreaFilled(false); //내용영역 채우기 안함
		item4.setFocusPainted(false);  //선택될때 생기는 테두리 사용 안함
		item4.setOpaque(false); //불투명해제
		
/*		item4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});*/
		
		JButton item5 = new JButton(new ImageIcon("images/stage2/item5.PNG"));
		item5.setBounds(575, 580, 100, 100);
		
		
		
		item5.setBorderPainted(false); //외곽선 없애줌
		item5.setContentAreaFilled(false); //내용영역 채우기 안함
		item5.setFocusPainted(false);  //선택될때 생기는 테두리 사용 안함
		item5.setOpaque(false); //불투명해제
		
/*		item5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});*/
		
		JButton item6 = new JButton(new ImageIcon("images/stage2/item6.PNG"));
		item6.setBounds(700, 580, 100, 100);
		
		
		
		item6.setBorderPainted(false); //외곽선 없애줌
		item6.setContentAreaFilled(false); //내용영역 채우기 안함
		item6.setFocusPainted(false);  //선택될때 생기는 테두리 사용 안함
		item6.setOpaque(false); //불투명해제
		
/*		item6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});*/
		
		JButton item7 = new JButton(new ImageIcon("images/stage2/item7.PNG"));
		item7.setBounds(825, 580, 100, 100);
		
		
		
		item7.setBorderPainted(false); //외곽선 없애줌
		item7.setContentAreaFilled(false); //내용영역 채우기 안함
		item7.setFocusPainted(false);  //선택될때 생기는 테두리 사용 안함
		item7.setOpaque(false); //불투명해제
		
/*		item7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});*/
		
		JButton item8 = new JButton(new ImageIcon("images/stage2/item8.PNG"));
		item8.setBounds(950, 580, 100, 100);
		
		
		
		item8.setBorderPainted(false); //외곽선 없애줌
		item8.setContentAreaFilled(false); //내용영역 채우기 안함
		item8.setFocusPainted(false);  //선택될때 생기는 테두리 사용 안함
		item8.setOpaque(false); //불투명해제
		
/*		item8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});*/
		
		JButton item9 = new JButton(new ImageIcon("images/stage2/item9.PNG"));
		item9.setBounds(1075, 580, 100, 100);
		
		
		
		item9.setBorderPainted(false); //외곽선 없애줌
		item9.setContentAreaFilled(false); //내용영역 채우기 안함
		item9.setFocusPainted(false);  //선택될때 생기는 테두리 사용 안함
		item9.setOpaque(false); //불투명해제
		
/*		item9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});*/
		
		JButton btnLeft = new JButton(new ImageIcon("images/stage2/b_left.PNG"));
		btnLeft.setBounds(300, 400, 60, 80);
		
		
		
		btnLeft.setBorderPainted(false); //외곽선 없애줌
		btnLeft.setContentAreaFilled(false); //내용영역 채우기 안함
		btnLeft.setFocusPainted(false);  //선택될때 생기는 테두리 사용 안함
		btnLeft.setOpaque(false); //불투명해제
		
		btnLeft.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
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
		this.add(quest1);
		
		this.setComponentZOrder(label, 17);//라벨을 16번째 이미지로 불러온다는것
		//System.out.println("왜안돼");
		

		

		
	}
	
}
