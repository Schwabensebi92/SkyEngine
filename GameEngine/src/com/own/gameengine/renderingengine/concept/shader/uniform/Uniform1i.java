package com.own.gameengine.renderingengine.concept.shader.uniform;


import static org.lwjgl.opengl.GL20.glUniform1i;


public class Uniform1i extends Uniform<Integer> {
	
	public Uniform1i(String identifier) {
		super(UniformType.Integer, identifier);
	}
	
	@Override
	public void send() {
		glUniform1i(location, value);
	}
}