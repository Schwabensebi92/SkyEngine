package com.own.gameengine.coreengine.scenegraph;


public abstract class GameComponent {

	protected GameObject	gameObject;

	public abstract void input();

	public abstract void update();

	public abstract void render();

	public void setGameObject(GameObject gameObject) {
		this.gameObject = gameObject;
	}
}
