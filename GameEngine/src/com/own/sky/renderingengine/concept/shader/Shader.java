package com.own.sky.renderingengine.concept.shader;


import static org.lwjgl.opengl.GL20.GL_COMPILE_STATUS;
import static org.lwjgl.opengl.GL20.glCompileShader;
import static org.lwjgl.opengl.GL20.glCreateShader;
import static org.lwjgl.opengl.GL20.glGetShaderInfoLog;
import static org.lwjgl.opengl.GL20.glGetShaderi;
import static org.lwjgl.opengl.GL20.glShaderSource;

import java.io.IOException;
import java.util.ArrayList;

import com.own.sky.renderingengine.concept.shader.uniform.Uniform;
import com.own.sky.resource.ShaderLinker;
import com.own.sky.resource.ShaderLoader;
import com.own.sky.resource.ShaderParser;


public abstract class Shader {
	
	private int						identifier;
	private final Shaders			type;
	private String					rawSourceCode;
	private String					linkedSourceCode;
	private ArrayList<Uniform<?>>	uniforms;
	private boolean					parsed;
	private boolean					compiled;
	
	public Shader(final Shaders type, final String fileName) {
		this(type);
		load(fileName);
		compile();
	}
	
	public Shader(final Shaders type) {
		identifier = 0;
		this.type = type;
		rawSourceCode = null;
		uniforms = new ArrayList<>();
		parsed = false;
		compiled = false;
	}
	
	public void load(final String fileName) {
		try {
			rawSourceCode = ShaderLoader.loadShader(fileName);
			linkedSourceCode = ShaderLinker.link(rawSourceCode);
			uniforms = ShaderParser.parse(linkedSourceCode);
			parsed = true;
			compiled = false;
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	public void compile() {
		try {
			identifier = glCreateShader(type.getValue());
			
			if (identifier == 0)
				throw new Exception("Shader creation failed: No valid memory location.");
				
			if (rawSourceCode == null)
				throw new Exception("Shader creation failed: No GLSL code loaded.");
				
			glShaderSource(identifier, rawSourceCode);
			glCompileShader(identifier);
			
			if (glGetShaderi(identifier, GL_COMPILE_STATUS) == 0)
				throw new Exception(glGetShaderInfoLog(identifier, 1024));
				
			compiled = true;
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	public int getIdentifier() {
		return identifier;
	}
	
	public ArrayList<Uniform<?>> getUniforms() {
		return uniforms;
	}
	
	public boolean isParsed() {
		return parsed;
	}
	
	public boolean isCompiled() {
		return compiled;
	}
}
