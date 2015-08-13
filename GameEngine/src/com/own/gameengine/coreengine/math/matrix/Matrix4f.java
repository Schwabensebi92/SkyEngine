package com.own.gameengine.coreengine.math.matrix;

public class Matrix4f {

	//@formatter:off
	/*
	 * matrix[x][y]
	 * 
	 *   → x
	 * ↓ [][][][]
	 * y [][][][]
	 *   [][][][]
	 *   [][][][]
	 */
	//formatter:on

	protected float[][]	matrix;

	public Matrix4f() {
		matrix = new float[4][4];
	}

	public Matrix4f(Matrix4f source) {
		matrix = new float[4][4];
		for (int x = 0; x < 4; x++) {
			for (int y = 0; y < 4; y++) {
				matrix[x][y] = source.matrix[x][y];
			}
		}
	}

	public Matrix4f mul(Matrix4f matrix) {
		Matrix4f newMatrix = new Matrix4f();
		for (int y = 0; y < 4; y++) {
			for (int x = 0; x < 4; x++) {
				newMatrix.set(x, y, this.matrix[x][0] * matrix.get(0, y)
						+ this.matrix[x][1] * matrix.get(1, y)
						+ this.matrix[x][2] * matrix.get(2, y)
						+ this.matrix[x][3] * matrix.get(3, y));
			}
		}
		this.setMatrix(newMatrix.getMatrix());

		return this;
	}

	public float get(int x, int y) {
		return matrix[x][y];
	}

	public void set(int x, int y, float value) {
		matrix[x][y] = value;
	}

	public float[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(float[][] matrix) {
		this.matrix = matrix;
	}
}
