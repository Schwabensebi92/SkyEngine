package com.own.gameengine.resource;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class FileLoader {
	
	public static String loadStringFromFile(String filePath) throws IOException {
		return new String(Files.readAllBytes(Paths.get(filePath)));
	}
}
