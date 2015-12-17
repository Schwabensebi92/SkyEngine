package com.own.gameengine.coreengine.math.matrix;


public class OrthographicProjectionMatrix4f extends Matrix4f {
	
	public OrthographicProjectionMatrix4f(final float left, final float right, final float bottom, final float top, final float near,
			final float far) {
		super();
		
		float width = right - left;
		float height = top - bottom;
		float depth = far - near;
		
		//@formatter:off
		elements[0][0] = 2.0f / width;				elements[1][0] = 0;							elements[2][0] = 0;						elements[3][0] = 0;
		elements[0][1] = 0;							elements[1][1] = 2.0f / height;				elements[2][1] = 0;						elements[3][1] = 0;
		elements[0][2] = 0;							elements[1][2] = 0;							elements[2][2] = -2.0f / depth;			elements[3][2] = 0;
		elements[0][3] = -(right + left) / width;	elements[1][3] = -(top + bottom) / height;	elements[2][3] = -(far + near) / depth;	elements[3][3] = 1;
		//@formatter:on
	}
}
