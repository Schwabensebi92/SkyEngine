package com.own.gameengine.coreengine.scenegraph;

import java.util.ArrayList;

import com.own.gameengine.renderingengine.graphics.Transform;

public class GameObject {

	private ArrayList<GameObject>		children;
	private ArrayList<GameComponent>	components;

	private Transform					transform;

	public GameObject() {
		children = new ArrayList<>();
		components = new ArrayList<>();

		transform = new Transform();
	}

	public void addChild(GameObject child) {
		children.add(child);
	}

	public void removeChild(GameObject child) {
		children.remove(child);
	}

	public void addComponent(GameComponent component) {
		components.add(component);
		component.setGameObject(this);
	}

	public void removeComponent(GameComponent component) {
		components.remove(component);
		component.setGameObject(null);
	}

	public void input() {
		for (GameComponent component : components)
			component.input();
		for (GameObject child : children)
			child.input();
	}

	public void update() {
		for (GameComponent component : components)
			component.update();
		for (GameObject child : children)
			child.update();
	}

	public void render() {
		for (GameComponent component : components)
			component.render();
		for (GameObject child : children)
			child.render();
	}

	public Transform getTransform() {
		return transform;
	}
}
