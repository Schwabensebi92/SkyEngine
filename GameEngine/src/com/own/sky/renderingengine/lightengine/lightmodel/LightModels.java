package com.own.sky.renderingengine.lightengine.lightmodel;


public enum LightModels {
	
	NO_LIGHTMODEL,
	FLAT_LIGHTMODEL,
	GOURAUD_LIGHTMODEL,
	PHONG_LIGHTMODEL;
	
	private LightModel lightModel;
	
	public LightModel getLightModel() {
		if (lightModel != null)
			return lightModel;
			
		switch (this) {
			case NO_LIGHTMODEL:
				lightModel = new NoLightModel();
				break;
			case FLAT_LIGHTMODEL:
				lightModel = new FlatLightModel();
				break;
			case GOURAUD_LIGHTMODEL:
				lightModel = new GouraudLightModel();
				break;
			case PHONG_LIGHTMODEL:
				lightModel = new PhongLightModel();
				break;
			default:
				throw new RuntimeException("Can't handle LightModel of type: " + this);
		}
		return lightModel;
	}
}
