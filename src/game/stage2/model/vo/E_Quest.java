package game.stage2.model.vo;

import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

import game.stage2.view.E_QuestPanel;

public class E_Quest extends JPanel{
	private JFrame mf;
	private JPanel panel;
	//퀘스트 문제 랜덤출력 변수 선언및 초기화
	public static int random = new Random().nextInt(3) + 1;
	
	public static int getRandom() {
		return random;
	}

	public static void setRandom(int random) {
		E_Quest.random = random;
	}

	
	public int[] getQuest() {
		
		//퀘스트 문제 배열선언 및 초기화
		int[] q = new int[9];
		
		System.out.println("q1 랜덤:" + random);
		
		if(random == 1) {
			 int[] q1 = {5, 6, 7, 8, 9, 1, 2, 3, 4};
			 q = q1;
		}
		
		if(random == 2) {
			int[] q2 = {9, 8, 7, 6, 5, 4, 3, 2, 1};
			q = q2;
		}
		
		if(random == 3) {
			int[] q3 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
			q = q3;
		}
		
		return q;
				
		
		
	}

	
	
}
