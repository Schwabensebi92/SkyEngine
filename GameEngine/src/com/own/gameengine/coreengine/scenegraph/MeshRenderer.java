package com.own.gameengine.coreengine.scenegraph;

import com.own.gameengine.coreengine.*;
import com.own.gameengine.renderingengine.RenderingEngine;
import com.own.gameengine.renderingengine.graphics.model.sample.ForwardShaderSample;
import com.own.gameengine.renderingengine.graphics.object.*;

public class MeshRenderer extends GameComponent {

	private Mesh		mesh;
	private Material	material;

	public MeshRenderer(Mesh mesh, Material material) {
		this.mesh = mesh;
		this.material = material;
	}

	@Override
	public void input() {
	}

	@Override
	public void update() {
	}

	@Override
	public void render() {
		ForwardShaderSample.getInstance().drawMesh(gameObject.getTransform(),
				((RenderingEngine) CoreRegister.get(CoreObject.RENDERING_ENGINE)).getMainCamera(),
				material, mesh);
	}
}