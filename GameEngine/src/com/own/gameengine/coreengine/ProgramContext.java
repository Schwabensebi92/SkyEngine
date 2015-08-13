package com.own.gameengine.coreengine;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.ByteBuffer;

import javax.imageio.ImageIO;

import org.lwjgl.opengl.Display;

public class ProgramContext {

	public static void setIcon(String fileName) {
		ByteBuffer[] list = load(new File("./res/icon/" + fileName));
		Display.setIcon(list);
	}

	private static ByteBuffer[] load(File file)
	{
		BufferedImage image = null;
		try {
			image = ImageIO.read(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		ByteBuffer[] bufferArray = null;
		String OS = System.getProperty("os.name").toUpperCase();
		if (OS.contains("WIN")) {
			bufferArray = new ByteBuffer[2];
			bufferArray[0] = loadInstance(image, 16);
			bufferArray[1] = loadInstance(image, 32);
		} else if (OS.contains("MAC")) {
			bufferArray = new ByteBuffer[1];
			bufferArray[0] = loadInstance(image, 128);
		} else {
			bufferArray = new ByteBuffer[1];
			bufferArray[0] = loadInstance(image, 32);
		}
		return bufferArray;
	}

	private static ByteBuffer loadInstance(BufferedImage image, int dimension)
	{
		BufferedImage scaledIcon = new BufferedImage(dimension, dimension, BufferedImage.TYPE_INT_ARGB_PRE);
		Graphics2D g = scaledIcon.createGraphics();
		double ratio = getIconRatio(image, scaledIcon);
		double width = image.getWidth() * ratio;
		double height = image.getHeight() * ratio;
		g.drawImage(image, (int) ((scaledIcon.getWidth() - width) / 2), (int) ((scaledIcon.getHeight() - height) / 2), (int) (width),
				(int) (height), null);
		g.dispose();
		return convertToByteBuffer(scaledIcon);
	}

	private static ByteBuffer convertToByteBuffer(BufferedImage image)
	{
		byte[] buffer = new byte[image.getWidth() * image.getHeight() * 4];
		int counter = 0;
		for (int i = 0; i < image.getHeight(); i++)
			for (int j = 0; j < image.getWidth(); j++) {
				int colorSpace = image.getRGB(j, i);
				buffer[counter + 0] = (byte) ((colorSpace << 8) >> 24);
				buffer[counter + 1] = (byte) ((colorSpace << 16) >> 24);
				buffer[counter + 2] = (byte) ((colorSpace << 24) >> 24);
				buffer[counter + 3] = (byte) (colorSpace >> 24);
				counter += 4;
			}
		return ByteBuffer.wrap(buffer);
	}

	private static double getIconRatio(BufferedImage src, BufferedImage icon)
	{
		double ratio = 1;
		if (src.getWidth() > icon.getWidth())
			ratio = (double) (icon.getWidth()) / src.getWidth();
		else
			ratio = (int) (icon.getWidth() / src.getWidth());
		if (src.getHeight() > icon.getHeight())
		{
			double r2 = (double) (icon.getHeight()) / src.getHeight();
			if (r2 < ratio)
				ratio = r2;
		}
		else
		{
			double r2 = (int) (icon.getHeight() / src.getHeight());
			if (r2 < ratio)
				ratio = r2;
		}
		return ratio;
	}
}
