package com.own.gameengine.inputengine;


import static org.lwjgl.glfw.GLFW.*;


public enum MouseButtons {
	
	MOUSE_BUTTON_1(GLFW_MOUSE_BUTTON_1),
	MOUSE_BUTTON_2(GLFW_MOUSE_BUTTON_2),
	MOUSE_BUTTON_3(GLFW_MOUSE_BUTTON_3),
	MOUSE_BUTTON_4(GLFW_MOUSE_BUTTON_4),
	MOUSE_BUTTON_5(GLFW_MOUSE_BUTTON_5),
	MOUSE_BUTTON_6(GLFW_MOUSE_BUTTON_6),
	MOUSE_BUTTON_7(GLFW_MOUSE_BUTTON_7),
	MOUSE_BUTTON_8(GLFW_MOUSE_BUTTON_8),
	MOUSE_BUTTON_LAST(GLFW_MOUSE_BUTTON_LAST),
	MOUSE_BUTTON_LEFT(GLFW_MOUSE_BUTTON_LEFT),
	MOUSE_BUTTON_RIGHT(GLFW_MOUSE_BUTTON_RIGHT),
	MOUSE_BUTTON_MIDDLE(GLFW_MOUSE_BUTTON_MIDDLE);
	
	public final static int NUM_BUTTONS = MOUSE_BUTTON_LAST.getButtonCode() + 1;
	
	private int buttonCode;
	
	private MouseButtons(final int buttonCode) {
		this.buttonCode = buttonCode;
	}
	
	protected int getButtonCode() {
		return buttonCode;
	}
}
