package com.own.sky.renderingengine.graphics.object;


import static org.lwjgl.opengl.GL11.GL_FLOAT;
import static org.lwjgl.opengl.GL11.GL_TRIANGLES;
import static org.lwjgl.opengl.GL11.GL_UNSIGNED_INT;
import static org.lwjgl.opengl.GL11.glDrawElements;
import static org.lwjgl.opengl.GL15.GL_ARRAY_BUFFER;
import static org.lwjgl.opengl.GL15.GL_ELEMENT_ARRAY_BUFFER;
import static org.lwjgl.opengl.GL15.GL_STATIC_DRAW;
import static org.lwjgl.opengl.GL15.glBindBuffer;
import static org.lwjgl.opengl.GL15.glBufferData;
import static org.lwjgl.opengl.GL15.glGenBuffers;
import static org.lwjgl.opengl.GL20.glDisableVertexAttribArray;
import static org.lwjgl.opengl.GL20.glEnableVertexAttribArray;
import static org.lwjgl.opengl.GL20.glVertexAttribPointer;
import static org.lwjgl.opengl.GL30.glBindVertexArray;
import static org.lwjgl.opengl.GL30.glGenVertexArrays;

import java.io.IOException;

import com.own.sky.math.Vector3f;
import com.own.sky.renderingengine.RenderingEngineUtil;
import com.own.sky.resource.MeshFileType;
import com.own.sky.resource.MeshLoader;
import com.own.sky.resource.MeshParser;


public class Mesh {
	
	private int	vbo;	// Vertex Buffer Object
	private int	vao;	// Vertex Array Object
	private int	ibo;	// Index Buffer Object
	private int	size;
	
	public Mesh(final String fileName, MeshFileType type) {
		this();
		loadMesh(fileName, type);
	}
	
	public Mesh(final Vertex[] vertices, final int[] indices, final boolean calculateNormals) {
		this();
		setVertices(vertices, indices, calculateNormals);
	}
	
	private Mesh() {
		vbo = glGenBuffers();
		vao = glGenVertexArrays();
		ibo = glGenBuffers();
		size = 0;
	}
	
	private void loadMesh(final String fileName, MeshFileType type) {
		String meshFileContent;
		try {
			meshFileContent = MeshLoader.loadMesh(fileName);
			MeshParser.parse(meshFileContent, type, this);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	public void setVertices(final Vertex[] vertices, final int[] indices, final boolean calculateNormals) {
		if (calculateNormals) {
			calculateNormals(vertices, indices);
		}
		
		glBindVertexArray(vao);
		size = indices.length;
		
		glBindBuffer(GL_ARRAY_BUFFER, vbo);
		glBufferData(GL_ARRAY_BUFFER, RenderingEngineUtil.createFlippedBuffer(vertices), GL_STATIC_DRAW);
		
		glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo);
		glBufferData(GL_ELEMENT_ARRAY_BUFFER, RenderingEngineUtil.createFlippedBuffer(indices), GL_STATIC_DRAW);
	}
	
	public void draw() {
		glEnableVertexAttribArray(0);
		glEnableVertexAttribArray(1);
		glEnableVertexAttribArray(2);
		
		glBindBuffer(GL_ARRAY_BUFFER, vbo);
		glVertexAttribPointer(0, 3, GL_FLOAT, false, Vertex.SIZE * 4, 0); // Position
		glVertexAttribPointer(1, 2, GL_FLOAT, false, Vertex.SIZE * 4, 12); // TextureCoordinate
		glVertexAttribPointer(2, 3, GL_FLOAT, false, Vertex.SIZE * 4, 20); // Normal
		
		glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo);
		glDrawElements(GL_TRIANGLES, size, GL_UNSIGNED_INT, 0);
		
		glDisableVertexAttribArray(0);
		glDisableVertexAttribArray(1);
		glDisableVertexAttribArray(2);
	}
	
	private void calculateNormals(final Vertex[] vertices, final int[] indices) {
		for (int i = 0; i < indices.length; i += 3) {
			int i0 = indices[i];
			int i1 = indices[i + 1];
			int i2 = indices[i + 2];
			
			Vector3f v1 = new Vector3f(vertices[i1].getPosition()).sub(vertices[i0].getPosition());
			Vector3f v2 = new Vector3f(vertices[i2].getPosition()).sub(vertices[i0].getPosition());
			
			Vector3f normal = v1.cross(v2).normalize();
			
			vertices[i0].getNormal().add(normal);
			vertices[i1].getNormal().add(normal);
			vertices[i2].getNormal().add(normal);
		}
		
		for (int i = 0; i < vertices.length; i++) {
			vertices[i].getNormal().normalize();
		}
	}
}
