package com.own.gameengine.test;


import com.own.gameengine.coreengine.math.Vector3f;
import com.own.gameengine.coreengine.scenegraph.*;
import com.own.gameengine.game.Game;
import com.own.gameengine.inputengine.KeyboardKeys;
import com.own.gameengine.renderingengine.graphics.*;
import com.own.gameengine.renderingengine.graphics.object.*;
import com.own.gameengine.renderingengine.graphics.projection.PerspectiveProjection;
import com.own.gameengine.temp.CubeMesh;


public class TestGame extends Game {
	
	public TestGame() {
		super("3D Game Engine", new WindowSettings("3D Game Engine", Resolution.RES_800x600, false, FrameRate.FPS_60, false));
	}
	
	@Override
	public void initialize() {
		// Meshes
		Mesh meshCube = new CubeMesh();
		
		// Materials
		Material materialCube = new Material(new Vector3f(0.7f, 0.7f, 0.7f), 1, 8);
		
		// Cube
		GameObject cube = new GameObject();
		cube.addComponent(new MeshRenderComponent(meshCube, materialCube));
		cube.addComponent(new DebugTransformComponent(KeyboardKeys.KEY_C));
		
		// Global Camera
		GameObject globalCameraObject = new GameObject();
		globalCameraObject.getTransform().translate(new Vector3f(0.0f, 0.0f, -1.5f));
		Camera globalCamera = new Camera(new PerspectiveProjection(getWindowSettings().getAspectRatio()));
		globalCameraObject.addComponent(globalCamera);
		globalCameraObject.addComponent(
				new KeyboardTranslationComponent(KeyboardKeys.KEY_W, KeyboardKeys.KEY_S, KeyboardKeys.KEY_D, KeyboardKeys.KEY_A, 1.0f));
		globalCameraObject.addComponent(new KeyboardRotationComponent(KeyboardKeys.KEY_UP, KeyboardKeys.KEY_DOWN, KeyboardKeys.KEY_RIGHT,
				KeyboardKeys.KEY_LEFT, (float) Math.toRadians(60.0f)));
		globalCameraObject.addComponent(new DebugTransformComponent(KeyboardKeys.KEY_G));
		globalCamera.activate();
		
		// Add objects to scene graph
		addObject(cube);
		addObject(globalCameraObject);
	}
	
	@Override
	public void cleanUp() {
	
	}
}
