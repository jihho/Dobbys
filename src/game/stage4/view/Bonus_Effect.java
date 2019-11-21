package game.stage4.view;

import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

public class Bonus_Effect {
	public static Clip bonus_clip;
	public static Clip bgm_clip;
	
	//깨지는 소리 (작음)
	public static void crack_S() {
		File bgm;
		AudioInputStream stream;
		AudioFormat format;
		DataLine.Info info;
		
		bgm = new File("sounds/stage4_glass(S).wav");
		
		try {
			stream = AudioSystem.getAudioInputStream(bgm);
			format = stream.getFormat();
			info = new DataLine.Info(Clip.class, format);
			bonus_clip = (Clip)AudioSystem.getLine(info);
			bonus_clip.open(stream);
			bonus_clip.start();
			
			
		} catch (Exception e) {
			System.out.println("err : " + e);
			}
		
	}
	
	//깨지는 소리 (중간)
		public static void crack_M() {
			File bgm;
			AudioInputStream stream;
			AudioFormat format;
			DataLine.Info info;
			
			bgm = new File("sounds/stage4_glass(M).wav");
			
			try {
				stream = AudioSystem.getAudioInputStream(bgm);
				format = stream.getFormat();
				info = new DataLine.Info(Clip.class, format);
				bonus_clip = (Clip)AudioSystem.getLine(info);
				bonus_clip.open(stream);
				bonus_clip.start();
				
				
			} catch (Exception e) {
				System.out.println("err : " + e);
				}
			
		}
		
		//깨지는 소리 (큼)
		public static void crack_L() {
			File bgm;
			AudioInputStream stream;
			AudioFormat format;
			DataLine.Info info;
			
			bgm = new File("sounds/stage4_glass(L).wav");
			
			try {
				stream = AudioSystem.getAudioInputStream(bgm);
				format = stream.getFormat();
				info = new DataLine.Info(Clip.class, format);
				bonus_clip = (Clip)AudioSystem.getLine(info);
				bonus_clip.open(stream);
				bonus_clip.start();
				
				
			} catch (Exception e) {
				System.out.println("err : " + e);
				}
			
		}
		
		public static void hokStart() {
			File bgm;
			AudioInputStream stream;
			AudioFormat format;
			DataLine.Info info;
			
			bgm = new File("sounds/hokStart.wav");
			
			try {
				stream = AudioSystem.getAudioInputStream(bgm);
				format = stream.getFormat();
				info = new DataLine.Info(Clip.class, format);
				bgm_clip = (Clip)AudioSystem.getLine(info);
				bgm_clip.open(stream);
				bgm_clip.start();
				
				
			} catch (Exception e) {
				System.out.println("err : " + e);
				}
			
		}
	
	//효과음 종료
	public static void intoBgmStop() {
		bgm_clip.stop();
		bgm_clip.close();
	}
}
