package com.own.gameengine.coreengine.math;


public class Vector3f {
	
	private float	x;
	private float	y;
	private float	z;
	
	public Vector3f(final float x, final float y, final float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Vector3f(final Vector3f source) {
		this(source.x, source.y, source.z);
	}
	
	public Vector3f() {
		this(0.0f, 0.0f, 0.0f);
	}
	
	public float length() {
		return (float) Math.sqrt(x * x + y * y + z * z);
	}
	
	public float dot(final Vector3f vector) {
		return x * vector.x + y * vector.y + z * vector.z;
	}
	
	public Vector3f cross(final Vector3f vector) {
		float newX = y * vector.z - z * vector.y;
		float newY = z * vector.x - x * vector.z;
		float newZ = x * vector.y - y * vector.x;
		
		x = newX;
		y = newY;
		z = newZ;
		
		return this;
	}
	
	public Vector3f normalize() {
		float length = length();
		
		x /= length;
		y /= length;
		z /= length;
		
		return this;
	}
	
	public Vector3f rotate(final Quaternion rotation) {
		Quaternion conjugate = new Quaternion(rotation).conjugate();
		
		rotation.mul(this).mul(conjugate);
		
		x = rotation.getX();
		y = rotation.getY();
		z = rotation.getZ();
		
		return this;
	}
	
	public Vector3f lerp(final Vector3f destination, final float lerpFactor) {
		return new Vector3f(destination).sub(this).mul(lerpFactor).add(this);
	}
	
	public Vector3f add(final Vector3f vector) {
		x += vector.x;
		y += vector.y;
		z += vector.z;
		
		return this;
	}
	
	public Vector3f add(final float amount) {
		x += amount;
		y += amount;
		z += amount;
		
		return this;
	}
	
	public Vector3f sub(final Vector3f vector) {
		x -= vector.x;
		y -= vector.y;
		z -= vector.z;
		
		return this;
	}
	
	public Vector3f sub(final float amount) {
		x -= amount;
		y -= amount;
		z -= amount;
		
		return this;
	}
	
	public Vector3f mul(final Vector3f vector) {
		x *= vector.x;
		y *= vector.y;
		z *= vector.z;
		
		return this;
	}
	
	public Vector3f mul(final float amount) {
		x *= amount;
		y *= amount;
		z *= amount;
		
		return this;
	}
	
	public Vector3f div(final Vector3f vector) {
		x /= vector.x;
		y /= vector.y;
		z /= vector.z;
		
		return this;
	}
	
	public Vector3f div(final float amount) {
		x /= amount;
		y /= amount;
		z /= amount;
		
		return this;
	}
	
	public Vector2f xy() {
		return new Vector2f(x, y);
	}
	
	public Vector2f xz() {
		return new Vector2f(x, z);
	}
	
	public Vector2f yx() {
		return new Vector2f(y, x);
	}
	
	public Vector2f yz() {
		return new Vector2f(y, z);
	}
	
	public Vector2f zx() {
		return new Vector2f(z, x);
	}
	
	public Vector2f zy() {
		return new Vector2f(y, z);
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
	
	public float getZ() {
		return z;
	}
	
	public void setZ(final float z) {
		this.z = z;
	}
	
	@Override
	public String toString() {
		return "(" + x + "/" + y + "/" + z + ")";
	}
	
	@Override
	public boolean equals(final Object other) {
		if (other == null)
			return false;
		if (other == this)
			return true;
		if (!(other instanceof Vector3f))
			return false;
		Vector3f otherVector = (Vector3f) other;
		return (x == otherVector.x) && (y == otherVector.y) && (z == otherVector.z);
	}
	
	@Override
	public int hashCode() {
		return (int) (x * 7 + y * 11 + z * 13);
	}
}
