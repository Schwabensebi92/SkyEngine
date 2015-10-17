package com.own.gameengine.coreengine;


import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.ByteBuffer;

import javax.imageio.ImageIO;


public class ProgramContext {
	
	public static void setIcon(final String fileName) {
		// TODO: Uncomment the ByteBuffer and insert GLFW setWindowIcon method
		// ByteBuffer[] list = load(new File("./res/icon/" + fileName));
	}
	
	private static ByteBuffer[] load(final File file) {
		BufferedImage image = null;
		try {
			image = ImageIO.read(file);
		} catch (final IOException e) {
			e.printStackTrace();
		}
		ByteBuffer[] bufferArray = null;
		final String OS = System.getProperty("os.name").toUpperCase();
		if (OS.contains("WIN")) {
			bufferArray = new ByteBuffer[2];
			bufferArray[0] = scaleImage(image, 16);
			bufferArray[1] = scaleImage(image, 32);
		} else if (OS.contains("MAC")) {
			bufferArray = new ByteBuffer[1];
			bufferArray[0] = scaleImage(image, 128);
		} else {
			bufferArray = new ByteBuffer[1];
			bufferArray[0] = scaleImage(image, 32);
		}
		return bufferArray;
	}
	
	private static ByteBuffer scaleImage(final BufferedImage image, final int dimension) {
		final BufferedImage scaledIcon = new BufferedImage(dimension, dimension, BufferedImage.TYPE_INT_ARGB_PRE);
		final Graphics2D g = scaledIcon.createGraphics();
		final double ratio = getIconRatio(image, scaledIcon);
		final double width = image.getWidth() * ratio;
		final double height = image.getHeight() * ratio;
		g.drawImage(image, (int) ((scaledIcon.getWidth() - width) / 2), (int) ((scaledIcon.getHeight() - height) / 2), (int) (width),
				(int) (height), null);
		g.dispose();
		return convertToByteBuffer(scaledIcon);
	}
	
	private static ByteBuffer convertToByteBuffer(final BufferedImage image) {
		final byte[] buffer = new byte[image.getWidth() * image.getHeight() * 4];
		int counter = 0;
		for (int y = 0; y < image.getHeight(); y++) {
			for (int x = 0; x < image.getWidth(); x++) {
				final int pixel = image.getRGB(x, y);
				buffer[counter + 0] = (byte) (pixel >> 16);
				buffer[counter + 1] = (byte) (pixel >> 8);
				buffer[counter + 2] = (byte) (pixel >> 0);
				buffer[counter + 3] = (byte) (pixel >> 24);
				counter += 4;
			}
		}
		return ByteBuffer.wrap(buffer);
	}
	
	private static double getIconRatio(final BufferedImage src, final BufferedImage icon) {
		double widthRatio = (double) (icon.getWidth()) / src.getWidth();
		double heightRatio = (double) (icon.getHeight()) / src.getHeight();
		return Math.min(widthRatio, heightRatio);
	}
}
