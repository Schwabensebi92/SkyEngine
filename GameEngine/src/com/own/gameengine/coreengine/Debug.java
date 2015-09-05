package com.own.gameengine.coreengine;


import java.io.PrintStream;


public class Debug {
	
	private final static PrintStream	out		= System.out;
	private static boolean				enable	= true;
	
	public static void out(final String text) {
		if (enable) {
			out.println(text);
		}
	}
	
	public static void enableOutput() {
		enable = true;
	}
	
	public static void disableOutput() {
		enable = false;
	}
}
