package com.own.gameengine.coreengine.math.matrix;


import com.own.gameengine.coreengine.math.Vector3f;


public class ScaleMatrix4f extends Matrix4f {
	
	public ScaleMatrix4f(final Vector3f scale) {
		super();
		
		//@formatter:off
		elements[0][0] = scale.getX();	elements[1][0] = 0;				elements[2][0] = 0;				elements[3][0] = 0;
		elements[0][1] = 0;				elements[1][1] = scale.getY();	elements[2][1] = 0;				elements[3][1] = 0;
		elements[0][2] = 0;				elements[1][2] = 0;				elements[2][2] = scale.getZ();	elements[3][2] = 0;
		elements[0][3] = 0;				elements[1][3] = 0;				elements[2][3] = 0;				elements[3][3] = 1;
		//@formatter:on
	}
}
