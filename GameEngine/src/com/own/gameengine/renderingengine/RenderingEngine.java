package com.own.gameengine.renderingengine;


import java.util.ArrayList;

import com.own.gameengine.coreengine.scenegraph.SceneGraph;
import com.own.gameengine.renderingengine.graphics.Camera;
import com.own.gameengine.renderingengine.graphics.light.Light;


public class RenderingEngine {
	
	private Camera mainCamera;
	
	private ArrayList<Light> lights;
	
	public RenderingEngine() {
		// TODO: Do some meaningful stuff
	}
	
	public void render(final SceneGraph sceneGraph) {
		sceneGraph.render();
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