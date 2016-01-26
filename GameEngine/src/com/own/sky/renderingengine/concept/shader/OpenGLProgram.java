package com.own.sky.renderingengine.concept.shader;


import static org.lwjgl.opengl.GL20.GL_LINK_STATUS;
import static org.lwjgl.opengl.GL20.GL_VALIDATE_STATUS;
import static org.lwjgl.opengl.GL20.glAttachShader;
import static org.lwjgl.opengl.GL20.glBindAttribLocation;
import static org.lwjgl.opengl.GL20.glCreateProgram;
import static org.lwjgl.opengl.GL20.glGetProgramInfoLog;
import static org.lwjgl.opengl.GL20.glGetProgrami;
import static org.lwjgl.opengl.GL20.glGetUniformLocation;
import static org.lwjgl.opengl.GL20.glLinkProgram;
import static org.lwjgl.opengl.GL20.glUseProgram;
import static org.lwjgl.opengl.GL20.glValidateProgram;
import static org.lwjgl.opengl.GL20.*;

import java.util.ArrayList;
import java.util.HashMap;

import javax.jws.soap.SOAPBinding;

import com.own.sky.renderingengine.concept.shader.uniform.Uniform;


public class OpenGLProgram {
	
	/*
	 * http://stackoverflow.com/a/24425436
	 */
	
	private int							identifier;
	private ArrayList<Shader>			shaders;
	private ArrayList<Uniform<?>>	uniforms;
	
	public OpenGLProgram() {
		try {
			identifier = glCreateProgram();
			uniforms = new ArrayList<>();
			
			if (identifier == 0)
				throw new Exception("OpenGLProgram creation failed: No valid memory location.");
				
			shaders = new ArrayList<>();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	public void bind() {
		glUseProgram(identifier);
	}
	
	public int getUniformLocation(final String uniformName) throws Exception {
		int uniformLocation = glGetUniformLocation(identifier, uniformName);
		
		if (uniformLocation == 0xFFFFFFFF)
			throw new Exception("Uniform [" + uniformName + "] is not used.");
			
		return uniformLocation;
	}
	
	public void bindAttributeLocation(final String attributeName, final int location) {
		glBindAttribLocation(identifier, location, attributeName);
	}
	
	public void addShader(final Shader shader) {
		shaders.add(shader);
		glAttachShader(identifier, shader.getIdentifier());
	}
	
	public void removeShader(Shader shader) {
		shaders.remove(shader);
		glDetachShader(identifier, shader.getIdentifier());
	}
	
	public void load() throws Exception { //TODO ShaderLoaderException
		for (Shader shader : shaders) {
			shader.load();
		}
	}
	
	public void link() throws Exception { //TODO ShaderLinkerException
		for (Shader shader : shaders) {
			shader.link();
		}
	}
	
	public void compile() throws Exception { //TODO ShaderCompilerException
		for (Shader shader : shaders) {
			if (!shader.isCompiled()) {
				shader.compile();
			}
			
			for (Uniform<?> uniform : shader.getUniforms()) {
				if (uniforms.contains(uniform))
					throw new Exception("Duplicate uniform declaration: Uniform " + uniform.getIdentifier() + " in shader "
							+ shader.getIdentifier() + " already was declared.");
				else {
					uniforms.add(uniform);
				}
			}
		}

		glLinkProgram(identifier);
		
		if (glGetProgrami(identifier, GL_LINK_STATUS) == 0)
			throw new Exception(glGetProgramInfoLog(identifier, 1024));
			
		glValidateProgram(identifier);
		
		if (glGetProgrami(identifier, GL_VALIDATE_STATUS) == 0)
			throw new Exception(glGetProgramInfoLog(identifier, 1024));
	}
}
