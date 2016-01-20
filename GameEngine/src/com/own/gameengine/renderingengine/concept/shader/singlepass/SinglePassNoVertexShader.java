package com.own.gameengine.renderingengine.concept.shader.singlepass;


import com.own.gameengine.renderingengine.concept.SinglePassShader;
import com.own.gameengine.renderingengine.concept.shader.VertexShader;
import com.own.gameengine.renderingengine.lightengine.lightmodel.NoLightShader;


public class SinglePassNoVertexShader extends VertexShader implements SinglePassShader, NoLightShader {
	
	public SinglePassNoVertexShader() {
		super("singlepass_no/singlepass_noVertex.vs");
	}
}
