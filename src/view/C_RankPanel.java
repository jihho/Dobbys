package view;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import model.vo.Score;

public class C_RankPanel extends JPanel{
	private JFrame mf;
	private ArrayList list;
	
	public C_RankPanel(JFrame mf, ArrayList list) {
		this.mf = mf;
		this.list = list;
		this.setBackground(Color.white);
		this.setBounds(0, 0, 1280, 720);
		
		printRank(list);
	
		mf.add(this);
	}
	
	public void printRank(ArrayList list) {
		JTextArea ta = new JTextArea();
		
		for(int i = 0; i < list.size(); i++) {
			Score s = (Score) list.get(i);
			ta.append((i+1) + " 위 " + s.getPoint() + " 점 " +s.getUserId() + "\n");
			if(i > 9) {
				break;
			}
		}
		ta.setBounds(0, 0, 800, 700);
		ta.setFont(new Font("", Font.BOLD, 50));
		this.add(ta);
	}
}
