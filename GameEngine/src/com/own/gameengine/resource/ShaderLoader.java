package com.own.gameengine.resource;


import java.io.IOException;


public class ShaderLoader {
	
	public static String loadShader(final String fileName) throws IOException {
		return FileLoader.loadStringFromFile("./res/shaders/" + fileName);
	}
}
