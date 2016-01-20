package com.own.gameengine.renderingengine.lightengine;


import java.util.ArrayList;

import com.own.gameengine.renderingengine.lightengine.light.AmbientLight;
import com.own.gameengine.renderingengine.lightengine.light.DirectionalLight;
import com.own.gameengine.renderingengine.lightengine.light.PointLight;
import com.own.gameengine.renderingengine.lightengine.light.SpotLight;


public class LightEngine {
	
	private ArrayList<AmbientLight>		ambientLights;
	private ArrayList<DirectionalLight>	directionalLights;
	private ArrayList<PointLight>		pointLights;
	private ArrayList<SpotLight>		spotLights;
	
	public LightEngine() {
		// TODO Do some meaningful stuff
	}
	
	public void initialize() {
		ambientLights = new ArrayList<>();
		directionalLights = new ArrayList<>();
		pointLights = new ArrayList<>();
		spotLights = new ArrayList<>();
	}
	
	public void cleanUp() {
	
	}
	
	// public void register(final Timeable timeable) {
	// timingObjects.add(timeable);
	// }
	//
	// public void unregister(final Timeable timeable) {
	// timingObjects.remove(timeable);
	// }
}
