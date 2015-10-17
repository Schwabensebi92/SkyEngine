package com.own.gameengine.renderingengine.concept.pipeline;

import com.own.gameengine.renderingengine.concept.shader.*;
import com.own.gameengine.renderingengine.graphics.*;
import com.own.gameengine.renderingengine.graphics.object.Material;

public class Legacy_BasicPipeline extends Legacy_RenderingPipeline {

	public Legacy_BasicPipeline() {
		super();

		addUniform("transform");
		addUniform("color");
	}

	@Override
	public Shader[] createShaders() {
		Shader[] shaders = {
				new VertexShader("basicVertex.vs"),
				new FragmentShader("basicFragment.fs")
		};
		return shaders;
	}

	public void updateUniforms(Transform transform, Camera camera, Material material) {
		material.getTexture().bind();

		setUniform("transform", transform.getProjectedTransformation(camera));
		setUniform("color", material.getColor());
	}
}
