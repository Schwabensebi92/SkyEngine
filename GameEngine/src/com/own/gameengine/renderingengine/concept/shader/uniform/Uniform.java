package com.own.gameengine.renderingengine.concept.shader.uniform;


import static org.lwjgl.opengl.GL20.*;

import com.own.gameengine.coreengine.math.Vector3f;
import com.own.gameengine.coreengine.math.matrix.Matrix4f;
import com.own.gameengine.renderingengine.RenderingEngineUtil;
import com.own.gameengine.renderingengine.graphics.light.*;


public abstract class Uniform<Type> {
	
	private String	identifier;
	private Type	value;
	
	public Uniform(final String identifier) {
		this.identifier = identifier;
	}
	
	public String getIdentifier() {
		return identifier;
	}
	
	public abstract void setValue(final Type value);
	
	public void setUniformi(final String uniformName, final int value) {
		glUniform1i(uniforms.get(uniformName), value);
	}
	
	public void setUniformf(final String uniformName, final float value) {
		glUniform1f(uniforms.get(uniformName), value);
	}
	
	public void setUniform(final String uniformName, final Vector3f value) {
		glUniform3f(uniforms.get(uniformName), value.getX(), value.getY(), value.getZ());
	}
	
	public void setUniform(final String uniformName, final Matrix4f value) {
		glUniformMatrix4fv(uniforms.get(uniformName), true, RenderingEngineUtil.createFlippedBuffer(value));
	}
	
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
