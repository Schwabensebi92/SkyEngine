package com.own.sky.renderingengine.concept;


public enum RenderingConcepts {
	
	NO_RENDERINGCONCEPT,
	SINGLE_PASS_RENDERINGCONCEPT,
	FORWARD_RENDERINGCONCEPT,
	DEFERRED_RENDERINGCONCEPT;
	
	private RenderingConcept renderingConcept;
	
	public RenderingConcept getRenderingConcept() {
		if (renderingConcept != null)
			return renderingConcept;
			
		switch (this) {
			case NO_RENDERINGCONCEPT:
				renderingConcept = new NoRenderingConcept();
				break;
			case SINGLE_PASS_RENDERINGCONCEPT:
				renderingConcept = new SinglePassRenderingConcept();
				break;
			case FORWARD_RENDERINGCONCEPT:
				renderingConcept = new ForwardRenderingConcept();
				break;
			case DEFERRED_RENDERINGCONCEPT:
				renderingConcept = new DeferredRenderingConcept();
				break;
			default:
				throw new RuntimeException("Can't handle RenderingConcept of type: " + this);
		}
		return renderingConcept;
	}
}
