package com.own.gameengine.coreengine.scenegraph;


import java.util.ArrayList;


public class SceneGraph {
	
	private ArrayList<GameObject> gameObjects;
	
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
	
	public void render() {
		for (GameObject gameObject : gameObjects) {
			gameObject.render();
		}
	}
}
