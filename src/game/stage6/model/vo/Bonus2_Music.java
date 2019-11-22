package game.stage6.model.vo;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

public class Bonus2_Music {
	public static Clip clip;
	
	public static void stage6_bg() {
		File bgm;
		AudioInputStream stream;
		AudioFormat format;
		DataLine.Info info;
		
		bgm = new File("sounds/stage6_bg.wav");
		
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
	
	//효과음 종료
	public static void intoBgmStop() {
		clip.stop();
		clip.close();
	}
}
