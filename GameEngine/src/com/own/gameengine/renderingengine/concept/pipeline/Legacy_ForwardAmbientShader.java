package com.own.gameengine.renderingengine.concept.pipeline;

import com.own.gameengine.renderingengine.cameraengine.Camera;
import com.own.gameengine.renderingengine.graphics.*;
import com.own.gameengine.renderingengine.graphics.object.Material;
import com.own.gameengine.renderingengine.graphics.object.Transform;
import com.own.gameengine.renderingengine.lightengine.light.AmbientLight;

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
