package com.own.sky.physicsengine.timingengine;

public class Time {

	public final static long	SECOND	= 1_000_000_000l;

	public static double getTime() {
		return (double) getNanoTime() / (double) SECOND;
	}

	public static long getNanoTime() {
		return System.nanoTime();
	}
}
