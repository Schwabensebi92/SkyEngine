package com.own.sky.coreengine.scenegraph;


import com.own.sky.coreengine.*;
import com.own.sky.inputengine.*;
import com.own.sky.math.Quaternion;
import com.own.sky.math.CoordinateSystem.CoordinateAxis;
import com.own.sky.renderingengine.concept.RenderingConcept;
import com.own.sky.renderingengine.graphics.object.Transform;


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
		
		t.rotate(new Quaternion(t.getRotation().getLocalXAxis(), upRotationAmount * timeDelta));
		t.rotate(new Quaternion(CoordinateAxis.Y_AXIS.getVector(), rightRotationAmount * timeDelta));
		
		upRotationAmount = 0.0f;
		rightRotationAmount = 0.0f;
	}
	
	@Override
	public void render(final RenderingConcept renderingConcept) {
	
	}
}
