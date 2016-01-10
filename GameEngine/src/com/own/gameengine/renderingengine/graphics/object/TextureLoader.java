package com.own.gameengine.renderingengine.graphics.object;


import static org.lwjgl.opengl.GL11.*;

import java.io.*;
import java.nio.*;
import java.nio.channels.FileChannel;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL12;
import org.lwjgl.stb.STBImage;


public class TextureLoader {
	
	private final static int BYTE_PER_PIXEL = 4;
	
	/**
	 * Creates an openGL texture from the image specified by <code>fileName</code>.
	 * 
	 * @param fileName
	 *            File name relative to the game engines texture resource folder.
	 * @return Returns the texture id for the newly created texture.
	 * @throws IOException
	 *             If loading the texture fails.
	 * 
	 * @see <a href="http://stackoverflow.com/a/33858800">stackoverflow.com/33858800</a>
	 */
	public static int loadTexture(final String fileName) throws IOException {
		ByteBuffer imageRaw = loadImageFile("./res/textures/" + fileName);
		
		IntBuffer imageWidthBuffer = BufferUtils.createIntBuffer(1);
		IntBuffer imageHeightBuffer = BufferUtils.createIntBuffer(1);
		IntBuffer numComponentsBuffer = BufferUtils.createIntBuffer(1);
		
		ByteBuffer image = STBImage.stbi_load_from_memory(imageRaw, imageWidthBuffer, imageHeightBuffer, numComponentsBuffer,
				BYTE_PER_PIXEL);
		if (image == null)
			throw new RuntimeException("Failed to load texture: " + STBImage.stbi_failure_reason());
			
		int imageWidth = imageWidthBuffer.get(0);
		int imageHeight = imageHeightBuffer.get(0);
		int numComponents = numComponentsBuffer.get(0);
		System.out.println("Tex NumComp: " + numComponents);
		
		int textureID = glGenTextures();
		glBindTexture(GL_TEXTURE_2D, textureID);
		
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL12.GL_CLAMP_TO_EDGE);
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL12.GL_CLAMP_TO_EDGE);
		
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
		
		glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA8, imageWidth, imageHeight, 0, GL_RGBA, GL_UNSIGNED_BYTE, image);
		
		return textureID;
	}
	
	private static ByteBuffer loadImageFile(final String fileName) throws IOException {
		File file = new File(fileName);
		
		FileInputStream fileInputStream = new FileInputStream(file);
		FileChannel fileChannel = fileInputStream.getChannel();
		
		ByteBuffer buffer = BufferUtils.createByteBuffer((int) fileChannel.size() + 1);
		
		while (fileChannel.read(buffer) != -1) {
			;
		}
		
		fileInputStream.close();
		fileChannel.close();
		buffer.flip();
		
		return buffer;
	}
}
