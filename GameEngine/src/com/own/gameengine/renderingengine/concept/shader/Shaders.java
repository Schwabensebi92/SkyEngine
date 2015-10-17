package com.own.gameengine.renderingengine.concept.shader;


import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL32.GL_GEOMETRY_SHADER;
import static org.lwjgl.opengl.GL40.*;


public enum Shaders {
	
	VERTEX_SHADER(GL_VERTEX_SHADER),
	TESSELLATION_CONTROL_SHADER(GL_TESS_CONTROL_SHADER),
	TESSELLATION_EVALUATION_SHADER(GL_TESS_EVALUATION_SHADER),
	GEOMETRY_SHADER(GL_GEOMETRY_SHADER),
	FRAGMENT_SHADER(GL_FRAGMENT_SHADER);
	
	private final int value;
	
	private Shaders(final int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
}
