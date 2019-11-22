package game.stage2.model.vo;

import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

public class E_EffectMusic {
	public static Clip boiling;
	public static Clip fire;
	public static Clip clip;
	
	//끓는 소리 효과음
	public static void stage2_boiling() {
		File bgm;
		AudioInputStream stream;
		AudioFormat format;
		DataLine.Info info;
		
		bgm = new File("sounds/stage2_boiling_2.wav");
		
		try {
			stream = AudioSystem.getAudioInputStream(bgm);
			format = stream.getFormat();
			info = new DataLine.Info(Clip.class, format);
			boiling = (Clip)AudioSystem.getLine(info);
			boiling.open(stream);
			boiling.start();
			
			
		} catch (Exception e) {
			System.out.println("err : " + e);
			}
		
	}
	
	//끊는 소리 효과음 종료
	public static void intoBgmStop_boiling() {
		boiling.stop();
		boiling.close();
	}
	
	//실패시 폭발 효과음
	public static void stage2_fire() {
		File bgm;
		AudioInputStream stream;
		AudioFormat format;
		DataLine.Info info;
		
		bgm = new File("sounds/stage2_fire.wav");
		
		try {
			stream = AudioSystem.getAudioInputStream(bgm);
			format = stream.getFormat();
			info = new DataLine.Info(Clip.class, format);
			fire = (Clip)AudioSystem.getLine(info);
			fire.open(stream);
			fire.start();
			
			
		} catch (Exception e) {
			System.out.println("err : " + e);
			}
		
	}
	
	//실패시 폭발 효과음 종료
	public static void intoBgmStop_fire() {
		fire.stop();
		fire.close();
	}
	
	
	//아이템, 힌트버튼 클릭 효과음
	public static void stage2_click() {
		File bgm;
		AudioInputStream stream;
		AudioFormat format;
		DataLine.Info info;
		
		bgm = new File("sounds/stage2_click.wav");
		
		try {
			stream = AudioSystem.getAudioInputStream(bgm);
			format = stream.getFormat();
			info = new DataLine.Info(Clip.class, format);
			clip = (Clip)AudioSystem.getLine(info);
			clip.open(stream);
			clip.start();
			
			
		} catch (Exception e) {
			System.out.println("err : " + e);
			}
		
	}
	
	//성공패널 효과음
	public static void stage2_suc() {
		File bgm;
		AudioInputStream stream;
		AudioFormat format;
		DataLine.Info info;
		
		bgm = new File("sounds/stage2_suc2.wav");
		
		try {
			stream = AudioSystem.getAudioInputStream(bgm);
			format = stream.getFormat();
			info = new DataLine.Info(Clip.class, format);
			clip = (Clip)AudioSystem.getLine(info);
			clip.open(stream);
			clip.start();
			
			
		} catch (Exception e) {
			System.out.println("err : " + e);
			}
		
	}
	
	//게임 방법 이미지 클릭 효과음
	public static void stage2_clickStart() {
		File bgm;
		AudioInputStream stream;
		AudioFormat format;
		DataLine.Info info;
		
		bgm = new File("sounds/stage2_clickstart.wav");
		
		try {
			stream = AudioSystem.getAudioInputStream(bgm);
			format = stream.getFormat();
			info = new DataLine.Info(Clip.class, format);
			clip = (Clip)AudioSystem.getLine(info);
			clip.open(stream);
			clip.start();
			
			
		} catch (Exception e) {
			System.out.println("err : " + e);
			}
		
	}
	
}
