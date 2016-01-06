package com.own.gameengine.test;


import com.own.gameengine.coreengine.*;
import com.own.gameengine.coreengine.math.Vector3f;
import com.own.gameengine.coreengine.scenegraph.GameComponent;
import com.own.gameengine.inputengine.*;
import com.own.gameengine.renderingengine.concept.RenderingConcept;
import com.own.gameengine.renderingengine.graphics.*;
import com.own.gameengine.renderingengine.graphics.object.*;


public class TestCameraRenderer extends GameComponent {
	
	private Mesh		mesh;
	private Material	material;
	
	public TestCameraRenderer(final Mesh mesh, final Material material) {
		super(false, false, true);
		this.mesh = mesh;
		this.material = material;
	}
	
	@Override
	public void input(final Mouse mouse, final Keyboard keyboard) {
	}
	
	@Override
	public void update() {
	}
	
	@Override
	public void render(final RenderingConcept renderingConcept) {
		Transform cameraSystemTransform = new Transform(getGameObject().getTransform());
		
		Vector3f cameraSystemTranslation = cameraSystemTransform.getTranslation();
		Vector3f cameraForward = cameraSystemTransform.getRotation().getLocalZAxis();
		cameraSystemTranslation.add(cameraForward.mul(1.0f));
		cameraSystemTransform.getRotation().conjugate();
		
		renderingConcept.renderMesh(cameraSystemTransform,
				((CameraEngine) CoreObjectRegister.get(CoreObject.CAMERA_ENGINE)).getActiveCamera(), material, mesh);
	}
}