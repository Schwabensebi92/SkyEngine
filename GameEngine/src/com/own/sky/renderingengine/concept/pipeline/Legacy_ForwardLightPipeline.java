package com.own.sky.renderingengine.concept.pipeline;


import com.own.sky.renderingengine.lightengine.light.Light;


public abstract class Legacy_ForwardLightPipeline<LightType extends Light> extends Legacy_RenderingPipeline {
	
	private LightType light;
	
	public Legacy_ForwardLightPipeline() {
		super();
	}
	
	public void setCurrentLight(final LightType light) {
		this.light = light;
	}
	
	public LightType getCurrentLight() {
		return light;
	}
}