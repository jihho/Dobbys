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
	F_General harry = new F_Harry(100, 10, 20, 30);	//체력, 공격, 스매쉬, 카운터
	F_General voldmort = new F_Voldmort(100, 10, 20, 30);

	public F_Stage3Play(JFrame mf) {
		this.mf = mf;
		this.setLayout(null);
		panel = this;

	}
	public void GamePlay(F_Stage3Panel pcho) {

		do {
			int vmchoice = (int)(Math.random()*4); //볼드모트의 선택이 될 랜덤 수

			switch(scan) {
			case 0 :	//공격일때
				if(vmchoice == 0 && vmchoice == 1 && vmchoice == 2) {

				}else if(vmchoice == 3) {
					voldmort.setHp(voldmort.getHp()-10);
				}

			case 1 : 	//방어일때
				if(vmchoice == 0 && vmchoice == 1 && vmchoice == 3) {

				}else if(vmchoice == 2) {
					harry.setHp(harry.getHp()-20);
				}
			case 2 :	//스매쉬일때
				if(vmchoice == 0) {
					harry.setHp(harry.getHp()-10);
				}else if(vmchoice == 1) {
					voldmort.setHp(voldmort.getHp()-20);
				}else if(vmchoice == 2 && vmchoice ==3) {

				}
			case 3 : 	//카운터일때
				if(vmchoice == 0) {
					harry.setHp(harry.getHp()-10);
				}else if(vmchoice == 1 && vmchoice == 3) {

				}else if(vmchoice == 2) {
					voldmort.setHp(voldmort.getHp() -30);
				}
			}

		}while(true);

	}
}
