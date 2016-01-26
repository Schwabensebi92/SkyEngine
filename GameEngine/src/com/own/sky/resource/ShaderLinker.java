package com.own.sky.resource;


import java.io.*;


public class ShaderLinker {
	
	public static String link(final String shaderFileContent) throws IOException {
		StringBuilder sourceCode = new StringBuilder();
		BufferedReader shaderReader = new BufferedReader(new StringReader(shaderFileContent));
		
		String line;
		while ((line = shaderReader.readLine()) != null) {
			sourceCode.append(line).append("\n");
		}
		
		shaderReader.close();
		
		return sourceCode.toString();
	}
}