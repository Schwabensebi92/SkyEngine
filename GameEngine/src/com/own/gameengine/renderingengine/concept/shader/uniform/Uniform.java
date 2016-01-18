package com.own.gameengine.renderingengine.concept.shader.uniform;


import com.own.gameengine.renderingengine.graphics.light.AmbientLight;
import com.own.gameengine.renderingengine.graphics.light.DirectionalLight;
import com.own.gameengine.renderingengine.graphics.light.PointLight;
import com.own.gameengine.renderingengine.graphics.light.SpotLight;


public abstract class Uniform<Type> {
	
	private UniformType	type;
	private String		identifier;
	protected int		location;
	protected Type		value;
	
	public Uniform(UniformType type, final String identifier) {
		this.type = type;
		this.identifier = identifier;
		this.location = 0xFFFFFFFF;
	}
	
	public String getIdentifier() {
		return identifier;
	}
	
	public void setLocation(int location) {
		this.location = location;
	}
	
	public void setValue(final Type value) {
		this.value = value;
	}
	
	public abstract void send();
	
	public void setUniform(final String uniformName, final AmbientLight ambientLight) {
		setUniformf(uniformName, ambientLight.getIntensity());
	}
	
	public void setUniform(final String uniformName, final DirectionalLight directionalLight) {
		setUniform(uniformName + ".baseLight", directionalLight.getColor());
		setUniformf(uniformName + ".intensity", directionalLight.getIntensity());
		setUniform(uniformName + ".direction", directionalLight.getDirection());
	}
	
	public void setUniform(final String uniformName, final PointLight pointLight) {
		setUniform(uniformName + ".color", pointLight.getColor());
		setUniformf(uniformName + ".intensity", pointLight.getIntensity());
		setUniformf(uniformName + ".attenuation.constant", pointLight.getAttenuation().getConstant());
		setUniformf(uniformName + ".attenuation.linear", pointLight.getAttenuation().getLinear());
		setUniformf(uniformName + ".attenuation.exponent", pointLight.getAttenuation().getExponent());
		setUniform(uniformName + ".position", pointLight.getPosition());
		setUniformf(uniformName + ".range", pointLight.getRange());
	}
	
	public void setUniform(final String uniformName, final SpotLight spotLight) {
		setUniform(uniformName + ".color", spotLight.getColor());
		setUniformf(uniformName + ".intensity", spotLight.getIntensity());
		setUniformf(uniformName + ".attenuation.constant", spotLight.getAttenuation().getConstant());
		setUniformf(uniformName + ".attenuation.linear", spotLight.getAttenuation().getLinear());
		setUniformf(uniformName + ".attenuation.exponent", spotLight.getAttenuation().getExponent());
		setUniform(uniformName + ".position", spotLight.getPosition());
		setUniformf(uniformName + ".range", spotLight.getRange());
		setUniform(uniformName + ".direction", spotLight.getDirection());
		setUniformf(uniformName + ".cutoff", spotLight.getCutoff());
	}
}
