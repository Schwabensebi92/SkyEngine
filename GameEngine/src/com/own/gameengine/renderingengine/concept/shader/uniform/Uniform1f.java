package com.own.gameengine.renderingengine.concept.shader.uniform;


import static org.lwjgl.opengl.GL20.glUniform1f;


public class Uniform1f extends Uniform<Float> {
	
	public Uniform1f(String identifier) {
		super(UniformType.Float, identifier);
	}
	
	@Override
	public void send() {
		glUniform1f(location, value);
	}
}