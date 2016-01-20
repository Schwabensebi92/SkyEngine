package com.own.gameengine.renderingengine.graphics.object;


import com.own.gameengine.math.*;


public class Vertex {
	
	public final static int SIZE = 8;
	
	private Vector3f	position;
	private Vector2f	textureCoordinate;
	private Vector3f	normal;
	
	public Vertex(final Vector3f position, final Vector2f textureCoordinate, final Vector3f normal) {
		this.position = position;
		this.textureCoordinate = textureCoordinate;
		this.normal = normal;
	}
	
	public Vertex(final Vector3f position, final Vector2f textureCoordinate) {
		this(position, textureCoordinate, new Vector3f());
	}
	
	public Vertex(final Vector3f position) {
		this(position, new Vector2f());
	}
	
	public Vertex(final float x, final float y, final float z) {
		position = new Vector3f(x, y, z);
	}
	
	public Vector3f getPosition() {
		return position;
	}
	
	public void setPosition(final Vector3f position) {
		this.position = position;
	}
	
	public Vector2f getTextureCoordinate() {
		return textureCoordinate;
	}
	
	public void setTextureCoordinate(final Vector2f textureCoordinate) {
		this.textureCoordinate = textureCoordinate;
	}
	
	public Vector3f getNormal() {
		return normal;
	}
	
	public void setNormal(final Vector3f normal) {
		this.normal = normal;
	}
	
	@Override
	public String toString() {
		return "Position: " + position + " ; TextureCoordinate: " + textureCoordinate + " ; Normal: " + normal;
	}
}
