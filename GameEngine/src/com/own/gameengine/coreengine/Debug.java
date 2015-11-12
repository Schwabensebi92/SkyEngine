package com.own.gameengine.coreengine;


public class Debug {
	
	private static boolean enable = true;
	
	public static void out(final Object out) {
		if (enable) {
			System.out.println(out);
		}
	}
	
	public static void enableOutput() {
		enable = true;
	}
	
	public static void disableOutput() {
		enable = false;
	}
}
