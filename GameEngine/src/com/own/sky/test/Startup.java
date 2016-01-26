package com.own.sky.test;


import com.own.sky.coreengine.CoreEngine;


public class Startup {
	
	public static void main(final String[] args) {
		final CoreEngine engine = new CoreEngine(new TestGame());
		engine.run();
	}
}
