package com.own.gameengine.coreengine.input;

import org.lwjgl.*;

import com.own.gameengine.coreengine.math.*;

public class Mouse {

	private static final int NUM_MOUSEBUTTONS = 5;
	private static boolean[] lastMouse = new boolean[NUM_MOUSEBUTTONS];

	public static void initialize() {
		try {
			org.lwjgl.input.Mouse.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
	}

	public static boolean getMouseButton(final int mouseButton)
	{
		return org.lwjgl.input.Mouse.isButtonDown(mouseButton);
	}

	public static boolean getMouseDown(final int mouseButton)
	{
		return getMouseButton(mouseButton) && !lastMouse[mouseButton];
	}

	public static boolean getMouseUp(final int mouseButton)
	{
		return !getMouseButton(mouseButton) && lastMouse[mouseButton];
	}

	public static Vector2f getMousePosition()
	{
		return new Vector2f(org.lwjgl.input.Mouse.getX(), org.lwjgl.input.Mouse.getY());
	}

	public static void setMousePosition(final Vector2f pos)
	{
		org.lwjgl.input.Mouse.setCursorPosition((int) pos.getX(), (int) pos.getY());
	}

	public static void setCursorEnabled(final boolean enabled)
	{
		org.lwjgl.input.Mouse.setGrabbed(!enabled);
	}

	public static Vector2f getPosition() {
		return new Vector2f(org.lwjgl.input.Mouse.getX(), org.lwjgl.input.Mouse.getY());
	}

	public static void update()
	{
		for (int i = 0; i < NUM_MOUSEBUTTONS; i++) {
			lastMouse[i] = getMouseButton(i);
		}
	}

	public static void cleanUp() {
		org.lwjgl.input.Mouse.destroy();
	}
}
