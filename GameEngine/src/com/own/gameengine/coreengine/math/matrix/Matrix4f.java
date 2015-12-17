package com.own.gameengine.coreengine.math.matrix;


/**
 * Represents a 4-by-4 Matrix.
 * 
 * @see <a href="https://en.wikipedia.org/wiki/Matrix_(mathematics)"> wikipedia.org/Matrix</a>
 * @author Sebastian Utz
 * 		
 */
public class Matrix4f {
	
	/**
	 * Amount of columns in this Matrix.
	 */
	private final static int	AMOUNT_ELEMENTS_M	= 4;
	/**
	 * Amount of rows in this Matrix.
	 */
	private final static int	AMOUNT_ELEMENTS_N	= 4;
	
	//@formatter:off
	/*
	 * matrix[m][n]
	 * 
	 *   → m
	 * ↓ [][][][]
	 * n [][][][]
	 *   [][][][]
	 *   [][][][]
	 */
	//formatter:on

	/**
	 * Contains the elements of this Matrix4f.
	 */
	protected float[][]	elements;

	/**
	 * Default constructor of Matrix4f.<br>
	 * The elements of the Matrix are initialized with 0.
	 */
	public Matrix4f() {
		elements = new float[AMOUNT_ELEMENTS_M][AMOUNT_ELEMENTS_N];
	}

	/**
	 * Copy constructor of Matrix4f.<br>
	 * The elements of this Matrix are initialized with the elements of the {@code source}.
	 * @param source The Matrix from which the elements are copied.
	 */
	public Matrix4f(final Matrix4f source) {
		elements = new float[AMOUNT_ELEMENTS_M][AMOUNT_ELEMENTS_N];
		for (int m = 0; m < AMOUNT_ELEMENTS_M; m++) {
			for (int n = 0; n < AMOUNT_ELEMENTS_N; n++) {
				elements[m][n] = source.elements[m][n];
			}
		}
	}

	/**
	 * Multiplies this Matrix with the Matrix {@code other}.<br>
	 * 
	 * @param other The Matrix with which this Matrix is multiplied.
	 * @return Returns this Matrix4f.
	 */
	public Matrix4f mul(final Matrix4f other) {
		float[][] newElements = new float[AMOUNT_ELEMENTS_M][AMOUNT_ELEMENTS_N];
		for (int n = 0; n < AMOUNT_ELEMENTS_N; n++) {
			for (int m = 0; m < AMOUNT_ELEMENTS_M; m++) {
				//formatter:off
				newElements[m][n] =
						  elements[m][0] * other.get(0, n)
						+ elements[m][1] * other.get(1, n)
						+ elements[m][2] * other.get(2, n)
						+ elements[m][3] * other.get(3, n);
				//formatter:on
			}
		}
		elements = newElements;

		return this;
	}

	/**
	 * Gets the element in column {@code m} and row {@code n}.
	 * @param m The column of the element.
	 * @param n The row of the element.
	 * @return Gets the element in column {@code m} and row {@code n}.
	 */
	public float get(final int m, final int n) {
		return elements[m][n];
	}

	/**
	 * Sets the element in column {@code m} and row {@code n} to {@code value}.
	 * @param m The column of the element.
	 * @param n The row of the element.
	 * @param value The new value of the element.
	 */
	public void set(final int m, final int n, final float value) {
		elements[m][n] = value;
	}
}
