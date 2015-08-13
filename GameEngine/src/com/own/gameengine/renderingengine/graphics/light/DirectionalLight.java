package com.own.gameengine.renderingengine.graphics.light;

import com.own.gameengine.coreengine.math.Vector3f;

public class DirectionalLight extends Light {

	private BaseLight	baseLight;
	private Vector3f	direction;

	public DirectionalLight(BaseLight baseLight, Vector3f direction) {
		this.baseLight = baseLight;
		this.direction = direction.normalize();
	}

	public BaseLight getBaseLight() {
		return baseLight;
	}

	public void setBaseLight(BaseLight baseLight) {
		this.baseLight = baseLight;
	}

	public Vector3f getDirection() {
		return direction;
	}

	public void setDirection(Vector3f direction) {
		this.direction = direction.normalize();
	}
}
