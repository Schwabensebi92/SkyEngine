package com.own.gameengine.error;


public class Debug {
	
	private static boolean enable = true;
	
	public static void out(final Object out) {
		if (enable) {
			System.out.println(out);
		}
	}
}
