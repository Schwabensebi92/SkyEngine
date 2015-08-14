package com.own.gameengine.coreengine.input;


import java.nio.DoubleBuffer;

import org.lwjgl.BufferUtils;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWMouseButtonCallback;

import com.own.gameengine.coreengine.math.Vector2f;


public class Mouse extends GLFWMouseButtonCallback {
	
	private static final int	GLFW_BUTTON_DOWN	= 1;
	private static final int	GLFW_BUTTON_UP		= 0;
	
	private static final int NUM_MOUSEBUTTONS = 5;
	
	private long		windowID;
	private boolean[]	lastButtons	= new boolean[NUM_MOUSEBUTTONS];
	
	public void initialize(long windowID) {
		this.windowID = windowID;
		GLFW.glfwSetMouseButtonCallback(windowID, this);
	}
	
	public boolean getMouseButton(final int mouseButton) {
		return GLFW.glfwGetMouseButton(windowID, mouseButton) == GLFW_BUTTON_DOWN;
	}
	
	public boolean getMouseDown(final int mouseButton) {
		return getMouseButton(mouseButton) && !lastButtons[mouseButton];
	}
	
	public boolean getMouseUp(final int mouseButton) {
		return !getMouseButton(mouseButton) && lastButtons[mouseButton];
	}
	
	public Vector2f getMousePosition() {
		DoubleBuffer x = BufferUtils.createDoubleBuffer(1);
		DoubleBuffer y = BufferUtils.createDoubleBuffer(1);
		GLFW.glfwGetCursorPos(windowID, x, y);
		return new Vector2f((float) x.get(0), (float) y.get(0));
	}
	
	public void setCursorEnabled(final boolean enabled) {
		if (enabled)
			GLFW.glfwSetInputMode(windowID, GLFW.GLFW_CURSOR, GLFW.GLFW_CURSOR_NORMAL);
		else
			GLFW.glfwSetInputMode(windowID, GLFW.GLFW_CURSOR, GLFW.GLFW_CURSOR_DISABLED);
	}
	
	public void update() {
		for (int i = 0; i < NUM_MOUSEBUTTONS; i++) {
			lastButtons[i] = getMouseButton(i);
		}
	}
	
	public void cleanUp() {
		release();
	}
	
	@Override
	public void invoke(long window, int button, int action, int mods) {
	
	}
}
