package com.own.sky.renderingengine.concept.shader.singlepass;


import com.own.sky.renderingengine.concept.SinglePassShader;
import com.own.sky.renderingengine.concept.shader.FragmentShader;
import com.own.sky.renderingengine.lightengine.lightmodel.NoLightShader;


public class SinglePassNoFragmentShader extends FragmentShader implements SinglePassShader, NoLightShader {
	
	public SinglePassNoFragmentShader() {
		super("singlepass_no/singlepass_noFragment.fs");
	}
}