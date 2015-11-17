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
	
	public void update() {
		for (GameObject gameObject : gameObjects) {
			gameObject.update();
		}
	}
	
	public ArrayList<GameComponent> collectGameComponentsInputEnabled() {
		ArrayList<GameComponent> gameComponents = new ArrayList<>();
		for (GameObject object : gameObjects) {
			collectGameComponentsInputEnabled(gameComponents, object);
		}
		return gameComponents;
	}
	
	private void collectGameComponentsInputEnabled(final ArrayList<GameComponent> gameComponents, final GameObject object) {
		for (GameComponent component : object.getComponents()) {
			if (component.isInputEnabled()) {
				gameComponents.add(component);
			}
		}
		
		for (GameObject child : object.getChildren()) {
			collectGameComponentsInputEnabled(gameComponents, child);
		}
	}
	
	public ArrayList<GameComponent> collectGameComponentsUpdateEnabled() {
		ArrayList<GameComponent> gameComponents = new ArrayList<>();
		for (GameObject object : gameObjects) {
			collectGameComponentsUpdateEnabled(gameComponents, object);
		}
		return gameComponents;
	}
	
	private void collectGameComponentsUpdateEnabled(final ArrayList<GameComponent> gameComponents, final GameObject object) {
		for (GameComponent component : object.getComponents()) {
			if (component.isUpdateEnabled()) {
				gameComponents.add(component);
			}
		}
		
		for (GameObject child : object.getChildren()) {
			collectGameComponentsUpdateEnabled(gameComponents, child);
		}
	}
	
	public ArrayList<GameComponent> collectGameComponentsRenderEnabled() {
		ArrayList<GameComponent> gameComponents = new ArrayList<>();
		for (GameObject object : gameObjects) {
			collectGameComponentsRenderEnabled(gameComponents, object);
		}
		return gameComponents;
	}
	
	private void collectGameComponentsRenderEnabled(final ArrayList<GameComponent> gameComponents, final GameObject object) {
		for (GameComponent component : object.getComponents()) {
			if (component.isRenderEnabled()) {
				gameComponents.add(component);
			}
		}
		
		for (GameObject child : object.getChildren()) {
			collectGameComponentsRenderEnabled(gameComponents, child);
		}
	}
}
