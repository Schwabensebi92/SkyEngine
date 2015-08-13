package com.own.gameengine.physicsengine.physics;

public class Timer implements Timeable {

	private double		duration;

	private double		startTime;
	private double		pauseStartTime;
	private double		totalPauseTime;
	private double		expireTime;
	private TimerState	state;

	public Timer(double duration) {
		this(duration, true);
	}

	public Timer(double duration, boolean register) {
		if (register)
			TimingEngine.instance().register(this);
		this.duration = duration;
		reset();
	}

	public void reset() {
		resetWithOffset(0.0);
	}

	public void resetWithOffset(double offset) {
		this.startTime = 0.0;
		this.pauseStartTime = 0.0;
		this.totalPauseTime = -offset;
		this.expireTime = 0.0;
		this.state = TimerState.NOT_STARTED;
	}

	@Override
	public void refresh() {
		// double currentTime = Time.getTime();
		switch (state) {
			case NOT_STARTED: {
				break;
			}
			case RUNNING: {
				boolean expired = hasExpired();
				if (expired)
					state = TimerState.EXPIRED;
				break;
			}
			case PAUSED: {
				boolean expired = hasExpired();
				if (expired)
					state = TimerState.EXPIRED;
				break;
			}
			case EXPIRED: {
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
				expireTime = startTime + duration;
				state = TimerState.RUNNING;
				break;
			}
			case RUNNING: {
				reset();
				start();
				break;
			}
			case PAUSED: {
				totalPauseTime += currentTime - pauseStartTime;
				expireTime = startTime + duration + totalPauseTime;
				state = TimerState.RUNNING;
				break;
			}
			case EXPIRED: {
				reset();
				start();
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
				state = TimerState.PAUSED;
				break;
			}
			case PAUSED: {
				break;
			}
			case EXPIRED: {
				break;
			}
			default: {
				break;
			}
		}
	}

	public double timeSincePause() {
		double currentTime = Time.getTime();
		switch (state) {
			case PAUSED: {
				return currentTime - pauseStartTime;
			}
			default: {
				return 0.0;
			}
		}
	}

	public boolean hasExpired() {
		double currentTime = Time.getTime();
		switch (state) {
			case NOT_STARTED: {
				return false;
			}
			case RUNNING: {
				return currentTime >= expireTime;
			}
			case PAUSED: {
				return currentTime - timeSincePause() >= expireTime;
			}
			case EXPIRED: {
				return true;
			}
			default: {
				return false;
			}
		}
	}

	public double getExpireTime() {
		// double currentTime = Time.getTime();
		switch (state) {
			case NOT_STARTED: {
				return 0.0;
			}
			case RUNNING: {
				return expireTime;
			}
			case PAUSED: {
				return expireTime + timeSincePause();
			}
			case EXPIRED: {
				return expireTime;
			}
			default: {
				return 0.0;
			}
		}
	}

	public double getRemainingTime() {
		double currentTime = Time.getTime();
		switch (state) {
			case NOT_STARTED: {
				return 0.0;
			}
			case RUNNING: {
				return expireTime - currentTime;
			}
			case PAUSED: {
				return expireTime + timeSincePause() - currentTime;
			}
			case EXPIRED: {
				return 0.0;
			}
			default: {
				return 0.0;
			}
		}
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	public double getDuration() {
		return duration;
	}

	@Override
	public String toString() {
		return "Timer:\tDuration[" + duration + " s],\tExpired[" + hasExpired() + "],\tExpireTime[" + getExpireTime()
				+ "],\tRemainingTime["
				+ getRemainingTime() + "],\tState[" + state.name() + "]";
	}
}
