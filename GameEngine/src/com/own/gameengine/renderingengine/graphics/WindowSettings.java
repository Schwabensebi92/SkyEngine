package com.own.gameengine.renderingengine.graphics;


public class WindowSettings {
	
	private final String	title;
	private final int		width;
	private final int		height;
	private final boolean	fullScreen;
	private final FrameRate	frameRate;
	private final boolean	resizable;
	
	public WindowSettings(final String title, final int width, final int height, final boolean fullScreen, final FrameRate frameRate,
			final boolean resizable) {
		this.title = title;
		this.width = width;
		this.height = height;
		this.fullScreen = fullScreen;
		this.frameRate = frameRate;
		this.resizable = resizable;
	}
	
	public WindowSettings(final String title, final Resolution resolution, final boolean fullScreen, final FrameRate frameRate,
			final boolean resizable) {
		this.title = title;
		width = resolution.getWidth();
		height = resolution.getHeight();
		this.fullScreen = fullScreen;
		this.frameRate = frameRate;
		this.resizable = resizable;
	}
	
	public String getTitle() {
		return title;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public float getAspectRatio() {
		return (float) width / (float) height;
	}
	
	public boolean isFullscreen() {
		return fullScreen;
	}
	
	public FrameRate getFrameRate() {
		return frameRate;
	}
	
	public boolean isResizable() {
		return resizable;
	}
}
