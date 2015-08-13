package com.own.gameengine.physicsengine.physics;

import java.util.ArrayList;

public class TimingEngine implements Timeable {

	private static TimingEngine	instance;

	public static TimingEngine instance() {
		if (instance == null)
			instance = new TimingEngine();
		return instance;
	}

	private ArrayList<Timeable>	timingObjects;

	private TimingEngine() {
		timingObjects = new ArrayList<>();
	}

	@Override
	public void refresh() {
		for (Timeable timeable : timingObjects)
			timeable.refresh();
	}

	@Override
	public void start() {
		for (Timeable timeable : timingObjects)
			timeable.start();
	}

	@Override
	public void pause() {
		for (Timeable timeable : timingObjects)
			timeable.pause();
	}

	public void register(Timeable timeable) {
		timingObjects.add(timeable);
	}

	public void unregister(Timeable timeable) {
		timingObjects.remove(timeable);
	}
}
