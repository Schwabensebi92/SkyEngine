package com.own.sky.temp;


import com.own.sky.math.*;
import com.own.sky.renderingengine.graphics.object.*;


public class CubeMesh extends Mesh {
	
	/**
	 * Default constructor for a cube mesh.
	 */
	public CubeMesh() {
		this(0.5f, 0.5f, 0.5f);
	}
	
	/**
	 * Constructor for a cube mesh.
	 * 
	 * @param w
	 *            Width of the cube.
	 * @param h
	 *            Height of the cube.
	 * @param l
	 *            Length of the cube.
	 */
	public CubeMesh(final float w, final float h, final float l) {
		super(
				//@formatter:off
				new Vertex[] {
					new Vertex(new Vector3f(-w,  h,  l), new Vector2f(0.25f, 1.0f)),
					new Vertex(new Vector3f( w,  h,  l), new Vector2f(0.5f, 1.0f)),
					new Vertex(new Vector3f( w,  h, -l), new Vector2f(0.5f, 0.75f)),
					new Vertex(new Vector3f(-w,  h, -l), new Vector2f(0.25f, 0.75f)),
					
					new Vertex(new Vector3f(-w, -h,  l), new Vector2f(0.25f, 0.25f)),
					new Vertex(new Vector3f( w, -h,  l), new Vector2f(0.5f, 0.25f)),
					new Vertex(new Vector3f( w, -h, -l), new Vector2f(0.5f, 0.5f)),
					new Vertex(new Vector3f(-w, -h, -l), new Vector2f(0.25f, 0.5f))
				},
				new int[] {
					0, 1, 2, // arrow top
					0, 2, 3,
					7, 6, 5, // arrow bottom
					7, 5, 4,
					4, 5, 1, // arrow left
					4, 1, 0,
					3, 2, 6, // arrow right
					3, 6, 7,
					4, 0, 3, // arrow back
					4, 3, 7,
					1, 5, 6, // arrow front
					1, 6, 2
				},
				true
				//@formatter:on
		);
	}
}
