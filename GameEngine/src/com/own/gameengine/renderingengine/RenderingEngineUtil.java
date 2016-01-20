package com.own.gameengine.renderingengine;


import java.nio.*;
import java.util.ArrayList;

import org.lwjgl.BufferUtils;

import com.own.gameengine.math.matrix.Matrix4f;
import com.own.gameengine.renderingengine.graphics.object.Vertex;


public class RenderingEngineUtil {
	
	public static FloatBuffer createFloatBuffer(final int size) {
		return BufferUtils.createFloatBuffer(size);
	}
	
	public static IntBuffer createIntBuffer(final int size) {
		return BufferUtils.createIntBuffer(size);
	}
	
	public static FloatBuffer createFlippedBuffer(final Vertex[] vertices) {
		FloatBuffer buffer = createFloatBuffer(vertices.length * Vertex.SIZE);
		for (int i = 0; i < vertices.length; i++) {
			buffer.put(vertices[i].getPosition().getX());
			buffer.put(vertices[i].getPosition().getY());
			buffer.put(vertices[i].getPosition().getZ());
			buffer.put(vertices[i].getTextureCoordinate().getX());
			buffer.put(vertices[i].getTextureCoordinate().getY());
			buffer.put(vertices[i].getNormal().getX());
			buffer.put(vertices[i].getNormal().getY());
			buffer.put(vertices[i].getNormal().getZ());
		}
		buffer.flip();
		return buffer;
	}
	
	public static IntBuffer createFlippedBuffer(final int[] indices) {
		IntBuffer buffer = createIntBuffer(indices.length);
		buffer.put(indices);
		buffer.flip();
		return buffer;
	}
	
	public static FloatBuffer createFlippedBuffer(final Matrix4f matrix) {
		FloatBuffer buffer = createFloatBuffer(4 * 4);
		// OpenGL uses Column-major-order
		for (int m = 0; m < 4; m++) {
			for (int n = 0; n < 4; n++) {
				buffer.put(matrix.get(m, n));
			}
		}
		buffer.flip();
		return buffer;
	}
	
	public static String[] removeEmptyStrings(final String[] strings) {
		ArrayList<String> result = new ArrayList<>();
		for (int i = 0; i < strings.length; i++) {
			if (!strings[i].equals("")) {
				result.add(strings[i]);
			}
		}
		
		String[] resultArray = new String[result.size()];
		result.toArray(resultArray);
		return resultArray;
	}
	
	public static int[] toIntArray(final Integer[] integerArray) {
		int[] intArray = new int[integerArray.length];
		
		for (int i = 0; i < integerArray.length; i++) {
			intArray[i] = integerArray[i].intValue();
		}
		
		return intArray;
	}
}
