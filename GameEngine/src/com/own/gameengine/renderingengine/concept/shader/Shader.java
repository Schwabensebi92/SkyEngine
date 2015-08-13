package com.own.gameengine.renderingengine.concept.shader;

import static org.lwjgl.opengl.GL20.*;

import java.io.*;

public abstract class Shader {

	private int				id;
	private final Shaders	type;
	private String			sourceCode;

	public Shader(Shaders type, String fileName) {
		this(type);
		load(fileName);
		create();
	}

	public Shader(Shaders type) {
		this.id = 0;
		this.type = type;
		this.sourceCode = null;
	}

	public void load(String fileName) {
		this.sourceCode = loadSourceCode(fileName);
	}

	public void create() {
		try {
			id = glCreateShader(type.getValue());

			if (id == 0) {
				throw new Exception("Shader creation failed: No valid memory location.");
			}

			if (sourceCode == null) {
				throw new Exception("Shader creation failed: No GLSL code loaded.");
			}

			glShaderSource(id, sourceCode);
			glCompileShader(id);

			if (glGetShaderi(id, GL_COMPILE_STATUS) == 0) {
				throw new Exception(glGetShaderInfoLog(id, 1024));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	private static String loadSourceCode(String fileName) {
		StringBuilder shaderSource = new StringBuilder();
		BufferedReader shaderReader = null;
		try {
			shaderReader = new BufferedReader(new FileReader("./res/shaders/" + fileName));

			String line;
			while ((line = shaderReader.readLine()) != null) {
				shaderSource.append(line).append("\n");
			}

			shaderReader.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}

		return shaderSource.toString();
	}

	public int getID() {
		return id;
	}
}
