package com.own.gameengine.renderingengine.graphics;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL32.GL_DEPTH_CLAMP;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.*;

import com.own.gameengine.coreengine.Debug;
import com.own.gameengine.coreengine.math.Vector3f;

public class OpenGL {

	public static void initDisplay(Display display) {
		try {
			org.lwjgl.opengl.Display.setTitle(display.getTitle());
			org.lwjgl.opengl.Display.setResizable(display.isResizable());
			if (display.isFullscreen()) {
				org.lwjgl.opengl.Display.setFullscreen(true);
			} else {
				org.lwjgl.opengl.Display.setDisplayMode(new DisplayMode(display.getWidth(), display.getHeight()));
				org.lwjgl.opengl.Display.create(new PixelFormat(),
						new ContextAttribs(3, 2).withForwardCompatible(true)
								.withProfileCore(true));
			}

			Debug.out("Powered by Open Graphics Library " + OpenGL.getOpenGLVersion());
		} catch (LWJGLException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public static void initGraphics() {
		glClearColor(0.0f, 0.0f, 0.0f, 0.0f);

		glFrontFace(GL_CW);
		glCullFace(GL_BACK);
		glEnable(GL_CULL_FACE);
		glEnable(GL_DEPTH_TEST);

		glEnable(GL_DEPTH_CLAMP);

		glEnable(GL_TEXTURE_2D);
	}

	public static void setClearColor(Vector3f color) {
		glClearColor(color.getX(), color.getY(), color.getZ(), 1.0f);
	}

	public static void clearScreen() {
		// TODO: Stencil Buffer
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
	}

	public static void enableTextures(boolean enable) {
		if (enable) {
			glEnable(GL_TEXTURE_2D);
		} else {
			glDisable(GL_TEXTURE_2D);
		}
	}

	public static void enableBlending(boolean enable) {
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

	public static void render() {
		org.lwjgl.opengl.Display.update();
	}

	public static void dispose() {
		org.lwjgl.opengl.Display.destroy();
	}

	public static boolean isCloseRequested() {
		return org.lwjgl.opengl.Display.isCloseRequested();
	}

	public static String getOpenGLVersion() {
		return glGetString(GL_VERSION);
	}
}
