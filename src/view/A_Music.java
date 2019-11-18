package view;

import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

public class A_Music {
	public static Clip clip;
	
	public static void introBgm() {
		File bgm;
		AudioInputStream stream;
		AudioFormat format;
		DataLine.Info info;
		
		bgm = new File("sounds/intro.wav");
		
		try {
			stream = AudioSystem.getAudioInputStream(bgm);
			format = stream.getFormat();
			info = new DataLine.Info(Clip.class, format);
			clip = (Clip)AudioSystem.getLine(info);
			clip.open(stream);
			clip.start();
			clip.loop(5);
			
		} catch (Exception e) {
			System.out.println("err : " + e);
			}
		
	}
	
	public static void lightningEffect() {
		File bgm;
		AudioInputStream stream;
		AudioFormat format;
		DataLine.Info info;
		
		bgm = new File("sounds/introEffect.wav");
		
		try {
			stream = AudioSystem.getAudioInputStream(bgm);
			format = stream.getFormat();
			info = new DataLine.Info(Clip.class, format);
			clip = (Clip)AudioSystem.getLine(info);
			clip.open(stream);
			clip.start();
			clip.loop(1);
			
		} catch (Exception e) {
			System.out.println("err : " + e);
			}
		
	}
	public static void trainSound() {
		File bgm;
		AudioInputStream stream;
		AudioFormat format;
		DataLine.Info info;
		
		bgm = new File("sounds/trainSound.wav");
		
		try {
			stream = AudioSystem.getAudioInputStream(bgm);
			format = stream.getFormat();
			info = new DataLine.Info(Clip.class, format);
			clip = (Clip)AudioSystem.getLine(info);
			clip.open(stream);
			clip.start();
			clip.loop(4);
			
		} catch (Exception e) {
			System.out.println("err : " + e);
			}
		
	}
	public static void intoBgmStop() {
		clip.stop();
		clip.close();
	}
	
	public static void harrySkillSound() {
		File bgm;
		AudioInputStream stream;
		AudioFormat format;
		DataLine.Info info;
		
		bgm = new File("sounds/harrySkillSound.wav");
		
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
	
	public static void stage1_backgroundSound() {
		File bgm;
		AudioInputStream stream;
		AudioFormat format;
		DataLine.Info info;
		
		bgm = new File("sounds/stage1_Background.wav");
		
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

//	public static void main(String[] args) {
//		A_Music test = new A_Music();
//		while(true) {
//			try {
//				test.abc();
//			} catch(Exception e) {
//				
//			}
//		}
//
//	}

}
