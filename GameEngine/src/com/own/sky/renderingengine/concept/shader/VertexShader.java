package com.own.sky.renderingengine.concept.shader;

public class VertexShader extends Shader {

	public VertexShader(String fileName) {
		super(Shaders.VERTEX_SHADER, fileName);
	}

	public VertexShader() {
		super(Shaders.VERTEX_SHADER);
	}
}
