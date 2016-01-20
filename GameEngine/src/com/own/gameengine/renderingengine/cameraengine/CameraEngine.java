package com.own.gameengine.renderingengine.cameraengine;


import java.util.Stack;


public class CameraEngine {
	
	private Stack<Camera> cameraStack;
	
	public CameraEngine() {
		// TODO Do some meaningful stuff
	}
	
	public void initialize() {
		cameraStack = new Stack();
	}
	
	public void cleanUp() {
	
	}
	
	public Camera getActiveCamera() {
		return cameraStack.peek();
	}
	
	public void activateCamera(final Camera camera) {
		if (cameraStack.empty() || !cameraStack.peek().equals(camera)) {
			cameraStack.push(camera);
		}
	}
	
	public void deactivateCamera(final Camera camera) {
		if (cameraStack.peek().equals(camera)) {
			cameraStack.pop();
		}
	}
}
