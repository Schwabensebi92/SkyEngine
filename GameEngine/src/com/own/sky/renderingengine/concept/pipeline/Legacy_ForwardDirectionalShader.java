package com.own.sky.renderingengine.concept.pipeline;

import com.own.sky.renderingengine.cameraengine.Camera;
import com.own.sky.renderingengine.graphics.*;
import com.own.sky.renderingengine.graphics.object.Material;
import com.own.sky.renderingengine.graphics.object.Transform;
import com.own.sky.renderingengine.lightengine.light.DirectionalLight;

public class Legacy_ForwardDirectionalShader extends Legacy_ForwardLightPipeline<DirectionalLight> {

	public Legacy_ForwardDirectionalShader() {
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

		setUniform("transform", transform.getWorldMatrix());
		setUniform("transformProjected", transform.getWorldViewProjectionMatrix(camera));

		setUniformf("specularIntensity", material.getSpecularIntensity());
		setUniformf("specularExponent", material.getSpecularExponent());

		setUniform("directionalLight", getCurrentLight());
	}
}
