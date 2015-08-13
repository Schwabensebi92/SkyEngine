package com.own.gameengine.coreengine.math.matrix;

public class IdentityMatrix4f extends Matrix4f {

	public IdentityMatrix4f() {
		super();

		//@formatter:off
		matrix[0][0] = 1;	matrix[1][0] = 0;	matrix[2][0] = 0;	matrix[3][0] = 0;
		matrix[0][1] = 0;	matrix[1][1] = 1;	matrix[2][1] = 0;	matrix[3][1] = 0;
		matrix[0][2] = 0;	matrix[1][2] = 0;	matrix[2][2] = 1;	matrix[3][2] = 0;
		matrix[0][3] = 0;	matrix[1][3] = 0;	matrix[2][3] = 0;	matrix[3][3] = 1;
		//@formatter:on
	}
}
