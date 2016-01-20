package com.own.gameengine.test;


import com.own.gameengine.coreengine.scenegraph.GameComponent;
import com.own.gameengine.inputengine.*;
import com.own.gameengine.renderingengine.cameraengine.Camera;
import com.own.gameengine.renderingengine.concept.RenderingConcept;


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
