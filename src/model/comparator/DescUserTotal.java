package model.comparator;

import java.util.Comparator;

import model.vo.User;

public class DescUserTotal implements Comparator{

	public DescUserTotal() {}
	@Override
	public int compare(Object arg0, Object arg1) {
		if(arg0 instanceof User && arg1 instanceof User) {
			User u1 = (User) arg0;
			User u2 = (User) arg1;
			
			return u2.getTotal() - u1.getTotal();
		}
		return 0;
	}

}
