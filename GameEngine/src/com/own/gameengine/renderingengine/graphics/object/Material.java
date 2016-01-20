package com.own.gameengine.renderingengine.graphics.object;


import com.own.gameengine.math.Vector3f;


public class Material {
	
	private Texture		texture;
	private Vector3f	color;
	private float		specularIntensity;
	private float		specularExponent;
	
	public Material(final Texture texture, final Vector3f color, final float specularIntensity, final float specularExponent) {
		this.texture = texture;
		this.color = color;
		this.specularIntensity = specularIntensity;
		this.specularExponent = specularExponent;
	}
	
	public Material(final Texture texture, final Vector3f color) {
		this(texture, color, 2, 32);
	}
	
	public Material(final Texture texture, final float specularIntensity, final float specularExponent) {
		this(texture, new Vector3f(1.0f, 1.0f, 1.0f), specularIntensity, specularExponent);
	}
	
	public Material(final Texture texture) {
		this(texture, new Vector3f(1.0f, 1.0f, 1.0f));
	}
	
	public Material(final Vector3f color, final float specularIntensity, final float specularExponent) {
		this(null, color, specularIntensity, specularExponent);
	}
	
	public Material(final Vector3f color) {
		this(null, color);
	}
	
	public Texture getTexture() {
		return texture;
	}
	
	public void setTexture(final Texture texture) {
		this.texture = texture;
	}
	
	public Vector3f getColor() {
		return color;
	}
	
	public void setColor(final Vector3f color) {
		this.color = color;
	}
	
	public float getSpecularIntensity() {
		return specularIntensity;
	}
	
	public void setSpecularIntensity(final float specularIntensity) {
		this.specularIntensity = specularIntensity;
	}
	
	public float getSpecularExponent() {
		return specularExponent;
	}
	
	public void setSpecularExponent(final float specularExponent) {
		this.specularExponent = specularExponent;
	}
}
