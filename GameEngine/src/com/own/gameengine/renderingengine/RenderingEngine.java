package com.own.gameengine.renderingengine;


import java.util.ArrayList;

import com.own.gameengine.coreengine.scenegraph.SceneGraph;
import com.own.gameengine.renderingengine.concept.RenderingConcepts;
import com.own.gameengine.renderingengine.concept.lightmodel.LightModels;
import com.own.gameengine.renderingengine.graphics.light.Light;


public class RenderingEngine {
	
	private final static RenderingConcepts	renderingConcept	= RenderingConcepts.SINGLE_PASS_RENDERINGCONCEPT;
	private final static LightModels		lightModel			= LightModels.NO_LIGHTMODEL;
	
	private ArrayList<Light> lights;
	
	public RenderingEngine() {
		// TODO Do some meaningful stuff
	}
	
	public void initialize() {
		renderingConcept.getRenderingConcept();
		lightModel.getLightModel();
	}
	
	public void cleanUp() {
	
	}
	
	public void run(final SceneGraph sceneGraph) {
		renderingConcept.getRenderingConcept().render(sceneGraph.collectGameComponentsRenderEnabled());
	}
	
	public ArrayList<Light> getLights() {
		return lights;
	}
}