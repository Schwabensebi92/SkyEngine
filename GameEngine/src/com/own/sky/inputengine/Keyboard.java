package com.own.sky.inputengine;


import static org.lwjgl.glfw.GLFW.*;


public class Keyboard extends InputDevice {
	
	private boolean[] keyStatesPreviousCycle;
	
	@Override
	protected void initialize(final long windowID) {
		super.initialize(windowID);
		keyStatesPreviousCycle = new boolean[KeyboardKeys.NUM_KEYS];
	}
	
	@Override
	protected void storeStatesForNextCycle() {
		for (KeyboardKeys key : KeyboardKeys.values()) {
			keyStatesPreviousCycle[key.getKeyCode()] = isKeyDown(key);
		}
	}
	
	public boolean isKeyDown(final KeyboardKeys key) {
		return glfwGetKey(getWindowID(), key.getKeyCode()) == GLFW_PRESS;
	}
	
	public boolean isKeyPressed(final KeyboardKeys key) {
		return isKeyDown(key) && !keyStatesPreviousCycle[key.getKeyCode()];
	}
	
	public boolean isKeyReleased(final KeyboardKeys key) {
		return !isKeyDown(key) && keyStatesPreviousCycle[key.getKeyCode()];
	}
	
	@Override
	protected void cleanUp() {
	
	}
}