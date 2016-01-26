package com.own.sky.debug;


public class Debug {
	
	private static boolean enable = true;
	
	public static void out(final Object out) {
		if (enable) {
			System.out.println(out);
		}
	}
	
	public static void enable() {
		enable = true;
	}
	
	public static void disable() {
		enable = false;
	}
}
