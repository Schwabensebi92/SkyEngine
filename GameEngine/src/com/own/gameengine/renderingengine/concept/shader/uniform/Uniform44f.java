package com.own.gameengine.renderingengine.concept.shader.uniform;


import static org.lwjgl.opengl.GL20.glUniformMatrix4fv;

import com.own.gameengine.coreengine.math.matrix.Matrix4f;
import com.own.gameengine.renderingengine.RenderingEngineUtil;


public class Uniform44f extends Uniform<Matrix4f> {
	
	public Uniform44f(String identifier) {
		super(UniformType.Matrix4f, identifier);
	}
	
	@Override
	public void send() {
		glUniformMatrix4fv(location, true, RenderingEngineUtil.createFlippedBuffer(value));
	}
}