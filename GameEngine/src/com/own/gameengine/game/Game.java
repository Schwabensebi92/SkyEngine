package com.own.gameengine.game;


import com.own.gameengine.coreengine.scenegraph.*;
import com.own.gameengine.renderingengine.graphics.*;


public abstract class Game {
	
	private final String			name;
	private final WindowSettings	windowSettings;
	private Camera					camera;
	
	private final SceneGraph sceneGraph;
	
	public Game(final String name, final WindowSettings windowSettings) {
		this.name = name;
		this.windowSettings = windowSettings;
		sceneGraph = new SceneGraph();
	}
	
	public abstract void initialize();
	
	public abstract void cleanUp();
	
	public void update() {
		sceneGraph.update();
	}
	
	public Camera getCamera() {
		return camera;
	}
	
	public void setCamera(final Camera camera) {
		this.camera = camera;
	}
	
	public void addObject(final GameObject gameObject) {
		sceneGraph.addChild(gameObject);
	}
	
	public void removeObject(final GameObject gameObject) {
		sceneGraph.removeChild(gameObject);
	}
	
	public SceneGraph getSceneGraph() {
		return sceneGraph;
	}
	
	public String getName() {
		return name;
	}
	
	public WindowSettings getWindowSettings() {
		return windowSettings;
	}
}
