package com.own.sky.renderingengine.lightengine.light;


import com.own.sky.math.Vector3f;
import com.own.sky.physicsengine.physics.Attenuation;


public class SpotLight extends Light {
	
	private Attenuation	attenuation;
	private Vector3f	position;
	private float		range;
	private Vector3f	direction;
	private float		cutoff;
	
	public SpotLight(final Vector3f color, final float intensity, final Attenuation attenuation, final Vector3f position, final float range,
			final Vector3f direction, final float cutoff) {
		super(Lights.SPOT_LIGHT, color, intensity);
		this.attenuation = attenuation;
		this.position = position;
		this.range = range;
		this.direction = direction.normalize();
		this.cutoff = cutoff;
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
	
	public Vector3f getDirection() {
		return direction;
	}
	
	public void setDirection(final Vector3f direction) {
		this.direction = direction.normalize();
	}
	
	public float getCutoff() {
		return cutoff;
	}
	
	public void setCutoff(final float cutoff) {
		this.cutoff = cutoff;
	}
}
