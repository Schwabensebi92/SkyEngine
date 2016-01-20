package com.own.gameengine.coreengine;

import com.own.gameengine.physicsengine.timingengine.Time;

public class UpdateTimer {

	private final static long	UPS						= 60;
	private final static long	UPS_NANOSECONDS_OPTIMAL	= Time.SECOND / UPS;

	private static UpdateTimer	instance;

	private long				lastUpdateTime;
	private double				delta;

	public UpdateTimer() {
		lastUpdateTime = 0;
		instance = this;
	}

	public void start() {
		lastUpdateTime = Time.getNanoTime();
	}

	public boolean isOver() {
		return (Time.getTime() - lastUpdateTime) > UPS_NANOSECONDS_OPTIMAL;
	}

	public void reset() {
		long currentUpdateTime = Time.getNanoTime();
		delta = (currentUpdateTime - lastUpdateTime) / (double) UPS_NANOSECONDS_OPTIMAL;
		lastUpdateTime = currentUpdateTime;
	}

	public static double getDelta() {
		if (instance != null) {
			return instance.delta;
		} else {
			return 0;
		}
	}
}
