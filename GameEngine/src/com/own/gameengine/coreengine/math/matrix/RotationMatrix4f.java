package com.own.gameengine.coreengine.math.matrix;


import com.own.gameengine.coreengine.math.*;


public class RotationMatrix4f extends Matrix4f {
	
	public RotationMatrix4f(final Quaternion rotation) {
		super();
		
		Vector3f forward = rotation.getForwardVector();
		forward.normalize();
		Vector3f up = rotation.getUpVector();
		up.normalize();
		Vector3f right = rotation.getRightVector();
		right.normalize();
		
		//@formatter:off
		elements[0][0] = right.getX();	elements[1][0] = up.getX();		elements[2][0] = forward.getX();	elements[3][0] = 0;
		elements[0][1] = right.getY();	elements[1][1] = up.getY();		elements[2][1] = forward.getY();	elements[3][1] = 0;
		elements[0][2] = right.getZ();	elements[1][2] = up.getZ();		elements[2][2] = forward.getZ();	elements[3][2] = 0;
		elements[0][3] = 0;				elements[1][3] = 0;				elements[2][3] = 0;					elements[3][3] = 1;
		//@formatter:on
	}
}
