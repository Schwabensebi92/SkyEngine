package com.own.sky.renderingengine.concept.shader.singlepass;


import com.own.sky.renderingengine.concept.SinglePassShader;
import com.own.sky.renderingengine.concept.shader.VertexShader;
import com.own.sky.renderingengine.lightengine.lightmodel.NoLightShader;


public class SinglePassNoVertexShader extends VertexShader implements SinglePassShader, NoLightShader {
	
	public SinglePassNoVertexShader() {
		super("singlepass_no/singlepass_noVertex.vs");
	}
}
