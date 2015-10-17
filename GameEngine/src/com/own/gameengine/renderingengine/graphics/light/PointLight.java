package com.own.gameengine.renderingengine.graphics.light;


import com.own.gameengine.coreengine.math.Vector3f;
import com.own.gameengine.physicsengine.physics.Attenuation;


public class PointLight extends Light {
	
	private Attenuation	attenuation;
	private Vector3f	position;
	private float		range;
	
	public PointLight(final Vector3f color, final float intensity, final Attenuation attenuation, final Vector3f position,
			final float range) {
		super(Lights.POINT_LIGHT, color, intensity);
		this.attenuation = attenuation;
		this.position = position;
		this.range = range;
	}
	
	public Attenuation getAttenuation() {
		return attenuation;
	}
	
	public void setAttenuation(final Attenuation attenuation) {
		this.attenuation = attenuation;
	}
	
	public Vector3f getPosition() {
		return position;
	}
	
	public void setPosition(final Vector3f position) {
		this.position = position;
	}
	
	public float getRange() {
		return range;
	}
	
	public void setRange(final float range) {
		this.range = range;
	}
}
