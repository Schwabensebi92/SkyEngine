package com.own.gameengine.renderingengine.concept;


import java.util.ArrayList;

import com.own.gameengine.coreengine.scenegraph.GameComponent;
import com.own.gameengine.renderingengine.cameraengine.Camera;
import com.own.gameengine.renderingengine.graphics.*;
import com.own.gameengine.renderingengine.graphics.object.*;


public class DeferredRenderingConcept extends RenderingConcept {
	
	/*
	 * https://de.wikipedia.org/wiki/Deferred_Shading
	 * https://en.wikipedia.org/wiki/Deferred_shading
	 * http://gamedev.stackexchange.com/questions/19575/is-there-a-way-to-use-an-arbitrary-number-of-lights-in-a-fragment-shader
	 * http://gamedevelopment.tutsplus.com/articles/forward-rendering-vs-deferred-rendering--gamedev-12342
	 * http://ogldev.atspace.co.uk/index.html
	 * http://ephenationopengl.blogspot.de/2012/01/setting-up-deferred-shader.html
	 * http://www.neuroproductions.be/opengl/making-a-3d-game-with-opengl-deferred-shading-and-stuff/
	 * http://stackoverflow.com/questions/28844150/what-should-a-g-buffer-commonly-include-in-a-deferred-rendering-process
	 * http://gamedev.stackexchange.com/questions/74634/best-way-to-render-multiple-lights-with-deferred-rendering-and-glsl
	 * http://gamedev.stackexchange.com/questions/74578/deferred-rendering-with-diffuse-specular-and-normal-maps
	 * http://http.download.nvidia.com/developer/presentations/2004/6800_Leagues/6800_Leagues_Deferred_Shading.pdf
	 * http://www.codinglabs.net/tutorial_simple_def_rendering.aspx
	 * http://gamedev.stackexchange.com/questions/74/what-is-deferred-rendering
	 * http://www.tomdalling.com/blog/modern-opengl/08-even-more-lighting-directional-lights-spotlights-multiple-lights/
	 */
	
	public DeferredRenderingConcept() {
		super(RenderingConcepts.DEFERRED_RENDERINGCONCEPT);
	}
	
	@Override
	public void render(final ArrayList<GameComponent> renderableGameComponents) {
		// TODO Implement
	}
	
	@Override
	public void renderMesh(final Transform transform, final Camera camera, final Material material, final Mesh mesh) {
		// TODO Implement
	}
}
