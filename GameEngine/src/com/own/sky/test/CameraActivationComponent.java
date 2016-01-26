package com.own.sky.test;


import com.own.sky.coreengine.scenegraph.GameComponent;
import com.own.sky.inputengine.*;
import com.own.sky.renderingengine.cameraengine.Camera;
import com.own.sky.renderingengine.concept.RenderingConcept;


public class CameraActivationComponent extends GameComponent {
	
	private Camera			camera;
	private KeyboardKeys	cameraActivationKey;
	private KeyboardKeys	cameraDeactivationKey;
	
	public CameraActivationComponent(final Camera camera, final KeyboardKeys cameraActivationKey,
			final KeyboardKeys cameraDeactivationKey) {
		super(true, false, false);
		this.camera = camera;
		this.cameraActivationKey = cameraActivationKey;
		this.cameraDeactivationKey = cameraDeactivationKey;
	}
	
	@Override
	public void input(final Mouse mouse, final Keyboard keyboard) {
		if (!camera.isActive()) {
			if (keyboard.isKeyPressed(cameraActivationKey)) {
				camera.activate();
			}
		} else {
			if (keyboard.isKeyPressed(cameraDeactivationKey)) {
				camera.deactivate();
			}
		}
	}
	
	@Override
	public void update() {
	
	}
	
	@Override
	public void render(final RenderingConcept renderingConcept) {
	
	}
}
