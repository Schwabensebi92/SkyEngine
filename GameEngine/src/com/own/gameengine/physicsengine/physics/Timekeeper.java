package com.own.gameengine.physicsengine.physics;

public class Timekeeper implements Timeable {

	private double			startTime;
	private double			pauseStartTime;
	private double			totalPauseTime;
	private double			stopTime;
	private TimekeeperState	state;

	public Timekeeper() {
		this(true);
	}

	public Timekeeper(boolean register) {
		if (register)
			TimingEngine.instance().register(this);
		reset();
	}

	public void reset() {
		resetWithOffset(0.0);
	}

	public void resetWithOffset(double offset) {
		this.startTime = 0.0;
		this.pauseStartTime = 0.0;
		this.totalPauseTime = -offset;
		this.stopTime = 0.0;
		this.state = TimekeeperState.NOT_STARTED;
	}

	@Override
	public void refresh() {
		// double currentTime = Time.getTime();
		switch (state) {
			case NOT_STARTED: {
				break;
			}
			case RUNNING: {
				break;
			}
			case PAUSED: {
				break;
			}
			case STOPPED: {
				break;
			}
			default: {
				break;
			}
		}
	}

	@Override
	public void start() {
		double currentTime = Time.getTime();
		switch (state) {
			case NOT_STARTED: {
				startTime = currentTime;
				state = TimekeeperState.RUNNING;
				break;
			}
			case RUNNING: {
				reset();
				startTime = currentTime;
				state = TimekeeperState.RUNNING;
				break;
			}
			case PAUSED: {
				totalPauseTime += currentTime - pauseStartTime;
				state = TimekeeperState.RUNNING;
				break;
			}
			case STOPPED: {
				reset();
				startTime = currentTime;
				state = TimekeeperState.RUNNING;
				break;
			}
			default: {
				break;
			}
		}
	}

	@Override
	public void pause() {
		double currentTime = Time.getTime();
		switch (state) {
			case NOT_STARTED: {
				break;
			}
			case RUNNING: {
				pauseStartTime = currentTime;
				state = TimekeeperState.PAUSED;
				break;
			}
			case PAUSED: {
				break;
			}
			case STOPPED: {
				break;
			}
			default: {
				break;
			}
		}
	}

	public void stop() {
		double currentTime = Time.getTime();
		switch (state) {
			case NOT_STARTED: {
				break;
			}
			case RUNNING: {
				stopTime = currentTime;
				state = TimekeeperState.STOPPED;
				break;
			}
			case PAUSED: {
				totalPauseTime += currentTime - pauseStartTime;
				stopTime = currentTime;
				state = TimekeeperState.STOPPED;
				break;
			}
			case STOPPED: {
				break;
			}
			default: {
				break;
			}
		}
	}

	public double getPassedTime() {
		double currentTime = Time.getTime();
		switch (state) {
			case NOT_STARTED: {
				return 0.0;
			}
			case RUNNING: {
				return currentTime - startTime - totalPauseTime;
			}
			case PAUSED: {
				return pauseStartTime - startTime - totalPauseTime;
			}
			case STOPPED: {
				return stopTime - startTime - totalPauseTime;
			}
			default: {
				return 0.0;
			}
		}
	}

	@Override
	public String toString() {
		return "Timekeeper: Time[" + getPassedTime() + "], State[" + state.name() + "]";
	}
}
