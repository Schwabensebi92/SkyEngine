package com.own.gameengine.coreengine.math.matrix;

import com.own.gameengine.coreengine.math.Vector3f;

public class CameraRotationMatrix4f extends Matrix4f {

	public CameraRotationMatrix4f(Vector3f forward, Vector3f up) {
		super();

		forward = new Vector3f(forward);
		forward.normalize();

		Vector3f right = new Vector3f(up);
		right.normalize();
		right.cross(forward);

		up = new Vector3f(forward).cross(right);

		//@formatter:off
		matrix[0][0] = right.getX();	matrix[1][0] = up.getX();		matrix[2][0] = forward.getX();	matrix[3][0] = 0;
		matrix[0][1] = right.getY();	matrix[1][1] = up.getY();		matrix[2][1] = forward.getY();	matrix[3][1] = 0;
		matrix[0][2] = right.getZ();	matrix[1][2] = up.getZ();		matrix[2][2] = forward.getZ();	matrix[3][2] = 0;
		matrix[0][3] = 0;				matrix[1][3] = 0;				matrix[2][3] = 0;				matrix[3][3] = 1;
		//@formatter:on
	}
}
