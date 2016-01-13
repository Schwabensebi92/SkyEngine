package com.own.gameengine.renderingengine.concept.shader.uniform;


public abstract class Uniform<Type extends UniformType> {
	
	private String	name;
	private Type	value;
	
	public abstract void setValue(final Type value);
}
