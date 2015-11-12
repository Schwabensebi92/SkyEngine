package com.own.gameengine.renderingengine.concept.shader.singlepass;


import com.own.gameengine.renderingengine.concept.SinglePassShader;
import com.own.gameengine.renderingengine.concept.lightmodel.PhongShader;
import com.own.gameengine.renderingengine.concept.shader.FragmentShader;


public class SinglePassPhongFragmentShader extends FragmentShader implements SinglePassShader, PhongShader {
	
	public SinglePassPhongFragmentShader() {
		super("singlepass_phong/singlepass_phongFragment.fs");
	}
}
