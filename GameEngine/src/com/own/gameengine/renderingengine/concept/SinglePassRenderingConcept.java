package com.own.gameengine.renderingengine.concept;


import java.util.ArrayList;

import com.own.gameengine.coreengine.scenegraph.GameComponent;
import com.own.gameengine.renderingengine.concept.shader.OpenGLProgram;
import com.own.gameengine.renderingengine.concept.shader.singlepass.*;
import com.own.gameengine.renderingengine.graphics.*;
import com.own.gameengine.renderingengine.graphics.object.*;


public class SinglePassRenderingConcept extends RenderingConcept {
	
	private final static int	RENDERING_CONCEPT_SINGLE_MAX_POINT_LIGHTS	= 4;
	private final static int	RENDERING_CONCEPT_SINGLE_MAX_SPOT_LIGHTS	= 4;
	
	private OpenGLProgram program;
	
	public SinglePassRenderingConcept() {
		super(RenderingConcepts.SINGLE_PASS_RENDERINGCONCEPT);
		
		program = new OpenGLProgram();
		program.addShader(new SinglePassNoVertexShader());
		program.addShader(new SinglePassNoFragmentShader());
		
		program.compile();
		
		program.addUniform("worldMatrix");
		program.addUniform("worldViewProjectionMatrix");
		
		program.addUniform("baseColor");
		program.addUniform("useTexture");
		
		// program.addUniform("eyePosition");
		//
		// program.addUniform("ambientLight");
		//
		// program.addUniform("specularIntensity");
		// program.addUniform("specularExponent");
		//
		// program.addUniform("directionalLight.color");
		// program.addUniform("directionalLight.intensity");
		// program.addUniform("directionalLight.direction");
		//
		// for (int i = 0; i < RENDERING_CONCEPT_SINGLE_MAX_POINT_LIGHTS; i++) {
		// program.addUniform("pointLights[" + i + "].color");
		// program.addUniform("pointLights[" + i + "].intensity");
		// program.addUniform("pointLights[" + i + "].attenuation.constant");
		// program.addUniform("pointLights[" + i + "].attenuation.linear");
		// program.addUniform("pointLights[" + i + "].attenuation.exponent");
		// program.addUniform("pointLights[" + i + "].position");
		// program.addUniform("pointLights[" + i + "].range");
		// }
		//
		// for (int i = 0; i < RENDERING_CONCEPT_SINGLE_MAX_SPOT_LIGHTS; i++) {
		// program.addUniform("spotLights[" + i + "].color");
		// program.addUniform("spotLights[" + i + "].intensity");
		// program.addUniform("spotLights[" + i + "].attenuation.constant");
		// program.addUniform("spotLights[" + i + "].attenuation.linear");
		// program.addUniform("spotLights[" + i + "].attenuation.exponent");
		// program.addUniform("spotLights[" + i + "].position");
		// program.addUniform("spotLights[" + i + "].range");
		//
		// program.addUniform("spotLights[" + i + "].direction");
		// program.addUniform("spotLights[" + i + "].cutoff");
		// }
	}
	
	@Override
	public void renderMesh(final Transform transform, final Camera camera, final Material material, final Mesh mesh) {
		updateUniforms(transform, camera, material);
		mesh.draw();
	}
	
	private void updateUniforms(final Transform transform, final Camera camera, final Material material) {
		program.setUniform("worldMatrix", transform.getWorldMatrix());
		program.setUniform("worldViewProjectionMatrix", transform.getWorldViewProjectionMatrix(camera));
		
		program.setUniform("baseColor", material.getColor());
		
		if (material.getTexture() != null) {
			material.getTexture().bind();
			program.setUniformi("useTexture", 1);
		} else {
			program.setUniformi("useTexture", 0);
		}
		
		// program.setUniform("eyePosition", camera.getGameObject().getTransform().getTranslation());
		//
		// if (ambientLight != null) {
		// program.setUniform("ambientLight", ambientLight);
		// }
		//
		// program.setUniformf("specularIntensity", material.getSpecularIntensity());
		// program.setUniformf("specularExponent", material.getSpecularExponent());
		//
		// if (directionalLight != null) {
		// program.setUniform("directionalLight", directionalLight);
		// }
		//
		// for (int i = 0; i < Math.min(pointLights.length, RENDERING_CONCEPT_SINGLE_MAX_POINT_LIGHTS); i++) {
		// program.setUniform("pointLights[" + i + "]", pointLights[i]);
		// }
		//
		// for (int i = 0; i < Math.min(spotLights.length, RENDERING_CONCEPT_SINGLE_MAX_SPOT_LIGHTS); i++) {
		// program.setUniform("spotLights[" + i + "]", spotLights[i]);
		// }
	}
	
	@Override
	public void render(final ArrayList<GameComponent> renderableGameComponents) {
		for (GameComponent renderableGameComponent : renderableGameComponents) {
			program.bind();
			renderableGameComponent.render(this);
		}
	}
}