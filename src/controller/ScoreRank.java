package controller;

import java.util.Comparator;

import model.vo.User;

public class ScoreRank implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		User s1 = (User) o1;
		User s2 = (User) o2;
		int result = 0;
		
		if(s1.getTotal() == s2.getTotal()) {
			result = 0;
		}
		if(s1.getTotal() > s2.getTotal()){
			result = -1;
		}
		if(s1.getTotal() < s2.getTotal()) {
			result = 1;
		}
		
		return result;
	}

}
