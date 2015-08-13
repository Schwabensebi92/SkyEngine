package com.own.gameengine.coreengine;

import com.own.gameengine.physicsengine.physics.Time;

public class CoreTiming {

	private static CoreTiming	instance;

	public static CoreTiming instance(double frameTime) {
		if (instance == null)
			instance = new CoreTiming(frameTime);
		return instance;
	}

	private double	frameTime;
	private double	startTime;
	private double	lastTime;
	private double	passedTime;
	private double	unprocessedTime;
	private boolean	didFrame;

	private CoreTiming(double frameTime) {
		this.frameTime = frameTime;
	}

	public void init() {
		startTime = 0;
		passedTime = 0;
		lastTime = Time.getTime();
		unprocessedTime = 0;
		didFrame = false;
	}

	public void cycle() {
		startTime = Time.getTime();
		passedTime = startTime - lastTime;
		lastTime = startTime;
		unprocessedTime += passedTime;
		didFrame = false;
	}

	public boolean hasFrame() {
		return unprocessedTime > frameTime;
	}

	public void frame() {
		didFrame = true;
		unprocessedTime -= frameTime;
	}

	public boolean didFrame() {
		return didFrame;
	}

	public static double getDelta() {
		if (instance == null)
			return 0.0;
		else
			return instance.frameTime;
	}
}
