package com.own.gameengine.coreengine.math;


public class CoordinateSystem {
	
	public enum CoordinateAxis {
		
		X_AXIS(1, 0, 0),
		Y_AXIS(0, 1, 0),
		Z_AXIS(0, 0, 1);
		
		private Vector3f vector;
		
		private CoordinateAxis(final float x, final float y, final float z) {
			vector = new Vector3f(x, y, z);
		}
		
		public Vector3f getVector() {
			return new Vector3f(vector);
		}
	}
	
	public enum CoordinateSpace {
		
		LOCAL,
		GLOBAL;
	}
}
