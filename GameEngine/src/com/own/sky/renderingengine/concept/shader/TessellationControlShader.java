package com.own.sky.renderingengine.concept.shader;

public class TessellationControlShader extends Shader {

	public TessellationControlShader(String fileName) {
		super(Shaders.TESSELLATION_CONTROL_SHADER, fileName);
	}

	public TessellationControlShader() {
		super(Shaders.TESSELLATION_CONTROL_SHADER);
	}
}
