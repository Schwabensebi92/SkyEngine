package com.own.sky.renderingengine.concept.shader.singlepass;


import com.own.sky.renderingengine.concept.SinglePassShader;
import com.own.sky.renderingengine.concept.shader.FragmentShader;
import com.own.sky.renderingengine.lightengine.lightmodel.PhongLightShader;


public class SinglePassPhongFragmentShader extends FragmentShader implements SinglePassShader, PhongLightShader {
	
	public SinglePassPhongFragmentShader() {
		super("singlepass_phong/singlepass_phongFragment.fs");
	}
}
