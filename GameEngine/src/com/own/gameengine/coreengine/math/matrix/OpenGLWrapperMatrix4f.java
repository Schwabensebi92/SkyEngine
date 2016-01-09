package com.own.gameengine.coreengine.math.matrix;


public class OpenGLWrapperMatrix4f extends Matrix4f {
	
	/**
	 * Constructor for a OpenGLWrapper matrix.<br>
	 * <br>
	 * This class converts matrices from game engine coordinate space (left-handed) to OpenGL space (right-handed).
	 */
	public OpenGLWrapperMatrix4f() {
		super();
		
		//@formatter:off
		elements[0][0] = 1;		elements[0][1] = 0;		elements[0][2] = 0;		elements[0][3] = 0;
		elements[1][0] = 0;		elements[1][1] = 1;		elements[1][2] = 0;		elements[1][3] = 0;
		elements[2][0] = 0;		elements[2][1] = 0;		elements[2][2] = 1;		elements[2][3] = 1;
		elements[3][0] = 0;		elements[3][1] = 0;		elements[3][2] = 0;		elements[3][3] = 1;
		//@formatter:on
	}
}