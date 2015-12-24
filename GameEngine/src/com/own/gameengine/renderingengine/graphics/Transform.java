package com.own.gameengine.renderingengine.graphics;


import com.own.gameengine.coreengine.math.*;
import com.own.gameengine.coreengine.math.matrix.*;


public class Transform {
	
	private Vector3f	translation;
	private Quaternion	rotation;
	private Vector3f	scale;
	
	public Transform() {
		translation = new Vector3f();
		rotation = new Quaternion();
		scale = new Vector3f(1.0f, 1.0f, 1.0f);
	}
	
	public Matrix4f getTransformation() {
		Matrix4f translationMatrix = new TranslationMatrix4f(translation);
		Matrix4f rotationMatrix = new RotationMatrix4f(rotation);
		Matrix4f scaleMatrix = new ScaleMatrix4f(scale);
		
		return translationMatrix.mul(rotationMatrix.mul(scaleMatrix));
	}
	
	public Matrix4f getProjectedTransformation(final Camera camera) {
		// Get object transformation matrix
		Matrix4f transformationMatrix = getTransformation();
		// Get camera projection matrix
		Matrix4f projectionMatrix = camera.getProjection().getProjectionMatrix();
		// Get camera rotation matrix and negate it
		Matrix4f cameraRotationMatrix = new RotationMatrix4f(camera.getGameObject().getTransform().getRotation());
		// Get camera translation matrix and negate it
		Matrix4f cameraTranslationMatrix = new TranslationMatrix4f(
				new Vector3f(camera.getGameObject().getTransform().getTranslation()).mul(-1));
				
		return projectionMatrix.mul(cameraRotationMatrix.mul(cameraTranslationMatrix.mul(transformationMatrix)));
	}
	
	public void translate(final Vector3f translationVector) {
		translation.add(translationVector);
	}
	
	public void rotate(final Vector3f rotationAxis, final float angle) {
		Quaternion additionalRotation = new Quaternion(rotationAxis, angle);
		additionalRotation.normalize();
		rotation = additionalRotation.mul(rotation).normalize();
	}
	
	public void scale(final Vector3f scaleVector) {
		scale.mul(scaleVector);
	}
	
	public Vector3f getTranslation() {
		return translation;
	}
	
	public void setTranslation(final Vector3f translation) {
		this.translation = translation;
	}
	
	public Quaternion getRotation() {
		return rotation;
	}
	
	public void setRotation(final Quaternion rotation) {
		this.rotation = rotation;
	}
	
	public Vector3f getScale() {
		return scale;
	}
	
	public void setScale(final Vector3f scale) {
		this.scale = scale;
	}
}
