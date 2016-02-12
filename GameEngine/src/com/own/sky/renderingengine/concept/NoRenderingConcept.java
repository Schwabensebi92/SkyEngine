package com.own.sky.renderingengine.concept;


import java.util.ArrayList;

import com.own.sky.coreengine.scenegraph.GameComponent;
import com.own.sky.renderingengine.cameraengine.Camera;
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
	
	@Override
	public void updateCustomUniforms(final Transform transform, final Camera camera, final Material material) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void load() throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void link() throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void compile() throws Exception {
		// TODO Auto-generated method stub
		
	}
}
