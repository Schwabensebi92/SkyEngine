package com.own.sky.renderingengine.concept;


import java.util.ArrayList;

import com.own.sky.coreengine.scenegraph.GameComponent;
import com.own.sky.renderingengine.cameraengine.Camera;
import com.own.sky.renderingengine.graphics.object.Material;
import com.own.sky.renderingengine.graphics.object.Mesh;
import com.own.sky.renderingengine.graphics.object.Transform;


public abstract class RenderingConcept {
	
	private RenderingConcepts type;
	
	public RenderingConcept(final RenderingConcepts type) {
		this.type = type;
	}
	
	public abstract void render(ArrayList<GameComponent> renderableGameComponents);
	
	public abstract void renderMesh(final Transform transform, final Camera camera, final Material material, final Mesh mesh);
	
	public void updateUniformsAutomatically(final Transform transform, final Camera camera, final Material material) {
		throw new RuntimeException("Not implemented yet!");
	}
	
	public RenderingConcepts getType() {
		return type;
	}
}