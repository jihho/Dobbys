package game.stage2.model.vo;

public class E_Items {
	private int item1 = 1;	//당근
	private int item2 = 2;	//사과
	private int item3 = 3;	//귤
	private int item4 = 4;	//박쥐날개
	private int item5 = 5;	//클로버
	private int item6 = 6;	//버섯
	private int item7 = 7;	//생선
	private int item8 = 8;	//깃털
	private int item9 = 9;	//해골
	private int leftBtn = 10;	//왼화살표
	private int rigthBtn = 11;	//오른화살표
	
	private static int MAX_HP = 5;
	private int hp = MAX_HP;
	
	private int qeust1;
	private int quest2;
	private int quest3;
	
	private int centerBtn;
	
	public E_Items() {}

	public E_Items(int item1, int item2, int item3, int item4, int item5, int item6, int item7, int item8, int item9,
			int hp, int qeust1, int quest2, int quest3, int leftBtn, int centerBtn, int rigthBtn) {
		
		this.item1 = item1;
		this.item2 = item2;
		this.item3 = item3;
		this.item4 = item4;
		this.item5 = item5;
		this.item6 = item6;
		this.item7 = item7;
		this.item8 = item8;
		this.item9 = item9;
		this.hp = hp;
		this.qeust1 = qeust1;
		this.quest2 = quest2;
		this.quest3 = quest3;
		this.leftBtn = leftBtn;
		this.centerBtn = centerBtn;
		this.rigthBtn = rigthBtn;
		
		
	}

	public int getItem1() {
		return item1;
	}

	public int getItem2() {
		return item2;
	}

	public int getItem3() {
		return item3;
	}

	public int getItem4() {
		return item4;
	}

	public int getItem5() {
		return item5;
	}

	public int getItem6() {
		return item6;
	}

	public int getItem7() {
		return item7;
	}

	public int getItem8() {
		return item8;
	}

	public int getItem9() {
		return item9;
	}

	public static int getMAX_HP() {
		return MAX_HP;
	}

	public int getHp() {
		return hp;
	}

	public int getQeust1() {
		return qeust1;
	}

	public int getQuest2() {
		return quest2;
	}

	public int getQuest3() {
		return quest3;
	}

	public int getLeftBtn() {
		return leftBtn;
	}

	public int getCenterBtn() {
		return centerBtn;
	}

	public int getRigthBtn() {
		return rigthBtn;
	}

	public void setItem1(int item1) {
		this.item1 = item1;
	}

	public void setItem2(int item2) {
		this.item2 = item2;
	}

	public void setItem3(int item3) {
		this.item3 = item3;
	}

	public void setItem4(int item4) {
		this.item4 = item4;
	}

	public void setItem5(int item5) {
		this.item5 = item5;
	}

	public void setItem6(int item6) {
		this.item6 = item6;
	}

	public void setItem7(int item7) {
		this.item7 = item7;
	}

	public void setItem8(int item8) {
		this.item8 = item8;
	}

	public void setItem9(int item9) {
		this.item9 = item9;
	}

	public static void setMAX_HP(int mAX_HP) {
		MAX_HP = mAX_HP;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public void setQeust1(int qeust1) {
		this.qeust1 = qeust1;
	}

	public void setQuest2(int quest2) {
		this.quest2 = quest2;
	}

	public void setQuest3(int quest3) {
		this.quest3 = quest3;
	}

	public void setLeftBtn(int leftBtn) {
		this.leftBtn = leftBtn;
	}

	public void setCenterBtn(int centerBtn) {
		this.centerBtn = centerBtn;
	}

	public void setRigthBtn(int rigthBtn) {
		this.rigthBtn = rigthBtn;
	}
	
	
	
	
	
	
	
}
