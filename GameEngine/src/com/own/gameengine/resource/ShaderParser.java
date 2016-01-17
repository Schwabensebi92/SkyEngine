package com.own.gameengine.resource;


import java.io.*;
import java.util.ArrayList;

import com.own.gameengine.renderingengine.concept.shader.uniform.Uniform;


public class ShaderParser {
	
	private final static String UNIFORM_KEYWORD = "Uniform";
	
	public static ArrayList<Uniform> parse(final String sourceCode) throws IOException {
		ArrayList<Uniform> uniforms = new ArrayList<>();
		BufferedReader shaderReader = new BufferedReader(new StringReader(sourceCode));
		
		String line;
		while ((line = shaderReader.readLine()) != null) {
			line.trim(); // Remove extra white space
			if (line.startsWith(UNIFORM_KEYWORD)) {
			
			}
		}
		
		shaderReader.close();
		
		return uniforms;
	}
}
