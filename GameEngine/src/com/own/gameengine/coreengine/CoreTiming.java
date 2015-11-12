package com.own.gameengine.coreengine;


import com.own.gameengine.physicsengine.physics.Time;


public class CoreTiming {
	
	private double	frameTime;
	private double	startTime;
	private double	lastTime;
	private double	passedTime;
	private double	unprocessedTime;
	private boolean	didFrame;
	
	public CoreTiming(final double frameTime) {
		this.frameTime = frameTime;
	}
	
	public void initialize() {
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
	
	public double getDelta() {
		return frameTime;
	}
}
