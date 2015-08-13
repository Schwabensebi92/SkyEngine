package com.own.gameengine.renderingengine.graphics;

import com.own.gameengine.coreengine.math.Vector3f;
import com.own.gameengine.renderingengine.graphics.projection.Projection;

public class Camera {

	public final static Vector3f	xAxis	= new Vector3f(1, 0, 0);
	public final static Vector3f	yAxis	= new Vector3f(0, 1, 0);
	public final static Vector3f	zAxis	= new Vector3f(0, 0, 1);

	private Projection				projection;

	private Vector3f				position;
	private Vector3f				forward;
	private Vector3f				up;

	public Camera(Projection projection, Vector3f position, Vector3f forward, Vector3f up) {
		this.projection = projection;

		this.position = position;
		this.forward = forward;
		this.up = up;

		forward.normalize();
		up.normalize();
	}

	public Camera(Projection projection) {
		this(projection, new Vector3f(), new Vector3f(zAxis), new Vector3f(yAxis));
	}

	public void move(Vector3f direction, float amount) {
		position.add(new Vector3f(direction).mul(amount));
	}

	public void rotateX(float degree) {
		Vector3f hAxis = new Vector3f(yAxis).cross(forward).normalize();

		forward.rotate(degree, hAxis).normalize();

		up = new Vector3f(forward).cross(hAxis).normalize();
	}

	public void rotateY(float angle) {
		Vector3f hAxis = new Vector3f(yAxis).cross(forward).normalize();

		forward.rotate(angle, yAxis).normalize();

		up = new Vector3f(forward).cross(hAxis).normalize();
	}

	public Projection getProjection() {
		return projection;
	}

	public Vector3f getLeft() {
		return new Vector3f(forward).cross(up).normalize();
	}

	public Vector3f getRight() {
		return new Vector3f(up).cross(forward).normalize();
	}

	public Vector3f getPosition() {
		return position;
	}

	public void setPosition(Vector3f position) {
		this.position = position;
	}

	public Vector3f getForward() {
		return forward;
	}

	public void setForward(Vector3f forward) {
		this.forward = forward.normalize();
	}

	public Vector3f getUp() {
		return up;
	}

	public void setUp(Vector3f up) {
		this.up = up.normalize();
	}
}
