package com.own.gameengine.renderingengine.concept.shader.uniform;


import static org.lwjgl.opengl.GL20.glUniform3f;

import com.own.gameengine.math.Vector3f;


public class Uniform3f extends Uniform<Vector3f> {
	
	public Uniform3f(String identifier) {
		super(UniformType.Vector3f, identifier);
	}
	
	@Override
	public void send() {
		glUniform3f(location, value.getX(), value.getY(), value.getZ());
	}
}