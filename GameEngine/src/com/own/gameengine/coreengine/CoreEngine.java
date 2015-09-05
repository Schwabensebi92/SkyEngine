package com.own.gameengine.coreengine;


import com.own.gameengine.coreengine.input.*;
import com.own.gameengine.game.Game;
import com.own.gameengine.physicsengine.physics.TimingEngine;
import com.own.gameengine.renderingengine.RenderingEngine;
import com.own.gameengine.renderingengine.graphics.*;


public class CoreEngine {
	
	private TimingEngine	timingEngine;
	private RenderingEngine	renderingEngine;
	
	private final Game game;
	
	private Window		window;
	private Mouse		mouse;
	private Keyboard	keyboard;
	
	private boolean				isRunning;
	private final CoreTiming	coreTiming;
	private final FPSCounter	fpsCounter;
	
	public CoreEngine(final Game game) {
		this.game = game;
		isRunning = false;
		coreTiming = CoreTiming.instance(1.0 / game.getWindowSettings().getFrameRate().value());
		fpsCounter = new FPSCounter();
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
		try {
			initialize();
		} catch (final LWJGLLibraryException e) {
			e.printStackTrace();
			stop();
		}
		
		while (isRunning) {
			coreTiming.cycle();
			
			while (coreTiming.hasFrame()) {
				if (CoreFlagRegister.unsetIfSet(CoreFlag.CORE_ENGINE_STOP_REQUEST)) {
					stop();
				}
				
				coreTiming.frame();
				
				input();
				update();
				
				if (fpsCounter.hasNewFPSData()) {
					Debug.out(fpsCounter.getFPSAndReset() + " fps");
				}
				
				timingEngine.refresh();
			}
			
			if (coreTiming.didFrame()) {
				render();
				if (window.isCloseRequested()) {
					CoreFlagRegister.set(CoreFlag.CORE_ENGINE_STOP_REQUEST);
				}
				fpsCounter.increase();
			} else {
				Util.sleep(1);
			}
		}
		
		cleanUp();
	}
	
	private void initialize() throws LWJGLLibraryException {
		timingEngine = TimingEngine.instance();
		
		renderingEngine = new RenderingEngine();
		
		// ProgramContext.setIcon("icon.jpg"); TODO: Correct Implementation
		
		OpenGL.initializeLWJGL();
		
		window = new Window(game.getWindowSettings());
		window.initialize();
		
		OpenGL.initializeOpenGL();
		
		mouse = new Mouse();
		mouse.initialize(window.getWindowID());
		keyboard = new Keyboard();
		keyboard.initialize(window.getWindowID());
		
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
		window.render();
	}
	
	private void cleanUp() {
		fpsCounter.stop();
		game.cleanUp();
		
		mouse.cleanUp();
		keyboard.cleanUp();
	}
	
	public boolean isRunning() {
		return isRunning;
	}
}
