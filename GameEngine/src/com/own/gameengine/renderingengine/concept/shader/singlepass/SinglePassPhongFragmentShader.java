package com.own.gameengine.renderingengine.concept.shader.singlepass;


import com.own.gameengine.renderingengine.concept.SinglePassShader;
import com.own.gameengine.renderingengine.concept.shader.FragmentShader;
import com.own.gameengine.renderingengine.lightengine.lightmodel.PhongLightShader;


public class SinglePassPhongFragmentShader extends FragmentShader implements SinglePassShader, PhongLightShader {
	
	public SinglePassPhongFragmentShader() {
		super("singlepass_phong/singlepass_phongFragment.fs");
	}
}
