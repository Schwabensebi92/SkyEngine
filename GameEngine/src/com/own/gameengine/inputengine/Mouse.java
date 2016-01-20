package com.own.gameengine.inputengine;


import static org.lwjgl.glfw.GLFW.*;

import java.nio.DoubleBuffer;

import org.lwjgl.BufferUtils;

import com.own.gameengine.math.Vector2f;


public class Mouse extends InputDevice {
	
	private boolean[]	buttonStatesPreviousCycle;
	private Vector2f	mousePositionPreviousCycle;
	
	@Override
	protected void initialize(final long windowID) {
		super.initialize(windowID);
		buttonStatesPreviousCycle = new boolean[MouseButtons.NUM_BUTTONS];
		mousePositionPreviousCycle = getMousePosition();
	}
	
	@Override
	protected void storeStatesForNextCycle() {
		for (MouseButtons button : MouseButtons.values()) {
			buttonStatesPreviousCycle[button.getButtonCode()] = isButtonDown(button);
		}
		
		mousePositionPreviousCycle = getMousePosition();
	}
	
	public boolean isButtonDown(final MouseButtons mouseButton) {
		return glfwGetMouseButton(getWindowID(), mouseButton.getButtonCode()) == GLFW_PRESS;
	}
	
	public boolean isButtonPressed(final MouseButtons mouseButton) {
		return isButtonDown(mouseButton) && !buttonStatesPreviousCycle[mouseButton.getButtonCode()];
	}
	
	public boolean isButtonReleased(final MouseButtons mouseButton) {
		return !isButtonDown(mouseButton) && buttonStatesPreviousCycle[mouseButton.getButtonCode()];
	}
	
	public Vector2f getMousePosition() {
		DoubleBuffer x = BufferUtils.createDoubleBuffer(1);
		DoubleBuffer y = BufferUtils.createDoubleBuffer(1);
		glfwGetCursorPos(getWindowID(), x, y);
		return new Vector2f((float) x.get(0), (float) y.get(0));
	}
	
	public Vector2f getMousePositionDelta() {
		return getMousePosition().sub(mousePositionPreviousCycle);
	}
	
	public void setCursorHidden(final boolean enabled) {
		if (enabled) {
			glfwSetInputMode(getWindowID(), GLFW_CURSOR, GLFW_CURSOR_HIDDEN);
		} else {
			glfwSetInputMode(getWindowID(), GLFW_CURSOR, GLFW_CURSOR_NORMAL);
		}
	}
	
	public void setCursorEnabled(final boolean enabled) {
		if (enabled) {
			glfwSetInputMode(getWindowID(), GLFW_CURSOR, GLFW_CURSOR_NORMAL);
		} else {
			glfwSetInputMode(getWindowID(), GLFW_CURSOR, GLFW_CURSOR_DISABLED);
		}
	}
	
	@Override
	protected void cleanUp() {
	
	}
}
