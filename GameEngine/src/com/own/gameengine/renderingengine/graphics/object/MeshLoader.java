package com.own.gameengine.renderingengine.graphics.object;


import java.io.*;
import java.util.ArrayList;

import com.own.gameengine.coreengine.math.Vector3f;
import com.own.gameengine.renderingengine.RenderingEngineUtil;


public class MeshLoader {
	
	public static void loadMesh(final String fileName, final Mesh mesh) {
		String[] splitString = fileName.split("\\.");
		String fileExtension = splitString[splitString.length - 1];
		
		if (fileExtension.equals("obj")) {
			ArrayList<Vertex> vertices = new ArrayList<Vertex>();
			ArrayList<Integer> indices = new ArrayList<Integer>();
			
			BufferedReader meshReader = null;
			
			try {
				meshReader = new BufferedReader(new FileReader("./res/models/" + fileName));
				
				String line;
				while ((line = meshReader.readLine()) != null) {
					String[] tokens = line.split(" ");
					tokens = RenderingEngineUtil.removeEmptyStrings(tokens);
					
					if (tokens.length == 0 || tokens[0].equals("#")) {
						continue;
					} else if (tokens[0].equals("v")) {
						vertices.add(
								new Vertex(new Vector3f(Float.valueOf(tokens[1]), Float.valueOf(tokens[2]), Float.valueOf(tokens[3]))));
					} else if (tokens[0].equals("f")) {
						indices.add(Integer.parseInt(tokens[1]) - 1);
						indices.add(Integer.parseInt(tokens[2]) - 1);
						indices.add(Integer.parseInt(tokens[3]) - 1);
					}
				}
				
				meshReader.close();
				
				Vertex[] vertexArray = new Vertex[vertices.size()];
				vertices.toArray(vertexArray);
				
				Integer[] indexArray = new Integer[indices.size()];
				indices.toArray(indexArray);
				
				mesh.setVertices(vertexArray, RenderingEngineUtil.toIntArray(indexArray), true);
				
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(1);
			}
			
		} else {
			new Exception("Error: File format not supported for mesh format: " + fileExtension).printStackTrace();
			System.exit(1);
		}
	}
}
