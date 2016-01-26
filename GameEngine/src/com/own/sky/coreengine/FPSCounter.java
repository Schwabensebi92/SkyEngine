package com.own.sky.coreengine;

import com.own.sky.physicsengine.timingengine.Timekeeper;

public class FPSCounter {

	private final static float	timeSpan	= 1.0f;

	private Timekeeper			timekeeper;
	private int					framesInCurrentTimeSpan;

	public FPSCounter() {
		this.timekeeper = new Timekeeper(false);
		this.framesInCurrentTimeSpan = 0;
	}

	public void start() {
		timekeeper.start();
		framesInCurrentTimeSpan = 0;
	}

	public void stop() {
		timekeeper.stop();
	}

	public void increase() {
		increaseWithAmount(1);
	}

	public void increaseWithAmount(int frameAmount) {
		this.framesInCurrentTimeSpan += frameAmount;
	}

	public boolean hasNewFPSData() {
		return timekeeper.getPassedTime() >= timeSpan;
	}

	public int getFPSAndReset() {
		int fps = (int) ((framesInCurrentTimeSpan / timekeeper.getPassedTime()) + 0.01);
		this.framesInCurrentTimeSpan = 0;
		this.timekeeper.start();

		return fps;
	}
}
