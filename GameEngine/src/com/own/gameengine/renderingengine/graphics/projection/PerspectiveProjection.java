package com.own.gameengine.renderingengine.graphics.projection;


import com.own.gameengine.coreengine.math.matrix.*;


public class PerspectiveProjection extends Projection {
	
	private float	fieldOfView;
	private float	aspectRatio;
	private float	zNear;
	private float	zFar;
	
	public PerspectiveProjection(final float fieldOfView, final float aspectRatio, final float zNear, final float zFar) {
		this.fieldOfView = fieldOfView;
		this.aspectRatio = aspectRatio;
		this.zNear = zNear;
		this.zFar = zFar;
	}
	
	public PerspectiveProjection(final float aspectRatio) {
		this(65.0f, aspectRatio, 0.1f, 1000.0f);
	}
	
	@Override
	public Matrix4f getProjectionMatrix() {
		return new PerspectiveProjectionMatrix4f(fieldOfView, aspectRatio, zNear, zFar);
	}
}
