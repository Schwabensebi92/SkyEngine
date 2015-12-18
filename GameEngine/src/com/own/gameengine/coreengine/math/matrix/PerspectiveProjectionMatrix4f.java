package com.own.gameengine.coreengine.math.matrix;


/**
 * Represents a 4-by-4 Perspective Projection Matrix.
 * 
 * @author Sebastian Utz
 * 
 */
public class PerspectiveProjectionMatrix4f extends Matrix4f {
	
	/**
	 * Constructor for a perspective projection matrix.<br>
	 * <br>
	 * <b>E.g.:</b><br>
	 * <i>Vector a</i><br>
	 * <i>Perspective Projection Matrix P of Perspective Projection p</i><br>
	 * <i>Projected Vector a'</i><br>
	 * <br>
	 * <u>a' = P * a</u>
	 * 
	 * @param fov
	 *            The Field of View.
	 * @param aspectRatio
	 *            The Aspect Ratio of the screen.
	 * @param zNear
	 *            The near clipping plane.
	 * @param zFar
	 *            The far clipping plane.
	 */
	public PerspectiveProjectionMatrix4f(final float fov, final float aspectRatio, final float zNear, final float zFar) {
		super();
		
		float tanHalfFov = (float) Math.tan(Math.toRadians((fov / 2)));
		float zRange = zNear - zFar;
		
		//@formatter:off
		elements[0][0] = 1.0f / (tanHalfFov * aspectRatio);	elements[0][1] = 0;					elements[0][2] = 0;							elements[0][3] = 0;
		elements[1][0] = 0;									elements[1][1] = 1.0f / tanHalfFov;	elements[1][2] = 0;							elements[1][3] = 0;
		elements[2][0] = 0;									elements[2][1] = 0;					elements[2][2] = (-zNear - zFar) / zRange;	elements[2][3] = 2 * zFar * zNear / zRange;
		elements[3][0] = 0;									elements[3][1] = 0;					elements[3][2] = 1;							elements[3][3] = 0;
		//@formatter:on
	}
}
