package com.own.gameengine.renderingengine;

import java.nio.*;
import java.util.ArrayList;

import org.lwjgl.BufferUtils;

import com.own.gameengine.coreengine.math.matrix.Matrix4f;
import com.own.gameengine.renderingengine.graphics.object.Vertex;

public class RenderingEngineUtil {

	public static FloatBuffer createFloatBuffer(int size) {
		return BufferUtils.createFloatBuffer(size);
	}

	public static IntBuffer createIntBuffer(int size) {
		return BufferUtils.createIntBuffer(size);
	}

	public static FloatBuffer createFlippedBuffer(Vertex[] vertices) {
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

	public static IntBuffer createFlippedBuffer(int[] indices) {
		IntBuffer buffer = createIntBuffer(indices.length);
		buffer.put(indices);
		buffer.flip();
		return buffer;
	}

	public static FloatBuffer createFlippedBuffer(Matrix4f matrix) {
		FloatBuffer buffer = createFloatBuffer(4 * 4);
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				buffer.put(matrix.get(i, j));
			}
		}
		buffer.flip();
		return buffer;
	}

	public static String[] removeEmptyStrings(String[] strings) {
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

	public static int[] toIntArray(Integer[] integerArray) {
		int[] intArray = new int[integerArray.length];

		for (int i = 0; i < integerArray.length; i++) {
			intArray[i] = integerArray[i].intValue();
		}

		return intArray;
	}
}
