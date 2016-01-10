package com.own.gameengine.test;


import com.own.gameengine.coreengine.math.*;
import com.own.gameengine.coreengine.math.matrix.*;


public class QuickTest {
	
	public static void main(final String[] args) {
		// Take into account that angle is internally inversed!
		Vector3f v_global = new Vector3f(0, 0, 1);
		Quaternion rotation = new Quaternion(new Vector3f(0, 1, 0), (float) Math.toRadians(184));
		Vector3f v_local_quat = new Vector3f(v_global).rotate(rotation);
		Vector3f v_local_matrix = mul(new RotationMatrix4f(new Quaternion(rotation)), new Vector3f(0, 0, 1));
		
		System.out.println("v_global:       " + v_global);
		System.out.println("rotation:       " + rotation);
		System.out.println("v_local_quat:   " + v_local_quat);
		System.out.println("v_local_matrix: " + v_local_matrix);
	}
	
	private static Vector3f mul(final Matrix4f matrix, final Vector3f vector) {
		float[] vector4 = { vector.getX(), vector.getY(), vector.getZ(), 1.0f };
		float[] resultVector = new float[4];
		for (int m = 0; m < 4; m++) {
			resultVector[m] = matrix.get(m, 0) * vector4[0] + matrix.get(m, 1) * vector4[1] + matrix.get(m, 2) * vector4[2]
					+ matrix.get(m, 3) * vector4[3];
		}
		return new Vector3f(resultVector[0], resultVector[1], resultVector[2]);
	}
}
