package com.own.gameengine.coreengine.math.matrix;

import com.own.gameengine.coreengine.math.Vector3f;

public class RotationMatrix4f extends Matrix4f {

	public RotationMatrix4f(Vector3f rotation) {
		super();

		Matrix4f rX = new Matrix4f(); // rotationX
		Matrix4f rY = new Matrix4f(); // rotationY
		Matrix4f rZ = new Matrix4f(); // rotationZ

		float xRad = (float) Math.toRadians(rotation.getX());
		float yRad = (float) Math.toRadians(rotation.getY());
		float zRad = (float) Math.toRadians(rotation.getZ());

		//@formatter:off
		rX.matrix[0][0] = 1;						rX.matrix[1][0] = 0;						rX.matrix[2][0] = 0;						rX.matrix[3][0] = 0;
		rX.matrix[0][1] = 0;						rX.matrix[1][1] = (float) Math.cos(xRad);	rX.matrix[2][1] = (float) Math.sin(xRad);	rX.matrix[3][1] = 0;
		rX.matrix[0][2] = 0;						rX.matrix[1][2] = (float) -Math.sin(xRad);	rX.matrix[2][2] = (float) Math.cos(xRad);	rX.matrix[3][2] = 0;
		rX.matrix[0][3] = 0;						rX.matrix[1][3] = 0;						rX.matrix[2][3] = 0;						rX.matrix[3][3] = 1;
		//@formatter:on

		//@formatter:off
		rY.matrix[0][0] = (float) Math.cos(yRad);	rY.matrix[1][0] = 0;						rY.matrix[2][0] = (float) Math.sin(yRad);	rY.matrix[3][0] = 0;
		rY.matrix[0][1] = 0;						rY.matrix[1][1] = 1;						rY.matrix[2][1] = 0;						rY.matrix[3][1] = 0;
		rY.matrix[0][2] = (float) -Math.sin(yRad);	rY.matrix[1][2] = 0;						rY.matrix[2][2] = (float) Math.cos(yRad);	rY.matrix[3][2] = 0;
		rY.matrix[0][3] = 0;						rY.matrix[1][3] = 0;						rY.matrix[2][3] = 0;						rY.matrix[3][3] = 1;
		//@formatter:on

		//@formatter:off
		rZ.matrix[0][0] = (float) Math.cos(zRad);	rZ.matrix[1][0] = (float) Math.sin(zRad);	rZ.matrix[2][0] = 0;						rZ.matrix[3][0] = 0;
		rZ.matrix[0][1] = (float) -Math.sin(zRad);	rZ.matrix[1][1] = (float) Math.cos(zRad);	rZ.matrix[2][1] = 0;						rZ.matrix[3][1] = 0;
		rZ.matrix[0][2] = 0;						rZ.matrix[1][2] = 0;						rZ.matrix[2][2] = 1;						rZ.matrix[3][2] = 0;
		rZ.matrix[0][3] = 0;						rZ.matrix[1][3] = 0;						rZ.matrix[2][3] = 0;						rZ.matrix[3][3] = 1;
		//@formatter:on

		Matrix4f rotationMatrix = rZ.mul(rY.mul(rX));

		this.matrix = rotationMatrix.matrix;
	}
}
