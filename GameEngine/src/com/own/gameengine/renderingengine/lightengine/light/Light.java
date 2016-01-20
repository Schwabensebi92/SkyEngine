package com.own.gameengine.renderingengine.lightengine.light;


import com.own.gameengine.math.Vector3f;


public abstract class Light {
	
	private Lights		type;
	private Vector3f	color;
	private float		intensity;
	
	public Light(final Lights type, final Vector3f color, final float intensity) {
		this.type = type;
		this.color = color;
		this.intensity = intensity;
	}
	
	public Vector3f getColor() {
		return color;
	}
	
	public void setColor(final Vector3f color) {
		this.color = color;
	}
	
	public float getIntensity() {
		return intensity;
	}
	
	public void setIntensity(final float intensity) {
		this.intensity = intensity;
	}
}
