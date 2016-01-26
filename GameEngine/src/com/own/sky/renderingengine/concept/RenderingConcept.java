package com.own.sky.renderingengine.concept;


import java.util.ArrayList;

import com.own.sky.coreengine.scenegraph.GameComponent;
import com.own.sky.renderingengine.cameraengine.Camera;
import com.own.sky.renderingengine.concept.shader.uniform.Uniform;
import com.own.sky.renderingengine.graphics.object.Material;
import com.own.sky.renderingengine.graphics.object.Mesh;
import com.own.sky.renderingengine.graphics.object.Transform;


public abstract class RenderingConcept {
	
	private RenderingConcepts type;
	private ArrayList<Uniform<?>> uniforms;
	
	public RenderingConcept(final RenderingConcepts type) {
		this.type = type;
		this.uniforms = new ArrayList<>();
	}
	
	public abstract void render(ArrayList<GameComponent> renderableGameComponents);
	
	public abstract void renderMesh(final Transform transform, final Camera camera, final Material material, final Mesh mesh);
	
	public abstract void load();
	
	public abstract void link();
	
	public abstract void compile();
	
	public void updateUniforms(Transform transform, Camera camera, Material material) {
		updateAutomaticUniforms(transform, camera, material);
		
	}
	
	public void updateAutomaticUniforms(final Transform transform, final Camera camera, final Material material) {
		throw new RuntimeException("Not implemented yet!");
	}
	
	public abstract void updateCustomUniforms(Transform transform, Camera camera, Material material);
	
	public RenderingConcepts getType() {
		return type;
	}
}