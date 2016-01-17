package com.own.gameengine.test;


import com.own.gameengine.coreengine.math.CoordinateSystem;
import com.own.gameengine.coreengine.scenegraph.GameComponent;
import com.own.gameengine.debug.Debug;
import com.own.gameengine.inputengine.Keyboard;
import com.own.gameengine.inputengine.KeyboardKeys;
import com.own.gameengine.inputengine.Mouse;
import com.own.gameengine.renderingengine.concept.RenderingConcept;
import com.own.gameengine.renderingengine.graphics.Transform;


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
