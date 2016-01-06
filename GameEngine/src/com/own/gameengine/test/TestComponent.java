package com.own.gameengine.test;


import com.own.gameengine.coreengine.math.CoordinateSystem;
import com.own.gameengine.coreengine.scenegraph.GameComponent;
import com.own.gameengine.error.Debug;
import com.own.gameengine.inputengine.*;
import com.own.gameengine.renderingengine.concept.RenderingConcept;
import com.own.gameengine.renderingengine.graphics.Transform;


public class TestComponent extends GameComponent {
	
	private int counter;
	
	public TestComponent() {
		super(true, true, true);
		counter = 0;
	}
	
	@Override
	public void input(final Mouse mouse, final Keyboard keyboard) {
		Transform t = getGameObject().getTransform();
		
		float angleDegree = 90.0f;
		
		if (keyboard.isKeyPressed(KeyboardKeys.KEY_1)) {
			t.rotate(t.getRotation().getLocalXAxis(), (float) Math.toRadians(angleDegree));
		}
		if (keyboard.isKeyPressed(KeyboardKeys.KEY_2)) {
			t.rotate(CoordinateSystem.CoordinateAxis.X_AXIS.getVector(), (float) Math.toRadians(angleDegree));
		}
		if (keyboard.isKeyPressed(KeyboardKeys.KEY_3)) {
			t.rotate(t.getRotation().getLocalYAxis(), (float) Math.toRadians(angleDegree));
		}
		if (keyboard.isKeyPressed(KeyboardKeys.KEY_4)) {
			t.rotate(CoordinateSystem.CoordinateAxis.Y_AXIS.getVector(), (float) Math.toRadians(angleDegree));
		}
		if (keyboard.isKeyPressed(KeyboardKeys.KEY_5)) {
			t.rotate(t.getRotation().getLocalZAxis(), (float) Math.toRadians(angleDegree));
		}
		if (keyboard.isKeyPressed(KeyboardKeys.KEY_6)) {
			t.rotate(CoordinateSystem.CoordinateAxis.Z_AXIS.getVector(), (float) Math.toRadians(angleDegree));
		}
		
		if (keyboard.isKeyPressed(KeyboardKeys.KEY_ENTER)) {
			Debug.out("--------------------------------");
			Debug.out("--------------------------------");
			Debug.out("Current rotation: " + t.getRotation());
			Debug.out("--------------------------------");
			Debug.out("global xAxis: " + CoordinateSystem.CoordinateAxis.X_AXIS.getVector());
			Debug.out("local xAxis: " + t.getRotation().getLocalXAxis());
			Debug.out("--------------------------------");
			Debug.out("global yAxis: " + CoordinateSystem.CoordinateAxis.Y_AXIS.getVector());
			Debug.out("local yAxis: " + t.getRotation().getLocalYAxis());
			Debug.out("--------------------------------");
			Debug.out("global zAxis: " + CoordinateSystem.CoordinateAxis.Z_AXIS.getVector());
			Debug.out("local zAxis: " + t.getRotation().getLocalZAxis());
			Debug.out("--------------------------------");
			Debug.out("--------------------------------");
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
