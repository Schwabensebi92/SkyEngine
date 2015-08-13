package com.own.gameengine.renderingengine.concept.shader;

public class GeometryShader extends Shader {

	public GeometryShader(String fileName) {
		super(Shaders.GEOMETRY_SHADER, fileName);
	}

	public GeometryShader() {
		super(Shaders.GEOMETRY_SHADER);
	}
}
