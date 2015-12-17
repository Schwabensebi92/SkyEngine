package com.own.gameengine.test;


import com.own.gameengine.coreengine.math.Vector3f;
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
		//@formatter:off
		Vertex[] vertices = new Vertex[] {
				new Vertex(new Vector3f(-0.5f, -0.5f, 3.0f)),
				new Vertex(new Vector3f(0.0f, 0.5f, 3.0f)),
				new Vertex(new Vector3f(0.5f, -0.5f, 3.0f))
		};
		//@formatter:on
		
		int[] indices = { 0, 1, 2 };
		
		Mesh mesh = new Mesh(vertices, indices, true);
		Material material = new Material(new Vector3f(1.0f, 0.5f, 0.5f), 1, 8);
		
		GameObject meshObject = new GameObject();
		meshObject.addComponent(new MeshRenderer(mesh, material));
		
		addObject(meshObject);
		
		GameObject player = new GameObject();
		// player.getTransform().setRotation(new Quaternion(CoordinateSystem.Y_AXIS, (float) Math.PI / 2.0f));
		Camera camera = new Camera(new PerspectiveProjection(getWindowSettings().getAspectRatio()));
		player.addComponent(camera);
		camera.activate();
		addObject(player);
	}
	
	@Override
	public void cleanUp() {
	
	}
}
