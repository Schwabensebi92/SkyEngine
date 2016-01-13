package com.own.gameengine.renderingengine.concept.shader;


import static org.lwjgl.opengl.GL20.GL_COMPILE_STATUS;
import static org.lwjgl.opengl.GL20.glCompileShader;
import static org.lwjgl.opengl.GL20.glCreateShader;
import static org.lwjgl.opengl.GL20.glGetShaderInfoLog;
import static org.lwjgl.opengl.GL20.glGetShaderi;
import static org.lwjgl.opengl.GL20.glShaderSource;

import java.io.IOException;

import com.own.gameengine.resource.ShaderLoader;
import com.own.gameengine.resource.ShaderParser;


public abstract class Shader {
	
	private int				id;
	private final Shaders	type;
	private String			sourceCode;
	private boolean			compiled;
	
	public Shader(final Shaders type, final String fileName) {
		this(type);
		load(fileName);
		compile();
	}
	
	public Shader(final Shaders type) {
		id = 0;
		this.type = type;
		sourceCode = null;
		compiled = false;
	}
	
	public void load(final String fileName) {
		try {
			String shaderFileContent = ShaderLoader.loadShader(fileName);
			sourceCode = ShaderParser.parse(shaderFileContent);
			compiled = false;
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	public void compile() {
		try {
			id = glCreateShader(type.getValue());
			
			if (id == 0)
				throw new Exception("Shader creation failed: No valid memory location.");
				
			if (sourceCode == null)
				throw new Exception("Shader creation failed: No GLSL code loaded.");
				
			glShaderSource(id, sourceCode);
			glCompileShader(id);
			
			if (glGetShaderi(id, GL_COMPILE_STATUS) == 0)
				throw new Exception(glGetShaderInfoLog(id, 1024));
				
			compiled = true;
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	public int getID() {
		return id;
	}
	
	public boolean isCompiled() {
		return compiled;
	}
}
