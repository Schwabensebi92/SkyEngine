package com.own.gameengine.renderingengine.graphics.light;


import com.own.gameengine.coreengine.math.Vector3f;


public class AmbientLight extends Light {
	
	public AmbientLight(final Vector3f color, final float intensity) {
		super(Lights.AMBIENT_LIGHT, color, intensity);
	}
}
