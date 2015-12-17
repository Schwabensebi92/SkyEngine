package com.own.gameengine.coreengine;


import com.own.gameengine.game.Game;
import com.own.gameengine.inputengine.InputEngine;
import com.own.gameengine.physicsengine.physics.TimingEngine;
import com.own.gameengine.renderingengine.RenderingEngine;
import com.own.gameengine.renderingengine.graphics.*;


public class CoreEngine {
	
	private TimingEngine	timingEngine;
	private CameraEngine	cameraEngine;
	private RenderingEngine	renderingEngine;
	private InputEngine		inputEngine;
	
	private final Game game;
	
	private Window window;
	
	private boolean				isRunning;
	private CoreTiming			coreTiming;
	private final FPSCounter	fpsCounter;
	
	public CoreEngine(final Game game) {
		this.game = game;
		isRunning = false;
		coreTiming = null;
		fpsCounter = new FPSCounter();
	}
	
	public void run() {
		if (isRunning)
			return;
			
		isRunning = true;
		runScheduler();
	}
	
	public void stop() {
		if (!isRunning)
			return;
			
		isRunning = false;
	}
	
	private void runScheduler() {
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
		// Initialization order is very important
		// ProgramContext.setIcon("icon.jpg"); TODO: Correct Implementation
		
		// Initialize TimingEngine
		timingEngine = new TimingEngine();
		timingEngine.initialize();
		CoreObjectRegister.set(CoreObject.TIMING_ENGINE, timingEngine);
		
		// Initialize CameraEngine
		cameraEngine = new CameraEngine();
		cameraEngine.initialize();
		CoreObjectRegister.set(CoreObject.CAMERA_ENGINE, cameraEngine);
		
		// Initialize LWJGL
		OpenGL.initializeLWJGL();
		window = new Window(game.getWindowSettings());
		window.initialize();
		
		// Initialize OpenGL
		OpenGL.initializeOpenGL();
		
		// Initialize Game
		game.initialize();
		
		// Initialize RenderingEngine
		renderingEngine = new RenderingEngine();
		renderingEngine.initialize();
		CoreObjectRegister.set(CoreObject.RENDERING_ENGINE, renderingEngine);
		
		// Initialize InputEngine
		inputEngine = new InputEngine();
		inputEngine.initialize(window.getWindowID());
		
		// Initialize CoreEngine
		fpsCounter.start();
		coreTiming = new CoreTiming(1.0 / game.getWindowSettings().getFrameRate().value());
		coreTiming.initialize();
		CoreObjectRegister.set(CoreObject.CORE_TIMING, coreTiming);
	}
	
	private void input() {
		inputEngine.run(game.getSceneGraph());
	}
	
	private void update() {
		game.update();
	}
	
	private void render() {
		OpenGL.clearScreen();
		renderingEngine.run(game.getSceneGraph());
		window.refresh();
	}
	
	private void cleanUp() {
		// CleanUp CoreEngine
		fpsCounter.stop();
		
		// CleanUp InputEngine
		inputEngine.cleanUp();
		
		// CleanUp RenderingEngine
		renderingEngine.cleanUp();
		
		// CleanUp Game
		game.cleanUp();
		
		// CleanUp OpenGL
		OpenGL.cleanUpOpenGL();
		
		// CleanUp LWJGL
		window.dispose();
		OpenGL.cleanUpLWJGL();
		
		// CleanUp CameraEngine
		cameraEngine.cleanUp();
		
		// CleanUp TimingEngine
		timingEngine.cleanUp();
	}
	
	public boolean isRunning() {
		return isRunning;
	}
}
