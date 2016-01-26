package com.own.sky.renderingengine.concept.shader.uniform;


import static org.lwjgl.opengl.GL20.glUniformMatrix4fv;

import com.own.sky.math.matrix.Matrix4f;
import com.own.sky.renderingengine.RenderingEngineUtil;


public class Uniform44f extends Uniform<Matrix4f> {
	
	public Uniform44f(String identifier) {
		super(UniformType.Matrix4f, identifier);
	}
	
	@Override
	public void send() {
		glUniformMatrix4fv(location, true, RenderingEngineUtil.createFlippedBuffer(value));
	}
}