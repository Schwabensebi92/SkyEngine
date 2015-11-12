package com.own.gameengine.renderingengine.concept;


import java.util.ArrayList;

import com.own.gameengine.coreengine.scenegraph.GameComponent;
import com.own.gameengine.renderingengine.graphics.*;
import com.own.gameengine.renderingengine.graphics.light.*;
import com.own.gameengine.renderingengine.graphics.object.*;


public abstract class RenderingConcept {
	
	private RenderingConcepts type;
	
	protected AmbientLight		ambientLight;
	protected DirectionalLight	directionalLight;
	protected PointLight[]		pointLights;
	protected SpotLight[]		spotLights;
	
	public RenderingConcept(final RenderingConcepts type) {
		this.type = type;
		ambientLight = null;
		directionalLight = null;
		pointLights = new PointLight[] {};
		spotLights = new SpotLight[] {};
	}
	
	public abstract void render(ArrayList<GameComponent> renderableGameComponents);
	
	public abstract void renderMesh(final Transform transform, final Camera camera, final Material material, final Mesh mesh);
	
	public void setAmbientLight(final AmbientLight ambientLight) {
		this.ambientLight = ambientLight;
	}
	
	public void setDirectionalLight(final DirectionalLight directionalLight) {
		this.directionalLight = directionalLight;
	}
	
	public void setPointLights(final PointLight[] pointLights) {
		this.pointLights = pointLights;
	}
	
	public void setSpotLights(final SpotLight[] spotLights) {
		this.spotLights = spotLights;
	}
}