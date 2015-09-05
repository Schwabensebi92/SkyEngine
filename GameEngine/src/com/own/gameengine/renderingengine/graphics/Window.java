package com.own.gameengine.renderingengine.graphics;


import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.NULL;

import java.nio.ByteBuffer;

import org.lwjgl.glfw.GLFWvidmode;

import com.own.gameengine.coreengine.math.Vector2f;


public class Window {
	
	private long windowID;
	
	private final String	title;
	private final int		width;
	private final int		height;
	private final boolean	fullScreen;
	private final FrameRate	frameRate;
	private final boolean	resizable;
	
	public Window(final WindowSettings windowSettings) {
		title = windowSettings.getTitle();
		width = windowSettings.getWidth();
		height = windowSettings.getHeight();
		fullScreen = windowSettings.isFullscreen();
		frameRate = windowSettings.getFrameRate();
		resizable = windowSettings.isResizable();
	}
	
	public void initialize() throws LWJGLLibraryException {
		glfwDefaultWindowHints();
		glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, OpenGL.CONTEXT_VERSION_MAJOR);
		glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, OpenGL.CONTEXT_VERSION_MINOR);
		glfwWindowHint(GLFW_OPENGL_FORWARD_COMPAT, (OpenGL.FORWARD_COMPATIBILITY ? GL_TRUE : GL_FALSE));
		glfwWindowHint(GLFW_OPENGL_PROFILE, OpenGL.PROFILE);
		glfwWindowHint(GLFW_VISIBLE, GL_FALSE);
		glfwWindowHint(GLFW_RESIZABLE, (resizable ? GL_TRUE : GL_FALSE));
		
		if (fullScreen) {
			windowID = glfwCreateWindow(width, height, title, glfwGetPrimaryMonitor(), NULL);
		} else {
			windowID = glfwCreateWindow(width, height, title, NULL, NULL);
		}
		
		if (windowID == NULL)
			throw new LWJGLLibraryException("Failed to create a GLFW window");
			
		final ByteBuffer vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());
		glfwSetWindowPos(windowID, (GLFWvidmode.width(vidmode) - width) / 2, (GLFWvidmode.height(vidmode) - height) / 2);
		
		glfwMakeContextCurrent(windowID);
		
		glfwShowWindow(windowID);
	}
	
	public boolean isCloseRequested() {
		return glfwWindowShouldClose(windowID) == GL_TRUE;
	}
	
	public void render() {
		glfwSwapBuffers(windowID);
		glfwPollEvents();
	}
	
	public void dispose() {
		glfwDestroyWindow(windowID);
	}
	
	public long getWindowID() {
		return windowID;
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
