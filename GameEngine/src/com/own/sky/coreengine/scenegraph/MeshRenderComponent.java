package com.own.sky.coreengine.scenegraph;


import com.own.sky.coreengine.*;
import com.own.sky.inputengine.*;
import com.own.sky.renderingengine.cameraengine.CameraEngine;
import com.own.sky.renderingengine.concept.RenderingConcept;
import com.own.sky.renderingengine.graphics.object.*;


public class MeshRenderComponent extends GameComponent {
	
	private Mesh		mesh;
	private Material	material;
	
	public MeshRenderComponent(final Mesh mesh, final Material material) {
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
		renderingConcept.renderMesh(getGameObject().getTransform(),
				((CameraEngine) CoreObjectRegister.get(CoreObject.CAMERA_ENGINE)).getActiveCamera(), material, mesh);
	}
}