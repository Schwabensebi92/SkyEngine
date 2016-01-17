package com.own.gameengine.renderingengine.concept.shader;


import static org.lwjgl.opengl.GL20.*;

import java.util.*;

import com.own.gameengine.renderingengine.concept.shader.uniform.Uniform;


public class OpenGLProgram {
	
	/*
	 * http://stackoverflow.com/a/24425436
	 */
	
	private int							identifier;
	private ArrayList<Shader>			shaders;
	private HashMap<String, Uniform>	uniforms;
	
	public OpenGLProgram() {
		try {
			identifier = glCreateProgram();
			uniforms = new HashMap();
			
			if (identifier == 0)
				throw new Exception("OpenGLProgram creation failed: No valid memory location.");
				
			shaders = new ArrayList();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	public void bind() {
		glUseProgram(identifier);
	}
	
	public void getUniformLocation(final String uniformName) {
		try {
			int uniformLocation = glGetUniformLocation(identifier, uniformName);
			
			if (uniformLocation == 0xFFFFFFFF)
				throw new Exception("Uniform [" + uniformName + "] was not created.");
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	public void bindAttributeLocation(final String attributeName, final int location) {
		glBindAttribLocation(identifier, location, attributeName);
	}
	
	public void addShader(final Shader shader) throws Exception {
		shaders.add(shader);
		for (Uniform uniform : shader.getUniforms()) {
			if (uniforms.containsKey(uniform.getIdentifier()))
				throw new Exception("Duplicate uniform declaration: Uniform " + uniform.getIdentifier() + " in shader "
						+ shader.getIdentifier() + " already was declared.");
			else {
				uniforms.put(uniform.getIdentifier(), uniform);
			}
		}
		glAttachShader(identifier, shader.getIdentifier());
	}
	
	public void compile() {
		for (Shader shader : shaders) {
			if (!shader.isCompiled()) {
				shader.compile();
			}
		}
		
		try {
			glLinkProgram(identifier);
			
			if (glGetProgrami(identifier, GL_LINK_STATUS) == 0)
				throw new Exception(glGetProgramInfoLog(identifier, 1024));
				
			glValidateProgram(identifier);
			
			if (glGetProgrami(identifier, GL_VALIDATE_STATUS) == 0)
				throw new Exception(glGetProgramInfoLog(identifier, 1024));
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
}
