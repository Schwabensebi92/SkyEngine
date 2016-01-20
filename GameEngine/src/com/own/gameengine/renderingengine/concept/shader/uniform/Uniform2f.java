package com.own.gameengine.renderingengine.concept.shader.uniform;


import static org.lwjgl.opengl.GL20.glUniform2f;

import com.own.gameengine.math.Vector2f;


public class Uniform2f extends Uniform<Vector2f> {
	
	public Uniform2f(String identifier) {
		super(UniformType.Vector2f, identifier);
	}
	
	@Override
	public void send() {
		glUniform2f(location, value.getX(), value.getY());
	}
}