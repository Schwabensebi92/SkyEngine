package com.own.sky.renderingengine.concept.shader;


import static org.lwjgl.opengl.GL20.*;

import java.util.ArrayList;

import com.own.sky.renderingengine.concept.shader.uniform.Uniform;
import com.own.sky.resource.*;


public abstract class Shader {
	
	private int				identifier;
	private final Shaders	type;
	
	private String	fileName;
	private String	rawSourceCode;
	private String	linkedSourceCode;
	
	private ArrayList<Uniform<?>> uniforms;
	
	private boolean	created;
	private boolean	loaded;
	private boolean	linked;
	private boolean	compiled;
	
	public Shader(final Shaders type, final String fileName) {
		this.type = type;
		this.fileName = fileName;
		created = false;
		reset();
	}
	
	public Shader(final Shaders type) {
		this(type, "");
	}
	
	private void reset() {
		delete();
		create();
		rawSourceCode = null;
		linkedSourceCode = null;
		uniforms = new ArrayList<>();
		loaded = false;
		linked = false;
		compiled = false;
	}
	
	private void create() {
		if (false == isCreated()) {
			identifier = glCreateShader(type.getValue());
			created = true;
		}
	}
	
	private void delete() {
		if (true == isCreated()) {
			glDeleteShader(identifier);
			identifier = 0;
			created = false;
		}
	}
	
	public void load() throws Exception { // TODO ShaderLoaderException
		rawSourceCode = ShaderLoader.loadShader(fileName);
		loaded = true;
		linked = false;
		compiled = false;
	}
	
	public void link() throws Exception { // TODO ShaderLinkerException
		linkedSourceCode = ShaderLinker.link(rawSourceCode);
		linked = true;
		compiled = false;
	}
	
	public void compile() throws Exception { // TODO ShaderCompilerException
		if (false == linked)
			throw new Exception("Shader creation failed: No GLSL code loaded.");
			
		if (0 == identifier)
			throw new Exception("Shader creation failed: No valid memory location.");
			
		uniforms = ShaderParser.parse(linkedSourceCode);
		
		glShaderSource(identifier, rawSourceCode);
		glCompileShader(identifier);
		
		if (0 == glGetShaderi(identifier, GL_COMPILE_STATUS))
			throw new Exception(glGetShaderInfoLog(identifier, 1024));
			
		compiled = true;
	}
	
	public void setFileName(final String fileName) {
		this.fileName = fileName;
		reset();
	}
	
	public int getIdentifier() {
		return identifier;
	}
	
	public ArrayList<Uniform<?>> getUniforms() {
		return uniforms;
	}
	
	public boolean isCreated() {
		return created;
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
