package com.own.sky.test;


import com.own.sky.coreengine.scenegraph.GameComponent;
import com.own.sky.debug.Debug;
import com.own.sky.inputengine.Keyboard;
import com.own.sky.inputengine.KeyboardKeys;
import com.own.sky.inputengine.Mouse;
import com.own.sky.math.CoordinateSystem;
import com.own.sky.renderingengine.concept.RenderingConcept;
import com.own.sky.renderingengine.graphics.object.Transform;


public class DebugTransformComponent extends GameComponent {
	
	private KeyboardKeys debugKey;
	
	public DebugTransformComponent(KeyboardKeys debugKey) {
		super(true, false, false);
		this.debugKey = debugKey;
	}
	
	@Override
	public void input(Mouse mouse, Keyboard keyboard) {
		Transform t = getGameObject().getTransform();
		
		if (keyboard.isKeyPressed(debugKey)) {
			Debug.out("################################");
			Debug.out("Current translation: " + t.getTranslation());
			Debug.out("--------------------------------");
			Debug.out("Current scale: " + t.getScale());
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
			Debug.out("################################");
		}
	}
	
	@Override
	public void update() {
	
	}
	
	@Override
	public void render(RenderingConcept renderingConcept) {
	
	}
	
}
