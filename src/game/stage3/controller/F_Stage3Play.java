package game.stage3.controller;

import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

import game.stage3.model.vo.F_General;
import game.stage3.model.vo.F_Harry;
import game.stage3.model.vo.F_Voldmort;
import game.stage3.views.F_Stage3Panel;

public class F_Stage3Play extends JPanel{
	private JFrame mf;
	private JPanel panel;
	private String hrChoice;	//해리의 선택
	private int scan;	//해리의 선택을 숫자로 바꿀 변수
	private F_Stage3Panel pcho;


	//해리와 볼드모트 생성
	F_General harry = new F_Harry(100, 10, 20, 30, 10);	//체력, 공격, 스매쉬, 카운터
	F_General voldmort = new F_Voldmort(100, 10, 20, 30, 10);

	public F_Stage3Play(JFrame mf) {
		this.mf = mf;
		this.setLayout(null);
		panel = this;

	}
	public void GamePlay(F_Stage3Panel pcho) {
		//공격  > 카운터 > 스매쉬 > 디펜스 > 공격(데미지 측정 차별), 회복 없음
		//0 공격, 1 방어, 2 스매쉬, 3 카운터
		do {
			int vmchoice = (int)(Math.random()*4); //볼드모트의 선택이 될 랜덤 수

			switch(scan) {
			case 0 :	//공격일때
				if(vmchoice == 0 && vmchoice == 1 && vmchoice == 2) {

				}else if(vmchoice == 3) {
					voldmort.setHp(voldmort.getHp() -10);
					voldmort.setHplife(voldmort.getHplife() -1);
				}

			case 1 : 	//방어일때
				if(vmchoice == 0 && vmchoice == 1 && vmchoice == 3) {

				}else if(vmchoice == 2) {
					harry.setHp(harry.getHp() -20);
					harry.setHplife(harry.getHplife() -2);
				}
			case 2 :	//스매쉬일때
				if(vmchoice == 0 && vmchoice == 2) {

				}else if(vmchoice == 1) {
					voldmort.setHp(voldmort.getHp()-20);
					voldmort.setHplife(voldmort.getHplife() -2);
				}else if(vmchoice ==3) {
					harry.setHp(harry.getHp() -30);
					harry.setHplife(harry.getHplife() -3);
				}
			case 3 : 	//카운터일때
				if(vmchoice == 0) {
					harry.setHp(harry.getHp()-10);
					harry.setHplife(harry.getHplife() -1);
				}else if(vmchoice == 1 && vmchoice == 3) {

				}else if(vmchoice == 2) {
					voldmort.setHp(voldmort.getHp() -30);
					voldmort.setHplife(voldmort.getHplife() -3);
				}
			}

			if(voldmort.getHp()<=0) {
				System.out.println("볼드모트를 물리쳤습니다."); return;

			}
			if(harry.getHp()<=0){
				System.out.println("재도전하시겠습니까?"); return;
			}

		}while(true);

	}
}
