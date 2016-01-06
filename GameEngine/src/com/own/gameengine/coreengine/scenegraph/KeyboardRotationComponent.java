package com.own.gameengine.coreengine.scenegraph;


import com.own.gameengine.coreengine.*;
import com.own.gameengine.coreengine.math.CoordinateSystem.CoordinateAxis;
import com.own.gameengine.inputengine.*;
import com.own.gameengine.renderingengine.concept.RenderingConcept;
import com.own.gameengine.renderingengine.graphics.Transform;


public class KeyboardRotationComponent extends GameComponent {
	
	private KeyboardKeys	upKey;
	private KeyboardKeys	downKey;
	private KeyboardKeys	rightKey;
	private KeyboardKeys	leftKey;
	private float			rotationAmount;
	
	private float	upRotationAmount;
	private float	rightRotationAmount;
	
	public KeyboardRotationComponent(final KeyboardKeys upKey, final KeyboardKeys downKey, final KeyboardKeys rightKey,
			final KeyboardKeys leftKey, final float rotationAmount) {
		super(true, true, false);
		this.upKey = upKey;
		this.downKey = downKey;
		this.rightKey = rightKey;
		this.leftKey = leftKey;
		this.rotationAmount = rotationAmount;
	}
	
	@Override
	public void input(final Mouse mouse, final Keyboard keyboard) {
		if (keyboard.isKeyDown(upKey)) {
			upRotationAmount -= rotationAmount;
		}
		if (keyboard.isKeyDown(downKey)) {
			upRotationAmount += rotationAmount;
		}
		if (keyboard.isKeyDown(rightKey)) {
			rightRotationAmount += rotationAmount;
		}
		if (keyboard.isKeyDown(leftKey)) {
			rightRotationAmount -= rotationAmount;
		}
	}
	
	@Override
	public void update() {
		Transform t = getGameObject().getTransform();
		float timeDelta = (float) ((CoreTiming) CoreObjectRegister.get(CoreObject.CORE_TIMING)).getDelta();
		
		t.rotate(t.getRotation().getLocalXAxis(), upRotationAmount * timeDelta);
		t.rotate(CoordinateAxis.Y_AXIS.getVector(), rightRotationAmount * timeDelta);
		
		upRotationAmount = 0.0f;
		rightRotationAmount = 0.0f;
	}
	
	@Override
	public void render(final RenderingConcept renderingConcept) {
	
	}
}
