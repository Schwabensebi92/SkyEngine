package com.own.gameengine.renderingengine.concept.shader;


public class FragmentShader extends Shader {
	
	public FragmentShader(final String fileName) {
		super(Shaders.FRAGMENT_SHADER, fileName);
	}
	
	public FragmentShader() {
		super(Shaders.FRAGMENT_SHADER);
	}
}
