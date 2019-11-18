package model.vo;

import java.io.Serializable;

public class User implements Serializable{
	
	private String id;
	private String pw;
	private String name;
	private String eMail;
	private int score1 = 0;
	private int score2 = 0;
	private int score3 = 0;
	private int total = 0;
	
	
	public User(String id, String pw, String name, String eMail) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.eMail = eMail;
	}
	
	public String getId() {
		return id;
	}

	public String getPw() {
		return pw;
	}

	public String getName() {
		return name;
	}

	public String geteMail() {
		return eMail;
	}

	public int getScore1() {
		return score1;
	}

	public int getScore2() {
		return score2;
	}

	public int getScore3() {
		return score3;
	}

	public int getTotal() {
		return total;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public void setScore1(int score1) {
		this.score1 = score1;
	}

	public void setScore2(int score2) {
		this.score2 = score2;
	}

	public void setScore3(int score3) {
		this.score3 = score3;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", pw=" + pw + ", name=" + name + ", eMail=" + eMail + ", score1=" + score1
				+ ", score2=" + score2 + ", score3=" + score3 + ", total=" + total + "]";
	}
	
	
	

}
