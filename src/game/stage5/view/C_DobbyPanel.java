package game.stage5.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class C_DobbyPanel extends JPanel{
	private JFrame mf;
	private JPanel panel;
	private JLabel background; 
	private JLabel black;
	private JLabel dobby;
	private JTextField scoreLabel;
	private JLabel[] arrows;
	private ArrayList<JLabel> inputs;
	private int[] arrNo;
	private int x = 50;
	private int x2 = 50;
	private int index = 0;
	private int ctn = 0;
	public static int point = 0;
	private String userId;

	public C_DobbyPanel(JFrame mf) {
		this.mf = mf;
		panel = this;
		this.setLayout(null);
		this.setBackground(Color.blue);

		inputs = new ArrayList<JLabel>();
		arrows = new JLabel[12];
		arrNo = new int[12];

		this.setBounds(0, 0, 1300, 770);
		scoreLabel();
		System.out.println("보너스 패널생성");

		background = new JLabel(new ImageIcon(new ImageIcon("images/background2.png").getImage().getScaledInstance(1300, 770, 0)));
		background.setBounds(0, 0, 1300, 770);
		black = new JLabel(new ImageIcon(new ImageIcon("images/black.png").getImage().getScaledInstance(1200, 600, 0)));
		black.setBounds(50, 50, 1200, 600);

		
		dobbyInit();
		buttonInit();

//			this.add(black);
//			this.add(background);

		mf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int num = 0;
				
				if(e.getKeyCode() == KeyEvent.VK_F) {
					num = 4;
				}
				if(e.getKeyCode() == KeyEvent.VK_S) {
					num = 2;
				}
				if(e.getKeyCode() == KeyEvent.VK_A) {
					num = 1;
				}
				if(e.getKeyCode() == KeyEvent.VK_D) {
					num = 3;
				}
				
				addButton(num);
				ctn++;
			}
		});

	}

	public void dobbyInit(){
		System.out.println("도비 초기화");
		URL url = getClass().getClassLoader().getResource("stage5/dobby-0.png");
		System.out.println(url);
		
		dobby = new JLabel(new ImageIcon(url));
		dobby.setBounds(500, 50, 300, 450);
		this.add(dobby);
		
		repaint();
	}

	public void buttonInit(){
		for(int i = 0; i < arrows.length; i++) {
			int num = new Random().nextInt(4) + 1;
			arrNo[i] = num;
			URL url = getClass().getClassLoader().getResource("stage5/" + num+"_blue.png");
			arrows[i] = new JLabel(new ImageIcon(new ImageIcon(url).getImage().getScaledInstance(80, 80, 0)));
			arrows[i].setBounds(x+50, 500, 80, 80);
			x += 90;
			this.add(arrows[i]);
			this.repaint();
		}
	}



	public void addButton(int num) {
		//x2=50;


		if(index >= arrows.length){
			reset();
			index = 0;
		}else{
			System.out.println("index : " + index);

			String color = "";
			if(arrNo[index] == num) {
				color = "green";
				URL url = getClass().getClassLoader().getResource("stage5/dobby-"+num+".png");
				dobby.setIcon(new ImageIcon(url));
				dobby.setBounds(500, 50, 300, 450);
				point += 50;
				scoreLabel.setText("SCORE : " + point);
				this.setBackground(Color.BLUE);
				scoreLabel.setBackground(Color.WHITE);
				
			}else {
				color = "gray";
				dobby.setIcon(new ImageIcon("images/tage5/dobby-6.png"));
				dobby.setBounds(500, 50, 300, 450);
				this.setBackground(Color.DARK_GRAY);
				scoreLabel.setBackground(Color.WHITE);
			}
			URL url = getClass().getClassLoader().getResource("stage5/" + num + "_" + color + ".png");
			JLabel input = new JLabel(new ImageIcon(new ImageIcon(url).getImage().getScaledInstance(80, 80, 0)));
			
			input.setBounds(x2+50, 600, 80, 80);
			inputs.add(input);
			x2 += 90;
			this.add(inputs.get(index));
			this.repaint();
			index++;
		}


	}

	public void reset(){

		System.out.println("리셋");
		this.remove(dobby);
		dobbyInit();

		for (int i = 0; i < arrows.length; i++) {
			this.remove(arrows[i]);
			this.repaint();
		}
		buttonInit();

		for (int i = 0; i < arrNo.length; i++) {
			this.remove(this.inputs.get(i));
			this.repaint();
		}
		
		inputs.clear();
		this.repaint();
		index = 0;
		x = 50;
		x2 = 50;
	}
	
	public void scoreLabel(){
		scoreLabel = new JTextField("SCORE : " + point);
		scoreLabel.setFont(new Font("DungGeunMo", Font.PLAIN, 40));
		scoreLabel.setBorder(BorderFactory.createEmptyBorder());
		scoreLabel.setBackground(Color.WHITE);
		this.setComponentZOrder(scoreLabel, 0);
		scoreLabel.setBounds(20, 20, 200, 50);
		this.add(scoreLabel);
	}
	
}

