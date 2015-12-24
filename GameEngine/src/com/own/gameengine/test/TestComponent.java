package com.own.gameengine.test;


import com.own.gameengine.coreengine.Debug;
import com.own.gameengine.coreengine.math.*;
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
		
		// t.rotate(new Vector3f(CoordinateSystem.Y_AXIS),
		// (float) ((CoreTiming) CoreObjectRegister.get(CoreObject.CORE_TIMING)).getDelta());
		// t.rotate(getGameObject().getTransform().getRotation().getUpVector(),
		// (float) ((CoreTiming) CoreObjectRegister.get(CoreObject.CORE_TIMING)).getDelta());
		
		if (keyboard.isKeyPressed(KeyboardKeys.KEY_1)) {
			t.rotate(t.getRotation().getRightVector(), (float) Math.toRadians(30));
		}
		if (keyboard.isKeyPressed(KeyboardKeys.KEY_2)) {
			t.rotate(new Vector3f(CoordinateSystem.X_AXIS), (float) Math.toRadians(30));
		}
		if (keyboard.isKeyPressed(KeyboardKeys.KEY_3)) {
			t.rotate(t.getRotation().getUpVector(), (float) Math.toRadians(30));
		}
		if (keyboard.isKeyPressed(KeyboardKeys.KEY_4)) {
			t.rotate(new Vector3f(CoordinateSystem.Y_AXIS), (float) Math.toRadians(30));
		}
		if (keyboard.isKeyPressed(KeyboardKeys.KEY_5)) {
			t.rotate(t.getRotation().getForwardVector(), (float) Math.toRadians(30));
		}
		if (keyboard.isKeyPressed(KeyboardKeys.KEY_6)) {
			t.rotate(new Vector3f(CoordinateSystem.Z_AXIS), (float) Math.toRadians(30));
		}
		
		if (keyboard.isKeyPressed(KeyboardKeys.KEY_ENTER)) {
			Debug.out("--------------------------------");
			Debug.out("--------------------------------");
			Debug.out("Current rotation: " + t.getRotation());
			Debug.out("--------------------------------");
			Debug.out("global xAxis: " + CoordinateSystem.X_AXIS);
			Debug.out("local xAxis: " + t.getRotation().getRightVector());
			Debug.out("--------------------------------");
			Debug.out("global yAxis: " + CoordinateSystem.Y_AXIS);
			Debug.out("local yAxis: " + t.getRotation().getUpVector());
			Debug.out("--------------------------------");
			Debug.out("global zAxis: " + CoordinateSystem.Z_AXIS);
			Debug.out("local zAxis: " + t.getRotation().getForwardVector());
			Debug.out("--------------------------------");
			Debug.out("--------------------------------");
		}
	}
	
	@Override
	public void update() {
	}
	
	@Override
	public void render(final RenderingConcept renderingConcept) {
	}
}
