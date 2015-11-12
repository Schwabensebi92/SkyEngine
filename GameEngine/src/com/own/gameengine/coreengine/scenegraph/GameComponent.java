package com.own.gameengine.coreengine.scenegraph;

import com.own.gameengine.renderingengine.concept.RenderingConcept;

public abstract class GameComponent {
	
	private boolean			enableInput;
	private boolean			enableUpdate;
	private boolean			enableRender;
	protected GameObject	gameObject;
	
	public GameComponent(final boolean enableInput, final boolean enableUpdate, final boolean enableRender) {
		this.enableInput = enableInput;
		this.enableUpdate = enableUpdate;
		this.enableRender = enableRender;
	}
	
	public abstract void input();
	
	public abstract void update();
	
	public abstract void render(RenderingConcept renderingConcept);
	
	public void setGameObject(final GameObject gameObject) {
		this.gameObject = gameObject;
	}
	
	public boolean isInputEnabled() {
		return enableInput;
	}
	
	public boolean isUpdateEnabled() {
		return enableUpdate;
	}
	
	public boolean isRenderEnabled() {
		return enableRender;
	}
}
