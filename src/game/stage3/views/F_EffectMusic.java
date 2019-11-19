package game.stage3.views;

import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

public class F_EffectMusic {
	public static Clip clip;
	
	
	public static void stage3_atk() {
		File bgm;
		AudioInputStream stream;
		AudioFormat format;
		DataLine.Info info;
		
		bgm = new File("sounds/stage3_atk.wav");
		
		try {
			stream = AudioSystem.getAudioInputStream(bgm);
			format = stream.getFormat();
			info = new DataLine.Info(Clip.class, format);
			clip = (Clip)AudioSystem.getLine(info);
			clip.open(stream);
			clip.start();
			//clip.loop(1);
			
		} catch (Exception e) {
			System.out.println("err : " + e);
			}
		
	}
	
	public static void stage3_smash() {
		File bgm;
		AudioInputStream stream;
		AudioFormat format;
		DataLine.Info info;
		
		bgm = new File("sounds/stage3_smash.wav");
		
		try {
			stream = AudioSystem.getAudioInputStream(bgm);
			format = stream.getFormat();
			info = new DataLine.Info(Clip.class, format);
			clip = (Clip)AudioSystem.getLine(info);
			clip.open(stream);
			clip.start();
			//clip.loop(1);
			
		} catch (Exception e) {
			System.out.println("err : " + e);
			}
		
	}
	
	public static void stage3_df() {
		File bgm;
		AudioInputStream stream;
		AudioFormat format;
		DataLine.Info info;
		
		bgm = new File("sounds/stage3_df.wav");
		
		try {
			stream = AudioSystem.getAudioInputStream(bgm);
			format = stream.getFormat();
			info = new DataLine.Info(Clip.class, format);
			clip = (Clip)AudioSystem.getLine(info);
			clip.open(stream);
			clip.start();
			//clip.loop(1);
			
		} catch (Exception e) {
			System.out.println("err : " + e);
			}
		
	}
	
	public static void stage3_ct() {
		File bgm;
		AudioInputStream stream;
		AudioFormat format;
		DataLine.Info info;
		
		bgm = new File("sounds/stage3_ct.wav");
		
		try {
			stream = AudioSystem.getAudioInputStream(bgm);
			format = stream.getFormat();
			info = new DataLine.Info(Clip.class, format);
			clip = (Clip)AudioSystem.getLine(info);
			clip.open(stream);
			clip.start();
			//clip.loop(1);
			
		} catch (Exception e) {
			System.out.println("err : " + e);
			}
		
	}

	public static void intoBgmStop() {
		clip.stop();
		clip.close();
	}
	
}