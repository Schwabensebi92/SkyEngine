package com.own.gameengine.renderingengine.graphics.projection;

import com.own.gameengine.coreengine.math.matrix.*;

public class PerspectiveProjection extends Projection {

	private float	fieldOfView;
	private float	aspectRatio;
	private float	zNear;
	private float	zFar;

	public PerspectiveProjection(float fieldOfView, float aspectRatio, float zNear, float zFar) {
		this.fieldOfView = fieldOfView;
		this.aspectRatio = aspectRatio;
		this.zNear = zNear;
		this.zFar = zFar;
	}

	public PerspectiveProjection(float aspectRatio) {
		this(70.0f, aspectRatio, 0.1f, 1000.0f);
	}

	@Override
	public Matrix4f getProjectionMatrix() {
		return new PerspectiveProjectionMatrix4f(fieldOfView, aspectRatio, zNear, zFar);
	}
}
