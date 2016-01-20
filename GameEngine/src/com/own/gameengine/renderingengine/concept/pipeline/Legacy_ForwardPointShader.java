package com.own.gameengine.renderingengine.concept.pipeline;

import com.own.gameengine.renderingengine.cameraengine.Camera;
import com.own.gameengine.renderingengine.graphics.*;
import com.own.gameengine.renderingengine.graphics.object.Material;
import com.own.gameengine.renderingengine.graphics.object.Transform;
import com.own.gameengine.renderingengine.lightengine.light.PointLight;

public class Legacy_ForwardPointShader extends Legacy_ForwardLightPipeline<PointLight> {

	public Legacy_ForwardPointShader() {
		super();

		addVertexShaderFromFile("forward_point.vs");
		addFragmentShaderFromFile("forward_point.fs");

		compileShader();

		addUniform("eyePosition");

		addUniform("transform");
		addUniform("transformProjected");

		addUniform("specularIntensity");
		addUniform("specularExponent");

		addUniform("pointLight.baseLight.color");
		addUniform("pointLight.baseLight.intensity");
		addUniform("pointLight.attenuation.constant");
		addUniform("pointLight.attenuation.linear");
		addUniform("pointLight.attenuation.exponent");
		addUniform("pointLight.position");
		addUniform("pointLight.range");
	}

	public void updateUniforms(Transform transform, Camera camera, Material material) {
		material.getTexture().bind();

		setUniform("eyePosition", camera.getPosition());

		setUniform("transform", transform.getWorldMatrix());
		setUniform("transformProjected", transform.getWorldViewProjectionMatrix(camera));

		setUniformf("specularIntensity", material.getSpecularIntensity());
		setUniformf("specularExponent", material.getSpecularExponent());

		setUniform("pointLight", getCurrentLight());
	}
}
