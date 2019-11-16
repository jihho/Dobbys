package game.stage2.controller;

import game.stage2.model.vo.E_Items;

public class E_GameManager {
	
	public static int ctn = 0;
	
	private int[] choice = new int[9];
	E_Items[] quest1 = new E_Items[9];
	
	public E_GameManager() {
		
		//퀘스트문제 
		
/*		private int item1 = 1;	//당근
		private int item2 = 2;	//사과
		private int item3 = 3;	//귤
		private int item4 = 4;	//박쥐날개
		private int item5 = 5;	//클로버
		private int item6 = 6;	//버섯
		private int item7 = 7;	//생선
		private int item8 = 8;	//깃털
		private int item9 = 9;	//해골
*/		
		//9, 7, 6, 3, 2, 4, 6, 8, 1
		//해골 생선 클로버 귤 사과 날개 버섯 깃털 당근 
		quest1[0] = new E_Items(9);
		quest1[1] = new E_Items(7);
		quest1[2] = new E_Items(5);
		quest1[3] = new E_Items(3);
		quest1[4] = new E_Items(2);
		quest1[5] = new E_Items(4);	
		quest1[6] = new E_Items(6);
		quest1[7] = new E_Items(8);
		quest1[8] = new E_Items(1);
		
		
		
	}
	
	//유저선택값 배열에 담기
	public void setChoice(int value) {
		choice[ctn] = value;
		System.out.println("dhdh");
		

	}
	
	//퀘스트값이랑 비교하기위해 유저값 불러오기
	public int[] getChoice() {
		return choice;
	}
	public void compare() {

		boolean flag;


		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				if(i == j) {
					System.out.println("성공!!!");
					flag = true;
				}else {
					System.out.println("시일패!!");
					flag = false;
				}
			}


		}


	}
	
	
	//퀘스트랑 유저선택이랑 동일한지 판단
	//항아리 버튼 누르면
	//다르면 hp 마이너스
	//같으면 성공
	
}
