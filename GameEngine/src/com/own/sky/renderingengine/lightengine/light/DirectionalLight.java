package com.own.sky.renderingengine.lightengine.light;


import com.own.sky.math.Vector3f;


public class DirectionalLight extends Light {
	
	private Vector3f direction;
	
	public DirectionalLight(final Vector3f color, final float intensity, final Vector3f direction) {
		super(Lights.DIRECTIONAL_LIGHT, color, intensity);
		this.direction = direction.normalize();
	}
	
	public Vector3f getDirection() {
		return direction;
	}
	
	public void setDirection(final Vector3f direction) {
		this.direction = direction.normalize();
	}
}
