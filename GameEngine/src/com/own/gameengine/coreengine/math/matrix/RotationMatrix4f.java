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
		
		// super();
		//
		// Matrix4f rX = new Matrix4f(); // rotationX
		// Matrix4f rY = new Matrix4f(); // rotationY
		// Matrix4f rZ = new Matrix4f(); // rotationZ
		//
		// float xRad = (float) Math.toRadians(rotation.getX());
		// float yRad = (float) Math.toRadians(rotation.getY());
		// float zRad = (float) Math.toRadians(rotation.getZ());
		//
//		//@formatter:off
//		rX.elements[0][0] = 1;						rX.elements[1][0] = 0;						rX.elements[2][0] = 0;						rX.elements[3][0] = 0;
//		rX.elements[0][1] = 0;						rX.elements[1][1] = (float) Math.cos(xRad);	rX.elements[2][1] = (float) Math.sin(xRad);	rX.elements[3][1] = 0;
//		rX.elements[0][2] = 0;						rX.elements[1][2] = (float) -Math.sin(xRad);rX.elements[2][2] = (float) Math.cos(xRad);	rX.elements[3][2] = 0;
//		rX.elements[0][3] = 0;						rX.elements[1][3] = 0;						rX.elements[2][3] = 0;						rX.elements[3][3] = 1;
//		//@formatter:on
		//
//		//@formatter:off
//		rY.elements[0][0] = (float) Math.cos(yRad);	rY.elements[1][0] = 0;						rY.elements[2][0] = (float) Math.sin(yRad);	rY.elements[3][0] = 0;
//		rY.elements[0][1] = 0;						rY.elements[1][1] = 1;						rY.elements[2][1] = 0;						rY.elements[3][1] = 0;
//		rY.elements[0][2] = (float) -Math.sin(yRad);rY.elements[1][2] = 0;						rY.elements[2][2] = (float) Math.cos(yRad);	rY.elements[3][2] = 0;
//		rY.elements[0][3] = 0;						rY.elements[1][3] = 0;						rY.elements[2][3] = 0;						rY.elements[3][3] = 1;
//		//@formatter:on
		//
//		//@formatter:off
//		rZ.elements[0][0] = (float) Math.cos(zRad);	rZ.elements[1][0] = (float) Math.sin(zRad);	rZ.elements[2][0] = 0;						rZ.elements[3][0] = 0;
//		rZ.elements[0][1] = (float) -Math.sin(zRad);rZ.elements[1][1] = (float) Math.cos(zRad);	rZ.elements[2][1] = 0;						rZ.elements[3][1] = 0;
//		rZ.elements[0][2] = 0;						rZ.elements[1][2] = 0;						rZ.elements[2][2] = 1;						rZ.elements[3][2] = 0;
//		rZ.elements[0][3] = 0;						rZ.elements[1][3] = 0;						rZ.elements[2][3] = 0;						rZ.elements[3][3] = 1;
//		//@formatter:on
		//
		// Matrix4f rotationMatrix = rZ.mul(rY.mul(rX));
		//
		// elements = rotationMatrix.elements;
	}
}
