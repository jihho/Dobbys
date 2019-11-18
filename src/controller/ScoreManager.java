package controller;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.dao.C_ScoreDao;
import model.vo.User;
import view.C_RandomAssign2;
import view.C_RankPanel;
import view.ChangePanel;


public class ScoreManager {
	private String userId;
	private C_ScoreDao sd = new C_ScoreDao();
	private JFrame mf;
	private JPanel panel;
	
	public ScoreManager(String userId, JFrame mf, JPanel panel) {
		this.userId = userId;
		this.mf = mf;
		this.panel = panel;
	}
	
	public void savaScore() {
		System.out.println(userId);
		System.out.println(C_RandomAssign2.total);
		User u = new User(userId, C_RandomAssign2.total);
		
		sd.insertScore(u);
		
		ArrayList list = sd.readAll();
		list.sort(new ScoreRank());

		//System.out.println(list);
		
		new ChangePanel(mf, panel).replaceRankPanel(new C_RankPanel(mf, list));
		
		
	}
}
