package com.own.gameengine.renderingengine.lightengine.light;


import com.own.gameengine.math.Vector3f;


public class AmbientLight extends Light {
	
	public AmbientLight(final Vector3f color, final float intensity) {
		super(Lights.AMBIENT_LIGHT, color, intensity);
	}
}
