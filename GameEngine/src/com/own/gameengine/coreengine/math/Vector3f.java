package com.own.gameengine.coreengine.math;

public class Vector3f {

	private float	x;
	private float	y;
	private float	z;

	public Vector3f(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public Vector3f(Vector3f source) {
		this(source.x, source.y, source.z);
	}

	public Vector3f() {
		this(0.0f, 0.0f, 0.0f);
	}

	public float length() {
		return (float) Math.sqrt(x * x + y * y + z * z);
	}

	public float dot(Vector3f vector) {
		return x * vector.x + y * vector.y + z * vector.z;
	}

	public Vector3f cross(Vector3f vector) {
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

	public Vector3f rotate(float degree, Vector3f axis) {
		float sinHalfAngle = (float) Math.sin(Math.toRadians(degree / 2));
		float cosHalfAngle = (float) Math.cos(Math.toRadians(degree / 2));

		float rX = axis.getX() * sinHalfAngle;
		float rY = axis.getY() * sinHalfAngle;
		float rZ = axis.getZ() * sinHalfAngle;
		float rW = cosHalfAngle;

		Quaternion rotation = new Quaternion(rX, rY, rZ, rW);
		Quaternion conjugate = new Quaternion(rotation).conjugate();

		rotation.mul(this).mul(conjugate);

		x = rotation.getX();
		y = rotation.getY();
		z = rotation.getZ();

		return this;
	}

	public Vector3f lerp(Vector3f destination, float lerpFactor) {
		return new Vector3f(destination).sub(this).mul(lerpFactor).add(this);
	}

	public Vector3f add(Vector3f vector) {
		x += vector.x;
		y += vector.y;
		z += vector.z;

		return this;
	}

	public Vector3f add(float amount) {
		x += amount;
		y += amount;
		z += amount;

		return this;
	}

	public Vector3f sub(Vector3f vector) {
		x -= vector.x;
		y -= vector.y;
		z -= vector.z;

		return this;
	}

	public Vector3f sub(float amount) {
		x -= amount;
		y -= amount;
		z -= amount;

		return this;
	}

	public Vector3f mul(Vector3f vector) {
		x *= vector.x;
		y *= vector.y;
		z *= vector.z;

		return this;
	}

	public Vector3f mul(float amount) {
		x *= amount;
		y *= amount;
		z *= amount;

		return this;
	}

	public Vector3f div(Vector3f vector) {
		x /= vector.x;
		y /= vector.y;
		z /= vector.z;

		return this;
	}

	public Vector3f div(float amount) {
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

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getZ() {
		return z;
	}

	public void setZ(float z) {
		this.z = z;
	}

	public String toString() {
		return "(" + x + "/" + y + "/" + z + ")";
	}

	@Override
	public boolean equals(Object other) {
		if (other == null)
			return false;
		if (other == this)
			return true;
		if (other instanceof Vector3f)
			return false;
		Vector3f otherVector = (Vector3f) other;
		return (x == otherVector.x) && (y == otherVector.y) && (z == otherVector.z);
	}

	@Override
	public int hashCode() {
		return (int) (x * 7 + y * 11 + z * 13);
	}
}
