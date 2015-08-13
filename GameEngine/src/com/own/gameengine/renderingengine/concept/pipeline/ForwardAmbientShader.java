package com.own.gameengine.renderingengine.concept.pipeline;

import com.own.gameengine.renderingengine.graphics.*;
import com.own.gameengine.renderingengine.graphics.light.AmbientLight;
import com.own.gameengine.renderingengine.graphics.object.Material;

public class ForwardAmbientShader extends ForwardLightPipeline<AmbientLight> {

	public ForwardAmbientShader() {
		super();

		addVertexShaderFromFile("forward_ambient.vs");
		addFragmentShaderFromFile("forward_ambient.fs");

		compileShader();

		addUniform("transformProjected");
		addUniform("ambientIntensity");
	}

	public void updateUniforms(Transform transform, Camera camera, Material material) {
		material.getTexture().bind();

		setUniform("transformProjected", transform.getProjectedTransformation(camera));
		setUniform("ambientIntensity", getCurrentLight());
	}
}
