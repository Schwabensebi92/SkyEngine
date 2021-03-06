package com.own.sky.renderingengine.concept.shader.uniform;


import com.own.sky.math.Vector3f;
import com.own.sky.renderingengine.lightengine.light.AmbientLight;
import com.own.sky.renderingengine.lightengine.light.DirectionalLight;
import com.own.sky.renderingengine.lightengine.light.PointLight;
import com.own.sky.renderingengine.lightengine.light.SpotLight;


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
	
	@Override
	public int hashCode() {
		return location;
	}
	
	@Override
	public boolean equals(Object other) {
		if (other == null)
			return false;
		if (other == this)
			return true;
		if (!(other instanceof Uniform))
			return false;
		Uniform<?> otherUniform = (Uniform<?>) other;
		return identifier.equals(otherUniform.getIdentifier());
	}
	
//	public void setUniform(final String uniformName, final AmbientLight ambientLight) {
//		setUniformf(uniformName, ambientLight.getIntensity());
//	}
//	
//	public void setUniform(final String uniformName, final DirectionalLight directionalLight) {
//		setUniform(uniformName + ".baseLight", directionalLight.getColor());
//		setUniformf(uniformName + ".intensity", directionalLight.getIntensity());
//		setUniform(uniformName + ".direction", directionalLight.getDirection());
//	}
//	
//	public void setUniform(final String uniformName, final PointLight pointLight) {
//		setUniform(uniformName + ".color", pointLight.getColor());
//		setUniformf(uniformName + ".intensity", pointLight.getIntensity());
//		setUniformf(uniformName + ".attenuation.constant", pointLight.getAttenuation().getConstant());
//		setUniformf(uniformName + ".attenuation.linear", pointLight.getAttenuation().getLinear());
//		setUniformf(uniformName + ".attenuation.exponent", pointLight.getAttenuation().getExponent());
//		setUniform(uniformName + ".position", pointLight.getPosition());
//		setUniformf(uniformName + ".range", pointLight.getRange());
//	}
//	
//	public void setUniform(final String uniformName, final SpotLight spotLight) {
//		setUniform(uniformName + ".color", spotLight.getColor());
//		setUniformf(uniformName + ".intensity", spotLight.getIntensity());
//		setUniformf(uniformName + ".attenuation.constant", spotLight.getAttenuation().getConstant());
//		setUniformf(uniformName + ".attenuation.linear", spotLight.getAttenuation().getLinear());
//		setUniformf(uniformName + ".attenuation.exponent", spotLight.getAttenuation().getExponent());
//		setUniform(uniformName + ".position", spotLight.getPosition());
//		setUniformf(uniformName + ".range", spotLight.getRange());
//		setUniform(uniformName + ".direction", spotLight.getDirection());
//		setUniformf(uniformName + ".cutoff", spotLight.getCutoff());
//	}
}
