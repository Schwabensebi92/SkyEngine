package com.own.sky.renderingengine.concept.pipeline;

import com.own.sky.renderingengine.cameraengine.Camera;
import com.own.sky.renderingengine.graphics.*;
import com.own.sky.renderingengine.graphics.object.Material;
import com.own.sky.renderingengine.graphics.object.Transform;
import com.own.sky.renderingengine.lightengine.light.AmbientLight;

public class Legacy_ForwardAmbientShader extends Legacy_ForwardLightPipeline<AmbientLight> {

	public Legacy_ForwardAmbientShader() {
		super();

		addVertexShaderFromFile("forward_ambient.vs");
		addFragmentShaderFromFile("forward_ambient.fs");

		compileShader();

		addUniform("transformProjected");
		addUniform("ambientIntensity");
	}

	public void updateUniforms(Transform transform, Camera camera, Material material) {
		material.getTexture().bind();

		setUniform("transformProjected", transform.getWorldViewProjectionMatrix(camera));
		setUniform("ambientIntensity", getCurrentLight());
	}
}
