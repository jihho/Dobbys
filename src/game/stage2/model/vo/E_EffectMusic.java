package game.stage2.model.vo;

import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

public class E_EffectMusic {
	public static Clip clip;
	
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
			clip = (Clip)AudioSystem.getLine(info);
			clip.open(stream);
			clip.start();
			
			
		} catch (Exception e) {
			System.out.println("err : " + e);
			}
		
	}
	
	public static void intoBgmStop() {
		clip.stop();
		clip.close();
	}
	
}
