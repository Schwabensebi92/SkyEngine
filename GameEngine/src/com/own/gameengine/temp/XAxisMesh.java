package com.own.gameengine.temp;


import com.own.gameengine.coreengine.math.Vector3f;
import com.own.gameengine.renderingengine.graphics.object.*;


public class XAxisMesh extends Mesh {
	
	/**
	 * Default constructor for an arrow mesh oriented to the X-Axis.
	 */
	public XAxisMesh() {
		this(0.005f, 1.0f, 0.02f, 0.04f);
	}
	
	/**
	 * Constructor for an arrow mesh oriented to the X-Axis.
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
	public XAxisMesh(final float t, final float l, final float ht, final float hl) {
		super(
				//@formatter:off
				new Vertex[] {
					new Vertex(new Vector3f(  -l,    t,    t)),
					new Vertex(new Vector3f(l-hl,    t,    t)),
					new Vertex(new Vector3f(l-hl,    t,   -t)),
					new Vertex(new Vector3f(  -l,    t,   -t)),
					
					new Vertex(new Vector3f(  -l,   -t,    t)),
					new Vertex(new Vector3f(l-hl,   -t,    t)),
					new Vertex(new Vector3f(l-hl,   -t,   -t)),
					new Vertex(new Vector3f(  -l,   -t,   -t)),
					
					new Vertex(new Vector3f(l-hl,  -ht,   ht)),
					new Vertex(new Vector3f(l-hl,   ht,   ht)),
					new Vertex(new Vector3f(l-hl,   ht,  -ht)),
					new Vertex(new Vector3f(l-hl,  -ht,  -ht)),
					
					new Vertex(new Vector3f(   l, 0.0f, 0.0f))
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
