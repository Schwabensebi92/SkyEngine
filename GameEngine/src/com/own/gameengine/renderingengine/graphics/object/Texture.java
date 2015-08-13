package com.own.gameengine.renderingengine.graphics.object;

import static org.lwjgl.opengl.GL11.*;

import java.io.*;

import org.newdawn.slick.opengl.*;

public class Texture {

	private int id;

	public Texture(String fileName) {
		this(loadTexture(fileName));
	}

	public Texture(int id) {
		this.id = id;
	}

	public void bind() {
		glBindTexture(GL_TEXTURE_2D, id);
	}

	public int getID() {
		return id;
	}

	private static int loadTexture(String fileName) {
		int id = 0;

		String[] splitArray = fileName.split("\\.");
		String extension = splitArray[splitArray.length - 1];

		try {
			id = TextureLoader.getTexture(extension,
					new FileInputStream(new File("./res/textures/" + fileName))).getTextureID();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}

		return id;
	}
}
