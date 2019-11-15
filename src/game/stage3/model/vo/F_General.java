package game.stage3.model.vo;

public class F_General {
	private int hp;
	private int atk;
	private int smash;
	private int counter;
	private int defence;
	
	public F_General() {}
	
	public F_General(int hp, int atk, int smash, int counter, int defence) {
		this.hp = hp;
		this.atk = atk;
		this.smash = smash;
		this.counter = counter;
		this.defence = defence;
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

	public int getDefence() {
		return defence;
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

	public void setDefence(int defence) {
		this.defence = defence;
	}
}
