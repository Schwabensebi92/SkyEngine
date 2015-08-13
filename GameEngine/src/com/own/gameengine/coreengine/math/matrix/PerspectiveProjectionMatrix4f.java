package com.own.gameengine.coreengine.math.matrix;

public class PerspectiveProjectionMatrix4f extends Matrix4f {

	public PerspectiveProjectionMatrix4f(float fov, float aspectRatio, float zNear, float zFar) {
		super();

		float tanHalfFov = (float) Math.tan(Math.toRadians((fov / 2)));
		float zRange = zNear - zFar;

		//@formatter:off
		matrix[0][0] = 1.0f / (tanHalfFov * aspectRatio);	matrix[1][0] = 0;					matrix[2][0] = 0;							matrix[3][0] = 0;
		matrix[0][1] = 0;									matrix[1][1] = 1.0f / tanHalfFov;	matrix[2][1] = 0;							matrix[3][1] = 0;
		matrix[0][2] = 0;									matrix[1][2] = 0;					matrix[2][2] = (-zNear - zFar) / zRange;	matrix[3][2] = 1;
		matrix[0][3] = 0;									matrix[1][3] = 0;					matrix[2][3] = 2 * zFar * zNear / zRange;	matrix[3][3] = 0;
		//@formatter:on
	}
}
