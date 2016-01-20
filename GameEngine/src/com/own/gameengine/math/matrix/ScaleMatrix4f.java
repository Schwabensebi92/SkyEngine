package com.own.gameengine.math.matrix;


import com.own.gameengine.math.Vector3f;


/**
 * Represents a 4-by-4 Scale Matrix.
 * 
 * @author Sebastian Utz
 * 		
 */
public class ScaleMatrix4f extends Matrix4f {
	
	/**
	 * Constructor for a scale matrix.<br>
	 * <br>
	 * <b>E.g.:</b><br>
	 * <i>Vector a</i><br>
	 * <i>Scale Matrix S of Scale Vector s</i><br>
	 * <i>Scaled Vector a'</i><br>
	 * <br>
	 * <u>a' = S * a</u><br>
	 * a'.x = a.x * s.x<br>
	 * a'.y = a.y * s.y<br>
	 * a'.z = a.z * s.z<br>
	 * 
	 * @param scale
	 *            The scale, which shall be represented by the matrix.
	 */
	public ScaleMatrix4f(final Vector3f scale) {
		super();
		
		//@formatter:off
		elements[0][0] = scale.getX();	elements[0][1] = 0;				elements[0][2] = 0;				elements[0][3] = 0;
		elements[1][0] = 0;				elements[1][1] = scale.getY();	elements[1][2] = 0;				elements[1][3] = 0;
		elements[2][0] = 0;				elements[2][1] = 0;				elements[2][2] = scale.getZ();	elements[2][3] = 0;
		elements[3][0] = 0;				elements[3][1] = 0;				elements[3][2] = 0;				elements[3][3] = 1;
		//@formatter:on
	}
}
