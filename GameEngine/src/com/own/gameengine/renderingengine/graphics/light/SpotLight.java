package com.own.gameengine.renderingengine.graphics.light;


import com.own.gameengine.coreengine.math.Vector3f;
import com.own.gameengine.physicsengine.physics.Attenuation;


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
