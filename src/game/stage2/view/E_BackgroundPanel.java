package game.stage2.view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class E_BackgroundPanel extends JPanel {
	private JFrame mf;
	private JPanel panel;

	public E_BackgroundPanel(JFrame mf) {
		mf.setTitle("HarryPotter ~ Stage2 ~");
		this.mf = mf;
		this.setLayout(null);

		panel = this;

		//백그라운드화면
		JLabel label = new JLabel(new ImageIcon(new ImageIcon("images/stage2/stage2_bg2.PNG").
				getImage().getScaledInstance(1280, 720, 0)));
		label.setBounds(0, 0, 1280, 720);

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
		
		this.setComponentZOrder(label, 9);
	}
}
