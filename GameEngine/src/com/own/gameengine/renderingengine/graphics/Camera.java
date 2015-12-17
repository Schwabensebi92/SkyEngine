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
		float moveAmount = 1.0f * (float) ((CoreTiming) CoreObjectRegister.get(CoreObject.CORE_TIMING)).getDelta();
		
		if (keyboard.isKeyDown(KeyboardKeys.KEY_W)) {
			move(getGameObject().getTransform().getRotation().getForwardVector(), moveAmount);
		}
		if (keyboard.isKeyDown(KeyboardKeys.KEY_S)) {
			move(getGameObject().getTransform().getRotation().getBackVector(), moveAmount);
		}
		if (keyboard.isKeyDown(KeyboardKeys.KEY_A)) {
			move(getGameObject().getTransform().getRotation().getLeftVector(), moveAmount);
		}
		if (keyboard.isKeyDown(KeyboardKeys.KEY_D)) {
			move(getGameObject().getTransform().getRotation().getRightVector(), moveAmount);
		}
		
		float sensitivity = 1.0f;
		
		Vector2f deltaPosition = mouse.getMousePositionDelta();
		
		if (deltaPosition.getX() != 0.0f) {
			getGameObject().getTransform().getRotation().rotate(CoordinateSystem.Y_AXIS,
					(float) Math.toRadians(deltaPosition.getX() * sensitivity));
		}
		if (deltaPosition.getY() != 0.0f) {
			getGameObject().getTransform().getRotation().rotate(getGameObject().getTransform().getRotation().getRightVector(),
					(float) Math.toRadians(-deltaPosition.getY() * sensitivity));
		}
	}
	
	private void move(final Vector3f direction, final float moveAmount) {
		getGameObject().getTransform().getTranslation().add(direction.mul(moveAmount));
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void render(final RenderingConcept renderingConcept) {
		// TODO Auto-generated method stub
		
	}
}
