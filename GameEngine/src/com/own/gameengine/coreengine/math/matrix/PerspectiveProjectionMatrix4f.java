package com.own.gameengine.coreengine.math.matrix;


public class PerspectiveProjectionMatrix4f extends Matrix4f {
	
	public PerspectiveProjectionMatrix4f(final float fov, final float aspectRatio, final float zNear, final float zFar) {
		super();
		
		float tanHalfFov = (float) Math.tan(Math.toRadians((fov / 2)));
		float zRange = zNear - zFar;
		
		//@formatter:off
		elements[0][0] = 1.0f / (tanHalfFov * aspectRatio);	elements[1][0] = 0;					elements[2][0] = 0;							elements[3][0] = 0;
		elements[0][1] = 0;									elements[1][1] = 1.0f / tanHalfFov;	elements[2][1] = 0;							elements[3][1] = 0;
		elements[0][2] = 0;									elements[1][2] = 0;					elements[2][2] = (-zNear - zFar) / zRange;	elements[3][2] = 1;
		elements[0][3] = 0;									elements[1][3] = 0;					elements[2][3] = 2 * zFar * zNear / zRange;	elements[3][3] = 0;
		//@formatter:on
	}
}
