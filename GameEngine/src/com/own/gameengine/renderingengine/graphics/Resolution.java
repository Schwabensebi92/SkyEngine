package com.own.gameengine.renderingengine.graphics;

public enum Resolution {

	Res1920x1080(1920, 1080),
	Res1080x720(1080, 720),
	Res800x600(800, 600),
	Res720x360(720, 360),
	Res720x480(720, 480),
	Res480x320(480, 320),
	Res360x240(360, 240);

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
