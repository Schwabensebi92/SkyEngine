package com.own.gameengine.test;


import com.own.gameengine.coreengine.math.CoordinateSystem;
import com.own.gameengine.coreengine.scenegraph.GameComponent;
import com.own.gameengine.inputengine.*;
import com.own.gameengine.renderingengine.concept.RenderingConcept;
import com.own.gameengine.renderingengine.graphics.Transform;


public class TestComponent extends GameComponent {
	
	public TestComponent() {
		super(true, true, true);
	}
	
	@Override
	public void input(final Mouse mouse, final Keyboard keyboard) {
		Transform t = getGameObject().getTransform();
		
		float angleDegree = 1.0f;
		
		if (keyboard.isKeyDown(KeyboardKeys.KEY_1)) {
			t.rotate(t.getRotation().getLocalXAxis(), (float) Math.toRadians(angleDegree));
		}
		if (keyboard.isKeyDown(KeyboardKeys.KEY_2)) {
			t.rotate(CoordinateSystem.CoordinateAxis.X_AXIS.getVector(), (float) Math.toRadians(angleDegree));
		}
		if (keyboard.isKeyDown(KeyboardKeys.KEY_3)) {
			t.rotate(t.getRotation().getLocalYAxis(), (float) Math.toRadians(angleDegree));
		}
		if (keyboard.isKeyDown(KeyboardKeys.KEY_4)) {
			t.rotate(CoordinateSystem.CoordinateAxis.Y_AXIS.getVector(), (float) Math.toRadians(angleDegree));
		}
		if (keyboard.isKeyDown(KeyboardKeys.KEY_5)) {
			t.rotate(t.getRotation().getLocalZAxis(), (float) Math.toRadians(angleDegree));
		}
		if (keyboard.isKeyDown(KeyboardKeys.KEY_6)) {
			t.rotate(CoordinateSystem.CoordinateAxis.Z_AXIS.getVector(), (float) Math.toRadians(angleDegree));
		}
		
		// if (keyboard.isKeyPressed(KeyboardKeys.KEY_7)) {
		// t.lookAt(CoordinateSystem.CoordinateAxis.X_AXIS.getVector(), null);
		// }
		// if (keyboard.isKeyPressed(KeyboardKeys.KEY_8)) {
		// t.lookAt(CoordinateSystem.CoordinateAxis.Y_AXIS.getVector(), null);
		// }
		// if (keyboard.isKeyPressed(KeyboardKeys.KEY_9)) {
		// t.lookAt(CoordinateSystem.CoordinateAxis.Z_AXIS.getVector(), null);
		// }
	}
	
	@Override
	public void update() {
	}
	
	@Override
	public void render(final RenderingConcept renderingConcept) {
	}
}
