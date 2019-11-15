package game.stage3.controller;

import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;

import game.stage3.model.vo.F_General;
import game.stage3.model.vo.F_Harry;
import game.stage3.model.vo.F_Voldmort;

public class F_Stage3Play extends JPanel{
	private JFrame mf;
	private JPanel panel;
	
	F_General harry = new F_Harry();
	F_General voldmort = new F_Voldmort();
	
	public F_Stage3Play(JFrame mf) {
		this.mf = mf;
		this.setLayout(null);
		
		panel = this;
		
		int vmchoice = (int)(Math.random()*4); //볼드모트의 선택이 될 랜덤 수
		int scan = 0;	//해리의 선택을 숫자로 바꿀 변수
		String hrChoice; //해리의 선택
		
		Scanner sc = new Scanner(System.in);
		hrChoice = sc.nextLine();
		
		if(hrChoice.equals("atk")) {	//공격일때 scan값
			scan = 0;
		}else if(hrChoice.equals("df")) {	//방어일때 scan값
			scan = 1;
		}else if(hrChoice.equals("smash")) {	//스매쉬일때 scan값
			scan = 2;
		}else if(hrChoice.equals("counter")) {	//카운터일때 scan값
			scan = 3;
		}
		
		if(vmchoice == 0) {
			
		}else if (vmchoice == 1) {
			
		}else if (vmchoice == 2) {
			
		}else if (vmchoice == 3) {
			
		}
			
		//공격 -> 카운터 -> 스매쉬 -> 디펜스 -> 공격	
		// 0 : atk
		// 1 : df
		// 2 : smash
		// 3 : counter
		switch(scan) {
		case 0 :	//공격일때
			if(vmchoice == 0 && vmchoice == 1 && vmchoice == 2) {
				
			}else if(vmchoice == 3) {
				voldmort.setHp(voldmort.getHp()-10);
			}
			
		case 1 : 
			if(vmchoice == 0 && vmchoice == 1 && vmchoice == 3) {
				
			}else if(vmchoice == 2) {
				harry.setHp(harry.getHp()-20);
			}
		case 2 :
			if(vmchoice == 0) {
				harry.setHp(harry.getHp()-10);
			}else if(vmchoice == 1) {
				voldmort.setHp(voldmort.getHp()-20);
			}else if(vmchoice == 2 && vmchoice ==3) {
				
			}
		case 3 : 
			if(vmchoice == 0) {
				harry.setHp(harry.getHp()-10);
			}else if(vmchoice == 1 && vmchoice == 3) {
				
			}else if(vmchoice == 2) {
				voldmort.setHp(voldmort.getHp() -30);
			}
		}
	
		
		
	}
}
