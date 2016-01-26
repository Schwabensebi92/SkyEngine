package com.own.sky.renderingengine.concept.shader;

public class TessellationEvaluationShader extends Shader {

	public TessellationEvaluationShader(String fileName) {
		super(Shaders.TESSELLATION_EVALUATION_SHADER, fileName);
	}

	public TessellationEvaluationShader() {
		super(Shaders.TESSELLATION_EVALUATION_SHADER);
	}
}
