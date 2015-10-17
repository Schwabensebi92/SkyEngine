package com.own.gameengine.renderingengine.concept;


public class DeferredRenderingConcept extends RenderingConcept {
	
	/*
	 * https://de.wikipedia.org/wiki/Deferred_Shading
	 * http://gamedev.stackexchange.com/questions/19575/is-there-a-way-to-use-an-arbitrary-number-of-lights-in-a-fragment-shader
	 */
	
	public DeferredRenderingConcept() {
		super(RenderingConcepts.DEFERRED_RENDERINGCONCEPT);
	}
}
