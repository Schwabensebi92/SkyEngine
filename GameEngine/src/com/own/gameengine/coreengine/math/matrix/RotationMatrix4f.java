package com.own.gameengine.coreengine.math.matrix;


import com.own.gameengine.coreengine.math.Quaternion;
import com.own.gameengine.coreengine.math.Vector3f;


/**
 * Represents a 4-by-4 Rotation Matrix.
 * 
 * @author Sebastian Utz
 * 		
 */
public class RotationMatrix4f extends Matrix4f {
	
	/**
	 * Constructor for a Rotation matrix.<br>
	 * <br>
	 * <b>E.g.:</b><br>
	 * <i>Vector a</i><br>
	 * <i>Rotation Matrix R of Rotation Quaternion r</i><br>
	 * <i>Rotated Vector a'</i><br>
	 * <br>
	 * <u>a' = R * a</u><br>
	 * a'.x = a.x * r.right.x + a.y * r.right.y + a.z * r.right.z<br>
	 * a'.y = a.x * r.up.x + a.y * r.up.y + a.z * r.up.z<br>
	 * a'.z = a.x * r.forward.x + a.y * r.forward.y + a.z * r.forward.z
	 * 
	 * @param rotation
	 *            The rotation, which shall be represented by the matrix.
	 */
	public RotationMatrix4f(final Quaternion rotation) {
		super();
		
		Vector3f r = rotation.getLocalXAxis().normalize();
		Vector3f u = rotation.getLocalYAxis().normalize();
		Vector3f f = rotation.getLocalZAxis().normalize();
		
		//@formatter:off
		elements[0][0] = r.getX();	elements[0][1] = r.getY();	elements[0][2] = r.getZ();	elements[0][3] = 0;
		elements[1][0] = u.getX();	elements[1][1] = u.getY();	elements[1][2] = u.getZ();	elements[1][3] = 0;
		elements[2][0] = f.getX();	elements[2][1] = f.getY();	elements[2][2] = f.getZ();	elements[2][3] = 0;
		elements[3][0] = 0;			elements[3][1] = 0;			elements[3][2] = 0;			elements[3][3] = 1;
		//@formatter:on
	}
}
