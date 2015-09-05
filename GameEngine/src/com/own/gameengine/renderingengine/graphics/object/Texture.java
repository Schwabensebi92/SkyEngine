package com.own.gameengine.renderingengine.graphics.object;


import static org.lwjgl.opengl.GL11.*;


public class Texture {
	
	private final int id;
	
	public Texture(final String fileName) {
		this(loadTexture(fileName));
	}
	
	public Texture(final int id) {
		this.id = id;
	}
	
	public void bind() {
		glBindTexture(GL_TEXTURE_2D, id);
	}
	
	public int getID() {
		return id;
	}
	
	private static int loadTexture(final String fileName) {
		int id = 0;
		
		final String[] splitArray = fileName.split("\\.");
		final String extension = splitArray[splitArray.length - 1];
		
		try {
			id = TextureLoader.loadTexture(fileName);
		} catch (final Exception e) {
			e.printStackTrace();
		}
		
		return id;
	}
}
