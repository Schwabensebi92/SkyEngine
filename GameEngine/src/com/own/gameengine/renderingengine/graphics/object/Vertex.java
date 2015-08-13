package com.own.gameengine.renderingengine.graphics.object;

import com.own.gameengine.coreengine.math.*;

public class Vertex {

	public final static int SIZE = 8;

	private Vector3f position;
	private Vector2f textureCoordinate;
	private Vector3f normal;

	public Vertex(Vector3f position, Vector2f textureCoordinate, Vector3f normal) {
		this.position = position;
		this.textureCoordinate = textureCoordinate;
		this.normal = normal;
	}

	public Vertex(Vector3f position, Vector2f textureCoordinate) {
		this(position, textureCoordinate, new Vector3f());
	}

	public Vertex(Vector3f position) {
		this(position, new Vector2f());
	}

	public Vertex(float x, float y, float z) {
		this.position = new Vector3f(x, y, z);
	}

	public Vector3f getPosition() {
		return position;
	}

	public void setPosition(Vector3f position) {
		this.position = position;
	}

	public Vector2f getTextureCoordinate() {
		return textureCoordinate;
	}

	public void setTextureCoordinate(Vector2f textureCoordinate) {
		this.textureCoordinate = textureCoordinate;
	}

	public Vector3f getNormal() {
		return normal;
	}

	public void setNormal(Vector3f normal) {
		this.normal = normal;
	}
}
