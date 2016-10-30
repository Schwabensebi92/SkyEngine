package com.own.sky.renderingengine.concept.shader;


import static org.lwjgl.opengl.GL20.*;

import java.util.ArrayList;

import com.own.sky.renderingengine.concept.shader.uniform.Uniform;


public class OpenGLProgram {
	
	/*
	 * http://stackoverflow.com/a/24425436
	 */
	
	private int						identifier;
	private ArrayList<Shader>		shaders;
	private ArrayList<Uniform<?>>	uniforms;
	
	public OpenGLProgram() {
		try {
			identifier = glCreateProgram();
			uniforms = new ArrayList<>();
			
			if (0 == identifier)
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
		
		if (0xFFFFFFFF == uniformLocation)
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
	
	public void removeShader(final Shader shader) {
		shaders.remove(shader);
		glDetachShader(identifier, shader.getIdentifier());
	}
	
	public void load() throws Exception { // TODO ShaderLoaderException
		for (Shader shader : shaders) {
			shader.load();
		}
	}
	
	public void link() throws Exception { // TODO ShaderLinkerException
		for (Shader shader : shaders) {
			shader.link();
		}
	}
	
	public void compile() throws Exception { // TODO ShaderCompilerException
		for (Shader shader : shaders) {
			if (!shader.isCompiled()) {
				shader.compile();
			}
			
			for (Uniform<?> uniform : shader.getUniforms()) {
				if (!uniforms.contains(uniform)) {
					uniforms.add(uniform);
				} else
					throw new Exception("Duplicate uniform declaration: Uniform " + uniform.getIdentifier() + " in shader "
							+ shader.getIdentifier() + " was already declared.");
			}
		}
		
		glLinkProgram(identifier);
		
		if (0 == glGetProgrami(identifier, GL_LINK_STATUS))
			throw new Exception(glGetProgramInfoLog(identifier, 1024));
			
		glValidateProgram(identifier);
		
		if (0 == glGetProgrami(identifier, GL_VALIDATE_STATUS))
			throw new Exception(glGetProgramInfoLog(identifier, 1024));
	}
	
	@Override
	public String toString() {
		return "OpenGLProgram " + identifier + ":\nShaders: " + shaders + "\nUniforms: " + uniforms;
	}
}
