package com.own.gameengine.coreengine.math.matrix;

public class OrthographicProjectionMatrix4f extends Matrix4f {

	public OrthographicProjectionMatrix4f(float left, float right, float bottom, float top, float near, float far) {
		super();

		float width = right - left;
		float height = top - bottom;
		float depth = far - near;

		//@formatter:off
		matrix[0][0] = 2.0f / width;			matrix[1][0] = 0;							matrix[2][0] = 0;						matrix[3][0] = 0;
		matrix[0][1] = 0;						matrix[1][1] = 2.0f / height;				matrix[2][1] = 0;						matrix[3][1] = 0;
		matrix[0][2] = 0;						matrix[1][2] = 0;							matrix[2][2] = -2.0f / depth;			matrix[3][2] = 0;
		matrix[0][3] = -(right + left) / width;	matrix[1][3] = -(top + bottom) / height;	matrix[2][3] = -(far + near) / depth;	matrix[3][3] = 1;
		//@formatter:on
	}
}
