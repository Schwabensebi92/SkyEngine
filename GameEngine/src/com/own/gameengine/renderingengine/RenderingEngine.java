package com.own.gameengine.renderingengine;


import java.util.ArrayList;

import com.own.gameengine.coreengine.scenegraph.*;
import com.own.gameengine.renderingengine.concept.RenderingConcepts;
import com.own.gameengine.renderingengine.concept.lightmodel.LightModels;
import com.own.gameengine.renderingengine.graphics.Camera;
import com.own.gameengine.renderingengine.graphics.light.Light;


public class RenderingEngine {
	
	private final static RenderingConcepts	renderingConcept	= RenderingConcepts.SINGLE_PASS_RENDERINGCONCEPT;
	private final static LightModels		lightModel			= LightModels.NO_LIGHTMODEL;
	
	private Camera mainCamera;
	
	private ArrayList<Light> lights;
	
	public RenderingEngine() {
		// TODO: Do some meaningful stuff
	}
	
	public void initialize() {
		renderingConcept.getRenderingConcept();
		lightModel.getLightModel();
	}
	
	public void render(final SceneGraph sceneGraph) {
		ArrayList<GameComponent> renderableGameComponents = new ArrayList<>();
		sceneGraph.collectRenderableGameComponents(renderableGameComponents);
		renderingConcept.getRenderingConcept().render(renderableGameComponents);
	}
	
	public Camera getMainCamera() {
		return mainCamera;
	}
	
	public void setMainCamera(final Camera mainCamera) {
		this.mainCamera = mainCamera;
	}
	
	public ArrayList<Light> getLights() {
		return lights;
	}
}