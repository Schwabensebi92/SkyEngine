package com.own.gameengine.coreengine;

import com.own.gameengine.coreengine.input.*;
import com.own.gameengine.game.Game;
import com.own.gameengine.physicsengine.physics.TimingEngine;
import com.own.gameengine.renderingengine.RenderingEngine;
import com.own.gameengine.renderingengine.graphics.OpenGL;

public class CoreEngine {

	private TimingEngine	timingEngine;
	private RenderingEngine	renderingEngine;

	private Game	game;

	private boolean			isRunning;
	private CoreTiming		coreTiming;
	private FPSCounter		fpsCounter;

	public CoreEngine(final Game game) {
		this.game = game;
		this.isRunning = false;
		this.coreTiming = CoreTiming.instance(1.0 / game.getDisplay().getFrameRate().getFrameRate());
		this.fpsCounter = new FPSCounter();
	}

	public void start() {
		if (isRunning)
			return;

		isRunning = true;
		run();
	}

	public void stop() {
		if (!isRunning)
			return;

		isRunning = false;
	}

	private void run() {
		initialize();

		while (isRunning) {
			coreTiming.cycle();

			while (coreTiming.hasFrame()) {
				if (CoreFlagRegister.unsetIfSet(CoreFlag.CORE_ENGINE_STOP_REQUEST))
					stop();

				coreTiming.frame();

				input();
				update();

				if (fpsCounter.hasNewFPSData())
					Debug.out(fpsCounter.getFPSAndReset() + " fps");

				timingEngine.refresh();
			}

			if (coreTiming.didFrame()) {
				render();
				if (OpenGL.isCloseRequested())
					CoreFlagRegister.set(CoreFlag.CORE_ENGINE_STOP_REQUEST);
				fpsCounter.increase();
			} else {
				Util.sleep(1);
			}
		}

		cleanUp();
	}

	private void initialize() {
		timingEngine = TimingEngine.instance();

		renderingEngine = new RenderingEngine();

		// ProgramContext.setIcon("icon.jpg"); TODO: Correct Implementation
		OpenGL.initDisplay(game.getDisplay());
		OpenGL.initGraphics();
		Mouse.initialize();
		Keyboard.initialize();

		game.initialize();

		renderingEngine.setMainCamera(game.getCamera());

		fpsCounter.start();

		coreTiming.init();
	}

	private void input() {
		game.input();
	}

	private void update() {
		game.update();
	}

	private void render() {
		OpenGL.clearScreen();
		renderingEngine.render(game.getSceneGraph());
		OpenGL.render();
	}

	private void cleanUp() {
		fpsCounter.stop();
		game.cleanUp();
		OpenGL.dispose();
		Mouse.cleanUp();
		Keyboard.cleanUp();
	}

	public boolean isRunning() {
		return isRunning;
	}
}
