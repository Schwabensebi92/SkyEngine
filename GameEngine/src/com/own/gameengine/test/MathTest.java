package com.own.gameengine.test;


import com.own.gameengine.coreengine.math.*;


public class MathTest {
	
	public static void main(final String[] args) {
		Vector3f v_global = new Vector3f(1, 0, 0);
		Quaternion rotation = new Quaternion(new Vector3f(0, 1, 0), (float) Math.toRadians(90));
		Vector3f v_local = new Vector3f(v_global).rotate(rotation);
		
		System.out.println("v_global: " + v_global);
		System.out.println("rotation: " + rotation);
		System.out.println("v_local:  " + v_local);
	}
}
