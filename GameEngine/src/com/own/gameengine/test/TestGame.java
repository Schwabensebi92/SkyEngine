package com.own.gameengine.test;


import com.own.gameengine.coreengine.math.Vector3f;
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
		Vertex[] verticesXAxis = new Vertex[] {
			new Vertex(new Vector3f(  -l,    t,    t)),
			new Vertex(new Vector3f(l-hl,    t,    t)),
			new Vertex(new Vector3f(l-hl,    t,   -t)),
			new Vertex(new Vector3f(  -l,    t,   -t)),
			
			new Vertex(new Vector3f(  -l,   -t,    t)),
			new Vertex(new Vector3f(l-hl,   -t,    t)),
			new Vertex(new Vector3f(l-hl,   -t,   -t)),
			new Vertex(new Vector3f(  -l,   -t,   -t)),
			
			new Vertex(new Vector3f(l-hl,  -ht,   ht)),
			new Vertex(new Vector3f(l-hl,   ht,   ht)),
			new Vertex(new Vector3f(l-hl,   ht,  -ht)),
			new Vertex(new Vector3f(l-hl,  -ht,  -ht)),
			
			new Vertex(new Vector3f(   l, 0.0f, 0.0f))
		};
		//@formatter:on
		
		//@formatter:off
		Vertex[] verticesYAxis = new Vertex[] {
			new Vertex(new Vector3f(-t,  -l, -t)),
			new Vertex(new Vector3f(-t,  l-hl, -t)),
			new Vertex(new Vector3f( t,  l-hl, -t)),
			new Vertex(new Vector3f( t,  -l, -t)),
			
			new Vertex(new Vector3f(-t, -l, t)),
			new Vertex(new Vector3f(-t, l-hl, t)),
			new Vertex(new Vector3f( t, l-hl, t)),
			new Vertex(new Vector3f( t, -l, t)),
			
			new Vertex(new Vector3f(-ht, l-hl, ht)),
			new Vertex(new Vector3f(-ht,  l-hl, -ht)),
			new Vertex(new Vector3f( ht,  l-hl, -ht)),
			new Vertex(new Vector3f( ht, l-hl, ht)),
			
			new Vertex(new Vector3f(0.0f, l, 0.0f))
		};
		//@formatter:on
		
		//@formatter:off
		Vertex[] verticesZAxis = new Vertex[] {
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
		
		Mesh meshXAxis = new Mesh(verticesXAxis, indices, true);
		Mesh meshYAxis = new Mesh(verticesYAxis, indices, true);
		Mesh meshZAxis = new Mesh(verticesZAxis, indices, true);
		Material materialXAxis = new Material(new Vector3f(1.0f, 0.0f, 0.0f), 1, 8);
		Material materialYAxis = new Material(new Vector3f(0.0f, 1.0f, 0.0f), 1, 8);
		Material materialZAxis = new Material(new Vector3f(0.0f, 0.0f, 1.0f), 1, 8);
		Material materialFreeVector = new Material(new Vector3f(1.0f, 1.0f, 0.0f), 1, 8);
		
		GameObject referenceAxis = new GameObject();
		referenceAxis.addComponent(new MeshRenderer(meshXAxis, materialXAxis));
		referenceAxis.addComponent(new MeshRenderer(meshYAxis, materialYAxis));
		referenceAxis.addComponent(new MeshRenderer(meshZAxis, materialZAxis));
		
		GameObject freeAxis = new GameObject();
		freeAxis.getTransform().setScale(new Vector3f(0.5f, 0.5f, 0.5f));
		freeAxis.addComponent(new MeshRenderer(meshXAxis, materialXAxis));
		freeAxis.addComponent(new MeshRenderer(meshYAxis, materialYAxis));
		freeAxis.addComponent(new MeshRenderer(meshZAxis, materialZAxis));
		freeAxis.addComponent(new TestComponent());
		
		GameObject freeVector = new GameObject();
		freeVector.getTransform().scale(new Vector3f(0.2f, 0.2f, 1.5f));
		freeVector.addComponent(new MeshRenderer(meshZAxis, materialFreeVector));
		
		addObject(referenceAxis);
		addObject(freeAxis);
		addObject(freeVector);
		
		GameObject player = new GameObject();
		player.getTransform().translate(new Vector3f(0.0f, 0.0f, -0.5f));
		Camera camera = new Camera(new PerspectiveProjection(getWindowSettings().getAspectRatio()));
		player.addComponent(camera);
		camera.activate();
		addObject(player);
	}
	
	@Override
	public void cleanUp() {
	
	}
}
