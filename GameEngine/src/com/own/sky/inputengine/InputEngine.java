package com.own.sky.inputengine;


import com.own.sky.coreengine.scenegraph.*;


public class InputEngine {
	
	private InputDevice[] inputDevices;
	
	private Mouse		mouse;
	private Keyboard	keyboard;
	
	public InputEngine() {
		mouse = new Mouse();
		keyboard = new Keyboard();
		inputDevices = new InputDevice[0];
	}
	
	public void initialize(final long windowID) {
		mouse.initialize(windowID);
		keyboard.initialize(windowID);
		inputDevices = new InputDevice[] { mouse, keyboard };
	}
	
	public void cleanUp() {
		keyboard.cleanUp();
		mouse.cleanUp();
	}
	
	public void run(final SceneGraph sceneGraph) {
		// Update SceneGraph
		for (GameComponent inputEnabledGameComponent : sceneGraph.collectGameComponentsInputEnabled()) {
			inputEnabledGameComponent.input(mouse, keyboard);
		}
		
		// Store states of InputDevices for next cycle
		for (InputDevice inputDevice : inputDevices) {
			inputDevice.storeStatesForNextCycle();
		}
	}
}
