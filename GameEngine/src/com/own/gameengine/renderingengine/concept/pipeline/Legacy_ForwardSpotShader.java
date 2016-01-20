package com.own.gameengine.renderingengine.concept.pipeline;

import com.own.gameengine.renderingengine.cameraengine.Camera;
import com.own.gameengine.renderingengine.graphics.*;
import com.own.gameengine.renderingengine.graphics.object.Material;
import com.own.gameengine.renderingengine.graphics.object.Transform;
import com.own.gameengine.renderingengine.lightengine.light.SpotLight;

public class Legacy_ForwardSpotShader extends Legacy_ForwardLightPipeline<SpotLight> {

	public Legacy_ForwardSpotShader() {
		super();

		addVertexShaderFromFile("forward_spot.vs");
		addFragmentShaderFromFile("forward_spot.fs");

		compileShader();

		addUniform("eyePosition");

		addUniform("transform");
		addUniform("transformProjected");

		addUniform("specularIntensity");
		addUniform("specularExponent");

		addUniform("spotLight.pointLight.baseLight.color");
		addUniform("spotLight.pointLight.baseLight.intensity");
		addUniform("spotLight.pointLight.attenuation.constant");
		addUniform("spotLight.pointLight.attenuation.linear");
		addUniform("spotLight.pointLight.attenuation.exponent");
		addUniform("spotLight.pointLight.position");
		addUniform("spotLight.pointLight.range");

		addUniform("spotLight.direction");
		addUniform("spotLight.cutoff");
	}

	public void updateUniforms(Transform transform, Camera camera, Material material) {
		material.getTexture().bind();

		setUniform("eyePosition", camera.getPosition());

		setUniform("transform", transform.getWorldMatrix());
		setUniform("transformProjected", transform.getWorldViewProjectionMatrix(camera));

		setUniformf("specularIntensity", material.getSpecularIntensity());
		setUniformf("specularExponent", material.getSpecularExponent());

		setUniform("spotLight", getCurrentLight());
	}
}
