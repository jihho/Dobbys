package view;

import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;

public class A_Music {
	public static Clip clip;
	public static Clip effect;
	
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
			//볼륨조절
			FloatControl gainControl = 
				    (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(-9.0f); // Reduce volume by 10 decibels.
			
			clip.start();
			clip.loop(0);
			
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
	
	// 진규 반배정 브금
	public static void hat_talk() {
		File bgm;
		AudioInputStream stream;
		AudioFormat format;
		DataLine.Info info;
		
		bgm = new File("sounds/hat3.wav");
		
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
	
	// 진규 그리핀도르
	public static void gryffindor() {
		File bgm;
		AudioInputStream stream;
		AudioFormat format;
		DataLine.Info info;
		
		bgm = new File("sounds/gryffindor.wav");
		
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
	
	public static void stage2_BgSound() {
		File bgm;
		AudioInputStream stream;
		AudioFormat format;
		DataLine.Info info;
		
		bgm = new File("sounds/stage2_bgsound2.wav");
		
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

	public static void stage3_backgroundSound() {
		File bgm;
		AudioInputStream stream;
		AudioFormat format;
		DataLine.Info info;
		
		bgm = new File("sounds/stage3_Background.wav");
		
		try {
			stream = AudioSystem.getAudioInputStream(bgm);
			format = stream.getFormat();
			info = new DataLine.Info(Clip.class, format);
			clip = (Clip)AudioSystem.getLine(info);
			clip.open(stream);
			FloatControl gainControl = 
				    (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(-9.0f); // Reduce volume by 10 decibels.
			clip.start();
			clip.loop(1);
			
		} catch (Exception e) {
			System.out.println("err : " + e);
			}
		
	}
	
	public static void stage3_sc() {
		File bgm;
		AudioInputStream stream;
		AudioFormat format;
		DataLine.Info info;
		
		bgm = new File("sounds/stage3_sc.wav");
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
	public static void stage3_fail() {
		File bgm;
		AudioInputStream stream;
		AudioFormat format;
		DataLine.Info info;
		
		bgm = new File("sounds/stage3_fail.wav");
		
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


	
	
	
	
	
	
	
	
	
	
	
	
	public static void door() {
		File bgm;
		AudioInputStream stream;
		AudioFormat format;
		DataLine.Info info;
		
		bgm = new File("sounds/door.wav");
		
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
	
	public static void loginEffect() {
		File bgm;
		AudioInputStream stream;
		AudioFormat format;
		DataLine.Info info;
		
		bgm = new File("sounds/loginEffect.wav");
		
		try {
			stream = AudioSystem.getAudioInputStream(bgm);
			format = stream.getFormat();
			info = new DataLine.Info(Clip.class, format);
			effect = (Clip)AudioSystem.getLine(info);
			effect.open(stream);
			
			//볼륨 조절 ( 증가 최대 6 , 감소 최대 9 )
			FloatControl gainControl = 
				    (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(6.0f); // Reduce volume by 10 decibels.
			
			effect.start();
			effect.loop(0);
			
		} catch (Exception e) {
			System.out.println("err : " + e);
			}
	}
	
	public static void btnEffect() {
		File bgm;
		AudioInputStream stream;
		AudioFormat format;
		DataLine.Info info;
		
		bgm = new File("sounds/btnEffect.wav");
		
		try {
			stream = AudioSystem.getAudioInputStream(bgm);
			format = stream.getFormat();
			info = new DataLine.Info(Clip.class, format);
			effect = (Clip)AudioSystem.getLine(info);
			effect.open(stream);
			effect.start();
			effect.loop(0);
			
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
