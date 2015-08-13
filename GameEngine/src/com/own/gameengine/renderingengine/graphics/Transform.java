package com.own.gameengine.renderingengine.graphics;

import com.own.gameengine.coreengine.math.Vector3f;
import com.own.gameengine.coreengine.math.matrix.*;

public class Transform {

	private Vector3f	translation;
	private Vector3f	rotation;
	private Vector3f	scale;

	public Transform() {
		translation = new Vector3f();
		rotation = new Vector3f();
		scale = new Vector3f(1.0f, 1.0f, 1.0f);
	}

	public Matrix4f getTransformation() {
		Matrix4f translationMatrix = new TranslationMatrix4f(translation);
		Matrix4f rotationMatrix = new RotationMatrix4f(rotation);
		Matrix4f scaleMatrix = new ScaleMatrix4f(scale);

		return translationMatrix.mul(rotationMatrix.mul(scaleMatrix));
	}

	public Matrix4f getProjectedTransformation(Camera camera) {
		Matrix4f transformationMatrix = getTransformation();
		Matrix4f projectionMatrix = camera.getProjection().getProjectionMatrix();
		Matrix4f cameraRotationMatrix = new CameraRotationMatrix4f(camera.getForward(), camera.getUp());
		Matrix4f cameraTranslationMatrix = new TranslationMatrix4f(new Vector3f(camera.getPosition()).mul(-1));

		return projectionMatrix.mul(cameraRotationMatrix.mul(cameraTranslationMatrix.mul(transformationMatrix)));
	}

	public Vector3f getTranslation() {
		return translation;
	}

	public void setTranslation(Vector3f translation) {
		this.translation = translation;
	}

	public Vector3f getRotation() {
		return rotation;
	}

	public void setRotation(Vector3f rotation) {
		this.rotation = rotation;
	}

	public Vector3f getScale() {
		return scale;
	}

	public void setScale(Vector3f scale) {
		this.scale = scale;
	}
}
