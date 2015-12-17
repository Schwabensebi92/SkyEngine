package com.own.gameengine.renderingengine.concept.shader.singlepass;


import com.own.gameengine.renderingengine.concept.SinglePassShader;
import com.own.gameengine.renderingengine.concept.lightmodel.NoLightShader;
import com.own.gameengine.renderingengine.concept.shader.FragmentShader;


public class SinglePassNoFragmentShader extends FragmentShader implements SinglePassShader, NoLightShader {
	
	public SinglePassNoFragmentShader() {
		super("singlepass_no/singlepass_noFragment.fs");
	}
}