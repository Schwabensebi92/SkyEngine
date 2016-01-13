package com.own.gameengine.resource;


import java.io.IOException;


public class MeshLoader {
	
	public static String loadMesh(final String fileName) throws IOException {
		return FileLoader.loadStringFromFile("./res/models/" + fileName);
	}
}
