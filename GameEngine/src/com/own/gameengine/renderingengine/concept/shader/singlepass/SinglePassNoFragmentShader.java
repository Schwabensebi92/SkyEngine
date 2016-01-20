package com.own.gameengine.renderingengine.concept.shader.singlepass;


import com.own.gameengine.renderingengine.concept.SinglePassShader;
import com.own.gameengine.renderingengine.concept.shader.FragmentShader;
import com.own.gameengine.renderingengine.lightengine.lightmodel.NoLightShader;


public class SinglePassNoFragmentShader extends FragmentShader implements SinglePassShader, NoLightShader {
	
	public SinglePassNoFragmentShader() {
		super("singlepass_no/singlepass_noFragment.fs");
	}
}