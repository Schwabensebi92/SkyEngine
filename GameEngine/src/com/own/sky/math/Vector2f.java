package com.own.sky.math;


public class Vector2f {
	
	private float	x;
	private float	y;
	
	public Vector2f(final float x, final float y) {
		this.x = x;
		this.y = y;
	}
	
	public Vector2f(final Vector2f source) {
		this(source.x, source.y);
	}
	
	public Vector2f() {
		this(0.0f, 0.0f);
	}
	
	public float length() {
		return (float) Math.sqrt(x * x + y * y);
	}
	
	public float dot(final Vector2f vector) {
		return x * vector.x + y * vector.y;
	}
	
	public float cross(final Vector2f vector) {
		return x * vector.getY() - y * vector.getX();
	}
	
	public Vector2f normalize() {
		float length = length();
		
		x /= length;
		y /= length;
		
		return this;
	}
	
	public Vector2f rotate(final float degree) {
		double radians = Math.toRadians(degree);
		double cos = Math.cos(radians);
		double sin = Math.sin(radians);
		
		float newX = (float) (x * cos - y * sin);
		float newY = (float) (x * sin + y * cos);
		
		x = newX;
		y = newY;
		
		return this;
	}
	
	public Vector2f lerp(final Vector2f destination, final float lerpFactor) {
		return new Vector2f(destination).sub(this).mul(lerpFactor).add(this);
	}
	
	public Vector2f add(final Vector2f vector) {
		x += vector.x;
		y += vector.y;
		
		return this;
	}
	
	public Vector2f add(final float amount) {
		x += amount;
		y += amount;
		
		return this;
	}
	
	public Vector2f sub(final Vector2f vector) {
		x -= vector.x;
		y -= vector.y;
		
		return this;
	}
	
	public Vector2f sub(final float amount) {
		x -= amount;
		y -= amount;
		
		return this;
	}
	
	public Vector2f mul(final Vector2f vector) {
		x *= vector.x;
		y *= vector.y;
		
		return this;
	}
	
	public Vector2f mul(final float amount) {
		x *= amount;
		y *= amount;
		
		return this;
	}
	
	public Vector2f div(final Vector2f vector) {
		x /= vector.x;
		y /= vector.y;
		
		return this;
	}
	
	public Vector2f div(final float amount) {
		x /= amount;
		y /= amount;
		
		return this;
	}
	
	public float getX() {
		return x;
	}
	
	public void setX(final float x) {
		this.x = x;
	}
	
	public float getY() {
		return y;
	}
	
	public void setY(final float y) {
		this.y = y;
	}
	
	@Override
	public String toString() {
		return "(x: " + x + "/y: " + y + ")";
	}
	
	@Override
	public boolean equals(final Object other) {
		if (other == null)
			return false;
		if (other == this)
			return true;
		if (!(other instanceof Vector2f))
			return false;
		Vector2f otherVector = (Vector2f) other;
		return (x == otherVector.x) && (y == otherVector.y);
	}
	
	@Override
	public int hashCode() {
		return (int) (x * 7 + y * 11);
	}
}
