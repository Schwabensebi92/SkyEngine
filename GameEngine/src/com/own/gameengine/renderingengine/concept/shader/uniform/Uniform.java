package com.own.gameengine.renderingengine.concept.shader.uniform;


public abstract class Uniform<Type> {
	
	private String	name;
	private Type	value;
	
	public abstract void setUniform(final Type value);
}
