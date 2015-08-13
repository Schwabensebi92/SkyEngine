package com.own.gameengine.game;

import com.own.gameengine.coreengine.scenegraph.GameObject;
import com.own.gameengine.renderingengine.graphics.*;

public abstract class Game {

	private String		name;
	private Display		display;
	private Camera		camera;

	private GameObject	sceneGraph;

	public Game(final String name, final Display display) {
		this.name = name;
		this.display = display;
		this.sceneGraph = new GameObject();
	}

	public abstract void initialize();

	public void input() {
		sceneGraph.input();
	}

	public void update() {
		sceneGraph.update();
	}

	public abstract void cleanUp();

	public Camera getCamera() {
		return camera;
	}

	public void setCamera(Camera camera) {
		this.camera = camera;
	}

	public void addObject(GameObject gameObject) {
		sceneGraph.addChild(gameObject);
	}

	public void removeObject(GameObject gameObject) {
		sceneGraph.removeChild(gameObject);
	}

	public GameObject getSceneGraph() {
		return sceneGraph;
	}

	public String getName() {
		return name;
	}

	public Display getDisplay() {
		return display;
	}
}
