package com.own.gameengine.inputengine;


public abstract class InputDevice {
	
	private long windowID;
	
	public InputDevice() {
		windowID = -1;
	}
	
	protected void initialize(final long windowID) {
		this.windowID = windowID;
	}
	
	/**
	 * Has to be called after the InputEngine updated the SceneGraph.
	 */
	protected abstract void storeStatesForNextCycle();
	
	protected abstract void cleanUp();
	
	protected long getWindowID() {
		return windowID;
	}
}
