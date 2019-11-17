package game.stage2.view;

import java.net.URL;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//게임 퀘스트 카운트화면(문제나오는 화면)
public class E_QuestPanel extends JPanel{
	private JFrame mf;
	private JPanel panel;
	private int random = new Random().nextInt(3) + 1;
	private String rQuest;	//퀘스트랜덤출력
	private int[] q1;
	private int[] q2;
	private int[] q3;
			


/*
	public int getRandom() {
		return random;
	}



	public void setRandom(int random) {
		this.random = random;
	}



	public E_QuestPanel(int random) {
		
		this.random = random;
	}
*/


	
	public E_QuestPanel(JFrame mf) {
		this.mf = mf;
		this.setLayout(null);
		
		panel = this;
		
		
		
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
		

		
		
		JButton item1 = new JButton(new ImageIcon("images/stage2/item1.PNG"));
		item1.setBounds(75, 580, 100, 100);
		
		
		//버튼 투명화
		item1.setBorderPainted(false); 		//외곽선 없애줌
		item1.setContentAreaFilled(false);  //내용영역 채우기 안함
		item1.setFocusPainted(false);  		//선택될때 생기는 테두리 사용 안함
		item1.setOpaque(false); 			//불투명해제
		

		
		JButton item2 = new JButton(new ImageIcon("images/stage2/item2.PNG"));
		item2.setBounds(200, 580, 100, 100);
		//item1과 사이간격 125
		
		
		item2.setBorderPainted(false); 		//외곽선 없애줌
		item2.setContentAreaFilled(false);  //내용영역 채우기 안함
		item2.setFocusPainted(false);  		//선택될때 생기는 테두리 사용 안함
		item2.setOpaque(false); 			//불투명해제
		

		
		JButton item3 = new JButton(new ImageIcon("images/stage2/item3.PNG"));
		item3.setBounds(325, 580, 100, 100);
		
		
		
		item3.setBorderPainted(false); 		//외곽선 없애줌
		item3.setContentAreaFilled(false);  //내용영역 채우기 안함
		item3.setFocusPainted(false);  		//선택될때 생기는 테두리 사용 안함
		item3.setOpaque(false); 			//불투명해제
		

		
		JButton item4 = new JButton(new ImageIcon("images/stage2/item4.PNG"));
		item4.setBounds(450, 580, 100, 100);
		
		
		
		item4.setBorderPainted(false); 		//외곽선 없애줌
		item4.setContentAreaFilled(false);  //내용영역 채우기 안함
		item4.setFocusPainted(false);  		//선택될때 생기는 테두리 사용 안함
		item4.setOpaque(false); 			//불투명해제
		

		
		JButton item5 = new JButton(new ImageIcon("images/stage2/item5.PNG"));
		item5.setBounds(575, 580, 100, 100);
		
		
		
		item5.setBorderPainted(false); 		//외곽선 없애줌
		item5.setContentAreaFilled(false);  //내용영역 채우기 안함
		item5.setFocusPainted(false);  		//선택될때 생기는 테두리 사용 안함
		item5.setOpaque(false); 			//불투명해제
		

		
		JButton item6 = new JButton(new ImageIcon("images/stage2/item6.PNG"));
		item6.setBounds(700, 580, 100, 100);
		
		
		
		item6.setBorderPainted(false); 		//외곽선 없애줌
		item6.setContentAreaFilled(false);  //내용영역 채우기 안함
		item6.setFocusPainted(false);  		//선택될때 생기는 테두리 사용 안함
		item6.setOpaque(false); 			//불투명해제
		

		
		JButton item7 = new JButton(new ImageIcon("images/stage2/item7.PNG"));
		item7.setBounds(825, 580, 100, 100);
		
		
		
		item7.setBorderPainted(false); 		//외곽선 없애줌
		item7.setContentAreaFilled(false);  //내용영역 채우기 안함
		item7.setFocusPainted(false);  		//선택될때 생기는 테두리 사용 안함
		item7.setOpaque(false); 			//불투명해제
		

		
		JButton item8 = new JButton(new ImageIcon("images/stage2/item8.PNG"));
		item8.setBounds(950, 580, 100, 100);
		
		
		
		item8.setBorderPainted(false); 		//외곽선 없애줌
		item8.setContentAreaFilled(false); 	//내용영역 채우기 안함
		item8.setFocusPainted(false);  		//선택될때 생기는 테두리 사용 안함
		item8.setOpaque(false); 			//불투명해제
		

		
		JButton item9 = new JButton(new ImageIcon("images/stage2/item9.PNG"));
		item9.setBounds(1075, 580, 100, 100);
		
		
		
		item9.setBorderPainted(false); 		//외곽선 없애줌
		item9.setContentAreaFilled(false); 	//내용영역 채우기 안함
		item9.setFocusPainted(false);  		//선택될때 생기는 테두리 사용 안함
		item9.setOpaque(false); 			//불투명해제
		
		
		
		//퀘스트 랜덤 출력
		//random = new Random().nextInt(3) + 1;
		rQuest = "quest" + random + ".png";
		
		JLabel quest = new JLabel(new ImageIcon(new ImageIcon("images/stage2/"+rQuest).
				getImage().getScaledInstance(264, 275, 0)));
		quest.setBounds(910, 130, 264, 275);
		
		
		
		
		
		//패널에 얹기
		this.add(label);

		this.add(item1);
		this.add(item2);
		this.add(item3);
		this.add(item4);
		this.add(item5);
		this.add(item6);
		this.add(item7);
		this.add(item8);
		this.add(item9);

		this.add(quest);

		this.add(hp1);
		this.add(hp2);
		this.add(hp3);
		
		this.setComponentZOrder(label, 10);
		//라벨을 13번째 이미지로 불러온다는것

		

		

		
	}

	public void setQuest(int random) {
		//퀘스트 문제 

		
		if(random == 1) {
			int[] q1 = {5, 6, 7, 8, 9, 1, 2, 3, 4};
		}
		
		if(random == 2) {
			int[] q2 = {9, 8, 7, 6, 5, 4, 3, 2, 1};
		}
		
		if(random == 3) {
			int[] q3 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		}
		
				
		
		
	}
	
	public int[] getQuest() {
		return q1;
		
	}
			
		

		
		
		
	
	


	
}
