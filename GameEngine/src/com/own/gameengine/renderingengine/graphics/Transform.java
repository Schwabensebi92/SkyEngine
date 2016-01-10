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
	
	public Transform(final Transform transform) {
		translation = new Vector3f(transform.getTranslation());
		rotation = new Quaternion(transform.getRotation());
		scale = new Vector3f(transform.getScale());
	}
	
	public Matrix4f getWorldMatrix() {
		// Get object translation matrix
		Matrix4f translationMatrix = new TranslationMatrix4f(translation);
		
		// Get object rotation matrix
		Matrix4f rotationMatrix = new RotationMatrix4f(rotation);
		
		// Get object scale matrix
		Matrix4f scaleMatrix = new ScaleMatrix4f(scale);
		
		// Calculate world matrix and return it
		Matrix4f worldMatrix = translationMatrix.mul(rotationMatrix.mul(scaleMatrix));
		return worldMatrix;
	}
	
	public Matrix4f getWorldViewMatrix(final Camera camera) {
		// Get object world matrix
		Matrix4f worldMatrix = getWorldMatrix();
		
		// Get camera rotation and negate it
		Quaternion cameraRotation = new Quaternion(camera.getGameObject().getTransform().getRotation()).conjugate();
		// Get camera rotation matrix
		Matrix4f cameraRotationMatrix = new RotationMatrix4f(cameraRotation);
		
		// Get camera translation and negate it
		Vector3f cameraTranslation = new Vector3f(camera.getGameObject().getTransform().getTranslation()).mul(-1);
		// Get camera translation matrix
		Matrix4f cameraTranslationMatrix = new TranslationMatrix4f(cameraTranslation);
		
		// Calculate worldView matrix and return it
		Matrix4f worldViewMatrix = cameraRotationMatrix.mul(cameraTranslationMatrix.mul(worldMatrix));
		return worldViewMatrix;
	}
	
	public Matrix4f getWorldViewProjectionMatrix(final Camera camera) {
		// Get world view matrix
		Matrix4f worldViewMatrix = getWorldViewMatrix(camera);
		
		// Get camera projection matrix
		Matrix4f projectionMatrix = camera.getProjection().getProjectionMatrix();
		
		// Calculate worldViewProjection matrix and return it
		Matrix4f worldViewProjectionMatrix = projectionMatrix.mul(worldViewMatrix);
		return worldViewProjectionMatrix;
	}
	
	public void translate(final Vector3f translationVector) {
		translation.add(translationVector);
	}
	
	public void rotate(final Quaternion additionalRotation) {
		rotation = new Quaternion(additionalRotation).mul(rotation);
	}
	
	public void scale(final Vector3f scaleVector) {
		scale.mul(scaleVector);
	}
	
	/**
	 * Sets the rotation to face the direction given by <code>direction</code> and keep the upwards orientation to the <code>up</code>
	 * -vector.
	 * 
	 * @param direction
	 *            The direction to look at.
	 * @param up
	 *            The upwards direction in which the transform should be oriented.
	 * 			
	 * @see <a href="http://lolengine.net/blog/2013/09/18/beautiful-maths-quaternion-from-vectors">lolengine.net/beautiful-maths-quaternion-
	 *      from-vectors</a>
	 * @see <a href="http://gamedev.stackexchange.com/a/15078">gamedev.stackexchange.com/15078</a>
	 * @see <a href="http://gamedev.stackexchange.com/questions/53129/quaternion-look-at-with-up-vector">gamedev.stackexchange.com/
	 *      quaternion-look-at-with-up-vector</a>
	 */
	public void lookAt(final Vector3f direction, final Vector3f up) {
		Quaternion rotationQuaternion = null;
		
		// Forward direction
		
		Vector3f destinationForwardNormalized = new Vector3f(direction).normalize();
		Vector3f currentForwardNormalized = getRotation().getLocalZAxis().normalize();
		
		float dotProduct = currentForwardNormalized.dot(destinationForwardNormalized);
		
		if (MathUtil.floatNearlyEquals(dotProduct, 1.0f, 0.000001f)) {
			// destination and current forward are nearly equal, rotate by identity quaternion
			rotationQuaternion = new Quaternion();
		} else if (MathUtil.floatNearlyEquals(dotProduct, -1.0f, 0.000001f)) {
			// destination and current forward point exactly in the opposite direction, rotate by PI
			rotationQuaternion = new Quaternion(getRotation().getLocalYAxis(), (float) Math.PI);
		} else {
			// normal case
			Vector3f rotationAxis = new Vector3f(currentForwardNormalized).cross(destinationForwardNormalized).normalize();
			float rotationAngle = (float) Math.acos(dotProduct);
			rotationQuaternion = new Quaternion(rotationAxis, rotationAngle);
		}
		
		rotate(rotationQuaternion);
		
		// Up direction
		
		Vector3f destinationUpNormalized = new Vector3f(up).normalize();
		Vector3f currentUpNormalized = getRotation().getLocalYAxis().normalize();
		
		dotProduct = currentUpNormalized.dot(destinationUpNormalized);
		
		if (MathUtil.floatNearlyEquals(dotProduct, 1.0f, 0.000001f)) {
			// destination and current up are nearly equal, rotate by identity quaternion
			rotationQuaternion = new Quaternion();
		} else if (MathUtil.floatNearlyEquals(dotProduct, -1.0f, 0.000001f)) {
			// destination and current up point exactly in the opposite direction, rotate by PI
			rotationQuaternion = new Quaternion(getRotation().getLocalZAxis(), (float) Math.PI);
		} else {
			// normal case
			Vector3f rotationAxis = new Vector3f(currentUpNormalized).cross(destinationUpNormalized).normalize();
			float rotationAngle = (float) Math.acos(dotProduct);
			rotationQuaternion = new Quaternion(rotationAxis, rotationAngle);
		}
		
		rotate(rotationQuaternion);
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
