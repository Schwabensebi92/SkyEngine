package com.own.sky.renderingengine.cameraengine;


import com.own.sky.coreengine.*;
import com.own.sky.coreengine.scenegraph.GameComponent;
import com.own.sky.inputengine.*;
import com.own.sky.renderingengine.concept.RenderingConcept;
import com.own.sky.renderingengine.graphics.projection.Projection;


public class Camera extends GameComponent {
	
	private Projection projection;
	
	public Camera(final Projection projection) {
		super(false, false, false);
		
		this.projection = projection;
	}
	
	public Projection getProjection() {
		return projection;
	}
	
	public void activate() {
		((CameraEngine) CoreObjectRegister.get(CoreObject.CAMERA_ENGINE)).activateCamera(this);
	}
	
	public void deactivate() {
		((CameraEngine) CoreObjectRegister.get(CoreObject.CAMERA_ENGINE)).deactivateCamera(this);
	}
	
	public boolean isActive() {
		return ((CameraEngine) CoreObjectRegister.get(CoreObject.CAMERA_ENGINE)).getActiveCamera().equals(this);
	}
	
	@Override
	public void input(final Mouse mouse, final Keyboard keyboard) {
	
	}
	
	@Override
	public void update() {
	
	}
	
	@Override
	public void render(final RenderingConcept renderingConcept) {
	
	}
}
