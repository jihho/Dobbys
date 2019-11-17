package game.stage2.view;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import view.C_GameStage;

public class E_SuccessPanel extends Thread{
	private JFrame mf;
	private JPanel panel;
	
	public E_SuccessPanel(JFrame mf, JPanel panel) {
		
		this.mf = mf;
		this.panel = panel;
		
		
	}
	@Override
	public void run() {
		//성공이미지 출력
		JLabel suc = new JLabel(new ImageIcon(new ImageIcon("images/stage2/stage2_suss.gif").
				getImage().getScaledInstance(1280, 720, 0)));
		//위치
		panel.add(suc, "Center");
		
		try {
			this.sleep(1000);
			System.out.println("시간가는중");
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		
	}
	//타이머가 끝나면 다음 메인화면으로 넘어감
	E_ChangePanel cp = new E_ChangePanel(mf, panel);
	C_GameStage gs = new C_GameStage(mf);
	
	
	
}
