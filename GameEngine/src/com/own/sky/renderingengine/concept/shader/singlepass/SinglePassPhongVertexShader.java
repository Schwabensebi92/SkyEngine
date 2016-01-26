package com.own.sky.renderingengine.concept.shader.singlepass;


import com.own.sky.renderingengine.concept.SinglePassShader;
import com.own.sky.renderingengine.concept.shader.VertexShader;
import com.own.sky.renderingengine.lightengine.lightmodel.PhongLightShader;


public class SinglePassPhongVertexShader extends VertexShader implements SinglePassShader, PhongLightShader {
	
	public SinglePassPhongVertexShader() {
		super("singlepass_phong/singlepass_phongVertex.vs");
	}
}
