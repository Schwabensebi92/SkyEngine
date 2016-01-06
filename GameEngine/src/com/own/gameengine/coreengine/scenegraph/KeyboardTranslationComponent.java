package com.own.gameengine.coreengine.scenegraph;


import com.own.gameengine.coreengine.*;
import com.own.gameengine.inputengine.*;
import com.own.gameengine.renderingengine.concept.RenderingConcept;
import com.own.gameengine.renderingengine.graphics.Transform;


public class KeyboardTranslationComponent extends GameComponent {
	
	private KeyboardKeys	forwardKey;
	private KeyboardKeys	backKey;
	private KeyboardKeys	rightKey;
	private KeyboardKeys	leftKey;
	private float			translationAmount;
	
	private float	forwardTranslationAmount;
	private float	rightTranslationAmount;
	
	public KeyboardTranslationComponent(final KeyboardKeys forwardKey, final KeyboardKeys backKey, final KeyboardKeys rightKey, final KeyboardKeys leftKey,
			final float translationAmount) {
		super(true, true, false);
		this.forwardKey = forwardKey;
		this.backKey = backKey;
		this.rightKey = rightKey;
		this.leftKey = leftKey;
		this.translationAmount = translationAmount;
	}
	
	@Override
	public void input(final Mouse mouse, final Keyboard keyboard) {
		if (keyboard.isKeyDown(forwardKey)) {
			forwardTranslationAmount += translationAmount;
		}
		if (keyboard.isKeyDown(backKey)) {
			forwardTranslationAmount -= translationAmount;
		}
		if (keyboard.isKeyDown(rightKey)) {
			rightTranslationAmount += translationAmount;
		}
		if (keyboard.isKeyDown(leftKey)) {
			rightTranslationAmount -= translationAmount;
		}
	}
	
	@Override
	public void update() {
		Transform t = getGameObject().getTransform();
		float timeDelta = (float) ((CoreTiming) CoreObjectRegister.get(CoreObject.CORE_TIMING)).getDelta();
		
		t.translate(t.getRotation().getLocalZAxis().mul(forwardTranslationAmount * timeDelta));
		t.translate(t.getRotation().getLocalXAxis().mul(rightTranslationAmount * timeDelta));
		
		forwardTranslationAmount = 0.0f;
		rightTranslationAmount = 0.0f;
	}
	
	@Override
	public void render(final RenderingConcept renderingConcept) {
	
	}
}