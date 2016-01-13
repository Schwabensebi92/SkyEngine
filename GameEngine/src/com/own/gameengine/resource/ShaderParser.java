package com.own.gameengine.resource;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;


public class ShaderParser {
	
	public static String parse(final String shaderFileContent) throws IOException {
		StringBuilder shaderSource = new StringBuilder();
		BufferedReader shaderReader = new BufferedReader(new StringReader(shaderFileContent));
		
		String line;
		while ((line = shaderReader.readLine()) != null) {
			shaderSource.append(line).append("\n");
		}
		
		shaderReader.close();
		
		return shaderSource.toString();
	}
}
