package com.own.gameengine.test;


import com.own.gameengine.coreengine.math.Vector3f;
import com.own.gameengine.coreengine.scenegraph.*;
import com.own.gameengine.game.Game;
import com.own.gameengine.inputengine.KeyboardKeys;
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
		int[] indicesAxis = {
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
		
		float cw = 0.05f; // half camera width
		float ch = 0.05f; // half camera height
		float cl = 0.15f; // camera length
		float clw = 0.04f; // half camera lense width
		float clh = 0.04f; // half camera lense height
		float cll = 0.02f; // camera lense length
		float chw = 0.01f; // half camera handle width
		float chh = 0.02f; // camera handle height
		float chl = 0.06f; // camera handle length
		
		//@formatter:off
		Vertex[] verticesCamera = new Vertex[] {
			// Camera
			new Vertex(new Vector3f(-cw,  ch,  -cl)), // 0
			new Vertex(new Vector3f(-cw,  ch, 0.0f)),
			new Vertex(new Vector3f( cw,  ch, 0.0f)),
			new Vertex(new Vector3f( cw,  ch,  -cl)),
			
			new Vertex(new Vector3f(-cw, -ch,  -cl)), // 4
			new Vertex(new Vector3f(-cw, -ch, 0.0f)),
			new Vertex(new Vector3f( cw, -ch, 0.0f)),
			new Vertex(new Vector3f( cw, -ch,  -cl)),
			
			// Camera lense
			new Vertex(new Vector3f(-clw, clh, 0.0f)), // 8
			new Vertex(new Vector3f(-clw, clh,  cll)),
			new Vertex(new Vector3f( clw, clh,  cll)),
			new Vertex(new Vector3f( clw, clh, 0.0f)),
			
			new Vertex(new Vector3f(-clw, -clh, 0.0f)), // 12
			new Vertex(new Vector3f(-clw, -clh,  cll)),
			new Vertex(new Vector3f( clw, -clh,  cll)),
			new Vertex(new Vector3f( clw, -clh, 0.0f)),
			
			// Camera handle
			new Vertex(new Vector3f(-clw, -clh, 0.0f)), // 16
			new Vertex(new Vector3f(-clw, -clh,  cll)),
			new Vertex(new Vector3f( clw, -clh,  cll)),
			new Vertex(new Vector3f( clw, -clh, 0.0f)),
			
			new Vertex(new Vector3f(-clw, -clh, 0.0f)), // 20
			new Vertex(new Vector3f(-clw, -clh,  cll)),
			new Vertex(new Vector3f( clw, -clh,  cll)),
			new Vertex(new Vector3f( clw, -clh, 0.0f)),
			
			new Vertex(new Vector3f(-clw, -clh, 0.0f)), // 24
			new Vertex(new Vector3f(-clw, -clh,  cll)),
			new Vertex(new Vector3f( clw, -clh,  cll)),
			new Vertex(new Vector3f( clw, -clh, 0.0f)),
			
			new Vertex(new Vector3f(-clw, -clh, 0.0f)), // 28
			new Vertex(new Vector3f(-clw, -clh,  cll)),
			new Vertex(new Vector3f( clw, -clh,  cll)),
			new Vertex(new Vector3f( clw, -clh, 0.0f)),
		};
		//@formatter:on
		
		//@formatter:off
		int[] indicesCamera = {
			0, 1, 2, // camera top
			0, 2, 3,
			7, 6, 5, // camera bottom
			7, 5, 4,
			4, 5, 1, // camera left
			4, 1, 0,
			3, 2, 6, // camera right
			3, 6, 7,
			4, 0, 3, // camera back
			4, 3, 7,
			1, 5, 6, // camera front
			1, 6, 2,
			8, 9, 10, // camera lense top
			8, 10, 11,
			15, 14, 13, // camera lense bottom
			15, 13, 12,
			12, 13, 9, // camera lense left
			12, 9, 8,
			11, 10, 14, // camera lense right
			11, 14, 15,
			9, 13, 14, // camera lense front
			9, 14, 10
		};
		//@formatter:on
		
		// Meshes
		Mesh meshXAxis = new Mesh(verticesXAxis, indicesAxis, true);
		Mesh meshYAxis = new Mesh(verticesYAxis, indicesAxis, true);
		Mesh meshZAxis = new Mesh(verticesZAxis, indicesAxis, true);
		Mesh meshCamera = new Mesh(verticesCamera, indicesCamera, true);
		
		// Materials
		Material materialReferenceXAxis = new Material(new Vector3f(0.3f, 0.0f, 0.0f), 1, 8);
		Material materialReferenceYAxis = new Material(new Vector3f(0.0f, 0.3f, 0.0f), 1, 8);
		Material materialReferenceZAxis = new Material(new Vector3f(0.0f, 0.0f, 0.3f), 1, 8);
		Material materialFreeXAxis = new Material(new Vector3f(1.0f, 0.0f, 0.0f), 1, 8);
		Material materialFreeYAxis = new Material(new Vector3f(0.0f, 1.0f, 0.0f), 1, 8);
		Material materialFreeZAxis = new Material(new Vector3f(0.0f, 0.0f, 1.0f), 1, 8);
		Material materialCamera = new Material(new Vector3f(0.8f, 0.8f, 0.8f), 1, 8);
		
		// Reference axis
		GameObject referenceAxis = new GameObject();
		referenceAxis.getTransform().translate(new Vector3f(0.25f, 0.0f, 0.25f));
		referenceAxis.addComponent(new MeshRenderComponent(meshXAxis, materialReferenceXAxis));
		referenceAxis.addComponent(new MeshRenderComponent(meshYAxis, materialReferenceYAxis));
		referenceAxis.addComponent(new MeshRenderComponent(meshZAxis, materialReferenceZAxis));
		
		// Free rotatable axis
		GameObject freeAxis = new GameObject();
		freeAxis.getTransform().translate(new Vector3f(-0.25f, 0.0f, -0.25f));
		freeAxis.addComponent(new MeshRenderComponent(meshXAxis, materialFreeXAxis));
		freeAxis.addComponent(new MeshRenderComponent(meshYAxis, materialFreeYAxis));
		freeAxis.addComponent(new MeshRenderComponent(meshZAxis, materialFreeZAxis));
		freeAxis.addComponent(new TestComponent());
		freeAxis.addComponent(new DebugTransformComponent(KeyboardKeys.KEY_F));
		
		// Free Camera
		// GameObject freeCameraObject = new GameObject();
		// Camera freeCamera = new Camera(new PerspectiveProjection(getWindowSettings().getAspectRatio()));
		// freeCameraObject.addComponent(freeCamera);
		// freeCameraObject.addComponent(
		// new KeyboardTranslationComponent(KeyboardKeys.KEY_W, KeyboardKeys.KEY_S, KeyboardKeys.KEY_D, KeyboardKeys.KEY_A, 1.0f));
		// freeCameraObject.addComponent(new KeyboardRotationComponent(KeyboardKeys.KEY_UP, KeyboardKeys.KEY_DOWN, KeyboardKeys.KEY_RIGHT,
		// KeyboardKeys.KEY_LEFT, (float) Math.toRadians(60.0f)));
		// freeCameraObject.addComponent(new MeshRenderComponent(meshCamera, materialCamera));
		// freeCameraObject.addComponent(new CameraActivationComponent(freeCamera, KeyboardKeys.KEY_SPACE, KeyboardKeys.KEY_SPACE));
		// freeCameraObject.addComponent(new DebugTransformComponent(KeyboardKeys.KEY_C));
		
		// Global Camera
		GameObject globalCameraObject = new GameObject();
		globalCameraObject.getTransform().translate(new Vector3f(0.0f, 0.25f, -2.5f));
		Camera globalCamera = new Camera(new PerspectiveProjection(getWindowSettings().getAspectRatio()));
		globalCameraObject.addComponent(globalCamera);
		globalCameraObject.addComponent(new DebugTransformComponent(KeyboardKeys.KEY_G));
		globalCameraObject.addComponent(
				new KeyboardTranslationComponent(KeyboardKeys.KEY_W, KeyboardKeys.KEY_S, KeyboardKeys.KEY_D, KeyboardKeys.KEY_A, 1.0f));
		globalCameraObject.addComponent(new KeyboardRotationComponent(KeyboardKeys.KEY_UP, KeyboardKeys.KEY_DOWN, KeyboardKeys.KEY_RIGHT,
				KeyboardKeys.KEY_LEFT, (float) Math.toRadians(60.0f)));
		globalCamera.activate();
		
		// Add objects to scene graph
		addObject(referenceAxis);
		addObject(freeAxis);
		// addObject(freeCameraObject);
		addObject(globalCameraObject);
	}
	
	@Override
	public void cleanUp() {
	
	}
}
