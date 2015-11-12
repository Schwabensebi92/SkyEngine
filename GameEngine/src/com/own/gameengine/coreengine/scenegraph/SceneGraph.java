package com.own.gameengine.coreengine.scenegraph;


import java.util.ArrayList;


public class SceneGraph {
	
	private ArrayList<GameObject> gameObjects;
	
	public SceneGraph() {
		gameObjects = new ArrayList<>();
	}
	
	public void addChild(final GameObject child) {
		gameObjects.add(child);
	}
	
	public void removeChild(final GameObject child) {
		gameObjects.remove(child);
	}
	
	public void clear() {
		gameObjects.clear();
	}
	
	public void input() {
		for (GameObject gameObject : gameObjects) {
			gameObject.input();
		}
	}
	
	public void update() {
		for (GameObject gameObject : gameObjects) {
			gameObject.update();
		}
	}
	
	public void collectRenderableGameComponents(final ArrayList<GameComponent> renderableGameComponents) {
		for (GameObject object : gameObjects) {
			collectRenderableGameComponents(renderableGameComponents, object);
		}
	}
	
	private void collectRenderableGameComponents(final ArrayList<GameComponent> renderableGameComponents, final GameObject object) {
		for (GameComponent component : object.getComponents()) {
			if (component.isRenderEnabled()) {
				renderableGameComponents.add(component);
			}
		}
		
		for (GameObject child : object.getChildren()) {
			collectRenderableGameComponents(renderableGameComponents, child);
		}
	}
}
