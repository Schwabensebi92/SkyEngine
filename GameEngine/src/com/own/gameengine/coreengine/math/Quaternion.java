package com.own.gameengine.coreengine.math;


public class Quaternion {

	private float x;
	private float y;
	private float z;
	private float w;

	public Quaternion(float x, float y, float z, float w) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}

	public Quaternion(Quaternion source) {
		this(source.x, source.y, source.z, source.w);
	}

	public Quaternion() {
		this(0.0f, 0.0f, 0.0f, 0.0f);
	}

	public float length() {
		return (float) Math.sqrt(x * x + y * y + z * z + w * w);
	}

	public Quaternion normalize() {
		float length = length();

		x /= length;
		y /= length;
		z /= length;
		w /= length;

		return this;
	}

	public Quaternion conjugate() {
		x *= -1;
		y *= -1;
		z *= -1;

		return this;
	}

	public Quaternion mul(Quaternion quaternion) {
		float newW = w * quaternion.w - x * quaternion.x - y * quaternion.y - z * quaternion.z;
		float newX = x * quaternion.w + w * quaternion.x + y * quaternion.z - z * quaternion.y;
		float newY = y * quaternion.w + w * quaternion.y + z * quaternion.x - x * quaternion.z;
		float newZ = z * quaternion.w + w * quaternion.z + x * quaternion.y - y * quaternion.x;

		x = newX;
		y = newY;
		z = newZ;
		w = newW;

		return this;
	}

	public Quaternion mul(Vector3f vector) {
		float newW = -x * vector.getX() - y * vector.getY() - z * vector.getZ();
		float newX = w * vector.getX() + y * vector.getZ() - z * vector.getY();
		float newY = w * vector.getY() + z * vector.getX() - x * vector.getZ();
		float newZ = w * vector.getZ() + x * vector.getY() - y * vector.getX();

		x = newX;
		y = newY;
		z = newZ;
		w = newW;

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

	public float getZ() {
		return z;
	}

	public void setZ(float z) {
		this.z = z;
	}

	public float getW() {
		return w;
	}

	public void setW(float w) {
		this.w = w;
	}
}
