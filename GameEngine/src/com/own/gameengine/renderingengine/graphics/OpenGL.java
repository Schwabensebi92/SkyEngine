package com.own.gameengine.renderingengine.graphics;


import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL32.GL_DEPTH_CLAMP;

import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;

import com.own.gameengine.coreengine.Debug;
import com.own.gameengine.coreengine.math.Vector3f;


public class OpenGL {
	
	public final static int		CONTEXT_VERSION_MAJOR	= 3;
	public final static int		CONTEXT_VERSION_MINOR	= 2;
	public final static boolean	FORWARD_COMPATIBILITY	= true;
	public final static int		PROFILE					= GLFW_OPENGL_CORE_PROFILE;
	
	private static GLFWErrorCallback errorCallback;
	
	public static void initializeLWJGL() throws LWJGLLibraryException {
		errorCallback = Callbacks.errorCallbackPrint(System.err);
		glfwSetErrorCallback(errorCallback);
		
		if (GLFW.glfwInit() != GL11.GL_TRUE)
			throw new LWJGLLibraryException("Unable to initialize GLFW");
	}
	
	public static void initializeOpenGL() {
		GLContext.createFromCurrent();
		GL.createCapabilities(false);
		
		glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
		
		glFrontFace(GL_CW);
		glCullFace(GL_BACK);
		glEnable(GL_CULL_FACE);
		glEnable(GL_DEPTH_TEST);
		
		glEnable(GL_DEPTH_CLAMP);
		
		glEnable(GL_TEXTURE_2D);
		
		Debug.out("Powered by Open Graphics Library " + OpenGL.getOpenGLVersion());
	}
	
	public static void cleanUpLWJGL() {
		glfwTerminate();
	}
	
	public static void cleanUpOpenGL() {
	
	}
	
	public static void setClearColor(final Vector3f color) {
		glClearColor(color.getX(), color.getY(), color.getZ(), 1.0f);
	}
	
	public static void clearScreen() {
		// TODO: Stencil Buffer
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
	}
	
	public static void enableTextures(final boolean enable) {
		if (enable) {
			glEnable(GL_TEXTURE_2D);
		} else {
			glDisable(GL_TEXTURE_2D);
		}
	}
	
	public static void enableBlending(final boolean enable) {
		if (enable) {
			glEnable(GL_BLEND);
			glBlendFunc(GL_ONE, GL_ONE);
			glDepthMask(false);
			glDepthFunc(GL_EQUAL);
		} else {
			glDepthFunc(GL_LESS);
			glDepthMask(true);
			glDisable(GL_BLEND);
		}
	}
	
	public static void unbindTextures() {
		glBindTexture(GL_TEXTURE_2D, 0);
	}
	
	public static String getOpenGLVersion() {
		return glGetString(GL_VERSION);
	}
}
