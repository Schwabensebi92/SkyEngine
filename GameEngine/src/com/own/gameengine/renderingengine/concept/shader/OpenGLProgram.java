package com.own.gameengine.renderingengine.concept.shader;


import static org.lwjgl.opengl.GL20.GL_LINK_STATUS;
import static org.lwjgl.opengl.GL20.GL_VALIDATE_STATUS;
import static org.lwjgl.opengl.GL20.glAttachShader;
import static org.lwjgl.opengl.GL20.glBindAttribLocation;
import static org.lwjgl.opengl.GL20.glCreateProgram;
import static org.lwjgl.opengl.GL20.glGetProgramInfoLog;
import static org.lwjgl.opengl.GL20.glGetProgrami;
import static org.lwjgl.opengl.GL20.glGetUniformLocation;
import static org.lwjgl.opengl.GL20.glLinkProgram;
import static org.lwjgl.opengl.GL20.glUniform1f;
import static org.lwjgl.opengl.GL20.glUniform1i;
import static org.lwjgl.opengl.GL20.glUniform3f;
import static org.lwjgl.opengl.GL20.glUniformMatrix4fv;
import static org.lwjgl.opengl.GL20.glUseProgram;
import static org.lwjgl.opengl.GL20.glValidateProgram;

import java.util.ArrayList;
import java.util.HashMap;

import com.own.gameengine.coreengine.math.Vector3f;
import com.own.gameengine.coreengine.math.matrix.Matrix4f;
import com.own.gameengine.renderingengine.RenderingEngineUtil;
import com.own.gameengine.renderingengine.graphics.light.AmbientLight;
import com.own.gameengine.renderingengine.graphics.light.DirectionalLight;
import com.own.gameengine.renderingengine.graphics.light.PointLight;
import com.own.gameengine.renderingengine.graphics.light.SpotLight;


public class OpenGLProgram {
	
	/*
	 * http://stackoverflow.com/a/24425436
	 */
	
	private int							id;
	private ArrayList<Shader>			shaders;
	private HashMap<String, Integer>	uniforms;
	
	public OpenGLProgram() {
		try {
			id = glCreateProgram();
			uniforms = new HashMap();
			
			if (id == 0)
				throw new Exception("OpenGLProgram creation failed: No valid memory location.");
				
			shaders = new ArrayList();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	public void bind() {
		glUseProgram(id);
	}
	
	public void addUniform(final String uniformName) {
		try {
			int uniformLocation = glGetUniformLocation(id, uniformName);
			
			if (uniformLocation == 0xFFFFFFFF)
				throw new Exception("Uniform [" + uniformName + "] creation failed: No valid memory location.");
			else {
				uniforms.put(uniformName, uniformLocation);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	public void bindAttributeLocation(final String attributeName, final int location) {
		glBindAttribLocation(id, location, attributeName);
	}
	
	public void addShader(final Shader shader) {
		shaders.add(shader);
		glAttachShader(id, shader.getID());
	}
	
	public void compile() {
		for (Shader shader : shaders) {
			if (!shader.isCompiled()) {
				shader.compile();
			}
		}
		
		try {
			glLinkProgram(id);
			
			if (glGetProgrami(id, GL_LINK_STATUS) == 0)
				throw new Exception(glGetProgramInfoLog(id, 1024));
				
			glValidateProgram(id);
			
			if (glGetProgrami(id, GL_VALIDATE_STATUS) == 0)
				throw new Exception(glGetProgramInfoLog(id, 1024));
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
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
