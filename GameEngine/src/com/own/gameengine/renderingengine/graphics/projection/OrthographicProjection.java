package com.own.gameengine.renderingengine.graphics.projection;


import com.own.gameengine.math.matrix.*;


public class OrthographicProjection extends Projection {
	
	private float	left;
	private float	right;
	private float	bottom;
	private float	top;
	private float	near;
	private float	far;
	
	public OrthographicProjection(final float left, final float right, final float bottom, final float top, final float near,
			final float far) {
		this.left = left;
		this.right = right;
		this.bottom = bottom;
		this.top = top;
		this.near = near;
		this.far = far;
	}
	
	public OrthographicProjection(final float aspectRatio) {
		this(-aspectRatio, aspectRatio, -1.0f, 1.0f, 0.1f, 1000.0f);
	}
	
	@Override
	public Matrix4f getProjectionMatrix() {
		return new OrthographicProjectionMatrix4f(left, right, bottom, top, near, far);
	}
}
