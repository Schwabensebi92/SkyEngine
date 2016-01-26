package com.own.sky.renderingengine.graphics;


public enum Resolution {
	
	RES_1920x1080(1920, 1080),
	RES_1080x720(1080, 720),
	RES_800x600(800, 600),
	RES_720x360(720, 360),
	RES_720x480(720, 480),
	RES_480x320(480, 320),
	RES_360x240(360, 240);
	
	private int width;
	private int height;
	
	private Resolution(final int width, final int height) {
		this.width = width;
		this.height = height;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
}
