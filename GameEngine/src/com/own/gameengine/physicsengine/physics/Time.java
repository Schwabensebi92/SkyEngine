package com.own.gameengine.physicsengine.physics;

public class Time {

	public final static long	SECOND	= 1_000_000_000l;

	public static double getTime() {
		return (double) getNanoTime() / (double) SECOND;
	}

	public static long getNanoTime() {
		return System.nanoTime();
	}
}
