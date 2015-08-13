package com.own.gameengine.renderingengine.graphics;

import com.own.gameengine.coreengine.math.Vector2f;

public class Display {

	private String		title;
	private int			width;
	private int			height;
	private boolean		fullScreen;
	private FrameRate	frameRate;
	private boolean		resizable;

	public Display(final String title, final int width, final int height, final boolean fullScreen, final FrameRate frameRate,
			boolean resizable) {
		this.title = title;
		this.width = width;
		this.height = height;
		this.fullScreen = fullScreen;
		this.frameRate = frameRate;
		this.resizable = resizable;
	}

	public Display(final String title, final Resolution resolution, final boolean fullScreen, final FrameRate frameRate, boolean resizable) {
		this(title, resolution.getWidth(), resolution.getHeight(), fullScreen, frameRate, resizable);
	}

	public String getTitle() {
		return title;
	}

	public float getAspectRatio() {
		return (float) width / (float) height;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
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

	public Vector2f getCenter() {
		return new Vector2f(width / 2.0f, height / 2.0f);
	}
}
