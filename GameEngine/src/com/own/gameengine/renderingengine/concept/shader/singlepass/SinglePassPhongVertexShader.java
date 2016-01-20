package com.own.gameengine.renderingengine.concept.shader.singlepass;


import com.own.gameengine.renderingengine.concept.SinglePassShader;
import com.own.gameengine.renderingengine.concept.shader.VertexShader;
import com.own.gameengine.renderingengine.lightengine.lightmodel.PhongLightShader;


public class SinglePassPhongVertexShader extends VertexShader implements SinglePassShader, PhongLightShader {
	
	public SinglePassPhongVertexShader() {
		super("singlepass_phong/singlepass_phongVertex.vs");
	}
}
