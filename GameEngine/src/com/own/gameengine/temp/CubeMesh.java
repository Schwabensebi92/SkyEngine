package com.own.gameengine.temp;


import com.own.gameengine.coreengine.math.Vector3f;
import com.own.gameengine.renderingengine.graphics.object.*;


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
					new Vertex(new Vector3f(-w,  h,  l)),
					new Vertex(new Vector3f( w,  h,  l)),
					new Vertex(new Vector3f( w,  h, -l)),
					new Vertex(new Vector3f(-w,  h, -l)),
					
					new Vertex(new Vector3f(-w, -h,  l)),
					new Vertex(new Vector3f( w, -h,  l)),
					new Vertex(new Vector3f( w, -h, -l)),
					new Vertex(new Vector3f(-w, -h, -l))
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
