package com.own.gameengine.renderingengine.concept.shader.singlepass;


import com.own.gameengine.renderingengine.concept.SinglePassShader;
import com.own.gameengine.renderingengine.concept.lightmodel.PhongShader;
import com.own.gameengine.renderingengine.concept.shader.VertexShader;


public class SinglePassPhongVertexShader extends VertexShader implements SinglePassShader, PhongShader {
	
	public SinglePassPhongVertexShader() {
		super("singlepass_phong/singlepass_phongVertex.vs");
	}
}
