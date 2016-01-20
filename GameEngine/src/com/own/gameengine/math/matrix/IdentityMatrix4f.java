package com.own.gameengine.math.matrix;


/**
 * Represents an 4-by-4 Identity Matrix.
 * 
 * @author Sebastian Utz
 * 		
 */
public class IdentityMatrix4f extends Matrix4f {
	
	/**
	 * Constructor for an identity matrix.<br>
	 * <br>
	 * <b>E.g.:</b><br>
	 * <i>Vector a</i><br>
	 * <i>Identity Matrix T</i><br>
	 * <i>Vector a'</i><br>
	 * <br>
	 * <u>a' = T * a</u><br>
	 * a'.x = a.x<br>
	 * a'.y = a.y<br>
	 * a'.z = a.z<br>
	 * 
	 */
	public IdentityMatrix4f() {
		super();
		
		//@formatter:off
		elements[0][0] = 1;	elements[0][1] = 0;	elements[0][2] = 0;	elements[0][3] = 0;
		elements[1][0] = 0;	elements[1][1] = 1;	elements[1][2] = 0;	elements[1][3] = 0;
		elements[2][0] = 0;	elements[2][1] = 0;	elements[2][2] = 1;	elements[2][3] = 0;
		elements[3][0] = 0;	elements[3][1] = 0;	elements[3][2] = 0;	elements[3][3] = 1;
		//@formatter:on
	}
}
