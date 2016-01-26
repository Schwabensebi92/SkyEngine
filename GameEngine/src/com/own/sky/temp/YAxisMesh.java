package com.own.sky.temp;


import com.own.sky.math.Vector3f;
import com.own.sky.renderingengine.graphics.object.*;


public class YAxisMesh extends Mesh {
	
	/**
	 * Default constructor for an arrow mesh oriented to the Y-Axis.
	 */
	public YAxisMesh() {
		this(0.005f, 1.0f, 0.02f, 0.04f);
	}
	
	/**
	 * Constructor for an arrow mesh oriented to the Y-Axis.
	 * 
	 * @param t
	 *            Arrow thickness
	 * @param l
	 *            Arrow length
	 * @param ht
	 *            Arrow head thickness
	 * @param hl
	 *            Arrow head length
	 */
	public YAxisMesh(final float t, final float l, final float ht, final float hl) {
		super(
				//@formatter:off
				new Vertex[] {
					new Vertex(new Vector3f(-t,  -l, -t)),
					new Vertex(new Vector3f(-t,  l-hl, -t)),
					new Vertex(new Vector3f( t,  l-hl, -t)),
					new Vertex(new Vector3f( t,  -l, -t)),
					
					new Vertex(new Vector3f(-t, -l, t)),
					new Vertex(new Vector3f(-t, l-hl, t)),
					new Vertex(new Vector3f( t, l-hl, t)),
					new Vertex(new Vector3f( t, -l, t)),
					
					new Vertex(new Vector3f(-ht, l-hl, ht)),
					new Vertex(new Vector3f(-ht,  l-hl, -ht)),
					new Vertex(new Vector3f( ht,  l-hl, -ht)),
					new Vertex(new Vector3f( ht, l-hl, ht)),
					
					new Vertex(new Vector3f(0.0f, l, 0.0f))
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
					1, 6, 2,
					8, 9, 10, // arrow head back
					8, 10, 11,
					9, 12, 10, // arrow head top
					11, 12, 8, // arrow head bottom
					8, 12, 9, // arrow head left
					10, 12, 11// arrow head right
				},
				true
				//@formatter:on
		);
	}
}
