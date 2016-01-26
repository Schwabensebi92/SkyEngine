package com.own.sky.test;


import com.own.sky.coreengine.*;
import com.own.sky.coreengine.scenegraph.GameComponent;
import com.own.sky.inputengine.*;
import com.own.sky.math.Vector3f;
import com.own.sky.renderingengine.cameraengine.CameraEngine;
import com.own.sky.renderingengine.concept.RenderingConcept;
import com.own.sky.renderingengine.graphics.*;
import com.own.sky.renderingengine.graphics.object.*;


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