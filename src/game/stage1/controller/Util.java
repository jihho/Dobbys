package game.stage1.controller;

import java.awt.Color;

public class Util {
	public static int rand(int max) {
		return (int)(Math.random()*(max + 1));
	}
	
	public static int rand(int min, int max) {
		return min + (int)(Math.random()*(max - min + 1));
	}
	
	public static boolean prob100(int r) {
		return (int)(Math.random()*100) <= r;
	}
	
	public static Color randColor() {
		return new Color(rand(255), rand(255), rand(255));
	}
	
	public static Color randColor(int min, int max) {
		return new Color(rand(min, max), rand(min, max), rand(min, max));
	}
}
