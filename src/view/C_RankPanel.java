package view;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import model.vo.User;

public class C_RankPanel extends JPanel{
	private JFrame mf;
	private ArrayList list;
	
	public C_RankPanel(JFrame mf, ArrayList list) {
		this.mf = mf;
		this.list = list;
		this.setBackground(Color.white);
		this.setBounds(0, 0, 1300, 770);
		
		printRank(list);
	
		mf.add(this);
	}
	
	public void printRank(ArrayList list) {
		
		JTextArea ta = new JTextArea();
		
		for(int i = 0; i < list.size(); i++) {
			User u = (User) list.get(i);
			ta.append((i+1) + " 위 " 
					+ "Stage1 " + u.getScore1() + "점 " 
					+ "Stage2 " + u.getScore2() + "점 "
					+ "Stage3 " + u.getScore3() + "점 "
					+ "Total " + u.getTotal() + "점 "
					+ u.getId() + "\n");
			if(i > 9) {
				break;
			}
		}
		ta.setBounds(0, 0, 1300, 770);
		ta.setFont(new Font("DungGeunMo", Font.PLAIN, 30));
		this.add(ta);
	}
}
