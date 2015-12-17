package com.own.gameengine.test;


import com.own.gameengine.coreengine.math.*;
import com.own.gameengine.coreengine.scenegraph.*;
import com.own.gameengine.game.Game;
import com.own.gameengine.renderingengine.graphics.*;
import com.own.gameengine.renderingengine.graphics.object.*;
import com.own.gameengine.renderingengine.graphics.projection.PerspectiveProjection;


public class TestGame extends Game {
	
	public TestGame() {
		super("3D Game Engine", new WindowSettings("3D Game Engine", Resolution.RES_480x320, false, FrameRate.FPS_60, false));
	}
	
	@Override
	public void initialize() {
		float fieldDepth = 10.0f;
		float fieldWidth = 10.0f;
		
		Vertex[] vertices = new Vertex[] { new Vertex(new Vector3f(-fieldWidth, 0.0f, -fieldDepth), new Vector2f(0.0f, 0.0f)),
				new Vertex(new Vector3f(-fieldWidth, 0.0f, fieldDepth * 3), new Vector2f(0.0f, 1.0f)),
				new Vertex(new Vector3f(fieldWidth * 3, 0.0f, -fieldDepth), new Vector2f(1.0f, 0.0f)),
				new Vertex(new Vector3f(fieldWidth * 3, 0.0f, fieldDepth * 3), new Vector2f(1.0f, 1.0f)) };
				
		int indices[] = { 0, 1, 2, 2, 1, 3 };
		
		Mesh mesh = new Mesh(vertices, indices, true);
		Material material = new Material(new Vector3f(0.5f, 0.5f, 0.5f), 1, 8);
		
		GameObject planeObject = new GameObject();
		planeObject.addComponent(new MeshRenderer(mesh, material));
		planeObject.getTransform().setTranslation(new Vector3f(0, -1, 5));
		
		addObject(planeObject);
		
		GameObject player = new GameObject();
		Camera camera = new Camera(new PerspectiveProjection(getWindowSettings().getAspectRatio()));
		player.addComponent(camera);
		camera.activate();
		addObject(player);
	}
	
	@Override
	public void cleanUp() {
	
	}
}
