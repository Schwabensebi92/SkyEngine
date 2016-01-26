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
	
	private String 					fileName;
	private String					rawSourceCode;
	private String					linkedSourceCode;
	
	private ArrayList<Uniform<?>>	uniforms;
	
	private boolean					loaded;
	private boolean					linked;
	private boolean					compiled;
	
	public Shader(final Shaders type, final String fileName) {
		this.type = type;
		this.fileName = fileName;
		reset();
	}
	
	public Shader(final Shaders type) {
		this(type, "");
	}
	
	private void reset() {
		identifier = 0;
		rawSourceCode = null;
		linkedSourceCode = null;
		uniforms = new ArrayList<>();
		loaded = false;
		linked = false;
		compiled = false;
	}
	
	public void load() throws Exception { //TODO ShaderLoaderException
		rawSourceCode = ShaderLoader.loadShader(fileName);
		loaded = true;
		linked = false;
		compiled = false;
	}
	
	public void link() throws Exception { //TODO ShaderLinkerException
		linkedSourceCode = ShaderLinker.link(rawSourceCode);
		linked = true;
		compiled = false;
	}
	
	public void compile() throws Exception { //TODO ShaderCompilerException	
		if (linked == false)
			throw new Exception("Shader creation failed: No GLSL code loaded.");
			
		identifier = glCreateShader(type.getValue());
		
		if (identifier == 0)
			throw new Exception("Shader creation failed: No valid memory location.");

		uniforms = ShaderParser.parse(linkedSourceCode);
		
		glShaderSource(identifier, rawSourceCode);
		glCompileShader(identifier);
		
		if (glGetShaderi(identifier, GL_COMPILE_STATUS) == 0)
			throw new Exception(glGetShaderInfoLog(identifier, 1024));
			
		compiled = true;
	}
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
		reset();
	}
	
	public int getIdentifier() {
		return identifier;
	}
	
	public ArrayList<Uniform<?>> getUniforms() {
		return uniforms;
	}
	
	public boolean isLoaded() {
		return loaded;
	}
	
	public boolean isLinked() {
		return linked;
	}
	
	public boolean isCompiled() {
		return compiled;
	}
}
