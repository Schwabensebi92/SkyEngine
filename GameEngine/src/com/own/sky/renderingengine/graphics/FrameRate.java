package com.own.sky.renderingengine.graphics;


public enum FrameRate {
	
	FPS_120(120),
	FPS_60(60),
	FPS_40(40),
	FPS_30(30),
	FPS_24(24);
	
	private int frameRate;
	
	private FrameRate(final int frameRate) {
		this.frameRate = frameRate;
	}
	
	public int value() {
		return frameRate;
	}
}
