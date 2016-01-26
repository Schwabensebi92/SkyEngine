package com.own.sky.renderingengine.concept;


import java.util.ArrayList;

import com.own.sky.coreengine.scenegraph.GameComponent;
import com.own.sky.renderingengine.cameraengine.Camera;
import com.own.sky.renderingengine.graphics.*;
import com.own.sky.renderingengine.graphics.object.*;


public class NoRenderingConcept extends RenderingConcept {
	
	public NoRenderingConcept() {
		super(RenderingConcepts.NO_RENDERINGCONCEPT);
	}
	
	@Override
	public void render(final ArrayList<GameComponent> renderableGameComponents) {
		// TODO Implement
	}
	
	@Override
	public void renderMesh(final Transform transform, final Camera camera, final Material material, final Mesh mesh) {
		// TODO Implement
	}
}