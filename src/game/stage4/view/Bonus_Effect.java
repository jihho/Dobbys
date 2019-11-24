package game.stage4.view;

import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

public class Bonus_Effect {
	public static Clip bonus_clip;
	public static Clip last_clip;
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
		
		public static void hokClick() {
			File bgm;
			AudioInputStream stream;
			AudioFormat format;
			DataLine.Info info;
			
			bgm = new File("sounds/hokClick.wav");
			
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
		
		public static void hokLastEffect() {
			File bgm;
			AudioInputStream stream;
			AudioFormat format;
			DataLine.Info info;
			
			bgm = new File("sounds/hokLast.wav");
			
			try {
				stream = AudioSystem.getAudioInputStream(bgm);
				format = stream.getFormat();
				info = new DataLine.Info(Clip.class, format);
				last_clip = (Clip)AudioSystem.getLine(info);
				last_clip.open(stream);
				last_clip.start();
				
				
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
				bonus_clip = (Clip)AudioSystem.getLine(info);
				bonus_clip.open(stream);
				bonus_clip.start();
				
				
			} catch (Exception e) {
				System.out.println("err : " + e);
				}
			
		}
		
		public static void hokBgm() {
			File bgm;
			AudioInputStream stream;
			AudioFormat format;
			DataLine.Info info;
			
			bgm = new File("sounds/hok1.wav");
			
			try {
				stream = AudioSystem.getAudioInputStream(bgm);
				format = stream.getFormat();
				info = new DataLine.Info(Clip.class, format);
				bgm_clip = (Clip)AudioSystem.getLine(info);
				bgm_clip.open(stream);
				bgm_clip.start();
				bgm_clip.loop(5);
				
				
			} catch (Exception e) {
				System.out.println("err : " + e);
				}
		}
		
		public static void hokEnding() {
			File bgm;
			AudioInputStream stream;
			AudioFormat format;
			DataLine.Info info;
			
			bgm = new File("sounds/hokEnding2.wav");
			
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
		
		public static void hokGet() {
			File bgm;
			AudioInputStream stream;
			AudioFormat format;
			DataLine.Info info;
			
			bgm = new File("sounds/hokGet.wav");
			
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
	
	//효과음 종료
	public static void intoBgmStop() {
		bgm_clip.stop();
		bgm_clip.close();
	}
	
		public static void intoBonusStop() {
			bonus_clip.stop();
			bonus_clip.close();
		}
}
