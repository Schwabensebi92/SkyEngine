package com.own.gameengine.physicsengine.physics;


import java.util.ArrayList;


public class TimingEngine implements Timeable {
	
	private ArrayList<Timeable> timingObjects;
	
	public TimingEngine() {
		// TODO: Do some meaningful stuff
	}
	
	public void initialize() {
		timingObjects = new ArrayList<>();
	}
	
	public void cleanUp() {
	
	}
	
	@Override
	public void refresh() {
		for (Timeable timeable : timingObjects) {
			timeable.refresh();
		}
	}
	
	@Override
	public void start() {
		for (Timeable timeable : timingObjects) {
			timeable.start();
		}
	}
	
	@Override
	public void pause() {
		for (Timeable timeable : timingObjects) {
			timeable.pause();
		}
	}
	
	public void register(final Timeable timeable) {
		timingObjects.add(timeable);
	}
	
	public void unregister(final Timeable timeable) {
		timingObjects.remove(timeable);
	}
}
