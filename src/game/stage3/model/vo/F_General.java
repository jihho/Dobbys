package game.stage3.model.vo;

public class F_General {
	private int hp;
	private int atk;
	private int smash;
	private int counter;
	private int hplife;
	
	public F_General() {}
	
	public F_General(int hp, int atk, int smash, int counter, int hplife) {
		this.hp = hp;
		this.atk = atk;
		this.smash = smash;
		this.counter = counter;
		this.hplife = hplife;
	}

	public int getHp() {
		return hp;
	}

	public int getAtk() {
		return atk;
	}

	public int getSmash() {
		return smash;
	}

	public int getCounter() {
		return counter;
	}
	
	public int getHplife() {
		return hplife;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}

	public void setSmash(int smash) {
		this.smash = smash;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}
	
	public void setHplife(int hplife) {
		this.hplife = hplife;
	}

}
