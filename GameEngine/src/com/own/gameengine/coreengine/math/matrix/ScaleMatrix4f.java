package com.own.gameengine.coreengine.math.matrix;

import com.own.gameengine.coreengine.math.Vector3f;

public class ScaleMatrix4f extends Matrix4f {

	public ScaleMatrix4f(Vector3f scale) {
		super();

		//@formatter:off
		matrix[0][0] = scale.getX();	matrix[1][0] = 0;				matrix[2][0] = 0;				matrix[3][0] = 0;
		matrix[0][1] = 0;				matrix[1][1] = scale.getY();	matrix[2][1] = 0;				matrix[3][1] = 0;
		matrix[0][2] = 0;				matrix[1][2] = 0;				matrix[2][2] = scale.getZ();	matrix[3][2] = 0;
		matrix[0][3] = 0;				matrix[1][3] = 0;				matrix[2][3] = 0;				matrix[3][3] = 1;
		//@formatter:on
	}
}
