package com.own.gameengine.renderingengine.graphics;


import com.own.gameengine.coreengine.*;
import com.own.gameengine.coreengine.math.*;
import com.own.gameengine.coreengine.scenegraph.GameComponent;
import com.own.gameengine.inputengine.*;
import com.own.gameengine.renderingengine.concept.RenderingConcept;
import com.own.gameengine.renderingengine.graphics.projection.Projection;


public class Camera extends GameComponent {
	
	private Projection projection;
	
	public Camera(final Projection projection) {
		super(true, false, false);
		
		this.projection = projection;
	}
	
	public Projection getProjection() {
		return projection;
	}
	
	public void activate() {
		((CameraEngine) CoreObjectRegister.get(CoreObject.CAMERA_ENGINE)).activateCamera(this);
	}
	
	public void deactivate() {
		((CameraEngine) CoreObjectRegister.get(CoreObject.CAMERA_ENGINE)).deactivateCamera(this);
	}
	
	@Override
	public void input(final Mouse mouse, final Keyboard keyboard) {
		Transform transform = getGameObject().getTransform();
		
		float moveAmount = 1.0f * (float) ((CoreTiming) CoreObjectRegister.get(CoreObject.CORE_TIMING)).getDelta();
		
		if (keyboard.isKeyDown(KeyboardKeys.KEY_W)) {
			move(transform.getRotation().getForwardVector(), moveAmount);
		}
		if (keyboard.isKeyDown(KeyboardKeys.KEY_S)) {
			move(transform.getRotation().getBackVector(), moveAmount);
		}
		if (keyboard.isKeyDown(KeyboardKeys.KEY_A)) {
			move(transform.getRotation().getLeftVector(), moveAmount);
		}
		if (keyboard.isKeyDown(KeyboardKeys.KEY_D)) {
			move(transform.getRotation().getRightVector(), moveAmount);
		}
		
		float rotationAmount = 60f * (float) ((CoreTiming) CoreObjectRegister.get(CoreObject.CORE_TIMING)).getDelta();
		
		if (keyboard.isKeyDown(KeyboardKeys.KEY_UP)) {
			rotate(transform.getRotation().getRightVector(), rotationAmount);
		}
		if (keyboard.isKeyDown(KeyboardKeys.KEY_DOWN)) {
			rotate(transform.getRotation().getLeftVector(), rotationAmount);
		}
		if (keyboard.isKeyDown(KeyboardKeys.KEY_LEFT)) {
			rotate(CoordinateSystem.CoordinateAxis.Y_AXIS.getVector(), rotationAmount);
		}
		if (keyboard.isKeyDown(KeyboardKeys.KEY_RIGHT)) {
			rotate(CoordinateSystem.CoordinateAxis.Y_AXIS.getVector(), -rotationAmount);
		}
	}
	
	private void move(final Vector3f direction, final float moveAmount) {
		getGameObject().getTransform().translate(direction.mul(moveAmount));
	}
	
	private void rotate(final Vector3f axis, final float rotationAmount) {
		getGameObject().getTransform().rotate(axis, (float) Math.toRadians(rotationAmount));
	}
	
	@Override
	public void update() {
	
	}
	
	@Override
	public void render(final RenderingConcept renderingConcept) {
	
	}
}
