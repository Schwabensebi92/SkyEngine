package com.own.gameengine.test;

import com.own.gameengine.coreengine.CoreEngine;

public class Startup {

	public static void main(String[] args) {
		CoreEngine engine = new CoreEngine(new TestGame());
		engine.start();
	}
}