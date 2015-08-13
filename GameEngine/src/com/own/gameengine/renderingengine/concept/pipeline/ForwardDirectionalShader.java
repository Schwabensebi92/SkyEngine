package com.own.gameengine.renderingengine.concept.pipeline;

import com.own.gameengine.renderingengine.graphics.*;
import com.own.gameengine.renderingengine.graphics.light.DirectionalLight;
import com.own.gameengine.renderingengine.graphics.object.Material;

public class ForwardDirectionalShader extends ForwardLightPipeline<DirectionalLight> {

	public ForwardDirectionalShader() {
		super();

		addVertexShaderFromFile("forward_directional.vs");
		addFragmentShaderFromFile("forward_directional.fs");

		compileShader();

		addUniform("eyePosition");

		addUniform("transform");
		addUniform("transformProjected");

		addUniform("specularIntensity");
		addUniform("specularExponent");

		addUniform("directionalLight.baseLight.color");
		addUniform("directionalLight.baseLight.intensity");
		addUniform("directionalLight.direction");
	}

	public void updateUniforms(Transform transform, Camera camera, Material material) {
		material.getTexture().bind();

		setUniform("eyePosition", camera.getPosition());

		setUniform("transform", transform.getTransformation());
		setUniform("transformProjected", transform.getProjectedTransformation(camera));

		setUniformf("specularIntensity", material.getSpecularIntensity());
		setUniformf("specularExponent", material.getSpecularExponent());

		setUniform("directionalLight", getCurrentLight());
	}
}
