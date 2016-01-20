package com.own.gameengine.resource;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

import com.own.gameengine.math.Vector3f;
import com.own.gameengine.renderingengine.RenderingEngineUtil;
import com.own.gameengine.renderingengine.graphics.object.Mesh;
import com.own.gameengine.renderingengine.graphics.object.Vertex;


public class MeshParser {
	
	public static void parse(final String meshFileContent, MeshFileType type, Mesh mesh) throws IOException {
		switch (type) {
			case obj: {
				parseObj(meshFileContent, mesh);
				break;
			}
			default: {
				throw new IOException("MeshParser: Not supported file format: " + type);
			}
		}
	}
	
	private static void parseObj(final String meshFileContent, Mesh mesh) throws IOException {
		ArrayList<Vertex> vertices = new ArrayList<Vertex>();
		ArrayList<Integer> indices = new ArrayList<Integer>();
		
		BufferedReader meshReader = new BufferedReader(new StringReader(meshFileContent));
		
		String line;
		while ((line = meshReader.readLine()) != null) {
			String[] tokens = line.split(" ");
			tokens = RenderingEngineUtil.removeEmptyStrings(tokens);
			
			if (tokens.length == 0 || tokens[0].equals("#")) {
				continue;
			} else if (tokens[0].equals("v")) {
				vertices.add(new Vertex(new Vector3f(Float.valueOf(tokens[1]), Float.valueOf(tokens[2]), Float.valueOf(tokens[3]))));
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
		
	}
}
