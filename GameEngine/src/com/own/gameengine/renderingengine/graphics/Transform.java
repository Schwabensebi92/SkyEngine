package com.own.gameengine.renderingengine.graphics;


import com.own.gameengine.coreengine.math.Quaternion;
import com.own.gameengine.coreengine.math.Vector3f;
import com.own.gameengine.coreengine.math.matrix.Matrix4f;
import com.own.gameengine.coreengine.math.matrix.OpenGLWrapperMatrix4f;
import com.own.gameengine.coreengine.math.matrix.RotationMatrix4f;
import com.own.gameengine.coreengine.math.matrix.ScaleMatrix4f;
import com.own.gameengine.coreengine.math.matrix.TranslationMatrix4f;


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
	
	public Matrix4f getTransformation() {
		Matrix4f translationMatrix = new TranslationMatrix4f(translation);
		Matrix4f rotationMatrix = new RotationMatrix4f(rotation);
		Matrix4f scaleMatrix = new ScaleMatrix4f(scale);
		// Get OpenGLWrapper matrix
		Matrix4f openGLWrapperMatrix = new OpenGLWrapperMatrix4f();
		
		return openGLWrapperMatrix.mul(translationMatrix.mul(rotationMatrix.mul(scaleMatrix)));
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
		rotation = additionalRotation.mul(rotation);
		// Invers:
		// rotation.mul(additionalRotation);
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
		// TODO Use up vector
		
		Vector3f destinationForwardNormalized = new Vector3f(direction).normalize();
		Vector3f currentForwardNormalized = getRotation().getLocalZAxis().normalize();
		
		Vector3f rotationAxis = new Vector3f(currentForwardNormalized).cross(destinationForwardNormalized);
		float rotationAngle = (float) Math.acos(currentForwardNormalized.dot(destinationForwardNormalized));
		
		rotate(rotationAxis, rotationAngle);
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
