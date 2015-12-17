package com.own.gameengine.renderingengine.concept.shader.singlepass;


import com.own.gameengine.renderingengine.concept.SinglePassShader;
import com.own.gameengine.renderingengine.concept.lightmodel.PhongLightShader;
import com.own.gameengine.renderingengine.concept.shader.FragmentShader;


public class SinglePassPhongFragmentShader extends FragmentShader implements SinglePassShader, PhongLightShader {
	
	public SinglePassPhongFragmentShader() {
		super("singlepass_phong/singlepass_phongFragment.fs");
	}
}
