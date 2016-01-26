package com.own.sky.test;


import com.own.sky.coreengine.scenegraph.GameComponent;
import com.own.sky.inputengine.*;
import com.own.sky.math.Quaternion;
import com.own.sky.renderingengine.concept.RenderingConcept;
import com.own.sky.renderingengine.graphics.object.Transform;


public class TestComponent extends GameComponent {
	
	public TestComponent() {
		super(true, true, true);
	}
	
	@Override
	public void input(final Mouse mouse, final Keyboard keyboard) {
		Transform t = getGameObject().getTransform();
		
		float angleDegree = 1.0f;
		
		if (keyboard.isKeyDown(KeyboardKeys.KEY_1)) {
			t.rotate(new Quaternion(t.getRotation().getLocalXAxis(), (float) Math.toRadians(angleDegree)));
		}
		if (keyboard.isKeyDown(KeyboardKeys.KEY_2)) {
			t.rotate(new Quaternion(t.getRotation().getLocalYAxis(), (float) Math.toRadians(angleDegree)));
		}
		if (keyboard.isKeyDown(KeyboardKeys.KEY_3)) {
			t.rotate(new Quaternion(t.getRotation().getLocalZAxis(), (float) Math.toRadians(angleDegree)));
		}
	}
	
	@Override
	public void update() {
	}
	
	@Override
	public void render(final RenderingConcept renderingConcept) {
	}
}
