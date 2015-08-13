package com.own.gameengine.renderingengine.concept.pipeline;

import com.own.gameengine.renderingengine.graphics.light.Light;

public abstract class ForwardLightPipeline<LightType extends Light> extends RenderingPipeline {

	private LightType	light;

	public ForwardLightPipeline() {
		super();
	}

	public void setCurrentLight(LightType light) {
		this.light = light;
	}

	public LightType getCurrentLight() {
		return light;
	}
}
