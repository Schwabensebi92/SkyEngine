package com.own.gameengine.renderingengine.graphics.light;

import com.own.gameengine.coreengine.math.Vector3f;

public class AmbientLight extends Light {

	private Vector3f	intensity;

	public AmbientLight(Vector3f intensity) {
		this.intensity = intensity;
	}

	public Vector3f getIntensity() {
		return intensity;
	}

	public void setIntensity(Vector3f intensity) {
		this.intensity = intensity;
	}
}
