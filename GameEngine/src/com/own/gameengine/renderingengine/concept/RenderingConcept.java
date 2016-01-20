package com.own.gameengine.renderingengine.concept;


import java.util.ArrayList;

import com.own.gameengine.coreengine.scenegraph.GameComponent;
import com.own.gameengine.renderingengine.cameraengine.Camera;
import com.own.gameengine.renderingengine.graphics.object.Material;
import com.own.gameengine.renderingengine.graphics.object.Mesh;
import com.own.gameengine.renderingengine.graphics.object.Transform;


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