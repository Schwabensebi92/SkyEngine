package com.own.gameengine.test;


import com.own.gameengine.coreengine.math.*;
import com.own.gameengine.coreengine.scenegraph.*;
import com.own.gameengine.game.Game;
import com.own.gameengine.renderingengine.graphics.*;
import com.own.gameengine.renderingengine.graphics.object.*;
import com.own.gameengine.renderingengine.graphics.projection.PerspectiveProjection;


public class TestGame extends Game {
	
	public TestGame() {
		super("3D Game Engine", new WindowSettings("3D Game Engine", Resolution.RES_800x600, false, FrameRate.FPS_60, false));
	}
	
	@Override
	public void initialize() {
		float t = 0.005f; // arrow thickness
		float l = 1.0f; // arrow length
		float ht = 0.02f; // arrow head thickness
		float hl = 0.04f; // arrow head length
		//@formatter:off
		Vertex[] vertices = new Vertex[] {
			new Vertex(new Vector3f(-t,  t, -l)),
			new Vertex(new Vector3f(-t,  t, l-hl)),
			new Vertex(new Vector3f( t,  t, l-hl)),
			new Vertex(new Vector3f( t,  t, -l)),

			new Vertex(new Vector3f(-t, -t, -l)),
			new Vertex(new Vector3f(-t, -t, l-hl)),
			new Vertex(new Vector3f( t, -t, l-hl)),
			new Vertex(new Vector3f( t, -t, -l)),
			
			new Vertex(new Vector3f(-ht, -ht, l-hl)),
			new Vertex(new Vector3f(-ht,  ht, l-hl)),
			new Vertex(new Vector3f( ht,  ht, l-hl)),
			new Vertex(new Vector3f( ht, -ht, l-hl)),
			
			new Vertex(new Vector3f(0.0f, 0.0f, l))
		};
		//@formatter:on
		
		//@formatter:off
		int[] indices = {
			0, 1, 2, // arrow top
			0, 2, 3,
			7, 6, 5, // arrow bottom
			7, 5, 4,
			4, 5, 1, // arrow left
			4, 1, 0,
			3, 2, 6, // arrow right
			3, 6, 7,
			4, 0, 3, // arrow back
			4, 3, 7,
			1, 5, 6, // arrow front
			1, 6, 2,
			8, 9, 10, // arrow head back
			8, 10, 11,
			9, 12, 10, // arrow head top
			11, 12, 8, // arrow head bottom
			8, 12, 9, // arrow head left
			10, 12, 11// arrow head right
		};
		//@formatter:on
		
		Mesh mesh = new Mesh(vertices, indices, true);
		Material materialXAxis = new Material(new Vector3f(1.0f, 0.0f, 0.0f), 1, 8);
		Material materialYAxis = new Material(new Vector3f(0.0f, 1.0f, 0.0f), 1, 8);
		Material materialZAxis = new Material(new Vector3f(0.0f, 0.0f, 1.0f), 1, 8);
		Material materialFreeVector = new Material(new Vector3f(1.0f, 1.0f, 1.0f), 1, 8);
		
		GameObject xAxis = new GameObject();
		xAxis.getTransform().rotate(new Vector3f(CoordinateSystem.Y_AXIS), (float) Math.toRadians(90));
		xAxis.addComponent(new MeshRenderer(mesh, materialXAxis));
		
		GameObject yAxis = new GameObject();
		yAxis.getTransform().rotate(new Vector3f(CoordinateSystem.X_AXIS), (float) Math.toRadians(270));
		yAxis.addComponent(new MeshRenderer(mesh, materialYAxis));
		
		GameObject zAxis = new GameObject();
		zAxis.addComponent(new MeshRenderer(mesh, materialZAxis));
		
		GameObject freeVector = new GameObject();
		freeVector.addComponent(new MeshRenderer(mesh, materialFreeVector));
		freeVector.addComponent(new TestComponent());
		
		addObject(xAxis);
		addObject(yAxis);
		addObject(zAxis);
		addObject(freeVector);
		
		GameObject player = new GameObject();
		player.getTransform().translate(new Vector3f(0.0f, 0.0f, -0.5f));
		Camera camera = new Camera(new PerspectiveProjection(getWindowSettings().getAspectRatio()));
		player.addComponent(camera);
		camera.activate();
		addObject(player);
		
		Quaternion Q = new Quaternion(new Vector3f(1, 1, 1), (float) Math.toRadians(360.0f));
		Vector3f P = new Vector3f(1.0f, 0.0f, 0.0f);
		P.rotate(new Quaternion(Q));
	}
	
	@Override
	public void cleanUp() {
	
	}
}
