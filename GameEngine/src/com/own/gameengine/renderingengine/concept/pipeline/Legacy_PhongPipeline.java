package com.own.gameengine.renderingengine.concept.pipeline;


import com.own.gameengine.math.Vector3f;
import com.own.gameengine.renderingengine.cameraengine.Camera;
import com.own.gameengine.renderingengine.concept.shader.*;
import com.own.gameengine.renderingengine.graphics.*;
import com.own.gameengine.renderingengine.graphics.object.Material;
import com.own.gameengine.renderingengine.graphics.object.Transform;
import com.own.gameengine.renderingengine.lightengine.light.*;


public class Legacy_PhongPipeline extends Legacy_RenderingPipeline {
	
	private final static int	MAX_POINT_LIGHTS	= 4;
	private final static int	MAX_SPOT_LIGHTS		= 4;
	
	private Vector3f			ambientLight;
	private DirectionalLight	directionalLight;
	private PointLight[]		pointLights;
	private SpotLight[]			spotLights;
	
	public Legacy_PhongPipeline() {
		super();
		
		ambientLight = new Vector3f(1.0f, 1.0f, 1.0f);
		directionalLight = new DirectionalLight(new Vector3f(1.0f, 1.0f, 1.0f), 0, new Vector3f());
		pointLights = new PointLight[] {};
		spotLights = new SpotLight[] {};
		
		addUniform("eyePosition");
		
		addUniform("transform");
		addUniform("transformProjected");
		addUniform("baseColor");
		
		addUniform("ambientLight");
		
		addUniform("specularIntensity");
		addUniform("specularExponent");
		
		addUniform("directionalLight.baseLight.color");
		addUniform("directionalLight.baseLight.intensity");
		addUniform("directionalLight.direction");
		
		for (int i = 0; i < MAX_POINT_LIGHTS; i++) {
			addUniform("pointLights[" + i + "].baseLight.color");
			addUniform("pointLights[" + i + "].baseLight.intensity");
			addUniform("pointLights[" + i + "].attenuation.constant");
			addUniform("pointLights[" + i + "].attenuation.linear");
			addUniform("pointLights[" + i + "].attenuation.exponent");
			addUniform("pointLights[" + i + "].position");
			addUniform("pointLights[" + i + "].range");
		}
		
		for (int i = 0; i < MAX_SPOT_LIGHTS; i++) {
			addUniform("spotLights[" + i + "].pointLight.baseLight.color");
			addUniform("spotLights[" + i + "].pointLight.baseLight.intensity");
			addUniform("spotLights[" + i + "].pointLight.attenuation.constant");
			addUniform("spotLights[" + i + "].pointLight.attenuation.linear");
			addUniform("spotLights[" + i + "].pointLight.attenuation.exponent");
			addUniform("spotLights[" + i + "].pointLight.position");
			addUniform("spotLights[" + i + "].pointLight.range");
			
			addUniform("spotLights[" + i + "].direction");
			addUniform("spotLights[" + i + "].cutoff");
		}
	}
	
	@Override
	public Shader[] createShaders() {
		Shader[] shaders = { new VertexShader("phongVertex.vs"), new FragmentShader("phongFragment.fs") };
		return shaders;
	}
	
	@Override
	public void updateUniforms(final Transform transform, final Camera camera, final Material material) {
		material.getTexture().bind();
		
		setUniform("eyePosition", camera.getPosition());
		
		setUniform("transform", transform.getWorldMatrix());
		setUniform("transformProjected", transform.getWorldViewProjectionMatrix(camera));
		setUniform("baseColor", material.getColor());
		
		setUniform("ambientLight", ambientLight);
		
		setUniformf("specularIntensity", material.getSpecularIntensity());
		setUniformf("specularExponent", material.getSpecularExponent());
		
		setUniform("directionalLight", directionalLight);
		
		for (int i = 0; i < pointLights.length; i++) {
			setUniform("pointLights[" + i + "]", pointLights[i]);
		}
		
		for (int i = 0; i < spotLights.length; i++) {
			setUniform("spotLights[" + i + "]", spotLights[i]);
		}
	}
	
	public Vector3f getAmbientLight() {
		return ambientLight;
	}
	
	public void setAmbientLight(final Vector3f ambientLight) {
		this.ambientLight = ambientLight;
	}
	
	public void setDirectionalLight(final DirectionalLight directionalLight) {
		this.directionalLight = directionalLight;
	}
	
	public void setPointLights(final PointLight[] pointLights) {
		if (pointLights.length > MAX_POINT_LIGHTS) {
			System.err.println("Error: You passed in " + pointLights.length + "PointLights, which is too much.");
			new Exception().printStackTrace();
			System.exit(1);
		}
		
		this.pointLights = pointLights;
	}
	
	public void setSpotLights(final SpotLight[] spotLights) {
		if (spotLights.length > MAX_SPOT_LIGHTS) {
			System.err.println("Error: You passed in " + spotLights.length + "SpotLights, which is too much.");
			new Exception().printStackTrace();
			System.exit(1);
		}
		
		this.spotLights = spotLights;
	}
}
