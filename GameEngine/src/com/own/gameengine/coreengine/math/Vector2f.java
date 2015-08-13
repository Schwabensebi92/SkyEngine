package com.own.gameengine.coreengine.math;

public class Vector2f {

	private float	x;
	private float	y;

	public Vector2f(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public Vector2f(Vector2f source) {
		this(source.x, source.y);
	}

	public Vector2f() {
		this(0.0f, 0.0f);
	}

	public float length() {
		return (float) Math.sqrt(x * x + y * y);
	}

	public float dot(Vector2f vector) {
		return x * vector.x + y * vector.y;
	}

	public float cross(Vector2f vector) {
		return x * vector.getY() - y * vector.getX();
	}

	public Vector2f normalize() {
		float length = length();

		x /= length;
		y /= length;

		return this;
	}

	public Vector2f rotate(float degree) {
		double radians = Math.toRadians(degree);
		double cos = Math.cos(radians);
		double sin = Math.sin(radians);

		float newX = (float) (x * cos - y * sin);
		float newY = (float) (x * sin + y * cos);

		x = newX;
		y = newY;

		return this;
	}

	public Vector2f lerp(Vector2f destination, float lerpFactor) {
		return new Vector2f(destination).sub(this).mul(lerpFactor).add(this);
	}

	public Vector2f add(Vector2f vector) {
		x += vector.x;
		y += vector.y;

		return this;
	}

	public Vector2f add(float amount) {
		x += amount;
		y += amount;

		return this;
	}

	public Vector2f sub(Vector2f vector) {
		x -= vector.x;
		y -= vector.y;

		return this;
	}

	public Vector2f sub(float amount) {
		x -= amount;
		y -= amount;

		return this;
	}

	public Vector2f mul(Vector2f vector) {
		x *= vector.x;
		y *= vector.y;

		return this;
	}

	public Vector2f mul(float amount) {
		x *= amount;
		y *= amount;

		return this;
	}

	public Vector2f div(Vector2f vector) {
		x /= vector.x;
		y /= vector.y;

		return this;
	}

	public Vector2f div(float amount) {
		x /= amount;
		y /= amount;

		return this;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public String toString() {
		return "(" + x + "/" + y + ")";
	}

	@Override
	public boolean equals(Object other) {
		if (other == null)
			return false;
		if (other == this)
			return true;
		if (other instanceof Vector2f)
			return false;
		Vector2f otherVector = (Vector2f) other;
		return (x == otherVector.x) && (y == otherVector.y);
	}

	@Override
	public int hashCode() {
		return (int) (x * 7 + y * 11);
	}
}
