package com.own.gameengine.renderingengine.concept;

import com.own.gameengine.renderingengine.concept.pipeline.RenderingPipeline;
import com.own.gameengine.renderingengine.graphics.*;
import com.own.gameengine.renderingengine.graphics.object.*;

public abstract class RenderingConcept {

	private static RenderingConcept	instance;

	public static RenderingConcept getInstance() {
		return instance;
	}

	private RenderingPipeline[]	shaders;
	private int					amountOfShaders;

	public RenderingConcept(RenderingPipeline[] shaders) {
		instance = this;
		this.shaders = shaders;
		this.amountOfShaders = shaders.length;
	}

	public void drawMesh(Transform transform, Camera camera, Material material, Mesh mesh) {
		if (amountOfShaders > 0) {
			shaders[0].drawMesh(transform, camera, material, mesh);

			if (amountOfShaders > 1) {
				OpenGL.enableBlending(true);
				for (int shaderIndex = 1; shaderIndex < amountOfShaders; shaderIndex++) {
					shaders[shaderIndex].drawMesh(transform, camera, material, mesh);
				}
				OpenGL.enableBlending(false);
			}
		}
	}

	public void updateUniforms(Transform transform, Camera camera, Material material) {
		for (int shaderIndex = 0; shaderIndex < amountOfShaders; shaderIndex++) {
			shaders[shaderIndex].updateUniforms(transform, camera, material);
		}
	}
}
