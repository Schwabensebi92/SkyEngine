package com.own.sky.math.matrix;


/**
 * Represents a 4-by-4 Orthographic Projection Matrix.
 * 
 * @author Sebastian Utz
 * 		
 */
public class OrthographicProjectionMatrix4f extends Matrix4f {
	
	/**
	 * Constructor for a orthographic projection matrix.<br>
	 * <br>
	 * <b>E.g.:</b><br>
	 * <i>Vector a</i><br>
	 * <i>Orthographic Projection Matrix O of Orthographic Projection o</i><br>
	 * <i>Projected Vector a'</i><br>
	 * <br>
	 * <u>a' = O * a</u>
	 * 
	 * @param left
	 *            The screen coordinate for the left side of the screen.
	 * @param right
	 *            The screen coordinate for the right side of the screen.
	 * @param bottom
	 *            The screen coordinate for the bottom of the screen.
	 * @param top
	 *            The screen coordinate for the top of the screen.
	 * @param near
	 *            The screen coordinate for the near clipping of the screen.
	 * @param far
	 *            The screen coordinate for the far clipping of the screen.
	 */
	public OrthographicProjectionMatrix4f(final float left, final float right, final float bottom, final float top, final float near,
			final float far) {
		super();
		
		float width = right - left;
		float height = top - bottom;
		float depth = far - near;
		
		//@formatter:off
		elements[0][0] = 2.0f / width;	elements[0][1] = 0;				elements[0][2] = 0;				elements[0][3] = -(right + left) / width;
		elements[1][0] = 0;				elements[1][1] = 2.0f / height;	elements[1][2] = 0;				elements[1][3] = -(top + bottom) / height;
		elements[2][0] = 0;				elements[2][1] = 0;				elements[2][2] = -2.0f / depth;	elements[2][3] = -(far + near) / depth;
		elements[3][0] = 0;				elements[3][1] = 0;				elements[3][2] = 0;				elements[3][3] = 1;
		//@formatter:on
	}
}
