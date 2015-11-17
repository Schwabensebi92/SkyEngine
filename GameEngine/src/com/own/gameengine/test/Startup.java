package com.own.gameengine.test;


import com.own.gameengine.coreengine.CoreEngine;


public class Startup {
	
	public static void main(final String[] args) {
		final CoreEngine engine = new CoreEngine(new TestGame());
		engine.run();
	}
}
