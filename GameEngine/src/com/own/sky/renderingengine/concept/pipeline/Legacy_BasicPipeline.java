package com.own.sky.renderingengine.concept.pipeline;


import com.own.sky.renderingengine.cameraengine.Camera;
import com.own.sky.renderingengine.concept.shader.*;
import com.own.sky.renderingengine.graphics.*;
import com.own.sky.renderingengine.graphics.object.Material;
import com.own.sky.renderingengine.graphics.object.Transform;


public class Legacy_BasicPipeline extends Legacy_RenderingPipeline {
	
	public Legacy_BasicPipeline() {
		super();
		
		addUniform("transform");
		addUniform("color");
	}
	
	@Override
	public Shader[] createShaders() {
		Shader[] shaders = { new VertexShader("basicVertex.vs"), new FragmentShader("basicFragment.fs") };
		return shaders;
	}
	
	@Override
	public void updateUniforms(final Transform transform, final Camera camera, final Material material) {
		material.getTexture().bind();
		
		setUniform("transform", transform.getWorldViewProjectionMatrix(camera));
		setUniform("color", material.getColor());
	}
}
